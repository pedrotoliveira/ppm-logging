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
package com.ppm.logging;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author pedrotoliveira
 */
public class ConsoleLoggerDelegate implements ConsoleLogger {

    private final Logger logger;

    private ConsoleLoggerDelegate(final Logger logger) {
        this.logger = logger;
    }

    static ConsoleLoggerDelegate create(Class<?> clazz) {
        Logger consoleLogger = LogManager.getLogger(clazz.getName());
        return new ConsoleLoggerDelegate(consoleLogger);
    }

    @Override
    public ConsoleLogger info(Object message, Throwable t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ConsoleLogger warn(Object message, Throwable t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ConsoleLogger error(Object message, Throwable t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ConsoleLogger debug(Object message, Throwable t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ConsoleLogger fatal(Object message, Throwable t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LogData logData(Map<String, Object> logData, Throwable t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LogData log(Object object, Throwable t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LogData log(Object object, Throwable t, MessagePatterns pattern) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
