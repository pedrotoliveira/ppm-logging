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

import java.util.Objects;

/**
 * Implements FluentLogger
 *
 * @author Pedro T. Oliveira
 */
public final class LoggerService implements FluentLogger {

    private final LoggerHolder holder;

    private LoggerService(Class<?> clazz) {
        Objects.requireNonNull(clazz, "Class cannot be null.");
        holder = new LoggerHolder(clazz);
    }

    /**
     * Initialize a new Fluent Logger based on a class
     *
     * @param clazz a Class to be attached to the Logger
     * @return FluentLogger instance
     */
    public static FluentLogger init(final Class<?> clazz) {
        return new LoggerService(clazz);
    }

    /**
     * Initialize a new Fluent Logger based on a class
     *
     * @param clazz a Class to be attached to the Logger
     * @return FluentLogger instance
     */
    public static FluentLogger by(final Class<?> clazz) {
        return new LoggerService(clazz);
    }

    @Override
    public LogOperations all() {
        return holder;
    }

    @Override
    public ConsoleLogger console() {
        return holder.getConsoleLoggerDelegate();
    }

    @Override
    public FileLogger file() {
        return holder.getFileLoggerDelegate();
    }

    @Override
    public RemoteLogger remote() {
        return holder.getSplunkLoggerDelegate();
    }
}
