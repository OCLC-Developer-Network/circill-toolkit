/*
 * Copyright (c) 2010 eXtensible Catalog Organization.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the MIT/X11 license. The text of the license can be
 * found at http://www.opensource.org/licenses/mit-license.php.
 */

package org.oclc.circill.toolkit.common.base;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

/**
 * Retains &amp; reports statistics on timing of steps in the Toolkit processing of a request.
 */
public class StatisticsBean implements ToolkitComponent {

    private static final Logger LOG = Logger.getLogger(StatisticsBean.class);

    private static final char COMMA = ',';
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");
    private static final int INITIAL_CSV_REPORT_SIZE = 1000;
    private static final String UNKNOWN_STEP_TEXT = "Unknown";

    /**
     * The steps in the processing of a message and its response.
     */
    public enum Step { UNMARSHAL_MESSAGE, CREATE_DATA, PERFORM_SERVICE, CREATE_MESSAGE, MARSHAL_MESSAGE, TOTAL }

    /**
     * Labels for the steps.
     */
    private static final EnumMap<Step, String> STEP_LABELS = new EnumMap<>(Step.class);
    static {
        STEP_LABELS.put(Step.UNMARSHAL_MESSAGE, "Unmarshal Message");
        STEP_LABELS.put(Step.CREATE_DATA, "Create Data From Message");
        STEP_LABELS.put(Step.PERFORM_SERVICE, "Perform Service");
        STEP_LABELS.put(Step.CREATE_MESSAGE, "Create Message From Data");
        STEP_LABELS.put(Step.MARSHAL_MESSAGE, "Marshal Message");
        STEP_LABELS.put(Step.TOTAL, "Total");
    }

    /** The collection of StatsRecords grouped by step and within steps by label. */
    private final Map<Step, Map<String, StatsRecord>> statisticsMap = Collections.synchronizedMap(new TreeMap<>());
    /** The separator between lines in the CSV report. */
    private static final String LINE_SEPARATOR = System.lineSeparator();
    /** The date/time at which the current counts were started. */
    protected LocalDateTime startDateTime = LocalDateTime.now();

    /**
     * Holds values for a particular statistics ("key").
     */
    public class StatsRecord {

        protected final Step step;
        protected final String label;
        protected long count;
        protected long totalIntervals;

        /**
         * Create a StatsRecord.
         * Note: This implementation makes a copy of the labels array.
         * @param step the {@link Step}
         * @param label the label for this record
         * @param startTime the start time for this stat
         * @param endTime the end time for this stat
         */
        public StatsRecord(final Step step, final String label, final long startTime, final long endTime) {
            this.step = step;
            this.label = label;
            add(startTime, endTime);
        }

        /**
         * Get the label.
         * @return the label
         */
        public String getLabel() {
            return this.label;
        }

        /**
         * Get the count of intervals in the record.
         * @return the count of intervals
         */
        public long getCount() {
            return this.count;
        }

        /**
         * Get the total of all intervals in the record.
         * @return the total of intervals
         */
        public long getTotalIntervals() {
            return this.totalIntervals;
        }

        /**
         * Add an interval (endTime - startTime) to the record and increment the count of intervals.
         * @param startTime -
         * @param endTime -
         */
        public final void add(final long startTime, final long endTime) {
            this.count++;
            this.totalIntervals += Math.max(endTime - startTime, 0);
        }
    }

    /**
     * Get the {@link ToolkitComponent} name.
     * @return the name
     */
    @Override
    public String getComponentName() {
        return ToolkitComponent.STATISTICS_BEAN_COMPONENT_NAME;
    }

    /**
     * Record an event's statistics.
     * @param step the step
     * @param startTime the start time of the step
     * @param endTime the end time of the step
     * @param label a label for the step
     */
    public synchronized void record(final Step step, final long startTime, final long endTime, final String label) {

        LOG.debug(step + " " + label + ": " + (endTime - startTime) + " milliseconds.");

        Map<String, StatsRecord> statsRecordMap = statisticsMap.get(step);
        if (statsRecordMap == null) {
            statsRecordMap = new TreeMap<>();
            statisticsMap.put(step, statsRecordMap);
        }

        final StatsRecord statsRecord = statsRecordMap.get(label);
        if (statsRecord == null) {
            statsRecordMap.put(label, new StatsRecord(step, label, startTime, endTime));
        } else {
            statsRecord.add(startTime, endTime);
        }

    }

    /**
     * Get the {@link StatsRecord}s.
     * @return the records
     */
    public Map<Step, Map<String, StatsRecord>> getStatsRecords() {
        return new TreeMap<>(statisticsMap);
    }

    /**
     * Get the date/time at which recording of statistics were started or re-started.
     * @return the date/time
     */
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    /**
     * Clear the {@link #statisticsMap}.
     */
    public synchronized void clear() {
        statisticsMap.clear();
        startDateTime = LocalDateTime.now();
    }

    /**
     * Create a statistics report in CSV format.
     * @return the report
     */
    public String createCSVReport() {

        final StringBuilder csvStatsReport = new StringBuilder(INITIAL_CSV_REPORT_SIZE);
        csvStatsReport.append("Statistics captured since: ").append(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(startDateTime)).append(LINE_SEPARATOR);
        csvStatsReport.append("Type,");
        csvStatsReport.append("Count, Total ms.,Average ms.").append(LINE_SEPARATOR);

        for (final Map.Entry<Step, Map<String, StatsRecord>> statRecordMapEntry : getStatsRecords().entrySet()) {
            for (final Map.Entry<String, StatsRecord> statRecord : statRecordMapEntry.getValue().entrySet()) {
                buildKeyCSV(csvStatsReport, statRecordMapEntry.getKey(), statRecord.getValue().getLabel());
                final float floatAvg = ((float) statRecord.getValue().getTotalIntervals()) / ((float) statRecord.getValue().getCount());
                csvStatsReport.append(statRecord.getValue().getCount()).append(COMMA).append(statRecord.getValue().getTotalIntervals()).append(COMMA)
                    .append(DECIMAL_FORMAT.format(floatAvg)).append(LINE_SEPARATOR);
            }
        }
        return csvStatsReport.toString();
    }

    private void buildKeyCSV(final StringBuilder report, final Step step, final String label) {
        report.append(STEP_LABELS.getOrDefault(step, UNKNOWN_STEP_TEXT)).append(" ").append(label).append(COMMA);
    }

}
