package com.segurosbolivar.automation.elements;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.helpers.DriverFacade;
import com.segurosbolivar.automation.commons.helpers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements extends BaseTest {
    protected DriverFacade webDriverFacade;

    /* ========== LoginTest ========= */

    @FindBy(xpath = "//header/nav[1]/div[1]/nav[1]/div[1]/ul[2]/li[1]")
    public static WebElement entryUser;

    @FindBy(xpath = "//span[contains(text(),'Personas')]")
    public static WebElement loginPerson;

    @FindBy(id = "loginInMail")
    public static WebElement loginInMail;

    @FindBy(id = "loginInPass")
    public static WebElement loginInPass;

    @FindBy(id = "loginUser")
    public static WebElement loginUser;

    @FindBy(id = "navbarDropdown")
    public static WebElement navbarDropdown;

    /* ========== LoginTest ========= */




    @FindBy(id = "trackLogIn")
    public static WebElement linkLogin;
    @FindBy(className = "perfil")
    public static  WebElement buttonProfile;
    @FindBy(className = "name")
    public static  WebElement labelUsername;

    public static By outlookNotSignedButton = By.id("trackLogIn");


    //     loginPopUpContainer //
    @FindBy(id = "login")
    public static WebElement loginPopUpContainer;
    @FindBy(id = "email")
    public static  WebElement inputUsername;
    @FindBy(id = "password")
    public static  WebElement inputPassword;
    @FindBy(id = "btn_login")
    public static  WebElement buttonLogin;


    public Elements() {
        this.webDriverFacade = DriverFactory.getDriverFacade();
        PageFactory.initElements(webDriverFacade.getWebDriver(), this);
    }
}
