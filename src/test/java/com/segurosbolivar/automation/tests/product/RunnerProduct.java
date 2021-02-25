package com.segurosbolivar.automation.tests.product;


import com.segurosbolivar.automation.commons.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RunnerProduct extends Hooks {
    ThreadLocal<StepsProduct> steps = ThreadLocal.withInitial(StepsProduct::new);

    @Test(priority = 1)
    public void realEstateSeePlanExistingUser() {

        try {
            steps.get()
                    .clickOnButtonProduct()
                    .clickOnClientRealEstate()
                    .clickOnSeePlan()
                    .fillFormNewAccountExistUser();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }


    }

    //ver planes flujos esxitosos
    @Test(priority = 2)
    public void realEstateSeePlanNewUserSuccessPay() {

        try {
            steps.get()
                    .clickOnButtonProduct()
                    .clickOnClientRealEstate()
                    .clickOnSeePlan()
                    .seePlanFillFormNewAccountSuccess()
                    .paymentSuccess()
                    .returnCommerce()
                    .goToAccount();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }

    }

    @Test(priority = 3)
    public void agentSeePlanNewUserSuccessPay() {

        try {
            steps.get()
                    .clickOnButtonProduct()
                    .clickOnClientAgent()
                    .clickOnSeePlan()
                    .seePlanFillFormNewAccountSuccess()
                    .paymentSuccess()
                    .returnCommerce()
                    .goToAccount();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }


    }

    @Test(priority = 4)
    public void builderSeePlanNewUserSuccessPay() {

        try {
            steps.get()
                    .clickOnButtonProduct()
                    .clickOnClientBuilder()
                    .clickOnSeePlan()
                    .seePlanFillFormNewAccountSuccess()
                    .paymentSuccess()
                    .returnCommerce()
                    .goToAccount();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }


    }
//flujos fallido ver planes

    @Test(priority = 5)
    public void realEstateSeePlanNewUserFailPayment() {

        try {
            steps.get()
                    .clickOnButtonProduct()
                    .clickOnClientRealEstate()
                    .clickOnSeePlan()
                    .seePlanFillFormNewAccountSuccess()
                    .paymentDeclined()
                    .retryPayment();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }

    }

    @Test(priority = 6)
    public void builderSeePlanNewUserFailPayment() {

        try {
            steps.get()
                    .clickOnButtonProduct()
                    .clickOnClientBuilder()
                    .clickOnSeePlan()
                    .seePlanFillFormNewAccountSuccess()
                    .paymentDeclined()
                    .retryPayment();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }

    }

    @Test(priority = 7)
    public void AgentSeePlanNewUserFailPayment() {

        try {

            steps.get()
                    .clickOnButtonProduct()
                    .clickOnClientAgent()
                    .clickOnSeePlan()
                    .seePlanFillFormNewAccountSuccess()
                    .paymentDeclined()
                    .retryPayment();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }

    }

    // flujos pendientes ver planes
    @Test(priority = 8)
    public void realEstateSeePlanNewUserPendingPayment() {

        try {
            steps.get()
                    .clickOnButtonProduct()
                    .clickOnClientRealEstate()
                    .clickOnSeePlan()
                    .seePlanFillFormNewAccountSuccess()
                    .paymentPending()
                    .returnCommercePending();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }


    }

    @Test(priority = 9)
    public void BuilderSeePlanNewUserPendingPayment() {

        try {
            steps.get()
                    .clickOnButtonProduct()
                    .clickOnClientBuilder()
                    .clickOnSeePlan()
                    .seePlanFillFormNewAccountSuccess()
                    .paymentPending()
                    .returnCommercePending();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }
    }

    @Test(priority = 10)
    public void agentSeePlanNewUserPendingPayment() {

        try {
            steps.get()
                    .clickOnButtonProduct()
                    .clickOnClientAgent()
                    .clickOnSeePlan()
                    .seePlanFillFormNewAccountSuccess()
                    .paymentPending()
                    .returnCommercePending();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }

    }

    // flujo exitoso arma tu plan
    @Test(priority = 11)
    public void realEstateMakePlanNewUserSuccessPayment() {

        try {
            steps.get()
                    .clickOnButtonProduct()
                    .clickOnClientRealEstate()
                    .clickOnSMakePlan()
                    .makePlanFillFormNewAccountSuccess()
                    .paymentSuccess()
                    .returnCommerce()
                    .goToAccount();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }
    }

    @Test(priority = 12)
    public void agentMakePlanNewUserSuccessPayment() {
        try {
            steps.get()
                    .clickOnButtonProduct()
                    .clickOnClientAgent()
                    .clickOnSMakePlan()
                    .makePlanFillFormNewAccountSuccess()
                    .paymentSuccess()
                    .returnCommerce()
                    .goToAccount();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }


    }

    //flujo pendiente arma tu plan
    @Test(priority = 13)
    public void realEstateMakePlanNewUserSuccessPending() {

        try {

            steps.get()
                    .clickOnButtonProduct()
                    .clickOnClientRealEstate()
                    .clickOnSMakePlan()
                    .makePlanFillFormNewAccountSuccess()
                    .paymentPending()
                    .returnCommercePending();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }


    }

    @Test(priority = 14)
    public void agentMakePlanNewUserSuccessPending() {

        try {
            steps.get()
                    .clickOnButtonProduct()
                    .clickOnClientAgent()
                    .clickOnSMakePlan()
                    .makePlanFillFormNewAccountSuccess()
                    .paymentPending()
                    .returnCommercePending();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }
    }

    //flujo rechazado arma tu plan
    @Test(priority = 15)
    public void realEstateMakePlanNewUserFailPayment() {

        try {
            steps.get()
                    .clickOnButtonProduct()
                    .clickOnClientRealEstate()
                    .clickOnSMakePlan()
                    .makePlanFillFormNewAccountSuccess()
                    .paymentDeclined()
                    .retryPayment();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }

    }

    @Test(priority = 16)
    public void agentMakePlanNewUserFailPayment() {

        try {
            steps.get()
                    .clickOnButtonProduct()
                    .clickOnClientAgent()
                    .clickOnSMakePlan()
                    .makePlanFillFormNewAccountSuccess()
                    .paymentDeclined()
                    .retryPayment();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }

    }

}