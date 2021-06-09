package com.segurosbolivar.automation.commons;

import com.segurosbolivar.automation.commons.helpers.driver.mobile.DriverMobileBase;
import com.segurosbolivar.automation.commons.helpers.driver.web.DriverWebBase;
import com.segurosbolivar.automation.commons.utils.InitAutomation;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class Hooks {
    protected JSONObject webElements;
    protected JSONObject mobileElements;

    @BeforeSuite(alwaysRun = true)
    public void suiteUp() throws Exception {
        //enable RestAssured logs
        InitAutomation.initRestAssured();
        //Init driver Factories
        InitAutomation.initDriverFactories();
        //start services  and send token to call other services
        InitAutomation.initServices();
        //call elements
        webElements = Elements.getWebElements();
        mobileElements = Elements.getMobileElements();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method) throws Exception {
    }

    @AfterSuite(alwaysRun = true)
    public void closeDriverObjects() throws MalformedURLException {
        DriverMobileBase.closeDriverObjects();
        DriverWebBase.closeDriverObjects();
    }
}
