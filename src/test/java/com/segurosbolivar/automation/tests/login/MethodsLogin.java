package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.commonslocal.BaseComponent;

public class MethodsLogin extends BaseComponent {
    private Methods methods = new Methods();

    public void clickExitPopUp(){
        boolean hidden = methods.visibleElement("popupExit",10);
        if(hidden!=false){
            methods.waitingForElement("popupExit",10);
            methods.clickElementJs("popupExit");
        }
    }


    public void clickOnEntryButton(){ //***
        methods.waitingForElement("entryUser",5);
        methods.clickElementJs("entryUser");
    }

    public String fillAllTheRequiredFieldsLogin(String email, String password){
        methods.waitForPageLoad();
        methods.waitingForElement("loginInMail", 30);
        methods.sendKeysText("loginInMail", email);
        methods.waitElementExplicitTime("loginInPass",10);
        methods.sendKeysText("loginInPass", password);
        methods.waitElementExplicitTime("loginUser",10);
        methods.clickElementJs("loginUser");
        methods.waitForPageLoad();
        methods.waitingForElement("helloUser", 30);
        return methods.getEntity("helloUser").getText();
    }
}
