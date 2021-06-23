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
 * Remote Logger Delegate
 *
 * @author Pedro T. Oliveira
 *
 */
public class RemoteLoggerDelegate implements RemoteLogger {

    private final Logger logger;

    RemoteLoggerDelegate(final Logger logger) {
        this.logger = logger;
    }

    /**
     * Create a new Remote Logger Delegate
     *
     * @param logger
     * @return the RemoteLoggerDelegate
     */
    static final RemoteLoggerDelegate create(final Class<?> clazz) {
        String loggerName = REMOTE_LOGGER_PREFIX + clazz.getName();
        Logger remoteLogger = LogManager.getLogger(loggerName);
        return new RemoteLoggerDelegate(remoteLogger);
    }

    @Override
    public RemoteLogger info(Object message) {
        logger.info(message);
        return this;
    }

    @Override
    public RemoteLogger warn(Object message) {
        logger.warn(message);
        return this;
    }

    @Override
    public RemoteLogger error(Object message) {
        logger.error(message);
        return this;
    }

    @Override
    public RemoteLogger debug(Object message) {
        logger.debug(message);
        return this;
    }

    @Override
    public LogOperations fatal(Object message) {
        logger.fatal(message);
        return this;
    }

    @Override
    public LogKey key(String key) {
        return LogKeyValueBuilder.create(this.logger, key);
    }

    @Override
    public LogData logData(final Map<String, Object> logData) {
        return new LogDataBuilder(this.logger, logData);
    }

    @Override
    public LogData log(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LogData log(Object object, MessagePatterns pattern) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
