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

import java.util.Map;

/**
 * Holder of AsLevel
 *
 * @author Pedro T. Oliveira
 *
 */
public class AsLevelBuilder implements AsLevel {

    private final Map<String, Object> logData;
    private final FileLogger fileLoggerDelegate;
    private final RemoteLogger remoteLoggerDelegate;

    /**
     *
     * @param logData
     * @param fileLoggerDelegate
     * @param remoteLoggerDelegate
     */
    public AsLevelBuilder(Map<String, Object> logData, FileLogger fileLoggerDelegate,
            RemoteLogger remoteLoggerDelegate) {
        super();
        this.logData = logData;
        this.fileLoggerDelegate = fileLoggerDelegate;
        this.remoteLoggerDelegate = remoteLoggerDelegate;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ppm..util.logging.AsLevel#asInfo()
     */
    @Override
    public AsLevel asInfo() {
        fileLoggerDelegate.logData(logData).asInfo();
        remoteLoggerDelegate.logData(logData).asInfo();
        return this;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ppm..util.logging.AsLevel#asWarn()
     */
    @Override
    public AsLevel asWarn() {
        fileLoggerDelegate.logData(logData).asWarn();
        remoteLoggerDelegate.logData(logData).asWarn();
        return this;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ppm..util.logging.AsLevel#asError()
     */
    @Override
    public AsLevel asError() {
        fileLoggerDelegate.logData(logData).asError();
        remoteLoggerDelegate.logData(logData).asError();
        return this;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ppm..util.logging.AsLevel#asDebug()
     */
    @Override
    public AsLevel asDebug() {
        fileLoggerDelegate.logData(logData).asDebug();
        remoteLoggerDelegate.logData(logData).asDebug();
        return this;
    }
}
