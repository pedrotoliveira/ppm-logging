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
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Unit tests of class SplunkLogKeyBuilder
 *
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class LogKeyValueBuilderTest {

    @Mock
    private Logger logger;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public final void testNewKey() {
        assertThat(LogKeyValueBuilder.create(logger, "command").getKey(), equalTo("command="));
        assertThat(LogKeyValueBuilder.create(logger, "command=").getKey(), equalTo("command="));
    }

    @Test
    public final void testLogKeyValue() {

        LogKeyValueBuilder builder = LogKeyValueBuilder.create(logger, "command");
        builder.value("tester");

        final String message = "command=tester ";

        builder.asInfo();
        verify(logger, atLeastOnce()).info(message);
        builder.asWarn();
        verify(logger, atLeastOnce()).warn(message);
        builder.asDebug();
        verify(logger, atLeastOnce()).debug(message);
        builder.asError();
        verify(logger, atLeastOnce()).error(message);
    }

    @Test(expected = NullPointerException.class)
    public final void testLogNullKey() {
        LogKeyValueBuilder builder = LogKeyValueBuilder.create(logger, "command");
        builder.key(null).value("sei não").asDebug();
    }

    @Test
    public void testValue() {
    }

    @Test
    public void testGetKey() {
    }

    @Test
    public void testLogKey() {
    }

    @Test
    public void testChangeKey() {
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
}
