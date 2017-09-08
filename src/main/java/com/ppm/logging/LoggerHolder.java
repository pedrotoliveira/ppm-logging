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

    /**
     *
     * @param clazz
     */
    public LoggerHolder(final Class<?> clazz) {
        this.consoleLoggerDelegate = ConsoleLoggerDelegate.create(clazz);
        this.fileLoggerDelegate = FileLoggerDelegate.create(clazz);
        this.remoteLoggerDelegate = RemoteLoggerDelegate.create(clazz);
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
        fileLoggerDelegate.info(message);
        remoteLoggerDelegate.info(message);
        return this;
    }

    @Override
    public LogOperations warn(final Object message) {
        fileLoggerDelegate.warn(message);
        remoteLoggerDelegate.warn(message);
        return this;
    }

    @Override
    public LogOperations error(final Object message) {
        fileLoggerDelegate.error(message);
        remoteLoggerDelegate.error(message);
        return this;
    }

    @Override
    public LogOperations debug(final Object message) {
        fileLoggerDelegate.debug(message);
        remoteLoggerDelegate.debug(message);
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
    public LogData log(Object object, LogPatterns pattern) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
