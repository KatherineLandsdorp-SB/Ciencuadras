package com.segurosbolivar.automation.sanitytest.flow;


import com.segurosbolivar.automation.sanitytest.ui.RegressionUi;
import com.segurosbolivar.automation.utils.PropertyManager;

public class RegressionFlow extends RegressionUi {

    public String loginUsername() {
        Login.click();
        Login.sendKeys();
        LoginPass.click();
        LoginPass.sendKeys();
        webDriverFacade.waitForVisibilityOfElement(buttonLogin);
        webDriverFacade.awaitToFindElement(outlookNotSignedButton);
        buttonLogin.click();
        webDriverFacade.waitForVisibilityOfElement(labelUsername);
        return labelUsername.getText();
    }

    public String loginFacebook() {
        buttonLoginFacebook.click();
        emailFacebook.click();
        emailFacebook.sendKeys();
        passwordFacebook.click();
        passwordFacebook.sendKeys();
        buttonFacebook.click();
    }
}
