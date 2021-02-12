package com.segurosbolivar.automation.tests.product;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.tests.shared.SharedMethods;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class StepProduct extends BaseTest {
    private MethodsProduct methodsProduct = new MethodsProduct();
    private SharedMethods sharedMethods = new SharedMethods();

    @Step("click on button product in the home")
    public StepProduct clickOnButtonProduct() {
        assertEquals(methodsProduct.clickOnButtonProduct(), services.getField("sanityFrontProduct"));
        return this;

    }

    @Step("Select to client Real Estate")
    public StepProduct clickOnClientRealEstate() {
        methodsProduct.clickOnClientRealEstate();
        assertTrue(methodsProduct.validateOptionSeePlan());
        assertTrue(methodsProduct.validationOptionsMakePlan());
        return this;

    }

    @Step("Select to client Builder")
    public StepProduct clickOnClientBuilder() {
        methodsProduct.clickOnClientBuilder();
        assertTrue(methodsProduct.validateOptionSeePlan());
        return this;

    }

    @Step("Select to client Agent")
    public StepProduct clickOnClientAgent() {
        methodsProduct.clickOnClientAgent();
        assertTrue(methodsProduct.validateOptionSeePlan());
        assertTrue(methodsProduct.validationOptionsMakePlan());
        return this;

    }

    @Step("Select to client Agent")
    public StepProduct clickOnSeePlan() {
        assertTrue(methodsProduct.clickOnSeePlan());
        return this;

    }

    @Step("Select to client Agent")
    public StepProduct clickOnSMakePlan() {
        assertTrue(methodsProduct.clickOnMakePlan());
        return this;

    }

    @Step("The client real estate buy plan por option see plans with user exits")
    public StepProduct fillFormNewAccountExistUser() {
        assertEquals(methodsProduct.RealEstateSeePlanExistsUser(), services.getField("sanityExistsUser"));
        return this;

    }

    @Step("fill form new user success payment ")
    public StepProduct seePlanFillFormNewAccountSuccess() {
        assertEquals(methodsProduct.seePlanNewUser(), services.getField("sanityCarText"));
        return this;

    }

    @Step("make plan fill form new user success payment ")
    public StepProduct makePlanFillFormNewAccountSuccess() {
        assertEquals(methodsProduct.makePlanNewUser(), services.getField("sanityCarText"));
        return this;

    }

    @Step("fill form car for pay success ")
    public StepProduct paymentSuccess() {
        assertEquals(sharedMethods.paymentSuccessProduct(), services.getField("sanityPaySuccess"));
        return this;

    }

    @Step("fill form car for pay fail ")
    public StepProduct paymentDeclined() {
        assertEquals(sharedMethods.paymentFaiProduct(), services.getField("sanityPayFail"));
        assertEquals(sharedMethods.retryPay(), services.getField("sanityRetryPay"));
        return this;

    }

    @Step("fill form car for pay pending ")
    public StepProduct paymentPending() {
        assertEquals(sharedMethods.paymentPendingProduct(), services.getField("sanityPayPending"));
        return this;

    }

    @Step("click on button return to commerce")
    public StepProduct returnCommerce() {
        assertEquals(methodsProduct.clickOnBtnReturnCommerce(), services.getField("sanityFinalpaySuccess"));
        return this;
    }

    @Step("click on button return to commerce")
    public StepProduct returnCommercePending() {
        assertEquals(methodsProduct.clickOnBtnReturnCommercePending(), services.getField("sanityFinalpayPending"));
        return this;
    }

    @Step("click on button return to commerce")
    public StepProduct goToAccount() {
        assertTrue(methodsProduct.clickOnButtonGoAccount());
        return this;
    }

    @Step("click on button return retry payment")
    public StepProduct retryPayment() {
        assertEquals(sharedMethods.clickOnButtonRetryPay(), services.getField("sanityPayMethod"));
        return this;
    }

}
