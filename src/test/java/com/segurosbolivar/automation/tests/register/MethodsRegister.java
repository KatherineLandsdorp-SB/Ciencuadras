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
        nameRegister.sendKeys(services.getField("firstName"));

        secondNameRegister.click();
        secondNameRegister.sendKeys(services.getField("secondName"));

        lastNameRegister.click();
        lastNameRegister.sendKeys(services.getField("lastName"));

        secondLastnameRegister.click();
        secondLastnameRegister.sendKeys(services.getField("secondLastName"));

        mailRegister.click();
        mailRegister.sendKeys(services.getField("mail"));

        passRegister.click();
        passRegister.sendKeys(services.getField("passRegister"));

        confirmPassRegister.click();
        confirmPassRegister.sendKeys(services.getField("passRegister"));


        driverFacade.waitForVisibilityOfElement(terms);
        terms.click();

        driverFacade.waitForVisibilityOfElement(register);
        register.click();

        driverFacade.waitForVisibilityOfElement(navbarDropdown);
        return navbarDropdown.getText();
    }




}
