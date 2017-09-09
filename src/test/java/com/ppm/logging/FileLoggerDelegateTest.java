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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

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
        this.delegate = new FileLoggerDelegate(logger);
    }

    @Test
    public final void testLogInfo() {
        delegate.info(message);
        verify(logger, atLeastOnce()).info(message);

        delegate.info(message, aException);
        verify(logger, atLeastOnce()).info(message, aException);
    }

    @Test
    public final void testLogWarn() {
        delegate.warn(message);
        verify(logger, atLeastOnce()).warn(message);

        delegate.warn(message, aException);
        verify(logger, atLeastOnce()).warn(message, aException);
    }

    @Test
    public final void testLogDebug() {
        delegate.debug(message);
        verify(logger, atLeastOnce()).debug(message);

        delegate.debug(message, aException);
        verify(logger, atLeastOnce()).debug(message, aException);
    }

    @Test
    public final void testLogError() {
        delegate.error(message);
        verify(logger, atLeastOnce()).error(message);

        delegate.error(message, aException);
        verify(logger, atLeastOnce()).error(message, aException);
    }

    @Test
    public final void testLogKeyValue() {
        delegate.key("key=").value("value").asInfo();
        verify(logger, atLeastOnce()).info("key=value ");

        delegate.key("key=").value("value").asDebug();
        verify(logger, atLeastOnce()).debug("key=value ");

        delegate.key("key=").value("value").asWarn();
        verify(logger, atLeastOnce()).warn("key=value ");

        delegate.key("key=").value("value").asError();
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

    /**
     * Test of create method, of class FileLoggerDelegate.
     */
    @Test
    public void testCreate() {
    }

    /**
     * Test of info method, of class FileLoggerDelegate.
     */
    @Test
    public void testInfo_Object() {
    }

    /**
     * Test of warn method, of class FileLoggerDelegate.
     */
    @Test
    public void testWarn_Object() {
    }

    /**
     * Test of error method, of class FileLoggerDelegate.
     */
    @Test
    public void testError_Object() {
    }

    /**
     * Test of debug method, of class FileLoggerDelegate.
     */
    @Test
    public void testDebug_Object() {
    }

    /**
     * Test of info method, of class FileLoggerDelegate.
     */
    @Test
    public void testInfo_Object_Throwable() {
    }

    /**
     * Test of warn method, of class FileLoggerDelegate.
     */
    @Test
    public void testWarn_Object_Throwable() {
    }

    /**
     * Test of error method, of class FileLoggerDelegate.
     */
    @Test
    public void testError_Object_Throwable() {
    }

    /**
     * Test of debug method, of class FileLoggerDelegate.
     */
    @Test
    public void testDebug_Object_Throwable() {
    }

    /**
     * Test of key method, of class FileLoggerDelegate.
     */
    @Test
    public void testKey() {
    }

    /**
     * Test of fatal method, of class FileLoggerDelegate.
     */
    @Test
    public void testFatal_Object() {
    }

    /**
     * Test of log method, of class FileLoggerDelegate.
     */
    @Test
    public void testLog_Object() {
    }

    /**
     * Test of log method, of class FileLoggerDelegate.
     */
    @Test
    public void testLog_Object_MessagePatterns() {
    }

    /**
     * Test of fatal method, of class FileLoggerDelegate.
     */
    @Test
    public void testFatal_Object_Throwable() {
    }

    /**
     * Test of log method, of class FileLoggerDelegate.
     */
    @Test
    public void testLog_Object_Throwable() {
    }

    /**
     * Test of log method, of class FileLoggerDelegate.
     */
    @Test
    public void testLog_3args() {
    }
}
