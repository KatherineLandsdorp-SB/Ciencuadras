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
    public static WebElement buttonProfile;
    @FindBy(className = "name")
    public static WebElement labelUsername;

    public static By outlookNotSignedButton = By.id("trackLogIn");


    //     loginPopUpContainer //
    @FindBy(id = "login")
    public static WebElement loginPopUpContainer;
    @FindBy(id = "email")
    public static WebElement inputUsername;
    @FindBy(id = "password")
    public static WebElement inputPassword;
    @FindBy(id = "btn_login")
    public static WebElement buttonLogin;


    //RegistrationAtTheEndTest//
    @FindBy(xpath = "(//a[@type='button' and //a[text()='Conoce cómo publicar']])[1]")
    public static WebElement buttonHowToPost;
    @FindBy(xpath = "//button[text()='PUBLICA TÚ MISMO']")
    public static WebElement buttonPostYourself;
    @FindBy(xpath = "//span[text()='PLAN BÁSICO']")
    public static WebElement buttonBasicPlan;
    @FindBy(xpath = "//*[@id=\"cardBasic\"]/div[1]/div/button")
    public static WebElement buttonAddToCar;
    @FindBy(xpath = "//*[@id=\"propertyTypeId\"]/div/div[1]/span/span")
    public static WebElement selectStudioApartment;
    @FindBy(xpath = "//*[@id=\"propertyTypeId\"]/div/div[1]/span/span")
    public static WebElement selectAparment;
    @FindBy(xpath = "//*[@id=\"propertyTypeId\"]/div/div[1]/span/span")
    public static WebElement selectHouse;
    @FindBy(xpath = "//*[@id=\"mat-button-toggle-73-button\"]/div/span")
    public static WebElement selectRent;
    @FindBy(xpath = "//*[@id=\"mat-button-toggle-82-button\"]/div/span")
    public static WebElement selectSale;
    @FindBy(id = "sellingPrice")
    public static WebElement inputSalePrice;
    @FindBy(id = "administrationValue")
    public static WebElement inputAdministrationValue;
    @FindBy(id = "antiquity")
    public static WebElement inputAntiquity;
    @FindBy(xpath = "//*[@id=\"mat-button-toggle-87-button\"]/div")
    public static WebElement inputStratum;
    @FindBy(xpath = "//*[@id=\"publicationInfoForm\"]/div[1]/div/fieldset/div[10]/div/div[1]/div/div/div/div/button[2]")
    public static WebElement buttonAddBathroom;
    @FindBy(xpath = "//*[@id=\"publicationInfoForm\"]/div[1]/div/fieldset/div[11]/div/div/div/div/div/div/button[1]")
    public static WebElement buttonRemoveBathroom;
    @FindBy(xpath = "//*[@id=\"publicationInfoForm\"]/div[1]/div/fieldset/div[12]/div/div/div/div/div/div/button[2]")
    public static WebElement buttonAddParking;
    @FindBy(xpath = "//*[@id=\"publicationInfoForm\"]/div[1]/div/fieldset/div[12]/div/div/div/div/div/div/button[1]")
    public static WebElement buttonremoveParking;
    @FindBy(xpath = "//*[@id=\"publicationInfoForm\"]/div[1]/div/fieldset/div[13]/div/div/div/div/div/div/button[2]")
    public static WebElement buttonBalcony;
    @FindBy(xpath = "//*[@id=\"publicationInfoForm\"]/div[1]/div/fieldset/div[13]/div/div/div/div/div/div/button[1]/span/span")
    public static WebElement buttonRemoveBalcony;
    @FindBy(xpath = "//*[@id=\"publicationInfoForm\"]/div[1]/div/fieldset/div[14]/div/div/div/div/div/div/button[2]")
    public static WebElement buttonAddTerrace;
    @FindBy(xpath = "//*[@id=\"publicationInfoForm\"]/div[1]/div/fieldset/div[14]/div/div/div/div/div/div/button[2]")
    public static WebElement buttonRemoveTerrce;
    @FindBy(id = "ciudad")
    public static WebElement inputCity;
    

    public Elements() {
        this.webDriverFacade = DriverFactory.getDriverFacade();
        PageFactory.initElements(webDriverFacade.getWebDriver(), this);
    }
}
