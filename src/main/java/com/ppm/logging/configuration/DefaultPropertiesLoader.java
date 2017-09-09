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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.Level;

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

    private final Properties properties;

    public DefaultPropertiesLoader(Properties properties) {
        this.properties = properties;
    }

    public DefaultPropertiesLoader() {
        try {
            URL url = getSystemResource(PPM_LOGGING_PROPERTIES);
            if (url == null) {
                throw new FileNotFoundException(PPM_LOGGING_PROPERTIES + " Not Found!");
            }
            this.properties = new Properties();
            this.properties.load(url.openStream());
        } catch (IOException ex) {
            throw new IllegalStateException(
                    "Error=\"Loading ppm-logging.properties\","
                    + " Message=\"" + ex.getMessage() + "\"",
                    ex);
        }
    }

    @Override
    public Level getRootLevel() {
        return getLevel(get(properties, ROOT_LEVEL, "FATAL"));
    }

    @Override
    public Boolean getConsoleEnabled() {
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
    public String getIgnoreExceptions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getConsoleTarget() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean getFileEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Level getFileLevel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public Boolean getRemoteEnabled() {
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
