package com.segurosbolivar.automation.smoketest.ui;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.helpers.DriverFacade;
import com.segurosbolivar.automation.commons.helpers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegressionUi extends BaseTest {

    protected DriverFacade webDriverFacade;

    @FindBy(id = "trackLogIn")
    public static WebElement linkLogin;
    @FindBy(className = "perfil")
    public static  WebElement buttonProfile;
    @FindBy(className = "name")
    public static  WebElement labelUsername;

    public static  By outlookNotSignedButton = By.id("trackLogIn");


//     loginPopUpContainer //
    @FindBy(id = "login")
    public static WebElement loginPopUpContainer;
    @FindBy(id = "email")
    public static  WebElement inputUsername;
    @FindBy(id = "password")
    public static  WebElement inputPassword;
    @FindBy(id = "btn_login")
    public static  WebElement buttonLogin;


    public RegressionUi() {
        this.webDriverFacade = DriverFactory.getDriverFacade();
        PageFactory.initElements(webDriverFacade.getWebDriver(), this);
    }
}
