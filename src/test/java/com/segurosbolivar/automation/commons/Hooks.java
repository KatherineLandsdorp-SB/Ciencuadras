package com.segurosbolivar.automation.commons;

import com.segurosbolivar.automation.commons.helpers.DriverFactory;
import com.segurosbolivar.automation.utils.PropertyManager;
import com.segurosbolivar.automation.utils.TestingExecution;
import com.segurosbolivar.automation.utils.Utils;
import org.testng.annotations.*;

import java.lang.reflect.Method;


@Listeners({TestListener.class})
public class Hooks {

    @BeforeSuite
    public void beforeSuite() {
        TestingExecution.idExecution = Utils.getTimeStampSeconds();
    }

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