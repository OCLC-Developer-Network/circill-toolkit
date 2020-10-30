package org.oclc.circill.toolkit.service.base;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.apache.log4j.Logger;

/**
 * Base class for testing non-SchemeValuePair beans.
 */
public class BaseTestNonSVPBeans {
    private static final Logger LOG = Logger.getLogger(BaseTestNonSVPBeans.class);

    public <T> void testExcludedProperties(final Class<T> beanClass, final List<PropertyInfo<?>> propertyInfos)
        throws InvocationTargetException, ToolkitException, InstantiationException, IllegalAccessException, TestNonSVPBeansException, NoSuchMethodException {

        for (final PropertyInfo<?> propertyInfo : propertyInfos) {
            LOG.debug("Testing " + beanClass.getSimpleName() + "." + propertyInfo.name);
            assertThat(beanClass.getSimpleName() + ".get" + propertyInfo.name + "() does not return what was passed to set" + propertyInfo.name + "().",
                hasValidGetterAndSetterForProperty(beanClass, propertyInfo));
            assertThat(beanClass.getSimpleName() + "'s hash code is not affected by the " + propertyInfo.name + " property.",
                hashCodeIsAffectedByProperty(beanClass, propertyInfo));
            assertThat(beanClass.getSimpleName() + " equals is not affected by the " + propertyInfo.name + " property.", propertyComparedDuringEquals(beanClass, propertyInfo));
            assertThat(beanClass.getSimpleName() + " equals does not handle the " + propertyInfo.name + " property being null.",
                nullPropertyHandledForEquals(beanClass, propertyInfo));
        }

    }

    public <P, T> boolean hasValidGetterAndSetterForProperty(final Class<T> beanClass, final PropertyInfo<P> propertyInfo)
        throws IllegalAccessException, InstantiationException, InvocationTargetException, ToolkitException, NoSuchMethodException {

        boolean result = true;
        final boolean propertyIsACollection = ReflectionHelper.isFieldACollection(beanClass, propertyInfo.name);
        if (propertyIsACollection) {
            result = testCollectionProperty(beanClass, propertyInfo);
        } else {
            result = testNonCollectionProperty(beanClass, propertyInfo);
        }
        return result;
    }

    @SuppressWarnings("ReuseOfLocalVariable")
    private <P, T> boolean testNonCollectionProperty(final Class<T> beanClass, final PropertyInfo<P> propertyInfo)
        throws NoSuchMethodException, ToolkitInternalException, IllegalAccessException, InvocationTargetException, InstantiationException {
        boolean result = true;
        final P testValue = propertyInfo.generator.generate();

        T bean = beanClass.getDeclaredConstructor().newInstance();
        ReflectionHelper.setField(bean, testValue, propertyInfo.name);
        final P retrievedValue = (P) ReflectionHelper.getSimpleField(bean, propertyInfo.name);
        if (!testValue.equals(retrievedValue)) {
            LOG.error(
                "The get" + propertyInfo.name + " method of " + beanClass.getSimpleName() + " does not return the simple object passed to the set" + propertyInfo.name
                    + " method.");
            result = false;
        }

        bean = beanClass.getDeclaredConstructor().newInstance();
        final P unsetFieldValue = (P) ReflectionHelper.getSimpleField(bean, propertyInfo.name);
        if (unsetFieldValue != null) {
            LOG.error("The get" + propertyInfo.name + " method of " + beanClass.getSimpleName() + " does not return null when set" + propertyInfo.name
                + " method has been called with null.");
            result = false;
        }
        return result;
    }

    @SuppressWarnings("ReuseOfLocalVariable")
    private <P, T> boolean testCollectionProperty(final Class<T> beanClass, final PropertyInfo<P> propertyInfo)
        throws ToolkitInternalException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        boolean result = true;
        T bean = beanClass.getDeclaredConstructor().newInstance();
        final P testValue = propertyInfo.generator.generate();
        final P testValue2 = propertyInfo.generator.generate();
        final P testValue3 = propertyInfo.generator.generate();

