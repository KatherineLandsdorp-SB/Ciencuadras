package com.segurosbolivar.automation.tests.publishRealState;

import com.segurosbolivar.automation.tests.shared.RecicleableMethodsCiencuadras;
import com.segurosbolivar.automation.elements.Elements;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class StepsPublishRealState {
    private MethodsPublishRealState MethodsPublishRealState;
    private RecicleableMethodsCiencuadras RecicleableMethodsCiencuadras;

    @Step()
    public StepsPublishRealState clickPublish() {
        RecicleableMethodsCiencuadras = new RecicleableMethodsCiencuadras();
        RecicleableMethodsCiencuadras.clickOnPublish();
        return this;
    }

    @Step()
    public StepsPublishRealState clickRealState() {
        RecicleableMethodsCiencuadras = new RecicleableMethodsCiencuadras();
        RecicleableMethodsCiencuadras.publishRealState();
        return this;
    }

    @Step()
    public StepsPublishRealState fillInName(String name) {
        MethodsPublishRealState = new MethodsPublishRealState();
        MethodsPublishRealState.registerName(name);
        return this;
    }

    @Step()
    public StepsPublishRealState fillInMail(String mail) {
        MethodsPublishRealState = new MethodsPublishRealState();
        MethodsPublishRealState.registerMail(mail);
        return this;
    }

    @Step()
    public StepsPublishRealState fillInPhones(String phone) {
        MethodsPublishRealState = new MethodsPublishRealState();
        MethodsPublishRealState.registerPhone(phone);
        return this;
    }

    @Step()
    public StepsPublishRealState fillInCitu(String city) throws InterruptedException {
        MethodsPublishRealState = new MethodsPublishRealState();
        MethodsPublishRealState.registerCity(city);
        return this;
    }
    @Step()
    public StepsPublishRealState selectSale() {
        MethodsPublishRealState = new MethodsPublishRealState();
        MethodsPublishRealState.clickButtonSale();
        return this;
    }

    @Step()
    public StepsPublishRealState clickConfirmation() {
        MethodsPublishRealState = new MethodsPublishRealState();
        MethodsPublishRealState.clickButtonConfirm();
        return this;
    }

    @Step()
    public StepsPublishRealState validationButton(String button) {
        MethodsPublishRealState = new MethodsPublishRealState();
        assertEquals(MethodsPublishRealState.validateElement(), button);
        return this;
    }

    @Step()
    public StepsPublishRealState clickButtonUnderstood() {
        MethodsPublishRealState = new MethodsPublishRealState();
        MethodsPublishRealState.clickButtonUnderstood();
        return this;
    }

    @Step()
    public StepsPublishRealState validationDataMandatory(String button) {
        MethodsPublishRealState = new MethodsPublishRealState();
        assertEquals(MethodsPublishRealState.validateDataMandatory(), button);
        return this;
    }

    @Step()
    public StepsPublishRealState validationRadioButtonSale() {
        MethodsPublishRealState = new MethodsPublishRealState();
        assertTrue(MethodsPublishRealState.validateRadioButtonSale());
        return this;
    }

    @Step()
    public StepsPublishRealState validationRadioButtonRent() {
        MethodsPublishRealState = new MethodsPublishRealState();
        assertTrue(MethodsPublishRealState.validateRadioButtonRent());
        return this;
    }

    @Step()
    public StepsPublishRealState validationRadioButtonRentSale() {
        MethodsPublishRealState = new MethodsPublishRealState();
        assertTrue(MethodsPublishRealState.validateRadioButtonRentSale());
        return this;
    }

    @Step()
    public StepsPublishRealState clickCaptcha() {
        MethodsPublishRealState = new MethodsPublishRealState();
        MethodsPublishRealState.clickOnCaptha();
        return this;
    }


}
