package com.segurosbolivar.automation.tests.product;


import com.segurosbolivar.automation.commons.Hooks;
import org.testng.annotations.Test;

public class RunnerProduct extends Hooks {
    ThreadLocal<StepsProduct> steps = ThreadLocal.withInitial(StepsProduct::new);

    @Test(priority = 1)
    public void realEstateSeePlanExistingUser() {
        steps.get()
                .clickOnButtonProduct()
                .clickOnClientRealEstate()
                .clickOnSeePlan()
                .fillFormNewAccountExistUser();
    }

    //ver planes flujos esxitosos
    @Test(priority = 2)
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

    @Test(priority = 3)
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

    @Test(priority = 4)
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

    @Test(priority = 5)
    public void realEstateSeePlanNewUserFailPayment() {
        steps.get()
                .clickOnButtonProduct()
                .clickOnClientRealEstate()
                .clickOnSeePlan()
                .seePlanFillFormNewAccountSuccess()
                .paymentDeclined()
                .retryPayment();
    }

    @Test(priority = 6)
    public void builderSeePlanNewUserFailPayment() {
        steps.get()
                .clickOnButtonProduct()
                .clickOnClientBuilder()
                .clickOnSeePlan()
                .seePlanFillFormNewAccountSuccess()
                .paymentDeclined()
                .retryPayment();
    }

    @Test(priority = 7)
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
    @Test(priority = 8)
    public void realEstateSeePlanNewUserPendingPayment() {
        steps.get()
                .clickOnButtonProduct()
                .clickOnClientRealEstate()
                .clickOnSeePlan()
                .seePlanFillFormNewAccountSuccess()
                .paymentPending()
                .returnCommercePending();
    }

    @Test(priority = 9)
    public void BuilderSeePlanNewUserPendingPayment() {
        steps.get()
                .clickOnButtonProduct()
                .clickOnClientBuilder()
                .clickOnSeePlan()
                .seePlanFillFormNewAccountSuccess()
                .paymentPending()
                .returnCommercePending();
    }

    @Test(priority = 10)
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
    @Test(priority = 11)
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

    @Test(priority = 12)
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
    @Test(priority = 13)
    public void realEstateMakePlanNewUserSuccessPending() {
        steps.get()
                .clickOnButtonProduct()
                .clickOnClientRealEstate()
                .clickOnSMakePlan()
                .makePlanFillFormNewAccountSuccess()
                .paymentPending()
                .returnCommercePending();

    }

    @Test(priority = 14)
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
    @Test(priority = 15)
    public void realEstateMakePlanNewUserFailPayment() {
        steps.get()
                .clickOnButtonProduct()
                .clickOnClientRealEstate()
                .clickOnSMakePlan()
                .makePlanFillFormNewAccountSuccess()
                .paymentDeclined()
                .retryPayment();
    }

    @Test(priority = 16)
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