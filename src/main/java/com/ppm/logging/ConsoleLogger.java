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
 *
 * @author pedrotoliveira
 */
public interface ConsoleLogger {

    /**
     *
     * @param message log message
     * @param t exception
     */
    ConsoleLogger info(final Object message, final Throwable t);

    /**
     *
     * @param message log message
     * @param t exception
     */
    ConsoleLogger warn(final Object message, final Throwable t);

    /**
     *
     * @param message log message
     * @param t exception
     */
    ConsoleLogger error(final Object message, final Throwable t);

    /**
     *
     * @param message log message
     * @param t exception
     */
    ConsoleLogger debug(final Object message, final Throwable t);

    /**
     *
     * @param message log message
     * @param t exception
     */
    ConsoleLogger fatal(final Object message, final Throwable t);

    /**
     *
     * @param logData Map key-value with log data
     * @param t exception to be logged
     * @return a LogData
     */
    LogData logData(final Map<String, Object> logData, final Throwable t);

    /**
     * Log an Object Data with the Default Configurated Pattern
     *
     * @param object to Log
     * @param t exception to be logged
     * @return a LogData
     */
    LogData log(final Object object, final Throwable t);

    /**
     * Log an Object Data with the Specified Pattern
     *
     * @param object to log
     * @param t exception to be logged
     * @param pattern selected MessagePatterns
     * @return a LogData
     */
    LogData log(final Object object, final Throwable t, final MessagePatterns pattern);
}
