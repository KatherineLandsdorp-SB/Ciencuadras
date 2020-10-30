package com.segurosbolivar.automation.sanitytest.flow;


import com.segurosbolivar.automation.sanitytest.ui.RegressionUi;
import com.segurosbolivar.automation.utils.PropertyManager;

public class RegressionFlow extends RegressionUi {

    //prueba

    public String loginUsername(){
        Login.click();

        webDriverFacade.waitForVisibilityOfElement(buttonLogin);
        webDriverFacade.awaitToFindElement(outlookNotSignedButton);
        buttonLogin.click();
        webDriverFacade.waitForVisibilityOfElement(labelUsername);
        return labelUsername.getText();
    }
}
