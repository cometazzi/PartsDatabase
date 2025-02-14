package org.badmotivator.persistence;

import java.io.*;
import java.util.*;

/**
 * @author Eric Knapp
 *
 */
public interface PropertiesLoader{

    default Properties loadProperties(String propertiesFilePath) throws Exception {
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/database.properties"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
            throw ioException;
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        }
        return properties;
    }
}