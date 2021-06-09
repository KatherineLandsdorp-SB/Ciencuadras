package com.segurosbolivar.automation.commons.helpers.driver.mobile;

import com.segurosbolivar.automation.commons.helpers.driver.mobile.platforms.AndroidDriver;
import com.segurosbolivar.automation.commons.helpers.driver.mobile.platforms.IOSDriver;
import com.segurosbolivar.automation.commons.utils.PropertyManager;
import io.appium.java_client.AppiumDriver;



public class DriverMobileFactory {
    private AppiumDriver<?> mobileDriver;

    AppiumDriver<?> getDriver() throws Exception {

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

    AppiumDriver<?> getCurrentDriver() {
        return mobileDriver;
    }

    void quitDriver() {
        if (null != mobileDriver) {
            mobileDriver.quit();
            mobileDriver = null;
        }
    }
}