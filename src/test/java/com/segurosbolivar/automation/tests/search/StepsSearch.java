package com.segurosbolivar.automation.tests.search;

import com.segurosbolivar.automation.commons.BaseTest;
import io.qameta.allure.Step;

public class StepsSearch extends BaseTest {

    private MethodsSearch MethodsRegister = new MethodsSearch();

    @Step("The user clicks on the login Link in the Header")
    public StepsSearch clickEntry(){
        MethodsRegister.clickOnEntry();
        return this;
    }

    @Step("The user clicks on the register Link in the Popup")
    public StepsSearch clickAllied(){
        MethodsRegister.registerAllied();
        return this;
    }

    @Step("The user fill all the required fields")
    public StepsSearch fillAll(){
        MethodsRegister.fillAllTheRequiredFields();
        return this;
    }

    @Step("Valid send email")
    public StepsSearch validateEmail(){
        MethodsRegister.validateRegistration();
        return this;
    }

}
