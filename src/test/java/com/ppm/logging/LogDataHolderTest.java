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

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LogDataHolderTest {

    private LogDataHolder holder;

    private Map<String, Object> logData = new HashMap<String, Object>();

    @Mock
    private RemoteLogger splunkLoggerDelegate;
    @Mock
    private FileLogger fileLoggerDelegate;
    @Mock
    private LogData mockedData;

    @Before
    public void setUp() throws Exception {
        logData.put("command", "tester");
        when(fileLoggerDelegate.logData(logData)).thenReturn(mockedData);
        when(splunkLoggerDelegate.logData(logData)).thenReturn(mockedData);
    }

    @After
    public void tearDown() throws Exception {
        holder = null;
    }

    @Test
    public final void testAsInfo() {
        holder = new LogDataHolder(logData, fileLoggerDelegate, splunkLoggerDelegate);
        holder.asInfo();
        verify(fileLoggerDelegate, atLeastOnce()).logData(logData);
        verify(splunkLoggerDelegate, atLeastOnce()).logData(logData);
        verify(mockedData, atLeastOnce()).asInfo();
    }

    @Test
    public final void testAsWarn() {
        holder = new LogDataHolder(logData, fileLoggerDelegate, splunkLoggerDelegate);
        holder.asWarn();
        verify(fileLoggerDelegate, atLeastOnce()).logData(logData);
        verify(splunkLoggerDelegate, atLeastOnce()).logData(logData);
        verify(mockedData, atLeastOnce()).asWarn();
    }

    @Test
    public final void testAsError() {
        holder = new LogDataHolder(logData, fileLoggerDelegate, splunkLoggerDelegate);
        holder.asError();
        verify(fileLoggerDelegate, atLeastOnce()).logData(logData);
        verify(splunkLoggerDelegate, atLeastOnce()).logData(logData);
        verify(mockedData, atLeastOnce()).asError();
    }

    @Test
    public final void testAsDebug() {
        holder = new LogDataHolder(logData, fileLoggerDelegate, splunkLoggerDelegate);
        holder.asDebug();
        verify(fileLoggerDelegate, atLeastOnce()).logData(logData);
        verify(splunkLoggerDelegate, atLeastOnce()).logData(logData);
        verify(mockedData, atLeastOnce()).asDebug();
    }

    @Test
    public final void testGetData() {
        holder = new LogDataHolder(logData, fileLoggerDelegate, splunkLoggerDelegate);
        when(mockedData.getData()).thenReturn("command=tester ");
        assertThat(holder.getData(), equalTo("command=tester "));
    }

}
