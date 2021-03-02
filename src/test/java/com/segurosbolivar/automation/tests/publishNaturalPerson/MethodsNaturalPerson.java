package com.segurosbolivar.automation.tests.publishNaturalPerson;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.tests.shared.SharedMethods;


public class MethodsNaturalPerson extends BaseTest {
    private Methods methods = new Methods();
    private SharedMethods shared = new SharedMethods();


    public boolean validateLabelAccompaniment() {
        methods.waitingForElement("labelAccompaniment", 10);
        return methods.getEntity("labelAccompaniment").isDisplayed();
    }

    public boolean validateLabelChoosePlan() {
        methods.waitingForElement("labelChoosePlan", 10);
        return methods.validationElementDisplayed("labelChoosePlan");
    }

    public boolean validateLabelPublish() {
        methods.waitingForElement("labelPublish", 10);
        return methods.validationElementDisplayed("labelPublish");
    }

    public boolean validateLabelPay() {
        methods.waitingForElement("labelPay", 10);
        return methods.validationElementDisplayed("labelPay");
    }

    public boolean validateCheckStepOneTracking() {
        methods.waitingForElement("checkDoneStepOne", 10);
        boolean present = methods.validationElementDisplayed("checkDoneStepOne");
        return present;
    }

    public boolean validateCheckStepTwoTracking() {
        methods.waitingForElement("checkDoneStepTwo", 10);
        boolean present = methods.validationElementDisplayed("checkDoneStepTwo");
        return present;
    }

    public boolean validateCheckStepThreeTracking() {
        methods.waitingForElement("checkDoneThree", 10);
        boolean present = methods.validationElementDisplayed("checkDoneThree");
        return present;
    }

    public boolean validateCheckStepFourTracking() {
        methods.waitingForElement("checkDoneStepFour", 10);
        boolean present = methods.validationElementDisplayed("checkDoneStepFour");
        return present;
    }

    public void clickOnButtonBackTracking() {
        methods.doScrollDown(7, "divFormPublication");
        methods.clickElement("buttonBackTracking");
    }

    public void clickBackForm() {
        methods.clickElement("buttonBackTracking");
    }

    public void clickButtonBack() {
        methods.waitingForElement("buttonBack", 120);
        methods.clickElement("buttonBack");
    }

    public void clickButtonSale() {
        methods.waitingForElement("buttonPublishSale", 10);
        methods.clickElement("buttonPublishSale");
    }

    public void registerRentValue() {
        methods.waitingForElement("inputValueRent", 60);
        methods.sendKeysText("inputValueRent", services.getField("sanityValueRent"));


    }

    public void registerSalePrice() {
        methods.waitingForElement("inputSalePrice", 60);
        methods.sendKeysText("inputSalePrice", services.getField("sanityValueSale"));

    }

    public void clickSliderAdministrationValue() {
        methods.clickElement("sliderAdministration");

    }

    public String validateMandatoryValueAdministration() {
        methods.waitingForElement("alertValueAdministration", 10);
        String text = methods.clearText("alertValueAdministration", "[ó]", "o");
        return text;
    }

    public void registerAdministration() {
        methods.sendKeysText("inputAdministrationValue", services.getField("sanityAdminValue"));


    }

    public void registerAntiquityProperty() {
        methods.sendKeysText("inputAntiquity", services.getField("sanityAntiquity"));
    }

    public void registerArea() {
        methods.sendKeysText("inputArea", services.getField("sanityArea"));
        //methods.doScrollDown(1, "divFormPublication");
    }

    public void registerDescriptionProperty() {
        methods.sendKeysText("inputDescription", services.getField("sanityDescription"));
    }

    public void registerStratum() {
        methods.clickElement("buttonStratum");
    }

    public void registerCityProperty() {
        methods.scrollToElement("formLocationProperty");
        methods.sendKeysText("inputCity", services.getField("sanityCity"));
        methods.pause(2);
        methods.keyDown("inputCity");
    }

    public void registerDistric() {
        methods.clickElement("inputDistric");
        methods.pause(3);
        methods.sendKeysText("inputDistric", services.getField("sanityDistric"));
        methods.keyDown("inputDistric");
        methods.waitingForElement("selectCity", 120);

    }

    public void registerAdress() {
        methods.clickElement("inputDistric");
        methods.pause(4);
        methods.sendKeysText("inputAdress", services.getField("sanityAdress"));
        methods.scrollToElement("inputAdress");
    }

    public void registerWrongAddress() {
        methods.clickElement("inputDistric");
        methods.pause(4);
        methods.sendKeysText("inputAdress", services.getField("sanitywrongAddress"));
    }

