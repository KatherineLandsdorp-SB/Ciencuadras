package com.segurosbolivar.automation.tests.publishRealState;

import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.tests.shared.SharedMethods;

public class MethodsPublishRealState extends BaseTest {
    private Methods methods = new Methods();
    private SharedMethods shared = new SharedMethods();

    public void registerForm(){

        methods.waitingForElement("inputNameRegister", 110);
        methods.clickElement("inputNameRegister");
        methods.sendKeysText("inputNameRegister", services.getField("sanityNameRealSt"));
        methods.sendKeysText("inputMail", services.getField("sanityMailRealSt"));
        methods.sendKeysText("inputPhone", services.getField("sanityPhone"));
        methods.sendKeysText("inputCityReallSate", services.getField("sanityCity"));
        methods.pause(2);
        methods.keyDown("inputCityReallSate");
        methods.clickElement("radioButtonSale");
        methods.clickElement("recaptcha");
        methods.pause(5);
        methods.clickElement("buttonConfirm");

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

    public void registerCity() throws InterruptedException {
        methods.waitingForElement("inputCityReallSate", 110);
        methods.sendKeysText("inputCityReallSate", services.getField("sanityCity"));
        methods.pause(2);
        methods.keyDown("inputCityReallSate");
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
        methods.clickElement("buttonConfirm");
    }

    public String validateElement() {
        methods.waitingForElement("buttonUnderstood", 110);
        String text = methods.getTextElement("buttonUnderstood");
        System.out.println("texto encontrado" + text);
        return text;
    }

    public void clickButtonUnderstood() {
        methods.clickElement("buttonUnderstood");
    }

    public String validateDataMandatory() {
        methods.waitingForElement("buttonConfirm", 110);
        String text = methods.getTextElement("buttonConfirm");
        System.out.println("texto encontrado" + text);
        return text;
    }

    public boolean validateRadioButtonSale() {
        boolean present = methods.validationElementEnable("radioButtonSale");
        return present;

    }

    public boolean validateRadioButtonRent() {
        boolean present = methods.validationElementEnable("radioButtonRent");
        return present;
    }

    public boolean validateRadioButtonRentSale() {
        boolean present = methods.validationElementEnable("radioButtonRentSale");
        return present;
    }

    public void clickOnCaptcha() {
        methods.clickElement("recaptcha");
        methods.pause(5);
    }
}
