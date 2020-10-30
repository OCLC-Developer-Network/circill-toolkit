# Circ/ILL Toolkit
<p align="center">
  <a href="./LICENSE.md">
    <img src="https://img.shields.io/github/license/OCLC-Developer-Network/circill-toolkit" alt="The Circ/ILL Toolkit is released under the MIT license." />
  </a>
</p>

The Circ/ILL Toolkit is a library for for marshalling, unmarshalling and exchanging messages conforming to ISO ILL (ISO 18626) or NCIP (NISO Z39.83).

The toolkit enables developers of clients (initiators) and servers (responders) to:
- compose messages as Java beans
- marshall them into standards-compliant form and send them to peer systems
- unmarshall the responses into Java beans

with support for local, consortial, vendor-specific or other configuration, including mapping of Schemes (e.g. PatronType) to local codes, validation of data, 
etc. all while guaranteeing forward compatibility with future versions of those standards.

### Prerequisites
Java 8 or later is required to run code using the Toolkit.

## Table of Contents
* [Circ/ILL Toolkit](#circill-toolkit)
    * [Prerequisites](#prerequisites)
  * [Getting started with the Circ/ILL Toolkit](#getting-started-with-the-circill-toolkit)
    * [Build the Toolkit](#build-the-toolkit)
    * [Deploy the test webapp](#deploy-the-test-webapp)
  * [Getting Started with an ISO 18626 client](#getting-started-with-an-iso-18626-client)
    * [Add Toolkit dependencies to your ISO 18626 client project](#add-toolkit-dependencies-to-your-iso-18626-client-project)
    * [Add Toolkit components to your ISO 18626 client application's configuration](#add-toolkit-components-to-your-iso-18626-client-applications-configuration)
    * [Send an ISO 18626 Request message from your ISO 18626 client application](#send-an-iso-18626-request-message-from-your-iso-18626-client-application)
  * [Getting Started with an ISO 18626 service](#getting-started-with-an-iso-18626-service)
    * [Add Toolkit dependencies to your ISO 18626 service project](#add-toolkit-dependencies-to-your-iso-18626-service-project)
    * [Implement your ISO 18626 Request service](#implement-your-iso-18626-request-service)
    * [Add Toolkit components to your ISO 18626 service webapp's configuration](#add-toolkit-components-to-your-iso-18626-service-webapps-configuration)
    * [Add the Toolkit components to your ISO 18626 service webapp's web\.xml file](#add-the-toolkit-components-to-your-iso-18626-service-webapps-webxml-file)
    * [Deploy and test your ISO 18626 service](#deploy-and-test-your-iso-18626-service)
  * [Getting Started with an NCIP client](#getting-started-with-an-ncip-client)
    * [Add the Toolkit dependencies to your NCIP client project](#add-the-toolkit-dependencies-to-your-ncip-client-project)
    * [Add Toolkit components to your NCIP client application's configuration](#add-toolkit-components-to-your-ncip-client-applications-configuration)
    * [Send an NCIP RequestItem message from your NCIP client application](#send-an-ncip-requestitem-message-from-your-ncip-client-application)
  * [Getting Started with an NCIP responder](#getting-started-with-an-ncip-responder)
    * [Add Toolkit dependencies to your NCIP responder project](#add-toolkit-dependencies-to-your-ncip-responder-project)
    * [Implement your NCIP RequestItem responder service](#implement-your-ncip-requestitem-responder-service)
    * [Add Toolkit components to your NCIP responder webapp's configuration](#add-toolkit-components-to-your-ncip-responder-webapps-configuration)
    * [Add the Toolkit components to your NCIP responder webapp's web\.xml file](#add-the-toolkit-components-to-your-ncip-responder-webapps-webxml-file)
    * [Deploy and test your NCIP responder](#deploy-and-test-your-ncip-responder)
  * [Using the Configurable Service:](#using-the-configurable-service)
  * [License](#license)

## Getting started with the Circ/ILL Toolkit

### Build the Toolkit
```text
mvn clean package
```

### Deploy the test webapp

## Getting Started with an ISO 18626 client

### Add Toolkit dependencies to your ISO 18626 client project
```xml
        <dependency>
            <groupId>org.oclc.circill.toolkit</groupId>
            <artifactId>binding-iso18626</artifactId>
            <version>0.25-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>org.oclc.circill.toolkit</groupId>
            <artifactId>service-base</artifactId>
            <version>0.25-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>org.oclc.circill.toolkit</groupId>
            <artifactId>service-iso18626</artifactId>
            <version>0.25-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>org.oclc.circill.toolkit</groupId>
            <artifactId>initiator</artifactId>
            <version>0.25-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>1.7.25</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>4.3.14.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>4.3.14.RELEASE</version>
        </dependency>
```

### Add Toolkit components to your ISO 18626 client application's configuration
Copy the circill-iso18626-toolkit-client.xml file from the examples/src/main/resources folder into your application's src/main/resources folder.

### Send an ISO 18626 Request message from your ISO 18626 client application
The following is an example Java client application that sends an ISO Request message to an ISO service. 
You can build & deploy the Circ/ILL Toolkit's dummy-webapp project to test your client, or you can follow the steps below for 
[**Getting Started with an ISO 18626 service**](#getting-started-with-an-iso-18626-service).  Once you've deployed an 
ISO service just execute this class as a Java application.
```java
package org.oclc.testisotoolkit.client;

import org.oclc.circill.toolkit.initiator.client.HttpClient;
import org.oclc.circill.toolkit.initiator.servicemanager.HttpInitiatorServiceManager;
import org.oclc.circill.toolkit.initiator.servicemanager.HttpInitiatorServiceManagerImpl;
import org.oclc.circill.toolkit.service.base.Service;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.iso18626.AgencyId;
import org.oclc.circill.toolkit.service.iso18626.BibliographicInfo;
import org.oclc.circill.toolkit.service.iso18626.BibliographicRecordId;
import org.oclc.circill.toolkit.service.iso18626.ErrorType;
import org.oclc.circill.toolkit.service.iso18626.Header;
import org.oclc.circill.toolkit.service.iso18626.ISO18626ConfirmationData;
import org.oclc.circill.toolkit.service.iso18626.ISO18626Message;
import org.oclc.circill.toolkit.service.iso18626.ISO18626RequestData;
import org.oclc.circill.toolkit.service.iso18626.MessageStatus;
import org.oclc.circill.toolkit.service.iso18626.RequestData;
import org.oclc.circill.toolkit.service.iso18626.RequestType;
import org.oclc.circill.toolkit.service.iso18626.ServiceInfo;
import org.oclc.circill.toolkit.service.iso18626.ServiceType;
import org.oclc.circill.toolkit.service.iso18626.Version2017AgencyIdType;
import org.oclc.circill.toolkit.service.iso18626.Version2017BibliographicRecordIdentifierCode;

import static java.lang.String.format;

import java.util.Calendar;
import java.util.Collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * An example ISO 18626 client.
 */
public final class ExampleISO18626Client {
    /**
     * Private constructor for utility class.
     */
    private ExampleISO18626Client() {
    }

    /**
     * Send an ISO 18626 Request message.
     * @param args ignored
     * @throws ToolkitException if there is a failure
     */
    public static void main(final String[] args) throws ToolkitException {
        // 1: Construct the Request message.
        final RequestData requestData = buildRequestData();

        // 2: Get the Toolkit client components from the application context.
        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("circill-iso18626-toolkit-client.xml");
        final HttpClient client = (HttpClient) applicationContext.getBean("v2017Client");
        final Service<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData> service
            = (Service<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData>) applicationContext
            .getBean("v2017InitiatorService");
        final ServiceContext<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData> serviceContext
            = (ServiceContext<ISO18626Message<ISO18626RequestData, ISO18626ConfirmationData>, ISO18626RequestData, ISO18626ConfirmationData>) applicationContext
            .getBean("v2017ServiceContext");

        // 3: Build a service manager for the target host.
        final HttpInitiatorServiceManager serviceManager = new HttpInitiatorServiceManagerImpl(client, "http://localhost:8080/iso18626/responder");

        // 4: Send the Request message and get the RequestConfirmation.
        final ISO18626ConfirmationData confirmation = service.performService(requestData, serviceContext, serviceManager);

        // 5: Determine whether the request was successful.
        if (MessageStatus.OK == confirmation.getConfirmationHeader().getMessageStatus()) {
            System.out.println("Request was successful.");
        } else {
            final ErrorType errorType = confirmation.getErrorData().getErrorType();
            final String errorValue = confirmation.getErrorData().getErrorValue();
            System.err.println(format("Request failed with errorType '%s' and errorValue '%s'.", errorType, errorValue));
        }
    }

    private static RequestData buildRequestData() {
        final AgencyId requesterAgencyId = new AgencyId();
        requesterAgencyId.setAgencyIdValue("Chicago Public Library");
        requesterAgencyId.setAgencyIdType(Version2017AgencyIdType.ISIL);
        final AgencyId supplyingAgencyId = new AgencyId();
        supplyingAgencyId.setAgencyIdValue("Dublin Public Library");
        supplyingAgencyId.setAgencyIdType(Version2017AgencyIdType.ISIL);
        final Header header = new Header();
        header.setRequestingAgencyId(requesterAgencyId);
        header.setRequestingAgencyRequestId("12345");
        header.setMultipleItemRequestId(""); // Bug in ISO 18626 schema - this field should be optional
        header.setSupplyingAgencyId(supplyingAgencyId);
        header.setTimestamp(Calendar.getInstance());
        final RequestData requestData = new RequestData();
        requestData.setHeader(header);

        final BibliographicRecordId bibliographicRecordId = new BibliographicRecordId();
        bibliographicRecordId.setBibliographicRecordIdentifier("777");
        bibliographicRecordId.setBibliographicRecordIdentifierCode(Version2017BibliographicRecordIdentifierCode.OCLC);
        final BibliographicInfo bibliographicInfo = new BibliographicInfo();
        bibliographicInfo.setBibliographicRecordIds(Collections.singletonList(bibliographicRecordId));
        requestData.setBibliographicInfo(bibliographicInfo);
        final ServiceInfo serviceInfo = new ServiceInfo();
        serviceInfo.setRequestType(RequestType.New);
        serviceInfo.setServiceType(ServiceType.Loan);
        requestData.setServiceInfo(serviceInfo);
        return requestData;
    }
}
``` 

## Getting Started with an ISO 18626 service
 
### Add Toolkit dependencies to your ISO 18626 service project
```xml
    <dependency>
      <groupId>org.oclc.circill.toolkit</groupId>
      <artifactId>binding-iso18626</artifactId>
      <version>0.25-SNAPSHOT</version>
    </dependency>
    <dependency>
      <groupId>org.oclc.circill.toolkit</groupId>
      <artifactId>common-ncip</artifactId>
      <version>0.25-SNAPSHOT</version>
    </dependency>
    <dependency>
      <groupId>org.oclc.circill.toolkit</groupId>
      <artifactId>dummy-jar</artifactId>
      <version>0.25-SNAPSHOT</version>
    </dependency>
    <dependency>
      <groupId>org.oclc.circill.toolkit</groupId>
      <artifactId>dummy-web</artifactId>
      <version>0.25-SNAPSHOT</version>
    </dependency>
    <dependency>
      <groupId>org.oclc.circill.toolkit</groupId>
      <artifactId>responder</artifactId>
      <version>0.25-SNAPSHOT</version>
    </dependency>
    <dependency>
      <groupId>org.oclc.circill.toolkit</groupId>
      <artifactId>service-base</artifactId>
      <version>0.25-SNAPSHOT</version>
    </dependency>
    <dependency>
      <groupId>org.oclc.circill.toolkit</groupId>
      <artifactId>service-iso18626</artifactId>
      <version>0.25-SNAPSHOT</version>
    </dependency>
    <!-- You can use other logging implementations. -->
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-log4j12</artifactId>
      <version>1.7.25</version>
    </dependency>
    <!-- You may already have some of these Spring dependencies in your project. -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-beans</artifactId>
      <version>4.3.14.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-core</artifactId>
      <version>4.3.14.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>4.3.14.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
      <version>4.3.14.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>4.3.14.RELEASE</version>
    </dependency>
```

### Implement your ISO 18626 Request service
The following is an example Java class that processes the ISO Request message and creates an ILL request in an dummy ILL system.
```java
package org.oclc.testtoolkit.internal.iso;

import org.oclc.circill.toolkit.service.base.RemoteServiceManager;
import org.oclc.circill.toolkit.service.base.Service;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ValidationException;
import org.oclc.circill.toolkit.service.iso18626.AgencyId;
import org.oclc.circill.toolkit.service.iso18626.ConfirmationHeader;
import org.oclc.circill.toolkit.service.iso18626.ISO18626Message;
import org.oclc.circill.toolkit.service.iso18626.MessageStatus;
import org.oclc.circill.toolkit.service.iso18626.RequestConfirmationData;
import org.oclc.circill.toolkit.service.iso18626.RequestData;
import org.oclc.circill.toolkit.service.iso18626.Version2017AgencyIdType;

import java.util.Calendar;

/**
 * Create a request in the ILL system.
 */
public class CreateRequestService implements Service<ISO18626Message<RequestData, RequestConfirmationData>, RequestData, RequestConfirmationData> {
    @Override
    public RequestConfirmationData performService(final RequestData requestData,
        final ServiceContext<ISO18626Message<RequestData, RequestConfirmationData>, RequestData, RequestConfirmationData> serviceContext,
        final RemoteServiceManager remoteServiceManager) throws ServiceException, ValidationException {

        // 1. Extract information from the Request message.
        final AgencyId requesterAgencyId = requestData.getHeader().getRequestingAgencyId();
        final String requester = requesterAgencyId.getAgencyIdValue();
        final String title = requestData.getBibliographicInfo().getTitle();
        // Get any other data from the incoming message to use when creating the ILL request.

        // 2. Create a request in the ILL system.
        final boolean success = createIllRequest(requester, title);

        // 3. Return a RequestConfirmation reporting the success or failure.
        final RequestConfirmationData requestConfirmationData = buildConfirmation(success, requestData);
        return requestConfirmationData;
    }

    /**
     * Create an ILL request in the local system.
     * Note: This is a stub implementation, and obviously more parameters would be required in an actual implementation.
     * @param requester symbol representing the requesting library
     * @param title title of the work requested
     * @return true if the request was created
     */
    private boolean createIllRequest(final String requester, final String title) {
        // Call your internal or proprietary API to create the ILL request.
        return true;
    }

    /**
     * Create the ISO 18626 confirmation message.
     */
    private RequestConfirmationData buildConfirmation(final boolean success, final RequestData requestData) {
        final ConfirmationHeader confirmationHeader = new ConfirmationHeader();
        confirmationHeader.setMessageStatus(success ? MessageStatus.OK : MessageStatus.ERROR);
        final AgencyId requesterAgencyId = requestData.getHeader().getRequestingAgencyId();
        confirmationHeader.setRequestingAgencyId(requesterAgencyId);
        final AgencyId supplyingAgencyId = new AgencyId();
        supplyingAgencyId.setAgencyIdType(Version2017AgencyIdType.ISIL);
        supplyingAgencyId.setAgencyIdValue("oclc-local");
        confirmationHeader.setSupplyingAgencyId(supplyingAgencyId);
        confirmationHeader.setMultipleItemRequestId(""); // Bug in ISO 18626 schema - this field should be optional
        confirmationHeader.setTimestamp(Calendar.getInstance());
        confirmationHeader.setTimestampReceived(requestData.getHeader().getTimestamp());
        final RequestConfirmationData requestConfirmationData = new RequestConfirmationData();
        requestConfirmationData.setConfirmationHeader(confirmationHeader);
        return requestConfirmationData;
    }
}
```
### Add Toolkit components to your ISO 18626 service webapp's configuration
- Copy the circill-iso18626-toolkit-web.xml file from the dummy/web/src/main/resources/ folder into your webapp's src/main/resources folder, and change the class of 
the "requestService" bean from this:
```xml
    <bean id="iso18626DummyService" class="org.oclc.circill.toolkit.dummy.DummyISO18626Service"/>

    <bean id="iso18626MessageHandler" class="org.oclc.circill.toolkit.dummy.SimpleMessageHandler">
        <constructor-arg name="service" ref="iso18626DummyService"/>
        <constructor-arg name="remoteServiceManager" ref="iso18626ServiceManager"/>
        <constructor-arg name="protocolHelper" ref="iso18626ProtocolHelper"/>
    </bean>
``` 
to this:
```xml
    <bean id="requestService" class="org.oclc.testtoolkit.internal.iso.CreateRequestService"/> <!-- Changed -->

    <bean id="iso18626MessageHandler" class="org.oclc.circill.toolkit.dummy.SimpleMessageHandler">
        <constructor-arg name="service" ref="requestService"/> <!-- Changed -->
        <constructor-arg name="remoteServiceManager" ref="iso18626ServiceManager"/>
        <constructor-arg name="protocolHelper" ref="iso18626ProtocolHelper"/>
    </bean>
```
### Add the Toolkit components to your ISO 18626 service webapp's web.xml file
```xml
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:circill-iso18626-toolkit-web.xml</param-value>
  </context-param>

  <!-- Your web.xml may already have the ContextLoaderListener. -->
  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>

  <servlet>
    <servlet-name>iso18626</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:empty.xml</param-value>
    </init-param>
    <load-on-startup>3</load-on-startup>
  </servlet>

  <servlet-mapping>
    <servlet-name>iso18626</servlet-name>
    <url-pattern>/iso18626/responder/*</url-pattern>
  </servlet-mapping>
```

### Deploy and test your ISO 18626 service
Build your webapp, deploy it to a container (e.g. tomcat, jetty, etc.) and test using the SimpleRequestClient in 
examples/src/main/java/org/oclc/circill/toolkit/examples/iso18626/ with these command-line parameters
```text
http://localhost:8080/iso18626/responder oclc-local 123456 "History of ISO 18626"
```
If you've followed the steps in **Getting Started with an ISO 18626 client**, you can use that client also.

## Getting Started with an NCIP client

### Add the Toolkit dependencies to your NCIP client project
```xml
        <dependency>
            <groupId>org.oclc.circill.toolkit</groupId>
            <artifactId>binding-ncipv2_02</artifactId>
            <version>0.25-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>org.oclc.circill.toolkit</groupId>
            <artifactId>service-base</artifactId>
            <version>0.25-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>org.oclc.circill.toolkit</groupId>
            <artifactId>service-ncip</artifactId>
            <version>0.25-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>org.oclc.circill.toolkit</groupId>
            <artifactId>service-ncip-common</artifactId>
            <version>0.25-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>org.oclc.circill.toolkit</groupId>
            <artifactId>initiator</artifactId>
            <version>0.25-SNAPSHOT</version>
        </dependency>
      <dependency>
          <groupId>org.slf4j</groupId>
          <artifactId>slf4j-log4j12</artifactId>
          <version>1.7.25</version>
      </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>4.3.14.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>4.3.14.RELEASE</version>
        </dependency>
```

### Add Toolkit components to your NCIP client application's configuration
Copy the circill-ncip-toolkit-client.xml file from the examples/src/main/resources folder into your application's src/main/resources folder.

### Send an NCIP RequestItem message from your NCIP client application
The following is an example Java client application that sends an NCIP RequestItem message to an NCIP responder. 
You can build & deploy the Circ/ILL Toolkit's dummy-webapp project to test your client, or you can follow the steps below for
[**Getting Started with an NCIP Responder**](#getting-started-with-an-ncip-responder).  Once you've deployed an NCIP responder just execute this class as a Java application. 
```java
package org.oclc.testnciptoolkit.client;

import org.oclc.circill.toolkit.initiator.client.HttpClient;
import org.oclc.circill.toolkit.initiator.servicemanager.HttpInitiatorServiceManager;
import org.oclc.circill.toolkit.initiator.servicemanager.HttpInitiatorServiceManagerImpl;
import org.oclc.circill.toolkit.service.base.Service;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.ncip.ItemId;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.NCIPResponseData;
import org.oclc.circill.toolkit.service.ncip.RequestItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.RequestItemResponseData;
import org.oclc.circill.toolkit.service.ncip.UserId;
import org.oclc.circill.toolkit.service.ncip.Version1RequestScopeType;
import org.oclc.circill.toolkit.service.ncip.Version1RequestType;
import org.oclc.circill.toolkit.service.ncip.common.AgencyId;
import org.oclc.circill.toolkit.service.ncip.common.FromAgencyId;
import org.oclc.circill.toolkit.service.ncip.common.InitiationHeader;
import org.oclc.circill.toolkit.service.ncip.common.ToAgencyId;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class ExampleNCIPClient {
    /**
     * Private constructor for utility class.
     */
    private ExampleNCIPClient() {
    }

    /**
     * Send an ISO 18626 Request message.
     * @param args ignored
     * @throws ToolkitException if there is a failure
     */
    public static void main(final String[] args) throws ToolkitException {
        // 1: Construct the Request message.
        final RequestItemInitiationData requestItemInitiationData = buildRequestItemInitiationData();

        // 2: Get the Toolkit client components from the application context.
        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("circill-ncip-toolkit-client.xml");
        final HttpClient client = (HttpClient) applicationContext.getBean("ncipClient");
        final Service<NCIPMessage<RequestItemInitiationData, RequestItemResponseData>, RequestItemInitiationData, RequestItemResponseData> service
            = (Service<NCIPMessage<RequestItemInitiationData, RequestItemResponseData>, RequestItemInitiationData, RequestItemResponseData>) applicationContext
            .getBean("ncipInitiatorService");
        final ServiceContext<NCIPMessage<RequestItemInitiationData, RequestItemResponseData>, RequestItemInitiationData, RequestItemResponseData> serviceContext
            = (ServiceContext<NCIPMessage<RequestItemInitiationData, RequestItemResponseData>, RequestItemInitiationData, RequestItemResponseData>) applicationContext
            .getBean("ncipServiceContext");

        // 3: Build a service manager for the target host.
        final HttpInitiatorServiceManager serviceManager = new HttpInitiatorServiceManagerImpl(client, "http://localhost:8080/ncip/responder");

        // 4: Send the Initiation message and get the Response.
        final NCIPResponseData responseData = service.performService(requestItemInitiationData, serviceContext, serviceManager);

        // 5: Determine whether the request was successful.
        if (CollectionUtils.isEmpty(responseData.getProblems())) {
            System.out.println("Request was successful.");
        } else {
            System.err.println("RequestItem failed:");
            responseData.getProblems().forEach(p -> {
                final String type = p.getProblemType().getValue();
                final String detail = p.getProblemDetail();
                final String element = p.getProblemElement();
                final String value = p.getProblemValue();
                System.err.println(format("Problem type '%s', detail '%s', element %s, value %s.", type, detail, element, value));
            });
        }
    }

    public static RequestItemInitiationData buildRequestItemInitiationData() throws ToolkitException {
        final RequestItemInitiationData requestItem = new RequestItemInitiationData();
        final AgencyId agencyId = new AgencyId("scheme", "2445");
        final InitiationHeader initHdr = new InitiationHeader();
        final ToAgencyId toAgencyId = new ToAgencyId();
        toAgencyId.setAgencyId(agencyId);
        initHdr.setToAgencyId(toAgencyId);
        final FromAgencyId fromAgencyId = new FromAgencyId();
        fromAgencyId.setAgencyId(agencyId);
        initHdr.setFromAgencyId(fromAgencyId);
        requestItem.setInitiationHeader(initHdr);
        final ItemId itemId = new ItemId();
        itemId.setItemIdentifierValue("255568102983");
        final List<ItemId> itemIdList = new ArrayList<>();
        itemIdList.add(itemId);
        requestItem.setItemIds(itemIdList);
        final UserId userId = new UserId();
        userId.setUserIdentifierValue("3555609213409");
        requestItem.setUserId(userId);
        requestItem.setRequestType(Version1RequestType.LOAN);
        requestItem.setRequestScopeType(Version1RequestScopeType.ITEM);
        return requestItem;
    }
}
```

## Getting Started with an NCIP responder

### Add Toolkit dependencies to your NCIP responder project
```xml
    <dependency>
      <groupId>org.oclc.circill.toolkit</groupId>
      <artifactId>binding-ncipv2_02</artifactId>
      <version>0.25-SNAPSHOT</version>
    </dependency>
    <dependency>
      <groupId>org.oclc.circill.toolkit</groupId>
      <artifactId>common-ncip</artifactId>
      <version>0.25-SNAPSHOT</version>
    </dependency>
    <dependency>
      <groupId>org.oclc.circill.toolkit</groupId>
      <artifactId>dummy-jar</artifactId>
      <version>0.25-SNAPSHOT</version>
    </dependency>
    <dependency>
      <groupId>org.oclc.circill.toolkit</groupId>
      <artifactId>dummy-web</artifactId>
      <version>0.25-SNAPSHOT</version>
    </dependency>
    <dependency>
      <groupId>org.oclc.circill.toolkit</groupId>
      <artifactId>service-base</artifactId>
      <version>0.25-SNAPSHOT</version>
    </dependency>
    <dependency>
      <groupId>org.oclc.circill.toolkit</groupId>
      <artifactId>service-ncip</artifactId>
      <version>0.25-SNAPSHOT</version>
    </dependency>
    <dependency>
      <groupId>org.oclc.circill.toolkit</groupId>
      <artifactId>service-ncip-common</artifactId>
      <version>0.25-SNAPSHOT</version>
    </dependency>
    <dependency>
      <groupId>org.oclc.circill.toolkit</groupId>
      <artifactId>responder</artifactId>
      <version>0.25-SNAPSHOT</version>
    </dependency>
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-log4j12</artifactId>
      <version>1.7.25</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-beans</artifactId>
      <version>4.3.14.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-core</artifactId>
      <version>4.3.14.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>4.3.14.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
      <version>4.3.14.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>4.3.14.RELEASE</version>
    </dependency>
```
### Implement your NCIP RequestItem responder service
The following is an example Java class that implements the NCIP RequestItem service and creates a hold in an dummy Circ system.
```java
package org.oclc.testtoolkit.internal.ncip;

import org.oclc.circill.toolkit.service.base.RemoteServiceManager;
import org.oclc.circill.toolkit.service.base.Service;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ValidationException;
import org.oclc.circill.toolkit.service.ncip.NCIPMessage;
import org.oclc.circill.toolkit.service.ncip.RequestId;
import org.oclc.circill.toolkit.service.ncip.RequestItemInitiationData;
import org.oclc.circill.toolkit.service.ncip.RequestItemResponseData;
import org.oclc.circill.toolkit.service.ncip.common.FromAgencyId;
import org.oclc.circill.toolkit.service.ncip.common.ResponseHeader;
import org.oclc.circill.toolkit.service.ncip.common.ToAgencyId;

import java.util.Random;

/**
 * Create a hold in the Circ system.
 */
public class RequestItemService implements Service<NCIPMessage<RequestItemInitiationData, RequestItemResponseData>, RequestItemInitiationData, RequestItemResponseData> {

    @Override
    public RequestItemResponseData performService(final RequestItemInitiationData requestItemInitiationData,
        final ServiceContext<NCIPMessage<RequestItemInitiationData, RequestItemResponseData>, RequestItemInitiationData, RequestItemResponseData> serviceContext,
        final RemoteServiceManager remoteServiceManager) throws ServiceException, ValidationException {

        // 1. Extract information from the RequestItem message.
        final String itemBarcode = requestItemInitiationData.getItemId().getItemIdentifierValue();
        final String userBarcode = requestItemInitiationData.getUserId().getUserIdentifierValue();

        // 2. Create a hold in the Circ system
        final String holdId = createCircHold(userBarcode, itemBarcode);

        // 3. Return a response reporting the success or failure.
        final RequestItemResponseData requestItemResponseData = buildResponse(holdId, requestItemInitiationData);
        return requestItemResponseData;
    }

    /**
     * Create a hold request in the Circ system.
     * Note: This is a stub implementation, and obviously more parameters would be required in an actual implementation.
     * @param userBarcode identifier of the user
     * @param itemBarcode identifier of the item to hold
     * @return true if the hold was created
     */
    private String createCircHold(final String userBarcode, final String itemBarcode) {
        // Call your internal or proprietary API to create the hold
        return Integer.toString((new Random()).ints().findAny().getAsInt());
    }

    /**
     * Create the NCIP RequestItemResponse message
     */
    private RequestItemResponseData buildResponse(final String holdId, final RequestItemInitiationData requestItemInitiationData) {
        final RequestItemResponseData requestItemResponseData = new RequestItemResponseData();
        final ToAgencyId toAgencyId = requestItemInitiationData.getInitiationHeader().getToAgencyId();
        final FromAgencyId fromAgencyid = requestItemInitiationData.getInitiationHeader().getFromAgencyId();
        final ResponseHeader responseHeader = new ResponseHeader();
        responseHeader.setToAgencyId(toAgencyId);
        responseHeader.setFromAgencyId(fromAgencyid);
        requestItemResponseData.setResponseHeader(responseHeader);
        final RequestId requestId = new RequestId();
        requestId.setRequestIdentifierValue(holdId);
        requestItemResponseData.setRequestId(requestId);
        requestItemResponseData.setItemId(requestItemInitiationData.getItemId());
        requestItemResponseData.setUserId(requestItemInitiationData.getUserId());
        requestItemResponseData.setRequestType(requestItemInitiationData.getRequestType());
        requestItemResponseData.setRequestScopeType(requestItemInitiationData.getRequestScopeType());
        return requestItemResponseData;
    }
}
```

### Add Toolkit components to your NCIP responder webapp's configuration
- Copy the circill-ncip-toolkit-web.xml file from the dummy/web/src/main/resources/ folder into your webapp's src/main/resources folder, and change the class of 
the "requestItemService" bean from this:
```xml
    <bean id="ncipDummyService" class="org.oclc.circill.toolkit.dummy.DummyNCIPService"/>

    <bean id="ncipMessageHandler" class="org.oclc.circill.toolkit.dummy.SimpleMessageHandler">
        <constructor-arg name="service" ref="ncipDummyService"/>
        <constructor-arg name="remoteServiceManager" ref="ncipServiceManager"/>
        <constructor-arg name="protocolHelper" ref="ncipProtocolHelper"/>
    </bean>
``` 
to this:
```xml
    <bean id="ncipRequestItemService" class="org.oclc.testtoolkit.internal.ncip.RequestItemService"/> <!-- Changed -->

    <bean id="ncipMessageHandler" class="org.oclc.circill.toolkit.dummy.SimpleMessageHandler">
        <constructor-arg name="service" ref="ncipRequestItemService"/> <!-- Changed -->
        <constructor-arg name="remoteServiceManager" ref="ncipServiceManager"/>
        <constructor-arg name="protocolHelper" ref="ncipProtocolHelper"/>
    </bean>
```

### Add the Toolkit components to your NCIP responder webapp's web.xml file
```xml
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:circill-ncip-toolkit-web.xml</param-value>
  </context-param>

  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>

  <servlet>
    <servlet-name>ncip</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:empty.xml</param-value>
    </init-param>
    <load-on-startup>3</load-on-startup>
  </servlet>

  <servlet-mapping>
    <servlet-name>ncip</servlet-name>
    <url-pattern>/ncip/responder/*</url-pattern>
  </servlet-mapping>
```

### Deploy and test your NCIP responder
Build your webapp, deploy it to a container (e.g. tomcat, jetty, etc.) and test using the SimpleRequestItemClient in 
examples/src/main/java/org/oclc/circill/toolkit/examples/ncip/:
```text
http://localhost:8080/ncip/responder itembarcode userbarcode
```
If you've followed the steps in **Getting Started with an NCIP client**, you can use that client also.

## Using the Configurable Service:
The CircILL-Toolkit includes a configurable server that will respond to both NCIP and ISO 18626 messages. 
See [here](dummy/webapp/src/test/resources/HowToUseConfigurableService.md)

## License

This project is licensed under the MIT License - see the [LICENSE.txt](LICENSE.txt) file for details

## Known issues
None at this time.

## Roadmap
### Support ISO 18626 Version 2021
This version has been ballotted by committee members and we expect it to be approved around the end of 2020, beginning of 2021.

## Credits
The eXtensible Catalog Organization's NCIP 2 Toolkit team.

The developers at OCLC.
