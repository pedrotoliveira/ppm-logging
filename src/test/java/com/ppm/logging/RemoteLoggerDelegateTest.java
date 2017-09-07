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
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Unit tests of class RemoteLoggerDelegate
 *
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 */
@RunWith(MockitoJUnitRunner.class)
public class RemoteLoggerDelegateTest {

    private RemoteLoggerDelegate delegate;

    private Object message;

    @Mock
    private Logger logger;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        this.message = Object.class.cast("Something to log");
        this.delegate = RemoteLoggerDelegate.create(logger);
    }

    @Test
    public final void testLogInfo() {
        delegate.logInfo(message);
        verify(logger, atLeastOnce()).info(message);
    }

    @Test
    public final void testLogWarn() {
        delegate.logWarn(message);
        verify(logger, atLeastOnce()).warn(message);
    }

    @Test
    public final void testLogDebug() {
        delegate.logDebug(message);
        verify(logger, atLeastOnce()).debug(message);
    }

    @Test
    public final void testLogError() {
        delegate.logError(message);
        verify(logger, atLeastOnce()).error(message);
    }

    @Test
    public final void testLogKeyValue() {
        delegate.logKey("key=").value("value").asInfo();
        verify(logger, atLeastOnce()).info("key=value ");

        delegate.logKey("key=").value("value").asDebug();
        verify(logger, atLeastOnce()).debug("key=value ");

        delegate.logKey("key=").value("value").asWarn();
        verify(logger, atLeastOnce()).warn("key=value ");

        delegate.logKey("key=").value("value").asError();
        verify(logger, atLeastOnce()).error("key=value ");
    }

    @Test
    public void testLogKey() {
    }

    @Test
    public void testLogData() {
    }

}
