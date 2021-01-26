package com.segurosbolivar.automation.tests.publishProperty;

import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.tests.login.StepsLogin;
import org.testng.annotations.Test;

public class RunnerPublishProperty extends Hooks {

    ThreadLocal<StepsPublishProperty> steps = ThreadLocal.withInitial(StepsPublishProperty::new);
    ThreadLocal<StepsLogin> step = ThreadLocal.withInitial(StepsLogin::new);

    @Test(priority = 1)
    //Sienpre cambiar correo para este test
    public void publishPropertyRegisterUserEnd() throws InterruptedException {
        steps.get().clickButtonOfferHome();
        steps.get().clickPublishYourself();
        steps.get().clickOnBasicPlan();
        steps.get().clickOnAddToCar();
        steps.get().registerValueRent();
        steps.get().registerValueAdministration();
        steps.get().registerAntiquityProperty();
        steps.get().registerDescription();
        steps.get().registerStratumProperty();
        steps.get().registerArea();
        steps.get().registerCityProperty();
        steps.get().registerPropertyDistric();
        steps.get().registerCityAdress();
        steps.get().confirmAdress();
        steps.get().regisStepsNewUserEmail();
        steps.get().registerTypeDocument();
        steps.get().registerIdentificationUser();
        steps.get().registerNameUser();
        steps.get().registerLastNameUser();
        steps.get().registerCellPhoneUser();
        steps.get().registerPasswordUser();
        steps.get().registerConfirmPasswordUser();
        steps.get().clickOnButtonContinue();
        steps.get().uploapFile();
    }
  //revisar login

    @Test(priority = 2)
    public void publishPropertyUserLoggegInWithIdentification() throws InterruptedException {
        step.get().clickEntry().fillAll();
        steps.get().clickButtonOfferHome();
        steps.get().clickPublishYourself();
        steps.get().clickOnBasicPlan();
        steps.get().clickOnAddToCar();
        steps.get().registerValueRent();
        steps.get().registerValueAdministration();
        steps.get().registerAntiquityProperty();
        steps.get().registerDescription();
        steps.get().registerStratumProperty();
        steps.get().registerArea();
        steps.get().registerCityProperty();
        steps.get().registerPropertyDistric();
        steps.get().registerCityAdress();
        steps.get().confirmAdress();
        steps.get().registerCellPhoneUser();
        steps.get().clickOnButtonContinue();
        steps.get().uploapFile();
    }


    @Test(priority = 3)
    public void publishPropertyUserNotLoggedIn() throws InterruptedException {
        steps.get()
                .clickButtonOfferHome()
                .clickPublishYourself()
                .clickOnBasicPlan()
                .clickOnAddToCar()
                .registerValueRent()
                .registerValueAdministration()
                .registerAntiquityProperty()
                .registerDescription()
                .registerStratumProperty()
                .registerArea()
                .registerCityProperty()
                .registerPropertyDistric()
                .registerCityAdress()
                .confirmAdress()
                .regisStepsOldUserEmail()
                .registerCellPhoneUser()
                .registerPasswordOldUser()
                .clickOnButtonContinue();
                // steps.get().uploapFile();
                //.clickButtonContinuePhoto();

    }

    @Test(priority = 4)
    public void publishPropertyCityWithoutLocality() throws InterruptedException {
        steps.get()
                .clickButtonOfferHome()
                .clickPublishYourself()
                .clickOnBasicPlan()
                .clickOnAddToCar()
                .registerValueRent()
                .registerValueAdministration()
                .registerAntiquityProperty()
                .registerDescription()
                .registerStratumProperty()
                .registerArea()
                .registerCityProperty()
                .registerCityAdress()
                .confirmAdress()
                .regisStepsOldUserEmail()
                .registerCellPhoneUser()
                .registerPasswordOldUser()
                .clickOnButtonContinue();

    }

    @Test(priority = 5)
    public void publishPropertyFormWithoutAddress() throws InterruptedException {
        steps.get()
                .clickButtonOfferHome()
                .clickPublishYourself()
                .clickOnBasicPlan()
                .clickOnAddToCar()
                .registerValueRent()
                .registerValueAdministration()
                .registerAntiquityProperty()
                .registerDescription()
                .registerStratumProperty()
                .registerArea()
                .registerPropertyDistric()
                .registerCityAdress()
                .confirmAdress()
                .regisStepsOldUserEmail()
                .registerCellPhoneUser()
                .registerPasswordOldUser()
                .clickOnButtonContinue()
                .validateFormWithoutCity();
    }

    //Revisar una vez realicen ajuste de bug CCF-260
    @Test(priority = 6)
    public void publishPropertyFormWithWrongAddress() throws InterruptedException {
        steps.get()
                .clickButtonOfferHome()
                .clickPublishYourself()
                .clickOnBasicPlan()
                .clickOnAddToCar()
                .registerValueRent()
                .registerValueAdministration()
                .registerAntiquityProperty()
                .registerDescription()
                .registerStratumProperty()
                .registerArea()
                .registerCityProperty()
                .registerPropertyDistric()
                .registerWrongCityAdress()
                .confirmAdress()
                .validateFormWithoutCity();
    }

