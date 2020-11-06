package com.segurosbolivar.automation.sanitytest.ui;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.helpers.DriverFacade;
import com.segurosbolivar.automation.commons.helpers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegressionUi extends BaseTest {

    protected DriverFacade webDriverFacade;

    @FindBy(id = "loginInMail")
    public static WebElement Login;
    @FindBy(id = "loginInPass")
    public static WebElement LoginPass;
    @FindBy(id = "loginUser")
    public static  WebElement buttonLogin;
    @FindBy(id = "navbarDropdown")
    public static  WebElement labelUsername;
    @FindBy(id = "facebookbtn")
    public static WebElement LoginFacebook;
    

    public static  By outlookNotSignedButton = By.id("trackLogIn");


    public RegressionUi() {
        this.webDriverFacade = DriverFactory.getDriverFacade();
        PageFactory.initElements(webDriverFacade.getWebDriver(), this);
    }
}
