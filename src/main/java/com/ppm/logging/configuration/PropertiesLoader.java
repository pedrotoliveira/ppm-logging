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

import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.Level;

/**
 *
 * @author pedrotoliveira
 */
public interface PropertiesLoader {

    String ROOT_LEVEL = "root.level";

    Level getRootLevel();

    String CONSOLE_ENABLED = "console.enabled";
    String CONSOLE_LEVEL = "console.level";
    String CONSOLE_PACKAGES = "console.packages";
    String CONSOLE_PATTERN_LAYOUT = "console.pattern.layout";
    String CONSOLE_IGNORE_EX = "console.ignoreExceptions";
    String CONSOLE_TARGET = "console.target";

    Boolean getConsoleEnabled();

    Level getConsoleLevel();

    List<String> getConsolePackages();

    String getConsolePatternLayout();

    String getIgnoreExceptions();

    String getConsoleTarget();

    String FILE_ENABLED = "file.enabled";
    String FILE_LEVEL = "file.level";
    String FILE_PACKAGES = "file.packages";
    String FILE_PATTERN_LAYOUT = "file.pattern.layout";
    String FILE_APPEND = "file.append";
    String FILE_CREATE_ON_DEMAND = "file.createOnDemand";
    String FILE_PATTERN = "file.filePattern";

    Boolean getFileEnabled();

    Level getFileLevel();

    List<String> getFilePackages();

    String getFilePatternLayout();

    Boolean getFileAppend();

    Boolean getCreateFileOnDemand();

    String getFilePattern();

    String REMOTE_ENABLED = "remote.enabled";
    String REMOTE_LEVEL = "remote.level";
    String REMOTE_PACKAGES = "remote.packages";
    String REMOTE_PATTERN_LAYOUT = "remote.pattern.layout";

    Boolean getRemoteEnabled();

    Level getRemoteLevel();

    List<String> getRemotePackages();

    String getRemotePatternLayout();

    default String get(final Properties prop, final String key, final String defaultValue) {
        return prop.getProperty(key, defaultValue);
    }
}
