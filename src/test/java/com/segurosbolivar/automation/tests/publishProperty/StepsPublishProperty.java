package com.segurosbolivar.automation.tests.publishProperty;

import com.segurosbolivar.automation.tests.shared.Methods;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class StepsPublishProperty {

    private MethodsPublishProperty MethodsPublishProperty;
    private Methods RecicleableMethodsCiencuadras;

    @Step("The user clicks on the publish button in the home")
    public StepsPublishProperty clickPublish() throws InterruptedException{
        RecicleableMethodsCiencuadras = new Methods();
        RecicleableMethodsCiencuadras.clickOnPublish();
        return this;

    }

    @Step("")
    public StepsPublishProperty clickPublishYourself() {
        MethodsPublishProperty = new MethodsPublishProperty();
        RecicleableMethodsCiencuadras.clickOnPublishYourself();
        return this;
    }

    @Step("")
    public StepsPublishProperty clickOnBasicPlan() {
        RecicleableMethodsCiencuadras = new Methods();
        RecicleableMethodsCiencuadras.clickOnBasicPlan();
        return this;
    }

    @Step("")
    public StepsPublishProperty clickOnAddToCar() {
        RecicleableMethodsCiencuadras = new Methods();
        RecicleableMethodsCiencuadras.clickOnAddToCar();
        return this;
    }

    @Step()
    public StepsPublishProperty fillAllFieldPublication() {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.fillAllFieldPublication();
        return this;
    }




}
