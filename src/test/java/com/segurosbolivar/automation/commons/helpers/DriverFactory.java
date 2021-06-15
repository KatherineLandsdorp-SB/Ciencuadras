package com.segurosbolivar.automation.commons.helpers;

public class
DriverFactory {

    private static ThreadLocal<DriverFacade> webDriverMap=new ThreadLocal<>();

    public static void setWebDriver(String description, String name) {
        webDriverMap.set(new DriverFacade(description, name));
    }

    public static DriverFacade getDriverFacade() {
        return webDriverMap.get();
    }
}
