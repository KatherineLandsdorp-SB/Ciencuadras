package com.segurosbolivar.automation.commons.helpers;

public class DriverFactory {

    private static ThreadLocal<DriverFacade> webDriverMap=new ThreadLocal<>();

    public static void setWebDriver() {
        webDriverMap.set(new DriverFacade());
    }

    public static DriverFacade getDriverFacade() {
        return webDriverMap.get();
    }

}
