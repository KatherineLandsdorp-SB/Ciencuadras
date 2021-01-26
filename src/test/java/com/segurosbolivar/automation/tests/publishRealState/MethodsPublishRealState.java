package com.segurosbolivar.automation.tests.publishRealState;

import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.tests.shared.SharedMethods;

public class MethodsPublishRealState extends BaseTest {
   /* private Methods methods = new Methods();
    private SharedMethods shared = new SharedMethods();

    public void registerName() {
        methods.waitingForElement("inputNameRegister",110);
        methods.clickElement("inputNameRegister");
        methods.sendKeysText("inputNameRegister",services.getField("sanityNameRealState"));
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
        if (selectCity.isEnabled()) {
            System.out.println("Esta disponible");
            driverFacade.waitForVisibilityOfElement(selectCity);
            selectCity.click();
        } else {
            driverFacade.waitForVisibilityOfElement(selectCity);
            selectCity.click();
            System.out.println("Encontrado en el intento 2");

        }
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
        present = services.validationElementEnable(radioButtonSale);
        return present;

    }

    public boolean validateRadioButtonRent() {
        boolean present;
        present = services.validationElementEnable(radioButtonRent);
        return present;
    }

    public boolean validateRadioButtonRentSale() {
        boolean present;
        present = services.validationElementEnable(radioButtonRentSale);
        return present;
    }
*/
}
