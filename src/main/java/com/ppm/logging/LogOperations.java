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
    void logInfo(final Object message);

    /**
     * Log a message as Warn level.
     *
     * @param message
     */
    void logWarn(final Object message);

    /**
     * Log a message as Error level.
     *
     * @param message
     */
    void logError(final Object message);

    /**
     * Log a message as Debug level.
     *
     * @param message
     */
    void logDebug(final Object message);

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
    LogKey logKey(final String key);
}
