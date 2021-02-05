package com.segurosbolivar.automation.tests.product;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.tests.shared.SharedMethods;

public class MethosProduct extends BaseTest {
    private Methods methods = new Methods();
    private SharedMethods shared = new SharedMethods();


    public void clickOnClientRealEstate() {
        methods.doScrollDown(2, "divProduct");
        methods.clickElement("clientRealEstate");
    }

    public void clickOnClientAgent() {
        methods.clickElement("clientAgent");
    }

    public void clickOnClientBuilder() {
        methods.generatosDinamicValue();
        methods.clickElement("clientBuilder");
    }

    public void clickOnMakePlan() {
        methods.clickElement("makePlan");
    }

    public void clickOnSeePlan() {
        methods.waitingForElement("seePlans", 120);
        methods.clickElement("seePlans");
    }

    public void clickOnAddPlanToCar() {
        methods.clickElement("carBasePlan");
    }

    public void clickOnBtnRemoveTour() {
        methods.clickElement("btnRemoveTour");
    }

    public void clickOnBtnAddTour() {
        methods.waitingForElement("btnAddTour", 120);
        methods.clickElement("btnAddTour");
    }

    public void clickOnBtnRemovePhoto() {
        methods.clickElement("btnRemovePhoto");
    }

    public void clickOnBtnAddPhoto() {
        methods.clickElement("btnAddPhoto");
    }

    public void clickOnBtnRemoveOutstanding() {
        methods.clickElement("btnRemoveOutstanding");
    }

    public void clickOnBtnAddOutstanding() {
        methods.clickElement("btnAddOutstanding");
    }

    public void clickOnBtnRemoveAscend() {
        methods.clickElement("btnRemoveAscend");
    }

    public void clickOnBtnAddAddAscend() {
        methods.clickElement("btnAddAscend");
    }

    public void clickOnBtnRemovePriceLine() {
        methods.clickElement("btRemovePriceLine");
    }

    public void clickOnBtnAddAddPriceLine() {
        methods.clickElement("btnAddPriceLine");
    }

    public void clickOnBtnCarPay() {
        methods.waitingForElement("btnCarPay", 130);
        methods.clickElement("btnCarPay");
    }

    public void clickOnBtnPlan() {
        methods.clickElement("btnSelectPlan");

    }

    public void clickOnBtnNewAccount() {
        methods.clickElement("newAccount");
    }

    public void clickOnCheckTerms() {
        methods.clickElement("checkTerms");

    }

    public void clickOnCheckAuthorize() {
        methods.clickElement("checkAuthorize");
    }

    public void clickOnBtnEntry() {
        methods.clickElement("buttonEntryPay");

    }

    public void registerCity() {
        methods.sendKeysText("cityFormProduct", services.getField("sanityCity"));
        methods.pause(2);
        methods.keyDown("cityFormProduct");
    }

    public void fillFormNewAccountSuccess() {
        methods.sendKeysText("nameFormProduct", services.getField("sanityNameUser"));
        methods.sendKeysText("mailFormProduct", methods.dinamicDataTest("sanityNewAccount"));
        methods.sendKeysText("NitFormProduct", services.getField("sanityNit"));
        methods.sendKeysText("phoneFormProduct", services.getField("sanityPhone"));
        registerCity();
        methods.sendKeysText("passwdFormProduct", services.getField("sanityPassword"));
        methods.sendKeysText("passwdConfirmProduct", services.getField("sanityPassword"));
        clickOnCheckTerms();
        clickOnCheckAuthorize();
        clickOnBtnEntry();


    }

    public void fillFormNewAccountExists() {
        methods.sendKeysText("nameFormProduct", services.getField("sanityNameUser"));
        methods.sendKeysText("mailFormProduct", services.getField("sanityMailNewUser"));
        methods.sendKeysText("NitFormProduct", services.getField("sanityNit"));
        methods.sendKeysText("phoneFormProduct", services.getField("sanityPhone"));
        registerCity();
        methods.sendKeysText("passwdFormProduct", services.getField("sanityPassword"));
        methods.sendKeysText("passwdConfirmProduct", services.getField("sanityPassword"));
        clickOnCheckTerms();
        clickOnCheckAuthorize();
        clickOnBtnEntry();


    }

    public void payToCarSuccessful() {
        shared.fillDataFormCar(services.getField("sanityCardsuccess"));
    }

    public void clickOnBtnReturnCommerce() {
        methods.clickElement("btnReturnCommerce");
    }

    public String RealEstateSeePlanExistsUser() {
        methods.waitForPageLoad();
        clickOnBtnPlan();
        methods.waitForPageLoad();
        clickOnBtnAddTour();
        clickOnBtnAddPhoto();
        clickOnBtnAddOutstanding();
        clickOnBtnAddAddAscend();
        clickOnBtnAddAddPriceLine();
        shared.clickOnBtnPayPlan();
        clickOnBtnCarPay();
        methods.changeWindow();
        clickOnBtnNewAccount();
        fillFormNewAccountExists();
        methods.waitingForElement("ExistsUserProduct", 120);
        methods.validationElementEnable("ExistsUserProduct");
        return methods.getEntity("ExistsUserProduct").getText();

    }


    public String NewUserPaymentSuccess() {
        methods.waitForPageLoad();
        clickOnBtnPlan();
        methods.waitForPageLoad();
        clickOnBtnAddTour();
        clickOnBtnAddPhoto();
        clickOnBtnAddOutstanding();
        clickOnBtnAddAddAscend();
        clickOnBtnAddAddPriceLine();
        shared.clickOnBtnPayPlan();
        clickOnBtnCarPay();
        methods.changeWindow();
        clickOnBtnNewAccount();
        fillFormNewAccountSuccess();
        methods.waitingForElement("elemto del carrito",120);
        return methods.getEntity("entryCar").getText();

    }

    public String NewUserPaymentDeclined() {
        methods.waitForPageLoad();
        clickOnBtnPlan();
        methods.waitForPageLoad();
        clickOnBtnAddTour();
        clickOnBtnAddPhoto();
        clickOnBtnAddOutstanding();
        clickOnBtnAddAddAscend();
        clickOnBtnAddAddPriceLine();
        shared.clickOnBtnPayPlan();
        clickOnBtnCarPay();
        methods.changeWindow();
        clickOnBtnNewAccount();
        fillFormNewAccountSuccess();
        methods.waitingForElement("elemto del carrito", 120);
        methods.validationElementEnable("elemtonto carrito");
        return methods.getEntity("texto del carrito").getText();

    }
    public String NewUserPaymentPending() {
        methods.waitForPageLoad();
        clickOnBtnPlan();
        methods.waitForPageLoad();
        clickOnBtnAddTour();
        clickOnBtnAddPhoto();
        clickOnBtnAddOutstanding();
        clickOnBtnAddAddAscend();
        clickOnBtnAddAddPriceLine();
        shared.clickOnBtnPayPlan();
        clickOnBtnCarPay();
        methods.changeWindow();
        clickOnBtnNewAccount();
        fillFormNewAccountSuccess();
        methods.waitingForElement("elemto del carrito", 120);
        methods.validationElementEnable("elemtonto carrito");
        return methods.getEntity("texto del carrito").getText();

    }


}
