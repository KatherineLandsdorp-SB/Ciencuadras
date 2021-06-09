package com.segurosbolivar.automation.commons.helpers.driver.web;

import com.segurosbolivar.automation.commons.utils.PropertyManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class DriverWebFactory {
    private RemoteWebDriver webDriver;

    RemoteWebDriver getDriver() {
        String platform = PropertyManager.getConfigValueByKey("webDriver").toLowerCase();

        if (null == webDriver) {

            if (platform.equals("chrome")) {
                webDriver = new ChromeDriver();
            }
            if (platform.equals("firefox")) {
                webDriver = new FirefoxDriver();
            }
        }
        return webDriver;
    }

    RemoteWebDriver getCurrentDriver() {
        return webDriver;
    }

    void quitDriver() {
        if (null != webDriver) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
