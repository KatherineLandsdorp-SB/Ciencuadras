package com.segurosbolivar.automation.commons.utils;

import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

public class Utils {
    public static String getStringDate(long milliseconds, String dateFormat) {
        Date startDate = new Date(milliseconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(Constants.TIME_ZONE_GTM_5));
        return simpleDateFormat.format(startDate);
    }

    public static String getStringDate(String dateFormat) {
        Date startDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(Constants.TIME_ZONE_GTM_5));
        return simpleDateFormat.format(startDate);
    }

    public static Test getTestAnnotation(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class);
    }


//    public static TestingExecution getExecutionInfo(ITestResult iTestResult) {
//
//        Number duration = (iTestResult.getEndMillis() - iTestResult.getStartMillis());
//        TestingExecution testingExecution = new TestingExecution();
//        testingExecution.idCaseExecution = Utils.getTimeStampMils();
//        testingExecution.dateExecution = Utils.getStringDate(iTestResult.getStartMillis(), "dd/MM/yyyy");
//        testingExecution.caseName = iTestResult.getMethod().getDescription();
//        testingExecution.suiteName = Utils.getTestAnnotation(iTestResult).suiteName();
//        testingExecution.startExecution = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(iTestResult.getStartMillis());
//        testingExecution.endExecution = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(iTestResult.getEndMillis());
//        testingExecution.testName = Utils.getTestAnnotation(iTestResult).testName();
//        testingExecution.executionTime = duration.toString();
//        testingExecution.methodName = iTestResult.getMethod().getMethodName();
//        testingExecution.pathClassName = iTestResult.getTestClass().getName();
//        testingExecution.portal = PropertyManager.getConfigValueByKey("portal");
//        testingExecution.area = PropertyManager.getConfigValueByKey("area");
//        testingExecution.executor = PropertyManager.getConfigValueByKey("executor");
//        testingExecution.providerName = PropertyManager.getConfigValueByKey("providerName");
//        testingExecution.manualExecutionTime = PropertyManager.getConfigValueByKey("manualExecutionTime");
//        testingExecution.environment = PropertyManager.getConfigValueByKey("environment");
//        testingExecution.automationType = PropertyManager.getConfigValueByKey("automationType");
//        testingExecution.jiraIssue = PropertyManager.getConfigValueByKey("jiraIssue");
//
//        return testingExecution;
//    }

    public static long getTimeStampSeconds() {
        Instant instant = Instant.now();
        return instant.getEpochSecond();
    }

    public static String getNameExecution() {
        Date myDate = new Date();
        return "UI_" + PropertyManager.getConfigValueByKey("portal") + "_" + PropertyManager.getConfigValueByKey("suite") + "_" + new SimpleDateFormat("yyyy_MM_dd_hh:mm:ss").format(myDate);
    }

    public static long getTimeStampMils() {
        Instant instant = Instant.now();
        return instant.toEpochMilli();
    }
}
