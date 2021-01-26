package com.segurosbolivar.automation.tests.publishRealState;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.tests.publishProperty.StepsPublishProperty;
import com.segurosbolivar.automation.tests.shared.SharedMethods;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class StepsPublishRealState extends BaseTest {
    private MethodsPublishRealState MethodsPublishRealState= new MethodsPublishRealState();
    private SharedMethods sharemethods = new SharedMethods();

    @Step("The user clicks on the sale button in the home")
    public StepsPublishRealState clickButtonSaleHome() {
        sharemethods.clickOnButtonSaleHome();
        return this;

    }

    @Step("The user clicks on the offer button in the home")
    public StepsPublishRealState clickButtonOfferHome() {
        sharemethods.clickOnButtonOfferHome();
        return this;
    }

    @Step("The user click on the button publih with Real State")
    public StepsPublishRealState clickRealState() {
        sharemethods.publishRealState();
        return this;
    }

    @Step("Register name in form publish with real state")
    public StepsPublishRealState fillInName() {
        MethodsPublishRealState.registerName();
        return this;
    }

    @Step("Register email in form publish with real state")
    public StepsPublishRealState fillInMail() {
        MethodsPublishRealState.registerMail();
        return this;
    }

    @Step("Step(Register cellphone in form publish with real state)")
    public StepsPublishRealState fillInPhones() {
        MethodsPublishRealState.registerPhone();
        return this;
    }

    @Step("Register city in form publish with real state)")
    public StepsPublishRealState fillInCity() throws InterruptedException {
        MethodsPublishRealState.registerCity();
        return this;
    }


    @Step("select rent transaction form publish with real state")
    public StepsPublishRealState selectSale() {
        MethodsPublishRealState.clickButtonSale();
        return this;
    }

    @Step("click on button confirm in form publish with real state")
    public StepsPublishRealState clickConfirmation() {
        MethodsPublishRealState.clickButtonConfirm();
        return this;
    }

    @Step("Validate text button Understood to end the form publish with real state")
    public StepsPublishRealState validationTextButtonUnderstand() {
        assertEquals(MethodsPublishRealState.validateElement(), services.getField("sanityUnderstand"));
        return this;
    }

    @Step("click on button Understood")
    public StepsPublishRealState clickButtonUnderstood() {
        MethodsPublishRealState.clickButtonUnderstood();
        return this;
    }

    @Step("validate mandatory button confirm")
    public StepsPublishRealState validationDataMandatory() {
        assertEquals(MethodsPublishRealState.validateDataMandatory(), services.getField("sanityConfirm"));
        return this;
    }

    @Step("validate existence radio button sale")
    public StepsPublishRealState validationRadioButtonSale() {
        assertTrue(MethodsPublishRealState.validateRadioButtonSale());
        return this;
    }

    @Step("validate existence radio button rent")
    public StepsPublishRealState validationRadioButtonRent() {

        assertTrue(MethodsPublishRealState.validateRadioButtonRent());
        return this;
    }

    @Step("validate existence radio button rent and sale")
    public StepsPublishRealState validationRadioButtonRentSale() {
        assertTrue(MethodsPublishRealState.validateRadioButtonRentSale());
        return this;
    }


}
