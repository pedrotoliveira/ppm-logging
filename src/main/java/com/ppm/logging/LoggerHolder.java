/*
 * Copyright (C) 2017 pedrotoliveira
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
package com.ppm.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.LoggerContext;

import java.util.Map;

/**
 * Logger Holder
 *
 * @author Pedro T. Oliveira
 *
 */
public class LoggerHolder implements LogOperations {

    private final ConsoleLoggerDelegate consoleLoggerDelegate;
    private final FileLoggerDelegate fileLoggerDelegate;
    private final RemoteLoggerDelegate remoteLoggerDelegate;
    private final Logger logger;

    /**
     *
     * @param clazz
     */
    public LoggerHolder(final Class<?> clazz) {
        logger = LogManager.getLogger(clazz);
        consoleLoggerDelegate = new ConsoleLoggerDelegate(logger);
        fileLoggerDelegate = new FileLoggerDelegate(logger);
        remoteLoggerDelegate = new RemoteLoggerDelegate(logger);
    }

    /**
     * @return the fileLogger
     */
    FileLogger getFileLoggerDelegate() {
        return fileLoggerDelegate;
    }

    /**
     * @return the remoteLogger
     */
    RemoteLogger getSplunkLoggerDelegate() {
        return remoteLoggerDelegate;
    }

    /**
     * @return the ConsoleLoggerDelegate
     */
    ConsoleLogger getConsoleLoggerDelegate() {
        return consoleLoggerDelegate;
    }

    @Override
    public LogOperations info(final Object message) {
        logger.info(message);
        return this;
    }

    @Override
    public LogOperations warn(final Object message) {
        logger.warn(message);
        return this;
    }

    @Override
    public LogOperations error(final Object message) {
        logger.error(message);
        return this;
    }

    @Override
    public LogOperations debug(final Object message) {
        logger.debug(message);
        return this;
    }

    @Override
    public LogDataHolder logData(final Map<String, Object> logData) {
        return new LogDataHolder(logData, fileLoggerDelegate, remoteLoggerDelegate);
    }

    @Override
    public LogKey key(String key) {
        return new LogKeyValueBuilderHolder(key, fileLoggerDelegate, remoteLoggerDelegate);
    }

    @Override
    public LogOperations fatal(Object message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LogData log(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LogData log(Object object, MessagePatterns pattern) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
