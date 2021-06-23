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

/**
 * Fluent logger is a interface that encapsulates common log operations to be used in a fluent way.
 *
 * @author Pedro T. Oliveira
 * @see LoggerService
 */
public interface FluentLogger {

    /**
     * Invoke Operations in all loggers
     *
     * @return All Message Builders
     */
    LogOperations all();

    /**
     * Invoke Console Logger Operations
     *
     * @return Console Logger Message Builder
     */
    ConsoleLogger console();

    /**
     * Invoke File Logger Operations
     *
     * @return File Logger Message Builder
     */
    FileLogger file();

    /**
     * Invoke Remote Logger Operations
     *
     * @return Remote Logger Message Builder
     */
    RemoteLogger remote();
}
