/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.log4j.Logger;

/**
 * A pair of Strings, a value and a scheme (representing a URI which gives a globally-unique context for the value); a set of
 * these objects represent an NCIP Enumerated Data Type (see the NCIP part 1).
 * These "Enumerated Data Types" are often referred to as "Schemes", a term which may also mean the Scheme's URI.
 * <p>The scheme is optional for uses where both parties to the exchange of information understand implicitly
 * the vocabulary from which the value is taken.</p>
 * <p>This implementation is intended to implement the type-safe enum pattern (see Joshua Bloch's Effective Java, ISBN 0-201-31005-8,
 * Item 21 "Replace enum constructs with classes", pp. 104-114).</p>
 * <p>Instances of this class are immutable.</p>
 * Note: This class maintains a static "registry" of unique instances to reduce the memory usage and speed comparison operations.
 * Clients are encouraged to use the {@link #find(String, String, Class)} method to retrieve instances from the registry rather than
 * constructing new ones. The find method will create a new instance if none is found in the registry.
 * The only difference between the two techniques is that the find method may throw an exception if the {@link SchemeValueBehavior} rule
 * for the underlying SchemeValuePair element class does not permit construction. (See {@link #getImmediateSVPSubclass(Class)} for the meaning of
 * 'underlying SchemeValuePair element' used here.)
 * For this reason <em>most</em> clients should use the find method - to support the deployment-time configuration of their application's behavior. The exception
 * to this recommendation is for Schemes where the behavior is {@link SchemeValueBehavior#ALLOW_ANY_VALUE_IN_KNOWN_SCHEMES} or {@link SchemeValueBehavior#ALLOW_ANY};
 * <em>and</em> where the retention of instances in the registry would have adverse impact upon memory usage.
 */
public abstract class SchemeValuePair {

    private static final Logger LOG = Logger.getLogger(SchemeValuePair.class);

    /** A registry of all configured instances of SchemeValuePair, used by the {@link #find(String, String, Class)} method. */
    private static final Map<Class<SchemeValuePair>, Map<String /*Scheme*/, Map<String /*Value*/, SchemeValuePair>>> SCHEME_REGISTRY = new HashMap<>();

    /** A registry of SchemeValuePair subclasses which allow being matched by scheme + value pairs where the scheme is null but the value matches the value in this Scheme. */
    private static final Map<String /* Class name including pkg */, Boolean> CLASSES_ALLOWING_NULL_SCHEME = new HashMap<>();

    /** A registry of aliases for Scheme URIs where the key is the alias and the value is the 'canonical' Scheme URI. */
    private static final Map<String, String> SCHEME_URI_ALIAS_MAP = new HashMap<>();

    /** The registry of {@link SchemeValueBehavior} for SchemeValuePair classes. */
    private static final Map<String /* Class name including pkg */, SchemeValueBehavior> BEHAVIOR_BY_CLASS_NAME_MAP = new HashMap<>();

    /**
     * Add the Schemes represented by the named classes to the list of those that allow the Scheme URI to be null.
     * <p>Note: This is <em>not necessarily</em> the "element" class, it can be a concrete SchemeValuePair subclass which contains the values for
     * all or part of an NCIP Enumerated Data Type. For example, Version1MediumType and WCLv1_0MediumType are <em>different</em> classes for this purpose,
     * despite both representing the same "element".</p>
     * @param classNames one or more full class name
     */
    public static void allowNullScheme(final String... classNames) {
        for (final String className : classNames) {
            CLASSES_ALLOWING_NULL_SCHEME.put(className, Boolean.TRUE);
        }
    }

    /**
     * Register the provided behavior for the provided (full) class name.
     * <p>Note: the class named by the className parameter must be the 'underlying SchemeValuePair element' class; (See {@link #getImmediateSVPSubclass(Class)} for the meaning of
     * 'underlying SchemeValuePair element' used here.)</p>
     *
     * @param className the full class name of the element class
     * @param behavior the {@link SchemeValueBehavior} for this class
     */
    public static void mapBehavior(final String className, final SchemeValueBehavior behavior) {
        synchronized (BEHAVIOR_BY_CLASS_NAME_MAP) {
            LOG.trace("Setting SchemeValuePair behavior for " + className + " to " + behavior.toString());
            BEHAVIOR_BY_CLASS_NAME_MAP.put(className, behavior);
        }
    }