    public void confirmAdress() {

        try {
            methods.waitingForElement("checkLocationProperty", 20);
            System.out.println("No entro en el catch 1");
            methods.clickElement("checkLocationProperty");
            System.out.println("No entro en el catch 2");
            methods.pause(2);
        }catch (Exception e){
            methods.waitingForElement("checkLocationProperty", 40);
            System.out.println("Entro en el catch ");
            methods.scrollToElement("checkLocationProperty");
            System.out.println("Entro en el catch ");
            methods.clickElement("checkLocationProperty");
            methods.pause(2);
        }
    }

    public void registerEmailNewUser() {
        methods.sendKeysText("inputEmail", services.getField("sanityMailNewUser"));
        methods.pause(8);
    }

    public void registerEmailOldUser() {
        methods.sendKeysText("inputEmail", services.getField("sanityOldUser"));
        methods.pause(8);
        methods.doScrollDown(2, "divFormPublication");
    }

    public void registerTypeDocument() {
        methods.clickElement("listTypeDocument");
        methods.sendKeysEnter("listTypeDocument");
    }

    public void registerIdentificationNewUser() {
        methods.sendKeysText("inputIdentification", services.getField("sanityDniNewUser"));
    }

    public void registerNameNewUser() {
        methods.sendKeysText("inputName", services.getField("sanityNameUser"));
    }

    public void registerLastNameNewUser() {
        methods.sendKeysText("inputLastName", services.getField("sanityLastName"));

    }

    public void registerCellPhoneNewUser() {
        methods.sendKeysText("inputCellPhone", services.getField("sanityPhone"));
    }

    public void registerPasswordNewUser() {
        methods.sendKeysText("password", services.getField("sanityPassword"));
    }

    public void registerConfirmPassword() {
        methods.sendKeysText("inputPasswordConfirm", services.getField("sanityPassword"));
    }

    public void registerPasswordOldUser() {
        methods.sendKeysText("passwordOldUser", services.getField("sanityPassword"));
    }

    public void clickOnButtonContinue() {
        methods.waitingForElement("buttonContinue", 10);
        methods.clickElement("buttonContinue");
        methods.pause(8);
    }

    public String validateTexFormWithoutCity() {
        methods.waitingForElement("texNav", 120);
        String text = methods.getTextElement("texNav");
        return text;
    }

    public String registerCityCoverage() {
        methods.sendKeysText("inputCityCoverage", services.getField("sanityCityCoverage"));
        methods.pause(2);
        methods.keyDown("inputCityCoverage");
        clickButtonConfirmCoverageCity();
        methods.waitingForElement("texConfirmedCity", 120);
        return methods.clearText("texConfirmedCity", "[-¡+.^:,]", "");
    }

    public void registerCityOutCoverage()  {
        methods.sendKeysText("inputCityCoverage", services.getField("sanityOutCoverage"));
        methods.pause(2);
        methods.keyDown("inputCityCoverage");
    }

    public void clickButtonConfirmCoverageCity() {
        methods.clickElement("buttonCnfirmCoverage");

    }

    public void clickButtonContinueCoverage() {
        methods.waitingForElement("buttonContinueCoverage", 120);
        methods.clickElement("buttonContinueCoverage");

    }

    public String validateTextConfirmCoverage() {
        methods.waitingForElement("texConfirmedCity", 120);
        String text = methods.clearText("texConfirmedCity", "[-¡+.^:,]", "");
        return text;
    }

    public String validateCityOutCoverage() {
        methods.waitingForElement("textOutCoverage", 120);
        String text = methods.getTextElement("textOutCoverage");
        return text;
    }

    public void clickOnButtonContinuePhoto() {
        methods.clickElement("buttonContinuePhoto");
    }

    public void uploadImage()  {
        methods.doScrollUp(2, "divFormPublication");
        methods.uploadRemoteImage(0, 2, "inputImage");

    }

    public void clickOnBtnReturnCommerce() {
        methods.clickElement("btnReturnCommerce");
    }
    public Boolean validateButtonGoPublication(){
        return methods.validationElementEnable("goPublications");
    }
    public Boolean validateButtonAddInformation(){
        return methods.validationElementEnable("addInformation");
    }
    public String clickOnButtonGoPublication(){
        methods.clickElement("goPublications");
        return "";
    }
    public String clickOnButtonAddInformation(){
        methods.clickElement("addInformation");
        return "";
    }

    public String registerUserEndFormPublishNaturalPerson() {
        registerRentValue();
        registerAdministration();
        registerAntiquityProperty();
        registerDescriptionProperty();
        registerStratum();
        registerArea();
        registerCityProperty();
        registerDistric();
        registerAdress();
        confirmAdress();
        registerEmailNewUser();
        registerTypeDocument();
        registerIdentificationNewUser();
        registerNameNewUser();
        registerLastNameNewUser();
        registerCellPhoneNewUser();
        registerPasswordNewUser();
        registerConfirmPassword();
        clickOnButtonContinue();
        methods.pause(10);
        methods.waitingForElement("navbarDropdown", 200);
        return methods.getTextElement("navbarDropdown");

    }

