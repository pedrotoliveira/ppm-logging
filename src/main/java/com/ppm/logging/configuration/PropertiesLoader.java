/*
 * Copyright (C) 2017 PPM Sistemas da Informacao LTDA
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.ppm.logging.configuration;

import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.Level;

/**
 * Properties Loader Interface.
 *
 * @author pedrotoliveira
 */
public interface PropertiesLoader {

    /**
     * Get Root Log Level
     * It can be: ALL TRACE DEBUG INFO WARN ERROR FATAL OF
     * - Custom log levels will be disabled at this project moment.
     *
     * @return an Event Level.
     * @see <a href=https://logging.apache.org/log4j/2.0/manual/architecture.html>log4j/2.0/manual/architecture.html</a>
     */
    Level getRootLevel();

    /**
     * It Should console logging be enabled?
     *
     * @return true or false
     */
    Boolean isConsoleEnabled();

    /**
     * Get Console Log Level
     * It can be: <b>ALL TRACE DEBUG INFO WARN ERROR FATAL OFF</b>
     * - Custom log levels will be disabled at this project moment.
     *
     * @return an Event Level.
     * @see
     * <a href="https://logging.apache.org/log4j/2.0/manual/architecture.html">log4j/2.0/manual/architecture.html</a>
     */
    Level getConsoleLevel();

    /**
     * Get a List of Packages to configure the Log Hierarchy.
     * <p>
     * By default The logger engine will consider the same pattern from log4j.
     * For example, the LoggerConfig named <b>"com.foo"</b> is a parent of the LoggerConfig named <b>"com.foo.Bar"</b>.
     * Similarly,<b>"java"</b> is a parent of <b>"java.util"</b> and an ancestor of <b>"java.util.Vector".</b>
     * This naming scheme should be familiar to most developers.
     * </p>
     *
     * @return a List of String representing packages Namespaces
     * @see
     * <a href="https://logging.apache.org/log4j/2.x/manual/architecture.html">log4j/2.x/manual/architecture.html</a>
     */
    List<String> getConsolePackages();

    /**
     * Gets Console Pattern Layout.
     * <p>
     * More often than not, users wish to customize not only the output destination but also the output format. This is
     * accomplished by associating a Layout with an Appender. The Layout is responsible for formatting the LogEvent
     * according to the user's wishes, whereas an appender takes care of sending the formatted output to its
     * destination.
     * </p>
     *
     * @return a Pattern Layout String
     * @see <a href="https://logging.apache.org/log4j/2.x/manual/layouts.html">log4j/2.x/manual/layouts.html</a>
     */
    String getConsolePatternLayout();

    /**
     * Should Console Logging Ignore Exceptions?
     *
     * <p>
     * The default is true, causing exceptions encountered while appending events to be internally logged and then
     * ignored. When set to false exceptions will be propagated to the caller, instead. You must set this to false when
     * wrapping this Appender in a FailoverAppender.
     * </p>
     *
     * @return Return a String "true" or "false" values, if you return something different from "true" or "false" the
     * DefaultConfigurationFactory will consider as "true".
     */
    String getConsoleIgnoreExceptions();

    /**
     * Output Stream for Console Logger.</br>
     *
     * Can be Either <b>"SYSTEM_OUT" or "SYSTEM_ERR"</b>. The default is <b>"SYSTEM_OUT".</b>
     *
     * @return a String
     */
    String getConsoleTarget();

    /**
     * It Should console logging be enabled?
     *
     * @return true or false
     */
    Boolean isFileEnabled();

    /**
     * Get File Log Level
     * It can be: <b>ALL TRACE DEBUG INFO WARN ERROR FATAL OFF</b>
     *
     * - Custom log levels will be disabled at this project moment.
     *
     * @return an Event Level.
     * @see
     * <a href="https://logging.apache.org/log4j/2.0/manual/architecture.html">log4j/2.0/manual/architecture.html</a>
     */
    Level getFileLevel();

