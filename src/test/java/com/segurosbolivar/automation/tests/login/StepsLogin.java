package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.tests.shared.Methods;
import io.qameta.allure.Step;
import static org.testng.Assert.assertEquals;

public class StepsLogin {

    private MethodsLogin methodsLogin = new MethodsLogin();
    private Methods methods = new Methods();

    @Step("The user clicks on the login Link in the Header")
    public StepsLogin clickEntry(){
        methodsLogin.clickOnEntry();
        return this;
    }

    @Step("The user clicks on the login Link in the Header")
    public StepsLogin clickLoginPerson(){
        methodsLogin.loginPerson();
        return this;
    }


    @Step("The user fill all the required fields")
    public StepsLogin fillAll(String username){
        assertEquals(methodsLogin.fillAllTheRequiredFields(), username);
        return this;
    }

    @Step("The user fill all the required fields facebook")
    public StepsLogin fillAllFacebook(){
        methodsLogin.fillAllTheRequiredFacebook();
        return this;
    }
}
