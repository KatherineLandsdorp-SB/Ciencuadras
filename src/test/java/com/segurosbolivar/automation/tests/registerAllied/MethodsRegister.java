package com.segurosbolivar.automation.tests.registerAllied;
import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Methods;

public class MethodsRegister extends BaseTest {
    protected Methods methods = new Methods();

    public void clickOnEntry(){
        methods.waitForPageLoad();
        methods.awaitToFindElement("entryUser", 3);
        methods.clickElement("entryUser");
    }

    public void registerAllied(){
        methods.awaitToFindElement("allied", 3);
        methods.clickElement("allied");
        methods.awaitToFindElement("alliedRegistry", 5);
        methods.clickElement("alliedRegistry");
    }

    public void fillAllTheRequiredFields(){
        methods.waitingForElement("usernameAllied", 3);
        methods.sendKeysText("usernameAllied", services.getField("nameAllied"));
        methods.sendKeysText("mailAllied", services.getField("mailAllied"));
        methods.sendKeysText("verifyEmailAllied",services.getField("mailAllied"));
        methods.sendKeysText("passwordAllied",services.getField("passwordAllied"));
        methods.AngularMaterialAutocomplete("cityAllied", services.getField("cityAllied"));
        methods.clickElement("registryAllied");
    }

    public void validateRegistration(){
        methods.waitingForElement("confirmationMessage", 2);
        System.out.println("jejejeje" + methods.getEntity("confirmationMessage").getText());
    }
}
