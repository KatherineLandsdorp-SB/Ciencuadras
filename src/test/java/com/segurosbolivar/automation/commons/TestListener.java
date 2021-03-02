package com.segurosbolivar.automation.commons;

import com.segurosbolivar.automation.commons.helpers.DriverFactory;
import com.segurosbolivar.automation.utils.ExcelWriter;
import com.segurosbolivar.automation.utils.PropertyManager;
import com.segurosbolivar.automation.utils.TestingExecution;
import com.segurosbolivar.automation.utils.Utils;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class TestListener implements ITestListener {

    private final boolean isLocalExecution = Boolean.parseBoolean(PropertyManager.getConfigValueByKey("driverLocal"));

    @Attachment(value = "Test Evidence", type = "image/png")
    public byte[] takeScreenshot(String description) {
        Allure.addAttachment(description, new ByteArrayInputStream(((TakesScreenshot) DriverFactory.getDriverFacade().getWebDriver()).getScreenshotAs(OutputType.BYTES)));
        TakesScreenshot scrShot = ((TakesScreenshot) DriverFactory.getDriverFacade().getWebDriver());
        return scrShot.getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }


    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("TEST SUCCESSFUL!");
        //add log
        takeScreenshot("TEST SUCCESSFUL!");

        if (!isLocalExecution) {
            WebDriver driver = DriverFactory.getDriverFacade().getWebDriver();
            ((JavascriptExecutor) driver).executeScript("lambda-status=passed");

        }

        this.sendTestMethodStatus(iTestResult, "TEST SUCCESSFUL");
    }


    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("THIS TEST FAILED!");
        //add log
        takeScreenshot("THIS TEST FAILED!");

        if (!isLocalExecution) {
            WebDriver driver = DriverFactory.getDriverFacade().getWebDriver();
            ((JavascriptExecutor) driver).executeScript("lambda-status=failed");

        }

        this.sendTestMethodStatus(iTestResult, "TEST FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        this.sendTestMethodStatus(iTestResult, "TEST SKIPPED");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    private void sendTestMethodStatus(ITestResult iTestResult, String executionState) {
        TestingExecution executionInfo = Utils.getExecutionInfo(iTestResult);
        executionInfo.executionState = executionState;
        ExcelWriter excel = new ExcelWriter("executions.xlsx");
        excel.write(executionInfo);
    }


}
