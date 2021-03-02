package com.segurosbolivar.automation.tests.publishNaturalPerson;

import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.tests.login.StepsLogin;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class RunnerNaturalPerson extends Hooks {

    ThreadLocal<StepsNaturalPerson> steps = ThreadLocal.withInitial(StepsNaturalPerson::new);
    ThreadLocal<StepsLogin> step = ThreadLocal.withInitial(StepsLogin::new);

    @Test(priority = 1)
    //Siempre cambiar correo para este test
    public void publicarPlanDestacadoUsuarioNoLogueado() {
        steps.get().
                clickButtonOfferHome()
                .clickPublishYourself()
                .clickOnAddToCarOutstanding()
                .registerCityCoverage()
                .clickButtonContinueCityCoverage()
                .fillFormNewUser()
                .uploadFile();
        //pendiente dactapicker

    }


    @Test(priority = 2)
    public void publishPropertyUserLoggedInWithIdentification() {
        step.get().clickEntry()
                .clickLoginPerson()
                .fillAll();
        steps.get()
                .clickButtonOfferHome()
                .clickPublishYourself()
                .clickOnAddToCar()
                .fillFormRentUserLoggedIn()
                .uploadFile()
                .clickButtonContinuePhoto()
                .paymentSuccess();
    }


    @Test(priority = 3)
    public void publishPlanBasicUserNotLoggedIn() {
        steps.get()
                .clickButtonOfferHome()
                .clickPublishYourself()
                .clickOnAddToCar()
                .fillFormRent()
                .uploadFile()
                .clickButtonContinuePhoto()
                .paymentSuccess();

        //.clickButtonContinuePhoto(); pendiente validar datapicker

    }


    @Test(priority = 5)
    public void publishPropertyFormWithoutAddress() {
        steps.get()
                .clickButtonOfferHome()
                .clickPublishYourself()
                .clickOnAddToCar()
                .validateFormWithoutCity();
    }


    @Test(priority = 6)
    public void publishPropertyFormWithWrongAddress() {
        steps.get()
                .clickButtonOfferHome()
                .clickPublishYourself()
                .clickOnAddToCar()
                .validateFormWrongAddress();
    }

    @Test(priority = 7)
    public void publishPropertyForSaleBasicPlan() {
        steps.get()
                .clickButtonSaleHome()
                .clickPublishYourself()
                .clickOnAddToCar()
                .fillFormSale()
        ;
    }

    @Test(priority = 8)
    public void publishPropertyForSaleOutstandingPlan() {
        steps.get()
                .clickButtonSaleHome()
                .clickPublishYourself()
                .clickOnAddToCarOutstanding()
                .registerCityCoverage()
                .clickButtonContinueCityCoverage()
                .fillFormSale()
                .uploadFile()
                .filldate();
    }

    @Test(priority = 9)
    public void publishForRentOutstandingPlanValueAdministration() {
        steps.get()
                .clickButtonOfferHome()
                .clickPublishYourself()
                .clickOnAddToCarOutstanding()
                .registerCityCoverage()
                .clickButtonContinueCityCoverage()
                .publishRentWithAdministrationValue();
    }

    @Test(priority = 10)
    public void publishForRentBasicPlantWithoutValueAdministration() {
        steps.get()
                .clickButtonOfferHome()
                .clickPublishYourself()
                .clickOnAddToCar()
                .publishRentWithOutFieldAdministration();
    }

    @Test(priority = 12)
    public void validateCityWithCoverage() {
        steps.get()
                .clickButtonOfferHome()
                .clickPublishYourself()
                .clickOnAddToCarOutstanding()
                .registerCityCoverage();
    }

    @Test(priority = 13)
    public void validateCityOutCoverage() {
        steps.get()
                .clickButtonSaleHome()
                .clickPublishYourself()
                .clickOnAddToCarOutstanding()
                .validateCityOutCoverage();
    }

    @Test(priority = 14)
    public void validateViewAndCheckStepTracking() {
        steps.get()
                .clickButtonSaleHome()
                .validateSteps()
                .uploadFile()
                .clickButtonContinuePhoto()
                .paymentSuccess();
    }

    @Test(priority = 15)
    public void validateBackCheckSteps() {
        steps.get()
                .clickButtonOfferHome()
                .validateBackSteps()
                .uploadFile()
                .clickButtonContinuePhoto()
                .paymentSuccess()
                .returnCommerce();

    }


}
