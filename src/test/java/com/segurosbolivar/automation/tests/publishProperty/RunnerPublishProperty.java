package com.segurosbolivar.automation.tests.publishProperty;

import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.tests.login.StepsLogin;
import com.segurosbolivar.automation.utils.PropertyManager;
import org.testng.annotations.Test;
import com.segurosbolivar.automation.tests.login.RunnerLogin;

public class RunnerPublishProperty extends Hooks {

    ThreadLocal<StepsPublishProperty> steps = ThreadLocal.withInitial(StepsPublishProperty::new);
    ThreadLocal<StepsLogin> step = ThreadLocal.withInitial(StepsLogin::new);


      /*@Test(priority=1)
        public void publishPropertyRegisterUserEnd() throws InterruptedException{
            steps.get().clickPublish();
            steps.get().clickPublishYourself();
            steps.get().clickOnBasicPlan();
            steps.get().clickOnAddToCar();
            steps.get().registerValueRent(PropertyManager.getConfigValueByKey("price"));
            steps.get().registerValueAdministration(PropertyManager.getConfigValueByKey("price"));
            steps.get().registerAntiquityProperty(PropertyManager.getConfigValueByKey("antiquity"));
            steps.get().registerDescription(PropertyManager.getConfigValueByKey("description"));
            steps.get().registerStratumProperty();
            steps.get().registerArea(PropertyManager.getConfigValueByKey("area"));
            steps.get().registerCityProperty(PropertyManager.getConfigValueByKey("city"));
            steps.get().registerLocationProperty(PropertyManager.getConfigValueByKey("location"));
            steps.get().registerPropertyDistric(PropertyManager.getConfigValueByKey("distric"));
            steps.get().registerCityAdress(PropertyManager.getConfigValueByKey("adress"));
            steps.get().confirmAdress();
            steps.get().regisStepsUserEmail(PropertyManager.getConfigValueByKey("emailNewUser"));
            steps.get().registerTypeDocument();
            steps.get().registerIdentificationUser(PropertyManager.getConfigValueByKey("identification"));
            steps.get().registerNameUser(PropertyManager.getConfigValueByKey("name"));
            steps.get().registerLastNameUser(PropertyManager.getConfigValueByKey("lastname"));
            steps.get().registerCellPhoneUser(PropertyManager.getConfigValueByKey("cellphone"));
            steps.get().registerPasswordUser(PropertyManager.getConfigValueByKey("passwordUser"));
            steps.get().registerConfirmPasswordUser(PropertyManager.getConfigValueByKey(("passwordUser")));
            //steps.get().clickOnButtonContinue();

        }

        @Test (priority=2)
        public void publishPropertyUserLoggegInWithIdentification() throws InterruptedException{
            //agregar metodo de login
            step.get().clickEntry().fillAll("PRUEBA AUTOMATION");
            steps.get().clickPublish();
            steps.get().clickPublishYourself();
            steps.get().clickOnBasicPlan();
            steps.get().clickOnAddToCar();
            steps.get().registerValueRent(PropertyManager.getConfigValueByKey("price"));
            steps.get().registerValueAdministration(PropertyManager.getConfigValueByKey("price"));
            steps.get().registerAntiquityProperty(PropertyManager.getConfigValueByKey("antiquity"));
            steps.get().registerDescription(PropertyManager.getConfigValueByKey("description"));
            steps.get().registerStratumProperty();
            steps.get().registerArea(PropertyManager.getConfigValueByKey("area"));
            steps.get().registerCityProperty(PropertyManager.getConfigValueByKey("city"));
            steps.get().registerLocationProperty(PropertyManager.getConfigValueByKey("location"));
            steps.get().registerPropertyDistric(PropertyManager.getConfigValueByKey("distric"));
            steps.get().registerCityAdress(PropertyManager.getConfigValueByKey("adress"));
            steps.get().confirmAdress();
            steps.get().regisStepsUserEmail(PropertyManager.getConfigValueByKey("emailUserRegister"));
            steps.get().registerCellPhoneUser(PropertyManager.getConfigValueByKey("cellphone"));
            steps.get().registerPasswordUser(PropertyManager.getConfigValueByKey("passwordUserRegister"));
            //steps.get().clickOnButtonContinue();

        }
        @Test (priority=3)
        public void publishPropertyUserNotLoggedIn() throws  InterruptedException{
            steps.get().clickPublish();
            steps.get().clickPublishYourself();
            steps.get().clickOnBasicPlan();
            steps.get().clickOnAddToCar();
            steps.get().registerValueRent(PropertyManager.getConfigValueByKey("price"));
            steps.get().registerValueAdministration(PropertyManager.getConfigValueByKey("price"));
            steps.get().registerAntiquityProperty(PropertyManager.getConfigValueByKey("antiquity"));
            steps.get().registerDescription(PropertyManager.getConfigValueByKey("description"));
            steps.get().registerStratumProperty();
            steps.get().registerArea(PropertyManager.getConfigValueByKey("area"));
            steps.get().registerCityProperty(PropertyManager.getConfigValueByKey("city"));
            steps.get().registerLocationProperty(PropertyManager.getConfigValueByKey("location"));
            steps.get().registerPropertyDistric(PropertyManager.getConfigValueByKey("distric"));
            steps.get().registerCityAdress(PropertyManager.getConfigValueByKey("adress"));
            steps.get().confirmAdress();
            steps.get().regisStepsUserEmail(PropertyManager.getConfigValueByKey("emailUserRegister"));
            steps.get().registerCellPhoneUser(PropertyManager.getConfigValueByKey("cellphone"));
            steps.get().registerPasswordUser(PropertyManager.getConfigValueByKey("passwordUserRegister"));
            steps.get().clickOnButtonContinue();

        }
        @Test (priority=4)
        public void publishPropertyCityWithoutLocality() throws InterruptedException{
            steps.get().clickPublish();
            steps.get().clickPublishYourself();
            steps.get().clickOnBasicPlan();
            steps.get().clickOnAddToCar();
            steps.get().registerValueRent(PropertyManager.getConfigValueByKey("price"));
            steps.get().registerValueAdministration(PropertyManager.getConfigValueByKey("price"));
            steps.get().registerAntiquityProperty(PropertyManager.getConfigValueByKey("antiquity"));
            steps.get().registerDescription(PropertyManager.getConfigValueByKey("description"));
            steps.get().registerStratumProperty();
            steps.get().registerArea(PropertyManager.getConfigValueByKey("area"));
            steps.get().registerCityProperty(PropertyManager.getConfigValueByKey("cityWihtOutLocation"));
            steps.get().registerCityAdress(PropertyManager.getConfigValueByKey("adressOutLocation"));
            steps.get().confirmAdress();
            steps.get().regisStepsUserEmail(PropertyManager.getConfigValueByKey("emailUserRegister"));
            steps.get().registerCellPhoneUser(PropertyManager.getConfigValueByKey("cellphone"));
            steps.get().registerPasswordUser(PropertyManager.getConfigValueByKey("passwordUserRegister"));
            steps.get().clickOnButtonContinue();

        }

        @Test (priority=5)
        public void publishPropertyFormWithoutAddress() throws InterruptedException{
            steps.get().clickPublish();
            steps.get().clickPublishYourself();
            steps.get().clickOnBasicPlan();
            steps.get().clickOnAddToCar();
            steps.get().registerValueRent(PropertyManager.getConfigValueByKey("price"));
            steps.get().registerValueAdministration(PropertyManager.getConfigValueByKey("price"));
            steps.get().registerAntiquityProperty(PropertyManager.getConfigValueByKey("antiquity"));
            steps.get().registerDescription(PropertyManager.getConfigValueByKey("description"));
            steps.get().registerStratumProperty();
            steps.get().registerArea(PropertyManager.getConfigValueByKey("area"));
            steps.get().registerLocationProperty(PropertyManager.getConfigValueByKey("location"));
            steps.get().registerPropertyDistric(PropertyManager.getConfigValueByKey("distric"));
            steps.get().registerCityAdress(PropertyManager.getConfigValueByKey("adress"));
            steps.get().confirmAdress();
            steps.get().regisStepsUserEmail(PropertyManager.getConfigValueByKey("emailUserRegister"));
            steps.get().registerCellPhoneUser(PropertyManager.getConfigValueByKey("cellphone"));
            steps.get().registerPasswordUser(PropertyManager.getConfigValueByKey("passwordUserRegister"));
            steps.get().clickOnButtonContinue();
            steps.get().validateFormWithoutCity(PropertyManager.getConfigValueByKey("textEmptyCity"));

        }


        @Test (priority=6)
        public  void publishPropertyFormWithWrongAddress() throws InterruptedException{
            steps.get().clickPublish();
            steps.get().clickPublishYourself();
            steps.get().clickOnBasicPlan();
            steps.get().clickOnAddToCar();
            steps.get().registerValueRent(PropertyManager.getConfigValueByKey("price"));
            steps.get().registerValueAdministration(PropertyManager.getConfigValueByKey("price"));
            steps.get().registerAntiquityProperty(PropertyManager.getConfigValueByKey("antiquity"));
            steps.get().registerDescription(PropertyManager.getConfigValueByKey("description"));
            steps.get().registerStratumProperty();
            steps.get().registerArea(PropertyManager.getConfigValueByKey("area"));
            steps.get().registerCityProperty(PropertyManager.getConfigValueByKey("wrongCity"));
            steps.get().registerLocationProperty(PropertyManager.getConfigValueByKey("wrongLocation"));
            steps.get().registerPropertyDistric(PropertyManager.getConfigValueByKey("wrongDistric"));
            steps.get().registerCityAdress(PropertyManager.getConfigValueByKey("wrongAdress"));
            steps.get().confirmAdress();
            steps.get().validateFormWithoutCity(PropertyManager.getConfigValueByKey("textEmptyCity"));
        }

        @Test (priority=7)
        public  void publishPropertyForSaleBasicPlan() throws  InterruptedException{
            steps.get().clickPublish();
            steps.get().clickPublishYourself();
            steps.get().clickOnBasicPlan();
            steps.get().clickOnAddToCar();
            steps.get().clickButtonPublishSale();
            steps.get().registerPriceSale(PropertyManager.getConfigValueByKey("priceSale"));
            steps.get().registerAntiquityProperty(PropertyManager.getConfigValueByKey("antiquity"));
            steps.get().registerDescription(PropertyManager.getConfigValueByKey("description"));
            steps.get().registerStratumProperty();
            steps.get().registerArea(PropertyManager.getConfigValueByKey("area"));
            steps.get().registerCityProperty(PropertyManager.getConfigValueByKey("city"));
            steps.get().registerLocationProperty(PropertyManager.getConfigValueByKey("location"));
            steps.get().registerPropertyDistric(PropertyManager.getConfigValueByKey("distric"));
            steps.get().registerCityAdress(PropertyManager.getConfigValueByKey("adress"));
            steps.get().confirmAdress();
            steps.get().regisStepsUserEmail(PropertyManager.getConfigValueByKey("emailUserRegister"));
            steps.get().registerCellPhoneUser(PropertyManager.getConfigValueByKey("cellphone"));
            steps.get().registerPasswordUser(PropertyManager.getConfigValueByKey("passwordUserRegister"));
            steps.get().clickOnButtonContinue();
        }
        @Test (priority=8)
        public  void publishPropertyForSaleFeaturedPlan()throws InterruptedException {
            steps.get().clickPublish();
            steps.get().clickPublishYourself();
            steps.get().clickOnAddToCarOutstanding();
            steps.get().registerCityCoverage(PropertyManager.getConfigValueByKey("city"));
            steps.get().clickButtonConfirmCityCoverage();
            steps.get().clickButtonContinueCityCoverage();
            steps.get().clickButtonPublishSale();
            steps.get().registerPriceSale(PropertyManager.getConfigValueByKey("priceSale"));
            steps.get().registerValueAdministration(PropertyManager.getConfigValueByKey("price"));
            steps.get().registerAntiquityProperty(PropertyManager.getConfigValueByKey("antiquity"));
            steps.get().registerDescription(PropertyManager.getConfigValueByKey("description"));
            steps.get().registerStratumProperty();
            steps.get().registerArea(PropertyManager.getConfigValueByKey("area"));
            steps.get().registerCityProperty(PropertyManager.getConfigValueByKey("city"));
            steps.get().registerLocationProperty(PropertyManager.getConfigValueByKey("location"));
            steps.get().registerPropertyDistric(PropertyManager.getConfigValueByKey("distric"));
            steps.get().registerCityAdress(PropertyManager.getConfigValueByKey("adress"));
            steps.get().confirmAdress();
            steps.get().regisStepsUserEmail(PropertyManager.getConfigValueByKey("emailUserRegister"));
            steps.get().registerCellPhoneUser(PropertyManager.getConfigValueByKey("cellphone"));
            steps.get().registerPasswordUser(PropertyManager.getConfigValueByKey("passwordUserRegister"));
            steps.get().clickOnButtonContinue();
        }

   @Test (priority=9)
    public void publishForRenOustandingPlantHiddenValueAdministration() throws InterruptedException{
        steps.get().clickPublish();
        steps.get().clickPublishYourself();
        steps.get().clickOnAddToCarOutstanding();
        steps.get().registerCityCoverage(PropertyManager.getConfigValueByKey("city"));
        steps.get().clickButtonConfirmCityCoverage();
        steps.get().clickButtonContinueCityCoverage();
        steps.get().registerValueRent(PropertyManager.getConfigValueByKey("price"));
        steps.get().clickAdministrationValue();
        steps.get().registerValueAdministration(PropertyManager.getConfigValueByKey("price"));
    }*/

