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


    //Home
    @FindBy(xpath = "(//a[@type='button' and //a[text()='Conoce cómo publicar']])[1]")
    public static WebElement buttonHowToPublish;

    //Home accompaniment
    @FindBy(xpath = "//button[text()='PUBLICA TÚ MISMO']")
    public static WebElement buttonPublishYourself;
    @FindBy(xpath = "//button[text()='CON INMOBILIARIA']")
    public  static WebElement buttonRealState;


    //Home Select plan
    @FindBy(id = "sale-button")
    public static WebElement buttonBasicPlan;
    @FindBy(xpath = "//button[@class='btn select-btn basico' and //button[contains(text(),'AÑADIR AL CARRITO')]]")
    public static WebElement buttonAddToCar;

    //Form RealState
    @FindBy (id = "name")
    public static WebElement buttonNameRegister;
    @FindBy(id = "email")
    public  static WebElement inputMail;
    @FindBy(id = "cellphone")
    public static WebElement inputPhone;
    @FindBy(xpath = "//span[@class='mat-option-text']")
    public static  WebElement selectCity;
    @FindBy(xpath = "(//div[@class='mat-radio-label-content'])[1]")
    public static  WebElement radioButtonRent;
    @FindBy(xpath ="(//div[@class='mat-radio-label-content'])[2]" )
    public  static  WebElement radioButtonSale;
    @FindBy(xpath = "(//div[@class='mat-radio-label-content'])[3]")
    public  static  WebElement radioButtonRentSale;
    //Form publish
    @FindBy(xpath = "//*[@id=\"cdk-step-label-0-2\"]/div[2]/div/span")
    public static  WebElement buttonTracking3;
    @FindBy(xpath = "//*[@id=\"propertyTypeId\"]/div/div[1]/span/span")
    public static WebElement selectStudioApartment;
    @FindBy(xpath = "//*[@id=\"propertyTypeId\"]/div/div[1]/span/span")
    public static WebElement selectAparment;
    @FindBy(xpath = "//*[@id=\"propertyTypeId\"]/div/div[1]/span/span")
    public static WebElement selectHouse;
    @FindBy(xpath = "//*[@id=\"mat-button-toggle-73-button\"]/div/span")
    public static WebElement selectRent;
    @FindBy(xpath = "//div/span[text()='Venta']")
    public static WebElement selectSale;
    @FindBy(xpath = "//input[@id=\"sellingPrice\"]")
    public static WebElement inputSalePrice;
    @FindBy(id = "administrationValue")
    public static WebElement inputAdministrationValue;
    @FindBy(id = "antiquity")
    public static WebElement inputAntiquity;
    @FindBy (id = "form_elem")
    public static WebElement inputDescription;
    @FindBy(xpath = "//button[@class='mat-button-toggle-button' and @id='mat-button-toggle-4-button']")
    public static WebElement buttonStratum;
    @FindBy(id = "builtArea")
    public static  WebElement inputArea;
    @FindBy(id = "//*[@id=\"publicationInfoForm\"]/div[1]/div/fieldset/div[11]/div/div/div/div/div/div/button[2]")
    public static WebElement buttonAddRoom;
    @FindBy(xpath = "//*[@id=\"publicationInfoForm\"]/div[1]/div/fieldset/div[10]/div/div[1]/div/div/div/div/button[2]")
    public static WebElement buttonAddBathroom;
    @FindBy(xpath = "//*[@id=\"publicationInfoForm\"]/div[1]/div/fieldset/div[11]/div/div/div/div/div/div/button[1]")
    public static WebElement buttonRemoveBathroom;
    @FindBy(xpath = "//*[@id=\"publicationInfoForm\"]/div[1]/div/fieldset/div[12]/div/div/div/div/div/div/button[2]")
    public static WebElement buttonAddParking;
    @FindBy(xpath = "//*[@id=\"publicationInfoForm\"]/div[1]/div/fieldset/div[12]/div/div/div/div/div/div/button[1]")
    public static WebElement buttonremoveParking;
    @FindBy(xpath = "//*[@id=\"publicationInfoForm\"]/div[1]/div/fieldset/div[13]/div/div/div/div/div/div/button[2]")
    public static WebElement buttonAddBalcony;
    @FindBy(xpath = "//*[@id=\"publicationInfoForm\"]/div[1]/div/fieldset/div[13]/div/div/div/div/div/div/button[1]/span/span")
    public static WebElement buttonRemoveBalcony;
    @FindBy (xpath = "//*[@id=\"publicationInfoForm\"]/div[1]/div/fieldset/div[14]/div/div/div/div/div/div/button[2]")
    public static WebElement buttonAddAscensor;
    @FindBy(xpath = "//*[@id=\"publicationInfoForm\"]/div[1]/div/fieldset/div[14]/div/div/div/div/div/div/button[2]")
    public static WebElement buttonAddTerrace;
    @FindBy(xpath = "//*[@id=\"publicationInfoForm\"]/div[1]/div/fieldset/div[14]/div/div/div/div/div/div/button[2]")
    public static WebElement buttonRemoveTerrce;
    @FindBy(xpath = "//*[@id=\"publicationInfoForm\"]/div[1]/div/fieldset/div[17]/div/div/div/div/div/div/button[2]")
    public static  WebElement buttonAddDeposits;
    @FindBy(id = "ciudad")
    public static WebElement inputCity;
    @FindBy(id = "localidadComuna")
    public static WebElement inputLocation;
    @FindBy(id = "barrio")
    public static WebElement inputDistric;
    @FindBy(id = "address")
    public static WebElement inputAdress;
    @FindBy(id = "dirCheckAddress-input")
    public static WebElement checkAdress;
    @FindBy(id = "email")
    public static WebElement inputEmail;
    @FindBy(id = "mat-option-3")
    public static WebElement selectCC;
    @FindBy(id = "identification")
    public static WebElement inputIdentification;
    @FindBy(id = "name")
    public static WebElement inputName;
    @FindBy(id = "last-name")
    public static WebElement inputLastName;
    @FindBy(id = "cellphone")
    public static WebElement inputCellPhone;
    @FindBy(id = "password")
    public static WebElement inputPasswordEndRegister;
    @FindBy(id = "password-confirm")
    public static WebElement inputPasswordConfirm;
    @FindBy(xpath = "//button[contains(text(), 'CONTINUAR')]")
    public static WebElement buttonContinue;
    @FindBy(xpath = "//*[@id=\"mediaInfo\"]/fieldset/div[2]/div[1]/div/div/input-file/div/div/div/button/span/mat-icon")
    public static WebElement buttonAddPhoto;
    @FindBy(xpath = "(//h3[contains(text(),'Resumen de tu compra')])[2]")
    public static WebElement headerSummary;


    public Elements() {
        this.webDriverFacade = DriverFactory.getDriverFacade();
        PageFactory.initElements(webDriverFacade.getWebDriver(), this);
    }
}
