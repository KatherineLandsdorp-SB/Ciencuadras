package com.segurosbolivar.automation.regressiontest.flow;


import com.segurosbolivar.automation.regressiontest.ui.RegressionUi;
import com.segurosbolivar.automation.utils.PropertyManager;

public class RegressionFlow extends RegressionUi {

    public String loginUsername(){
        webDriverFacade.waitForVisibilityOfElement(buttonProfile);
        webDriverFacade.awaitToFindElement(outlookNotSignedButton);
        buttonProfile.click();
        webDriverFacade.waitForVisibilityOfElement(labelUsername);
        return labelUsername.getText();
    }

    public void fillAllTheRequiredFields(){
        driverFacade.waitForVisibilityOfElement(loginPopUpContainer);
        inputUsername.click();
        inputUsername.sendKeys(PropertyManager.getConfigValueByKey("username"));
        inputPassword.sendKeys(PropertyManager.getConfigValueByKey("password"));
        buttonLogin.click();
    }

    public void clickOnLogin(){
        webDriverFacade.waitForVisibilityOfElement(linkLogin);
        linkLogin.click();
    }
}
