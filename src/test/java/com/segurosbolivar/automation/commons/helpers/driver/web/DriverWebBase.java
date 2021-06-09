package com.segurosbolivar.automation.commons.helpers.driver.web;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverWebBase {

    private static List<DriverWebFactory> webDriverThreadPool =
            Collections.synchronizedList(new ArrayList<DriverWebFactory>());
    private static ThreadLocal<DriverWebFactory> driverThread;

    public static void instantiateDriverObject() {
        driverThread = new ThreadLocal<DriverWebFactory>() {
            @Override
            protected DriverWebFactory initialValue() {
                DriverWebFactory webDriverThread = new DriverWebFactory();
                webDriverThreadPool.add(webDriverThread);
                return webDriverThread;
            }
        };
    }

    public static RemoteWebDriver getDriver() {
        return driverThread.get().getDriver();
    }

    public static RemoteWebDriver getCurrentDriver() {
        return driverThread.get().getCurrentDriver();
    }

    public static void quitDriver() {
        driverThread.get().quitDriver();
    }

    public static void closeDriverObjects() {
        for (DriverWebFactory webDriverThread : webDriverThreadPool) {
            webDriverThread.quitDriver();
        }
    }

}
