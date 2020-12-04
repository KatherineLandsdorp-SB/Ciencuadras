package com.segurosbolivar.automation.tests.publishRealState;

import com.segurosbolivar.automation.tests.shared.RecicleableMethodsCiencuadras;
import com.segurosbolivar.automation.elements.Elements;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class StepsPublishRealState extends Elements {
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
    public StepsPublishRealState fillInCitu(String city) {
        MethodsPublishRealState = new MethodsPublishRealState();
        MethodsPublishRealState.registerCity(city);
        return this;
    }

    @Step()
    public StepsPublishRealState selectCity(){
        MethodsPublishRealState = new MethodsPublishRealState();
        MethodsPublishRealState.selectCity();
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
        assertEquals(MethodsPublishRealState.validationElement(), button);
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
        assertEquals(MethodsPublishRealState.validationDataMandatory(), button);
        return this;
    }

}
