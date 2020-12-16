package com.segurosbolivar.automation.tests.shared;


import com.segurosbolivar.automation.commons.helpers.DriverFacade;
import com.segurosbolivar.automation.elements.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import static org.junit.Assert.assertFalse;

public class RecicleableMethodsCiencuadras extends Elements {


    public void clickOnPublish() {
        buttonPublishProperty.click();
    }

    public void clickOnKnowHowPublish() {
        buttonKnowPublish.click();
    }

    public void clickOnPublishYourself() {
        webDriverFacade.waitForVisibilityOfElement(buttonPublishYourself);

        if (buttonPublishYourself.isEnabled()) {
            System.out.println("Esta disponible");
            driverFacade.waitForVisibilityOfElement(buttonPublishYourself);
            buttonPublishYourself.click();
        } else {
            driverFacade.waitForVisibilityOfElement(buttonPublishYourself);
            buttonPublishYourself.click();
            System.out.println("Encontrado en el intento 2");

        }
    }


    public void clickOnBasicPlan() {
        webDriverFacade.waitForVisibilityOfElement(buttonBasicPlan);
        buttonBasicPlan.click();
    }

    public void clickOnAddToCarOutstanding() {

        webDriverFacade.waitForVisibilityOfElement(buttonAddToCar);
        if (buttonAddToCar.isEnabled()) {
            driverFacade.waitForVisibilityOfElement(buttonAddToCar);
            buttonAddToCar.click();

        } else {
            driverFacade.waitForVisibilityOfElement(buttonAddToCar);
            buttonAddToCar.click();
        }


    }

    public void clickOnAddToCarBasicPlan() {
        buttonBasicAddToCar.click();

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

    public void validarexistenciaElemento() {
        List<WebElement> dynamicElement = driverFacade.getWebDriver().findElements(By.xpath(""));

        if (dynamicElement.size() != 0) {
            System.out.println("Existe elemento");
        } else {//0, elemento no esta presente.
            System.out.println("Elemento no existe");
        }
    }

    public void keyDown(WebElement elemt) throws InterruptedException{
        Thread.sleep(3000);
        elemt.sendKeys(Keys.ARROW_DOWN);
        elemt.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }


}
