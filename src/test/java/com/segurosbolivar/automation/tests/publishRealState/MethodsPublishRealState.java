package com.segurosbolivar.automation.tests.publishRealState;

import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.tests.shared.SharedMethods;

public class MethodsPublishRealState extends BaseTest {
    private Methods methods = new Methods();
    private SharedMethods shared = new SharedMethods();

    public Boolean publishRealState() {
        methods.waitingForElement("buttonRealState", 10);
        methods.clickElement("buttonRealState");
        methods.waitingForElement("recaptcha",10);
        return methods.validationElementEnable("recaptcha");
    }


    public void registerForm(){

        methods.waitingForElement("inputNameRegister", 210);
        methods.clickElement("inputNameRegister");
        methods.sendKeysText("inputNameRegister", services.getField("sanityNameRealSt"));
        methods.sendKeysText("inputMail", services.getField("sanityMailRealSt"));
        methods.sendKeysText("inputPhone", services.getField("sanityPhone"));
        methods.sendKeysText("inputCityRealState", services.getField("sanityCity"));
        methods.pause(2);
        methods.keyDown("inputCityRealState");
        try {
            methods.clickElement("radioButtonSale");
        }catch (Exception e ){
            methods.scrollTo("radioButtonSale");
            methods.clickElement("radioButtonSale");

        }
        methods.clickElement("recaptcha");
        methods.clickElement("recaptchaMobile");
        methods.pause(5);
        try {
            methods.clickElement("buttonConfirm");
        }catch (Exception e ){
            methods.scrollTo("buttonConfirm");
            methods.clickElement("buttonConfirm");

        }

    }

    public void registerName() {
        methods.waitingForElement("inputNameRegister", 110);
        methods.clickElement("inputNameRegister");
        methods.sendKeysText("inputNameRegister", services.getField("sanityNameRealSt"));
    }

    public void registerMail() {
        methods.waitingForElement("inputMail", 110);
        methods.sendKeysText("inputMail", services.getField("sanityMailRealSt"));

    }

    public void registerPhone() {
        methods.sendKeysText("inputPhone", services.getField("sanityPhone"));
    }

    public void registerCity()  {
        methods.waitingForElement("inputCityRealState", 110);
        methods.sendKeysText("inputCityRealState", services.getField("sanityCity"));
        methods.pause(2);
        methods.keyDown("inputCityRealState");
    }

    public void clickButtonSale() {
        methods.waitingForElement("radioButtonSale", 110);
        methods.clickElement("radioButtonSale");
    }

    public void clickButtonRent() {
        methods.clickElement("radioButtonRent");
    }

    public void clickRadioButtonRentSale() {
        methods.clickElement("radioButtonRentSale");
    }

    public void clickButtonConfirm() {
        try {
            methods.clickElement("buttonRealState");

        }catch (Exception e){
            methods.waitingForElement("buttonConfirm", 20);
            methods.scrollToElement("buttonConfirm");
            methods.clickElement("buttonConfirm");
        }
    }

    public String validateElement() {
        methods.waitingForElement("buttonUnderstood", 110);
        return methods.getTextElement("buttonUnderstood");
    }

    public Boolean clickButtonUnderstood() {
        methods.clickElement("buttonUnderstood");
        return methods.validationElementEnable("buttonSaleHome");
    }

    public String validateDataMandatory() {
        methods.waitingForElement("buttonConfirm", 10);

        return methods.getTextElement("buttonConfirm");
    }

    public boolean validateRadioButtonSale() {
        return methods.validationElementEnable("radioButtonSale");

    }

    public boolean validateRadioButtonRent() {

        return methods.validationElementEnable("radioButtonRent");
    }

    public boolean validateRadioButtonRentSale() {
        return methods.validationElementEnable("radioButtonRentSale");
    }

    public void clickOnCaptcha() {
        methods.clickElement("recaptcha");
        methods.pause(5);
    }

    public void fillNoMandatoryDataName() {
        registerMail();
        registerPhone();
        registerCity();
        clickButtonSale();
        clickOnCaptcha();
        clickButtonConfirm();
    }
    public void fillNoMandatoryDataEmail(){
        registerName();
        registerPhone();
        registerCity();
        clickButtonRent();
        clickOnCaptcha();
        clickButtonConfirm();
    }
    public void fillNoMandatoryDataPhone(){
        registerName();
        registerMail();
        registerCity();
        clickButtonSale();
        clickOnCaptcha();
        clickButtonConfirm();
    }
    public void fillNoMandatoryDataCity(){
        registerName();
        registerMail();
        registerPhone();
        clickRadioButtonRentSale();
        clickOnCaptcha();
        clickButtonConfirm();
    }


}
