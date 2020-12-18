package com.segurosbolivar.automation.commons;

import com.segurosbolivar.automation.commons.helpers.DriverFacade;
import com.segurosbolivar.automation.commons.helpers.DriverFactory;
import com.segurosbolivar.automation.elements.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseTest extends Elements {
    protected DriverFacade driverFacade;
    protected WebDriver webDriver;


    public BaseTest() {
        this.driverFacade = DriverFactory.getDriverFacade();
        PageFactory.initElements(driverFacade.getWebDriver(), this);
    }
}
