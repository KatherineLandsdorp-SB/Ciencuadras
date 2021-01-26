package com.segurosbolivar.automation.tests.PublishHome;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.tests.shared.SharedMethods;
import io.qameta.allure.Step;

import static org.testng.Assert.assertTrue;


public class StepsMethodsPublishHome extends BaseTest {
    private MethodsPublishHome MethodsPublishHome;

    private SharedMethods sharemethods = new SharedMethods();


    @Step("Validate existence button publish property")
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
        sharemethods.clickOnKnowHowPublish();

    }



}
