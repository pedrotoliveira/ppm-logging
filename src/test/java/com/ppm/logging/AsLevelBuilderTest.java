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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

/**
 * Unit tests of class AsLevelBuilder
 *
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AsLevelBuilderTest {

    private AsLevelBuilder builder;

    private Map<String, Object> logData = new HashMap<>();
    @Mock
    private FileLogger fileLoggerDelegate;
    @Mock
    private RemoteLogger splunkLoggerDelegate;
    @Mock
    private LogData value;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        logData.put("command", "tester");
        builder = new AsLevelBuilder(logData, fileLoggerDelegate, splunkLoggerDelegate);
        when(fileLoggerDelegate.logData(logData)).thenReturn(value);
        when(splunkLoggerDelegate.logData(logData)).thenReturn(value);
    }

    /**
     * Test method for {@link com.ppm.logging.AsLevelBuilder#asInfo()}.
     */
    @Test
    public final void testAsInfo() {
        builder.asInfo();
        verify(fileLoggerDelegate, atMost(1)).logData(logData);
        verify(splunkLoggerDelegate, atMost(1)).logData(logData);
        verify(value, atLeastOnce()).asInfo();
    }

    /**
     * Test method for {@link com.ppm.logging.AsLevelBuilder#asWarn()}.
     */
    @Test
    public final void testAsWarn() {
        builder.asWarn();
        verify(fileLoggerDelegate, atMost(1)).logData(logData);
        verify(splunkLoggerDelegate, atMost(1)).logData(logData);
        verify(value, atLeastOnce()).asWarn();
    }

    /**
     * Test method for {@link com.ppm.logging.AsLevelBuilder#asError()}.
     */
    @Test
    public final void testAsError() {
        builder.asError();
        verify(fileLoggerDelegate, atMost(1)).logData(logData);
        verify(splunkLoggerDelegate, atMost(1)).logData(logData);
        verify(value, atLeastOnce()).asError();
    }

    /**
     * Test method for {@link com.ppm.logging.AsLevelBuilder#asDebug()}.
     */
    @Test
    public final void testAsDebug() {
        builder.asDebug();
        verify(fileLoggerDelegate, atMost(1)).logData(logData);
        verify(splunkLoggerDelegate, atMost(1)).logData(logData);
        verify(value, atLeastOnce()).asDebug();
    }
}
