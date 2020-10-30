/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.initiator.client;

import org.oclc.circill.toolkit.common.base.StatisticsBean;

import javax.net.ssl.HostnameVerifier;
import java.net.MalformedURLException;

/**
 * Base class for clients (a.k.a. 'initiators').
 */
public abstract class BaseClient {

    /**
     * The {@link StatisticsBean} instance used to report performance data.
     */
    protected StatisticsBean statisticsBean;
    /**
     * A sub-class of {@link HostnameVerifier}; only used for HTTPS transport, and optional even then.
     */
    protected HostnameVerifier hostnameVerifier = null;
    /**
     * The default connect timeout interval of 30000 ms.
     */
    protected static final int DEFAULT_CONNECT_TIMEOUT = 180000;
    /**
     * The default read timeout interval of 30000 ms.
     */
    protected static final int DEFAULT_READ_TIMEOUT = 180000;

    /**
     * The connect timeout for this client's connections.
     */
    protected int connectTimeout = DEFAULT_CONNECT_TIMEOUT;
    /**
     * The read timeout for this client's connections.
     */
    protected int readTimeout = DEFAULT_READ_TIMEOUT;

    /**
     * Construct a new client with the provided {@link StatisticsBean} and default timeout values.
     *
     * @param statisticsBean the {@link StatisticsBean} to which to write statistics
     */
    protected BaseClient(final StatisticsBean statisticsBean) {
        this.statisticsBean = statisticsBean;
    }

    /**
     * Get the {@link HostnameVerifier} for this client.
     *
     * @return the hostname verifier
     */
    public HostnameVerifier getHostnameVerifier() {
        return hostnameVerifier;
    }

    /**
     * Set the {@link HostnameVerifier} for this client.
     *
     * @param hostnameVerifier the hostname verifier used by this client
     */
    public void setHostnameVerifier(final HostnameVerifier hostnameVerifier) {
        this.hostnameVerifier = hostnameVerifier;
    }

    /**
     * Get the connect timeout for this client's connections.
     *
     * @return the connect timeout in milliseconds
     */
    public int getConnectTimeout() {
        return connectTimeout;
    }

    /**
     * Set the connect timeout for this client's connections.
     *
     * @param connectTimeout the connect timeout in milliseconds for this client's connections
     */
    public void setConnectTimeout(final int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    /**
     * Get the read timeout for this client's connections.
     *
     * @return the read timeout in milliseconds
     */
    public int getReadTimeout() {
        return readTimeout;
    }

    /**
     * Set the read timeout for this client's connections.
     *
     * @param readTimeout the read timeout in milliseconds for this client's connections
     */
    public void setReadTimeout(final int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public StatisticsBean getStatisticsBean() {
        return statisticsBean;
    }

    /**
     * Validate the URL.
     * @param targetURL the address of the service
     * @throws MalformedURLException if the URL is not valid.
     */
    protected void validateURL(final String targetURL) throws MalformedURLException {
        // Make sure that the url starts with https:// or http://
        if (targetURL.substring(0, targetURL.indexOf("://")).compareToIgnoreCase("https") != 0
            && targetURL.substring(0, targetURL.indexOf("://")).compareToIgnoreCase("http") != 0) {
            throw new MalformedURLException("The target address' protocol is not https or http.");
        }
    }

}
