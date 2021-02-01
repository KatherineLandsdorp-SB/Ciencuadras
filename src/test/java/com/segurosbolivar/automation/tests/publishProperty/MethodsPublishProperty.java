package com.segurosbolivar.automation.tests.publishProperty;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.tests.shared.SharedMethods;
import com.segurosbolivar.automation.utils.PropertyManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;


public class MethodsPublishProperty extends BaseTest {
    private Methods methods = new Methods();
    private SharedMethods shared = new SharedMethods();


    public boolean validateLabelAccompaniment() {
        methods.waitingForElement("labelAccompaniment", 10);
        boolean present = methods.getEntity("labelAccompaniment").isDisplayed();
        System.out.println("entro aqui" + methods.getEntity("labelAccompaniment"));
        return present;
    }

    public boolean validateLabelChoosePlan() {
        methods.waitingForElement("labelChoosePlan", 10);
        boolean present = methods.validationElementDisplayed("labelChoosePlan");
        return present;
    }

    public boolean validateLabelPublish() {
        methods.waitingForElement("labelPublish", 10);
        boolean present = methods.validationElementDisplayed("labelPublish");
        return present;
    }

    public boolean validateLabelPay() {
        methods.waitingForElement("labelPay", 10);
        boolean present = methods.validationElementDisplayed("labelPay");
        return present;
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
        methods.doScrollDown(7,"divFormPublication");
        methods.clickElement("buttonBackTracking");
    }
    public void clickBackForm() {
        methods.clickElement("buttonBackTracking");
    }

    public void clickButtonBack() {
        methods.clickElement("buttonBack");
    }

    public void clickButtonSale() {
        methods.waitingForElement("buttonPublishSale", 10);
        methods.clickElement("buttonPublishSale");
    }

    public void registerRentValue() {
        methods.waitingForElement("inputValueRent",60);
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

    public void validateNoEnableIValueAdministration() {
        if (methods.validationElementEnable("inputAdministrationValue")) {
            methods.sendKeysText("inputAdministrationValue", services.getField("sanityValueAdmi"));
        } else {
            methods.validationElementSelected("sliderAdministration");
            System.out.println("El campos no esta disponible");
        }

    }

    public void registerAntiquityProperty() {
        methods.sendKeysText("inputAntiquity", services.getField("sanityAntiquity"));
    }

    public void registerArea() {
        methods.sendKeysText("inputArea", services.getField("sanityArea"));
        methods.doScrollDown(1,"divFormPublication");
    }

    public void registerDescriptionProperty() {
        methods.sendKeysText("inputDescription", services.getField("sanityDescription"));
    }

    public void registerStratum() {
        methods.clickElement("buttonStratum");
    }

    public void registerCityProperty() throws InterruptedException {
        methods.sendKeysText("inputCity", services.getField("sanityCity"));
        methods.pause(2);
        methods.keyDown("inputCity");
    }

    public void registerDistric() throws InterruptedException {
        methods.clickElement("inputDistric");
        methods.pause(3);
        methods.sendKeysText("inputDistric", services.getField("sanityDistric"));
        methods.waitingForElement("selectCity",120);
        methods.keyDown("inputDistric");
    }

    public void registerAdress() {
        methods.clickElement("inputDistric");
        methods.pause(4);
        methods.sendKeysText("inputAdress", services.getField("sanityAdress"));
    }
    public void registerWrongAddress() {
        methods.clickElement("inputDistric");
        methods.pause(4);
        methods.sendKeysText("inputAdress", services.getField("sanitywrongAddress"));
    }

    public void confirmAdress() throws InterruptedException {
        methods.clickElement("checkAdress");
        methods.pause(2);
    }

    public void registerEmailNewUser() throws InterruptedException {
        methods.sendKeysText("inputEmail", services.getField("sanityMailNewUser"));
        methods.pause(8);
    }

    public void registerEmailOldUser() throws InterruptedException {
        methods.sendKeysText("inputEmail", services.getField("sanityOldUser"));
        methods.pause(8);
        methods.doScrollDown(2,"divFormPublication");
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

    public void clickOnButtonContinue() throws InterruptedException {
        methods.waitingForElement("buttonContinue", 10);
        methods.clickElement("buttonContinue");
        methods.pause(8);
    }

    public String validateTexFormWithoutCity() {
        methods.waitingForElement("texNav", 10);
        String text = methods.getTextElement("texNav");
        return text;
    }

    public void registerCityCoverage() throws InterruptedException {
        methods.sendKeysText("inputCityCoverage", services.getField("sanityCityCoverage"));
        methods.pause(2);
        methods.keyDown("inputCityCoverage");
    }
    public void registerCityOutCoverage() throws InterruptedException {
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
        methods.pause(2);
        String text = methods.clearText("texConfirmedCity", "[-¡+.^:,]", "");
        return text;
    }

    public String validateTextOutCoverage() {
        methods.pause(2);
        String text = methods.getTextElement("textOutCoverage");
        return text;
    }

    public void clickOnButtonContinuePhoto() {
        methods.clickElement("buttonContinuePhoto");
    }

    public void uploadImage() throws InterruptedException{
        methods.doScrollUp(2,"divFormPublication");
        methods.uploadRemoteImage(0, 2, "inputImage");

    }


}
