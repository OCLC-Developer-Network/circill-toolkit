/*
 * Copyright (c) 2019 OCLC, Inc.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.dummy.web;

import org.oclc.circill.toolkit.dummy.ConfigurableService;
import org.oclc.circill.toolkit.dummy.ConfigurableServiceHandler;
import org.oclc.circill.toolkit.service.base.ServiceException;

import static java.lang.String.format;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * A controller to configure the {@link ConfigurableService}.
 */
@Controller
public class ConfigurationController {

    private static final String HTML_START = "<html>\n<body>\n";
    private static final String BASE_REF_FORMAT = "<base href=\"%s\">";
    private static final String SUBMIT_BUTTON = "<input type=\"submit\" value=\"Submit\"/>\n";
    private static final String HTML_END = "<a href=\"./\">Return to configuration menu</a>\n</body>\n</html>\n";

    /** The base of the deployed webapp, used for relative URLs in generated HTML. */
    private String webappBase = "";

    /**
     * Build the HTML for the menu page.
     * @return the menu page
     */
    private String buildMenu() {
        final StringBuilder menu = new StringBuilder();
        menu.append(HTML_START)
            .append(format(BASE_REF_FORMAT, webappBase))
            .append("<h1>Configuration menu</h1>\n")
            .append("<a href=\"list\">List handlers</a><br/>\n")
            .append("<a href=\"add\">Add handler</a><br/>\n")
            .append("<a href=\"reorder\">Reorder handlers</a><br/>\n")
            .append("<a href=\"remove\">Remove handler</a><br/>\n")
            .append("<a href=\"../\">Return to main menu</a></body>\n</html>");
        return menu.toString();
    }

    /**
     * Build the HTML for the add page.
     * @return the add page
     */
    private String buildAddForm() {
        final StringBuilder addForm = new StringBuilder();
        addForm.append(HTML_START)
            .append(format(BASE_REF_FORMAT, webappBase))
            .append("<h1>Add handler</h1>\n" + "<form id=\"messageInput\" method=\"POST\" action=\"add\">\n")
            .append(SUBMIT_BUTTON)
            .append("<textarea rows=\"10\" cols=\"120\" name=\"handler\" placeholder='Enter handler class source code here.'></textarea>\n</form>\n")
            .append(HTML_END);
        return addForm.toString();
    }

    /**
     * Build the HTML for the remove page.
     * @return the remove page
     */
    private String buildRemoveForm() {
        final StringBuilder removeForm = new StringBuilder();
        removeForm.append(HTML_START)
            .append(format(BASE_REF_FORMAT, webappBase))
            .append("<h1>Remove handler</h1>\n")
            .append("<form id=\"messageInput\" method=\"POST\" action=\"remove\">\n")
            .append(SUBMIT_BUTTON)
            .append("<textarea rows=\"10\" cols=\"120\" name=\"handler\" placeholder='Enter class name of handler to remove'></textarea>\n</form>\n")
            .append(HTML_END);
        return removeForm.toString();
    }

    /**
     * Build the HTML for the reorder page.
     * @return the reorder page
     */
    private String buildReorderForm() {
        final StringBuilder reorderForm = new StringBuilder();
        reorderForm.append(HTML_START)
            .append(format(BASE_REF_FORMAT, webappBase))
            .append("<h1>Reorder handlers</h1>\n")
            .append("<form id=\"messageInput\" method=\"POST\" action=\"reorder\">\n")
            .append(SUBMIT_BUTTON)
            .append("<textarea rows=\"10\" cols=\"120\" name=\"handlers\" placeholder='Enter names of handler in desired order separated by newline'></textarea>\n</form>\n")
            .append(HTML_END);
        return reorderForm.toString();
    }

    private ConfigurableService configurableService;

