package com.segurosbolivar.automation.tests.registertest;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.tests.register.StepsRegister;
import io.qameta.allure.Step;

public class StepsRegisterTest extends BaseTest {

    MethodsRegisterTest methodsRegisterTest = new MethodsRegisterTest();

    @Step("The user clicks on the login Link in the Header")
    public StepsRegisterTest clickEntry() {
        methodsRegisterTest.clickOnEntry();
        return this;
    }

    @Step("The user clicks on the register Link in the Popup")
    public StepsRegisterTest clickRegister() {
        methodsRegisterTest.registerPerson();
        return this;
    }

    @Step("The user fill all the required fields")
    public StepsRegisterTest fillAll(){
        methodsRegisterTest.fillAllTheRequiredFields();
        return this;
    }
}
