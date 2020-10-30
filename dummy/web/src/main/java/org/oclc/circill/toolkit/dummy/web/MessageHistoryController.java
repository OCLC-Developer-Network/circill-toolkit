/*
 * Copyright (c) 2020 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy.web;

import org.oclc.circill.toolkit.common.base.MessageCache;
import org.oclc.circill.toolkit.common.base.MessageCacheEntry;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ToolkitHelper;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeFormatter;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * A controller to display captured messages.
 */
@Controller
public class MessageHistoryController {

    private static final DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    /** The base of the deployed webapp, used for relative URLs in generated HTML. */
    private String webappBase = "";

    /** Cache for received and returned messages. */
    private MessageCache messageCache;

    /** Whether to display the messages in pretty-printed form or not. */
    private boolean prettyPrintMessages = true;

    /**
     * Get the list of messages.
     * @return the page's HTML
     * @throws ServiceException if formatting the messages for display fails
     */
    @GetMapping(value = "display", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String display() throws ServiceException {
        return buildDisplay();
    }

    /**
     * Clear the message cache.
     * @return redirects to the display method
     */
    @PostMapping(value = "clear", produces = "text/html;charset=UTF-8")
    public String clear() {
        messageCache.removeAll();
        return "redirect:display/";
    }

    private String buildDisplay() throws ServiceException {
        final String first = "<html><body>"
            + "<base href=\"" + webappBase + "\">"
            + "<table>"
            + "<tr><td>The table has " + messageCache.getCount() + " current entries and a maximum of " + messageCache.getCapacity() + " entries.</td></tr>"
            + "<tr><td><form action=\"../clear\" method=\"post\">\n" + "    <input type=\"submit\" name=\"clear\" value=\"Clear\" />\n" + "</form></td></tr>"
            + "<tr><td><a href=\"../../\">Return to main menu</a></td></tr>"
            + "</table>"
            + "<table border=\"1\" style=\"font-family:'Courier New', Courier, monospace;white-space: pre;\" cellpadding=\"15\">";
        final StringBuilder middle = new StringBuilder();
        int count = 0;
        for (final MessageCacheEntry messageCacheEntry : messageCache.getAll()) {
            final String messageForDisplay;
            count++;
            if (prettyPrintMessages) {
                final StringWriter strWriter = new StringWriter();
                ToolkitHelper.prettyPrintXML(new ByteArrayInputStream(messageCacheEntry.getMessage().getBytes(StandardCharsets.UTF_8)), strWriter);
                messageForDisplay = strWriter.toString();
            } else {
                messageForDisplay = messageCacheEntry.getMessage();
            }
            final String timestamp = messageCacheEntry.getTimestamp().format(TIMESTAMP_FORMAT);
            middle.append("<tr><td valign=\"top\">")
                .append(count)
                .append("</td><td valign=\"top\">")
                .append(timestamp)
                .append("</td><td style=\"padding:0;\">")
                .append(StringEscapeUtils.escapeHtml4(messageForDisplay))
                .append("</td></tr>");
        }
        final String last = "</table>"
            + "</body></html>";
        return first + middle + last;
    }

    public MessageCache getMessageCache() {
        return messageCache;
    }

    public void setMessageCache(final MessageCache messageCache) {
        this.messageCache = messageCache;
    }

    /**
     * Get the webapp base.
     * @return the webapp base
     */
    public String getWebappBase() {
        return webappBase;
    }

    /**
     * Set the webapp base.
     * @param webappBase the webapp base
     */
    public void setWebappBase(final String webappBase) {
        this.webappBase = webappBase;
    }

    public boolean isPrettyPrintMessages() {
        return prettyPrintMessages;
    }

    public void setPrettyPrintMessages(final boolean prettyPrintMessages) {
        this.prettyPrintMessages = prettyPrintMessages;
    }

}
