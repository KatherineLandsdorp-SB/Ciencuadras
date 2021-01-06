package com.segurosbolivar.automation.elements;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.helpers.DriverFacade;
import com.segurosbolivar.automation.commons.helpers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements  {
    protected DriverFacade webDriverFacade;

    /* ========== LoginTest ========= */
    @FindBy(id = "city")
    public static WebElement cityAllied;

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
    @FindBy(xpath = "(//div/a[@href='/publicar'])[1]")
    public static WebElement buttonPublishProperty;
    @FindBy(xpath = "(//div/a[@href='/publicar'])[2]")
    public static WebElement buttonKnowPublish;
    @FindBy(xpath = "//p[contains(text(),'VENDER')]")
    public static  WebElement buttonSale;

    //Home tracking
    @FindBy(xpath = "//div//button[text()='PUBLICA TÚ MISMO']")
    public static WebElement buttonPublishYourself;
    @FindBy(xpath = "//div/button[text()='CON INMOBILIARIA']")
    public static WebElement buttonRealState;
    @FindBy(xpath = "(//div/span[@class='label-desktop ng-star-inserted'])[1]")
    public static WebElement labelAccompaniment;
    @FindBy(xpath = "(//div/span[contains(text(),'1')])[1]")
    public static WebElement imgStepAccompaniment;
    @FindBy(xpath = "(//mat-icon[contains(text(),'done')])[1]")
    public static  WebElement checkDoneStepOne;
    @FindBy(xpath = "(//span[@class='label-desktop ng-star-inserted'])[2]")
    public static WebElement labelChoosePlan;
    @FindBy(xpath = "(//div/span[contains(text(),'2')])[1]")
    public static WebElement imgStepChoosePlan;
    @FindBy(xpath = "(//mat-icon[contains(text(),'done')])[2]")
    public static  WebElement checkDoneStepTwo;
    @FindBy(xpath = "(//span[@class='label-desktop ng-star-inserted'])[3]")
    public static WebElement labelPublish;
    @FindBy(xpath = "(//div/span[contains(text(),'3')])[1]")
    public static WebElement imgStepPublish;
    @FindBy(xpath = "(//mat-icon[contains(text(),'done')])[3]")
    public static  WebElement checkDoneThree;
    @FindBy(xpath = "(//span[@class='label-desktop ng-star-inserted'])[4]")
    public static WebElement labelPay;
    @FindBy(xpath = "(//div/span[contains(text(),'4')])[1]")
    public static  WebElement imgStepPay;
    @FindBy(xpath = "(//mat-icon[contains(text(),'done')])[4]")
    public static  WebElement checkDoneStepFour;
    @FindBy(xpath = "(//button[text()='ATRÁS'])[1]")
    public static  WebElement buttonBackTracking;
    @FindBy(xpath = "(//button[text()='ATRÁS'])[2]")
    public static  WebElement buttonBack;




    //Home Select plan basic
    @FindBy(id = "sale-button")
    public static WebElement buttonBasicPlan;
    @FindBy(xpath = "//button[@class='btn select-btn basico' and //button[contains(text(),'AÑADIR AL CARRITO')]]")
    public static WebElement buttonBasicAddToCar;

    //Home select plan destacadp
    @FindBy(id = "rent-button")
    public static WebElement buttonFeaturedPlan;
    @FindBy(xpath = "(//*[@id=\"ciudad\"])[2]")
    public static WebElement inputCityCoverage;
    @FindBy(xpath = "(//div/button[contains (text(), 'CONFIRMAR')])")
    public static WebElement buttonCnfirmCoverage;
    @FindBy(xpath = "(//div/button[contains (text(), 'CONTINUAR')])[6]")
    public static WebElement buttonContinueCoverage;
    @FindBy(xpath = "//div/p[@class='confirmed-coverage__text']")
    public static WebElement texConfirmedCity;
    @FindBy(xpath = "//div//h3[@class='out-of-coverage__title']")
    public static WebElement textOutCoverage;
    @FindBy(xpath = "//button[@class='btn destacado' and //button[contains(text(),'AÑADIR AL CARRITO')]]")
    public static WebElement buttonAddToCar;

    //Form RealState
    @FindBy(xpath = "//div/input[@id='name' and @name='nameRegister']")
    public static WebElement inputNameRegister;
    @FindBy(xpath = "//div/input[@id='email' and @name='mailRegister']")
    public static WebElement inputMail;
    @FindBy(xpath = "//div/input[@id='cellphone' and @name='cellphone']")
    public static WebElement inputPhone;
    @FindBy(xpath = "(//div/input[@id='ciudad' and @name='ciudad'])[2]")
    public static WebElement inputCityReallSate;
    @FindBy(xpath = "(//span[@class='mat-option-text'])[1]")
    public static WebElement selectCity;
    @FindBy(xpath = "(//div[@class='mat-radio-label-content'])[1]")
    public static WebElement radioButtonRent;
    @FindBy(xpath = "(//div[@class='mat-radio-label-content'])[2]")
    public static WebElement radioButtonSale;
    @FindBy(xpath = "(//div[@class='mat-radio-label-content'])[3]")
    public static WebElement radioButtonRentSale;
    @FindBy(xpath = "//span[contains (text(), 'CONFIRMAR')]")
    public static WebElement buttonConfirm;
    //public static By textConfirmation = By.xpath("//div/h5[text()='¡Nos encanta ayudarte!']");
    @FindBy(xpath = "//div/h5[text()='¡Nos encanta ayudarte!']")
    public static WebElement textConfirmation;
    @FindBy(xpath = "//div/a[@class='btn btn-default']")
    public static WebElement buttonUnderstood;
    @FindBy(xpath = "//span[contains(text(),'Ingresa un número de celular')]")
    public static WebElement texMissingPhone;
    @FindBy(xpath = "//span[contains(text(),'Ingresa un correo electrónico')]")
    public static WebElement texMissingMail;
    @FindBy(xpath = "//span[contains(text(),'Ingresa tu nombre')]")
    public static WebElement textMissingName;
    @FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/div/div/span")
    public static  WebElement captchaRealState;

    //Form publish
    @FindBy(xpath = "//*[@id=\"cdk-step-label-0-2\"]/div[2]/div/span")
    public static WebElement buttonTracking3;
    @FindBy(xpath = "//*[@id=\"propertyTypeId\"]/div/div[1]/span/span")
    public static WebElement selectStudioApartment;
    @FindBy(xpath = "//*[@id=\"propertyTypeId\"]/div/div[1]/span/span")
    public static WebElement selectAparment;
    @FindBy(xpath = "//*[@id=\"propertyTypeId\"]/div/div[1]/span/span")
    public static WebElement selectHouse;
    @FindBy(xpath = "//*[@id=\"mat-button-toggle-73-button\"]/div/span")
    public static WebElement selectRent;
    @FindBy(xpath = "//div/span[text()='Venta']")
    public static WebElement buttonPublishSale;
    @FindBy(xpath = "//input[@id=\"sellingPrice\"]")
    public static WebElement inputSalePrice;
    @FindBy(id = "leasingFee")
    public static WebElement inputValueRent;
    @FindBy(id = "administrationValue")
    public static WebElement inputAdministrationValue;
    @FindBy(xpath = "//div[contains(text(),' El campo Valor de la administración Es Obligatorio')]")
    public static WebElement alertValueAdministration;
    @FindBy(id = "antiquity")
    public static WebElement inputAntiquity;
    @FindBy(id = "form_elem")
    public static WebElement sliderAdministration;
    @FindBy(xpath = "//div/textarea")
    public static WebElement inputDescription;
    @FindBy(xpath = "//button/div[contains(text(), '3')]")
    public static WebElement buttonStratum;
    @FindBy(id = "builtArea")
    public static WebElement inputArea;
    @FindBy(id = "ciudad")
    public static WebElement inputCity;
    @FindBy(id = "barrio")
    public static WebElement inputDistric;
    @FindBy(id = "address")
    public static WebElement inputAdress;
    @FindBy(xpath = "//span[contains(text(),'Confirmar ubicación del inmueble.')]")
    public static WebElement checkAdress;
    @FindBy(id = "email")
    public static WebElement inputEmail;
    @FindBy(id = "documentType")
    public static WebElement listTypeDocument;
    @FindBy(xpath = "(//span[contains(text(),'Cédula de ciudadanía')])[2]")
    public static WebElement listCedula;
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
    @FindBy(xpath = "//*[@id=\"mediaInfo\"]/fieldset/div[2]/div[1]/div/div/input-file/div/div/div/button")
    public static WebElement buttonAddPhoto;
    @FindBy(xpath = "(//h3[contains(text(),'Resumen de tu compra')])[2]")
    public static WebElement headerSummary;
    @FindBy(xpath = "//p[contains (text(),'Disculpa no hemos podido ubicar tu inmueble, por favor revisa tu direccion')]")
    public static WebElement texNav;
    @FindBy(xpath = "//*[@id=\"ngx-input-file-0\"]")
    public static WebElement inputImage;
    @FindBy(xpath = "(//button[contains(text(), 'CONTINUAR')])[2]")
    public static WebElement buttonContinuePhoto;



    public Elements() {
        this.webDriverFacade = DriverFactory.getDriverFacade();
        PageFactory.initElements(webDriverFacade.getWebDriver(), this);
    }
}
