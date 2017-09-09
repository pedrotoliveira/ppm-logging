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

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author pedrotoliveira
 */
public class FluentLoggerTest {

    public FluentLoggerTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of all method, of class FluentLogger.
     */
    @Test
    public void testAll() {
    }

    /**
     * Test of console method, of class FluentLogger.
     */
    @Test
    public void testConsole() {
    }

    /**
     * Test of file method, of class FluentLogger.
     */
    @Test
    public void testFile() {
    }

    /**
     * Test of remote method, of class FluentLogger.
     */
    @Test
    public void testRemote() {
    }

    public class FluentLoggerImpl implements FluentLogger {

        public LogOperations all() {
            return null;
        }

        public ConsoleLogger console() {
            return null;
        }

        public FileLogger file() {
            return null;
        }

        public RemoteLogger remote() {
            return null;
        }
    }

}