    /**
     * Get a List of Packages to configure the Log Hierarchy.
     * <p>
     * By default The logger engine will consider the same pattern from log4j.
     * For example, the LoggerConfig named <b>"com.foo"</b> is a parent of the LoggerConfig named <b>"com.foo.Bar"</b>.
     * Similarly,<b>"java"</b> is a parent of <b>"java.util"</b> and an ancestor of <b>"java.util.Vector".</b>
     *
     * This naming scheme should be familiar to most developers.
     * </p>
     *
     * @return a List of String representing packages Namespaces
     * @see
     * <a href="https://logging.apache.org/log4j/2.x/manual/architecture.html">log4j/2.x/manual/architecture.html</a>
     */
    List<String> getFilePackages();

    /**
     * Gets File Pattern Layout.
     * <p>
     * More often than not, users wish to customize not only the output destination but also the output format. This is
     * accomplished by associating a Layout with an Appender. The Layout is responsible for formatting the LogEvent
     * according to the user's wishes, whereas an appender takes care of sending the formatted output to its
     * destination.
     * </p>
     *
     * @return a Pattern Layout String
     * @see <a href="https://logging.apache.org/log4j/2.x/manual/layouts.html">log4j/2.x/manual/layouts.html</a>
     */
    String getFilePatternLayout();

    /**
     * Get the file append property.
     * <p>
     * When true - the default, records will be appended to the end of the file. When set to false, the file will be
     * cleared before new records are written.
     * </p>
     *
     * @return true or false
     */
    Boolean getFileAppend();

    /**
     * Get the Create File On Demand property.
     * <p>
     * The appender creates the file on-demand. The appender only creates the file when a log event passes all filters
     * and is routed to this appender. Defaults to false.
     * </p>
     *
     * @return true or false
     */
    Boolean getCreateFileOnDemand();

    /**
     * Get the file archiving pattern.
     * <p>
     * The pattern of the file name of the archived log file Example: .yyyy-MM-dd This pattern will depends on file
     * systems grow policies.
     * </p>
     *
     * @return a String representing the pattern
     */
    String getFilePattern();

    /**
     * It Should Remote logging be enabled?
     *
     * @return true or false
     */
    Boolean isRemoteEnabled();

    /**
     * Get Remote Log Level
     *
     * It can be: <b>ALL TRACE DEBUG INFO WARN ERROR FATAL OFF</b>
     *
     * - Custom log levels will be disabled at this project moment.
     *
     * @return an Event Level.
     * @see
     * <a href="https://logging.apache.org/log4j/2.0/manual/architecture.html">log4j/2.0/manual/architecture.html</a>
     */
    Level getRemoteLevel();

    /**
     * Get a List of Packages to configure the Log Hierarchy.
     *
     * By default The logger engine will consider the same pattern from log4j.
     * For example, the LoggerConfig named <b>"com.foo"</b> is a parent of the LoggerConfig named <b>"com.foo.Bar"</b>.
     * Similarly,<b>"java"</b> is a parent of <b>"java.util"</b> and an ancestor of <b>"java.util.Vector".</b>
     *
     *
     * This naming scheme should be familiar to most developers.
     *
     * @return a List of String representing packages Namespaces
     * @see
     * <a href="https://logging.apache.org/log4j/2.x/manual/architecture.html">log4j/2.x/manual/architecture.html</a>
     */
    List<String> getRemotePackages();

    /**
     * Gets Remote Pattern Layout.
     * <p>
     * More often than not, users wish to customize not only the output destination but also the output format. This is
     * accomplished by associating a Layout with an Appender. The Layout is responsible for formatting the LogEvent
     * according to the user's wishes, whereas an appender takes care of sending the formatted output to its
     * destination.
     * </p>
     *
     * @return a Pattern Layout String
     * @see <a href="https://logging.apache.org/log4j/2.x/manual/layouts.html">log4j/2.x/manual/layouts.html</a>
     */
    String getRemotePatternLayout();

    /**
     * Get a Property value by the given ConfigurationKey, if the properties not found return the default value.
     *
     * @param prop a Properties object
     * @param key a ConfigurationKey
     * @param defaultValue a default value
     * @return a Property Value
     */
    default String get(final Properties prop, final ConfigurationKey key, final String defaultValue) {
        return prop.getProperty(key.getName(), defaultValue);
    }
}
