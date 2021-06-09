package com.segurosbolivar.automation.commons;
import com.segurosbolivar.automation.commons.helpers.DriverFactory;
import com.segurosbolivar.automation.commons.utils.PropertyManager;
import com.segurosbolivar.automation.commons.utils.TestingExecution;
import com.segurosbolivar.automation.commons.utils.TrackingWriter;
import com.segurosbolivar.automation.commons.utils.Utils;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import java.io.ByteArrayInputStream;

public class TestListener  implements ISuiteListener, ITestListener{

    private final boolean isLocalExecution = Boolean.parseBoolean(PropertyManager.getConfigValueByKey("driverLocal"));




    @Attachment(value = "Test Evidence", type = "image/png")
    public byte[] takeScreenshot(String description) {
        Allure.addAttachment(description, new ByteArrayInputStream(((TakesScreenshot) DriverFactory.getDriverFacade().getWebDriver()).getScreenshotAs(OutputType.BYTES)));
        TakesScreenshot scrShot = ((TakesScreenshot) DriverFactory.getDriverFacade().getWebDriver());
        return scrShot.getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        if (!isLocalExecution) {
                WebDriver driver = DriverFactory.getDriverFacade().getWebDriver();
                ((JavascriptExecutor) driver).executeScript("lambda-status=passed");
            }
         if((iTestResult.getAttribute("executionSuccess") == null)){
             iTestResult.setAttribute("executionSuccess", "true");
            this.sendTestMethodStatus(iTestResult, "4");
         }
    }


    @Override
    public void onTestFailure(ITestResult iTestResult) {
        WebDriver driver = DriverFactory.getDriverFacade().getWebDriver();

        if (!isLocalExecution) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=failed");
        }
        driver.quit();
        if((iTestResult.getAttribute("executionFailure") == null)) {
            iTestResult.setAttribute("executionFailure", "true");
            this.sendTestMethodStatus(iTestResult, "3");
        }
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

    @Override
    public void onStart(ISuite suite) {
    }

    @Override
    public void onFinish(ISuite suite) {

    }

    private void sendTestMethodStatus(ITestResult iTestResult, String executionState) {

        if (!Boolean.valueOf(PropertyManager.getConfigValueByKey("driverLocal"))) {
            TestingExecution executionInfo = Utils.getExecutionInfo(iTestResult);
            executionInfo.executionState = executionState;
            TrackingWriter write = new TrackingWriter();
            write.setCaseExecution(executionInfo);
        }

    }
}
