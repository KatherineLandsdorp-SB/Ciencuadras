package com.segurosbolivar.automation.commons;

import com.segurosbolivar.automation.commons.helpers.DriverFacade;
import com.segurosbolivar.automation.commons.helpers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements {
    protected DriverFacade webDriverFacade;

    /* ========== Login ========= */

    public Elements() {
        this.webDriverFacade = DriverFactory.getDriverFacade();
        PageFactory.initElements(webDriverFacade.getWebDriver(), this);
    }
}
