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

import java.util.regex.Pattern;
import org.apache.logging.log4j.Logger;

/**
 * A Splunk log value wrapper.
 *
 * @author Pedro T. Oliveira
 *
 */
public class KeyValue implements RecursiveLogKey {

    private final StringBuilder value;
    private final LogKeyValueBuilder builder;
    private final Logger logger;
    private final Pattern pattern = Pattern.compile("\\s");

    /**
     *
     * @param builder
     * @param logger
     */
    public KeyValue(final LogKeyValueBuilder builder, final Logger logger) {
        super();
        this.builder = builder;
        this.logger = logger;
        this.value = new StringBuilder();
    }

    /**
     * @return the logger
     */
    public Logger getLogger() {
        return logger;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value.toString();
    }

    /**
     * Set a key and a value.
     *
     * @param key
     * @param value the value to set
     * @return a RecursiveLogKey
     */
    public RecursiveLogKey setValue(String key, Object value) {
        this.value.append(key);
        if (stringHasSpaces(String.valueOf(value))) {
            this.value.append("\"").append(value).append("\" ");
        } else {
            this.value.append(value).append(" ");
        }
        return this;
    }

    public LogKey key(String key) {
        return builder.changeKey(key);
    }

    public AsLevel asInfo() {
        logger.info(value.toString());
        return this;
    }

    public AsLevel asWarn() {
        logger.warn(value.toString());
        return this;
    }

    public AsLevel asError() {
        logger.error(value.toString());
        return this;
    }

    public AsLevel asDebug() {
        logger.debug(value.toString());
        return this;
    }

    private boolean stringHasSpaces(final String s) {
        return pattern.matcher(s).find();
    }
}
