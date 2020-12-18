package com.segurosbolivar.automation.tests.publishRealState;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Services;
import com.segurosbolivar.automation.elements.Elements;
import com.segurosbolivar.automation.tests.shared.RecicleableMethodsCiencuadras;
import com.segurosbolivar.automation.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;
import java.util.regex.Matcher;

public class MethodsPublishRealState extends BaseTest {
    RecicleableMethodsCiencuadras methodsRecicleable = new RecicleableMethodsCiencuadras();
    Services services = new Services();

    public void registerName(String name) {
        driverFacade.waitForVisibilityOfElement(inputNameRegister);
        inputNameRegister.click();
        inputNameRegister.sendKeys(name);
    }

    public void registerMail(String mail) {
        driverFacade.waitForVisibilityOfElement(inputMail);
        inputMail.sendKeys(mail);
    }

    public void registerPhone(String phone) {
        inputPhone.sendKeys(phone);
    }

    public void registerCity(String city) throws InterruptedException {
        services.DropdownCity(inputCityReallSate, city);

    }


    public void clickButtonSale() {
        driverFacade.waitForVisibilityOfElement(radioButtonSale);
        radioButtonSale.click();
    }

    public void clickButtonRent() {
        radioButtonRent.click();
    }

    public void clickRadioButtonRentSale() {
        radioButtonRentSale.click();
    }

    public void clickButtonConfirm() {
        buttonConfirm.click();
    }

    public String validateElement() {
        driverFacade.waitForVisibilityOfElement(buttonUnderstood);
        String btn = buttonUnderstood.getText();
        System.out.println("texto encontrado" + btn);
        return buttonUnderstood.getText();
    }

    public void clickButtonUnderstood() {

        buttonUnderstood.click();
    }

    public String validateDataMandatory() {
        driverFacade.waitForVisibilityOfElement(buttonConfirm);
        String btn = buttonConfirm.getText();
        System.out.println("texto encontrado" + btn);
        return buttonConfirm.getText();
    }


    public boolean validateRadioButtonSale() {
        boolean present;
        present = methodsRecicleable.validationElementEnable(radioButtonSale);
        return present;

    }

    public boolean validateRadioButtonRent() {
        boolean present;
        present = methodsRecicleable.validationElementEnable(radioButtonRent);
        return present;
    }

    public boolean validateRadioButtonRentSale() {
        boolean present;
        present = methodsRecicleable.validationElementEnable(radioButtonRentSale);
        return present;
    }

    public void clickOnCaptha() {
        captchaRealState.click();
    }

}
