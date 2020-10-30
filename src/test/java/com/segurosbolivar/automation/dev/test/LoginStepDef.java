package com.segurosbolivar.automation.dev.test;

import com.segurosbolivar.automation.dev.flow.RegressionFlow;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class LoginStepDef extends LoginTest {

    private RegressionFlow objRegressionFlow;

    @Step("The user clicks on the login Link in the Header")
    public LoginStepDef clickLogin(){
        objRegressionFlow.clickOnLogin();
        return this;
    }

    @Step("The user fill all the required fields")
    public LoginStepDef fillAll(){
       objRegressionFlow.fillAllTheRequiredFields();
        return this;
    }

    @Step("The user must log in successfully")
    public LoginStepDef checkLogin(String username){
        assertEquals(objRegressionFlow.loginUsername(), username);
        return this;
    }
}
