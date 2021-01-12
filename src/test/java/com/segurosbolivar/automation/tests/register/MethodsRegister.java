package com.segurosbolivar.automation.tests.register;
import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.tests.shared.SharedMethods;

public class MethodsRegister extends BaseTest {
    private Methods methods = new Methods();
    private SharedMethods shared = new SharedMethods();

    public void clickOnEntry(){
        methods.waitingForElement("entryUser", 3);
        methods.clickElement("entryUser");
    }

    public void registerPerson(){
        methods.waitingForElement("registerUser", 3);
        methods.clickElement("registerUser");
    }

    public String fillAllTheRequiredFields(){
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
        methods.waitingForElement("navbarDropdown", 800);
        return methods.getEntity("navbarDropdown").getText();
    }




}
