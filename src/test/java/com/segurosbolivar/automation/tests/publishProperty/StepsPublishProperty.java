package com.segurosbolivar.automation.tests.publishProperty;

import com.segurosbolivar.automation.tests.shared.SharedMethods;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class StepsPublishProperty {

    private MethodsPublishProperty MethodsPublishProperty;
    private SharedMethods RecicleableMethodsCiencuadras;

    @Step("The user clicks on the publish button in the home")
    public StepsPublishProperty clickPublish() throws InterruptedException{
        RecicleableMethodsCiencuadras = new SharedMethods();
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
        RecicleableMethodsCiencuadras = new SharedMethods();
        RecicleableMethodsCiencuadras.clickOnBasicPlan();
        return this;
    }

    @Step("")
    public StepsPublishProperty clickOnAddToCar() {
        RecicleableMethodsCiencuadras = new SharedMethods();
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
