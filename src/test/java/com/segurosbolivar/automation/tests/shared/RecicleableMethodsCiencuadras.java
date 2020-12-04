package com.segurosbolivar.automation.tests.shared;

import com.segurosbolivar.automation.commons.helpers.DriverFacade;
import com.segurosbolivar.automation.elements.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RecicleableMethodsCiencuadras extends Elements {
    //protected DriverFacade webDriverFacade;

    public void clickOnPublish() {
        //webDriverFacade.waitForVisibilityOfElement(buttonHowToPublish);

        buttonHowToPublish.click();
    }

    public void clickOnPublishYourself() {
        webDriverFacade.waitForVisibilityOfElement(buttonPublishYourself);
        buttonPublishYourself.click();
    }

    public void clickOnBasicPlan() {
        webDriverFacade.waitForVisibilityOfElement(buttonBasicPlan);
        buttonBasicPlan.click();
    }

    public void clickOnAddToCar() {
        webDriverFacade.waitForVisibilityOfElement(buttonAddToCar);
        buttonAddToCar.click();
    }

    public void publishRealState() {
        driverFacade.waitForVisibilityOfElement(buttonRealState);
        if (buttonRealState.isEnabled()) {
            buttonRealState.click();
        }
    }


    public boolean WaitingForElement(By ByElemto, int intentos) throws InterruptedException {

        boolean ElementPresent = false;
        int Intentos = 0;

        while (Intentos < (intentos * 2) && !ElementPresent) {
            try {
                ElementPresent = driverW.findElement(ByElemto).isEnabled();
            } catch (Exception e) {
                System.out.println(ElementPresent + "  Not Present ");
                Intentos++;
                System.out.print("#Tried: " + Intentos);
                System.out.println(ElementPresent + " Not Present  ");

            }
        }

        if (ElementPresent) {
            Thread.sleep(1000);
            System.out.print("Successful Enable: ** :) **  ");
            //assertEquals(true, ElementPresent);
        } else {
            System.out.print("Enable Failed: ** :( **  ");
            System.out.print("No Se encontro el Elemento: ** :( ** : " + ByElemto);
            System.out.print("Nooooo Se encontro el Elemento: ** :) **  ");
            assertFalse(ElementPresent);

        }
        System.out.println(" ");
        return ElementPresent;
    }//***************end.. method waiting Element ***************//

    //Metod validation web element enable
    public boolean validationElementEnable(WebElement webElement) {
        boolean element = false;
        try {
            element = webElement.isEnabled();
            System.out.println("Is disponible");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        if (element) {
            System.out.println("Is disponible 2");
        } else {
            System.out.println(element + "  Not Present ");
        }
        return element;

    }


}