    @Test(priority = 10)
    public void publishForRenBasicPlantWithoutValueAdministration() throws InterruptedException{
        steps.get().clickPublish();
        steps.get().clickPublishYourself();
        steps.get().clickOnBasicPlan();
        steps.get().clickOnAddToCar();
        steps.get().registerValueRent(PropertyManager.getConfigValueByKey("price"));
        //steps.get().registerValueAdministration(PropertyManager.getConfigValueByKey("price"));
        steps.get().registerAntiquityProperty(PropertyManager.getConfigValueByKey("antiquity"));
        steps.get().registerDescription(PropertyManager.getConfigValueByKey("description"));
        steps.get().registerStratumProperty();
        steps.get().registerArea(PropertyManager.getConfigValueByKey("area"));
        steps.get().registerCityProperty(PropertyManager.getConfigValueByKey("city"));
        steps.get().registerLocationProperty(PropertyManager.getConfigValueByKey("location"));
        steps.get().registerPropertyDistric(PropertyManager.getConfigValueByKey("distric"));
        steps.get().registerCityAdress(PropertyManager.getConfigValueByKey("adress"));
        steps.get().confirmAdress();
        steps.get().regisStepsUserEmail(PropertyManager.getConfigValueByKey("emailUserRegister"));
        steps.get().registerCellPhoneUser(PropertyManager.getConfigValueByKey("cellphone"));
        steps.get().registerPasswordUser(PropertyManager.getConfigValueByKey("passwordUserRegister"));
        steps.get().clickOnButtonContinue();
        steps.get().validateMandatoryFieldValueAdministration(PropertyManager.getConfigValueByKey("alertValueAdministration"));

    }
  /*  @Test (priority=12)
    public void validateCityWithCoverage() throws InterruptedException{
        steps.get().clickPublish();
        steps.get().clickPublishYourself();
        steps.get().clickOnAddToCarOutstanding();
        steps.get().registerCityCoverage(PropertyManager.getConfigValueByKey("city"));
        steps.get().clickButtonConfirmCityCoverage();
        steps.get().validateCityCoverage(PropertyManager.getConfigValueByKey("textCoverageCity"));
        steps.get().clickButtonContinueCityCoverage();
    }
    @Test(priority = 13)
    public  void  validationCityOutCoverage() throws  InterruptedException{
        steps.get().clickPublish();
        steps.get().clickPublishYourself();
        steps.get().clickOnAddToCarOutstanding();
        steps.get().registerCityCoverage(PropertyManager.getConfigValueByKey("cityOutCoverage"));
        steps.get().clickButtonConfirmCityCoverage();
        steps.get().validateCityOutCoverage(PropertyManager.getConfigValueByKey("textOutCoverageCity"));

    }
    @Test(priority = 14)
    public  void  validationViewStepTracking() throws  InterruptedException{


    }
    @Test(priority = 15)
    public  void  validationCheckSteps() throws  InterruptedException{


    }
    @Test(priority = 16)
    public  void  validationBackCheckSteps() throws  InterruptedException{


    }
*/


}
