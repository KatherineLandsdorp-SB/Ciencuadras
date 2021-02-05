package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.tests.shared.SharedMethods;
import com.segurosbolivar.automation.utils.PropertyManager;
import org.apache.commons.lang3.StringUtils;

public class MethodsLogin extends BaseTest {
    private Methods methods = new Methods();
    private SharedMethods shared = new SharedMethods();

    public void clickOnEntry(){
        methods.waitForPageLoad();
        methods.waitingForElement("entryUser", 320);
        methods.clickElementJs("entryUser");
    }

    public void clickOnRemember(){
        methods.waitForPageLoad();
        methods.waitingForElement("defaultCheckIn", 320);
        methods.clickElementJs("defaultCheckIn");
    }

    public void loginPerson(){
        methods.waitingForElement("loginPerson", 320);
        methods.clickElementJs("loginPerson");
    }

    public String fillAllTheRequiredFacebook(){
        methods.waitForPageLoad();
        methods.waitingForElement("facebookbtn", 320);
        methods.clickElementJs("facebookbtn");
        methods.switchToAnotherWindow(2);
        methods.waitForPageLoad();
        methods.waitingForElement("emailFacebook", 320);
        methods.sendKeysText("emailFacebook", services.getField("mailFacebook"));
        methods.sendKeysText("passFacebook", services.getField("passFacebook"));
        methods.clickElementJs("facebookLogin");
        methods.switchToAnotherWindow(1);
        methods.waitForPageLoad();
        methods.waitingForElement("navbarDropdown", 320);
        return methods.getEntity("navbarDropdown").getText();
    }

    public String fillAllTheRequiredGmail(){
        methods.waitForPageLoad();
        methods.waitingForElement("googlebtn", 500);
        methods.clickElementJs("googlebtn");
        methods.switchToAnotherWindow(2);
        methods.waitForPageLoad();
        methods.waitingForElement("identifierIdGoogle", 500);
        methods.sendKeysText("identifierIdGoogle", services.getField("mailGmail"));
        methods.clickElementJs("nextGmail");
        methods.waitForPageLoad();
        methods.waitingForElement("passGmail", 500);
        methods.sendKeysText("passGmail", services.getField("passGmail"));
        methods.clickElementJs("nextGmail");
        methods.switchToAnotherWindow(1);
        methods.waitForPageLoad();
        methods.waitingForElement("navbarDropdown", 1800);
        return methods.getEntity("navbarDropdown").getText();
    }

    public String fillAllTheRequiredFields(){
        methods.waitForPageLoad();
        methods.waitingForElement("loginInMail", 320);
        methods.sendKeysText("loginInMail", services.getField("mail"));
        methods.sendKeysText("loginInPass", services.getField("passRegister"));
        methods.clickElementJs("loginUser");
        methods.waitForPageLoad();
        methods.waitingForElement("navbarDropdown", 320);
        return methods.getEntity("navbarDropdown").getText();
    }

    public String FailedFields(){
        methods.waitForPageLoad();
        methods.waitingForElement("loginInMail", 320);
        methods.sendKeysText("loginInMail", "mailfalso@yopmail.com");
        methods.sendKeysText("loginInPass", services.getField("passRegister"));
        methods.clickElementJs("loginUser");
        methods.waitForPageLoad();
        methods.waitingForElement("navbarDropdown", 320);
        return methods.getEntity("navbarDropdown").getText();
    }
}
