package com.segurosbolivar.automation.tests.suite1Login;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.tests.shared.SharedMethods;
import io.qameta.allure.Step;
;

import static org.testng.Assert.assertEquals;

public class StepsSuite1Login extends BaseTest {

    private MethodsSuite1Login methodsLogin = new MethodsSuite1Login();
    private SharedMethods methods = new SharedMethods();

    @Step("The user clicks on the login Link in the Header")
    public StepsSuite1Login clickEntry(){
        methodsLogin.clickOnEntry();
        return this;
    }

    @Step("The user clicks in remember user")
    public StepsSuite1Login clickRemember(){
        methodsLogin.clickOnRemember();
        return this;
    }

    @Step("The user clicks on the login Link in the Header")
    public StepsSuite1Login clickLoginPerson(){
        methodsLogin.loginPerson();
        return this;
    }


    @Step("The user fill all the required fields")
    public StepsSuite1Login fillAll(){
        assertEquals(methodsLogin.fillAllTheRequiredFields(), services.getField("nameUserNav"));
        return this;
    }

    @Step("The user fill all the required fields")
    public StepsSuite1Login fillFail(){
        methodsLogin.FailedFields();
        return this;
    }

    @Step("The user fill all the required fields facebook")
    public StepsSuite1Login fillAllFacebook(){
        assertEquals(methodsLogin.fillAllTheRequiredFacebook(), services.getField("navBarFacebook"));
        return this;
    }

    @Step("The user fill all the required fields google")
    public StepsSuite1Login fillAllGmail(){
        assertEquals(methodsLogin.fillAllTheRequiredGmail(), services.getField("navBarFacebook"));
        return this;
    }
}
