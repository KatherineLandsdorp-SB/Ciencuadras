package com.segurosbolivar.automation.tests.publishProperty;

import com.segurosbolivar.automation.tests.shared.RecicleableMethodsCiencuadras;
import com.segurosbolivar.automation.elements.Elements;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class StepsPublishProperty extends Elements {

    private MethodsPublishProperty MethodsPublishProperty;
    private RecicleableMethodsCiencuadras RecicleableMethodsCiencuadras;

    @Step("The user clicks on the publish button in the home")
    public StepsPublishProperty clickPublish() {
        RecicleableMethodsCiencuadras = new RecicleableMethodsCiencuadras();
        RecicleableMethodsCiencuadras.clickOnPublish();
        return this;

    }

    @Step("")
    public StepsPublishProperty clickPublishYourself() {
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
    @Step()
    public  StepsPublishProperty registerCityCoverage(String city){
        MethodsPublishProperty= new MethodsPublishProperty();
        MethodsPublishProperty.registerCityCoverage(city);
        return this;
    }
    @Step()
    public  StepsPublishProperty validateCityCoverage(String text){
        MethodsPublishProperty= new MethodsPublishProperty();
        assertEquals(MethodsPublishProperty.validateTextConfirmCoverage(),text);
        return this;
    }
    @Step()
    public StepsPublishProperty validateCityOutCoverage(String text){
        MethodsPublishProperty = new MethodsPublishProperty();
        assertEquals(MethodsPublishProperty.validateTextOutCoverage(),text);
        return this;
    }
    @Step()
    public StepsPublishProperty clickButtonContinueCityCoverage(){
        MethodsPublishProperty= new MethodsPublishProperty();
        MethodsPublishProperty.clickButtonContinueCoverageCity();
        return this;
    }




}
