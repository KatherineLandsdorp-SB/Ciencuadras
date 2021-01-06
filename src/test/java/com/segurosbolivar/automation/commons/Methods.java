package com.segurosbolivar.automation.commons;

import org.awaitility.Duration;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertFalse;

public class Methods extends BaseTest{
    WebDriverWait wait;
    private JSONObject field;
    private int iteration;

    /* ============================================================= */
    /* ====================== JSON     HANDLE ====================== */
    /* ============================================================= */

    //Buscar un elemento dada la entidad
    public WebElement getEntity(String entity){
        WebElement element = null;
        field = (JSONObject) driverFacade.JsonFile().get(entity);
        try {
            if(field != null){
                String typeObject = (String) field.get("GetFieldBy");
                switch (typeObject){
                    case "Xpath":
                        element = driverFacade.getWebDriver().findElement(By.xpath((String) field.get("ValueToFind")));
                        break;
                    case "Id":
                        element = driverFacade.getWebDriver().findElement(By.id((String) field.get("ValueToFind")));
                        break;
                    default:
                        element = null;
                }
                return element;

            }else{
                System.out.println("Item not found");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return element;
    }

    /* ============================================================= */
    /* ====================== JSON     HANDLE ====================== */
    /* ============================================================= */


    /* ============================================================= */
    /* ====================== COMMONS GLOBALES ====================== */
    /* ============================================================= */

    //Esperar un elemento con carga explicita
    public WebElement waitElementExplicitTime(String entity){
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driverFacade.getWebDriver(), 10);
        field = (JSONObject) driverFacade.JsonFile().get(entity);
        try {
            if(field != null){
                String typeObject = (String) field.get("GetFieldBy");
                System.out.println("elemento" + field.get("ValueToFind"));
                switch (typeObject){
                    case "Xpath":
                        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((String) field.get("ValueToFind"))));
                        break;
                    default:
                        element = null;
                }
                return element;

            }else{
                System.out.println("Item not found");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return element;
    }


    //Esperar elemento por iteraciones
    public  void waitingForElement(String entity, int iterations)  {

        WebElement element = null;
        field = (JSONObject) driverFacade.JsonFile().get(entity);
        if(field != null) {
            String typeObject = (String) field.get("GetFieldBy");

            try {
                boolean ElementPresent = false;
                iteration = 0;

                while (iteration < (iterations * 2) && !ElementPresent) {
                    try {

                        switch (typeObject){
                            case "Xpath":
                                ElementPresent = driverFacade.getWebDriver().findElement(By.xpath((String) field.get("ValueToFind"))).isEnabled();
                                break;
                            case "Id":
                                ElementPresent = driverFacade.getWebDriver().findElement(By.id((String) field.get("ValueToFind"))).isEnabled();
                                break;
                            default:
                                ElementPresent = false;
                        }

                    } catch (Exception e) {
                        iteration++;
                        System.out.print("#Tried: " + iteration);
                        System.out.println(ElementPresent + " Not Present  " + entity);
                    }
                }

                if (ElementPresent) {
                    Thread.sleep(1000);
                    System.out.print("Successful Enable: ** :) **  ");
                    //assertEquals(true, ElementPresent);
                } else {
                    System.out.print("Enable Failed: ** :( **  ");
                    System.out.print("No Se encontro el Elemento: ** :( ** : " + entity);
                    System.out.print("Nooooo Se encontro el Elemento: ** :) **  ");
                    assertFalse(ElementPresent);
                }
                System.out.println(" ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Item not found");
        }
    }


    //Esperar un elemento esperando n segundos
    public void awaitToFindElement(String entity, int seconds) {
        WebElement element = null;
        field = (JSONObject) driverFacade.JsonFile().get(entity);

        await().atMost(seconds, TimeUnit.SECONDS)
                .pollInterval(Duration.ONE_SECOND)
                .until(() -> {
                    try {
                        driverFacade.getWebDriver().findElement(By.xpath((String) field.get("ValueToFind")));
                        return true;
                    } catch (NoSuchElementException e) {
                        return false;
                    }
                });
    }


    //Validar si un elemento esta disponible
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


    public void waitForPageLoad() {
        Wait<WebDriver> wait = new WebDriverWait(driverFacade.getWebDriver(), 30);
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("Current Window State       : "
                        + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
        pause(6);
    }

    public String elementText(String text, String type){
        return "//"+type+"[text()='"+text+"']";
    }

    public WebElement xpathElement(String xpath){
        return driverFacade.getWebDriver().findElement(By.xpath(xpath));
    }

    public void clickElement(String entity){
        getEntity(entity).click();
    }
    //changeWindow
    public void changeWindow(){
        String originalWindow = driverFacade.getWebDriver().getWindowHandle();
        for (String windowHandle : driverFacade.getWebDriver().getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driverFacade.getWebDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    //waitTime
    public void pause(Integer seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Enviar texto
    public void sendKeysText(String entity, String text){
        getEntity(entity).click();
        getEntity(entity).clear();
        getEntity(entity).sendKeys(text);
    }
    /* ============================================================= */
    /* =================== FIN COMMONS GLOBALES ==================== */
    /* ============================================================= */



    /* ============================================================= */
    /* ==================== ELEMENTOS ANGULAR ====================== */
    /* ============================================================= */

    // Select material angular
    public void AngularMaterialSelect(WebElement webElement, String search) {
        driverFacade.waitForVisibilityOfElement(webElement);
        webElement.click();
        webElement.sendKeys(search);
        Select dropdown = new Select(driverFacade.getWebDriver().findElement(By.xpath("//span[contains(text(),'"+search+"')]")));
        dropdown.selectByVisibleText(search);
        //WebElement element = webDriver.findElement(By.xpath("//span[contains(text(),'"+search+"')]"));
        //driverFacade.waitForVisibilityOfElement(element);
    }

    // Autocomplete material angular
    public void AngularMaterialAutocomplete(String entity, String search) {
        waitingForElement(entity, 5);
        getEntity(entity).click();
        getEntity(entity).sendKeys(search);
        getEntity(entity).sendKeys(Keys.ARROW_DOWN);
        getEntity(entity).sendKeys(Keys.ENTER);
    }

    /* ============================================================= */
    /* =================== FIN ELEMENTOS ANGULAR =================== */
    /* ============================================================= */

}
