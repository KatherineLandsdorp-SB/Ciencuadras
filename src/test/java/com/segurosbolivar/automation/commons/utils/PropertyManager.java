package com.segurosbolivar.automation.commons.utils;

import lombok.extern.log4j.Log4j2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j2
public class PropertyManager {
    private static final String configFilePath = System.getProperty("user.dir") + "/src/test/java/resources/config.properties";
    private static final Properties properties = new Properties();

    private static void loadProperties() {
        try {
            properties.load(new FileInputStream(configFilePath));

        } catch (IOException ex) {
            log.error("Configuration properties file cannot be found");
            ex.printStackTrace();
        }
    }

    public static String getConfigValueByKey(String key) {
        loadProperties();
        return resolveValueWithEnvVars(properties.getProperty(key));
    }

    private static String resolveValueWithEnvVars(String value) {
        if (null == value) {
            return null;
        }

        Pattern p = Pattern.compile("\\$\\{(\\w+)\\}|\\$(\\w+)");
        Matcher m = p.matcher(value);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String envVarName = null == m.group(1) ? m.group(2) : m.group(1);
            String envVarValue = System.getenv(envVarName);

            if (null == envVarValue) {
                try {
                    log.fatal("Environment variable ${" + envVarName + "}" + " doesn't exist");
                    throw new Exception("Environment variable ${" + envVarName + "}" + " doesn't exist");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

            if (envVarValue.isEmpty()) {
                try {
                    log.fatal("Environment variable  ${" + envVarName + "}" + " can't be empty");
                    throw new Exception("Environment variable ${" + envVarName + "}" + " can't be empty");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

            m.appendReplacement(sb,
                    null == envVarValue ? "" : Matcher.quoteReplacement(envVarValue));
        }
        m.appendTail(sb);
        return sb.toString();
    }
}
