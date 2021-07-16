package com.segurosbolivar.automation.commons.jira.integration;


import com.segurosbolivar.automation.commons.jira.zapi.Utils.PropertiesParser;
import com.segurosbolivar.automation.commons.rcarz.jiraclient.*;
import com.segurosbolivar.automation.commons.rcarz.jiraclient.Issue.FluentCreate;

public class JiraServiceProvider {

    private JiraClient jira;
    private String project;
    private  String newIssueString;
    public  String idIssueString;

    public JiraServiceProvider() throws JiraException {
       String urlJira = PropertiesParser.getJiraUrl();
       String usernameJira = PropertiesParser.getUsername();
       String passwordJira = PropertiesParser.getPassword();
       BasicCredentials creds = new BasicCredentials(usernameJira, passwordJira);

        // initialize the jira client with the url and the credentials
        jira = new JiraClient(urlJira, creds);
        this.project = project;
    }

    public String createJiraIssue(String issueType, String summary, String description, String userResponsible) {
        /* Create a new issue. */

        try {
            FluentCreate newIssueFluentCreate = jira.createIssue(project, issueType);
            // Add the summary
            newIssueFluentCreate.field(Field.SUMMARY, summary);
            // Add the description
            newIssueFluentCreate.field(Field.DESCRIPTION, description);

            newIssueFluentCreate.field(Field.ASSIGNEE, userResponsible);

            // create the issue in the jira server
            Issue newIssue = newIssueFluentCreate.execute();

            System.out.println("Se creó un nuevo issue con ID de Jira: " + newIssue + ", Tipo de issue: " + issueType);
            idIssueString = newIssue.getId();
            newIssueString = String.valueOf(newIssue);


        } catch (JiraException e) {
            e.printStackTrace();
        }

        // Retorna el nuevo issue creado
        return newIssueString;
    }


}