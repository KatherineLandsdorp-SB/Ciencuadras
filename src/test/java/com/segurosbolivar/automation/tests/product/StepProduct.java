package com.segurosbolivar.automation.tests.product;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.tests.publishProperty.StepsPublishProperty;
import com.segurosbolivar.automation.tests.shared.SharedMethods;
import io.qameta.allure.Step;
import static org.testng.Assert.assertEquals;


public class StepProduct extends BaseTest {
    private MethosProduct methosProduct = new MethosProduct();
    private SharedMethods sharedMethods = new SharedMethods();

    @Step("Select to client Real Estate")
    public StepProduct clickOnClientRealEstate() {
        methosProduct.clickOnClientRealEstate();
        return this;

    }
    @Step("Select to client Builder")
    public StepProduct clickOnClientBuilder() {
        methosProduct.clickOnClientBuilder();
        return this;

    }
    @Step("Select to client Agent")
    public StepProduct clickOnClientAgent() {
        methosProduct.clickOnClientAgent();
        return this;

    }
    @Step("Select to client Agent")
    public StepProduct clickOnSeePlan() {
        methosProduct.clickOnSeePlan();
        return this;

    }
    @Step("The client real estate buy plan por option see plans with user exits")
    public StepProduct fillFormNewAccountExistUser() {
       assertEquals(methosProduct.RealEstateSeePlanExistsUser(), services.getField("sanityExistsUser"));
        return this;

    }
    @Step("fill form new user success payment ")
    public StepProduct fillFormNewAccountSuccess() {
        assertEquals(methosProduct.NewUserPaymentSuccess(), services.getField(""));
        return this;

    }
    @Step("fill form new user fail payment ")
    public StepProduct fillFormNewAccountFailPayment() {
        assertEquals(methosProduct.NewUserPaymentDeclined(), services.getField(""));
        return this;

    }
    @Step("fill form new user pending payment ")
    public StepProduct fillFormNewAccountPendingPayment() {
        assertEquals(methosProduct.NewUserPaymentPending(), services.getField(""));
        return this;

    }
    @Step("fill form car for pay succesr ")
    public StepProduct paymentSuccess() {
        assertEquals(sharedMethods.paymentSuccess(), services.getField("sanityPaySuccess"));
        return this;

    }
    @Step("fill form car for pay succesr ")
    public StepProduct paymentDeclined() {
        assertEquals(sharedMethods.paymentFail(), services.getField("sanityPaySuccess"));
        return this;

    }
    @Step("fill form car for pay succesr ")
    public StepProduct paymentPending() {
        assertEquals(sharedMethods.paymentPending(), services.getField("sanityPaySuccess"));
        return this;

    }

}
