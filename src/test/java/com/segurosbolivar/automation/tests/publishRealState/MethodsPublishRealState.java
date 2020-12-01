package com.segurosbolivar.automation.tests.publishRealState;

import com.segurosbolivar.automation.elements.Elements;
import com.segurosbolivar.automation.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;
import java.util.regex.Matcher;

public class MethodsPublishRealState extends Elements {

    public String fillFieldsFormRealState() {
        inputNameRegister.sendKeys(PropertyManager.getConfigValueByKey("nameRealState"));
        inputMail.sendKeys(PropertyManager.getConfigValueByKey("emailRealState"));
        inputPhone.sendKeys(PropertyManager.getConfigValueByKey("phoneRealState"));
        inputCityReallSate.sendKeys(PropertyManager.getConfigValueByKey("cityRealState"));
        driverFacade.waitForVisibilityOfElement(selectCity);
        selectCity.click();
        radioButtonSale.click();
        buttonConfirm.click();
        //webDriverFacade.waitForVisibilityOfElement(textConfirmation);
        return textConfirmation.getText();


    }




}
