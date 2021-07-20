package com.segurosbolivar.automation.commons;

import com.segurosbolivar.automation.commons.helpers.driver.mobile.DriverMobileBase;
import com.segurosbolivar.automation.commons.helpers.driver.web.DriverWebBase;
import com.segurosbolivar.automation.commons.models.Execution;
import com.segurosbolivar.automation.commons.services.MetricsService;
import com.segurosbolivar.automation.commons.services.utils.ServiceConstants;
import com.segurosbolivar.automation.commons.utils.Constants;
import com.segurosbolivar.automation.commons.utils.InitAutomation;
import com.segurosbolivar.automation.commons.utils.ReadXmlSuite;
import com.segurosbolivar.automation.commons.utils.Utils;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class Hooks {
    @BeforeSuite(alwaysRun = true)
    public void suiteUp(ITestContext iTestContext) throws Exception {

        //enable RestAssured logs
        InitAutomation.initRestAssured();
        //Init driver Factories
        InitAutomation.initDriverFactories();
        //start services  and send token to call other services
        InitAutomation.initServices();
        //Start services Jira
        InitAutomation.initJiraClient();

        //call elements
        Elements.initElements();

        // Register execution into database
        String pathXmlSuiteFile = iTestContext.getSuite().getXmlSuite().getFileName();
        Integer idSuite = ReadXmlSuite.getSuiteId(pathXmlSuiteFile);
        Execution executionRequest = Execution.builder()
                .idSuite(idSuite)
                .idProvider(ServiceConstants.PROVIDER_ID)
                .idTypeExecution(ServiceConstants.TYPE_EXECUTION_ID)
                .idTypeAutomation(ServiceConstants.TYPE_AUTOMATION_ID)
                .idEnvironment(ServiceConstants.ENVIRONMENT_ID)
                .idStateExecution(ServiceConstants.STATE_EXECUTION_ID)
                .executor(ServiceConstants.AUTOMATION_EXECUTOR)
                .requestDate(Utils.getStringDate(Constants.DATE_TIME_FORMAT))
                .build();
        Execution.id = MetricsService.setExecution(executionRequest);

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method) throws Exception {
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(Method method) {
        // DriverMobileBase.quitDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void closeDriverObjects() throws MalformedURLException {
        DriverMobileBase.closeDriverObjects();
        DriverWebBase.closeDriverObjects();
    }
}
