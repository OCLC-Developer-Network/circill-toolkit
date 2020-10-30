/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.binding;

import org.oclc.circill.toolkit.common.base.ConfigurationHelper;
import org.oclc.circill.toolkit.common.base.ServiceContextFactory;
import org.oclc.circill.toolkit.common.base.StatisticsBean;
import org.oclc.circill.toolkit.common.base.ToolkitComponent;
import org.oclc.circill.toolkit.common.base.Translator;
import org.oclc.circill.toolkit.service.base.SchemeValuePair;
import org.oclc.circill.toolkit.service.base.ServiceContext;
import org.oclc.circill.toolkit.service.base.ServiceException;
import org.oclc.circill.toolkit.service.base.ServiceInitiationData;
import org.oclc.circill.toolkit.service.base.ServiceMessage;
import org.oclc.circill.toolkit.service.base.ServiceResponseData;
import org.oclc.circill.toolkit.service.base.ToolkitException;
import org.oclc.circill.toolkit.service.base.ToolkitHelper;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.castor.xmlctf.xmldiff.XMLDiff;
import org.junit.Assert;
import org.w3c.dom.Document;

/**
 * This class performs round-trip verification of sample messages. For each message in the sample files directory this will:
 * <ol>
 *     <li>Read the file into an {@link InputStream}.</li>
 *     <li>Pass that stream to {@link Translator#createResponseData(ServiceContext, InputStream)} if the filename contains "Response", otherwise to
 *     {@link Translator#createInitiationData(ServiceContext, InputStream)}.</li>
 *     <li>If that call returns a non-null object, it passes that object to {@link Translator#createResponseMessageStream(ServiceContext, ServiceResponseData)} or
 *     {@link Translator#createInitiationMessageStream(ServiceContext, ServiceInitiationData)}, effectively doing the reverse of what the previous call did.</li>
 *     <li>It then pretty-prints the {@link InputStream} returned by that call to a temporary file and performs an XML infoset comparison on that temporary file and the input
 *     file. An XML Infoset comparison compares the information in the XML document, thus abstracting from differences that may appear in a text form of the XML, e.g. different
 *     namespace aliases for the same namespace URI.</li>
 *     <li>If the XML Infosets match, the test (for that file) passes; if not it then does a command-line diff of the two files to produce a report of the lines which are
 *     different. For this last difference to work well (i.e. to indicate only significant differences), the input file may have to be modified to align with the format of the
 *     output, e.g.
 *     <ul>
 *         <li>Namespace aliases need to match.</li>
 *         <li>The order of attributes on the root element need to match.</li>
 *         <li>The line breaks between attributes needs to match.</li>
 *         <li>Comments will be omitted from the temporary file.</li>
 *         <li>Elements with an empty content model (e.g. ResourceDesired) will be represented as </li>
 *     </ul>
 *     Note: you need not make the above adjustments to get a test to pass; but when a test fails the diff output will include these extraneous differences, and it may be easier
 *     to understand
 *     the diff output without them and then restore e.g., the comments, once the test passes.<p>
 *     See also the NotesOnFormatting.txt file in the src/test folder of the binding-common project.
 *     </li>
 * </ol>
 * <p>
 * The available run-time properties to control the execution are listed below. All property names are preceded by this class's full name but this is omitted here.
 * For example, to set the file names pattern you would set the property {@code org.oclc.circill.toolkit.binding.jaxb.dozer.BaseTestTranslator.fileNamesPattern="*NewFiles*
 * .xml"}.
 * <ul>
 *     <li><b>performXMLDiff</b>: whether to perform the XML difference or not. If true the comparisons described above will be performed, if false the test only verifies that
 *     the Toolkit can round-trip the XML without exception, not whether the round-trip was loss-less. <b>Default</b>: true</li>
 *     <li><b>diffCommand</b>: The 'diff' command to perform the file difference. <b>Default</b>: diff</li>
 *     <li><b>diffParms</b>: Any parameters the diff command may need. <b>Default</b>: (empty string)</li>
 *     <li><b>deleteTempFiles</b>: Delete temporary XML files. Set to 'false' if you want to be able to examine the temporary files after the test program completes.
 *     <b>Default</b>: true</li>
 *     <li><b>sampleFilesDir</b>: Directory with sample files. <b>Default</b>: src/test/data/sampleMessages</li>
 *     <li><b>fileNamesPattern</b>: The regex expression (as a Java String) that identifies which files in the sampleFilesDir should be processed. <b>Default</b>: {@literal "
 *     .*\\.xml"}</li>
 *     <li><b>fileNamesToOmitPattern</b>: The regex expression (as a Java String) that identifies which files (that are included by the fileNamesPattern) should be omitted.
 *     <b>Default</b>: (null)</li>
 *     <li><b>iterations</b>: The number of iterations of the test process to perform. The tests emit timing data and this can be used for a crude performance measure.
 *     <b>Default</b>: 1</li>
 *     <li><b>threads</b>: The number of threads to start, each thread will perform as many iterations as the <b>iterations</b> property. <b>Default</b>: 1</li>
 * </ul>
 * <p>
 * This is an example of the output when the command-line diff is run:
 * <pre>{@code junit.framework.AssertionFailedError: One or more messages failed:
 * XML objects differ for WSILLLookupUserResponseSample1.xml.
 * performXMLDiff detected differences for WSILLLookupUserResponseSample1.xml:
 * Input XML file (on the left) is not matched by result XML file (on the right):
 * 2,4c2,5
 * < <ns1:NCIPMessage ns1:version="http://www.niso.org/schemas/ncip/v2_02/ncip_v2_02.xsd"
 * <                  xmlns:ns1="http://www.niso.org/2008/ncip"
 * <                  xmlns:ns2="http://www.oclc.org/ncip/ws_ill/2015"
 * ---
 * > <ns2:NCIPMessage
 * >     ns2:version="http://www.niso.org/schemas/ncip/v2_02/ncip_v2_02.xsd"
 * >     xmlns="http://www.oclc.org/ncip/ws_ill/2015"
 * >     xmlns:ns2="http://www.niso.org/2008/ncip"
 * }</pre>In the above example the NCIP XML Schema namespace is given the "ns1" alias in the input file, but the Toolkit assigns it the alias "ns2". The simplest solution is to
 * change the aliases in the sample file to match the ones assigned by the Toolkit.
 * Additionally, the Toolkit outputs each attribute on its own line; you should modify the XML files to match.
 * This diffierence is not enough to cause the test to fail, as the namespaces, not the aliases, are what is seen by the XML infoset comparison. These modifications will merely
 * elminate them from the output of the diff command, making it easier to notice the remaining, significant differences.
 * The next part of the output shows the significant difference:
 * <pre>{@code 46d46
 * <                   <ns2:IsExpired/>
 * }</pre>This indicates that the IsExpired element on line 46 in the input is <em>not</em> in the output. This suggests that the binding process (unmarshalling from the XML file
 * to JAXB classes, mapping from JAXB to the service classes, mapping from the service classes back to JAXB, and marshalling from JAXB to the XML temporary file) has a bug (e.g.
 * the IsExpired element was not added to the Dozer mapping file or the appropriate service class).
 * <p>
 * <b>Note</b>: As stated above, these formatting requirements <b>are not</b> requirements of the Toolkit for normal processing of messages; they are only requirements on the
 * format
 * of the sample XML files used in these tests, and even then only if you want to simplify the output from the diff utility when debugging a problem in the binding package.
 */
