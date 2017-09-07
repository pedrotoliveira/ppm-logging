/*
 *  Copyright (C) 2010 Pedro T. Oliveira <pedro.oliveira.nom.br>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
