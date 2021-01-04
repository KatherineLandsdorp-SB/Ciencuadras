package com.segurosbolivar.automation.commons;

import com.segurosbolivar.automation.commons.helpers.DriverFacade;
import com.segurosbolivar.automation.commons.helpers.DriverFactory;
import com.segurosbolivar.automation.commons.Services;
import com.segurosbolivar.automation.elements.Elements;
import com.segurosbolivar.automation.utils.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseTest extends Elements {
    protected DriverFacade driverFacade;
    protected WebDriver webDriver;
    protected Services services = new Services();
    public BaseTest() {
        this.driverFacade = DriverFactory.getDriverFacade();
        PageFactory.initElements(driverFacade.getWebDriver(),this);
        this.services.getDataService(PropertyManager.getConfigValueByKey("slugPortal"));
    }
}
