package org.oclc.circill.toolkit.service.base;

/**
 * An exception thrown by unit test methods indicating a failed test.
 */
public class TestNonSVPBeansException extends Exception {
    public TestNonSVPBeansException(final String msg) {
        super(msg);
    }
}
