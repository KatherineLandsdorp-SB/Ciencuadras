package com.segurosbolivar.automation.commons.jira.zapi.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by Chaitanya on 31-May-15.
 * Update by Sandra M. Arias R. 6-Nov-20.
 */
public class PropertiesParser {
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String JIRA_URL = "jira.url";
    public static final String JIRA_PORT = "jira.port";
    public static final String JIRA_HOST = "jira.host";
    public static final String JIRA_VERSION = "jira.version";
    public static final String JIRA_PROJECT = "jira.project";
    public static final String JIRA_PROJECT_NAME = "jira.projectName";
    public static final String JIRA_TESTISSUETYPE = "jira.testIssueType";
    public static final String ZEPHYR_CYCLE = "zephyr.cycle";
    public static final String ZEPHYR_TESTKEY = "zephyr.testkey";
    static Logger logger = Logger.getLogger(PropertiesParser.class.getName());
    static Properties properties;
    static InputStream inputStream;

    private static PropertiesParser propertiesParser = new PropertiesParser();


    public static PropertiesParser getInstance()
    {
        return propertiesParser;
    }


    PropertiesParser() {
        try {
            // TODO : Remove hard coding
            inputStream = new FileInputStream("src/test/java/resources/default.properties");
            properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
        } catch (FileNotFoundException e) {
            logger.severe("Properties file not found!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        //inputStream = new FileInputStream("C:\\Users\\Chaitanya\\Desktop\\ZAPI\\src\\main\\resources\\default.properties");
    }

    public static String getProperty(String propertyName) {
        return PropertiesParser.getInstance().properties.getProperty(propertyName);
    }

    public static String getUsername() {
        return PropertiesParser.getProperty(USERNAME);
    }

    public static String getPassword() {
        return PropertiesParser.getProperty(PASSWORD);
    }

    public static String getJiraUrl() {
        return PropertiesParser.getProperty(JIRA_URL);
    }

    public static int getJiraPort() {
        return Integer.parseInt(PropertiesParser.getProperty(JIRA_PORT));
    }

    public static String getJiraHost() {
        return PropertiesParser.getProperty(JIRA_HOST);
    }

    public static String getVersion() {
        return PropertiesParser.getProperty(JIRA_VERSION);
    }

    public static String getCycle() {
        return PropertiesParser.getProperty(ZEPHYR_CYCLE);
    }

    public static String getTestKey() {
        return PropertiesParser.getProperty(ZEPHYR_TESTKEY);
    }

    public static String getProject() {
        return PropertiesParser.getProperty(JIRA_PROJECT);
    }

    public static String getProjectName() {
        return PropertiesParser.getProperty(JIRA_PROJECT_NAME);
    }

    public static String getJiraTestIssueType() {
        return PropertiesParser.getProperty(JIRA_TESTISSUETYPE);
    }

    /*public static String getUsernameFromTerminal() {
        return System.getProperty("jiraUsername");
    }*/

  /*  public static String getPasswordFromTerminal() {
        return System.getProperty("jiraPassword");
    }*/
}
