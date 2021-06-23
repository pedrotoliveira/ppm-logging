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
package com.ppm.logging;

import org.apache.logging.log4j.message.Message;

/**
 *
 * @author pedrotoliveira
 */
public class LogMessage implements Message {

    private static final long serialVersionUID = 7947629685272045055L;

    @Override
    public String getFormattedMessage() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getFormat() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object[] getParameters() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Throwable getThrowable() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
