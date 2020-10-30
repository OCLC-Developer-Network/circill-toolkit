/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php. 
 */

package org.oclc.circill.toolkit.service.ncip;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Carries data elements describing the AuthenticationPrompt.
 */
public class AuthenticationPrompt {

    /**
     * PromptOutput
     */
    protected PromptOutput promptOutput;

    /**
     * Set PromptOutput.
     *
     * @param promptOutput the {@link PromptOutput}
     */
    public void setPromptOutput(final PromptOutput promptOutput) {

        this.promptOutput = promptOutput;

    }

    /**
     * Get PromptOutput.
     *
     * @return the {@link PromptOutput}
     */
    public PromptOutput getPromptOutput() {

        return promptOutput;

    }

    /**
     * PromptInput
     */
    protected PromptInput promptInput;

    /**
     * Set PromptInput.
     *
     * @param promptInput the {@link PromptInput}
     */
    public void setPromptInput(final PromptInput promptInput) {

        this.promptInput = promptInput;

    }

    /**
     * Get PromptInput.
     *
     * @return the {@link PromptInput}
     */
    public PromptInput getPromptInput() {

        return promptInput;

    }

    /**
     * Generic toString() implementation.
     *
     * @return String
     */
    @Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this);

    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        final AuthenticationPrompt rhs = (AuthenticationPrompt) obj;
        return new EqualsBuilder().append(promptOutput, rhs.promptOutput).append(promptInput, rhs.promptInput).isEquals();
    }

    @Override
    public int hashCode() {
        final int result = new HashCodeBuilder(2113721943, 1616817019).append(promptOutput).append(promptInput).toHashCode();
        return result;
    }
}