    /**
     * Empty the registry of SchemeValuePair behaviors.
     * Note: This is intended only for use in unit tests.
     */
    public static void clearBehaviors() {
        synchronized (BEHAVIOR_BY_CLASS_NAME_MAP) {
            LOG.debug("Clearing SchemeValuePair behavior registry.");
            BEHAVIOR_BY_CLASS_NAME_MAP.clear();
        }
    }

    /**
     * Set the behavior for the provided SchemeValuePair elements to allow any Value.
     * @param classNames the SchemeValuePair elements
     */
    public static void allowAnyValue(final String... classNames) {
        for (final String className : classNames) {
            mapBehavior(className, SchemeValueBehavior.ALLOW_ANY);
        }
    }

    /**
     * Set the behavior for the provided SchemeValuePair elements to allow any Value in known Schemes.
     * @param classNames the SchemeValuePair elements
     */
    public static void allowAnyValueInKnownSchemes(final String... classNames) {
        for (final String className : classNames) {
            mapBehavior(className, SchemeValueBehavior.ALLOW_ANY_VALUE_IN_KNOWN_SCHEMES);
        }
    }

    /**
     * Load the SchemeValuePair classes, with the side-effect that their instances are registered.
     * @param classNames the SchemeValuePair classes to load
     * @throws ConfigurationException if the class is not found on the classpath
     * @throws ToolkitInternalException if the class is not correctly defined or its instances cannot be loaded via reflection
     */
    public static void loadSchemeValueClasses(final String... classNames) throws ConfigurationException, ToolkitInternalException {
        for (final String className : classNames) {
            try {
                final Method m = Class.forName(className).getDeclaredMethod("loadAll");
                m.invoke(null);
            } catch (ClassNotFoundException cnfe) {
                throw new ConfigurationException("Exception loading '" + className + "':", cnfe);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                throw new ToolkitInternalException("Exception loading '" + className + ":", e);
            }
        }
    }

    /**
     * Register the provided aliasURI for a provided canonicalURI.
     * <p>Note: 'Canonical' scheme URIs are the values used by the Toolkit when outputing the scheme, e.g. when marshalling the XML;
     * the aliases are input values that are recognized as matches when the Toolkit is finding the SchemeValuePair instance to represent
     * a given scheme and value, e.g. when unmarshalling XML.</p>
     * @param canonicalURI the canonical URI
     * @param aliasURI the alias URI
     */
    public static void setSchemeURIAlias(final String canonicalURI, final String aliasURI) {
        SCHEME_URI_ALIAS_MAP.put(aliasURI, canonicalURI);
    }

    /**
     * Register the provided URIs in the aliasMap
     * @param aliasMap a map of canonical URIs to an alias for them
     */
    public static void setSchemeURIAliases(final Map<String, String> aliasMap) {
        for (final Map.Entry<String, String> entry : aliasMap.entrySet()) {
            setSchemeURIAlias(entry.getKey(), entry.getValue());
        }
    }

    /**
     * Register the URI associated with the field name in the aliasMap.
     * @param classAndFieldName class + field name defining the canonical URIs
     * @param aliasURI the alias URI
     * @throws ConfigurationException if the class is not found on the classpath
     * @throws ToolkitInternalException if the class is not correctly defined or its instances cannot be loaded via reflection
     */
    public static void setSchemeURIAliasFromField(final String classAndFieldName, final String aliasURI) throws ConfigurationException, ToolkitInternalException {
        try {
            final int constantQualifierIndex = classAndFieldName.lastIndexOf('.');
            final String className = classAndFieldName.substring(0, constantQualifierIndex);
            final String fieldName = classAndFieldName.substring(constantQualifierIndex + 1);
            final Class<?> clazz = Class.forName(className);
            final Field canonicalURIField = ReflectionHelper.findField(clazz, fieldName);
            final String canonicalURI = (String) canonicalURIField.get(null);
            setSchemeURIAlias(canonicalURI, aliasURI);
        } catch (ClassNotFoundException cnfe) {
            throw new ConfigurationException("Exception registering Scheme URI alias '" + aliasURI + "' for '" + classAndFieldName + "':", cnfe);
        } catch (IllegalAccessException iae) {
            throw new ToolkitInternalException("Exception registering Scheme URI alias '" + aliasURI + "' for '" + classAndFieldName + "':", iae);
        }
    }

