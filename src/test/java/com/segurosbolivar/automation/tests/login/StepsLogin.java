package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.commonslocal.BaseComponent;
import io.qameta.allure.Step;

public class StepsLogin  extends BaseComponent {
    private Methods methods = new Methods();

    @Step("The user clicks on the login Link in the Header")
    public StepsLogin clickEntry(){
            header.clickOnEntry();
        return this;
    }

    @Step("The user clicks the enter button")
    public StepsLogin clickEnterButton(){
            methods.waitingForElement("entryUser",5);
            methods.clickElementJs("entryUser");
        return this;
    }

    @Step("The user fill all the required fields")
    public StepsLogin fillAll(String email, String password){
            methods.waitForPageLoad();
            methods.waitingForElement("loginInMail", 30);
            methods.sendKeysText("loginInMail", email);
            methods.waitElementExplicitTime("loginInPass",10);
            methods.sendKeysText("loginInPass", password);
        return this;
    }

    @Step("The user fill all the required fields")
    public StepsLogin checkRemember(){
        methods.waitingForElement("defaultCheckIn", 30);
        methods.clickElementJs("defaultCheckIn");
        return this;
    }

    @Step("The user fill all the required fields")
    public StepsLogin clickOnLogin(){
            methods.waitElementExplicitTime("loginUser",10);
            methods.clickElement("loginUser");

        return this;
    }

    @Step("The user fill all the required fields")
    public StepsLogin validateSuccess(){
            methods.waitForPageLoad();
            methods.waitingForElement("helloUser", 30);
            methods.getEntity("helloUser").getText();
        return this;
    }

    @Step("The user fill all the required fields")
    public StepsLogin validateFailed(){
        methods.waitingForElement("userError",10);
        methods.validationElementDisplayed("userError");
        return this;
    }
}