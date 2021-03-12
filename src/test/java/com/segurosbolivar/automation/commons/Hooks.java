package com.segurosbolivar.automation.commons;

import com.segurosbolivar.automation.commons.helpers.DriverFactory;
import com.segurosbolivar.automation.utils.PropertyManager;
import org.testng.annotations.*;

import java.lang.reflect.Method;


@Listeners({TestListener.class})

public class Hooks {

    @BeforeMethod(alwaysRun = true)
    //@org.testng.annotations.Parameters(value={"browser","version","platform"})
    @Parameters(value={"browser","version","platform"})
    public void before(String browser, String version, String platform) {
        DriverFactory.setWebDriver(browser,version,platform);
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