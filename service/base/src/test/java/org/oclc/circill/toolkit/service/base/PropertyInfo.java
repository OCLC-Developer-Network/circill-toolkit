package org.oclc.circill.toolkit.service.base;

import com.google.code.beanmatchers.ValueGenerator;

/**
 * Information required to perform unit tests on a bean property.
 */
public class PropertyInfo<PROPERTY_TYPE> {
    public final Repeatability repeatability;
    public final String name;
    public final ValueGenerator<PROPERTY_TYPE> generator;

    public PropertyInfo(final Repeatability repeatability, final String name, final ValueGenerator<PROPERTY_TYPE> generator) {
        this.repeatability = repeatability;
        this.name = name;
        this.generator = generator;
    }

}
