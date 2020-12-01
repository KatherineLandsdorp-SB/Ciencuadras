package com.segurosbolivar.automation.tests.publishProperty;

import com.segurosbolivar.automation.elements.Elements;
import com.segurosbolivar.automation.utils.PropertyManager;


public class MethodsPublishProperty extends Elements {


    //Formulario publish yourselff
    public void fillAllFieldPublication() {
        //buttonTracking3.isDisplayed();
        // selectAparment.click();
       // webDriverFacade.waitForVisibilityOfElement(selectSale);
       // selectSale.click();
        webDriverFacade.waitForVisibilityOfElement(inputSalePrice);
        inputSalePrice.sendKeys(PropertyManager.getConfigValueByKey("salePrice"));
        webDriverFacade.waitForVisibilityOfElement(inputAntiquity);
        inputAntiquity.sendKeys(PropertyManager.getConfigValueByKey("antiquity"));
        inputDescription.sendKeys(PropertyManager.getConfigValueByKey("description"));
        buttonStratum.click();
/*
        inputArea.sendKeys(PropertyManager.getConfigValueByKey("area"));
        buttonAddBathroom.click();
        buttonAddRoom.click();
        buttonAddBathroom.click();
        buttonAddParking.click();
        buttonAddBalcony.click();
        buttonAddAscensor.click();
        buttonAddTerrace.click();
        buttonAddDeposits.click();
        inputCity.sendKeys(PropertyManager.getConfigValueByKey("city"));
        inputLocation.sendKeys((PropertyManager.getConfigValueByKey("location")));
        inputDistric.sendKeys(PropertyManager.getConfigValueByKey("distric"));
        inputAdress.sendKeys(PropertyManager.getConfigValueByKey("adress"));
        checkAdress.click();
        inputEmail.sendKeys(PropertyManager.getConfigValueByKey("email"));
        selectCC.click();
        inputIdentification.sendKeys(PropertyManager.getConfigValueByKey("identification"));
        inputName.sendKeys(PropertyManager.getConfigValueByKey("name"));
        inputLastName.sendKeys(PropertyManager.getConfigValueByKey("lastname"));
        inputCellPhone.sendKeys(PropertyManager.getConfigValueByKey("cellphone"));
        inputPassword.sendKeys(PropertyManager.getConfigValueByKey("passwordUser"));
        inputPasswordConfirm.sendKeys(PropertyManager.getConfigValueByKey("confirmpassword"));
        //buttonContinue.click();
*/
    }
}
