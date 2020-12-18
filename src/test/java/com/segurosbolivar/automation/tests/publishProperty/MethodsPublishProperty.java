package com.segurosbolivar.automation.tests.publishProperty;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Services;
import com.segurosbolivar.automation.elements.Elements;
import com.segurosbolivar.automation.tests.shared.RecicleableMethodsCiencuadras;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;


public class MethodsPublishProperty extends BaseTest {

    RecicleableMethodsCiencuadras methodsRecicleables = new RecicleableMethodsCiencuadras();
    Services services = new Services();

    public boolean validateLabelAccompaniment() {
        driverFacade.waitForVisibilityOfElement(labelAccompaniment);
        boolean present = labelAccompaniment.isDisplayed();
        System.out.println("entro aqui" + labelAccompaniment);
        return present;
    }

    public boolean validateLabelChoosePlan() {
        driverFacade.waitForVisibilityOfElement(labelChoosePlan);
        boolean present = labelChoosePlan.isDisplayed();
        System.out.println("entro aqui" + labelChoosePlan);
        return present;
    }

    public boolean validateLabelPublish() {
        driverFacade.waitForVisibilityOfElement(labelPublish);
        boolean present = labelPublish.isDisplayed();
        System.out.println("entro aqui" + labelPublish);
        return present;
    }

    public boolean validateLabelPay() {
        driverFacade.waitForVisibilityOfElement(labelPay);
        boolean present = labelPay.isDisplayed();
        System.out.println("entro aqui" + labelPay);
        return present;
    }

    public boolean validateCheckStepOneTracking() {
        driverFacade.waitForVisibilityOfElement(checkDoneStepOne);
        boolean present = checkDoneStepOne.isDisplayed();
        System.out.println("entro aqui" + checkDoneStepOne);
        return present;
    }

    public boolean validateCheckStepTwoTracking() {
        driverFacade.waitForVisibilityOfElement(checkDoneStepTwo);
        boolean present = checkDoneStepTwo.isDisplayed();
        System.out.println("entro aqui" + checkDoneStepTwo);
        return present;
    }

    public boolean validateCheckStepThreeTracking() {
        driverFacade.waitForVisibilityOfElement(checkDoneThree);
        boolean present = checkDoneThree.isDisplayed();
        System.out.println("entro aqui" + checkDoneThree);
        return present;
    }

    public boolean validateCheckStepFourTracking() {
        driverFacade.waitForVisibilityOfElement(checkDoneStepFour);
        boolean present = checkDoneStepFour.isDisplayed();
        System.out.println("entro aqui" + checkDoneStepFour);
        return present;
    }

    public void clickOnButtonBackTracking() {
        driverFacade.waitForVisibilityOfElement(buttonBackTracking);
        buttonBackTracking.click();
        System.out.println("entro aqui" + buttonBackTracking);
    }

    public void clickButtonSale() {
        driverFacade.waitForVisibilityOfElement(buttonPublishSale);
        buttonPublishSale.click();
    }

    public void registerRentValue(String value) {
        inputValueRent.sendKeys(value);

    }

    public void registerSalePrice(String value) {
        webDriverFacade.waitForVisibilityOfElement(inputSalePrice);
        inputSalePrice.sendKeys(value);
    }

    public void clickSliderAdministrationValue() {
        sliderAdministration.click();
    }

    public void registerValueAdministration(String value) {
        List<WebElement> dynamicElement = driverFacade.getWebDriver().findElements(By.id("administrationValue"));
        if (dynamicElement.size() != 0) {
            System.out.println("Existe elemento");
            inputAdministrationValue.sendKeys(value);
        } else {//0, elemento no esta presente.
            System.out.println("Elemento no existe");
        }
    }

    public String validateMandatoryValueAdministration() {
        driverFacade.waitForVisibilityOfElement(alertValueAdministration);
        String present = alertValueAdministration.getText().replaceAll("[ó]", "o");
        return present;

    }


    public void validateNoEnableIValueAdministration(String value) {
        if (inputAdministrationValue.isEnabled()) {
            inputAdministrationValue.sendKeys(value);
        } else {
            sliderAdministration.isSelected();
            System.out.println("El campos no esta disponible");
        }

    }

    public void registerAntiquityProperty(String value) {
        webDriverFacade.waitForVisibilityOfElement(inputAntiquity);
        inputAntiquity.sendKeys(value);

    }

    public void registeArea(String area) {
        inputArea.sendKeys(area);
    }

    public void registerDescriptionProperty(String value) {
        inputDescription.sendKeys(value);

    }

    public void registerStratum() {
        buttonStratum.click();

    }

    public void registerCityProperty(String city) throws InterruptedException {
        inputCity.sendKeys(city);
        driverFacade.waitForVisibilityOfElement(selectCity);
        if (selectCity.isEnabled()) {
            driverFacade.waitForVisibilityOfElement(selectCity);
            selectCity.click();
        } else {
            driverFacade.waitForVisibilityOfElement(selectCity);
            selectCity.click();
        }
    }

    public void registerLocationProperty(String value) throws InterruptedException {
        services.DropdownCity(inputLocation,value);

    }

    public void registerDistric(String value) throws InterruptedException {
        services.DropdownCity(inputDistric,value);
        inputDistric.sendKeys(value);
    }

    public void registerAdress(String value) {
        inputAdress.click();
        inputAdress.sendKeys(value);
    }

    public void confirmAdress() throws InterruptedException {
        checkAdress.click();
        Thread.sleep(2000);
    }

    public void registerEmailNewUser(String email) throws InterruptedException {
        inputEmail.sendKeys(email);
        Thread.sleep(8000);
    }

    public void registerTypeDocument() {
        listTypeDocument.click();
        listTypeDocument.sendKeys(Keys.ENTER);
    }

    public void registerIdentificationNewUser(String value) {
        inputIdentification.sendKeys(value);
    }

    public void registerNameNewUser(String name) {
        inputName.sendKeys(name);
    }

    public void registerLastNameNewUser(String lastname) {
        inputLastName.sendKeys(lastname);
    }

    public void registerCellPhoneNewUser(String phone) {
        inputCellPhone.sendKeys(phone);
    }

    public void registerPasswordNewUser(String value) {
        inputPassword.sendKeys(value);
    }

    public void registerConfirmPassword(String value) {
        inputPasswordConfirm.sendKeys(value);
    }

    public void clickOnButtonContinue() {
        buttonContinue.click();
    }

    public String validateTexFormWithoutCity() {
        driverFacade.waitForVisibilityOfElement(texNav);
        String present;
        present = texNav.getText();
        return present;
    }

    public void registerCityCoverage(String city) throws InterruptedException {
        services.DropdownCity(inputCityCoverage,city);
    }

    public void clickButtonConfirmCoverageCity() {
        buttonCnfirmCoverage.click();
    }

    public void clickButtonContinueCoverage() {
        driverFacade.waitForVisibilityOfElement(buttonContinueCoverage);
        buttonContinueCoverage.click();
    }

    public String validateTextConfirmCoverage() {
        String present;
        driverFacade.waitForVisibilityOfElement(texConfirmedCity);
        present = texConfirmedCity.getText();
        String result = present.replaceAll("[-¡+.^:,]", "");
        return result;
    }

    public String validateTextOutCoverage() {
        driverFacade.waitForVisibilityOfElement(textOutCoverage);
        String present;
        present = textOutCoverage.getText();
        return present;
    }

}
