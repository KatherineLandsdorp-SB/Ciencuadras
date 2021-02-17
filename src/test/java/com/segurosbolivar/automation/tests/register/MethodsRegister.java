package com.segurosbolivar.automation.tests.register;
import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.tests.shared.SharedMethods;

public class MethodsRegister extends BaseTest {
    private Methods methods = new Methods();
    private SharedMethods shared = new SharedMethods();

    public void clickOnEntry(){
        methods.waitForPageLoad();
        methods.waitingForElement("entryUser", 15);
        methods.clickElementJs("entryUser");
    }

    public void registerPerson(){
        methods.waitForPageLoad();
        methods.waitingForElement("registerUser", 15);
        methods.clickElement("registerUser");
    }

    public void registerAllied(){
        methods.waitForPageLoad();
        methods.waitingForElement("allied", 15);
        methods.clickElementJs("allied");
        methods.waitingForElement("alliedRegistry", 15);
        methods.clickElementJs("alliedRegistry");
    }

    public String fillAllTheRequiredFields(){
        methods.waitForPageLoad();
        methods.waitingForElement("nameRegister", 15);
        methods.sendKeysText("nameRegister", services.getField("firstName"));
        methods.sendKeysText("secondNameRegister", services.getField("secondName"));
        methods.sendKeysText("lastNameRegister", services.getField("lastName"));
        methods.sendKeysText("secondLastnameRegister", services.getField("secondLastName"));
        methods.sendKeysText("mailRegister", services.getField("mail"));
        methods.sendKeysText("passRegister", services.getField("passRegister"));
        methods.sendKeysText("confirmPassRegister", services.getField("passRegister"));
        methods.scrollTo("terms");
        methods.clickElementJs("terms");
        methods.clickElementJs("register");
        methods.waitForPageLoad();
        methods.waitingForElement("navbarDropdown", 15);
        return methods.getEntity("navbarDropdown").getText();
    }

    public String fillAllTheRequiredFieldsAllied(){
        methods.waitingForElement("usernameAllied", 30);
        methods.sendKeysText("usernameAllied", services.getField("nameAllied"));
        methods.sendKeysText("mailAllied", services.getField("mailAllied"));
        methods.sendKeysText("verifyEmailAllied",services.getField("mailAllied"));
        methods.sendKeysText("passwordAllied",services.getField("passwordAllied"));
        methods.angularMaterialAutocomplete("cityAllied", services.getField("cityAllied"));
        methods.clickElementJs("registryAllied");
        return methods.searchText("Te hemos enviado un correo", 15);
    }
}
