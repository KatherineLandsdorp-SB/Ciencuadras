package com.segurosbolivar.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static String configFilePath = System.getProperty("user.dir") + "/src/test/java/resources/config.properties";
    private static Properties properties = new Properties();

    private static void loadProperties() {
        try {
            properties.load(new FileInputStream(configFilePath));

        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
    }

    public static String getConfigValueByKey(String key) {
        loadProperties();
        return properties.getProperty(key);
    }
}
