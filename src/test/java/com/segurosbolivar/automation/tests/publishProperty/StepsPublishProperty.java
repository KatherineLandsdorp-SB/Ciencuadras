package com.segurosbolivar.automation.tests.publishProperty;

import com.segurosbolivar.automation.tests.shared.RecicleableMethodsCiencuadras;
import com.segurosbolivar.automation.elements.Elements;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class StepsPublishProperty extends Elements {

    private MethodsPublishProperty MethodsPublishProperty;
    private RecicleableMethodsCiencuadras RecicleableMethodsCiencuadras;

    @Step("The user clicks on the publish button in the home")
    public StepsPublishProperty clickPublish() throws InterruptedException{
        RecicleableMethodsCiencuadras = new RecicleableMethodsCiencuadras();
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
        RecicleableMethodsCiencuadras = new RecicleableMethodsCiencuadras();
        RecicleableMethodsCiencuadras.clickOnBasicPlan();
        return this;
    }

    @Step("")
    public StepsPublishProperty clickOnAddToCar() {
        RecicleableMethodsCiencuadras = new RecicleableMethodsCiencuadras();
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
