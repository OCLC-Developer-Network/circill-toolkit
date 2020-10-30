/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.service.iso18626;

@SuppressWarnings("ReturnOfThis")
public final class RequestingAgencyAuthenticationBuilder {

    private String accountId;
    private String securityCode;

    /**
     * This utility class does not allow instances.
     */
    private RequestingAgencyAuthenticationBuilder() {
    }

    /**
     * -
     * @return a builder for {@link RequestingAgencyAuthentication}
     */
    public static RequestingAgencyAuthenticationBuilder aRequestingAgencyAuthentication() {
        final RequestingAgencyAuthenticationBuilder builder = new RequestingAgencyAuthenticationBuilder();
        return builder;
    }

    public RequestingAgencyAuthenticationBuilder withAccountId(final String accountId) {
        this.accountId = accountId;
        return this;
    }

    public RequestingAgencyAuthenticationBuilder withSecurityCode(final String securityCode) {
        this.securityCode = securityCode;
        return this;
    }

    public RequestingAgencyAuthentication build() {
        final RequestingAgencyAuthentication requestingAgencyAuthentication = new RequestingAgencyAuthentication();
        requestingAgencyAuthentication.setAccountId(accountId);
        requestingAgencyAuthentication.setSecurityCode(securityCode);
        return requestingAgencyAuthentication;
    }

}

