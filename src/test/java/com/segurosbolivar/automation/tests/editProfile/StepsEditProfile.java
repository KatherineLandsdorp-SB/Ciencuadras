package com.segurosbolivar.automation.tests.editProfile;

import com.segurosbolivar.automation.tests.shared.SharedMethods;
import io.qameta.allure.Step;

public class StepsEditProfile {

    private MethodsEditProfile methodsLogin = new MethodsEditProfile();
    private SharedMethods methods = new SharedMethods();

    @Step("The user clicks on the login Link in the Header")
    public StepsEditProfile clickEntry(){
        methodsLogin.clickOnEntry();
        return this;
    }

    @Step("The user clicks on the login Link in the Header")
    public StepsEditProfile clickLoginPerson(){
        methodsLogin.loginPerson();
        return this;
    }


    @Step("The user fill all the required fields")
    public StepsEditProfile fillAll(){
        methodsLogin.fillAllTheRequiredFields();
        return this;
    }

    @Step("The user fill all the required fields facebook")
    public StepsEditProfile fillAllFacebook(){
        methodsLogin.fillAllTheRequiredFacebook();
        return this;
    }
}
