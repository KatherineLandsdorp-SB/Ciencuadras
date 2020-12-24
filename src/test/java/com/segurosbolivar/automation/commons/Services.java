package com.segurosbolivar.automation.commons;

import com.segurosbolivar.automation.commons.helpers.DriverFactory;
import com.segurosbolivar.automation.utils.PropertyManager;
import org.awaitility.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertFalse;

public class Services extends BaseTest {
    WebDriverWait wait;

    /* ============================================================= */
    /* ====================== COMMONS ANGULAR ====================== */
    /* ============================================================= */

    public boolean WaitingForElement(WebElement webElement, int intentos) throws InterruptedException {

        By ByElement = toByVal(webElement);
        boolean ElementPresent = false;
        int Intentos = 0;

        while (Intentos < (intentos * 2) && !ElementPresent) {
            try {
                ElementPresent = webDriver.findElement(ByElement).isEnabled();
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
            System.out.print("No Se encontro el Elemento: ** :( ** : " + ByElement);
            System.out.print("Nooooo Se encontro el Elemento: ** :) **  ");
            assertFalse(ElementPresent);
        }
        System.out.println(" ");
        return ElementPresent;
    }

    //***************end.. method waiting Element ***************//

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

    public By toByVal(WebElement we) {
        // By format = "[foundFrom] -> locator: term"
        // see RemoteWebElement toString() implementation
        String[] data = we.toString().split(" -> ")[1].replace("]", "").split(": ");
        String locator = data[0];
        String term = data[1];

        switch (locator) {
            case "xpath":
                return By.xpath(term);
            case "css selector":
                return By.cssSelector(term);
            case "id":
                return By.id(term);
            case "tag name":
                return By.tagName(term);
            case "name":
                return By.name(term);
            case "link text":
                return By.linkText(term);
            case "class name":
                return By.className(term);
        }
        return (By) we;
    }


    public void waitForVisibilityOfElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }




    /* ============================================================= */
    /* =================== FIN COMMONS ANGULAR ===================== */
    /* ============================================================= */


    /* ============================================================= */
    /* ==================== ELEMENTOS ANGULAR ====================== */
    /* ============================================================= */

    // Select material angular
    public void AngularMaterialSelect(WebElement webElement, String search) {
        driverFacade.waitForVisibilityOfElement(webElement);
        cityAllied.click();
        cityAllied.sendKeys(search);
        //WebElement element = webDriver.findElement(By.xpath("//span[contains(text(),'"+search+"')]"));
        //driverFacade.waitForVisibilityOfElement(element);

        Select dropdown = new Select(webDriver.findElement(By.xpath("//span[contains(text(),'" + search + "')]")));
        dropdown.selectByVisibleText(search);
    }


    // Autocomplete material angular
    public void AngularMaterialAutocomplete(WebElement webElement, String search) {
        driverFacade.waitForVisibilityOfElement(webElement);
        cityAllied.click();
        cityAllied.sendKeys(search);
        Select dropdown = new Select(webDriver.findElement(By.xpath("//span[contains(text(),'" + search + "')]")));
        dropdown.selectByVisibleText(search);
    }

    /* ============================================================= */
    /* =================== FIN ELEMENTOS ANGULAR =================== */
    /* ============================================================= */
    //MODIFICACIONES SANDY

    /* ============================================================= */
    /* =================== Metodos seleccion ciudad =================== */
    /* ============================================================= */
    public void DropdownCity(WebElement webElement, String search) throws InterruptedException {
        webElement.sendKeys(search);
        Thread.sleep(4000);
        webElement.sendKeys(Keys.ARROW_DOWN);
        webElement.sendKeys(Keys.ENTER);
    }

    // revisar
    public void awaitToFindElement(WebElement webElement, int SECONDS) {
        By ByElement = toByVal(webElement);
        await().atMost(SECONDS, TimeUnit.SECONDS)
                .pollInterval(Duration.ONE_SECOND)
                .until(() -> {
                    try {
                        webDriver.findElements(ByElement);
                        System.out.println("ENTRO" + ByElement);
                        return true;
                    } catch (NoSuchElementException e) {
                        return false;
                    }
                });
    }


    public void uploadFile() throws InterruptedException{
       String path=System.getProperty("user.dir");
       System.getProperty("user.dir");
       System.out.println(path);
       inputImage.sendKeys(path+"/src/test/java/com/segurosbolivar/automation/commons/uploadFile/imagen.png");
        Thread.sleep(10000);
        inputImage.sendKeys(path+"/src/test/java/com/segurosbolivar/automation/commons/uploadFile/imagen.png");
        Thread.sleep(10000);
        inputImage.sendKeys(path+"/src/test/java/com/segurosbolivar/automation/commons/uploadFile/imagen.png");

    }


}
