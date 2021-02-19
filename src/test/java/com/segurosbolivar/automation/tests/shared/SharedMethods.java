package com.segurosbolivar.automation.tests.shared;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.commons.helpers.DriverFacade;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SharedMethods extends BaseTest {

    private Methods methods = new Methods();


    public void clickOnPublish() {
        methods.clickElement("buttonPublishProperty");
    }

    public void clickOnKnowHowPublish() {
        methods.clickElement("buttonKnowPublish");
    }

    public void clickOnPublishYourself() {
        methods.doScrollDown(2, "divPublish");
        methods.clickElement("buttonPublishYourself");
    }

    public void clickOnBasicPlan() {
        methods.waitingForElement("buttonBasicPlan", 10);
        methods.clickElement("buttonBasicPlan");
    }

    public void clickOnAddToCar() {
        methods.waitingForElement("buttonAddToCar", 10);
        methods.clickElement("buttonAddToCar");
    }

    public void publishRealState() {
        methods.waitingForElement("buttonRealState", 10);
        methods.clickElement("buttonRealState");
    }


    public void clickOnAddToCarOutstanding() {
        methods.waitingForElement("buttonAddToCar", 10);
        methods.clickElement("buttonAddToCar");
    }

    public void clickOnAddToCarBasicPlan() {
        methods.waitingForElement("buttonBasicAddToCar", 10);
        methods.clickElement("buttonBasicAddToCar");


    }

    public void clickOnButtonSaleHome() {
        methods.waitForPageLoad();
        methods.clickElement("buttonSaleHome");
    }

    public void clickOnButtonOfferHome() {
        methods.waitForPageLoad();
        methods.clickElement("buttonOfferHome");
    }



    public void registerValueAdministration() {
        List<WebElement> dynamicElement = driverFacade.getWebDriver().findElements(By.id("administrationValue"));
        if (dynamicElement.size() != 0) {
            System.out.println("Existe elemento");
            methods.sendKeysText("inputAdministrationValue", services.getField("sanityAdminValue"));
        } else {//0, elemento no esta presente.
            System.out.println("El campo valor arriendo esta deshabilitado");
        }
    }

    public void clickOnBtnPayPlan() {
        methods.clickElement("btnPayPlan");
    }
    public void clickOnBtnCarPay() {
        methods.waitingForElement("btnCarPay", 130);
        methods.clickElement("btnCarPay");
    }

    public void fillDataFormCar(String number) {
        methods.clickElement("btnPayPlan");
        methods.waitingForElement("creditCard",150);
        methods.clickElement("creditCard");
        methods.sendKeysText("nameCreditCard", services.getField("sanityNameUser"));
        methods.sendKeysText("numberCreditCard", number);
        methods.sendKeysText("monthCreditCard", services.getField("sanityMonth"));
        methods.sendKeysText("yearCreditCard", services.getField("sanityYear"));
        methods.sendKeysText("cvvCreditCard", services.getField("sanityCvv"));
        methods.angularMaterialAutocomplete("selectDues","divDues");
        methods.doScrollDown(1,"sanityNameUser");
        clickOnBtnCarPay();
    }

    public void fillDataFormCarProduct(String number) {

        methods.clickElement("btnPayPlan");
        methods.waitingForElement("creditCard",150);
        methods.clickElement("creditCard");
        methods.sendKeysText("nameCreditCard", services.getField("sanityNameUser"));
        methods.sendKeysText("numberCreditCard", number);
        methods.sendKeysText("monthCreditCard", services.getField("sanityMonth"));
        methods.sendKeysText("yearCreditCard", services.getField("sanityYear"));
        methods.sendKeysText("cvvCreditCard", services.getField("sanityCvv"));
        methods.angularMaterialAutocomplete("selectDues","divDues");
        methods.doScrollDown(1,"sanityNameUser");
        clickOnBtnPayPlan();
    }

    public String  paymentSuccessProduct() {
        fillDataFormCarProduct(services.getField("sanityCardsuccess"));
        methods.waitingForElement("transactionSuccess",500);
        return methods.getTextElement("transactionSuccess");
    }

    public String  paymentSuccess() {
        fillDataFormCar(services.getField("sanityCardsuccess"));
        methods.waitingForElement("transactionSuccess",500);
        return methods.getTextElement("transactionSuccess");
    }

    public  String  paymentFail() {
        fillDataFormCar(services.getField("sanityCardFail"));
        return methods.getTextElement("payFail");
    }
    public  String  paymentFaiProduct() {
        fillDataFormCarProduct(services.getField("sanityCardFail"));
        methods.waitingForElement("payFail",500);
        return methods.getTextElement("payFail");

    }

    public String  paymentPending() {
        fillDataFormCar(services.getField("sanityCardPending"));
        return methods.getTextElement("payPending");
    }
    public String  paymentPendingProduct() {
        fillDataFormCarProduct(services.getField("sanityCardPending"));
        methods.waitingForElement("payPending",500);
        return methods.getTextElement("payPending");
    }

    public String retryPay(){
        return methods.getTextElement("retryPayment");
    }
    public String  clickOnButtonRetryPay(){
        methods.clickElement("retryPayment");
        methods.waitingForElement("paymentMethod",500);
        return methods.getTextElement("paymentMethod");

    }



}
