package com.segurosbolivar.automation.tests.publishNaturalPerson;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.tests.shared.SharedMethods;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class StepsNaturalPerson extends BaseTest {

    private MethodsNaturalPerson methodsNaturalPerson = new MethodsNaturalPerson();
    private SharedMethods sharemethods = new SharedMethods();

    @Step("The user clicks on the sale button in the home")
    public StepsNaturalPerson clickButtonSaleHome() {
        sharemethods.clickOnButtonSaleHome();
        return this;

    }
    @Step("The user clicks on the offer button in the home")
    public StepsNaturalPerson clickButtonOfferHome() {
        sharemethods.clickOnButtonOfferHome();
        return this;

    }

    @Step("The user clicks on the publish button in the home")
    public StepsNaturalPerson clickPublish() throws InterruptedException {
        sharemethods.clickOnPublish();
        return this;

    }

    @Step("The user click on button publish yourself")
    public StepsNaturalPerson clickPublishYourself() {
        sharemethods.clickOnPublishYourself();
        return this;
    }

    @Step("The user click on button basic plan")
    public StepsNaturalPerson clickOnBasicPlan() {
        sharemethods.clickOnBasicPlan();
        return this;
    }

    @Step("The user click on button add to car for basic plan")
    public StepsNaturalPerson clickOnAddToCar() {
        sharemethods.clickOnAddToCarBasicPlan();
        return this;
    }

    @Step("The user click on button add to car for outstanding plan")
    public StepsNaturalPerson clickOnAddToCarOutstanding() {
        sharemethods.clickOnAddToCarOutstanding();
        return this;
    }

    @Step("validation enable step Accompaniment ")
    public StepsNaturalPerson validateStepAccompaniment() {
        methodsNaturalPerson.validateLabelAccompaniment();
        return this;
    }

    @Step("validation enable step choose plan")
    public StepsNaturalPerson validateStepChoosePlan() {
        methodsNaturalPerson.validateLabelChoosePlan();
        return this;
    }

    @Step("validation enable step publish")
    public StepsNaturalPerson validateStepPublish() {
        methodsNaturalPerson.validateLabelPublish();
        return this;
    }

    @Step("validation enable step pay")
    public StepsNaturalPerson validateStepPay() {
        methodsNaturalPerson.validateLabelPay();
        return this;
    }

    @Step("validation enable step one tracking")
    public StepsNaturalPerson validateCheckDoneStepOneTracking() {
        methodsNaturalPerson.validateCheckStepOneTracking();
        return this;
    }

    @Step("validation enable step two tracking")
    public StepsNaturalPerson validateCheckDoneStepTwoTracking() {
        methodsNaturalPerson.validateCheckStepTwoTracking();
        return this;
    }

    @Step("validation enable step three tracking")
    public StepsNaturalPerson validateCheckDoneStepThreeTracking() {
        methodsNaturalPerson.validateCheckStepThreeTracking();
        return this;
    }

    @Step("validation enable step four tracking")
    public StepsNaturalPerson validateCheckDoneStepFourTracking() {
        methodsNaturalPerson.validateCheckStepFourTracking();
        return this;
    }

    @Step("The user click on button back de tracking")
    public StepsNaturalPerson clickOnButtonBackStepTracking() {
        methodsNaturalPerson.clickOnButtonBackTracking();
        return this;
    }
    @Step("The user click on button back de tracking")
    public StepsNaturalPerson clickOnButtonBackFomr() {
        methodsNaturalPerson.clickBackForm();
        return this;
    }

    @Step("The user click on button back")
    public StepsNaturalPerson clickOnButtonBack() {
        methodsNaturalPerson.clickButtonBack();
        return this;
    }


    //Step form publications
    @Step("The user registered the rent value")
    public StepsNaturalPerson registerValueRent() {
        methodsNaturalPerson.registerRentValue();
        return this;
    }

    @Step("the user click on button publish sale")
    public StepsNaturalPerson clickButtonPublishSale() {
        methodsNaturalPerson.clickButtonSale();
        return this;
    }

    @Step("The user registered the price sale")
    public StepsNaturalPerson registerPriceSale() {
        methodsNaturalPerson.registerSalePrice();
        return this;
    }

    @Step("The user click on slider administration value")
    public StepsNaturalPerson clickAdministrationValue() {
        methodsNaturalPerson.clickSliderAdministrationValue();
        return this;
    }

    @Step("The user registered value Administration")
    public StepsNaturalPerson registerValueAdministration() {
        sharemethods.registerValueAdministration();
        return this;
    }

    @Step("validation field value administration")
    public StepsNaturalPerson validateMandatoryFieldValueAdministration() {
        assertEquals(methodsNaturalPerson.validateMandatoryValueAdministration(), services.getField("sanityAlertValueAdmin"));
        return this;
    }

    @Step("The user registered the antiquity property")
    public StepsNaturalPerson registerAntiquityProperty() {
        methodsNaturalPerson.registerAntiquityProperty();
        return this;
    }

    @Step("The user registered the value area property")
    public StepsNaturalPerson registerArea() {
        methodsNaturalPerson.registerArea();
        return this;
    }

    @Step("The user registered description of property ")
    public StepsNaturalPerson registerDescription() {
        methodsNaturalPerson.registerDescriptionProperty();
        return this;
    }

    @Step("The user registered stratum property")
    public StepsNaturalPerson registerStratumProperty() {
        methodsNaturalPerson.registerStratum();
        return this;
    }

    @Step("The user registered the city property")
    public StepsNaturalPerson registerCityProperty() throws InterruptedException {
        methodsNaturalPerson.registerCityProperty();
        return this;
    }

    @Step("The user registered property distric")
    public StepsNaturalPerson registerPropertyDistric() throws InterruptedException {
        methodsNaturalPerson.registerDistric();
        return this;
    }

    @Step("The user registered the city adress")
    public StepsNaturalPerson registerCityAdress() {
        methodsNaturalPerson.registerAdress();
        return this;
    }
    @Step("The user registered the city adress")
    public StepsNaturalPerson registerWrongCityAdress() {
        methodsNaturalPerson.registerWrongAddress();
        return this;
    }

    @Step("The user confirm the city adress registered")
    public StepsNaturalPerson confirmAdress() throws InterruptedException {
        methodsNaturalPerson.confirmAdress();
        return this;
    }

    @Step("The user registered your email")
    public StepsNaturalPerson regisStepsNewUserEmail() throws InterruptedException {
        methodsNaturalPerson.registerEmailNewUser();
        return this;
    }
    @Step("The user registered email registered")
    public StepsNaturalPerson regisStepsOldUserEmail() throws InterruptedException {
        methodsNaturalPerson.registerEmailOldUser();
        return this;
    }

    @Step("The user registered typeDocument")
    public StepsNaturalPerson registerTypeDocument() {
        methodsNaturalPerson.registerTypeDocument();
        return this;
    }

    @Step("The user registered identification")
    public StepsNaturalPerson registerIdentificationUser() {
        methodsNaturalPerson.registerIdentificationNewUser();
        return this;
    }

    @Step("The user registered nameUser")
    public StepsNaturalPerson registerNameUser() {
        methodsNaturalPerson.registerNameNewUser();
        return this;
    }

    @Step("The user registered lastName")
    public StepsNaturalPerson registerLastNameUser() {
        methodsNaturalPerson.registerLastNameNewUser();
        return this;
    }

    @Step("registered phone new user")
    public StepsNaturalPerson registerCellPhoneUser() {
        methodsNaturalPerson.registerCellPhoneNewUser();
        return this;
    }

    @Step("The user registered password")
    public StepsNaturalPerson registerPasswordUser() {
        methodsNaturalPerson.registerPasswordNewUser();
        return this;
    }

    @Step("The user confirmed the password")
    public StepsNaturalPerson registerConfirmPasswordUser() {
        methodsNaturalPerson.registerConfirmPassword();
        return this;
    }
    @Step("The user confirmed the password")
    public StepsNaturalPerson registerPasswordOldUser() {
        methodsNaturalPerson.registerPasswordOldUser();
        return this;
    }

    @Step("The user click on button continue")
    public StepsNaturalPerson clickOnButtonContinue() throws InterruptedException {
        methodsNaturalPerson.clickOnButtonContinue();
        return this;
    }

    @Step("The user regitstered city whit coverage")
    public StepsNaturalPerson registerCityCoverage() throws InterruptedException {
        methodsNaturalPerson.registerCityCoverage();
        return this;
    }
    @Step("The user regitstered city whit coverage")
    public StepsNaturalPerson registerCityOutCoverage() throws InterruptedException {
        methodsNaturalPerson.registerCityOutCoverage();
        return this;
    }

    @Step("validation City withCoverage")
    public StepsNaturalPerson validateCityCoverage() {
        assertEquals(methodsNaturalPerson.validateTextConfirmCoverage(), services.getField("sanityCoverageCity"));
        return this;
    }

    @Step("validation city out coverage")
    public StepsNaturalPerson validateCityOutCoverage() {
        assertEquals(methodsNaturalPerson.validateTextOutCoverage(), services.getField("sanityOutCoverageCity"));
        return this;
    }

    @Step("The user click on button continue form validation city coverage")
    public StepsNaturalPerson clickButtonContinueCityCoverage() throws InterruptedException {
        methodsNaturalPerson.clickButtonContinueCoverage();
        return this;
    }

    @Step("the user click on button confirm coverage city")
    public StepsNaturalPerson clickButtonConfirmCityCoverage() throws InterruptedException {
        methodsNaturalPerson.clickButtonConfirmCoverageCity();
        return this;
    }

    @Step("validation text city without coverage")
    public StepsNaturalPerson validateFormWithoutCity() {
        assertEquals(methodsNaturalPerson.validateTexFormWithoutCity(), services.getField("sanityEmptyCity"));
        return this;
    }

    @Step("upload images")
    public StepsNaturalPerson uploapFile() throws InterruptedException {
        methodsNaturalPerson.uploadImage();
        return this;
    }

    @Step("user click on button continue windows add photo")
    public StepsNaturalPerson clickButtonContinuePhoto() {
        methodsNaturalPerson.clickOnButtonContinuePhoto();
        return this;
    }

    @Step("fill form car for pay succes ")
    public StepsNaturalPerson paymentSuccess() {
        assertEquals(sharemethods.paymentSuccess(), services.getField("sanityPaySuccess"));
        return this;

    }
    @Step("")
    public StepsNaturalPerson returnCommerce(){
        methodsNaturalPerson.clickOnBtnReturnCommerce();
        return this;
    }
}






