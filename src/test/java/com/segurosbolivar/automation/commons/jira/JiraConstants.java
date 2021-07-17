package com.segurosbolivar.automation.commons.jira;

import com.segurosbolivar.automation.commons.utils.PropertyManager;

public class JiraConstants {

    public static final String JIRA_URL= PropertyManager.getConfigValueByKey("jira.url");
    public static final String JIRA_USER = PropertyManager.getConfigValueByKey("jira.user_name");
    public static final String JIRA_PASSWORD = PropertyManager.getConfigValueByKey("jira.password");
    public static final String JIRA_NAME_PROJECT = PropertyManager.getConfigValueByKey("jira.name_project");
    public static final String JIRA_ID_EPIC_PLATFORM = PropertyManager.getConfigValueByKey("jira.id_epic_platform");
    public static final String JIRA_ID_HU_PROJECT = PropertyManager.getConfigValueByKey("jira.id_hu_project");
    public static final String JIRA_USER_NAME_RESPONSIBLE = PropertyManager.getConfigValueByKey("jira.user_name_responsible");
    public static final String JIRA_HOST =PropertyManager.getConfigValueByKey("jira.host");
    public static final String JIRA_PORT =PropertyManager.getConfigValueByKey("jira.port");
}