    /**
     * Register the URIs associated with the provided field names in the aliasMap
     * @param aliasMap a map of class + field names defining the canonical URIs, to an alias for them
     * @throws ConfigurationException if the class is not found on the classpath
     * @throws ToolkitInternalException if the class is not correctly defined or its instances cannot be loaded via reflection
     */
    public static void setSchemeURIAliasesFromFields(final Map<String, String> aliasMap) throws ConfigurationException, ToolkitInternalException {
        for (final Map.Entry<String, String> entry : aliasMap.entrySet()) {
            setSchemeURIAliasFromField(entry.getKey(), entry.getValue());
        }
    }

    /**
     * Return the canonical scheme for the provided scheme.
     * @param scheme the possibly non-canonical scheme (a URI)
     * @return the canonical scheme if different, otherwise the provided scheme
     */
    protected static String canonicalizeSchemeURI(final String scheme) {
        final String canonicalScheme;
        if (scheme != null) {
            final String newScheme = SCHEME_URI_ALIAS_MAP.get(scheme);
            if (newScheme != null) {
                canonicalScheme = newScheme;
            } else {
                canonicalScheme = scheme;
            }
        } else {
            canonicalScheme = null;
        }
        return canonicalScheme;
    }

    /**
     * The Scheme or URI of the Scheme/Value pair.
     */
    protected String scheme;
    /**
     * The Value of the Scheme/Value pair.
     */
    protected final String value;
    /**
     * The statically-initialized (at construction) hashCode.
     */
    protected int hashCode;

    /**
     * Construct a SchemeValuePair with a scheme and a value; add the instance to the {@link #SCHEME_REGISTRY} if it is not already there.
     * See {@link #matches(String, String)} for the precise meaning of "already there".
     * <p>Note: if the scheme is non-blank and the value is {@link SchemeValueBehavior#ANY_VALUES_FLAG}, the
     * SchemeValuePair class for the XML element that <em>this</em> SchemeValuePair class represents
     * will be set to {@link SchemeValueBehavior#ALLOW_ANY_VALUE_IN_KNOWN_SCHEMES}.</p>
     *
     * @param scheme the Scheme (a URI)
     * @param value  a Value within the Scheme
     */
    protected SchemeValuePair(final String scheme, final String value) {
        this.scheme = scheme;
        this.value = value;
        this.hashCode = calculateHashCode(this.scheme, this.value);
        if (StringUtils.isNotBlank(this.scheme) && StringUtils.isNotBlank(value) && value.compareTo(SchemeValueBehavior.ANY_VALUES_FLAG) == 0) {
            SchemeValuePair.mapBehavior(getImmediateSVPSubclass((Class<SchemeValuePair>) this.getClass()).getName(), SchemeValueBehavior.ALLOW_ANY_VALUE_IN_KNOWN_SCHEMES);
        }
        addIfAbsent(this);
    }

    /**
     * Construct a SchemeValuePair with a value but no scheme (the scheme is implicit between the two systems exchanging messages using this object);
     * add the instance to the {@link #SCHEME_REGISTRY} if it is not already there.
     * See {@link #matches(String, String)} for the precise meaning of "already there".
     *
     * @param value a Value in an implicit scheme
     */
    protected SchemeValuePair(final String value) {
        this.value = value;
        this.hashCode = calculateHashCode(this.scheme, this.value);
        addIfAbsent(this);
    }

    /**
     * Returns the scheme (a URI) for this object's value.
     *
     * @return the scheme
     */
    public String getScheme() {
        return scheme;
    }

