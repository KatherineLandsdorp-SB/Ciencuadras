package com.segurosbolivar.automation.utils;

import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Utils {

    public static String getStringDate(long milliseconds, String dateFormat) {
        Date startDate = new Date(milliseconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        return simpleDateFormat.format(startDate);
    }

    public static Test getTestAnnotation(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class);
    }

    public static TestingExecution getExecutionInfo(ITestResult iTestResult) {

        Number duration = (iTestResult.getEndMillis() - iTestResult.getStartMillis());

        TestingExecution testingExecution = new TestingExecution();
        testingExecution.idCaseExecution = iTestResult.getMethod().getId();
        testingExecution.dateExecution = Utils.getStringDate(iTestResult.getStartMillis(), "dd/MM/yyyy");
        testingExecution.caseName = iTestResult.getMethod().getDescription();
        testingExecution.suiteName = Utils.getTestAnnotation(iTestResult).suiteName();
        testingExecution.startExecution = Utils.getStringDate(iTestResult.getStartMillis(), "HH:mm:ss");
        testingExecution.endExecution = Utils.getStringDate(iTestResult.getEndMillis(), "HH:mm:ss");
        testingExecution.testName = Utils.getTestAnnotation(iTestResult).testName();
        testingExecution.executionTime = duration.toString();
        testingExecution.methodName = iTestResult.getMethod().getMethodName();
        testingExecution.pathClassName = iTestResult.getTestClass().getName();
        testingExecution.portal = PropertyManager.getConfigValueByKey("portal");
        testingExecution.area = PropertyManager.getConfigValueByKey("area");
        testingExecution.executor = PropertyManager.getConfigValueByKey("executor");
        testingExecution.providerName = PropertyManager.getConfigValueByKey("providerName");
        testingExecution.manualExecutionTime = PropertyManager.getConfigValueByKey("manualExecutionTime");
        testingExecution.environment = PropertyManager.getConfigValueByKey("environment");
        testingExecution.automationType = PropertyManager.getConfigValueByKey("automationType");
        testingExecution.jiraIssue = PropertyManager.getConfigValueByKey("jiraIssue");

        return testingExecution;
    }

    public static long getTimeStampSeconds() {
        Instant instant = Instant.now();
        return instant.getEpochSecond();
    }
}