public abstract class BaseTestTranslator<SM extends ServiceMessage<ID, RD>, ID extends ServiceInitiationData, RD extends ServiceResponseData> implements Runnable {

    private static final Logger LOG = Logger.getLogger(BaseTestTranslator.class);

    private static final String DEFAULT_FILENAMES_PATTERN = ".*\\.xml";

    private static final String DEFAULT_FILENAMES_TO_OMIT_PATTERN = null;

    private static final String DIFFXML_CLASS_NAME = "org.diffxml.diffxml.DiffFactory";

    protected static final boolean performXMLDiff = Boolean.parseBoolean(System.getProperty(BaseTestTranslator.class.getName() + ".performXMLDiff", "true"));

    protected static final boolean reportDiffAsXMLIndented = Boolean.getBoolean(BaseTestTranslator.class.getName() + ".reportDiffAsXMLIndented");

    protected static final String diffCommand = System.getProperty(BaseTestTranslator.class.getName() + ".diffCommand", "diff");

    protected static final String diffParms = System.getProperty(BaseTestTranslator.class.getName() + ".diffParms", "-w");

    protected static final boolean deleteTempFiles = Boolean.parseBoolean(System.getProperty(BaseTestTranslator.class.getName() + ".deleteTempFiles", "true"));

    protected final Translator<SM, ID, RD> translator;
    /**
     * The {@link StatisticsBean} instance used to report performance data.
     */
    protected final StatisticsBean statisticsBean;

