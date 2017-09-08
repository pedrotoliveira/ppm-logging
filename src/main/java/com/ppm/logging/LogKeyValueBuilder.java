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

import org.apache.logging.log4j.Logger;

/**
 * LogKeyValue Builder
 *
 * @author Pedro T. Oliveira
 *
 */
public final class LogKeyValueBuilder implements LogKey, RecursiveLogKey {

    private String key;
    private final KeyValue keyValue;

    private LogKeyValueBuilder(final Logger logger, final String key) {
        this.key = key;
        this.keyValue = new KeyValue(this, logger);
    }

    /**
     * Create a LogKeyValueBuilder
     *
     * @param logger internal Logger
     * @param key Key
     * @return a LogKeyValueBuilder
     */
    protected static LogKeyValueBuilder create(final Logger logger, final String key) {
        return (key.contains("=")) ? new LogKeyValueBuilder(logger, key) : new LogKeyValueBuilder(logger, key + "=");
    }

    public RecursiveLogKey value(final Object msg) {
        return keyValue.setValue(key, msg);
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    public LogKey logKey(String key) {
        return changeKey(key);
    }

    /**
     * Construct a Key with '=' if not present.
     *
     * @param key a String
     * @return a LogKey
     */
    public LogKey changeKey(String key) {
        this.key = (key.contains("=")) ? key : key + "=";
        return this;
    }

    public AsLevel asInfo() {
        return keyValue.asInfo();
    }

    public AsLevel asWarn() {
        return keyValue.asWarn();
    }

    public AsLevel asError() {
        return keyValue.asError();
    }

    public AsLevel asDebug() {
        return keyValue.asDebug();
    }
}
