package com.segurosbolivar.automation.commons;

import com.segurosbolivar.automation.commons.helpers.DriverFactory;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class TestListener  implements ITestListener{

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
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("THIS TEST FAILED!");
        //add log
        takeScreenshot("THIS TEST FAILED!");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

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
}
