package com.segurosbolivar.automation.commons;

import com.segurosbolivar.automation.commons.helpers.DriverFactory;
import com.segurosbolivar.automation.commons.utils.PropertyManager;
import com.segurosbolivar.automation.commons.utils.TestingExecution;
import com.segurosbolivar.automation.commons.utils.Utils;
import org.codehaus.jettison.json.JSONException;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


@Listeners({TestListener.class})
public class Hooks {
    private Services services = new Services();

    @BeforeSuite
    public void beforeSuite() throws IOException {
        TestingExecution.nameExecution = Utils.getNameExecution();
        Services.getElements(PropertyManager.getConfigValueByKey("idPortal"), PropertyManager.getConfigValueByKey("idEnvironment"));
        if (!Boolean.valueOf(PropertyManager.getConfigValueByKey("driverLocal"))) {
            Services.setExecution(PropertyManager.getConfigValueByKey("idSuite"),
                    PropertyManager.getConfigValueByKey("idEnvironment"),
                    PropertyManager.getConfigValueByKey("idStateExecution"),
                    PropertyManager.getConfigValueByKey("idProvider"),
                    PropertyManager.getConfigValueByKey("idTypeAutomation"),
                    PropertyManager.getConfigValueByKey("idTypeExecution"),
                    PropertyManager.getConfigValueByKey("jiraProject"),
                    PropertyManager.getConfigValueByKey("JiraIssue"),
                    PropertyManager.getConfigValueByKey("executor"));
            //Services.setExecution("3", "2", "1", "AUT", "A00T01", "Holman Cabezas");
        }
    }

    @BeforeMethod
    public void before(Method method) throws JSONException {
        Test test = method.getAnnotation(Test.class);
        TestingExecution.testName = test.testName();
        TestingExecution.testName = test.testName();
        DriverFactory.setWebDriver(test.description(), TestingExecution.nameExecution);
//        JSONObject jsonObj = services.getDataService(PropertyManager.getConfigValueByKey("idPortal"), test.testName());
//        TestingExecution.dataCase = jsonObj.getJSONArray("data");
//        TestingExecution.dataAssert = jsonObj.getJSONObject("asserts");
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