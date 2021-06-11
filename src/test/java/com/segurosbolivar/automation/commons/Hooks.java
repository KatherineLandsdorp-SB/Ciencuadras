package com.segurosbolivar.automation.commons;

import com.segurosbolivar.automation.commons.helpers.DriverFactory;
import com.segurosbolivar.automation.commons.utils.PropertyManager;
import com.segurosbolivar.automation.commons.utils.TestingExecution;
import com.segurosbolivar.automation.commons.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


@Listeners({TestListener.class})
public class Hooks {
    protected Services data = new Services();
    public WebDriver driver;
    @BeforeSuite
    public void beforeSuite() throws IOException {
        TestingExecution.nameExecution = Utils.getNameExecution();
        Services.getElements(PropertyManager.getConfigValueByKey("idPortal"), PropertyManager.getConfigValueByKey("idEnvironment"));
        if (!Boolean.valueOf(PropertyManager.getConfigValueByKey("driverLocal"))) {
            Services.setExecution("3", "2", "1", "AUT", "A00T01", "Holman Cabezas");
        }
    }

    @BeforeMethod
    public void before(Method method) {

        Test test = method.getAnnotation(Test.class);
        TestingExecution.testName = test.testName();
        TestingExecution.testName = test.testName();
        DriverFactory.setWebDriver(test.description(), TestingExecution.nameExecution);
        driver = DriverFactory.getDriverFacade().getWebDriver();
        data.getDataService(PropertyManager.getConfigValueByKey("idPortal"), test.testName());
        DriverFactory.getDriverFacade().getWebDriver().get(PropertyManager.getConfigValueByKey("url"));
    }

    @AfterMethod
    public void after() {
        DriverFactory.getDriverFacade().getWebDriver().quit();
    }

    @AfterSuite
    public void afterSuite() {

    }

}