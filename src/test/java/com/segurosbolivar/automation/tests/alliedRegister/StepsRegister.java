package com.segurosbolivar.automation.tests.alliedRegister;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.tests.shared.Methods;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class StepsRegister extends BaseTest {

    private com.segurosbolivar.automation.tests.alliedRegister.MethodsRegister MethodsRegister = new MethodsRegister();

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
    public StepsRegister fillAll(String username){
        assertEquals(MethodsRegister.fillAllTheRequiredFields(), username);
        return this;
    }

}
