package com.segurosbolivar.automation.commons;

import org.awaitility.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertFalse;

public class Services extends BaseTest{
    WebDriverWait wait;

    /* ============================================================= */
    /* ====================== COMMONS ANGULAR ====================== */
    /* ============================================================= */
    public WebElement elementText(String text){
        return xpathElement("//span[text()='"+text+"']");
    }

    public WebElement xpathElement(String xpath){
        return webDriver.findElement(By.xpath(xpath));
    }

    //waitingElement
    public  void waitingForElement(WebElement webElement, int intentos)  {
        try {
            By ByElement = toByVal(webElement);
            boolean ElementPresent = false;
            int Intentos = 0;

            while (Intentos < (intentos * 2) && !ElementPresent) {
                try {
                    ElementPresent = driverFacade.getWebDriver().findElement(ByElement).isEnabled();
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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

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

    //WebElementToBy
    public By toByVal(WebElement we) {
        // By format = "[foundFrom] -> locator: term"
        // see RemoteWebElement toString() implementation
        String[] data = we.toString().split(" -> ")[1].replace("]", "").split(": ");
        String locator = data[0];
        String term = data[1];

        switch (locator) {
            case "xpath":
                String[] dataXpath = we.toString().split(" -> ")[1].replace("]]", "]").split(": ");
                String termXpath = dataXpath[1];
                return By.xpath(termXpath);
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

    //waitForVisibilityOfElement
    public void waitForVisibilityOfElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    //awaitToFindElement
    public void awaitToFindElement(WebElement webElement, int SECONDS) {
        By ByElement = toByVal(webElement);

        await().atMost(SECONDS, TimeUnit.SECONDS)
                .pollInterval(Duration.ONE_SECOND)
                .until(() -> {
                    try {
                        driverFacade.getWebDriver().findElement(ByElement);
                        return true;
                    } catch (NoSuchElementException e) {
                        return false;
                    }
                });
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
    /* ============================================================= */
    /* =================== FIN COMMONS ANGULAR ===================== */
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
    public void AngularMaterialAutocomplete(WebElement webElement, String search) {
        waitingForElement(webElement, 5);
        webElement.click();
        webElement.sendKeys(search);
        webElement.sendKeys(Keys.ARROW_DOWN);
        webElement.sendKeys(Keys.ENTER);
    }

    /* ============================================================= */
    /* =================== FIN ELEMENTOS ANGULAR =================== */
    /* ============================================================= */

}
