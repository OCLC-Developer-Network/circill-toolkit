# The Configurable Service 

The Configurable Service simplifies testing client applications by allowing you to change the response that's returned without redeploying the service. 

How to use the Configurable service:
1) Build and deploy the dummy/webapp module's war file at the root application context (i.e., "/").
2) Go to http://localhost:8080/config/list to view the list of configurable handlers. There are four handlers available by default when deployed:
    1) NCIPRequestItemService - always returns a successful response, as if the request succeeded.
    2) NCIPLookupUserService - always returns a successful response, with no user data.
    3) NCIPUnsupportedService - always returns an NCIP Problem response indicating the requested service is unsupported.
    4) ISO18626DynamicResponder - can be configured to respond with an "OK" status for whatever incoming message is received, or with any of the standard error types, 
    or with an exception.

     The source for these handlers is in the dummy/web/src/main/resources folder.
3) To test it:
    1) Load the URL http://localhost:8080/ncip/ or http://localhost:8080/iso18626/.
    2) You can click the button in the "Sample Documents" to load a pre-defined message, or paste one of your own into the top text box.
    3) Click the Submit button; this should result in a handler being called and the response message being displayed in the lower text box.
4) To use it:
    1) Configure your NCIP or ISO 18626 client application to send messages to this Configurable Service.
    2) Test, modify the handlers, repeat until done.
5) To add a handler to the deployed service, select the "Add handler" option from the main configuration menu, and paste in a Groovy class to handle incoming messages.
    1) The class must implement ConfigurableServiceHandler, i.e. have a canHandle and handle methods. See that class' Javadoc for details.
    2) You can add multiple handlers; they're added to the front of the list. When a message is received the ConfigurableService calls canHandle in this order until one of the
       handlers returns true, it then calls that handler.
    3) You can remove (and replace it with a new version) and reorder handlers, all without redploying the service. 

This has been tested on Tomcat 8, although it should work on other versions with little or no adjustment.