    @Test(priority = 7)
    public void publishPropertyForSaleBasicPlan() throws InterruptedException {
        steps.get()
                .clickButtonSaleHome()
                .clickPublishYourself()
                .clickOnBasicPlan()
                .clickOnAddToCar()
                .registerPriceSale()
                .registerAntiquityProperty()
                .registerDescription()
                .registerStratumProperty()
                .registerArea()
                .registerCityProperty()
                .registerPropertyDistric()
                .registerCityAdress()
                .confirmAdress()
                .regisStepsOldUserEmail()
                .registerCellPhoneUser()
                .registerPasswordOldUser()
                .clickOnButtonContinue();
        //.uploapFile();
    }

    @Test(priority = 8)
    public void publishPropertyForSaleFeaturedPlan() throws InterruptedException {
        steps.get()
                .clickButtonSaleHome()
                .clickPublishYourself()
                .clickOnAddToCarOutstanding()
                .registerCityCoverage()
                .clickButtonConfirmCityCoverage()
                .clickButtonContinueCityCoverage()
                .registerPriceSale()
                .registerValueAdministration()
                .registerAntiquityProperty()
                .registerDescription()
                .registerStratumProperty()
                .registerArea()
                .registerCityProperty()
                .registerPropertyDistric()
                .registerCityAdress()
                .confirmAdress()
                .regisStepsOldUserEmail()
                .registerCellPhoneUser()
                .registerPasswordOldUser()
                .clickOnButtonContinue();
        //.uploapFile();
    }

    @Test(priority = 9)
    public void publishForRenOustandingPlanHiddenValueAdministration() throws InterruptedException {
        steps.get()
                .clickButtonOfferHome()
                .clickPublishYourself()
                .clickOnAddToCarOutstanding()
                .registerCityCoverage()
                .clickButtonConfirmCityCoverage()
                .clickButtonContinueCityCoverage()
                .registerValueRent()
                .clickAdministrationValue()
                .registerValueAdministration();
    }

    @Test(priority = 10)
    public void publishForRenBasicPlantWithoutValueAdministration() throws InterruptedException {
        steps.get()
                .clickButtonOfferHome()
                .clickPublishYourself()
                .clickOnBasicPlan()
                .clickOnAddToCar()
                .registerValueRent()
                .registerAntiquityProperty()
                .registerDescription()
                .registerStratumProperty()
                .registerArea()
                .registerCityProperty()
                .registerPropertyDistric()
                .registerCityAdress()
                .confirmAdress()
                .regisStepsOldUserEmail()
                .registerCellPhoneUser()
                .registerPasswordOldUser()
                .clickOnButtonContinue()
                .validateMandatoryFieldValueAdministration();
    }

    @Test(priority = 12)
    public void validateCityWithCoverage() throws InterruptedException {
        steps.get()
                .clickButtonOfferHome()
                .clickPublishYourself()
                .clickOnAddToCarOutstanding()
                .registerCityCoverage()
                .clickButtonConfirmCityCoverage()
                .validateCityCoverage()
                .clickButtonContinueCityCoverage();
    }

    @Test(priority = 13)
    public void validateCityOutCoverage() throws InterruptedException {
        steps.get()
                .clickButtonSaleHome()
                .clickPublishYourself()
                .clickOnAddToCarOutstanding()
                .registerCityOutCoverage()
                .clickButtonConfirmCityCoverage()
                .validateCityOutCoverage();
    }

    @Test(priority = 14)
    public void validateViewAndCheckStepTracking() throws InterruptedException {
        steps.get()
                .clickButtonSaleHome()
                .validateStepAccompaniment()
                .clickPublishYourself()
                .validateCheckDoneStepOneTracking()
                .validateStepChoosePlan()
                .clickOnBasicPlan()
                .clickOnAddToCar()
                .validateCheckDoneStepTwoTracking()
                .validateStepPublish()
                .registerPriceSale()
                .registerAntiquityProperty()
                .registerDescription()
                .registerStratumProperty()
                .registerArea()
                .registerCityProperty()
                .registerPropertyDistric()
                .registerCityAdress()
                .confirmAdress()
                .regisStepsOldUserEmail()
                .registerCellPhoneUser()
                .registerPasswordOldUser()
                .clickOnButtonContinue();
    }

    @Test(priority = 11, groups = {"smoke"})
    public void validateBackCheckSteps() throws InterruptedException {
        steps.get()
                .clickButtonOfferHome()
                .clickPublishYourself()
                .clickOnBasicPlan()
                .clickOnAddToCar()
                .clickOnButtonBackStepTracking()
                .clickOnAddToCar()
                .validateStepPublish()
                .registerValueRent()
                .registerValueAdministration()
                .registerAntiquityProperty()
                .registerDescription()
                .registerStratumProperty()
                .registerArea()
                .registerCityProperty()
                .registerPropertyDistric()
                .registerCityAdress()
                .confirmAdress()
                .regisStepsOldUserEmail()
                .registerCellPhoneUser()
                .registerPasswordOldUser();
        //.clickOnButtonContinue();
        // Thread.sleep(10000);
        //steps.get().clickOnButtonBack()
        // steps.get().clickOnButtonBackFomr();
        // steps.get().uploapFile()*/
    }


}
