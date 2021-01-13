package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.tests.shared.SharedMethods;


public class MethodsLogin extends BaseTest {
    private Methods methods = new Methods();
    private SharedMethods shared = new SharedMethods();


    public void clickOnEntry(){
        methods.awaitToFindElement("entryUser", 5);
        methods.clickElement("entryUser");
    }

    public void clickOnRemember(){
        methods.waitForPageLoad();
        methods.awaitToFindElement("defaultCheckIn", 120);
        methods.clickElement("defaultCheckIn");
    }

    public void loginPerson(){
        methods.awaitToFindElement("loginPerson", 5);
        methods.clickElement("loginPerson");
    }

    public String fillAllTheRequiredFacebook(){
        methods.waitForPageLoad();
        methods.waitingForElement("facebookbtn", 120);
        methods.clickElement("facebookbtn");
        methods.switchToAnotherWindow(2);
        methods.waitForPageLoad();
        methods.waitingForElement("emailFacebook", 120);
        methods.sendKeysText("emailFacebook", services.getField("mailFacebook"));
        methods.sendKeysText("passFacebook", services.getField("passFacebook"));
        methods.clickElement("facebookLogin");
        methods.switchToAnotherWindow(1);
        methods.waitForPageLoad();
        methods.waitingForElement("navbarDropdown", 120);
        return methods.getEntity("navbarDropdown").getText();
    }

    public String fillAllTheRequiredGmail(){
        methods.waitingForElement("googlebtn", 120);
        methods.clickElement("googlebtn");
        methods.switchToAnotherWindow(2);
        methods.waitForPageLoad();
        methods.waitingForElement("identifierIdGoogle", 120);
        methods.sendKeysText("identifierIdGoogle", services.getField("mailGmail"));
        methods.clickElement("nextGmail");
        methods.waitForPageLoad();
        methods.waitingForElement("passGmail", 120);
        methods.sendKeysText("passGmail", services.getField("passGmail"));
        methods.clickElementJs("nextGmail");
        methods.switchToAnotherWindow(1);
        methods.waitForPageLoad();
        methods.waitingForElement("navbarDropdown", 800);
        return methods.getEntity("navbarDropdown").getText();
    }

    public String fillAllTheRequiredFields(){
        methods.waitForPageLoad();
        methods.waitingForElement("loginInMail", 60);
        methods.sendKeysText("loginInMail", services.getField("mail"));
        methods.sendKeysText("loginInPass", services.getField("passRegister"));
        methods.clickElement("loginUser");
        methods.waitForPageLoad();
        methods.waitingForElement("navbarDropdown", 800);
        return methods.getEntity("navbarDropdown").getText();
    }
}
