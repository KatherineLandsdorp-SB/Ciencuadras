package com.segurosbolivar.automation.tests.PublishHome;

import com.segurosbolivar.automation.tests.shared.SharedMethods;
import io.qameta.allure.Step;

import static org.testng.Assert.assertTrue;


public class StepsMethodsPublishHome {
    private MethodsPublishHome MethodsPublishHome;
    private SharedMethods RecicleableMethodsCiencuadras;


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
        RecicleableMethodsCiencuadras=new SharedMethods();
        RecicleableMethodsCiencuadras.clickOnKnowHowPublish();;
    }
    @Step()
    public void validateLabelAccompaiment(){
        MethodsPublishHome=new MethodsPublishHome();
        assertTrue(MethodsPublishHome.validateLabelAccompainment());
    }


}
