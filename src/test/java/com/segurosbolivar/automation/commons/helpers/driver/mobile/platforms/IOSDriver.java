package com.segurosbolivar.automation.commons.helpers.driver.mobile.platforms;

import com.segurosbolivar.automation.commons.utils.PropertyManager;
import io.appium.java_client.AppiumDriver;

public class IOSDriver {
    public static AppiumDriver<?> getDriver() throws Exception {

        if (!Boolean.parseBoolean(PropertyManager.getConfigValueByKey("driverLocal")))
            return getRemoteDriver();
        return getLocalDriver();
    }

    private static AppiumDriver<?> getLocalDriver() throws Exception {

        throw new Exception("implmentacion driver IOS Local  pendiente");
    }

    private static AppiumDriver<?> getRemoteDriver() throws Exception {
        throw new Exception("implmentacion driver IOS remoto  pendiente");
    }
}