    public void publishRentNaturalPerson() {
        registerRentValue();
        registerAdministration();
        registerAntiquityProperty();
        registerDescriptionProperty();
        registerStratum();
        registerArea();
        registerCityProperty();
        registerDistric();
        registerAdress();
        confirmAdress();
        registerEmailOldUser();
        registerCellPhoneNewUser();
        registerPasswordOldUser();
        clickOnButtonContinue();

    }
    public String publishRentUserLoggedIn() {
        registerRentValue();
        registerAdministration();
        registerAntiquityProperty();
        registerDescriptionProperty();
        registerStratum();
        registerArea();
        registerCityProperty();
        registerDistric();
        registerAdress();
        confirmAdress();
        registerCellPhoneNewUser();
        clickOnButtonContinue();
        methods.pause(10);
        methods.waitingForElement("navbarDropdown", 200);
        return methods.getTextElement("navbarDropdown");

    }

    public void publishSaleNaturalPerson() {
        registerSalePrice();
        registerAdministration();
        registerAntiquityProperty();
        registerDescriptionProperty();
        registerStratum();
        registerArea();
        registerCityProperty();
        registerDistric();
        registerAdress();
        confirmAdress();
        registerEmailOldUser();
        registerCellPhoneNewUser();
        registerPasswordOldUser();
        clickOnButtonContinue();

    }

    public String publishWithoutAddress() {
        registerRentValue();
        registerAdministration();
        registerAntiquityProperty();
        registerDescriptionProperty();
        registerStratum();
        registerArea();
        registerDistric();
        registerAdress();
        confirmAdress();
        registerEmailOldUser();
        registerCellPhoneNewUser();
        registerPasswordOldUser();
        clickOnButtonContinue();
        methods.waitingForElement("texNav", 10);
        return methods.getTextElement("texNav");

    }

    public String publishWithWrongAddress() {
        registerRentValue();
        registerAdministration();
        registerAntiquityProperty();
        registerDescriptionProperty();
        registerStratum();
        registerArea();
        registerCityProperty();
        registerDistric();
        registerWrongAddress();
        confirmAdress();
        methods.waitingForElement("texNav", 10);
        return methods.getTextElement("texNav");

    }

    public String publishRentIncludeAdministration() {
        registerRentValue();
        clickSliderAdministrationValue();
        registerAntiquityProperty();
        registerDescriptionProperty();
        registerStratum();
        registerArea();
        registerCityProperty();
        registerDistric();
        registerAdress();
        confirmAdress();
        registerEmailOldUser();
        registerCellPhoneNewUser();
        registerPasswordOldUser();
        clickOnButtonContinue();
        methods.pause(10);
        methods.waitingForElement("navbarDropdown", 200);
        return methods.getTextElement("navbarDropdown");
    }

    public String publishRentWithOutAdministration() {
        registerRentValue();
        registerAntiquityProperty();
        registerDescriptionProperty();
        registerStratum();
        registerArea();
        registerCityProperty();
        registerDistric();
        registerAdress();
        confirmAdress();
        registerEmailOldUser();
        registerCellPhoneNewUser();
        registerPasswordOldUser();
        clickOnButtonContinue();
        methods.waitingForElement("alertValueAdministration", 10);
        methods.doScrollUp(4, "divFormPublication");
        return methods.clearText("alertValueAdministration", "[ó]", "o");

    }

    public String publishWithTracking() {
        validateLabelAccompaniment();
        shared.clickOnPublishYourself();
        validateCheckStepOneTracking();
        validateLabelChoosePlan();
        shared.clickOnAddToCarBasicPlan();
        validateCheckStepTwoTracking();
        validateLabelPublish();
        registerSalePrice();
        registerAdministration();
        registerAntiquityProperty();
        registerDescriptionProperty();
        registerStratum();
        registerArea();
        registerCityProperty();
        registerDistric();
        registerAdress();
        confirmAdress();
        registerEmailOldUser();
        registerCellPhoneNewUser();
        registerPasswordOldUser();
        clickOnButtonContinue();
        methods.pause(10);
        methods.waitingForElement("navbarDropdown", 200);
        return methods.getTextElement("navbarDropdown");

    }
    public String publishBackStep(){
        shared.clickOnPublishYourself();
        shared.clickOnAddToCarBasicPlan();
        clickOnButtonBackTracking();
        shared.clickOnAddToCarBasicPlan();
        registerRentValue();
        registerAdministration();
        registerAntiquityProperty();
        registerDescriptionProperty();
        registerStratum();
        registerArea();
        registerCityProperty();
        registerDistric();
        registerAdress();
        confirmAdress();
        registerEmailOldUser();
        registerCellPhoneNewUser();
        registerPasswordOldUser();
        clickOnButtonContinue();
        methods.pause(10);
        methods.waitingForElement("navbarDropdown", 200);
        return methods.getTextElement("navbarDropdown");


    }

}