    /**
     * Get the "menu" page.
     * @return the page's HTML
     */
    @GetMapping(value = "/", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String menu() {
        return buildMenu();
    }

    /**
     * Get the "add handler" page.
     * @return the page's HTML
     */
    @GetMapping(value = "/add", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addForm() {
        return buildAddForm();
    }

    /**
     * Add a handler.
     * @param httpRequest the POST request with the source of the handler in the "handler" parameter
     * @return a message indicating whether the handler was added
     */
    @PostMapping(value = "/add", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String add(final HttpServletRequest httpRequest) {
        final String source = httpRequest.getParameter("handler");
        try {
            configurableService.addHandler(source);
        } catch (ServiceException e) {
            return "Failed to add the handler. " + e.getLocalizedMessage();
        }
        return "Successfully added handler.";
    }

    /**
     * Set the service associated with this controller.
     * @param configurableService the {@link ConfigurableService}
     */
    public void setConfigurableService(final ConfigurableService configurableService) {
        this.configurableService = configurableService;
    }

    /**
     * Get the service associated with this controller.
     * @return the {@link ConfigurableService}
     */
    public ConfigurableService getConfigurableService() {
        return configurableService;
    }

    /**
     * Set the option on the handler
     * @param httpRequest the POST request with the handler name in the option to set
     * @return message indicating whether the option is set
     */
    @PostMapping(value = "/option", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String setOption(final HttpServletRequest httpRequest) {
        final String handlerName = httpRequest.getParameter("handler");
        final String option = httpRequest.getParameter("option");
        String returnMessage = "";
        try {
            final ConfigurableServiceHandler handler = configurableService.getHandler(handlerName);
            if (DynamicConfigurableServiceHandler.class.isAssignableFrom(handler.getClass())) {
                ((DynamicConfigurableServiceHandler) handler).setOption(option);
                returnMessage = "Successfully set the option '" + option + "' for handler '" + handlerName + " '.";
            }
        }  catch (ServiceException e) {
            returnMessage = "Failed to set the '" + option + "' for handler '" + handlerName + " '. " + e.getLocalizedMessage();
        }
        return returnMessage;
    }

    /**
     * Get the "list handlers" page.
     * @param request the {@link HttpServletRequest}
     * @return the page's HTML
     */
    @GetMapping(value = "/list", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String list(final HttpServletRequest request) {
        final List<String> handlerNames = configurableService.getHandlerNames();
        if (CollectionUtils.isEmpty(handlerNames)) {
            return "No handlers are configured.";
        }
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>\n")
            .append("<style> table, th, td { border: 1px solid black; } table {border-collapse: collapse;} td {align: left; vertical-align: top;}</style>\n")
            .append("<script> function setOption(handler, option) {\n")
            .append("var xhttp = new XMLHttpRequest(); \n")
            .append(" xhttp.onreadystatechange = function() {\n")
            .append("    if (this.readyState == 4 && this.status == 200) {\n")
            .append("      document.getElementById('status').innerHTML = this.responseText;\n")
            .append("    } };\n")
            .append("xhttp.open('POST','option', true);\n")
            .append("xhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');\n")
            .append("xhttp.send(`handler=${handler}&option=${option}`);}\n")
            .append("</script>")
            .append("<body>\n")
            .append(format(BASE_REF_FORMAT, webappBase))
            .append("<h1>List of Handlers</h1>\n")
            .append(" <table>\n");
        for (final String handlerName: handlerNames) {
            try {
                final ConfigurableServiceHandler handler = configurableService.getHandler(handlerName);
                stringBuilder.append("<tr>\n<td>").append(handlerName).append("</td>\n<td>");
                if (DynamicConfigurableServiceHandler.class.isAssignableFrom(handler.getClass())) {
                    final String currentOption = ((DynamicConfigurableServiceHandler) handler).currentOption();
                    for (final String option : ((DynamicConfigurableServiceHandler) handler).getOptions()) {
                        final String checked = currentOption.equalsIgnoreCase(option) ? "checked" : "";
                        stringBuilder.append("<div><input type='radio' name='").append(handlerName).append("Option' value='").append(option).append("' ").append(checked)
                            .append(" onchange='setOption(`").append(handlerName).append("`,`").append(option).append("`)' >\n")
                            .append(" <label for='").append(option).append("'> ").append(option).append(" </label></div>\n");
                    }
                }
                stringBuilder.append("</td> </tr>\n");
            } catch (ServiceException e) {
                // Ignore
            }
        }
        stringBuilder.append("</table>\n")
            .append("<a href=\"./\">Return to configuration menu</a>\n</body>\n")
            .append("<p id='status'></p>")
            .append("</html>");
        return stringBuilder.toString();
    }

    /**
     * Get the "remove handlers" page.
     * @return the page's HTML
     */
    @GetMapping(value = "/remove", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String removeForm() {
        return buildRemoveForm();
    }

    /**
     * Remove a handler.
     * @param httpRequest the POST request with the name of the handler to remove in the "handler" parameter
     * @return a message indicating that the handler was removed, or why it couldn't be
     */
    @PostMapping(value = "/remove", produces = "text/plain;charset=UTF-8")
    public String remove(final HttpServletRequest httpRequest) {
        final String handlerName = httpRequest.getParameter("handler");
        final boolean removed = configurableService.removeHandler(handlerName);
        final String response;
        if (removed) {
            response = "redirect:list/";
        } else {
            response = "redirect:error?message=" + StringEscapeUtils.escapeHtml4("Handler '" + handlerName + "' not found.");
        }
        return response;
    }

    /**
     * Get the "reorder" page.
     * @return the page's HTML
     */
    @GetMapping(value = "/reorder", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String reorderForm() {
        return buildReorderForm();
    }

    /**
     * Reorder the handlers.
     * @param httpRequest the POST request with the names of the handlers in the desired order
     * @return a message indicating whether the handlers were reordered, or why they couldn't be
     */
    @PostMapping(value = "/reorder", produces = "text/plain;charset=UTF-8")
    public String reorder(final HttpServletRequest httpRequest) {
        final String handlers = httpRequest.getParameter("handlers");
        final List<String> orderedHandlerNames = Arrays.stream(StringUtils.split(handlers, System.lineSeparator())).map(StringUtils::strip).collect(Collectors.toList());
        final List<String> unfoundHandlers = configurableService.reorderHandlers(orderedHandlerNames);
        final String response;
        if (unfoundHandlers.isEmpty()) {
            response = "redirect:list/";
        } else {
            response = "redirect:error?message=" + StringEscapeUtils.escapeHtml4("Handler(s) " + StringUtils.join(unfoundHandlers.toArray(), ", ") + " not found.");
        }
        return response;
    }

    /**
     * Display the error page with a message.
     * @param request the {@link HttpServletRequest}
     * @return the page's HTML
     */
    @GetMapping(value = "/error", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String error(final HttpServletRequest request) {
        final String message = request.getParameter("message");
        final StringBuilder addForm = new StringBuilder();
        addForm.append(HTML_START)
            .append(format(BASE_REF_FORMAT, webappBase))
            .append("<p style=\"color:red\">").append(message).append("</p>")
            .append(HTML_END);
        return addForm.toString();
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

}
