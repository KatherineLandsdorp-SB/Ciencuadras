package com.segurosbolivar.automation.commons.helpers;

import com.segurosbolivar.automation.utils.PropertyManager;
import org.awaitility.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class DriverFacade {

    RemoteWebDriver driver;
    WebDriverWait wait;
    int timeoutInSeconds = 60;


    private DesiredCapabilities capabilitiesSetUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platform", "MacOS Catalina");
//        capabilities.setCapability("browserName", "Safari");
//        capabilities.setCapability("version","13.0");
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "70.0");
        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("build", "Ui_Automation_Seguros_Bolivar_Structure");
        capabilities.setCapability("name", "Ui_Automation_Seguros_Bolivar_Structure_1");
        capabilities.setCapability("network", true); // To enable network logs
        capabilities.setCapability("visual", true); // To enable step by step screenshot
        capabilities.setCapability("video", true); // To enable video recording
        capabilities.setCapability("console", true); // To capture console logs
        return capabilities;
    }

    public DriverFacade() {
        if (!Boolean.valueOf(PropertyManager.getConfigValueByKey("driverLocal"))) {
            try {
                driver = new RemoteWebDriver(new URL("https://" + PropertyManager.getConfigValueByKey("lambdausername")
                        + ":" + PropertyManager.getConfigValueByKey("lambdapassword") +
                        PropertyManager.getConfigValueByKey("gridURL")), capabilitiesSetUp());
            } catch (MalformedURLException e) {
                System.out.println("Invalid grid URL");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        else{
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        }
        wait = new WebDriverWait(driver, timeoutInSeconds);
    }
    public WebDriver getWebDriver(){
        return driver;
    }



    public void waitForVisibilityOfElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void awaitToFindElement(By webElement) {
        await().atMost(1, TimeUnit.MINUTES)
                .pollInterval(Duration.ONE_SECOND)
                .until(() -> {
                    try {
                        driver.findElement(webElement);
                        return true;
                    } catch (NoSuchElementException e) {
                        return false;
                    }

                });
    }
}