        final List<P> testList = new ArrayList<>();
        testList.add(testValue);
        ReflectionHelper.setField(bean, testList, propertyInfo.name);
        final List<P> retrievedList = (List<P>) ReflectionHelper.getCollectionField(bean, propertyInfo.name);
        if (!testList.equals(retrievedList)) {
            LOG.error(
                "The get" + propertyInfo.name + " method of " + beanClass.getSimpleName() + " does not return the list passed to the set" + propertyInfo.name + " method.");
            result = false;
        }

        bean = beanClass.getDeclaredConstructor().newInstance();
        final List<P> unsetFieldList = (List<P>) ReflectionHelper.getCollectionField(bean, propertyInfo.name);
        if (!(unsetFieldList != null && unsetFieldList.isEmpty())) {
            LOG.error("The get" + propertyInfo.name + " method of " + beanClass.getSimpleName() + " does not return an empty list when set" + propertyInfo.name
                + " method has not been called.");
            result = false;
        }

        if (propertyInfo.repeatability == Repeatability.BOTH) {
            testRepeatabilityBoth(beanClass, propertyInfo);
        }

        bean = beanClass.getDeclaredConstructor().newInstance();
        ReflectionHelper.setFieldNull(bean, List.class, propertyInfo.name);
        P setToNullFieldValue = (P) ReflectionHelper.getCollectionField(bean, propertyInfo.name);
        if (setToNullFieldValue != null) {
            LOG.error("The get" + propertyInfo.name + " method of " + beanClass.getSimpleName() + " should return null when set" + propertyInfo.name
                + " method has been called with null.");
            result = false;
        }

        bean = beanClass.getDeclaredConstructor().newInstance();
        ReflectionHelper.setFieldNull(bean, List.class, propertyInfo.name);
        setToNullFieldValue = (P) ReflectionHelper.getIndexedField(bean, propertyInfo.name, 0);
        if (setToNullFieldValue != null) {
            LOG.error("The get" + propertyInfo.name + "(0) method of " + beanClass.getSimpleName() + " should return null when set" + propertyInfo.name
                + " method has been called with null.");
            result = false;
        }

        bean = beanClass.getDeclaredConstructor().newInstance();
        final P value = (P) ReflectionHelper.getIndexedField(bean, propertyInfo.name, 0);
        assertNull("The get" + propertyInfo.name + "(0) method of " + beanClass.getSimpleName() + " should return null when the list is empty.", value);

        bean = beanClass.getDeclaredConstructor().newInstance();
        List<P> listOfOne = new ArrayList<>();
        listOfOne.add(testValue);
        ReflectionHelper.setField(bean, listOfOne, propertyInfo.name);
        try {
            ReflectionHelper.getIndexedField(bean, propertyInfo.name, 0);
        } catch (ToolkitInternalException e) {
            LOG.error("The get" + propertyInfo.name + "(0) method of " + beanClass.getSimpleName()
                + " threw an exception when the property had been set with a list of one object, and that object was at index 0.", e);
            result = false;
        }

        bean = beanClass.getDeclaredConstructor().newInstance();
        listOfOne = new ArrayList<>();
        listOfOne.add(testValue);
        ReflectionHelper.setField(bean, listOfOne, propertyInfo.name);
        boolean expectedExceptionNotCaught = true;
        try {
            ReflectionHelper.getIndexedField(bean, propertyInfo.name, 1);
        } catch (ToolkitInternalException e) {
            expectedExceptionNotCaught = false;
        }
        if (expectedExceptionNotCaught) {
            LOG.error("The get" + propertyInfo.name + "(1) method of " + beanClass.getSimpleName()
                + " does not throw an exception when the list has only one object, and that object is at index 0.");
            result = false;
        }

        bean = beanClass.getDeclaredConstructor().newInstance();
        expectedExceptionNotCaught = true;
        try {
            ReflectionHelper.setIndexedField(bean, propertyInfo.name, 1, testValue);
        } catch (ToolkitInternalException e) {
            expectedExceptionNotCaught = false;
        }
        if (expectedExceptionNotCaught) {
            LOG.error("The set" + propertyInfo.name + "(1) method of " + beanClass.getSimpleName()
                + " does not throw an exception when the list is empty and an object is inserted at index 1.");
            result = false;
        }

