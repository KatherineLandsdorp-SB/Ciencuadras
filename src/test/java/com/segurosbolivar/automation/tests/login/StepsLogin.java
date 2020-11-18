package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.elements.Elements;
import io.qameta.allure.Step;
import static org.testng.Assert.assertEquals;

public class StepsLogin extends Elements {

    private MethodsLogin MethodsLogin;

    @Step("The user clicks on the login Link in the Header")
    public StepsLogin clickEntry(){
        MethodsLogin = new MethodsLogin();
        MethodsLogin.clickOnEntry();
        return this;
    }

    @Step("The user fill all the required fields")
    public StepsLogin fillAll(String username){
        MethodsLogin.loginPerson();
        assertEquals(MethodsLogin.fillAllTheRequiredFields(), username);
        return this;
    }
}
