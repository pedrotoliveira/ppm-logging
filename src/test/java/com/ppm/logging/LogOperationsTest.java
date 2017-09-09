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
public class LogOperationsTest {

    public LogOperationsTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of info method, of class LogOperations.
     */
    @Test
    public void testInfo() {
    }

    /**
     * Test of warn method, of class LogOperations.
     */
    @Test
    public void testWarn() {
    }

    /**
     * Test of error method, of class LogOperations.
     */
    @Test
    public void testError() {
    }

    /**
     * Test of debug method, of class LogOperations.
     */
    @Test
    public void testDebug() {
    }

    /**
     * Test of fatal method, of class LogOperations.
     */
    @Test
    public void testFatal() {
    }

    /**
     * Test of logData method, of class LogOperations.
     */
    @Test
    public void testLogData() {
    }

    /**
     * Test of key method, of class LogOperations.
     */
    @Test
    public void testKey() {
    }

    /**
     * Test of log method, of class LogOperations.
     */
    @Test
    public void testLog_Object() {
    }

    /**
     * Test of log method, of class LogOperations.
     */
    @Test
    public void testLog_Object_MessagePatterns() {
    }

    public class LogOperationsImpl implements LogOperations {

        public LogOperations info(Object message) {
            return null;
        }

        public LogOperations warn(Object message) {
            return null;
        }

        public LogOperations error(Object message) {
            return null;
        }

        public LogOperations debug(Object message) {
            return null;
        }

        public LogOperations fatal(Object message) {
            return null;
        }

        public LogData logData(Map<String, Object> logData) {
            return null;
        }

        public LogKey key(String key) {
            return null;
        }

        public LogData log(Object object) {
            return null;
        }

        public LogData log(Object object, MessagePatterns pattern) {
            return null;
        }
    }

}
