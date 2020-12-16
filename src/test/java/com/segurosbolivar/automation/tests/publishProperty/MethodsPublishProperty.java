package com.segurosbolivar.automation.tests.publishProperty;

import com.segurosbolivar.automation.elements.Elements;
import com.segurosbolivar.automation.tests.shared.RecicleableMethodsCiencuadras;
import com.segurosbolivar.automation.utils.PropertyManager;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class MethodsPublishProperty extends Elements {

    RecicleableMethodsCiencuadras methodsRecicleables = new RecicleableMethodsCiencuadras();

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
        if(dynamicElement.size() != 0){
            System.out.println("Existe elemento");
            inputAdministrationValue.sendKeys(value);
        }else{//0, elemento no esta presente.
            System.out.println("Elemento no existe");
        }
    }
    public String validateMandatoryValueAdministration(){
        driverFacade.waitForVisibilityOfElement(alertValueAdministration);
        String present = alertValueAdministration.getText().replaceAll("[ó]", "o");
        return present;

    }


    public void validateNoEnableIValueAdministracion(String value) {
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
        inputLocation.sendKeys(value);
        Thread.sleep(3000);
        inputLocation.sendKeys(Keys.ARROW_DOWN);
        inputLocation.sendKeys(Keys.ENTER);
    }

    public void registerDistric(String value) throws InterruptedException {
        inputDistric.sendKeys(value);
        Thread.sleep(4000);
        inputDistric.sendKeys(Keys.ARROW_DOWN);
        inputDistric.sendKeys(Keys.ENTER);
        Thread.sleep(3000);

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
        // listCedula.click();
    }

    public void registerIdentificacionNewUser(String value) {
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
        driverFacade.waitForVisibilityOfElement(inputCityCoverage);
        inputCityCoverage.sendKeys(city);
        Thread.sleep(3000);
        inputCityCoverage.sendKeys(Keys.ARROW_DOWN);
        inputCityCoverage.sendKeys(Keys.ENTER);

    }
    public void clickButtonConfirmCoverageCity(){
        buttonCnfirmCoverage.click();
    }

    public void clickButtonContinueCoverage() {
        //driverFacade.awaitToFindElement(By.xpath("(//div/button[contains (text(), 'CONTINUAR')])[6]"));
        driverFacade.waitForVisibilityOfElement(buttonContinueCoverage);
        buttonContinueCoverage.click();


    }

    public String validateTextConfirmCoverage() {
        String present;
        driverFacade.waitForVisibilityOfElement(texConfirmedCity);
        methodsRecicleables.validationElementEnable(texConfirmedCity);
        present = texConfirmedCity.getText();
        String result = present.replaceAll("[-¡+.^:,]", "");
        return result;

    }

    public String validateTextOutCoverage() {
        driverFacade.waitForVisibilityOfElement(textOutCoverage);
        String present;
        // methodsRecicleables.validationElementEnable(textOutCoverage);
        present = textOutCoverage.getText();
        return present;
    }

}
