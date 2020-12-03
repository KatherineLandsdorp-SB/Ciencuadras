package com.segurosbolivar.automation.tests.publishRealState;

import com.segurosbolivar.automation.elements.Elements;
import com.segurosbolivar.automation.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;
import java.util.regex.Matcher;

import static org.junit.Assert.assertTrue;

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



    public boolean WaitingForElement(By ByElemto,int intentos) throws InterruptedException {
        By ElementoAENcontrar = ByElemto;
        boolean ElementPresent = false;
        int Intentos = 0;

        while (Intentos < (intentos * 2) && ElementPresent==false  ) {
            try {
                ElementPresent = driverW.findElement(ElementoAENcontrar).isEnabled();
            }
            catch (Exception e) {
                System.out.println(ElementPresent + "  Not Present ");
                Intentos ++;
                System.out.print("#Tried: "+Intentos);
                System.out.println(ElementPresent + " Not Present  ");

            }
        }

        if (ElementPresent == true) {

            Thread.sleep(1000);
            System.out.print("Successful Enable: ** :) **  ");
            //assertEquals(true, ElementPresent);

        }

        else
        {

            System.out.print("Enable Failed: ** :( **  ");
//            ExtentTestManagerAndroid.GetEvidenceExtendTestAndroid("Elemento no Encontrado: "+ElementoAENcontrar, driver);
            System.out.print("No Se encontro el Elemento: ** :( ** : " + ElementoAENcontrar);
            System.out.print("Nooooo Se encontro el Elemento: ** :) **  ");

            assertTrue(ElementPresent);

        }
        System.out.println(" ");
        return ElementPresent;
    }//***************end.. method waiting Element ***************//




}
