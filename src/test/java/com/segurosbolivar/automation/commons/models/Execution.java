package com.segurosbolivar.automation.commons.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Execution {
    public static Integer id;
    public Integer idSuite;
    public Integer idEnvironment;
    public Integer idStateExecution;
    public Integer idProvider;
    public Integer idTypeAutomation;
    public Integer idTypeExecution;
    public String requestDate;
    public String jiraProject;
    public String jiraIssue;
    public String executor;
    public String idCycleJira;
}
