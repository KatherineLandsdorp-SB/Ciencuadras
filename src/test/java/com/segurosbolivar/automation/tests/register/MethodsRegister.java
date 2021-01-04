package com.segurosbolivar.automation.tests.register;

import com.segurosbolivar.automation.commons.BaseTest;

public class MethodsRegister extends BaseTest {

    public void clickOnEntry(){
        webDriverFacade.waitForVisibilityOfElement(entryUser);
        entryUser.click();
    }

    public void registerPerson(){
        webDriverFacade.waitForVisibilityOfElement(registerUser);
        registerUser.click();
    }

    public String fillAllTheRequiredFields(){
        driverFacade.waitForVisibilityOfElement(nameRegister);
        nameRegister.click();
        nameRegister.sendKeys("name");

        driverFacade.waitForVisibilityOfElement(secondNameRegister);
        secondNameRegister.click();
        secondNameRegister.sendKeys("name");

        driverFacade.waitForVisibilityOfElement(lastNameRegister);
        lastNameRegister.click();
        lastNameRegister.sendKeys("name");

        driverFacade.waitForVisibilityOfElement(secondLastnameRegister);
        secondLastnameRegister.click();
        secondLastnameRegister.sendKeys("name");

        driverFacade.waitForVisibilityOfElement(mailRegister);
        mailRegister.click();
        mailRegister.sendKeys("name");

        driverFacade.waitForVisibilityOfElement(passRegister);
        passRegister.click();
        passRegister.sendKeys("name");


        driverFacade.waitForVisibilityOfElement(terms);
        terms.click();

        driverFacade.waitForVisibilityOfElement(register);
        register.click();

        driverFacade.waitForVisibilityOfElement(navbarDropdown);
        return navbarDropdown.getText();
    }




}
