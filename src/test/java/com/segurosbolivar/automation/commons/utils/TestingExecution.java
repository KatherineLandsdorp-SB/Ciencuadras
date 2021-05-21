package com.segurosbolivar.automation.commons.utils;

import lombok.Data;
import org.codehaus.jettison.json.JSONArray;

@Data
public class TestingExecution {
    public static String idExecution;
    public static String nameExecution;
    public static String testName;
    public long idCaseExecution;
    public String dateExecution;
    public String startExecution;
    public String endExecution;
    public String area;
    public String suiteName;
    public String caseName;
    public String methodName;
    public String pathClassName;
    public String executionState;
    public String portal;
    public String executor;
    public String providerName;
    public String executionTime;
    public String manualExecutionTime;
    public String environment;
    public String automationType;
    public String jiraIssue;
    public static JSONArray dataObect;
}
