package com.segurosbolivar.automation.tests.product;


import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.tests.shared.SharedMethods;

public class MethodsProduct extends BaseTest {
    private Methods methods = new Methods();
    private SharedMethods shared = new SharedMethods();

    public String clickOnButtonProduct() {
        methods.clickElement("linkProduct");
        methods.waitingForElement("textProduct", 120);
        return methods.getTextElement("textProduct");
    }

    public Boolean validateOptionSeePlan() {
        return methods.validationElementEnable("seePlans");
    }

    public Boolean validationOptionsMakePlan() {
        return methods.validationElementEnable("makePlan");
    }


    public void clickOnClientRealEstate() {
        methods.doScrollDown(2, "divProduct");
        methods.clickElement("clientRealEstate");
    }

    public String clickOnBtnReturnCommerce() {
        methods.clickElement("btnReturnCommerce");
        methods.waitingForElement("sanityFinalpaySuccess", 120);
        methods.validationElementEnable("goAccount");
        return methods.getTextElement("paySuccessful");
    }

    public String clickOnBtnReturnCommercePending() {
        methods.clickElement("btnReturnCommerce");
        methods.waitingForElement("payToPending", 120);
        return methods.getTextElement("payToPending");
    }

    public Boolean clickOnButtonGoAccount() {
        methods.clickElement("goAccount");
        return methods.validationElementEnable("activeProduct");
    }

    public void clickOnClientAgent() {
        methods.waitingForElement("clientAgent", 120);
        methods.clickElement("clientAgent");
    }

    public void clickOnClientBuilder() {
        methods.waitingForElement("clientBuilder", 120);
        methods.clickElement("clientBuilder");
    }

    public Boolean clickOnMakePlan() {
        methods.waitingForElement("makePlan", 120);
        methods.clickElement("makePlan");
        methods.waitingForElement("windowMakePlan", 120);
        return methods.validationElementEnable("windowMakePlan");
    }

    public Boolean clickOnSeePlan() {
        methods.waitingForElement("seePlans", 120);
        methods.clickElement("seePlans");
        methods.waitingForElement("windowSeePlan", 120);
        return methods.validationElementEnable("windowSeePlan");
    }

    public void clickOnAddPlanToCar() {
        methods.scrollTo("carBasePlan");
        methods.clickElement("carBasePlan");
    }


    public void clickOnBtnAddTour() {
        methods.waitingForElement("btnAddTour", 120);
        methods.clickElement("btnAddTour");
    }


    public void clickOnBtnAddPhoto() {
        methods.clickElement("btnAddPhoto");
    }


    public void clickOnBtnAddOutstanding() {
        methods.clickElement("btnAddOutstanding");
    }


    public void clickOnBtnAddAddAscend() {
        methods.clickElement("btnAddAscend");
    }


    public void clickOnBtnAddAddPriceLine() {
        methods.clickElement("btnAddPriceLine");
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
        methods.pause(10);


    }

    public void payToCarSuccessful() {
        shared.fillDataFormCar(services.getField("sanityCardsuccess"));
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
        shared.clickOnBtnCarPay();
        methods.changeWindow();
        clickOnBtnNewAccount();
        fillFormNewAccountExists();
        methods.waitingForElement("ExistsUserProduct", 120);
        methods.validationElementEnable("ExistsUserProduct");
        return methods.getEntity("ExistsUserProduct").getText();

    }


    public String seePlanNewUser() {
        methods.waitForPageLoad();
        clickOnBtnPlan();
        methods.waitForPageLoad();
        clickOnBtnAddTour();
        clickOnBtnAddPhoto();
        clickOnBtnAddOutstanding();
        clickOnBtnAddAddAscend();
        clickOnBtnAddAddPriceLine();
        shared.clickOnBtnPayPlan();
        shared.clickOnBtnCarPay();
        methods.changeWindow();
        clickOnBtnNewAccount();
        fillFormNewAccountSuccess();
        methods.waitingForElement("entryCar", 800);
        return methods.getEntity("entryCar").getText();

    }

    public String makePlanNewUser() {
        methods.waitForPageLoad();
        methods.waitForPageLoad();
        clickOnBtnAddTour();
        clickOnBtnAddPhoto();
        clickOnBtnAddOutstanding();
        clickOnBtnAddAddAscend();
        clickOnBtnAddAddPriceLine();
        clickOnAddPlanToCar();
        shared.clickOnBtnPayPlan();
        shared.clickOnBtnCarPay();
        methods.changeWindow();
        clickOnBtnNewAccount();
        fillFormNewAccountSuccess();
        methods.waitingForElement("entryCar", 800);
        return methods.getEntity("entryCar").getText();

    }


}
