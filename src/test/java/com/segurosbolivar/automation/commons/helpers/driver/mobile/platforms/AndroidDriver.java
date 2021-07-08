package com.segurosbolivar.automation.commons.helpers.driver.mobile.platforms;

import com.segurosbolivar.automation.commons.helpers.driver.DriverConstants;
import com.segurosbolivar.automation.commons.utils.PropertyManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

@Log4j2
public class AndroidDriver {
    public static AppiumDriver<?> getDriver() throws Exception {

        if (!Boolean.parseBoolean(PropertyManager.getConfigValueByKey("driverLocal")))
            return getRemoteDriver();
        return getLocalDriver();
    }

    private static AppiumDriver<?> getLocalDriver() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appWaitActivity", "*");
        capabilities.setCapability(MobileCapabilityType.UDID, DriverConstants.MOBILE_UDID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DriverConstants.MOBILE_DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.VERSION, DriverConstants.MOBILE_VERSION);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, DriverConstants.MOBILE_APP_PACKAGE);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, DriverConstants.MOBILE_APP_ACTIVITY);
        AppiumDriver<?> mobileDriver = null;
        try {
            mobileDriver = new io.appium.java_client.android.AndroidDriver<MobileElement>(new URL(DriverConstants.MOBILE_HOST_URL), capabilities);

        } catch (Exception ex) {
            log.fatal(ex.getMessage());
            System.exit(-1);
        }

        return mobileDriver;
    }

    private static AppiumDriver<?> getRemoteDriver() throws Exception {
        throw new Exception("implmentacion driver Android remoto  pendiente");
    }

}
