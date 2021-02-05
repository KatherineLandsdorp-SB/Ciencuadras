package com.segurosbolivar.automation.tests.publishProperty;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Services;
import com.segurosbolivar.automation.tests.rent.MethodsRent;
import com.segurosbolivar.automation.tests.shared.SharedMethods;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class StepsPublishProperty extends BaseTest {

    private MethodsPublishProperty methodsPublishProperty = new MethodsPublishProperty();
    private SharedMethods sharemethods = new SharedMethods();

    @Step("The user clicks on the sale button in the home")
    public StepsPublishProperty clickButtonSaleHome() {
        sharemethods.clickOnButtonSaleHome();
        return this;

    }
    @Step("The user clicks on the offer button in the home")
    public StepsPublishProperty clickButtonOfferHome() {
        sharemethods.clickOnButtonOfferHome();
        return this;

    }

    @Step("The user clicks on the publish button in the home")
    public StepsPublishProperty clickPublish() throws InterruptedException {
        sharemethods.clickOnPublish();
        return this;

    }

    @Step("The user click on button publish yourself")
    public StepsPublishProperty clickPublishYourself() {
        sharemethods.clickOnPublishYourself();
        return this;
    }

    @Step("The user click on button basic plan")
    public StepsPublishProperty clickOnBasicPlan() {
        sharemethods.clickOnBasicPlan();
        return this;
    }

    @Step("The user click on button add to car for basic plan")
    public StepsPublishProperty clickOnAddToCar() {
        sharemethods.clickOnAddToCarBasicPlan();
        return this;
    }

    @Step("The user click on button add to car for outstanding plan")
    public StepsPublishProperty clickOnAddToCarOutstanding() {
        sharemethods.clickOnAddToCarOutstanding();
        return this;
    }

    @Step("validation enable step Accompaniment ")
    public StepsPublishProperty validateStepAccompaniment() {
        methodsPublishProperty.validateLabelAccompaniment();
        return this;
    }

    @Step("validation enable step choose plan")
    public StepsPublishProperty validateStepChoosePlan() {
        methodsPublishProperty.validateLabelChoosePlan();
        return this;
    }

    @Step("validation enable step publish")
    public StepsPublishProperty validateStepPublish() {
        methodsPublishProperty.validateLabelPublish();
        return this;
    }

    @Step("validation enable step pay")
    public StepsPublishProperty validateStepPay() {
        methodsPublishProperty.validateLabelPay();
        return this;
    }

    @Step("validation enable step one tracking")
    public StepsPublishProperty validateCheckDoneStepOneTracking() {
        methodsPublishProperty.validateCheckStepOneTracking();
        return this;
    }

    @Step("validation enable step two tracking")
    public StepsPublishProperty validateCheckDoneStepTwoTracking() {
        methodsPublishProperty.validateCheckStepTwoTracking();
        return this;
    }

    @Step("validation enable step three tracking")
    public StepsPublishProperty validateCheckDoneStepThreeTracking() {
        methodsPublishProperty.validateCheckStepThreeTracking();
        return this;
    }

    @Step("validation enable step four tracking")
    public StepsPublishProperty validateCheckDoneStepFourTracking() {
        methodsPublishProperty.validateCheckStepFourTracking();
        return this;
    }

    @Step("The user click on button back de tracking")
    public StepsPublishProperty clickOnButtonBackStepTracking() {
        methodsPublishProperty.clickOnButtonBackTracking();
        return this;
    }
    @Step("The user click on button back de tracking")
    public StepsPublishProperty clickOnButtonBackFomr() {
        methodsPublishProperty.clickBackForm();
        return this;
    }

    @Step("The user click on button back")
    public StepsPublishProperty clickOnButtonBack() {
        methodsPublishProperty.clickButtonBack();
        return this;
    }


    //Step form publications
    @Step("The user registered the rent value")
    public StepsPublishProperty registerValueRent() {
        methodsPublishProperty.registerRentValue();
        return this;
    }

    @Step("the user click on button publish sale")
    public StepsPublishProperty clickButtonPublishSale() {
        methodsPublishProperty.clickButtonSale();
        return this;
    }

    @Step("The user registered the price sale")
    public StepsPublishProperty registerPriceSale() {
        methodsPublishProperty.registerSalePrice();
        return this;
    }

    @Step("The user click on slider administration value")
    public StepsPublishProperty clickAdministrationValue() {
        methodsPublishProperty.clickSliderAdministrationValue();
        return this;
    }

    @Step("The user registered value Administration")
    public StepsPublishProperty registerValueAdministration() {
        sharemethods.registerValueAdministration();
        return this;
    }

    @Step("validation field value administration")
    public StepsPublishProperty validateMandatoryFieldValueAdministration() {
        assertEquals(methodsPublishProperty.validateMandatoryValueAdministration(), services.getField("sanityAlertValueAdmin"));
        return this;
    }

    @Step("The user registered the antiquity property")
    public StepsPublishProperty registerAntiquityProperty() {
        methodsPublishProperty.registerAntiquityProperty();
        return this;
    }

    @Step("The user registered the value area property")
    public StepsPublishProperty registerArea() {
        methodsPublishProperty.registerArea();
        return this;
    }

    @Step("The user registered description of property ")
    public StepsPublishProperty registerDescription() {
        methodsPublishProperty.registerDescriptionProperty();
        return this;
    }

    @Step("The user registered stratum property")
    public StepsPublishProperty registerStratumProperty() {
        methodsPublishProperty.registerStratum();
        return this;
    }

    @Step("The user registered the city property")
    public StepsPublishProperty registerCityProperty() throws InterruptedException {
        methodsPublishProperty.registerCityProperty();
        return this;
    }

    @Step("The user registered property distric")
    public StepsPublishProperty registerPropertyDistric() throws InterruptedException {
        methodsPublishProperty.registerDistric();
        return this;
    }

    @Step("The user registered the city adress")
    public StepsPublishProperty registerCityAdress() {
        methodsPublishProperty.registerAdress();
        return this;
    }
    @Step("The user registered the city adress")
    public StepsPublishProperty registerWrongCityAdress() {
        methodsPublishProperty.registerWrongAddress();
        return this;
    }

    @Step("The user confirm the city adress registered")
    public StepsPublishProperty confirmAdress() throws InterruptedException {
        methodsPublishProperty.confirmAdress();
        return this;
    }

    @Step("The user registered your email")
    public StepsPublishProperty regisStepsNewUserEmail() throws InterruptedException {
        methodsPublishProperty.registerEmailNewUser();
        return this;
    }
    @Step("The user registered email registered")
    public StepsPublishProperty regisStepsOldUserEmail() throws InterruptedException {
        methodsPublishProperty.registerEmailOldUser();
        return this;
    }

    @Step("The user registered typeDocument")
    public StepsPublishProperty registerTypeDocument() {
        methodsPublishProperty.registerTypeDocument();
        return this;
    }

    @Step("The user registered identification")
    public StepsPublishProperty registerIdentificationUser() {
        methodsPublishProperty.registerIdentificationNewUser();
        return this;
    }

    @Step("The user registered nameUser")
    public StepsPublishProperty registerNameUser() {
        methodsPublishProperty.registerNameNewUser();
        return this;
    }

    @Step("The user registered lastName")
    public StepsPublishProperty registerLastNameUser() {
        methodsPublishProperty.registerLastNameNewUser();
        return this;
    }

    @Step("registered phone new user")
    public StepsPublishProperty registerCellPhoneUser() {
        methodsPublishProperty.registerCellPhoneNewUser();
        return this;
    }

    @Step("The user registered password")
    public StepsPublishProperty registerPasswordUser() {
        methodsPublishProperty.registerPasswordNewUser();
        return this;
    }

    @Step("The user confirmed the password")
    public StepsPublishProperty registerConfirmPasswordUser() {
        methodsPublishProperty.registerConfirmPassword();
        return this;
    }
    @Step("The user confirmed the password")
    public StepsPublishProperty registerPasswordOldUser() {
        methodsPublishProperty.registerPasswordOldUser();
        return this;
    }

    @Step("The user click on button continue")
    public StepsPublishProperty clickOnButtonContinue() throws InterruptedException {
        methodsPublishProperty.clickOnButtonContinue();
        return this;
    }

    @Step("The user regitstered city whit coverage")
    public StepsPublishProperty registerCityCoverage() throws InterruptedException {
        methodsPublishProperty.registerCityCoverage();
        return this;
    }
    @Step("The user regitstered city whit coverage")
    public StepsPublishProperty registerCityOutCoverage() throws InterruptedException {
        methodsPublishProperty.registerCityOutCoverage();
        return this;
    }

    @Step("validation City withCoverage")
    public StepsPublishProperty validateCityCoverage() {
        assertEquals(methodsPublishProperty.validateTextConfirmCoverage(), services.getField("sanityCoverageCity"));
        return this;
    }

    @Step("validation city out coverage")
    public StepsPublishProperty validateCityOutCoverage() {
        assertEquals(methodsPublishProperty.validateTextOutCoverage(), services.getField("sanityOutCoverageCity"));
        return this;
    }

    @Step("The user click on button continue form validation city coverage")
    public StepsPublishProperty clickButtonContinueCityCoverage() throws InterruptedException {
        methodsPublishProperty.clickButtonContinueCoverage();
        return this;
    }

    @Step("the user click on button confirm coverage city")
    public StepsPublishProperty clickButtonConfirmCityCoverage() throws InterruptedException {
        methodsPublishProperty.clickButtonConfirmCoverageCity();
        return this;
    }

    @Step("validation text city without coverage")
    public StepsPublishProperty validateFormWithoutCity() {
        assertEquals(methodsPublishProperty.validateTexFormWithoutCity(), services.getField("sanityEmptyCity"));
        return this;
    }

    @Step("upload images")
    public StepsPublishProperty uploapFile() throws InterruptedException {
        methodsPublishProperty.uploadImage();
        return this;
    }

    @Step("user click on button continue windows add photo")
    public StepsPublishProperty clickButtonContinuePhoto() {
        methodsPublishProperty.clickOnButtonContinuePhoto();
        return this;
    }
}






