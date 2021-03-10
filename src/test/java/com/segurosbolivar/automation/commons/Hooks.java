package com.segurosbolivar.automation.commons;

import com.segurosbolivar.automation.commons.anotations.Suite;
import com.segurosbolivar.automation.commons.enums.Dom;
import com.segurosbolivar.automation.commons.helpers.DriverFactory;
import com.segurosbolivar.automation.utils.PropertyManager;
import com.segurosbolivar.automation.utils.TestingExecution;
import com.segurosbolivar.automation.utils.Utils;
import org.testng.annotations.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;


@Listeners({TestListener.class})
public class Hooks {

    @BeforeClass
    public void beforeClass() {
        Annotation annotation = this.getClass().getAnnotation(Suite.class);
        if (annotation != null) {
            Suite suite = (Suite) annotation;
            List<Dom> domList = Arrays.asList(suite.domList());
            int id = domList.get(0).getId();
            System.out.println("El primer Id Dom es " + id);
        }

    }

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