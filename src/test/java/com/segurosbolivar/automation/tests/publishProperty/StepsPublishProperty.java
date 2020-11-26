package com.segurosbolivar.automation.tests.publishProperty;

import com.segurosbolivar.automation.elements.Elements;
import com.segurosbolivar.automation.tests.login.MethodsLogin;
import com.segurosbolivar.automation.tests.login.StepsLogin;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class StepsPublishProperty extends Elements {

    private MethodsPublishProperty MethodsPublishProperty;

        @Step ("The user clicks on the publish button in the home")
        public StepsPublishProperty clickPublish(){
            MethodsPublishProperty = new MethodsPublishProperty();
            MethodsPublishProperty.clickOnPublish();
            return this;

        }

        @Step("")
        public StepsPublishProperty clickPublishYourself(){
            MethodsPublishProperty = new MethodsPublishProperty();
            MethodsPublishProperty.clickOnPublishYourself();
        return this;
       }
       @Step("")
    public StepsPublishProperty  clickOnBasicPlan(){
            MethodsPublishProperty= new MethodsPublishProperty();
            MethodsPublishProperty.clickOnBasicPlan();
        return this;
    }
         @Step("")
    public  StepsPublishProperty clickOnAddToCar(){
            MethodsPublishProperty= new MethodsPublishProperty();
            MethodsPublishProperty.clickOnAddToCar();
        return this;
    }

    @Step()
    public StepsPublishProperty fillAllFieldPublication(){
            MethodsPublishProperty.fillAllFieldPublication();
        return this;
    }




}
