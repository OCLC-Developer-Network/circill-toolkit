/*
 * Copyright (c) 2017 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.initiator.client;

import org.oclc.circill.toolkit.service.base.ServiceException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;
import org.apache.log4j.Logger;

/**
 * Implementation of {@link HttpClient} that takes an instance of an ApacheHttpClient
 * to perform the actual communication with the responder/service.
 */
public class ApacheHttpClientClient implements HttpClient {

    private static final Logger LOG = Logger.getLogger(ApacheHttpClientClient.class);
    private static final String LOGGER_WARN_MESSAGE = "Exception connecting to or exchanging messages with target. Url:";
    private static final String ERROR_MESSAGE = "Exception connecting to or exchanging messages with target.";
    private static final int DEFULT_READ_TIMEOUT_MILLIS = 30000;
    private static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 3500;
    private int readTimeoutInMillis = DEFULT_READ_TIMEOUT_MILLIS;
    private int connectTimeoutInMillis = DEFAULT_CONNECT_TIMEOUT_MILLIS;
    private Executor executor;

    @Override
    public InputStream sendMessage(final byte[] initiationMsgBytes, final Map<String, String> headers, final String targetURL) throws ServiceException {

        try {
            return executor.execute(Request.Post(targetURL).setHeaders(getHeaderArray(headers)).socketTimeout(readTimeoutInMillis).connectTimeout(connectTimeoutInMillis)
                .body(new ByteArrayEntity(initiationMsgBytes, ContentType.TEXT_XML))).returnContent().asStream();
        } catch (IOException e) {
            LOG.warn(LOGGER_WARN_MESSAGE + targetURL);
            throw new ServiceException(ERROR_MESSAGE, e);
        }
    }

    protected Header[] getHeaderArray(final Map<String, String> headers) {
        final List<Header> headerList = new ArrayList<>();
        if (headers != null && !headers.isEmpty()) {
            for (final Map.Entry<String, String> entry : headers.entrySet()) {
                headerList.add(new BasicHeader(entry.getKey(), entry.getValue()));
            }
        }
        return headerList.toArray(new Header[headerList.size()]);
    }

    public void setReadTimeoutInMillis(final int readTimeoutInMillis) {
        this.readTimeoutInMillis = readTimeoutInMillis;
    }

    public void setConnectTimeoutInMillis(final int connectTimeoutInMillis) {
        this.connectTimeoutInMillis = connectTimeoutInMillis;
    }

    public void setExecutor(final Executor executor) {
        this.executor = executor;
    }
}
