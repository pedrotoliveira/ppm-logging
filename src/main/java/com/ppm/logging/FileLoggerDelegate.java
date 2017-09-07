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

import org.apache.logging.log4j.Logger;

/**
 * File Logger Delegate
 *
 * @author Pedro T. Oliveira
 *
 */
public final class FileLoggerDelegate implements FileLogger {

    private final Logger logger;

    private FileLoggerDelegate(final Logger logger) {
        this.logger = logger;
    }

    /**
     *
     * @param logger
     * @return The FileLoggerDelegate
     */
    protected static FileLoggerDelegate create(final Logger logger) {
        return new FileLoggerDelegate(logger);
    }

    public void logInfo(Object message) {
        logger.info(message);
    }

    public void logWarn(Object message) {
        logger.warn(message);
    }

    public void logError(Object message) {
        logger.error(message);
    }

    public void logDebug(Object message) {
        logger.debug(message);
    }

    public void logInfo(Object message, Throwable t) {
        logger.info(message, t);
    }

    public void logWarn(Object message, Throwable t) {
        logger.warn(message, t);
    }

    @Override
    public void logError(Object message, Throwable t) {
        logger.error(message, t);
    }

    @Override
    public void logDebug(Object message, Throwable t) {
        logger.debug(message, t);
    }

    public LogData logData(Map<String, Object> logData) {
        return new LogDataBuilder(logger, logData);
    }

    @Override
    public LogData logData(Map<String, Object> logData, Throwable t) {
        return new LogDataBuilder(logger, logData, t);
    }

    public LogKey logKey(String key) {
        return LogKeyValueBuilder.create(logger, key);
    }
}
