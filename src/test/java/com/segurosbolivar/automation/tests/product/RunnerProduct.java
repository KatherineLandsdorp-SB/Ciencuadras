package com.segurosbolivar.automation.tests.product;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.annotations.Test;

public class RunnerProduct extends Hooks {
    ThreadLocal<StepProduct> steps = ThreadLocal.withInitial(StepProduct::new);

    @Test(priority = 1, groups = {"sanity"})
    public void realEstateSeePlanExistingUser() {
        steps.get()
                .clickOnButtonProduct()
                .clickOnClientRealEstate()
                .clickOnSeePlan()
                .fillFormNewAccountExistUser();
    }

    //ver planes flujos esxitosos
    @Test(priority = 2, groups = {"sanity"})
    public void realEstateSeePlanNewUserSuccessPay() {
        steps.get()
                .clickOnButtonProduct()
                .clickOnClientRealEstate()
                .clickOnSeePlan()
                .seePlanFillFormNewAccountSuccess()
                .paymentSuccess()
                .returnCommerce()
                .goToAccount();
    }

    @Test(priority = 3, groups = {"sanity"})
    public void agentSeePlanNewUserSuccessPay() {
        steps.get()
                .clickOnButtonProduct()
                .clickOnClientAgent()
                .clickOnSeePlan()
                .seePlanFillFormNewAccountSuccess()
                .paymentSuccess()
                .returnCommerce()
                .goToAccount();
    }

    @Test(priority = 4, groups = {"sanity"})
    public void builderSeePlanNewUserSuccessPay() {
        steps.get()
                .clickOnButtonProduct()
                .clickOnClientBuilder()
                .clickOnSeePlan()
                .seePlanFillFormNewAccountSuccess()
                .paymentSuccess()
                .returnCommerce()
                .goToAccount();

    }
//flujos fallido ver planes

    @Test(priority = 5, groups = {"sanity"})
    public void realEstateSeePlanNewUserFailPayment() {
        steps.get()
                .clickOnButtonProduct()
                .clickOnClientRealEstate()
                .clickOnSeePlan()
                .seePlanFillFormNewAccountSuccess()
                .paymentDeclined()
                .retryPayment();
    }

    @Test(priority = 6, groups = {"sanity"})
    public void builderSeePlanNewUserFailPayment() {
        steps.get()
                .clickOnButtonProduct()
                .clickOnClientBuilder()
                .clickOnSeePlan()
                .seePlanFillFormNewAccountSuccess()
                .paymentDeclined()
                .retryPayment();
    }

    @Test(priority = 7, groups = {"sanity"})
    public void AgentSeePlanNewUserFailPayment() {
        steps.get()
                .clickOnButtonProduct()
                .clickOnClientAgent()
                .clickOnSeePlan()
                .seePlanFillFormNewAccountSuccess()
                .paymentDeclined()
                .retryPayment();
    }

    // flujos pendientes ver planes
    @Test(priority = 8, groups = {"sanity"})
    public void realEstateSeePlanNewUserPendingPayment() {
        steps.get()
                .clickOnButtonProduct()
                .clickOnClientRealEstate()
                .clickOnSeePlan()
                .seePlanFillFormNewAccountSuccess()
                .paymentPending()
                .returnCommercePending();
    }

    @Test(priority = 9, groups = {"sanity"})
    public void BuilderSeePlanNewUserPendingPayment() {
        steps.get()
                .clickOnButtonProduct()
                .clickOnClientBuilder()
                .clickOnSeePlan()
                .seePlanFillFormNewAccountSuccess()
                .paymentPending()
                .returnCommercePending();
    }

    @Test(priority = 10, groups = {"sanity"})
    public void agentSeePlanNewUserPendingPayment() {
        steps.get()
                .clickOnButtonProduct()
                .clickOnClientAgent()
                .clickOnSeePlan()
                .seePlanFillFormNewAccountSuccess()
                .paymentPending()
                .returnCommercePending();
    }

    // flujo exitoso arma tu plan
    @Test(priority = 11, groups = {"sanity"})
    public void realEstateMakePlanNewUserSuccessPayment() {
        steps.get()
                .clickOnButtonProduct()
                .clickOnClientRealEstate()
                .clickOnSMakePlan()
                .makePlanFillFormNewAccountSuccess()
                .paymentSuccess()
                .returnCommerce()
                .goToAccount();

    }

    @Test(priority = 12, groups = {"sanity"})
    public void agentMakePlanNewUserSuccessPayment() {
        steps.get()
                .clickOnButtonProduct()
                .clickOnClientAgent()
                .clickOnSMakePlan()
                .makePlanFillFormNewAccountSuccess()
                .paymentSuccess()
                .returnCommerce()
                .goToAccount();

    }

    //flujo pendiente arma tu plan
    @Test(priority = 13, groups = {"sanity"})
    public void realEstateMakePlanNewUserSuccessPending() {
        steps.get()
                .clickOnButtonProduct()
                .clickOnClientRealEstate()
                .clickOnSMakePlan()
                .makePlanFillFormNewAccountSuccess()
                .paymentPending()
                .returnCommercePending();

    }

    @Test(priority = 14, groups = {"sanity"})
    public void agentMakePlanNewUserSuccessPending() {
        steps.get()
                .clickOnButtonProduct()
                .clickOnClientAgent()
                .clickOnSMakePlan()
                .makePlanFillFormNewAccountSuccess()
                .paymentPending()
                .returnCommercePending();

    }

    //flujo rechazado arma tu plan
    @Test(priority = 15, groups = {"sanity"})
    public void realEstateMakePlanNewUserFailPayment() {
        steps.get()
                .clickOnButtonProduct()
                .clickOnClientRealEstate()
                .clickOnSMakePlan()
                .makePlanFillFormNewAccountSuccess()
                .paymentDeclined()
                .retryPayment();
    }

    @Test(priority = 16, groups = {"sanity"})
    public void agentMakePlanNewUserFailPayment() {
        steps.get()
                .clickOnButtonProduct()
                .clickOnClientAgent()
                .clickOnSMakePlan()
                .makePlanFillFormNewAccountSuccess()
                .paymentDeclined()
                .retryPayment();
    }

}
