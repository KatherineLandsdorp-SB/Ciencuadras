package com.segurosbolivar.automation.commons.utils;


import com.segurosbolivar.automation.commons.Services;

public class TrackingWriter {

    public void setCaseExecution(TestingExecution testingExecution) {
        Services.setCaseExecution(testingExecution.idExecution, testingExecution.testName, testingExecution.executionState, testingExecution.startExecution , testingExecution.endExecution, PropertyManager.getConfigValueByKey("pathS3Output") + testingExecution.testName + "-" + TestingExecution.idExecution + ".json", null);
    }
}
