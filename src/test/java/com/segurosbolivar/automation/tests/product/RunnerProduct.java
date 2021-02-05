package com.segurosbolivar.automation.tests.product;

import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.tests.publishProperty.StepsPublishProperty;
import org.testng.annotations.Test;

public class RunnerProduct extends Hooks {
    ThreadLocal<StepProduct> steps= ThreadLocal.withInitial(StepProduct::new);

    @Test(priority = 1, groups = { "sanit"})
    public  void realEstateSeePlanExistingUser(){
        steps.get()
                .clickOnClientRealEstate()
                .fillFormNewAccountExistUser();
    }
    @Test(priority = 2, groups = { "sanity"})
    public  void realEstateSeePlanNewUserSuccessPay(){
        steps.get()
                .clickOnClientRealEstate()
                .clickOnSeePlan()
                .fillFormNewAccountSuccess()
                .paymentSuccess();
    }
    @Test(priority = 3, groups = { "sanit"})
    public  void agentSeePlanNewUserSuccessPay(){
        steps.get()
                .clickOnClientAgent()
                .clickOnSeePlan()
                .fillFormNewAccountSuccess()
                . paymentSuccess();
    }
    @Test(priority = 4, groups = { "sanity"})
    public  void builderSeePlanNewUserSuccessPay(){
        steps.get()
                .clickOnClientBuilder()
                .clickOnSeePlan()
                .fillFormNewAccountSuccess()
                . paymentSuccess();
    }
    @Test(priority = 5, groups = { "sanit"})
    public  void realEstateSeePlanNewUserFailPayment(){
        steps.get()
                .clickOnClientRealEstate()
                .clickOnSeePlan()
                .fillFormNewAccountFailPayment()
                .paymentDeclined();
    }
    @Test(priority = 6, groups = { "sanit"})
    public  void builderSeePlanNewUserFailPayment(){
        steps.get()
                .clickOnClientBuilder()
                .clickOnSeePlan()
                .fillFormNewAccountFailPayment()
                .paymentDeclined();
    }
    @Test(priority = 7, groups = { "sanit"})
    public  void AgentSeePlanNewUserFailPayment(){
        steps.get()
                .clickOnClientAgent()
                .clickOnSeePlan()
                .fillFormNewAccountFailPayment()
                .paymentDeclined();
    }
    @Test(priority = 8, groups = { "sanit"})
    public  void realEstateSeePlanNewUserPendingPayment(){
        steps.get()
                .clickOnClientRealEstate()
                .clickOnSeePlan()
                .fillFormNewAccountPendingPayment()
                .paymentPending();
    }
    @Test(priority = 9, groups = { "sanit"})
    public  void BuilderSeePlanNewUserPendingPayment(){
        steps.get()
                .clickOnClientBuilder()
                .clickOnSeePlan()
                .fillFormNewAccountPendingPayment()
                .paymentPending();
    }
    @Test(priority = 10, groups = { "sanit"})
    public  void agentSeePlanNewUserPendingPayment(){
        steps.get()
                .clickOnClientAgent()
                .clickOnSeePlan()
                .fillFormNewAccountPendingPayment()
                .paymentPending();
    }
    // validaciones form new user
    @Test(priority = 10, groups = { "sanit"})
    public void  validarformulario (){

    }

}
