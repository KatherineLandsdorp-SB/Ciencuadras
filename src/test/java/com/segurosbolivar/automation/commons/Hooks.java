package com.segurosbolivar.automation.commons;

import com.segurosbolivar.automation.commons.helpers.DriverFactory;
import com.segurosbolivar.automation.utils.PropertyManager;
import org.testng.annotations.*;

import java.lang.reflect.Method;


@Listeners({TestListener.class})

public class Hooks {

    @BeforeMethod(alwaysRun = true)
    @Parameters(value={"browser","version","platform","deviceName"})
    public void before( @Optional String browser, String version, String platform, @Optional String deviceName) {
        DriverFactory.setWebDriver(browser,version,platform,deviceName);
        DriverFactory.getDriverFacade().getWebDriver().get(PropertyManager.getConfigValueByKey("url"));
        //bd inicio
    }


    @AfterMethod()
    public void after() {
       DriverFactory.getDriverFacade().getWebDriver().quit();

    }
//    bd final

    @AfterClass void terminate () {
        //Remove the ThreadLocalMap element
        DriverFactory.getDriverFacade().getWebDriver().close();
    }
}