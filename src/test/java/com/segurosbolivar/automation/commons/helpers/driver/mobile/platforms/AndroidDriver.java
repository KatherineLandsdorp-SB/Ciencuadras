package com.segurosbolivar.automation.commons.helpers.driver.mobile.platforms;

import com.segurosbolivar.automation.commons.utils.PropertyManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriver {
    public static AppiumDriver<?> getDriver() throws MalformedURLException {

        if (!Boolean.parseBoolean(PropertyManager.getConfigValueByKey("driverLocal")))
            return getRemoteDriver();
        return getLocalDriver();
    }

    private static AppiumDriver<?> getLocalDriver() throws MalformedURLException {
        String completeURL = "http://127.0.0.1:4723/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appWaitActivity", "*");
        capabilities.setCapability(MobileCapabilityType.UDID, "R58N22M9SZM");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy A71");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.segurosbolivar.bolivarconmigo");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.ionic.starter.MainActivity");
        AppiumDriver<?> mobileDriver = new io.appium.java_client.android.AndroidDriver<MobileElement>(new URL(completeURL), capabilities);

        return mobileDriver;
    }

    private static AppiumDriver<?> getRemoteDriver() throws MalformedURLException {
        String completeURL = "http://127.0.0.1:4723/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.UDID, "R58N22M9SZM");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy A71");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.segurosbolivar.bolivarconmigo");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.ionic.starter.MainActivity");
        AppiumDriver<?> mobileDriver = new io.appium.java_client.android.AndroidDriver<MobileElement>(new URL(completeURL), capabilities);
        return mobileDriver;

    }

}
