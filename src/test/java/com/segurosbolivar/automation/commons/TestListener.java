package com.segurosbolivar.automation.commons;

import com.segurosbolivar.automation.commons.helpers.driver.mobile.DriverMobileBase;
import com.segurosbolivar.automation.commons.helpers.driver.web.DriverWebBase;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.util.Optional;

public class TestListener implements ITestListener {

    @Attachment(value = "Test Evidence Mobile", type = "image/png")
    public byte[] takeMobileScreenshot(String description) {
        AppiumDriver<?> driver = DriverMobileBase.getCurrentDriver();
        Allure.addAttachment(description, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        TakesScreenshot scrShot = DriverMobileBase.getCurrentDriver();
        return scrShot.getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Test Evidence Web", type = "image/png")
    public byte[] takeWebScreenshot() {
        Allure.addAttachment("failure", new ByteArrayInputStream(((TakesScreenshot) DriverWebBase.getCurrentDriver()).getScreenshotAs(OutputType.BYTES)));

        TakesScreenshot scrShot = ((TakesScreenshot) DriverWebBase.getCurrentDriver());
        return scrShot.getScreenshotAs(OutputType.BYTES);
    }


    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Optional<WebDriver> webDriver = Optional.ofNullable(DriverWebBase.getCurrentDriver());
        Optional<AppiumDriver<?>> mobileDriver = Optional.ofNullable(DriverMobileBase.getCurrentDriver());

        if (webDriver.isPresent()) {
            takeWebScreenshot();
        }

        if (mobileDriver.isPresent()) {
            takeMobileScreenshot("failure");
        }
    }
}
