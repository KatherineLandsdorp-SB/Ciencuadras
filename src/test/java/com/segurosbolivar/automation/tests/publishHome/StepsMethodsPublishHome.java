package com.segurosbolivar.automation.tests.publishHome;

import com.segurosbolivar.automation.tests.shared.RecicleableMethodsCiencuadras;
import io.qameta.allure.Step;

import static org.testng.Assert.assertTrue;


public class StepsMethodsPublishHome {
    private MethodsPublishHome MethodsPublishHome;
    private RecicleableMethodsCiencuadras RecicleableMethodsCiencuadras;


    @Step()
    public void validateButtonPublishProperty(){
        MethodsPublishHome= new MethodsPublishHome();
        assertTrue( MethodsPublishHome.validateButtonPublishProperty());
    }
    @Step()
    public void validateButtonKnowPublish(){
        MethodsPublishHome= new MethodsPublishHome();
        assertTrue( MethodsPublishHome.validateButtonKnowHowPublish());
    }
    @Step()
    public void clickButtonKnowPublish(){
        RecicleableMethodsCiencuadras=new RecicleableMethodsCiencuadras();
        RecicleableMethodsCiencuadras.clickOnKnowHowPublish();;
    }
    @Step()
    public void validateLabelAccompaiment(){
        MethodsPublishHome=new MethodsPublishHome();
        assertTrue(MethodsPublishHome.validateLabelAccompainment());
    }


}
