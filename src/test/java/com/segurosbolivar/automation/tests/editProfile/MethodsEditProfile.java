package com.segurosbolivar.automation.tests.editProfile;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.utils.PropertyManager;

public class MethodsEditProfile extends BaseTest {
    private Methods methods = new Methods();


    public void clickOnEntry(){
        methods.awaitToFindElement("entryUser", 5);
        entryUser.click();
    }

    public void loginPerson(){
        methods.awaitToFindElement("loginPerson", 5);
        loginPerson.click();
    }

    public void fillAllTheRequiredFacebook(){
        methods.awaitToFindElement("facebookbtn", 5);
        methods.clickElement("facebookbtn");
        methods.changeWindow();
        methods.waitForPageLoad();
        methods.awaitToFindElement("facebookEmail", 5);
        facebookEmail.sendKeys(PropertyManager.getConfigValueByKey("username"));
        facebookPass.sendKeys(PropertyManager.getConfigValueByKey("password"));
        buttonLoginFacebook.click();
    }

    public String fillAllTheRequiredFields(){
        methods.waitingForElement("loginInMail", 5);
        loginInMail.click();
        loginInMail.sendKeys(PropertyManager.getConfigValueByKey("username"));
        loginInPass.sendKeys(PropertyManager.getConfigValueByKey("password"));
        loginUser.click();
        webDriverFacade.waitForVisibilityOfElement(navbarDropdown);
        return navbarDropdown.getText();
    }
}
