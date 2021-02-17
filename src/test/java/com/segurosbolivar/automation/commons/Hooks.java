package com.segurosbolivar.automation.commons;

import com.segurosbolivar.automation.commons.helpers.DriverFactory;
import com.segurosbolivar.automation.utils.PropertyManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Listeners({TestListener.class})
public class Hooks {

    @BeforeMethod
    public void before(Method method) {
        Test test = method.getAnnotation(Test.class);
        DriverFactory.setWebDriver(test.description());
        DriverFactory.getDriverFacade().getWebDriver().get(PropertyManager.getConfigValueByKey("url"));
        //bd inicio
    }


    @AfterMethod
    public void after() {
       DriverFactory.getDriverFacade().getWebDriver().quit();
    }
//    bd final
}