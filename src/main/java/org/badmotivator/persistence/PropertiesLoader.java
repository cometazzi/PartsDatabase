package org.badmotivator.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;

/**
 * @author Eric Knapp
 *
 */
public interface PropertiesLoader{
    Logger logger = LogManager.getLogger(PropertiesLoader.class);

    default Properties loadProperties(String propertiesFilePath) throws Exception {
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/database.properties"));
        } catch (IOException ioException) {
            logger.error("Error reading properties file: " + ioException);
            throw ioException;
        } catch (Exception exception) {
            logger.error("Error reading properties file: " + exception);
            throw exception;
        }
        return properties;
    }
}