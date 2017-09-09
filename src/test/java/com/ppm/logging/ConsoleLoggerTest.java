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
package com.ppm.logging;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author pedrotoliveira
 */
public class ConsoleLoggerTest {

    public ConsoleLoggerTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of info method, of class ConsoleLogger.
     */
    @Test
    public void testInfo() {
    }

    /**
     * Test of warn method, of class ConsoleLogger.
     */
    @Test
    public void testWarn() {
    }

    /**
     * Test of error method, of class ConsoleLogger.
     */
    @Test
    public void testError() {
    }

    /**
     * Test of debug method, of class ConsoleLogger.
     */
    @Test
    public void testDebug() {
    }

    /**
     * Test of fatal method, of class ConsoleLogger.
     */
    @Test
    public void testFatal() {
    }

    /**
     * Test of logData method, of class ConsoleLogger.
     */
    @Test
    public void testLogData() {
    }

    /**
     * Test of log method, of class ConsoleLogger.
     */
    @Test
    public void testLog_Object_Throwable() {
    }

    /**
     * Test of log method, of class ConsoleLogger.
     */
    @Test
    public void testLog_3args() {
    }

    public class ConsoleLoggerImpl implements ConsoleLogger {

        public ConsoleLogger info(Object message, Throwable t) {
            return null;
        }

        public ConsoleLogger warn(Object message, Throwable t) {
            return null;
        }

        public ConsoleLogger error(Object message, Throwable t) {
            return null;
        }

        public ConsoleLogger debug(Object message, Throwable t) {
            return null;
        }

        public ConsoleLogger fatal(Object message, Throwable t) {
            return null;
        }

        public LogData logData(Map<String, Object> logData, Throwable t) {
            return null;
        }

        public LogData log(Object object, Throwable t) {
            return null;
        }

        public LogData log(Object object, Throwable t, MessagePatterns pattern) {
            return null;
        }
    }

}
