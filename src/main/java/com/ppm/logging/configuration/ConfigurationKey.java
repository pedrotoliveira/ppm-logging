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
package com.ppm.logging.configuration;

/**
 * Configuration Key
 *
 * @author pedrotoliveira
 */
public enum ConfigurationKey {

    ROOT_LEVEL("root.level"),
    //CONSOLE
    CONSOLE_ENABLED("console.enabled"),
    CONSOLE_LEVEL("console.level"),
    CONSOLE_PACKAGES("console.packages"),
    CONSOLE_PATTERN_LAYOUT("console.pattern.layout"),
    CONSOLE_IGNORE_EX("console.ignoreExceptions"),
    CONSOLE_TARGET("console.target"),
    //FILE
    FILE_ENABLED("file.enabled"),
    FILE_LEVEL("file.level"),
    FILE_PACKAGES("file.packages"),
    FILE_PATTERN_LAYOUT("file.pattern.layout"),
    FILE_APPEND("file.append"),
    FILE_CREATE_ON_DEMAND("file.createOnDemand"),
    FILE_PATTERN("file.filePattern"),
    //REMOTE
    REMOTE_ENABLED("remote.enabled"),
    REMOTE_LEVEL("remote.level"),
    REMOTE_PACKAGES("remote.packages"),
    REMOTE_PATTERN_LAYOUT("remote.pattern.layout");

    private final String name;

    private ConfigurationKey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
