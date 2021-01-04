package com.segurosbolivar.automation.tests.register;

import com.segurosbolivar.automation.tests.shared.Methods;
import com.segurosbolivar.automation.commons.BaseTest;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class StepsRegister extends BaseTest {

    private MethodsRegister MethodsRegister = new MethodsRegister();
    private Methods methods = new Methods();

    @Step("The user clicks on the login Link in the Header")
    public StepsRegister clickEntry(){
        MethodsRegister.clickOnEntry();
        return this;
    }

    @Step("The user clicks on the register Link in the Popup")
    public StepsRegister clickRegister(){
        MethodsRegister.registerPerson();
        return this;
    }

    @Step("The user fill all the required fields")
    public StepsRegister fillAll(String username){
        MethodsRegister.registerPerson();
        assertEquals(MethodsRegister.fillAllTheRequiredFields(), username);
        return this;
    }

}
