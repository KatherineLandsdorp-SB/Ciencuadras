package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.tests.shared.SharedMethods;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class StepsLogin extends BaseTest {

    private MethodsLogin methodsLogin = new MethodsLogin();
    private SharedMethods methods = new SharedMethods();

    @Step("The user clicks on the login Link in the Header")
    public StepsLogin clickEntry(){
        methodsLogin.clickOnEntry();
        return this;
    }

    @Step("The user clicks in remember user")
    public StepsLogin clickRemember(){
        methodsLogin.clickOnRemember();
        return this;
    }

    @Step("The user clicks on the login Link in the Header")
    public StepsLogin clickLoginPerson(){
        methodsLogin.loginPerson();
        return this;
    }


    @Step("The user fill all the required fields")
    public StepsLogin fillAll(){
        assertEquals(methodsLogin.fillAllTheRequiredFields(), services.getField("nameUserNav"));
        return this;
    }

    @Step("The user fill all the required fields facebook")
    public StepsLogin fillAllFacebook(){
        assertEquals(methodsLogin.fillAllTheRequiredFacebook(), services.getField("navBarFacebook"));
        return this;
    }

    @Step("The user fill all the required fields google")
    public StepsLogin fillAllGmail(){
        assertEquals(methodsLogin.fillAllTheRequiredGmail(), services.getField("navBarFacebook"));
        return this;
    }
}
