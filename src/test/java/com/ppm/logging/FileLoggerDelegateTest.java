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
 * Unit Test of class FileLoggerDelegate
 *
 * @author Pedro T. Oliveira <pedro.oliveira20@gmail.com>
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class FileLoggerDelegateTest {

    private FileLoggerDelegate delegate;

    private Object message;
    private Exception aException;

    @Mock
    private Logger logger;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        this.message = Object.class.cast("Something to log");
        this.aException = new Exception("A Exception");
        this.delegate = FileLoggerDelegate.create(this.logger);
    }

    @Test
    public final void testLogInfo() {
        delegate.logInfo(message);
        verify(logger, atLeastOnce()).info(message);

        delegate.logInfo(message, aException);
        verify(logger, atLeastOnce()).info(message, aException);
    }

    @Test
    public final void testLogWarn() {
        delegate.logWarn(message);
        verify(logger, atLeastOnce()).warn(message);

        delegate.logWarn(message, aException);
        verify(logger, atLeastOnce()).warn(message, aException);
    }

    @Test
    public final void testLogDebug() {
        delegate.logDebug(message);
        verify(logger, atLeastOnce()).debug(message);

        delegate.logDebug(message, aException);
        verify(logger, atLeastOnce()).debug(message, aException);
    }

    @Test
    public final void testLogError() {
        delegate.logError(message);
        verify(logger, atLeastOnce()).error(message);

        delegate.logError(message, aException);
        verify(logger, atLeastOnce()).error(message, aException);
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
    public void testLogInfo_Object() {
    }

    @Test
    public void testLogWarn_Object() {
    }

    @Test
    public void testLogError_Object() {
    }

    @Test
    public void testLogDebug_Object() {
    }

    @Test
    public void testLogInfo_Object_Throwable() {
    }

    @Test
    public void testLogWarn_Object_Throwable() {
    }

    @Test
    public void testLogError_Object_Throwable() {
    }

    @Test
    public void testLogDebug_Object_Throwable() {
    }

    @Test
    public void testLogData_Map() {
    }

    @Test
    public void testLogData_Map_Throwable() {
    }

    @Test
    public void testLogKey() {
    }
}