        bean = beanClass.getDeclaredConstructor().newInstance();
        listOfOne = new ArrayList<>();
        listOfOne.add(testValue);
        ReflectionHelper.setField(bean, listOfOne, propertyInfo.name);
        try {
            final P retrievedValue = (P) ReflectionHelper.getIndexedField(bean, propertyInfo.name, 0);
            assertSame("The get" + propertyInfo.name + "(0) method of " + beanClass.getSimpleName() + " did not return the same object as was set at that index.", testValue,
                retrievedValue);
        } catch (ToolkitInternalException e) {
            LOG.error("The get" + propertyInfo.name + "(0) method of " + beanClass.getSimpleName()
                + " threw an exception when the list had one object, and that object was at index 0.");
            result = false;
        }

        bean = beanClass.getDeclaredConstructor().newInstance();
        listOfOne = new ArrayList<>();
        listOfOne.add(testValue);
        listOfOne.add(testValue2);
        ReflectionHelper.setField(bean, listOfOne, propertyInfo.name);
        try {
            final P retrievedValue = (P) ReflectionHelper.getIndexedField(bean, propertyInfo.name, 0);
            assertSame("The get" + propertyInfo.name + "(0) method of " + beanClass.getSimpleName() + " did not return the same object as was set at that index.", testValue,
                retrievedValue);
            final P retrievedValue2 = (P) ReflectionHelper.getIndexedField(bean, propertyInfo.name, 1);
            assertSame("The get" + propertyInfo.name + "(1) method of " + beanClass.getSimpleName() + " did not return the same object as was set at that index.", testValue2,
                retrievedValue2);
        } catch (ToolkitInternalException e) {
            LOG.error("The get" + propertyInfo.name + "(0) method of " + beanClass.getSimpleName()
                + " threw an exception when the list had one object, and that object was at index 0.");
            result = false;
        }
        return result;
    }

    private <P, T> boolean testRepeatabilityBoth(final Class<T> beanClass, final PropertyInfo<P> propertyInfo)
        throws ToolkitInternalException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        boolean result = true;
        T bean = beanClass.getDeclaredConstructor().newInstance();
        final P testValue = propertyInfo.generator.generate();
        final P testValue2 = propertyInfo.generator.generate();
        final P testValue3 = propertyInfo.generator.generate();
        bean = beanClass.getDeclaredConstructor().newInstance();
        P returnedFieldValue = (P) ReflectionHelper.getSimpleField(bean, propertyInfo.name);
        if (returnedFieldValue != null) {
            LOG.error("The simple get" + propertyInfo.name + " method of " + beanClass.getSimpleName() + " does not return null if the " + propertyInfo.name
                + " is uninitialized (i.e. is an empty list).");
            result = false;
        }

        bean = beanClass.getDeclaredConstructor().newInstance();
        List<P> testList = new ArrayList<>();
        testList = new ArrayList<>();
        testList.add(testValue);
        testList.add(testValue2);
        ReflectionHelper.setField(bean, testList, propertyInfo.name);
        returnedFieldValue = (P) ReflectionHelper.getSimpleField(bean, propertyInfo.name);
        if (!(returnedFieldValue.equals(testValue2))) {
            LOG.error("The simple get" + propertyInfo.name + " method of " + beanClass.getSimpleName()
                + " does not return the last element added to a list that was then passed to the set" + propertyInfo.name + "s method.");
            result = false;
        }

        ReflectionHelper.setField(bean, testValue3, propertyInfo.name);
        final List<P> retrievedList = (List<P>) ReflectionHelper.getCollectionField(bean, propertyInfo.name);
        if (!(retrievedList.size() == 1 && retrievedList.get(0).equals(testValue3))) {
            LOG.error(
                "The get" + propertyInfo.name + " method of " + beanClass.getSimpleName() + " does not return a list with a single entry when set" + propertyInfo.name
                    + " method has been called with a simple object.");
            result = false;
        }

        bean = beanClass.getDeclaredConstructor().newInstance();
        ReflectionHelper.setFieldNull(bean, testValue.getClass(), propertyInfo.name);
        final P setToNullFieldValue = (P) ReflectionHelper.getSimpleField(bean, propertyInfo.name);
        if (setToNullFieldValue != null) {
            LOG.error("The simple get" + propertyInfo.name + " method of " + beanClass.getSimpleName() + " does not return null when set" + propertyInfo.name
                + " method has been called with null.");
            result = false;
        }

        bean = beanClass.getDeclaredConstructor().newInstance();
        ReflectionHelper.setFieldNull(bean, List.class, propertyInfo.name);
        ReflectionHelper.setField(bean, testValue, propertyInfo.name);
        returnedFieldValue = (P) ReflectionHelper.getSimpleField(bean, propertyInfo.name);
        if (!(returnedFieldValue.equals(testValue))) {
            LOG.error(
                "The simple get" + propertyInfo.name + " method of " + beanClass.getSimpleName() + " does not return the value set via set" + propertyInfo.name
                    + " method if the list is first set to null.");
            result = false;
        }
        final List<P> returnedList = (List<P>) ReflectionHelper.getCollectionField(bean, propertyInfo.name);
        if (returnedList.size() != 1 || !returnedList.get(0).equals(testValue)) {
            LOG.error(
                "The get" + propertyInfo.name + "s method of " + beanClass.getSimpleName() + " does not return a list with the single value set via set" + propertyInfo.name
                    + " method if the list is first set to null.");
            result = false;
        }
        return result;
    }

    public <P, T> boolean hashCodeIsAffectedByProperty(final Class<T> beanClass, final PropertyInfo<P> propertyInfo)
        throws TestNonSVPBeansException, InvocationTargetException, ToolkitException, IllegalAccessException, InstantiationException, NoSuchMethodException {

        boolean result = true;

        final PairOfValues<P> pair = generateTwoDistinctValues(propertyInfo);
        final T bean = beanClass.getDeclaredConstructor().newInstance();
        if (propertyInfo.repeatability == Repeatability.SIMPLE || propertyInfo.repeatability == Repeatability.BOTH) {
            ReflectionHelper.setField(bean, pair.value1, propertyInfo.name);
            final int initialHashCode = bean.hashCode();
            ReflectionHelper.setField(bean, pair.value2, propertyInfo.name);
            final int newHashCode = bean.hashCode();
            if (initialHashCode == newHashCode) {
                LOG.error("The hashCode of " + beanClass.getSimpleName() + " is not affected by the value of " + propertyInfo.name + " as a simple field.");
                result = false;
            }
        }

        if (propertyInfo.repeatability == Repeatability.COLLECTION || propertyInfo.repeatability == Repeatability.BOTH) {
            final List<P> list1 = new ArrayList<>();
            list1.add(pair.value1);
            ReflectionHelper.setField(bean, list1, propertyInfo.name);
            final int initialHashCode = bean.hashCode();
            final List<P> list2 = new ArrayList<>();
            list2.add(pair.value2);
            ReflectionHelper.setField(bean, list2, propertyInfo.name);
            final int newHashCode = bean.hashCode();
            if (initialHashCode == newHashCode) {
                LOG.error("The hashCode of " + beanClass.getSimpleName() + " is not affected by the value of " + propertyInfo.name + " as a collection.");
                result = false;
            }
        }

        return result;

    }

    public <P, T> boolean propertyComparedDuringEquals(final Class<T> beanClass, final PropertyInfo<P> propertyInfo)
        throws TestNonSVPBeansException, IllegalAccessException, InstantiationException, InvocationTargetException, ToolkitException, NoSuchMethodException {

        boolean result = true;
        final PairOfValues<P> pair = generateTwoDistinctValues(propertyInfo);

        if (propertyInfo.repeatability == Repeatability.SIMPLE || propertyInfo.repeatability == Repeatability.BOTH) {
            final T bean1 = beanClass.getDeclaredConstructor().newInstance();
            ReflectionHelper.setField(bean1, pair.value1, propertyInfo.name);
            final T bean2 = beanClass.getDeclaredConstructor().newInstance();
            ReflectionHelper.setField(bean2, pair.value2, propertyInfo.name);
            final T bean3 = beanClass.getDeclaredConstructor().newInstance();
            ReflectionHelper.setField(bean3, pair.value1, propertyInfo.name);
            if (bean1.equals(bean2) && bean1.equals(bean3)) {
                LOG.error("The equals method of " + beanClass.getSimpleName() + " is not affected by the value of " + propertyInfo.name + " as a simple field.");
                result = false;
            }
        }

        if (propertyInfo.repeatability == Repeatability.COLLECTION || propertyInfo.repeatability == Repeatability.BOTH) {
            final T bean1 = beanClass.getDeclaredConstructor().newInstance();
            final List<P> list1 = new ArrayList<>();
            list1.add(pair.value1);
            ReflectionHelper.setField(bean1, list1, propertyInfo.name);
            final T bean2 = beanClass.getDeclaredConstructor().newInstance();
            final List<P> list2 = new ArrayList<>();
            list2.add(pair.value2);
            ReflectionHelper.setField(bean2, list2, propertyInfo.name);
            final T bean3 = beanClass.getDeclaredConstructor().newInstance();
            ReflectionHelper.setField(bean3, list1, propertyInfo.name);
            if (bean1.equals(bean2) && bean1.equals(bean3)) {
                LOG.error("The equals method of " + beanClass.getSimpleName() + " is not affected by the value of " + propertyInfo.name + " as a collection.");
                result = false;
            }
        }

        return result;

    }

    public <P, T> boolean nullPropertyHandledForEquals(final Class<T> beanClass, final PropertyInfo<P> propertyInfo)
        throws TestNonSVPBeansException, IllegalAccessException, InstantiationException, InvocationTargetException, ToolkitException, NoSuchMethodException {

        boolean result = true;

        final T beanOne = beanClass.getDeclaredConstructor().newInstance();
        final P valueOne = propertyInfo.generator.generate();

        if (propertyInfo.repeatability == Repeatability.SIMPLE || propertyInfo.repeatability == Repeatability.BOTH) {

            ReflectionHelper.setField(beanOne, valueOne, propertyInfo.name);

            final T beanTwo = beanClass.getDeclaredConstructor().newInstance();
            ReflectionHelper.setField(beanOne, null, propertyInfo.name);

            try {
                if ((beanOne.equals(beanTwo) || beanTwo.equals(beanOne))) {
                    LOG.error("The equals method of " + beanClass.getSimpleName() + " does not handle null " + propertyInfo.name + " as a simple field.");
                    result = false;
                }
            } catch (RuntimeException e) {
                LOG.error("The equals method of " + beanClass.getSimpleName() + " does not handle null " + propertyInfo.name + " as a simple field.");
                result = false;
            }
        }

        if (propertyInfo.repeatability == Repeatability.COLLECTION || propertyInfo.repeatability == Repeatability.BOTH) {

            final List<P> listOne = new ArrayList<>();
            listOne.add(valueOne);
            ReflectionHelper.setField(beanOne, listOne, propertyInfo.name);

            final T beanTwo = beanClass.getDeclaredConstructor().newInstance();
            ReflectionHelper.setField(beanOne, null, propertyInfo.name);

            try {
                if ((beanOne.equals(beanTwo) || beanTwo.equals(beanOne))) {
                    LOG.error("The equals method of " + beanClass.getSimpleName() + " does not handle null " + propertyInfo.name + " as a collection.");
                    result = false;
                }
            } catch (RuntimeException e) {
                LOG.error("The equals method of " + beanClass.getSimpleName() + " does not handle null " + propertyInfo.name + " as a collection.");
                result = false;
            }
        }

        return result;

    }

    static class PairOfValues<P> {
        final P value1;
        final P value2;

        PairOfValues(final P one, final P two) {
            value1 = one;
            value2 = two;
        }
    }

    public static <P> PairOfValues<P> generateTwoDistinctValues(final PropertyInfo<P> propertyInfo) throws TestNonSVPBeansException {
        final int maxAttempts = 128;
        int attempts = 0;
        final P value1 = propertyInfo.generator.generate();
        P value2;
        do {
            if (attempts == maxAttempts) {
                throw new TestNonSVPBeansException("Could not generate two distinct values for " + propertyInfo.name + " after " + maxAttempts + " attempts.");
            }
            value2 = propertyInfo.generator.generate();
            attempts++;
        } while (value1.equals(value2));
        return new PairOfValues<>(value1, value2);
    }
}
