package com.segurosbolivar.automation.tests.publishRealState;

import com.segurosbolivar.automation.tests.shared.RecicleableMethodsCiencuadras;
import com.segurosbolivar.automation.elements.Elements;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class StepsPublishRealState extends Elements {
    private MethodsPublishRealState MethodsPublishRealState;
    private RecicleableMethodsCiencuadras RecicleableMethodsCiencuadras;

    @Step()
    public StepsPublishRealState clickPublish() throws InterruptedException{
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
    public StepsPublishRealState fillFieldFormRealState(String textConfirmation) {
        MethodsPublishRealState = new MethodsPublishRealState();
        MethodsPublishRealState.fillFieldsFormRealState();
        assertEquals(MethodsPublishRealState.fillFieldsFormRealState(), textConfirmation);
        return this;
    }
}
