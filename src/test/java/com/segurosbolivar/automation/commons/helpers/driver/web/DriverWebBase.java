package com.segurosbolivar.automation.commons.helpers.driver.web;

import com.segurosbolivar.automation.commons.helpers.driver.DriverConstants;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DriverWebBase {

    public static String nameExecutionLambda;

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
        boolean isDriverLocal = Boolean.parseBoolean(DriverConstants.DRIVER_LOCAL);
        if(isDriverLocal) {
            return driverThread.get().getDriver();
        }else{
            return getCurrentDriver();
        }
    }


    public static RemoteWebDriver getDriverRemote(String description) {
      return  driverThread.get().getDriver(description, nameExecutionLambda);
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
