package com.segurosbolivar.automation.utils;

import lombok.Data;

@Data
public class TestingExecution {

    public String id;
    public String dateExecution;
    public String startExecution;
    public String endExecution;
    public String area;
    public String suiteName;
    public String caseName;
    public String testName;
    public String methodName;
    public String pathClassName;
    public String executionState;
    public String portal;
    public String automatizador;
    public String providerName;
    public String executionTime;
    public String manualExecutionTime;
    public String environment;
    public String automationType;
}
