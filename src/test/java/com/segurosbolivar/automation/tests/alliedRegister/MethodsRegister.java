package com.segurosbolivar.automation.tests.alliedRegister;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Services;

public class MethodsRegister extends BaseTest {
    private Services methods = new Services();


    public void clickOnEntry(){
        webDriverFacade.waitForVisibilityOfElement(entryUser);
        entryUser.click();
    }

    public void registerAllied(){
        webDriverFacade.waitForVisibilityOfElement(allied);
        allied.click();
        webDriverFacade.waitForVisibilityOfElement(alliedRegistry);
        alliedRegistry.click();
    }

    public String fillAllTheRequiredFields(){

        methods.AngularMaterialSelect(usernameAllied, "bogota");
//
//        driverFacade.waitForVisibilityOfElement(usernameAllied);
//        usernameAllied.click();
//        usernameAllied.sendKeys("prueba110");
//
//        driverFacade.waitForVisibilityOfElement(mailAllied);
//        mailAllied.click();
//        mailAllied.sendKeys("prueba110@yopmail.com");
//
//        driverFacade.waitForVisibilityOfElement(verifyEmailAllied);
//        verifyEmailAllied.click();
//        verifyEmailAllied.sendKeys("prueba110@yopmail.com");
//
//        driverFacade.waitForVisibilityOfElement(passwordAllied);
//        passwordAllied.click();
//        passwordAllied.sendKeys("prueba110");
//
//
//        driverFacade.waitForVisibilityOfElement(cityAllied);
//        cityAllied.click();
//        cityAllied.sendKeys("bogota");
//
//        driverFacade.waitForVisibilityOfElement(buttonRegisterAllied);
//        buttonRegisterAllied.click();

        driverFacade.waitForVisibilityOfElement(navbarDropdown);
        return navbarDropdown.getText();
    }




}
