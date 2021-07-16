package com.segurosbolivar.automation.commons;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.segurosbolivar.automation.commons.helpers.driver.DriverConstants;
import com.segurosbolivar.automation.commons.helpers.driver.mobile.DriverMobileBase;
import com.segurosbolivar.automation.commons.helpers.driver.web.DriverWebBase;
import com.segurosbolivar.automation.commons.models.CaseExecution;
import com.segurosbolivar.automation.commons.models.Execution;
import com.segurosbolivar.automation.commons.services.MetricsService;
import com.segurosbolivar.automation.commons.utils.Constants;
import com.segurosbolivar.automation.commons.utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.annotations.TestType;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;

@Log4j2
public class TestListener implements ITestListener {

    @Attachment(value = "Test Evidence Mobile", type = "image/png")
    public byte[] takeMobileScreenshot() {
        AppiumDriver<?> driver = DriverMobileBase.getCurrentDriver();
        TakesScreenshot scrShot = null;
        try {
            Allure.addAttachment("failure", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            scrShot = ((TakesScreenshot) driver);

        } catch (Exception ex) {
            log.error("Mobile Driver: " + driver);
        }
        return scrShot.getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Test Evidence Web", type = "image/png")
    public byte[] takeWebScreenshot() {
        WebDriver driver = DriverWebBase.getCurrentDriver();
        TakesScreenshot scrShot = null;
        try {
            Allure.addAttachment("failure", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            scrShot = ((TakesScreenshot) driver);
        } catch (Exception ex) {
            log.error("Web Driver: " + driver);
        }
        return scrShot.getScreenshotAs(OutputType.BYTES);
    }


    @Override
    public void onTestStart(ITestResult iTestResult) {
        Test testAnnotation = Utils.getTestAnnotation(iTestResult);
        boolean isLocalDriver = Boolean.parseBoolean(DriverConstants.DRIVER_LOCAL);
        if (!isLocalDriver) {
            DriverWebBase.getDriverRemote(testAnnotation.description());
        }
    }

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Test testAnnotation = Utils.getTestAnnotation(iTestResult);
        TestType testType = testAnnotation.testType();

        boolean isLocalDriver = Boolean.parseBoolean(DriverConstants.DRIVER_LOCAL);
        if (testType == TestType.WEB) {
            takeWebScreenshot();
            if (!isLocalDriver) {
                WebDriver driver = DriverWebBase.getCurrentDriver();
                ((JavascriptExecutor) driver).executeScript("lambda-status=failed");
            }
            DriverWebBase.quitDriver();
        } else if (testType == TestType.MOBILE) {
            takeMobileScreenshot();
            DriverMobileBase.quitDriver();
        } else if (testType == TestType.HYBRID) {
            takeWebScreenshot();
            takeMobileScreenshot();
            DriverMobileBase.quitDriver();
            DriverWebBase.quitDriver();
        }
        sendTestMethodStatus(iTestResult, Constants.TEST_FAIL);
        /*

         System.out.println("THIS TEST FAILED!");
        String idTest = Utils.getTestAnnotation(result).testName();
        String description = Utils.getTestAnnotation(result).description();
        String idIssue = mp.get(Integer.valueOf(idTest));

        IssueDOM issue = null;
        try {
            logger.info("COSULTANDO CASO DE PRUEBA " + idIssue);
            issue = this.conn.getIssue(idIssue);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        logger.info("INICIANDO EJECUCION DE LA SUITE DE PRUEBAS: MARCACION DE LA PRUEBA PARA LA EJECUCION");
        try {
            TestObject   currentTest = TestObject.createTestObject(issue, this.versionId, this.nameCycle, this.testCycleList);
            currentTest.getExecutionForTest();
            currentTest.markTestStatusTo(TestStatus.iStatus_FAIL);
            logger.info("ESTADO DE LA PRUEBA: FAIL");

            String issueSummary = "CASO ID - " + idTest+" - ERROR"; // Campo: Resumen, en JIRA
            String issueDescription = description; // Campo: Descripción, en JIRA
            String userResponsibleError = "";
            String idIssueError = jiraSP.createJiraIssue("Error", issueSummary, issueDescription, userResponsibleError);
            this.conn.linkIssues(idIssue,idIssueError,"");
            this.conn.DoTransitionIssue(idIssueError,"");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
         */
    }


    @SneakyThrows
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        boolean isLocalDriver = Boolean.parseBoolean(DriverConstants.DRIVER_LOCAL);

        Object[] params = iTestResult.getParameters();
        if (params.length > 0) {
            Data data = (Data) params[0];
            System.out.println(data.getData().toJSONString());

        }
        /*
        if (!isLocalDriver) {
            WebDriver driver = DriverWebBase.getCurrentDriver();
            ((JavascriptExecutor) driver).executeScript("lambda-status=passed");
        }

         */
        sendTestMethodStatus(iTestResult, Constants.TEST_SUCCESS);
    }

    private void sendTestMethodStatus(ITestResult iTestResult, Integer idStateExecution) throws JsonProcessingException {
        Test testAnnotation = Utils.getTestAnnotation(iTestResult);
        Integer idExecution = Execution.id;
        CaseExecution caseExecution = CaseExecution.builder()
                .idExecution(idExecution)
                .idCase(testAnnotation.id())
                .idStateExecution(idStateExecution)
                .startDate(new SimpleDateFormat(Constants.DATE_TIME_FORMAT).format(iTestResult.getStartMillis()))
                .endDate(new SimpleDateFormat(Constants.DATE_TIME_FORMAT).format(iTestResult.getEndMillis()))
                .build();
        MetricsService.setCaseExecution(caseExecution);
    }

}
