package com.segurosbolivar.automation.commons.jira.integration;

import com.segurosbolivar.automation.commons.jira.integration.JiraServiceProvider;
import com.segurosbolivar.automation.commons.jira.zapi.ConnectionManager;
import com.segurosbolivar.automation.commons.rcarz.jiraclient.JiraException;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class JiraClientFactory {

    private static JiraServiceProvider jiraObject;
    private static ConnectionManager connection;

    public static void InitJiraServiceProvider(){
        try{
            jiraObject = new JiraServiceProvider();
            connection = ConnectionManager.getInstance();
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    public static JiraServiceProvider getClient() throws JiraException {
        return jiraObject;
    }

    public static ConnectionManager getJiraApi(){
        return connection;
    }
}
