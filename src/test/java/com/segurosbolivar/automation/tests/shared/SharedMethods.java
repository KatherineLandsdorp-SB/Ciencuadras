package com.segurosbolivar.automation.tests.shared;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.commons.helpers.DriverFacade;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    public Boolean clickOnPublishYourself() {
        try {
            methods.waitingForElement("buttonPublishYourself", 20);
            methods.clickElement("buttonPublishYourself");
            return methods.validationElementEnable("buttonPublishYourself");

        }catch (Exception e){
            methods.waitingForElement("buttonPublishYourself", 40);
            methods.scrollToElement("buttonPublishYourself");
            methods.clickElement("buttonPublishYourself");
            return methods.validationElementEnable("buttonPublishYourself");
        }

    }

    public Boolean clickOnBasicPlan() {
        methods.waitingForElement("buttonBasicPlan", 120);
        methods.clickElement("buttonBasicPlan");
        return methods.validationElementEnable("buttonBasicPlan");
    }

    public void clickOnAddToCar() {
        methods.waitingForElement("buttonAddToCar", 10);
        methods.clickElement("buttonAddToCar");
    }

    public void publishRealState() {
        try {
            methods.waitingForElement("buttonRealState", 20);
            methods.clickElement("buttonRealState");

        }catch (Exception e){
            methods.waitingForElement("buttonRealState", 20);
            methods.scrollToElement("buttonRealState");
            methods.clickElement("buttonRealState");
        }

    }


    public String clickOnAddToCarOutstanding() {

        try {
            methods.waitingForElement("buttonAddToCar", 30);
            methods.clickElement("buttonAddToCar");
            methods.waitingForElement("textCoverage", 120);
            return methods.getTextElement("textCoverage");

        }catch (Exception e){
            methods.waitingForElement("buttonAddToCar", 500);
            methods.scrollToElement("buttonAddToCar");
            methods.clickElement("buttonAddToCar");
            methods.waitingForElement("textCoverage", 120);
            return methods.getTextElement("textCoverage");
        }
    }

    public Boolean clickOnAddToCarBasicPlan() {
        methods.waitingForElement("buttonBasicAddToCar", 10);
        methods.clickElement("buttonBasicAddToCar");
        return methods.validationElementEnable("buttonBasicAddToCar");


    }

    public Boolean clickOnButtonSaleHome() {
        methods.waitForPageLoad();
        Boolean elementEnable= methods.validationElementEnable("buttonSaleHome");
        methods.clickElement("buttonSaleHome");
        return elementEnable;
    }

    public Boolean clickOnButtonOfferHome() {
        methods.waitForPageLoad();
        Boolean elementEnable= methods.validationElementEnable("buttonOfferHome");
        methods.clickElement("buttonOfferHome");
       return elementEnable;
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
        methods.waitingForElement("btnPayPlan",250);
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
        methods.waitingForElement("btnPayPlan",150);
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

    public String clickOnDate(){
        methods.scrollToElement("textScrollCalender");
        methods.clickElement("daysCalendar");
        methods.clickDateMonth("daysMonthCalendar");
        methods.waitingForElement("hoursDay",50);
        methods.clickElement("hoursDay");
        methods.waitingForElement("hourDay",50);
        methods.clickElement("hourDay");
        return "";
    }


}
