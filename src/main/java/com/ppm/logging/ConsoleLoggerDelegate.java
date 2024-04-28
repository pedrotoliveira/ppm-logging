package com.ppm.logging;

import org.apache.logging.log4j.Logger;

import java.util.Map;

/**
 *
 * @author pedrotoliveira
 */
public class ConsoleLoggerDelegate implements ConsoleLogger {

    private final Logger logger;

    public ConsoleLoggerDelegate(final Logger logger) {
        this.logger = logger;
    }

    @Override
    public ConsoleLogger info(Object message, Throwable t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ConsoleLogger warn(Object message, Throwable t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ConsoleLogger error(Object message, Throwable t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ConsoleLogger debug(Object message, Throwable t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ConsoleLogger fatal(Object message, Throwable t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LogData logData(Map<String, Object> logData, Throwable t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LogData log(Object object, Throwable t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LogData log(Object object, Throwable t, MessagePatterns pattern) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
