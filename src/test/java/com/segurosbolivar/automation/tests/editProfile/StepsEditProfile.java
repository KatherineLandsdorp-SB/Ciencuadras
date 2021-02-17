package com.segurosbolivar.automation.tests.editProfile;

import com.segurosbolivar.automation.tests.login.MethodsLogin;
import com.segurosbolivar.automation.tests.shared.SharedMethods;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class StepsEditProfile {

    private MethodsLogin methodsLogin = new MethodsLogin();
    private MethodsEditProfile methodsEditProfile = new MethodsEditProfile();

    @Step("^A user is logged in the EdirProfile service$")
    public StepsEditProfile aUserIsLoggedIn(){
        methodsLogin.clickOnEntry();
        methodsLogin.loginPerson();
        methodsLogin.fillAllTheRequiredFields();
        return this;
    }

    @Step("^A user is logged in the EdirProfile service$")
    public StepsEditProfile editProfile(){
        methodsEditProfile.clickNavbarDropdown();
        methodsEditProfile.clickEditProfile();
        assertEquals("Guardando datos por favor espere...", methodsEditProfile.fillAllData());
        return this;
    }

}
