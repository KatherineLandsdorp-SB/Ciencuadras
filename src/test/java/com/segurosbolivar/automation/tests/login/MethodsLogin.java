package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Services;
import com.segurosbolivar.automation.utils.PropertyManager;

public class MethodsLogin extends BaseTest {
    private Services methods = new Services();


    public void clickOnEntry(){
        methods.awaitToFindElement(entryUser, 5);
        entryUser.click();
    }

    public void loginPerson(){
        methods.awaitToFindElement(loginPerson, 5);
        loginPerson.click();
    }

    public void fillAllTheRequiredFacebook(){
        methods.waitForPageLoad();
        methods.awaitToFindElement(facebookbtn, 5);
        facebookbtn.click();
        methods.changeWindow();
        methods.waitForPageLoad();
        methods.awaitToFindElement(facebookEmail, 5);
        facebookEmail.sendKeys(PropertyManager.getConfigValueByKey("username"));
        facebookPass.sendKeys(PropertyManager.getConfigValueByKey("password"));
        buttonLoginFacebook.click();
    }

    public String fillAllTheRequiredFields(){
        methods.waitingForElement(loginInMail, 5);
        loginInMail.click();
        loginInMail.sendKeys(PropertyManager.getConfigValueByKey("username"));
        loginInPass.sendKeys(PropertyManager.getConfigValueByKey("password"));
        loginUser.click();
        webDriverFacade.waitForVisibilityOfElement(navbarDropdown);
        return navbarDropdown.getText();
    }
}
