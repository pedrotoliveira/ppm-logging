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

import java.net.URI;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Order;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.FilterComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.RootLoggerComponentBuilder;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;
import org.apache.logging.log4j.core.config.plugins.Plugin;

/**
 * The Logger Configuration Factory
 *
 * @author pedrotoliveira
 */
@Plugin(name = "LoggerConfiguration", category = ConfigurationFactory.CATEGORY)
@Order(1)
public class LoggerConfigurationFactory extends ConfigurationFactory {

    /**
     * Valid file extensions for Configuration files. Because it specifies a supported type of "*" it will override any
     * configuration files provided
     */
    public static final String[] CONFIG_FILES_TYPES = new String[]{"*"};

    @Override
    protected String[] getSupportedTypes() {
        return CONFIG_FILES_TYPES;
    }

    @Override
    public Configuration getConfiguration(LoggerContext loggerContext, ConfigurationSource source) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Configuration getConfiguration(LoggerContext loggerContext, String name, URI configLocation) {
        PropertiesLoader propertiesLoader = createPropertiesLoader();
        Level rootLevel = Level.FATAL;

        ConfigurationBuilder<BuiltConfiguration> configBuilder = newConfigurationBuilder();
        configBuilder.setConfigurationName(name);
        configBuilder.setStatusLevel(rootLevel);
        configBuilder.add(createThresholdFilter(configBuilder, rootLevel));

        AppenderComponentBuilder consoleAppenderBuilder = configBuilder.newAppender("Console", ConsoleAppender.PLUGIN_NAME);
        consoleAppenderBuilder.addAttribute("target", ConsoleAppender.Target.SYSTEM_OUT);

        RootLoggerComponentBuilder rootLoggerBuilder = configBuilder.newRootLogger(rootLevel);

        return configBuilder.build();
    }

    private FilterComponentBuilder createThresholdFilter(ConfigurationBuilder<BuiltConfiguration> configBuilder, Level level) {
        return configBuilder
                .newFilter("ThresholdFilter", Filter.Result.NEUTRAL, Filter.Result.DENY)
                .addAttribute("level", level);
    }

    public PropertiesLoader createPropertiesLoader() {
        return new DefaultPropertiesLoader();
    }
}
