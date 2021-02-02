package com.segurosbolivar.automation.tests.registertest;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Methods;

public class MethodsRegisterTest extends BaseTest {
    private Methods methods = new Methods();

    public void clickOnEntry() {
        methods.waitingForElement("entryUser", 3);
        methods.clickElement("entryUser");
    }

    public void registerPerson() {
        methods.waitingForElement("registerUser", 3);
        methods.clickElement("registerUser");
        methods.waitForPageLoad();
    }

    public void fillAllTheRequiredFields() {
        methods.waitingForElement("nameRegister", 15);
        methods.sendKeysText("nameRegister", services.getField("firstName"));
        methods.sendKeysText("secondNameRegister", services.getField("secondName"));
        methods.sendKeysText("lastNameRegister", services.getField("lastName"));
        methods.sendKeysText("secondLastnameRegister", services.getField("secondLastName"));
        methods.sendKeysText("mailRegister", services.getField("mail"));
        methods.sendKeysText("passRegister", services.getField("passRegister"));
        methods.sendKeysText("confirmPassRegister", services.getField("passRegister"));
        methods.scrollTo("terms");
        methods.clickElement("terms");
        methods.clickElement("register");
        methods.waitForPageLoad();
    }

}
