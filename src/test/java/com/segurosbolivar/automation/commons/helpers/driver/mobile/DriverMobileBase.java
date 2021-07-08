package com.segurosbolivar.automation.commons.helpers.driver.mobile;

import com.segurosbolivar.automation.commons.helpers.driver.mobile.platforms.AndroidDriver;
import com.segurosbolivar.automation.commons.helpers.driver.mobile.platforms.IOSDriver;
import com.segurosbolivar.automation.commons.utils.PropertyManager;
import io.appium.java_client.AppiumDriver;
import lombok.extern.log4j.Log4j2;

import java.net.MalformedURLException;

@Log4j2
public class DriverMobileBase {

    private static AppiumDriver<?> mobileDriver;

    public static void instantiateDriverObject() {
    }

    public static AppiumDriver<?> getDriver() throws Exception {
        if (null == mobileDriver) {
            String option = PropertyManager.getConfigValueByKey("mobileDriver").toLowerCase();
            switch (option) {
                case "android":
                    return mobileDriver = AndroidDriver.getDriver();
                case "ios":
                    return mobileDriver = IOSDriver.getDriver();
                default:
                    throw new Exception("Driver" + option + "Not Found");
            }
        }
        return mobileDriver;

    }

    public static void quitDriver() {
        if (null != mobileDriver) {
            try {
                mobileDriver.quit();
                mobileDriver = null;

            } catch (Exception ex) {
                log.warn(ex.getMessage());
            }
        }
    }

    public static AppiumDriver<?> getCurrentDriver() {
        return mobileDriver;
    }

    public static void closeDriverObjects() throws MalformedURLException {
        quitDriver();
    }
}