    /**
     * Returns the value of this object.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Find an instance of SchemeValuePair for svpClass's "element" class in the {@link #SCHEME_REGISTRY} and return it; if none is found
     * create it, add it to the {@link #SCHEME_REGISTRY} and return it.
     * <p>Note: Should <em>only</em> be used by {@link SchemeValueBehavior#applyBehavior(String, String, Class)} as it creates an instance of
     * SchemeValuePair if a match is not found, without calling applyBehaivor. In other words, the determination that creation is permitted
     * must already be made before this is called.</p>
     *
     * @param scheme a String representing the NCIP Scheme URI.
     * @param value  a String representing the Value in the Scheme; must not be null
     * @param svpClass the {@link Class} for the subclass of SchemeValuePair
     * @return the (possibly new) instance
     * @throws ToolkitInternalException if creation through Reflection API fails
     */
    protected static SchemeValuePair addIfAbsent(final String scheme, final String value, final Class<? extends SchemeValuePair> svpClass) throws ToolkitInternalException {
        SchemeValuePair match;
        synchronized (SCHEME_REGISTRY) {
            // Re-check that this instance isn't in the registry and if not, add it.
            match = search(scheme, value, svpClass);
            if (match == null) {
                LOG.debug("Adding SchemeValuePair(\"" + scheme + "\", \"" + value + "\") to " + svpClass.getName());
                final Class<?>[] parmTypes = new Class[2];
                parmTypes[0] = String.class;
                parmTypes[1] = String.class;
                try {
                    final Constructor<? extends SchemeValuePair> ctor = svpClass.getConstructor(parmTypes);
                    final Object[] parmInstances = new Object[2];
                    parmInstances[0] = scheme;
                    parmInstances[1] = value;
                    // The SchemeValuePair constructors add this instance to the registry.
                    match = ctor.newInstance(parmInstances);
                } catch (ReflectiveOperationException e) {
                    throw new ToolkitInternalException("Unsupported Scheme/Value combination of " + scheme + ", " + value + " for " + getImmediateSVPSubclass(svpClass) + ".", e);
                }
            } else {
                LOG.debug("Skipping adding (" + match.getScheme() + ", " + match.getValue() + ")" + " because it's already been added.");
            }
        }
        return match;
    }

    /**
     * Add the provided instance if it is not already in the {@link #SCHEME_REGISTRY} registry.
     * An instance is "already" in the registry if {@link #search(String, String, Class)} returns an instance.
     * <p>Note: Intended to be called only by this class' constructors as it accepts an already-created instance of SchemeValuePair.</p>
     * <p>Must be called by all forms of this class' constructors.</p>
     *
     * @param svp an instance of SchemeValuePair
     */
    private static void addIfAbsent(final SchemeValuePair svp) {
        synchronized (SCHEME_REGISTRY) {
            // While synchronized on values list, re-check that this instance isn't in the list and if not, add it.
            if (search(svp.getScheme(), svp.getValue(), svp.getClass()) == null) {
                final Class<SchemeValuePair> elementClass = getImmediateSVPSubclass((Class<SchemeValuePair>) svp.getClass());
                final Map<String, Map<String /*Value*/, SchemeValuePair>> elementSchemes;
                if (SCHEME_REGISTRY.containsKey(elementClass)) {
                    elementSchemes = SCHEME_REGISTRY.get(elementClass);
                } else {
                    elementSchemes = new HashMap<>();
                    SCHEME_REGISTRY.put(elementClass, elementSchemes);
                }

                if (!elementSchemes.containsKey(svp.getScheme())) {
                    elementSchemes.put(svp.getScheme(), new HashMap<>());
                }
                elementSchemes.get(svp.getScheme()).put(svp.getValue(), svp);
            }
        }
    }

