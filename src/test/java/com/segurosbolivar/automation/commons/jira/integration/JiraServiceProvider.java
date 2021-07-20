package com.segurosbolivar.automation.commons.jira.integration;


import com.segurosbolivar.automation.commons.jira.JiraConstants;
import com.segurosbolivar.automation.commons.jira.zapi.Utils.PropertiesParser;
import com.segurosbolivar.automation.commons.rcarz.jiraclient.*;
import com.segurosbolivar.automation.commons.rcarz.jiraclient.Issue.FluentCreate;

public class JiraServiceProvider {

    private JiraClient jira;
    private String project;
    private String userResponsible;
    private String parentIdIssue;

    public  String idIssueString;

    public JiraServiceProvider() throws JiraException {
       String urlJira = JiraConstants.JIRA_URL;
       String usernameJira = JiraConstants.JIRA_USER;
       String passwordJira = JiraConstants.JIRA_PASSWORD;
       this.project = JiraConstants.JIRA_NAME_PROJECT;
       this.userResponsible = JiraConstants.JIRA_USER_NAME_RESPONSIBLE;
       this.parentIdIssue = JiraConstants.JIRA_ID_HU_PROJECT;
       BasicCredentials creds = new BasicCredentials(usernameJira, passwordJira);

        // initialize the jira client with the url and the credentials
        jira = new JiraClient(urlJira, creds);

    }

    public String createJiraIssue(String issueType, String summary, String description) {
        String issueKey="";
        try {
            FluentCreate newIssueFluentCreate = jira.createIssue(project, issueType);
            // Add the summary
            newIssueFluentCreate.field(Field.SUMMARY, summary);
            // Add the description
            newIssueFluentCreate.field(Field.DESCRIPTION, description);
            // Add the User responsible
            if(!userResponsible.equals("none")) {
                newIssueFluentCreate.field(Field.ASSIGNEE, userResponsible);
            }
            // Add the parent
            newIssueFluentCreate.field(Field.PARENT,parentIdIssue);
            // create the issue in the jira server
            Issue newIssue = newIssueFluentCreate.execute();
            //System.out.println("Se creo un nuevo issue con ID de Jira: " + newIssue + ", Tipo de issue: " + issueType);
            issueKey = String.valueOf(newIssue);

        } catch (JiraException e) {
            e.printStackTrace();
        }
        return issueKey;
    }


}