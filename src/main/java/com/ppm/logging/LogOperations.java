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
 * Common Log Operations
 *
 * @author Pedro T. Oliveira
 *
 */
public interface LogOperations {

    /**
     * Log a message as Info level.
     *
     * @param message
     */
    LogOperations info(final Object message);

    /**
     * Log a message as Warn level.
     *
     * @param message
     */
    LogOperations warn(final Object message);

    /**
     * Log a message as Error level.
     *
     * @param message
     */
    LogOperations error(final Object message);

    /**
     * Log a message as Debug level.
     *
     * @param message
     */
    LogOperations debug(final Object message);

    /**
     * Log a message as Fatal level.
     *
     * @param message
     */
    LogOperations fatal(final Object message);

    /**
     * Log a collection of key and value messages.
     *
     * @param logData
     * @return a LogData
     */
    LogData logData(final Map<String, Object> logData);

    /**
     * Add a key to log
     *
     * @param key key value. Can be formated with "=" or without it.
     * @return SplunkLogKey
     */
    LogKey key(final String key);

    /**
     * Log an Object Data with the Default Configurated Pattern
     *
     * @param object to Log
     * @return a LogData
     */
    LogData log(Object object);

    /**
     * Log an Object Data with the Specified Pattern
     *
     * @param object to log
     * @param pattern A MessagePatterns
     * @return a LogData
     */
    LogData log(Object object, MessagePatterns pattern);
}
