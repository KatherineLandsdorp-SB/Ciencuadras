package com.segurosbolivar.automation.commons.helpers;

public class DriverFactory {
    private static ThreadLocal<DriverFacade> webDriverMap=new ThreadLocal<>();

    public static void setWebDriver(String browser, String version, String platform) {

        webDriverMap.set(new DriverFacade(browser,version, platform));
    }

    public static DriverFacade getDriverFacade() {

        return webDriverMap.get();
    }


}




