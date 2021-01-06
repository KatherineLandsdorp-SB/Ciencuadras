package com.segurosbolivar.automation.tests.alliedRegister;

import com.segurosbolivar.automation.commons.BaseTest;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class StepsRegister extends BaseTest {

    private MethodsRegister MethodsRegister = new MethodsRegister();

    @Step("The user clicks on the login Link in the Header")
    public StepsRegister clickEntry(){
        MethodsRegister.clickOnEntry();
        return this;
    }

    @Step("The user clicks on the register Link in the Popup")
    public StepsRegister clickAllied(){
        MethodsRegister.registerAllied();
        return this;
    }

    @Step("The user fill all the required fields")
    public StepsRegister fillAll(){
        MethodsRegister.fillAllTheRequiredFields();
        return this;
    }

    @Step("Valid send email")
    public StepsRegister validateEmail(){
        MethodsRegister.validateRegistration();
        return this;
    }

}