    protected final ServiceContextFactory serviceContextFactory;

    {
        SchemeValuePair.clearBehaviors();

        try {
            translator = ConfigurationHelper.getComponent(ToolkitComponent.TRANSLATOR_COMPONENT_NAME);
            statisticsBean = ConfigurationHelper.getComponent(ToolkitComponent.STATISTICS_BEAN_COMPONENT_NAME);
            serviceContextFactory = ConfigurationHelper.getComponent(ToolkitComponent.SERVICE_CONTEXT_FACTORY_COMPONENT_NAME);
        } catch (ToolkitException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    static class Stats {
        long initTranslateStreamToSvcElapsedTime = 0;
        long respTranslateStreamToSvcElapsedTime = 0;
        long initTranslateSvcToStreamElapsedTime = 0;
        long respTranslateSvcToStreamElapsedTime = 0;
        long initMsgStreamToSvcCount = 0;
        long respMsgStreamToSvcCount = 0;
        long initMsgSvcToStreamCount = 0;
        long respMsgSvcToStreamCount = 0;
    }

    public void doTest() throws FileNotFoundException, ToolkitException, ServiceException {

        LOG.info("Entered doTest for " + this.getClass().getName());

        final String sampleFilesDirectory = System.getProperty(BaseTestTranslator.class.getName() + ".sampleFilesDir", "src/test/data/sampleMessages");
        if (sampleFilesDirectory == null) {
            Assert.fail("Test failed because system property " + BaseTestTranslator.class.getName()
                + ".sampleFilesDir was not set. It must be set to a directory containing sample messages.");
        }

        final String fileNamesPattern = System.getProperty(BaseTestTranslator.class.getName() + ".fileNamesPattern", DEFAULT_FILENAMES_PATTERN);
        final String fileNamesToOmitPattern = System.getProperty(BaseTestTranslator.class.getName() + ".fileNamesToOmitPattern", DEFAULT_FILENAMES_TO_OMIT_PATTERN);
        int iterations = 1;
        final String iterationsString = System.getProperty(BaseTestTranslator.class.getName() + ".iterations");
        if (iterationsString != null) {
            iterations = Integer.parseInt(iterationsString);
        }

        final File dir = new File(sampleFilesDirectory);
        LOG.debug(
            "Looking for sample files in " + dir.getAbsolutePath() + ", with pattern " + fileNamesPattern + " and omit pattern " + fileNamesToOmitPattern + "; doing " + iterations
                + " iteration(s).");

        final FileFilter fileFilter = File::isFile;
        final StringBuilder failuresList = new StringBuilder();
        final File[] files = dir.listFiles(fileFilter);
        final Stats stats = new Stats();

        if (files != null) {
            for (int iteration = 0; iteration < iterations; ++iteration) {
                for (final File file : files) {
                    final String fileName = file.getName();
                    if (processFile(fileName, fileNamesPattern, fileNamesToOmitPattern)) {
                        final InputStream inStream = new FileInputStream(file);
                        LOG.info("Testing " + fileName);
                        final ServiceContext<SM, ID, RD> serviceContext = serviceContextFactory.getInitialServiceContext();
                        if (fileName.contains("Response") || fileName.contains("Confirmation")) {
                            handleResponse(fileName, file, inStream, serviceContext, stats, failuresList);
                        } else {
                            handleInitiation(fileName, file, inStream, serviceContext, stats, failuresList);
                        }
                    }
                }
            }
            Assert.assertEquals("One or more messages failed:" + System.lineSeparator() + failuresList, 0, failuresList.length());
        } else {
            Assert.fail(
                "No files were found in " + sampleFilesDirectory + ". Note: do not include a trailing slash in the path." + "Working directory: " + System.getProperty("user.dir"));
        }

        LOG.info("Elapsed time for translating stream-to-service for initiation messages: " + stats.initTranslateStreamToSvcElapsedTime + " for " + stats.initMsgStreamToSvcCount
            + " messages; average " + computeAverage(stats.initTranslateStreamToSvcElapsedTime, stats.initMsgStreamToSvcCount));
        LOG.info("Elapsed time for translating stream-to-service for response messages: " + stats.respTranslateStreamToSvcElapsedTime + " for " + stats.respMsgStreamToSvcCount
            + " messages; average " + computeAverage(stats.respTranslateStreamToSvcElapsedTime, stats.respMsgStreamToSvcCount));
        LOG.info("Elapsed time for translating service-to-stream for initiation messages: " + stats.initTranslateSvcToStreamElapsedTime + " for " + stats.initMsgSvcToStreamCount
            + " messages; average " + computeAverage(stats.initTranslateSvcToStreamElapsedTime, stats.initMsgSvcToStreamCount));
        LOG.info("Elapsed time for translating service-to-stream for response messages: " + stats.respTranslateSvcToStreamElapsedTime + " for " + stats.respMsgSvcToStreamCount
            + " messages; average " + computeAverage(stats.respTranslateSvcToStreamElapsedTime, stats.respMsgSvcToStreamCount));

        final String statsReport = statisticsBean.createCSVReport();
        System.out.println(statsReport);

    }

    private static boolean processFile(final String fileName, final String fileNamesPattern, final String fileNamesToOmitPattern) {
        final boolean fileNameMatchesPattern = fileNamesPattern == null || fileNamesPattern.length() == 0 || fileName.matches(fileNamesPattern);
        final boolean fileDoesntMatchOmitPattern = fileNamesToOmitPattern == null || fileNamesToOmitPattern.length() == 0 || !fileName.matches(fileNamesToOmitPattern);
        return fileNameMatchesPattern && fileDoesntMatchOmitPattern;
    }

    private void handleInitiation(final String fileName, final File file, final InputStream inStream, final ServiceContext<SM, ID, RD> serviceContext, final Stats stats,
        final StringBuilder failuresList) throws ToolkitException {

        try {

            long startTime = System.currentTimeMillis();
            final ID initiationData = translator.createInitiationData(serviceContext, inStream);
            long endTime = System.currentTimeMillis();
            stats.initTranslateStreamToSvcElapsedTime += (endTime - startTime);
            stats.initMsgStreamToSvcCount++;

            Assert.assertNotNull("createInitiationData returned null for " + fileName + ".", initiationData);

            try {

                startTime = System.currentTimeMillis();
                final InputStream initiationStream = translator.createInitiationMessageStream(serviceContext, initiationData);
                Assert.assertNotNull(initiationStream);
                endTime = System.currentTimeMillis();
                stats.initTranslateSvcToStreamElapsedTime += (endTime - startTime);
                stats.initMsgSvcToStreamCount++;

                if (performXMLDiff) {
                    performXMLDiff(initiationStream, failuresList, file);
                }

            } catch (ServiceException e) {
                LOG.debug("Exception in createInitiationMessageStream for '" + fileName + "'.", e);
                failuresList.append(collectException("createInitiationMessageStream", fileName, e));
            }

        } catch (ServiceException e) {
            LOG.debug("Exception in createInitiationData for '" + fileName + "'.", e);
            failuresList.append(collectException("createInitiationData", fileName, e));
        }

    }

    private void handleResponse(final String fileName, final File file, final InputStream inStream, final ServiceContext<SM, ID, RD> serviceContext, final Stats stats,
        final StringBuilder failuresList) throws ToolkitException {

        try {

            long startTime = System.currentTimeMillis();
            final RD responseData = translator.createResponseData(serviceContext, inStream);
            long endTime = System.currentTimeMillis();
            stats.respTranslateStreamToSvcElapsedTime += (endTime - startTime);
            stats.respMsgStreamToSvcCount++;

            Assert.assertNotNull("createResponseData returned null for " + fileName + ".", responseData);

            try {

                startTime = System.currentTimeMillis();
                final InputStream responseStream = translator.createResponseMessageStream(serviceContext, responseData);
                endTime = System.currentTimeMillis();
                stats.respTranslateSvcToStreamElapsedTime += (endTime - startTime);
                stats.respMsgSvcToStreamCount++;

                Assert.assertNotNull(responseStream);

                if (performXMLDiff) {
                    performXMLDiff(responseStream, failuresList, file);
                }

            } catch (ServiceException e) {
                LOG.debug("Exception in createResponseMessageStream for '" + fileName + "'.", e);
                failuresList.append(collectException("createResponseMessageStream", fileName, e));
            }

        } catch (ServiceException e) {
            LOG.debug("Exception in createResponseData for '" + fileName + "'.", e);
            failuresList.append(collectException("createResponseData", fileName, e));
        }

    }

    protected static float computeAverage(final long dividend, final long divisor) {
        if (divisor != 0) {
            return dividend / divisor;
        } else {
            return Float.MAX_VALUE;
        }
    }

    protected static StringBuilder collectException(final String methodName, final String fileName, final Throwable e) {
        final StringBuilder message = new StringBuilder(ToolkitHelper.convertExceptionToString(e));
        message.append("' in '").append(methodName).append("' converting the sample file ").append(fileName).append(".").append(System.lineSeparator());
        return message;
    }

    protected void performXMLDiff(final InputStream msgStream, final StringBuilder failuresList, final File file) throws ServiceException {

        LOG.debug("Performing diff on " + file.getName());

        final String fileName = file.getName();

        try {

            final File prettyPrintedXMLFile = File.createTempFile("BaseTestTranslator", ".xml");
            if (deleteTempFiles) {
                prettyPrintedXMLFile.deleteOnExit();
            }

            final Writer outWriter;
            try {

                outWriter = new FileWriter(prettyPrintedXMLFile);

            } catch (IOException e) {

                throw new ServiceException("IOException performing XML diff.", e);

            }

            ToolkitHelper.prettyPrintXML(msgStream, outWriter);

            //doXMLDiff(failuresList, fileName, file, prettyPrintedXMLFile);
            doCastorXMLDiff(failuresList, fileName, file, prettyPrintedXMLFile);

        } catch (IOException | ToolkitException e) {

            failuresList.append(collectException("performXMLDiff", fileName, e));

        }

    }

    private void doCastorXMLDiff(final StringBuilder failuresList, final String originalFileName, final File originalFile, final File prettyPrintedXMLFile)
        throws ServiceException {

        LOG.info("Performing Castor XML diff on '" + prettyPrintedXMLFile.getAbsolutePath() + "' and '" + originalFile.getAbsolutePath() + "'.");
        final XMLDiff diff = new XMLDiff(prettyPrintedXMLFile.getAbsolutePath(), originalFile.getAbsolutePath());
        int result = 0;
        try {
            result = diff.compare();
        } catch (IOException e) {
            failuresList.append(collectException("doCastorXMLDiff", originalFileName, e));
        }
        if (result != 0) {
            failuresList.append("XML objects differ for ").append(originalFileName).append(".").append(System.lineSeparator());
            doFileDiff(failuresList, originalFileName, originalFile, prettyPrintedXMLFile);
        }

    }

    // Note: Replace the call to doCastorXMLDiff with this if you think Castor's XML diff isn't working correctly,
    // Because the org.diffxml.diffxml uses a GNU License, not an MIT license,
    // it is not provided as part of the Toolkit, we use reflection to invoke
    // it here so we can avoid problems compiling this class in the absence of that
    // package. Note that, if the package is absent this "diff" will be silently
    // skipped.
    private void doXMLDiff(final StringBuilder failuresList, final String originalFileName, final File originalFile, final File prettyPrintedXMLFile) {
        try {
            // The following 3 lines or code are equivalent to this:
            // Diff diffInstance = DiffFactory.createDiff();
            final Class<?> diffFactoryClass = Class.forName(DIFFXML_CLASS_NAME);

            try {

                final Method createDiffMethod = diffFactoryClass.getMethod("createDiff");
                final Object diffInstance = createDiffMethod.invoke(null);

                // The following 2 lines of code are equivalent to this:
                // Document delta = diffInstance.diff(file, temp);
                final Method diffMethod = diffInstance.getClass().getMethod("diff", File.class, File.class);
                final Document deltaDocument = (Document) diffMethod.invoke(diffInstance, originalFile, prettyPrintedXMLFile);

                if (deltaDocument.getDocumentElement().hasChildNodes()) {

                    if (reportDiffAsXMLIndented) {

                        final OutputStream byteStream = new ByteArrayOutputStream();
                        // DOMOps.outputXMLIndented(deltaDocument, byteStream);
                        final Class<?> DOMOpsClass = Class.forName("org.diffxml.diffxml.DOMOps");
                        final Method outputXMLIndentedMethod = DOMOpsClass.getMethod("outputXMLIndented", Document.class, OutputStream.class);
                        outputXMLIndentedMethod.invoke(null, deltaDocument, byteStream);

                        failuresList.append(new StringBuilder().append("performXMLDiff detected differences for ").append(originalFileName).append(":\n").append('\t')
                            .append("Result XML file does not match input:\n").append(byteStream.toString())).append('\n');

                    } else {

                        doFileDiff(failuresList, originalFileName, originalFile, prettyPrintedXMLFile);

                    }

                }

            } catch (Exception e) {

                failuresList.append(collectException("performXMLDiff", originalFileName, e));

            }
        } catch (ClassNotFoundException e) {

            LOG.warn("ClassNotFoundException trying to load " + DIFFXML_CLASS_NAME + ". Skipping diffXML comparison. Exception was:", e);

        } finally {

            if (deleteTempFiles) {
                prettyPrintedXMLFile.delete();
            }

        }
    }

    private void doFileDiff(final StringBuilder failuresList, final String originalFileName, final File originalFile, final File prettyPrintedXMLFile) {

        try {
            final String[] parms;
            int parmsIndex = 0;
            if (diffParms != null && !diffParms.isEmpty()) {
                final String[] diffParmsArray = diffParms.split(" ");
                parms = new String[diffParmsArray.length + 2];
                for (final String diffParm : diffParmsArray) {
                    parms[parmsIndex++] = diffParm;
                }
            } else {
                parms = new String[2];
            }
            parms[parmsIndex++] = originalFile.getAbsolutePath();
            parms[parmsIndex++] = prettyPrintedXMLFile.getAbsolutePath();

            final String diffOutput = runCmd(diffCommand, parms);
            if (diffOutput != null && diffOutput.length() > 0) {

                failuresList.append(new StringBuilder().append("performXMLDiff detected differences for ").append(originalFileName).append(":\n").append('\t')
                    .append("Input XML file (on the left) is not matched ").append("by result XML file (on the right):\n").append(diffOutput));

            } else {
                LOG.info("Diff output is null or empty.");
            }

        } catch (ServiceException e) {

            failuresList.append(collectException("performXMLDiff", originalFileName, e));

        }
    }

    public static String runCmd(final String command, final String[] parms) throws ServiceException {
        String result = "";
        try {
            final String osName = System.getProperty("os.name");
            LOG.debug("OS name: " + osName);
            final String[] cmd;
            int nextParm;
            if ("Windows NT".equals(osName) || "Windows XP".equals(osName)) {
                cmd = new String[3 + parms.length];
                cmd[0] = "cmd.exe";
                cmd[1] = "/C";
                nextParm = 2;
            } else if ("Windows 95".equals(osName)) {
                cmd = new String[3 + parms.length];
                cmd[0] = "command.com";
                cmd[1] = "/C";
                nextParm = 2;
            } else { // Assuming that else is unix or unix-like in this regard of not needing an explicit shell program.
                cmd = new String[1 + parms.length];
                nextParm = 0;
            }

            // Example values to use for 'command' here:
            //   If using cygwin on a Windows OS:
            //     "c:\\cygwin\\bin\\telnet.exe 192.168.1.101"
            //     "c:\\cygwin\\bin\\expect.exe /tmp/telnettojbdesktop.exp"
            //   If using a Unix (I'm guessing here):
            //     "telnet 192.168.1.101"
            //     "expect /tmp/telnettojbdesktop.exp"
            cmd[nextParm++] = command;

            for (final String p : parms) {
                cmd[nextParm++] = p;
            }

            if (LOG.isDebugEnabled()) {
                final StringBuilder buffer = new StringBuilder("Executing ");
                for (final String a : cmd) {
                    buffer.append(a).append(" ");
                }
                LOG.debug(buffer.toString());
            }

            final Runtime rt = Runtime.getRuntime();
            final Process proc = rt.exec(cmd);

            final StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "ERROR");

            final StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "OUTPUT");

            errorGobbler.start();
            outputGobbler.start();

            // This is the stream used to pass INPUT to the process. (It's called the "output stream" because
            // it's an *output* stream from the perspective of this class.)
            final OutputStream outputStream = proc.getOutputStream();

            final int exitVal = proc.waitFor();
            if (exitVal != 0) {
                LOG.error("Exit value from " + cmd[2] + ": " + exitVal);
            }

            final String stdErr = errorGobbler.getBuffer();
            if (stdErr.length() > 0) {
                result = stdErr;
            }

            final String stdOut = outputGobbler.getBuffer();
            if (stdOut.length() > 0) {
                // It's intentional that stdOut replaces what was in stdErr if there *is* anything in stdOut.
                result = stdOut;
            }
        } catch (Throwable t) {
            throw new ServiceException("Exception running external diff command.", t);
        }
        return result;
    }

    @Override
    public void run() {

        try {

            doTest();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    static class StreamGobbler extends Thread {
        final InputStream is;
        final String type;
        final StringBuffer stringBuffer = new StringBuffer();

        StreamGobbler(final InputStream is, final String type) {
            this.is = is;
            this.type = type;
        }

        @Override
        public void run() {
            try {
                final InputStreamReader isr = new InputStreamReader(is);
                final BufferedReader br = new BufferedReader(isr);
                String line;
                while ((line = br.readLine()) != null) {
                    stringBuffer.append(line).append(System.lineSeparator());
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        public String getBuffer() {
            return stringBuffer.toString();
        }
    }

}
