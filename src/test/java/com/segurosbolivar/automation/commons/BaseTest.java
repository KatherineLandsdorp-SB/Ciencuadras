package com.segurosbolivar.automation.commons;
import com.segurosbolivar.automation.commons.helpers.DriverFacade;
import com.segurosbolivar.automation.commons.helpers.DriverFactory;
import com.segurosbolivar.automation.elements.Elements;
import com.segurosbolivar.automation.utils.PropertyManager;
import org.openqa.selenium.support.PageFactory;

public class BaseTest extends Elements {
    protected DriverFacade driverFacade;
    protected Services services = new Services();

    public BaseTest() {
        this.driverFacade = DriverFactory.getDriverFacade();
        this.services.getDataService(PropertyManager.getConfigValueByKey("slugPortal"));
        PageFactory.initElements(driverFacade.getWebDriver(),this);
    }
}
