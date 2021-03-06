package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Methods;

import java.io.IOException;

public class MethodsLogin extends BaseTest {
    private Methods methods = new Methods();

    public void clickExitPopUp(){
        boolean hidden = methods.visibleElement("popupExit",10);
        if(hidden!=false){
            methods.waitingForElement("popupExit",10);
            methods.clickElementJs("popupExit");
        }
    }

    public void clickOnEntry(){
        methods.waitForPageLoad();
        methods.waitingForElement("headPerson", 5);
        methods.clickElement("headPerson");
    }

    public void clickOnEntryButton(){ //***
        methods.waitingForElement("entryUser",5);
        methods.clickElementJs("entryUser");
    }

    public String fillAllTheRequiredFieldsLogin(String email, String password){
        methods.waitForPageLoad();
        methods.waitingForElement("nameMail", 30);
        methods.sendKeysText("nameMail", email);
        methods.waitElementExplicitTime("loginInPass");
        methods.sendKeysText("loginInPass", password);
        methods.waitElementExplicitTime("loginUser");
        methods.clickElement("loginUser");
        methods.waitForPageLoad();
        methods.waitingForElement("helloUser", 30);
        return methods.getEntity("helloUser").getText();
    }
}
