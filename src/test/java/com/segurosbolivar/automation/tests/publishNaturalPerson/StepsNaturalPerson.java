package com.segurosbolivar.automation.tests.publishNaturalPerson;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.tests.shared.SharedMethods;
import io.qameta.allure.Step;

import static org.testng.Assert.*;

public class StepsNaturalPerson extends BaseTest {

    private MethodsNaturalPerson methodsNaturalPerson = new MethodsNaturalPerson();
    private SharedMethods sharemethods = new SharedMethods();

    @Step("The user clicks on the sale button in the home")
    public StepsNaturalPerson clickButtonSaleHome() {
        assertTrue(sharemethods.clickOnButtonSaleHome());
        return this;

    }

    @Step("The user clicks on the offer button in the home")
    public StepsNaturalPerson clickButtonOfferHome() {
        assertTrue(sharemethods.clickOnButtonOfferHome());
        return this;

    }

    @Step("The user click on button publish yourself")
    public StepsNaturalPerson clickPublishYourself() {
        assertTrue(sharemethods.clickOnPublishYourself());
        return this;
    }

    @Step("The user click on button add to car for basic plan")
    public StepsNaturalPerson clickOnAddToCar() {
        assertTrue(sharemethods.clickOnAddToCarBasicPlan());
        return this;
    }

    @Step("The user click on button add to car for outstanding plan")
    public StepsNaturalPerson clickOnAddToCarOutstanding() {
        assertEquals(sharemethods.clickOnAddToCarOutstanding(), "Verifica tu cobertura");
        return this;
    }

    //Step form publications

    @Step("register of new user in form PN")
    public StepsNaturalPerson fillFormNewUser() {
        assertEquals(methodsNaturalPerson.registerUserEndFormPublishNaturalPerson(), services.getField("sanityNameUser") + " " + services.getField("sanityLastName"));
        return this;
    }

    @Step("publish include value administration")
    public StepsNaturalPerson publishRentWithAdministrationValue() {
        assertEquals(methodsNaturalPerson.publishRentIncludeAdministration(), services.getField("sanityUserRegister"));
        return this;
    }

    @Step("publication validate the steps in form")
    public StepsNaturalPerson validateSteps() {
        assertEquals(methodsNaturalPerson.publishWithTracking(), services.getField("sanityUserRegister"));
        return this;
    }

    @Step("publish include value administration")
    public StepsNaturalPerson validateBackSteps() {
        assertEquals(methodsNaturalPerson.publishBackStep(), services.getField("sanityUserRegister"));
        return this;
    }

    @Step("validation field value administration")
    public StepsNaturalPerson publishRentWithOutFieldAdministration() {
        assertEquals(methodsNaturalPerson.publishRentWithOutAdministration(), services.getField("sanityAlertValueAdmin"));
        return this;
    }

    @Step("The user registered city whit coverage")
    public StepsNaturalPerson registerCityCoverage() {
        assertEquals(methodsNaturalPerson.registerCityCoverage(), services.getField("sanityCoverageCity"));
        return this;
    }
    @Step("validation city out coverage")
    public StepsNaturalPerson validateCityOutCoverage() {
        methodsNaturalPerson.registerCityOutCoverage();
        methodsNaturalPerson.clickButtonConfirmCoverageCity();
        assertEquals(methodsNaturalPerson.validateCityOutCoverage(), services.getField("sanityOutCoverageCity"));
        return this;
    }

    @Step("The user click on button continue form validation city coverage")
    public StepsNaturalPerson clickButtonContinueCityCoverage() {
        methodsNaturalPerson.clickButtonContinueCoverage();
        assertTrue(methodsNaturalPerson.validateLabelAccompaniment());
        return this;
    }

    @Step("Form for publish for rent")
    public StepsNaturalPerson fillFormRent() {
        methodsNaturalPerson.publishRentNaturalPerson();
        return this;
    }

    @Step("Form for publish for rent")
    public StepsNaturalPerson fillFormRentUserLoggedIn() {
        assertEquals( methodsNaturalPerson.publishRentUserLoggedIn(),services.getField("sanityUserRegister"));
        return this;
    }

    @Step("Form for publish for sale")
    public StepsNaturalPerson fillFormSale() {
        methodsNaturalPerson.publishSaleNaturalPerson();
        return this;
    }


    @Step("validation form  without city")
    public StepsNaturalPerson validateFormWithoutCity() {
        assertEquals(methodsNaturalPerson.publishWithoutAddress(), services.getField("sanityEmptyCity"));
        return this;
    }

    @Step("validation form  wrong address")
    public StepsNaturalPerson validateFormWrongAddress() {
        assertEquals(methodsNaturalPerson.publishWithWrongAddress(), services.getField("sanityEmptyCity"));
        return this;
    }

    @Step("upload images")
    public StepsNaturalPerson uploadFile()  {
        methodsNaturalPerson.uploadImage();
        return this;
    }

    @Step("user click on button continue windows add photo")
    public StepsNaturalPerson clickButtonContinuePhoto() {
        methodsNaturalPerson.clickOnButtonContinuePhoto();
        return this;
    }

    @Step("fill form car for pay succes ")
    public StepsNaturalPerson paymentSuccess() {
        assertEquals(sharemethods.paymentSuccess(), services.getField("sanityPaySuccess"));
        return this;

    }

    @Step("Click on button return commerce")
    public StepsNaturalPerson returnCommerce() {
        methodsNaturalPerson.clickOnBtnReturnCommerce();
        assertTrue(methodsNaturalPerson.validateButtonGoPublication());
        assertTrue(methodsNaturalPerson.validateButtonAddInformation());
        return this;
    }
    @Step("Click on button go to my publications")
    public StepsNaturalPerson clickGotoPublication(){
       assertTrue(methodsNaturalPerson.clickOnButtonGoPublication());
        return this;

    }
    @Step("Click on button go to my publications")
    public StepsNaturalPerson clickAddInformation(){
        assertTrue(methodsNaturalPerson.clickOnButtonAddInformation());
        return this;

    }

    @Step("select the date you want")
    public StepsNaturalPerson filldate(){
        sharemethods.clickOnDate();
    return this;
    }

}






