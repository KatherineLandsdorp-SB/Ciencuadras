package com.segurosbolivar.automation.commons;

import com.segurosbolivar.automation.commons.helpers.DriverFacade;
import com.segurosbolivar.automation.regressiontest.ui.RegressionUi;

public class RecicleableMethodsCiencuadras extends RegressionUi {

    protected DriverFacade webDriverFacade;

    public void clickOnLogin(){
        webDriverFacade.waitForVisibilityOfElement(linkLogin);
        linkLogin.click();
    }
}
