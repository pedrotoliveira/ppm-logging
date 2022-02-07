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
import java.util.Arrays;

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
 * The PPM Logger Configuration Factory<br/>
 *
 * <p>
 * During initialization, Log4j 2 will search for available ConfigurationFactories and then select the one to use. The
 * selected ConfigurationFactory creates the Configuration that Log4j will use. Here is how Log4j finds the available
 * ConfigurationFactories:
 * <ol>
 * <li>
 * A system property named "log4j.configurationFactory" can be set with the name of the ConfigurationFactory to be used.
 * </li>
 * <li>
 * ConfigurationFactory.setConfigurationFactory(ConfigurationFactory) can be called with the instance of the
 * ConfigurationFactory to be used. This must be called before any other calls to Log4j.
 * </li>
 * <li>
 * A ConfigurationFactory implementation can be added to the classpath and configured as a plugin in the
 * "ConfigurationFactory" category. The Order annotation can be used to specify the relative priority when multiple
 * applicable ConfigurationFactories are found.
 * </li>
 * </ol>
 * ConfigurationFactories have the concept of "supported types", which basically maps to the file extension of the
 * configuration file that the ConfigurationFactory can handle. If a configuration file location is specified,
 * ConfigurationFactories whose supported type does not include "*" or the matching file extension will not be used.
 * </p>
 *
 * @author pedrotoliveira
 * @see <a href="https://logging.apache.org/log4j/2.x/manual/customconfig.html">log4j/2.x/manual/customconfig.html</a>
 */
//@Plugin(name = "DefaultConfigurationFactory", category = "ConfigurationFactory")
//@Order(5)
public class DefaultConfigurationFactory extends ConfigurationFactory {

    /**
     * Valid file extensions for Configuration files. Because it specifies a supported type of "*" it will override any
     * configuration files provided
     */
    public static final String[] CONFIG_FILES_TYPES = new String[]{"*"};

    private final PropertiesLoader propertiesLoader;

    public DefaultConfigurationFactory() {
        this.propertiesLoader = new DefaultPropertiesLoader();
    }

    public DefaultConfigurationFactory(PropertiesLoader propertiesLoader) {
        this.propertiesLoader = propertiesLoader;
    }

    @Override
    protected String[] getSupportedTypes() {
        return Arrays.copyOf(CONFIG_FILES_TYPES, CONFIG_FILES_TYPES.length);
    }

    @Override
    public Configuration getConfiguration(LoggerContext loggerContext, ConfigurationSource source) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Configuration getConfiguration(LoggerContext loggerContext, String name, URI configLocation) {
        PropertiesLoader properties = getPropertiesLoader();
        Level rootLevel = Level.DEBUG;

        ConfigurationBuilder<BuiltConfiguration> configBuilder = newConfigurationBuilder();
        configBuilder.setConfigurationName(name);
        configBuilder.setStatusLevel(rootLevel);
        configBuilder.add(createThresholdFilter(configBuilder, rootLevel));

        AppenderComponentBuilder consoleAppenderBuilder = configBuilder.newAppender("Console", ConsoleAppender.PLUGIN_NAME);
        consoleAppenderBuilder.addAttribute("target", ConsoleAppender.Target.SYSTEM_OUT);

        RootLoggerComponentBuilder rootLoggerBuilder = configBuilder
                .newRootLogger(rootLevel)
                .addComponent(consoleAppenderBuilder);

        configBuilder.add(rootLoggerBuilder);
        return configBuilder.build();
    }

    private FilterComponentBuilder createThresholdFilter(ConfigurationBuilder<BuiltConfiguration> configBuilder, Level level) {
        return configBuilder
                .newFilter("ThresholdFilter", Filter.Result.NEUTRAL, Filter.Result.DENY)
                .addAttribute("level", level);
    }

    public PropertiesLoader getPropertiesLoader() {
        return propertiesLoader;
    }
}
