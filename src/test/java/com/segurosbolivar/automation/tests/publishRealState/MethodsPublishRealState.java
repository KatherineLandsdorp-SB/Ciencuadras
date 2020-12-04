package com.segurosbolivar.automation.tests.publishRealState;

import com.segurosbolivar.automation.elements.Elements;
import com.segurosbolivar.automation.tests.shared.RecicleableMethodsCiencuadras;
import com.segurosbolivar.automation.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;
import java.util.regex.Matcher;

public class MethodsPublishRealState extends Elements {
    RecicleableMethodsCiencuadras methodsRecicleable= new RecicleableMethodsCiencuadras();

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

    public void registerCity(String city) {
        driverFacade.waitForVisibilityOfElement(inputCityReallSate);
        inputCityReallSate.sendKeys(city);
    }

    public void selectCity() {
        driverFacade.waitForVisibilityOfElement(selectCity);
        if (selectCity.isEnabled()){
            System.out.println("Esta disponible");
            driverFacade.waitForVisibilityOfElement(selectCity);
            selectCity.click();
        }else {
            driverFacade.waitForVisibilityOfElement(selectCity);
            selectCity.click();
            System.out.println("Encontrado en el intento 2");

        }           }

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

    public String validationElement() {
        driverFacade.waitForVisibilityOfElement(buttonUnderstood);
        String btn = buttonUnderstood.getText();
        System.out.println("texto encontrado" + btn);
        return buttonUnderstood.getText();
    }

    public void clickButtonUnderstood() {
        buttonUnderstood.click();
    }

    public String validationDataMandatory() {
        driverFacade.waitForVisibilityOfElement(buttonConfirm);
        String btn = buttonConfirm.getText();
        System.out.println("texto encontrado" + btn);
        return buttonConfirm.getText();
    }

}
