package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.commons.ConnectionBD;
import com.segurosbolivar.automation.elements.Elements;
import com.segurosbolivar.automation.utils.PropertyManager;

public class MethodsLogin extends Elements {

    ConnectionBD objBd = new ConnectionBD();

    public void clickOnEntry(){
        webDriverFacade.waitForVisibilityOfElement(entryUser);
        entryUser.click();
    }

    public void loginPerson(){
        webDriverFacade.waitForVisibilityOfElement(loginPerson);
        loginPerson.click();
    }

    public String fillAllTheRequiredFields(){
        driverFacade.waitForVisibilityOfElement(loginInMail);
        loginInMail.click();
        System.out.println("Prueba de extraccion de BD " + objBd.getDataService("cienCuadras","username"));
        loginInMail.sendKeys(objBd.getDataService("cienCuadras","username"));
        loginInPass.sendKeys(PropertyManager.getConfigValueByKey("password"));
        loginUser.click();
        webDriverFacade.waitForVisibilityOfElement(navbarDropdown);
        return navbarDropdown.getText();
    }


}
