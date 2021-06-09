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

public class IOSDriver {
    public static AppiumDriver<?> getDriver() throws MalformedURLException {

        if (!Boolean.parseBoolean(PropertyManager.getConfigValueByKey("driverLocal")))
            return getRemoteDriver();
        return getLocalDriver();
    }

    private static AppiumDriver<?> getLocalDriver() throws MalformedURLException {

        String completeURL = "http://127.0.0.1:4723/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.UDID, "2aa062159805");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Personal");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.calculator");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
        return new io.appium.java_client.ios.IOSDriver<MobileElement>(new URL(completeURL), capabilities);
    }

    private static AppiumDriver<?> getRemoteDriver() throws MalformedURLException {
        String completeURL = "http://127.0.0.1:4723/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.UDID, "2aa062159805");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Personal");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.calculator");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
        return new io.appium.java_client.ios.IOSDriver<MobileElement>(new URL(completeURL), capabilities);

    }
}