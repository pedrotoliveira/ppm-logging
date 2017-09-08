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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * File Logger Delegate
 *
 * @author Pedro T. Oliveira
 *
 */
public final class FileLoggerDelegate implements FileLogger {

    private final Logger logger;

    FileLoggerDelegate(final Logger logger) {
        this.logger = logger;
    }

    /**
     *
     * @param logger
     * @return The FileLoggerDelegate
     */
    static FileLoggerDelegate create(final Class<?> clazz) {
        String loggerName = FILE_LOGGER_PREFIX + clazz.getName();
        Logger fileLogger = LogManager.getLogger(loggerName);
        return new FileLoggerDelegate(fileLogger);
    }

    @Override
    public FileLogger info(Object message) {
        logger.info(message);
        return this;
    }

    @Override
    public FileLogger warn(Object message) {
        logger.warn(message);
        return this;
    }

    @Override
    public FileLogger error(Object message) {
        logger.error(message);
        return this;
    }

    @Override
    public FileLogger debug(Object message) {
        logger.debug(message);
        return this;
    }

    @Override
    public FileLogger info(Object message, Throwable t) {
        logger.info(message, t);
        return this;
    }

    @Override
    public FileLogger warn(Object message, Throwable t) {
        logger.warn(message, t);
        return this;
    }

    @Override
    public FileLogger error(Object message, Throwable t) {
        logger.error(message, t);
        return this;
    }

    @Override
    public FileLogger debug(Object message, Throwable t) {
        logger.debug(message, t);
        return this;
    }

    @Override
    public LogData logData(Map<String, Object> logData) {
        return new LogDataBuilder(logger, logData);
    }

    @Override
    public LogData logData(Map<String, Object> logData, Throwable t) {
        return new LogDataBuilder(logger, logData, t);
    }

    @Override
    public LogKey key(String key) {
        return LogKeyValueBuilder.create(logger, key);
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

    @Override
    public ConsoleLogger fatal(Object message, Throwable t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LogData log(Object object, Throwable t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LogData log(Object object, Throwable t, LogPatterns pattern) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
