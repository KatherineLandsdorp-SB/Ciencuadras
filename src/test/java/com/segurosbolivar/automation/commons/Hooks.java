package com.segurosbolivar.automation.commons;

import com.segurosbolivar.automation.commons.helpers.DriverFactory;
import com.segurosbolivar.automation.utils.PropertyManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class Hooks {

    @BeforeMethod(alwaysRun = true)
    public void before() {
        DriverFactory.setWebDriver();
        DriverFactory.getDriverFacade().getWebDriver().get(PropertyManager.getConfigValueByKey("url"));
        //bd inicio
    }


    @AfterMethod(alwaysRun = true)
    public void after() {
        DriverFactory.getDriverFacade().getWebDriver().quit();
    }
//    bd final
}