/*
 * Copyright (c) - PPM Sistemas de Informacao LTDA, Todos os direitos reservados
 *
 * Este arquivo e uma propriedade confidencial da PPM Sistemas de Informacao LTDA.
 * Nenhuma parte do mesmo pode ser copiada, reproduzida, impressa ou transmitida
 * por qualquer meio sem autorizacao expressa e por escrito de um representante
 * legal da PPM Sistemas de Informacao LTDA.
 *
 * All rights reserved
 *
 * This file is a confidential property of PPM Sistemas de Informacao LTDA.
 * No part of this file may be reproduced or copied in any form or by any means
 * without written permisson from an authorized person from PPM Sistemas de Informacao
 * LTDA.
 *
 */
package com.ppm.logging;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.logging.log4j.Level;

/**
 *
 * @author pedrotoliveira
 */
public class PropertiesLoader {

    private static final String PPM_LOGGING_PROPERTIES = "ppm-logging.properties";
    private final Properties properties;

    public PropertiesLoader(Properties properties) {
        this.properties = properties;
    }

    public static PropertiesLoader load() {
        try {
            URL url = ClassLoader.getSystemResource(PPM_LOGGING_PROPERTIES);
            if (url == null) {
                throw new FileNotFoundException(PPM_LOGGING_PROPERTIES + " Not Found!");
            }
            Properties prop = new Properties();
            prop.load(url.openStream());
            return new PropertiesLoader(prop);
        } catch (IOException ex) {
            throw new IllegalStateException("Error=\"Loading ppm-logging.properties\","
                    + " Message=\"" + ex.getMessage() + "\"",
                    ex);
        }
    }

    Level getRootLevel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
