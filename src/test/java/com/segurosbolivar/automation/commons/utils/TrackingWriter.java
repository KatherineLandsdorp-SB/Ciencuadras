package com.segurosbolivar.automation.commons.utils;


import com.segurosbolivar.automation.commons.Services;

public class TrackingWriter {

    public void setCaseExecution(TestingExecution testingExecution) {
        Services.setCaseExecution(testingExecution.idExecution, testingExecution.testName, testingExecution.executionState, PropertyManager.getConfigValueByKey("idTypeExecution"), testingExecution.startExecution , testingExecution.endExecution);
    }
}
