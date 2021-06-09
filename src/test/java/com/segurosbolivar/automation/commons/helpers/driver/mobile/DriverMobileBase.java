package com.segurosbolivar.automation.commons.helpers.driver.mobile;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverMobileBase {

    private static List<DriverMobileFactory> webDriverThreadPool =
            Collections.synchronizedList(new ArrayList<DriverMobileFactory>());
    private static ThreadLocal<DriverMobileFactory> driverThread;

    public static void instantiateDriverObject() {
        driverThread = new ThreadLocal<DriverMobileFactory>() {
            @Override
            protected DriverMobileFactory initialValue() {
                DriverMobileFactory webDriverThread = new DriverMobileFactory();
                webDriverThreadPool.add(webDriverThread);
                return webDriverThread;
            }
        };
    }

    public static AppiumDriver<?> getDriver() throws Exception {
        return driverThread.get().getDriver();
    }

    public static void quitDriver() {
        driverThread.get().quitDriver();
    }

    public static AppiumDriver<?> getCurrentDriver() {
        return driverThread.get().getCurrentDriver();
    }

    public static void closeDriverObjects() throws MalformedURLException {
        for (DriverMobileFactory webDriverThread : webDriverThreadPool) {
            webDriverThread.quitDriver();
        }
    }
}