    /**
     * Find the instance that matches the scheme and value strings supplied; create it if not found provided the
     * associated XML element's {@link SchemeValueBehavior} rules permit creation of it.
     *
     * @param scheme a String representing the Scheme URI
     * @param value  a String representing the Value in the Scheme; must not be null
     * @param svpClass the {@link Class} for the subclass of SchemeValuePair
     * @return an instance that matches, whether it was pre-existing or created from the provided scheme, value and svpClass
     * @throws ConfigurationException if the instance is not found, and behavior rules for this element prohibit creating it
     * @throws ToolkitInternalException if the instance creation fails
     */
    protected static SchemeValuePair find(final String scheme, final String value, final Class<? extends SchemeValuePair> svpClass)
        throws ConfigurationException, ToolkitInternalException {
        SchemeValuePair match = search(scheme, value, svpClass);
        if (match == null) {
            SchemeValueBehavior behavior = BEHAVIOR_BY_CLASS_NAME_MAP.get(svpClass.getName());
            if (behavior == null) {
                behavior = SchemeValueBehavior.UNSET;
            }
            match = behavior.applyBehavior(scheme, value, svpClass);
        }
        return match;
    }

    /**
     * Search the {@link #SCHEME_REGISTRY} by scheme + value for the XML element represented by the svpClass.
     *
     * @param scheme a String representing the Scheme URI.
     * @param value  a String representing the Value in the Scheme; must not be null
     * @param svpClass the {@link Class} representing the XML element
     * @return an instance that matches, or null if none is found to match
     */
    static SchemeValuePair search(final String scheme, final String value, final Class<? extends SchemeValuePair> svpClass) {
        SchemeValuePair match = null;
        final Map<String, Map<String /*Value*/, SchemeValuePair>> elementSchemes = SCHEME_REGISTRY.get(getImmediateSVPSubclass(svpClass));
        if (elementSchemes != null) {
            if (scheme == null) {
                match = searchForMatchOnValueOnly(value, elementSchemes);
            } else {
                final String canonicalScheme = canonicalizeSchemeURI(scheme);
                if (value != null && value.length() > 0 && elementSchemes.containsKey(canonicalScheme)) {
                    match = elementSchemes.get(canonicalScheme).get(value);
                } else {
                    match = null;
                }
            }
        }
        return match;
    }

    /**
     * Search for a match to the provided value within a particular element's subset of the {@link #SCHEME_REGISTRY}.
     * <p>Note: Intended to be used when the sought-for scheme is null, this first checks for an entry in the {@code elementSchemes} map for a null key
     * (which is the list of values in the Scheme where the scheme URI is null) and if there is one it looks for a match on the value and if
     * there is one it returns that. If there was no match, then for every Scheme in the {@code elementSchemes} map that allows a null scheme URI,
     * it looks for a match on the value and if there is one it returns that.</p>
     * @param <SVP> a {@link SchemeValuePair} sub-class
     * @param value the value to search for
     * @param elementSchemes a subset of the registry containing schemes associated with a particular element, which may or may not allow the scheme to be null
     * @return a match or null if none found
     */
    private static <SVP extends SchemeValuePair> SVP searchForMatchOnValueOnly(final String value, final Map<String, Map<String /*Value*/, SVP>> elementSchemes) {
        SVP match = null;
        final Map<String /*Value*/, SVP> nullSchemeMap = elementSchemes.get(null);
        if (nullSchemeMap != null) {
            match = nullSchemeMap.get(value);
        }

        if (match == null) {
            for (final Map.Entry<String /*Scheme*/, Map<String /*Value*/, SVP>> entry : elementSchemes.entrySet()) {
                final Map<String /*Value*/, SVP> schemeMap = entry.getValue();
                if (!schemeMap.isEmpty()) {
                    final SchemeValuePair anySVP = schemeMap.entrySet().iterator().next().getValue();
                    if (areNullSchemesAllowed((Class<SchemeValuePair>) anySVP.getClass())) {
                        match = schemeMap.get(value);
                        if (match != null) {
                            break;
                        }
                    }
                }
            }
        }
        return match;
    }

