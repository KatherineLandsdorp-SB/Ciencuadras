package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.commons.BaseTest;
import io.qameta.allure.Step;

public class StepsLogin extends BaseTest {

    private MethodsLogin methodsLogin = new MethodsLogin();

    @Step("The user closes the popup")
    public StepsLogin clickExitPopUp() {
        methodsLogin.clickExitPopUp();
        return this;
    }

    @Step("The user clicks on the login Link in the Header")
    public StepsLogin clickEntry(){
        methodsLogin.header.clickOnEntry();
        return this;
    }

    @Step("The user clicks the enter button")
    public StepsLogin clickEnterButton(){
        methodsLogin.clickOnEntryButton();
        return this;
    }

    @Step("The user fill all the required fields")
    public StepsLogin fillAll(String email, String password){
        methodsLogin.fillAllTheRequiredFieldsLogin(email, password);
        return this;
    }
}