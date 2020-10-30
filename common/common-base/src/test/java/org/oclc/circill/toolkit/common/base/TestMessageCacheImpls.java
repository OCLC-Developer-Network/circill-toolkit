package org.oclc.circill.toolkit.common.base;

import static org.oclc.circill.toolkit.service.base.ReflectionHelper.ALL_CLASSES_NAME_PATTERN;

import org.oclc.circill.toolkit.service.base.ReflectionHelper;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

/**
 * Test all implementations of {@link MessageCache}.
 */
public class TestMessageCacheImpls {

    private static final Logger LOG = Logger.getLogger(TestMessageCacheImpls.class);

    private static final String[] MESSAGES = { "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE" };

    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    @Test
    public void testAll() throws Exception {
        final List<Class<MessageCache>> classes = ReflectionHelper
            .findClassesInPackage(TestMessageCacheImpls.class.getPackage().getName(), ALL_CLASSES_NAME_PATTERN, ".*\\.MessageCache", MessageCache.class);

        for (final Class<MessageCache> testClass : classes) {
            testBehavior(testClass);
        }
    }

    public void testBehavior(final Class<MessageCache> testClass) throws Exception {
        testConstruction(testClass);
        testBehaviorForZeroMessages(testClass);
        testBehaviorForOneMessage(testClass);
        testBehaviorForTwoMessages(testClass);
        testResizing(testClass);
    }

    public void testConstruction(final Class<MessageCache> testClass) throws Exception {
        final MessageCache cache = testClass.newInstance();
        collector.checkThat(testClass.getName() + " was initialized with a count that is not zero.", cache.getCount(), is(0));
    }

    public void testBehaviorForZeroMessages(final Class<MessageCache> testClass) throws Exception {
        final MessageCache cache = testClass.newInstance();

        final List<MessageCacheEntry> allRetrievedMessages = cache.getAll();
        collector.checkThat(testClass.getName() + " did not return anything from the getAll method.", allRetrievedMessages, notNullValue());
        collector.checkThat(testClass.getName() + " did not return an empty list from the getAll method.", allRetrievedMessages.size(), is(0));

        cache.removeAll();
        collector.checkThat(testClass.getName() + " doesn't have a count of 0 after calling removeAll().", cache.getCount(), is(0));

    }

    public void testBehaviorForOneMessage(final Class<MessageCache> testClass) throws Exception {
        final MessageCache cache = testClass.newInstance();

        cache.add(MESSAGES[0]);
        collector.checkThat(testClass.getName() + " doesn't have a count of 1 after adding a message.", cache.getCount(), is(1));

        final List<MessageCacheEntry> allRetrievedMessages = cache.getAll();
        collector.checkThat(testClass.getName() + " did not return anything from the getAll method.", allRetrievedMessages, notNullValue());
        collector.checkThat(testClass.getName() + " did not return a list of one message from the getAll method.", allRetrievedMessages.size(), is(1));
        collector.checkThat(testClass.getName() + " did not return a list of the one expected message from the getAll method.", allRetrievedMessages.get(0).getMessage(), is(MESSAGES[0]));

        cache.removeAll();
        collector.checkThat(testClass.getName() + " doesn't have a count of 0 after calling removeAll.", cache.getCount(), is(0));

    }

    public void testBehaviorForTwoMessages(final Class<MessageCache> testClass) throws Exception {
        final MessageCache cache = testClass.newInstance();

        cache.add(MESSAGES[0]);
        cache.add(MESSAGES[1]);

        collector.checkThat(testClass.getName() + " doesn't have a count of 2 after adding two messages.", cache.getCount(), is(2));

        final List<MessageCacheEntry> retrievedMessages = cache.getAll();
        collector.checkThat(testClass.getName() + " doesn't have a count of 2 after adding a message and calling the getAll method.", cache.getCount(), is(2));
        collector.checkThat(testClass.getName() + " did not return anything from the getAll() method.", retrievedMessages, notNullValue());
        collector.checkThat(testClass.getName() + " did not return a list of two messages from the getAll() method.", retrievedMessages.size(), is(2));
        collector.checkThat(testClass.getName() + " did not return a list with the second-added message as the first in the list returned by the getAll() method.",
            retrievedMessages.get(0).getMessage(), is(MESSAGES[1]));
        collector.checkThat(testClass.getName() + " did not return a list with the first-added message as the second in the list returned by the getAll() method.",
            retrievedMessages.get(1).getMessage(), is(MESSAGES[0]));

        cache.removeAll();
        collector.checkThat(testClass.getName() + " doesn't have a count of 0 after removing all messages.", cache.getCount(), is(0));
    }

    public void testResizing(final Class<MessageCache> testClass) throws Exception {
        final MessageCache cache = testClass.newInstance();
        cache.add(MESSAGES[0]);
        cache.add(MESSAGES[1]);

        collector.checkThat(testClass.getName() + " doesn't have a count of 2 after adding two messages.", cache.getCount(), is(2));

        cache.setCapacity(1);
        collector.checkThat(testClass.getName() + " doesn't have a count of 1 after resizing down to 1.", cache.getCount(), is(1));

        List<MessageCacheEntry> retrievedMessages = cache.getAll();
        collector.checkThat(testClass.getName() + " did not return a list with the just second-added message after resizing down to 1.",
            retrievedMessages.get(0).getMessage(), is(MESSAGES[1]));

        cache.setCapacity(3);
        final int newCapacity = cache.getCount();
        collector.checkThat(testClass.getName() + " doesn't have a capacity of 3 after setting capacity to 3.", cache.getCapacity(), is(3));
        collector.checkThat(testClass.getName() + " doesn't have a count of 1 after setting capacity to 3.", cache.getCount(), is(1));

        retrievedMessages = cache.getAll();
        collector.checkThat(testClass.getName() + " did not return a list with the just second-added message after setting capacity to 3 and not adding any.",
            retrievedMessages.get(0).getMessage(), is(MESSAGES[1]));

        cache.add(MESSAGES[3]);
        cache.add(MESSAGES[4]);

        retrievedMessages = cache.getAll();
        collector.checkThat(testClass.getName() + " did not return message 4 as the first message  after adding up-to the capacity.",
            retrievedMessages.get(0).getMessage(), is(MESSAGES[4]));
        collector.checkThat(testClass.getName() + " did not return message 3 as the first message  after adding up-to the capacity.",
            retrievedMessages.get(1).getMessage(), is(MESSAGES[3]));
        collector.checkThat(testClass.getName() + " did not return message 1 as the first message  after adding up-to the capacity.",
            retrievedMessages.get(2).getMessage(), is(MESSAGES[1]));

        cache.add(MESSAGES[5]);

        retrievedMessages = cache.getAll();
        collector.checkThat(testClass.getName() + " did not return message 3 as the first message after adding one beyond the capacity.",
            retrievedMessages.get(0).getMessage(), is(MESSAGES[5]));
        collector.checkThat(testClass.getName() + " did not return message 4 as the first message after adding one beyond the capacity.",
            retrievedMessages.get(1).getMessage(), is(MESSAGES[4]));
        collector.checkThat(testClass.getName() + " did not return message 3 as the first message after adding one beyond the capacity.",
            retrievedMessages.get(2).getMessage(), is(MESSAGES[3]));


    }
}