    /**
     * Test two instances for equality. In addition to returning true if the passed-in Object <code>o</code> is the
     * same instance as <code>this</code>, this method considers two objects equal if, after translating their schemes
     * to canonical form, the two object's schemes are equal and the two object's values are equal.
     * <p>
     * Note: Sub-classes of SchemeValuePair that add comparable attributes (e.g. CurrencyCode) must override
     * the equals method, call their superclass's equals, and then (if the objects are equal) compare the
     * added attributes.
     */
    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        }
        if (!(o instanceof SchemeValuePair)) {
            return false;
        }

        final SchemeValuePair svpO = (SchemeValuePair) o;
        if (!this.isComparableSVPSubclass(svpO)) {
            return false;
        }

        return matches(svpO.getScheme(), svpO.getValue());

    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    /**
     * Calculate the hashCode from the provided scheme and value parameters.
     * <p>Note: Intended to be called by constructors.</p>
     * @param scheme the scheme
     * @param value the value
     * @return the hash code
     */
    protected static int calculateHashCode(final String scheme, final String value) {
        // See https://stackoverflow.com/a/18066516 for an explanation of this approach
        return Objects.hash(scheme, value != null ? value.toLowerCase() : null);
    }

    /**
     * Subclasses with additional properties (e.g. {@link CurrencyCode}) should call this at the end of their constructors, passing the value for each additional property.
     * @param object the 'this' object to which the addition will be added
     * @param additionalFields the additional properties that contribute to the hashing function
     */
    protected static void addToHashCode(final SchemeValuePair object, final Object... additionalFields) {
        object.hashCode = Objects.hash(object.scheme, object.value, additionalFields);
    }

    /**
     * Returns the immediate subclass of SchemeValuePair; this is the class from the {@link org.oclc.circill.toolkit.service.base}
     * package which represents an element in the XML Schema. For example {@code MediumType}, {@code Version1MediumType}, {@code WCLv1_1MediumType}
     * all 'represent' the XML element {@code MediumType}, so a call to this method for any of those classes wold return MediumType.class.
     *
     * @param <SVP> the {@link SchemeValuePair} type
     * @param svpClass a subclass of {@link SchemeValuePair}
     * @return the subclass of {@link SchemeValuePair} that represents the XML Schema element
     */
    protected static <SVP extends SchemeValuePair> Class<SVP> getImmediateSVPSubclass(final Class<SVP> svpClass) {
        Class<SVP> immediateSubclass = svpClass;
        while (!immediateSubclass.getSuperclass().equals(SchemeValuePair.class)) {
            immediateSubclass = (Class<SVP>) immediateSubclass.getSuperclass();
        }
        return immediateSubclass;
    }

    /**
     * Return true if the two objects subclass the same "immediate child class" of SchemeValuePair
     *
     * @param o the other object
     * @return whether the two objects subclass the same "immediate child class" of SchemeValuePair
     */
    public boolean isComparableSVPSubclass(final SchemeValuePair o) {
        if (!o.getClass().equals(this.getClass())) {
            final Class<SchemeValuePair> oImmediateSubClass = getImmediateSVPSubclass((Class<SchemeValuePair>) o.getClass());
            final Class<SchemeValuePair> thisImmediateSubClass = getImmediateSVPSubclass((Class<SchemeValuePair>) this.getClass());
            if (!oImmediateSubClass.equals(thisImmediateSubClass)) {
                return false;
            }
        }
        return true;

    }

    /**
     * Determine whether the provided {@link SchemeValuePair} scheme and value match
     * the scheme and value fields of this object.
     * @param svp -
     * @return -
     */
    public boolean matches(final SchemeValuePair svp) {
        return matches(svp.getScheme(), svp.getValue());
    }

    /**
     * Determine if the provided scheme matches this object's {@link #scheme},
     * and this provided value matches this object's {@link #value}.
     * <p>Note: this method defines "match" as the case where this.value equals the value parameter and
     * (after both schemes are translated to their canonical form) either this.scheme equals the scheme parameter
     * or either scheme is null and the 'element' class allows null.</p>
     * <p>Note: If value is null and this.value is null, this will return true.</p>
     *
     * @param scheme the Scheme URI
     * @param value the enumerated value within the Scheme
     * @return true if the scheme and value match this object's scheme and value
     */
    public boolean matches(final String scheme, final String value) {

        final boolean thisClassAllowsNullScheme = areNullSchemesAllowed();

        if (this.getScheme() != null) {
            return compareSchemeAndValue(scheme, value, thisClassAllowsNullScheme);
        } else { // this.scheme == null
            return compareWhenThisSchemeIsNull(scheme, value, thisClassAllowsNullScheme);
        }
    }

    /**
     * Compare the provided scheme and value to this instance's scheme and value.
     * @param scheme a scheme
     * @param value a value
     * @param thisClassAllowsNullScheme whether this class allows the scheme to be null (i.e. is optional)
     * @return true if the scheme and value match
     */
    private boolean compareSchemeAndValue(final String scheme, final String value, final boolean thisClassAllowsNullScheme) {
        final boolean matched;
        final String thisSchemeCanonical = canonicalizeSchemeURI(this.getScheme());
        if (scheme != null) {
            final String svpOSchemeCanonical = canonicalizeSchemeURI(scheme);
            if (thisSchemeCanonical != null && thisSchemeCanonical.compareToIgnoreCase(svpOSchemeCanonical) == 0) {
                matched = compareValue(value);
            } else {
                matched = false; // this.scheme != o.scheme
            }
        } else if (thisClassAllowsNullScheme) {
            matched = compareValue(value);
        } else {
            matched = false; // this.scheme != null && o.scheme == null
        }
        return matched;
    }

    /**
     * Compare the provided value to this instance's value and whether this class allows the scheme to be null.
     * @param scheme a scheme
     * @param value a value
     * @param thisClassAllowsNullScheme whether this class allows the scheme to be null (i.e. is optional)
     * @return true if the values match and this class allows the scheme to be null.
     */
    private boolean compareWhenThisSchemeIsNull(final String scheme, final String value, final boolean thisClassAllowsNullScheme) {
        if (scheme != null) {
            if (thisClassAllowsNullScheme) {
                return this.compareValue(value);
            } else {
                return false; // this.scheme == null && o.scheme != null
            }
        } else { // this.scheme == null && o.scheme == null
            return this.compareValue(value);
        }
    }

    /**
     * Compare this instance's {@link #value} to the provided value.
     *
     * <p>Note: Intended to be used by {@link #matches(String, String)}.</p>
     * @param value the value to compare
     * @return whether or not the value matches this object's value
     */
    @SuppressWarnings({ "checkstyle:returncount", "checkstyle:simplifybooleanreturn", "squid:S1126" })
    protected boolean compareValue(final String value) {
        if (this.getValue() != null) {
            if (value != null) {
                if (this.getValue().compareToIgnoreCase(value) == 0) {
                    return true;
                } else {
                    return false; // this.value != o.value
                }
            } else {
                return false; // this.value != null && o.value == null
            }
        } else {
            if (value != null) {
                return false; // this.value == null && o.value != null
            } else {
                return true; // this.value == null && o.value == null
            }
        }
    }

    /**
     * Returns true if the class parameter, or the element it represents, is configured to allow null values for the Scheme URI.
     * See {@link #getImmediateSVPSubclass(Class)} (Class)} for the meaning of 'element' used here.
     *
     * @param svpClass the SchemeValuePair subclass
     * @return true if the class is configured to allow null values for the Scheme URI
     */
    private static boolean areNullSchemesAllowed(final Class<SchemeValuePair> svpClass) {
        if (CLASSES_ALLOWING_NULL_SCHEME.containsKey(svpClass.getName())) {
            return true;
        }
        final Class<?> elementClass = getImmediateSVPSubclass(svpClass);
        return CLASSES_ALLOWING_NULL_SCHEME.containsKey(elementClass.getName());
    }

    /**
     * Returns true if the class of this instance is configured to allow null values for the Scheme URI.
     * @return true if the class is configured to allow null values for the Scheme URI
     */
    public boolean areNullSchemesAllowed() {
        return areNullSchemesAllowed((Class<SchemeValuePair>) this.getClass());
    }

    /**
     * Construct an {@link Iterator} over all SchemeValuePair instances for provided subclass of SchemeValuePair.
     * <p>Note: This includes instances with any Scheme URI, i.e. it includes all instances presently known to the Toolkit
     * that were defined for the same 'element' of the NCIP XML schema. For the meaning of 'element' here see {@link #getImmediateSVPSubclass(Class)} (Class)}.</p>
     *
     * @param <SVP> the {@link SchemeValuePair} type
     * @param svpClass the SchemeValuePair class
     * @return an {@link Iterator} over all SchemeValuePair instances for the XML element associated with the svpClass
     */
    protected static <SVP extends SchemeValuePair> Iterator<SVP> getIterator(final Class<SVP> svpClass) {
        final Iterator<SVP> iterator;
        final Map<String /*Scheme*/, Map<String /*Value*/, SchemeValuePair>> elementSchemes = SCHEME_REGISTRY.get(getImmediateSVPSubclass(svpClass));
        if (elementSchemes != null) {
            final List<SchemeValuePair> svpList = new ArrayList<>();
            for (final Map.Entry<String /*Scheme*/, Map<String /*Value*/, SchemeValuePair>> elementSchemesEntry : elementSchemes.entrySet()) {
                elementSchemesEntry.getValue().forEach((key, value1) -> svpList.add(value1));
            }
            iterator = (Iterator<SVP>) svpList.iterator();
        } else {
            iterator = Collections.emptyIterator();
        }
        return iterator;
    }

    /**
     * Write contents of {@link #SCHEME_REGISTRY} to the logger at trace level.
     * @param logger the logger
     */
    protected static void dumpRegistry(final Logger logger) {
        synchronized (SCHEME_REGISTRY) {
            SCHEME_REGISTRY.forEach((svpClass, schemeMap) -> {
                final String className = svpClass.getName();
                logger.trace("For class '" + className + "':");
                schemeMap.forEach((scheme, valueMap) -> {
                    logger.trace("\\tFor '" + scheme + "':");
                    valueMap.forEach(
                        (value, svpImplementationClass) -> logger.trace("\\t\\tValue '" + value + "' represented by class " + svpImplementationClass.getClass().getName()));
                });
            });
        }
    }

    /**
     * Write contents of {@link #CLASSES_ALLOWING_NULL_SCHEME} to the logger at trace level.
     * @param logger the logger
     */
    protected static void dumpClassesAllowingNullScheme(final Logger logger) {
        synchronized (CLASSES_ALLOWING_NULL_SCHEME) {
            CLASSES_ALLOWING_NULL_SCHEME
                .forEach((svpClassName, allows) -> logger.trace(svpClassName + (Boolean.TRUE.equals(allows) ? " allows " : " doesn't allow ") + " null scheme."));
        }
    }

    /**
     * Write contents of {@link #SCHEME_URI_ALIAS_MAP} to the logger at trace level.
     * @param logger the logger
     */
    protected static void dumpUriAliasMap(final Logger logger) {
        synchronized (SCHEME_URI_ALIAS_MAP) {
            SCHEME_URI_ALIAS_MAP.forEach((canonicalUri, aliasUri) -> logger.trace(aliasUri + " is an alias for " + canonicalUri));
        }
    }

    /**
     * Write contents of {@link #BEHAVIOR_BY_CLASS_NAME_MAP} to the logger at trace level.
     * @param logger the logger
     */
    protected static void dumpBehavior(final Logger logger) {
        synchronized (BEHAVIOR_BY_CLASS_NAME_MAP) {
            BEHAVIOR_BY_CLASS_NAME_MAP.forEach((svpClassName, behavior) -> logger.trace(svpClassName + " is configured with " + behavior.toString() + " behavior."));
        }
    }

    /**
     * Dump the static configuration: the SVP registry, the URI alias map, the classes allowing null schemes and the behavior.
     * @param logger the logger to write the configuration to
     */
    protected static void dumpConfiguration(final Logger logger) {
        dumpRegistry(logger);
        dumpUriAliasMap(logger);
        dumpClassesAllowingNullScheme(logger);
        dumpBehavior(logger);
    }

    /**
     * Generic toString() implementation.
     *
     * @return String
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
