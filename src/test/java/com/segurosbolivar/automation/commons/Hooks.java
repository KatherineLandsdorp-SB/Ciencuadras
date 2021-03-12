package com.segurosbolivar.automation.commons;

import com.segurosbolivar.automation.commons.helpers.DriverFactory;
import com.segurosbolivar.automation.utils.PropertyManager;
import org.testng.annotations.*;

import java.lang.reflect.Method;


@Listeners({TestListener.class})

public class Hooks {

    @BeforeMethod(alwaysRun = true)
    public void before() {
        DriverFactory.setWebDriver();
        DriverFactory.getDriverFacade().getWebDriver().get(PropertyManager.getConfigValueByKey("url"));
        //bd inicio
    }


    @AfterMethod()
    public void after() {
      DriverFactory.getDriverFacade().getWebDriver().quit();
    }
//    bd final
}