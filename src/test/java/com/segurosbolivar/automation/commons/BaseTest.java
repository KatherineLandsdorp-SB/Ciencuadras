package com.segurosbolivar.automation.commons;

import com.segurosbolivar.automation.commons.helpers.DriverFacade;
import com.segurosbolivar.automation.commons.helpers.DriverFactory;
import org.openqa.selenium.support.PageFactory;

public class BaseTest {
    protected DriverFacade driverFacade;


    public BaseTest() {
        this.driverFacade = DriverFactory.getDriverFacade();
        PageFactory.initElements(driverFacade.getWebDriver(),this);
    }
}
