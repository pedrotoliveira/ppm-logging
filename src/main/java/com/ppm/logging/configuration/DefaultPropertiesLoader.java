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
package com.ppm.logging.configuration;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.Level;

import static com.ppm.logging.configuration.ConfigurationKey.*;
import static java.lang.ClassLoader.getSystemResource;
import static org.apache.logging.log4j.Level.getLevel;

/**
 * Default Configuration Properties Loader
 *
 * @author pedrotoliveira
 */
public class DefaultPropertiesLoader implements PropertiesLoader {

    private static final String PPM_LOGGING_PROPERTIES = "ppm-logging.properties";
    private static final String COMMA = ",";
    private static final String ERROR_MESSAGE = "Error=\"Loading ppm-logging.properties\", Message=\":ex:\"";

    private final Properties properties;

    public DefaultPropertiesLoader() {
        this(new Properties());
        loadPropertiesFile();
    }

    public DefaultPropertiesLoader(Properties properties) {
        this.properties = properties;
    }

    private void loadPropertiesFile() throws IllegalStateException {
        try {
            URL url = getSystemResource(PPM_LOGGING_PROPERTIES);
            if (url != null) {
                this.properties.load(url.openStream());
            }
        } catch (IOException ex) {
            handleIOException(ex);
        }
    }

    private void handleIOException(IOException ex) throws IllegalStateException {
        throw new IllegalStateException(ERROR_MESSAGE.replaceFirst(":ex:", ex.getMessage()), ex);
    }

    @Override
    public Level getRootLevel() {
        return getLevel(get(properties, ROOT_LEVEL, "FATAL"));
    }

    @Override
    public Boolean isConsoleEnabled() {
        return Boolean.valueOf(get(properties, CONSOLE_ENABLED, "true"));
    }

    @Override
    public Level getConsoleLevel() {
        return getLevel(get(properties, CONSOLE_LEVEL, "ERROR"));
    }

    @Override
    public List<String> getConsolePackages() {
        String[] packages = get(properties, CONSOLE_PACKAGES, "br.com.ppm").split(COMMA);
        return Arrays.asList(packages);
    }

    @Override
    public String getConsolePatternLayout() {
        return get(properties, CONSOLE_PATTERN_LAYOUT, "%d{ISO8601}|pid=%pid|level=%highlight{%p}|%d|%t:%x|class=%c|%m%n");
    }

    @Override
    public String getConsoleIgnoreExceptions() {
        return get(properties, CONSOLE_IGNORE_EX, "false");
    }

    @Override
    public String getConsoleTarget() {
        return get(properties, CONSOLE_TARGET, "SYSTEM_OUT");
    }

    @Override
    public Boolean isFileEnabled() {
        return Boolean.valueOf(get(properties, FILE_ENABLED, "true"));
    }

    @Override
    public Level getFileLevel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<String> getFilePackages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFilePatternLayout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean getFileAppend() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean getCreateFileOnDemand() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFilePattern() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean isRemoteEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Level getRemoteLevel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getRemotePackages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getRemotePatternLayout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
