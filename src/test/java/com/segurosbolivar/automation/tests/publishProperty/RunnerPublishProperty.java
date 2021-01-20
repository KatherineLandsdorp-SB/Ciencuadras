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
        steps.get().clickPublish();
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
        steps.get().regisStepsUserEmail();
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


    @Test(priority = 2)
    public void publishPropertyUserLoggegInWithIdentification() throws InterruptedException {
        step.get().clickEntry().fillAll();
        steps.get().clickPublish();
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
        // steps.get().clickPublish();
        steps.get().clickButtonSaleHome();
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
        steps.get().regisStepsUserEmail();
        steps.get().registerCellPhoneUser();
        steps.get().registerPasswordUser();
        steps.get().clickOnButtonContinue();
        steps.get().uploapFile();
        //steps.get().uploapFile();
        steps.get().clickButtonContinuePhoto();

    }

    @Test(priority = 4)
    public void publishPropertyCityWithoutLocality() throws InterruptedException {
        steps.get().clickPublish();
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
        steps.get().registerCityAdress();
        steps.get().confirmAdress();
        steps.get().regisStepsUserEmail();
        steps.get().registerCellPhoneUser();
        steps.get().registerPasswordUser();
        steps.get().clickOnButtonContinue();

    }

    @Test(priority = 5)
    public void publishPropertyFormWithoutAddress() throws InterruptedException {
        steps.get().clickPublish();
        steps.get().clickPublishYourself();
        steps.get().clickOnBasicPlan();
        steps.get().clickOnAddToCar();
        steps.get().registerValueRent();
        steps.get().registerValueAdministration();
        steps.get().registerAntiquityProperty();
        steps.get().registerDescription();
        steps.get().registerStratumProperty();
        steps.get().registerArea();
        steps.get().registerPropertyDistric();
        steps.get().registerCityAdress();
        steps.get().confirmAdress();
        steps.get().regisStepsUserEmail();
        steps.get().registerCellPhoneUser();
        steps.get().registerPasswordUser();
        steps.get().clickOnButtonContinue();
        steps.get().validateFormWithoutCity();
    }

    @Test(priority = 6)
    public void publishPropertyFormWithWrongAddress() throws InterruptedException {
        steps.get().clickPublish();
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
        steps.get().validateFormWithoutCity();
    }

    @Test(priority = 7)
    public void publishPropertyForSaleBasicPlan() throws InterruptedException {
        steps.get().clickPublish();
        steps.get().clickPublishYourself();
        steps.get().clickOnBasicPlan();
        steps.get().clickOnAddToCar();
        steps.get().clickButtonPublishSale();
        steps.get().registerPriceSale();
        steps.get().registerAntiquityProperty();
        steps.get().registerDescription();
        steps.get().registerStratumProperty();
        steps.get().registerArea();
        steps.get().registerCityProperty();
        steps.get().registerPropertyDistric();
        steps.get().registerCityAdress();
        steps.get().confirmAdress();
        steps.get().regisStepsUserEmail();
        steps.get().registerCellPhoneUser();
        steps.get().registerPasswordUser();
        steps.get().clickOnButtonContinue();
        steps.get().uploapFile();
    }

    @Test(priority = 8)
    public void publishPropertyForSaleFeaturedPlan() throws InterruptedException {
        steps.get().clickPublish();
        steps.get().clickPublishYourself();
        steps.get().clickOnAddToCarOutstanding();
        steps.get().registerCityCoverage();
        steps.get().clickButtonConfirmCityCoverage();
        steps.get().clickButtonContinueCityCoverage();
        steps.get().clickButtonPublishSale();
        steps.get().registerPriceSale();
        steps.get().registerValueAdministration();
        steps.get().registerAntiquityProperty();
        steps.get().registerDescription();
        steps.get().registerStratumProperty();
        steps.get().registerArea();
        steps.get().registerCityProperty();
        steps.get().registerPropertyDistric();
        steps.get().registerCityAdress();
        steps.get().confirmAdress();
        steps.get().regisStepsUserEmail();
        steps.get().registerCellPhoneUser();
        steps.get().registerPasswordUser();
        steps.get().clickOnButtonContinue();
        steps.get().uploapFile();
    }

    @Test(priority = 9)
    public void publishForRenOustandingPlantHiddenValueAdministration() throws InterruptedException {
        steps.get().clickPublish();
        steps.get().clickPublishYourself();
        steps.get().clickOnAddToCarOutstanding();
        steps.get().registerCityCoverage();
        steps.get().clickButtonConfirmCityCoverage();
        steps.get().clickButtonContinueCityCoverage();
        steps.get().registerValueRent();
        steps.get().clickAdministrationValue();
        steps.get().registerValueAdministration();
    }

    @Test(priority = 10)
    public void publishForRenBasicPlantWithoutValueAdministration() throws InterruptedException {
        steps.get().clickPublish();
        steps.get().clickPublishYourself();
        steps.get().clickOnBasicPlan();
        steps.get().clickOnAddToCar();
        steps.get().registerValueRent();
        //steps.get().registerValueAdministration();
        steps.get().registerAntiquityProperty();
        steps.get().registerDescription();
        steps.get().registerStratumProperty();
        steps.get().registerArea();
        steps.get().registerCityProperty();
        steps.get().registerPropertyDistric();
        steps.get().registerCityAdress();
        steps.get().confirmAdress();
        steps.get().regisStepsUserEmail();
        steps.get().registerCellPhoneUser();
        steps.get().registerPasswordUser();
        steps.get().clickOnButtonContinue();
        steps.get().validateMandatoryFieldValueAdministration();
    }

    @Test(priority = 12)
    public void validateCityWithCoverage() throws InterruptedException {
        steps.get().clickPublish();
        steps.get().clickPublishYourself();
        steps.get().clickOnAddToCarOutstanding();
        steps.get().registerCityCoverage();
        steps.get().clickButtonConfirmCityCoverage();
        steps.get().validateCityCoverage();
        steps.get().clickButtonContinueCityCoverage();
    }

    @Test(priority = 13)
    public void validateCityOutCoverage() throws InterruptedException {
        steps.get().clickPublish();
        steps.get().clickPublishYourself();
        steps.get().clickOnAddToCarOutstanding();
        steps.get().registerCityCoverage();
        steps.get().clickButtonConfirmCityCoverage();
        steps.get().validateCityOutCoverage();
    }

    @Test(priority = 14)
    public void validateViewAndCheckStepTracking() throws InterruptedException {
        steps.get().clickPublish();
        steps.get().validateStepAccompaniment();
        steps.get().clickPublishYourself();
        steps.get().validateCheckDoneStepOneTracking();
        steps.get().validateStepChoosePlan();
        steps.get().clickOnBasicPlan();
        steps.get().clickOnAddToCar();
        steps.get().validateCheckDoneStepTwoTracking();
        steps.get().clickButtonPublishSale();
        steps.get().validateStepPublish();
        steps.get().registerPriceSale();
        steps.get().registerAntiquityProperty();
        steps.get().registerDescription();
        steps.get().registerStratumProperty();
        steps.get().registerArea();
        steps.get().registerCityProperty();
        steps.get().registerPropertyDistric();
        steps.get().registerCityAdress();
        steps.get().confirmAdress();
        steps.get().regisStepsUserEmail();
        steps.get().registerCellPhoneUser();
        steps.get().registerPasswordUser();
        steps.get().clickOnButtonContinue();
    }

    @Test(priority = 1, groups = {"smoke"})
    public void validateBackCheckSteps() throws InterruptedException {
        steps.get()
                .clickPublish()
                .clickPublishYourself()
                .clickOnBasicPlan()
                .clickOnAddToCar()
                .clickOnButtonBackStepTracking()
                .clickOnAddToCar()
                .validateStepPublish()
                .registerValueRent();
                /*.registerValueAdministration()
                .registerAntiquityProperty()
                .registerDescription()
                .registerStratumProperty()
                .registerArea()
                .registerCityProperty()
                .registerPropertyDistric()
                .registerCityAdress()
                .confirmAdress()
                .regisStepsUserEmail()
                .registerCellPhoneUser()
                .registerPasswordUser()
                .clickOnButtonContinue();
        Thread.sleep(10000);
        steps.get().clickOnButtonBack();
        steps.get().clickOnButtonBackStepTracking();
        // steps.get().uploapFile();
*/
    }


}
