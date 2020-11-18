package com.segurosbolivar.automation.regressiontest.test.steps;

import com.segurosbolivar.automation.regressiontest.flow.RegressionFlow;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class LoginStepDef{

    private RegressionFlow RegressionFlow;

    @Step("The user clicks on the login Link in the Header")
    public LoginStepDef clickLogin(){
        RegressionFlow = new RegressionFlow();
        RegressionFlow.clickOnLogin();
        return this;
    }

//    @Step("The user fill all the required fields")
//    public LoginStepDef fillAll(){
//        RegressionFlow.fillAllTheRequiredFields();
//        return this;
//    }
//
//    @Step("The user must log in successfully")
//    public LoginStepDef checkLogin(String username){
//        assertEquals(RegressionFlow.loginUsername(), username);
//        return this;
//    }
}
