package org.oclc.circill.toolkit.service.base;

/*
   Because non-repeatable fields in NCIP have been made repeatable in subsequent versions, and the Toolkit should
   support old versions of connectors, we have chosen to maintain the set methods that take a simple object,
   not the collection, and the get methods that return a simple object for backwards-compatibility.
   As a result when we test a property's getters and setters we need to control whether the tests
   are for a simple, non-repeatable property, or a collection, or both. 'Both' is for those cases
   where a property has been made repeatable since version 1 of NCIP.
   Note that the set-up for the tests do not determine this by inspecting the repeatability of the
   property in the class, as that would not be possible for properties having 'both' behaviors.
   We don't determine this by inspection for the vast majority of cases which aren't 'both' for the
   reason that in that case if someone only changed the property to make it repeatable and did not preserve
   the backwards-compatibility, these tests will fail and (hopefully) that failure will lead to this reminder.
 */
public enum Repeatability {
    SIMPLE, COLLECTION, BOTH
}
