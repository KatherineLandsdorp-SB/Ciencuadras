package com.segurosbolivar.automation.tests.alliedRegister;

import com.segurosbolivar.automation.commons.Services;
import com.segurosbolivar.automation.commons.BaseTest;

public class MethodsRegister extends BaseTest {
    private Services methods = new Services();


    public void clickOnEntry(){
        methods.awaitToFindElement(entryUser, 5);
        entryUser.click();
    }

    public void registerAllied(){
//        methods.awaitToFindElement(allied , 5);
//        allied.click();
//        webDriverFacade.waitForVisibilityOfElement(alliedRegistry);
//        alliedRegistry.click();
    }

    public String fillAllTheRequiredFields(){
//
//
//        methods.awaitToFindElement(usernameAllied, 1);
//        usernameAllied.click();
//        usernameAllied.sendKeys("prueba110");
//
//        methods.awaitToFindElement(mailAllied,5);
//        mailAllied.click();
//        mailAllied.sendKeys("prueba1130@yopmail.com");
//
//        methods.awaitToFindElement(verifyEmailAllied, 5);
//        verifyEmailAllied.click();
//        verifyEmailAllied.sendKeys("prueba110@yopmail.com");
//
//        methods.awaitToFindElement(passwordAllied, 5);
//        passwordAllied.click();
//        passwordAllied.sendKeys("prueba110");
//
//        methods.AngularMaterialAutocomplete(cityAllied, "bogota");
//        methods.elementText("registrate").click();

        driverFacade.waitForVisibilityOfElement(navbarDropdown);
        return navbarDropdown.getText();
    }




}
