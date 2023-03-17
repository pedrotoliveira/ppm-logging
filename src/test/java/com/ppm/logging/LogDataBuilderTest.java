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

import org.apache.logging.log4j.core.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

/**
 * Unit Test of LogDataBuilder
 *
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class LogDataBuilderTest {

    private LogDataBuilder builder;

    private Map<String, Object> logData = new HashMap<>();
    @Mock
    private Logger logger;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        logData.put("command", "tester");
    }

    @After
    public void tearDown() throws Exception {
        builder = null;
    }

    @Test
    public final void testBuilder() throws Exception {
        builder = new LogDataBuilder(logger, logData);
        assertThat(builder.getData(), equalTo("command=tester "));

        builder.asInfo();
        verify(logger, atLeastOnce()).info("command=tester ");
        builder.asWarn();
        verify(logger, atLeastOnce()).warn("command=tester ");
        builder.asDebug();
        verify(logger, atLeastOnce()).debug("command=tester ");
        builder.asError();
        verify(logger, atLeastOnce()).error("command=tester ");
    }

    @Test
    public final void testBuilderException() throws Exception {
        Exception ex = new Exception("Test Exception");

        builder = new LogDataBuilder(logger, logData, ex);

        builder.asInfo();
        verify(logger, atLeastOnce()).info("command=tester ", ex);
        builder.asWarn();
        verify(logger, atLeastOnce()).warn("command=tester ", ex);
        builder.asDebug();
        verify(logger, atLeastOnce()).debug("command=tester ", ex);
        builder.asError();
        verify(logger, atLeastOnce()).error("command=tester ", ex);
    }

    @Test
    public void testAsInfo() {
    }

    @Test
    public void testAsWarn() {
    }

    @Test
    public void testAsError() {
    }

    @Test
    public void testAsDebug() {
    }

    @Test
    public void testGetData() {
    }

    @Test
    public void testHashCode() {
    }

    @Test
    public void testEquals() {
    }

    @Test
    public void testToString() {
    }

}
