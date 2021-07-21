package com.actoJava.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static InputStream fileInputStream;
    private static Properties prop;

    public static Properties getAllProperties() {

        prop = new Properties();

        try {
            //read properties file
            String propFilePath = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";
            fileInputStream = new FileInputStream(propFilePath);

            // load properties file in Properties
            prop.load(fileInputStream);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

    public static void cleanUp() {
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
                System.out.println("Stream is cleaned up!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
