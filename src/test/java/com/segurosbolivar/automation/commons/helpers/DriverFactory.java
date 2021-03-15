package com.segurosbolivar.automation.commons.helpers;

public class DriverFactory {
    private static ThreadLocal<DriverFacade> webDriverMap=new ThreadLocal<>();

    public static void setWebDriver(String browser, String version, String platform, String deviceName) {

        webDriverMap.set(new DriverFacade(browser,version, platform,deviceName));
    }

    public static DriverFacade getDriverFacade() {

        return webDriverMap.get();
    }


}




