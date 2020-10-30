/*
 * Copyright (c) 2011 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding.jaxb.dozer;

import javax.xml.bind.JAXBElement;
import java.util.Comparator;
import java.util.List;

class ContentMappingComparator implements Comparator {

    final List<String> elementOrderByName;

    ContentMappingComparator(final List<String> elementOrderByName) {

        this.elementOrderByName = elementOrderByName;

    }

    @Override
    public int compare(final Object firstElement, final Object secondElement) {

        final int result;
        final String firstElementName;
        if (firstElement instanceof JAXBElement) {

            firstElementName = ((JAXBElement) firstElement).getName().getLocalPart();

        } else {

            firstElementName = firstElement.getClass().getSimpleName();

        }
        final String secondElementName;
        if (secondElement instanceof JAXBElement) {

            secondElementName = ((JAXBElement) secondElement).getName().getLocalPart();

        } else {

            secondElementName = secondElement.getClass().getSimpleName();

        }

        final int firstIndex = elementOrderByName.indexOf(firstElementName);
        final int secondIndex = elementOrderByName.indexOf(secondElementName);
        if (firstIndex > secondIndex) {

            result = 1;

        } else if (firstIndex == secondIndex) {

            result = 0;

        } else {

            result = -1;

        }

        return result;

    }

}
