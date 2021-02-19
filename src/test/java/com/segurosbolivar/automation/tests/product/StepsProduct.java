package com.segurosbolivar.automation.tests.product;


import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.tests.shared.SharedMethods;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class StepsProduct extends BaseTest {
    private MethodsProduct methodsProduct = new MethodsProduct();
    private SharedMethods sharedMethods = new SharedMethods();

    @Step("click on button product in the home")
    public StepsProduct clickOnButtonProduct() {
        assertEquals(methodsProduct.clickOnButtonProduct(), services.getField("sanityFrontProduct"));
        return this;

    }

    @Step("Select to client Real Estate")
    public StepsProduct clickOnClientRealEstate() {
        methodsProduct.clickOnClientRealEstate();
        assertTrue(methodsProduct.validateOptionSeePlan());
        assertTrue(methodsProduct.validationOptionsMakePlan());
        return this;

    }

    @Step("Select to client Builder")
    public StepsProduct clickOnClientBuilder() {
        methodsProduct.clickOnClientBuilder();
        assertTrue(methodsProduct.validateOptionSeePlan());
        return this;

    }

    @Step("Select to client Agent")
    public StepsProduct clickOnClientAgent() {
        methodsProduct.clickOnClientAgent();
        assertTrue(methodsProduct.validateOptionSeePlan());
        assertTrue(methodsProduct.validationOptionsMakePlan());
        return this;

    }

    @Step("Select to client Agent")
    public StepsProduct clickOnSeePlan() {
        assertTrue(methodsProduct.clickOnSeePlan());
        return this;

    }

    @Step("Select to client Agent")
    public StepsProduct clickOnSMakePlan() {
        assertTrue(methodsProduct.clickOnMakePlan());
        return this;

    }

    @Step("The client real estate buy plan por option see plans with user exits")
    public StepsProduct fillFormNewAccountExistUser() {
        assertEquals(methodsProduct.RealEstateSeePlanExistsUser(), services.getField("sanityExistsUser"));
        return this;

    }

    @Step("fill form new user success payment ")
    public StepsProduct seePlanFillFormNewAccountSuccess() {
        assertEquals(methodsProduct.seePlanNewUser(), services.getField("sanityCarText"));
        return this;

    }

    @Step("make plan fill form new user success payment ")
    public StepsProduct makePlanFillFormNewAccountSuccess() {
        assertEquals(methodsProduct.makePlanNewUser(), services.getField("sanityCarText"));
        return this;

    }

    @Step("fill form car for pay success ")
    public StepsProduct paymentSuccess() {
        assertEquals(sharedMethods.paymentSuccessProduct(), services.getField("sanityPaySuccess"));
        return this;

    }

    @Step("fill form car for pay fail ")
    public StepsProduct paymentDeclined() {
        assertEquals(sharedMethods.paymentFaiProduct(), services.getField("sanityPayFail"));
        assertEquals(sharedMethods.retryPay(), services.getField("sanityRetryPay"));
        return this;

    }

    @Step("fill form car for pay pending ")
    public StepsProduct paymentPending() {
        assertEquals(sharedMethods.paymentPendingProduct(), services.getField("sanityPayPending"));
        return this;

    }

    @Step("click on button return to commerce")
    public StepsProduct returnCommerce() {
        assertEquals(methodsProduct.clickOnBtnReturnCommerce(), services.getField("sanityFinalpaySuccess"));
        return this;
    }

    @Step("click on button return to commerce")
    public StepsProduct returnCommercePending() {
        assertEquals(methodsProduct.clickOnBtnReturnCommercePending(), services.getField("sanityFinalpayPending"));
        return this;
    }

    @Step("click on button return to commerce")
    public StepsProduct goToAccount() {
        assertTrue(methodsProduct.clickOnButtonGoAccount());
        return this;
    }

    @Step("click on button return retry payment")
    public StepsProduct retryPayment() {
        assertEquals(sharedMethods.clickOnButtonRetryPay(), services.getField("sanityPayMethod"));
        return this;
    }

}
