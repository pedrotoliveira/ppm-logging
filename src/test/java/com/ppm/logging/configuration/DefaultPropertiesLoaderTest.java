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

import org.apache.logging.log4j.Level;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit Tests for DefaultPropertiesLoader
 *
 * @author pedrotoliveira
 * @see DefaultPropertiesLoader
 */
public class DefaultPropertiesLoaderTest {

    private DefaultPropertiesLoader loader;

    @Before
    public void setUp() {
        this.loader = new DefaultPropertiesLoader();
    }

    /**
     * Test of getRootLevel method, of class DefaultPropertiesLoader.
     */
    @Test
    public void testGetRootLevel() {
//        testCase("Root Level Should Be ALL").assertEqualTo(loader.getRootLevel(), Level.ALL);
    }

    /**
     * Test of getConsoleEnabled method, of class DefaultPropertiesLoader.
     */
    @Test
    public void testGetConsoleEnabled() {
//        testCase("Console Log Should be true").assertTrue(loader.isConsoleEnabled());
    }

    /**
     * Test of getConsoleLevel method, of class DefaultPropertiesLoader.
     */
    @Test
    public void testGetConsoleLevel() {
        Level consoleLevel = loader.getConsoleLevel();
//        testCase("Console Level Should Be FATAL")
//                .assertEqualTo(consoleLevel, Level.FATAL);
    }

    /**
     * Test of getConsolePackages method, of class DefaultPropertiesLoader.
     */
    @Test
    public void testGetConsolePackages() {
    }

    /**
     * Test of getConsolePatternLayout method, of class DefaultPropertiesLoader.
     */
    @Test
    public void testGetConsolePatternLayout() {
    }

    /**
     * Test of getIgnoreExceptions method, of class DefaultPropertiesLoader.
     */
    @Test
    public void testGetIgnoreExceptions() {
    }

    /**
     * Test of getConsoleTarget method, of class DefaultPropertiesLoader.
     */
    @Test
    public void testGetConsoleTarget() {
    }

    /**
     * Test of getFileEnabled method, of class DefaultPropertiesLoader.
     */
    @Test
    public void testGetFileEnabled() {
    }

    /**
     * Test of getFileLevel method, of class DefaultPropertiesLoader.
     */
    @Test
    public void testGetFileLevel() {
    }

    /**
     * Test of getFilePackages method, of class DefaultPropertiesLoader.
     */
    @Test
    public void testGetFilePackages() {
    }

    /**
     * Test of getFilePatternLayout method, of class DefaultPropertiesLoader.
     */
    @Test
    public void testGetFilePatternLayout() {
    }

    /**
     * Test of getFileAppend method, of class DefaultPropertiesLoader.
     */
    @Test
    public void testGetFileAppend() {
    }

    /**
     * Test of getCreateFileOnDemand method, of class DefaultPropertiesLoader.
     */
    @Test
    public void testGetCreateFileOnDemand() {
    }

    /**
     * Test of getFilePattern method, of class DefaultPropertiesLoader.
     */
    @Test
    public void testGetFilePattern() {
    }

    /**
     * Test of getRemoteEnabled method, of class DefaultPropertiesLoader.
     */
    @Test
    public void testGetRemoteEnabled() {
    }

    /**
     * Test of getRemoteLevel method, of class DefaultPropertiesLoader.
     */
    @Test
    public void testGetRemoteLevel() {
    }

    /**
     * Test of getRemotePackages method, of class DefaultPropertiesLoader.
     */
    @Test
    public void testGetRemotePackages() {
    }

    /**
     * Test of getRemotePatternLayout method, of class DefaultPropertiesLoader.
     */
    @Test
    public void testGetRemotePatternLayout() {
    }

}
