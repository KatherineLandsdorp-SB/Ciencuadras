package com.segurosbolivar.automation.commons.methods.mobile;

import com.segurosbolivar.automation.commons.helpers.driver.mobile.DriverMobileBase;
import com.segurosbolivar.automation.commons.utils.JsonParser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class MobileMethods {
    private final AppiumDriver<?> driver;
    private final JSONObject elements;

    public MobileMethods(JSONObject elements) {
        this.elements = elements;
        this.driver = DriverMobileBase.getCurrentDriver();
    }

    protected MobileElement getEntity(String entity) {
        MobileElement element = null;
        JSONObject field = JsonParser.toJSONObject(elements.get(entity));
        try {
            if (field != null) {
                String typeObject = (String) field.get("GetFieldBy");
                switch (typeObject) {
                    case "Xpath":
                        element = (MobileElement) driver.findElement(By.xpath((String) field.get("ValueToFind")));
                        break;
                    case "Id":
                        element = (MobileElement) driver.findElement(By.id((String) field.get("ValueToFind")));
                        break;
                    default:
                        element = null;
                }
                return element;

            } else {
                System.out.println("MobileMethods entity " + entity + " not found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * <b>waitElementExplicitTime</b>
     * <p>Método con instrucciones que realiza una espera inteligente condicionado a la aparición de un elemento en el DOM.</p>
     * <p>El entity puede estar dado con propiedades tales como ID, Nombre, Clase, XPath, Selectores CSS, Texto de enlace, etc.</p>
     * <p><b>Implementación</b></p>
     * <p><b>methods.waitElementExplicitTime("entity");</b></p>
     * @param entity Propiedad para buscar un elemento dentro del DOM de una página.
     * @return element - Encontrado en la búsqueda del DOM.
     */
    public MobileElement waitElementExplicitTime(String entity) throws Exception {
        MobileElement element = null;
        WebDriverWait wait = new WebDriverWait(DriverMobileBase.getDriver(), 10);
        JSONObject field = JsonParser.toJSONObject(elements.get(entity));
        try {
            if (field != null) {
                String typeObject = (String) field.get("GetFieldBy");
                //System.out.println("elemento" + field.get("ValueToFind"));
                switch (typeObject) {
                    case "Xpath":
                        element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((String) field.get("ValueToFind"))));
                        break;
                    default:
                        element = null;
                }
                return element;

            } else {
                System.out.println("Item not found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return element;
    }

    public void click(String entity) {
        MobileElement element = getEntity(entity);
        element.click();
    }

    public String getText(String entity) {
        MobileElement element = getEntity(entity);
        String text = element.getText();

        return text;
    }

    /**
     * <b>sendKeysText</b>
     * <p>Método con instrucciones para escribir texto sobre un campo de texto en una página web.</p>
     * <p>Hace referencia a simular un usuario real escribiendo texto en una página web.</p>
     * <p><b>Implementación</b></p>
     * <p><b>methods.sendKeysText("entity","Texto básico");</b></p>
     * @param entity Propiedad dada como ID, Nombre, Clase, XPath, Selectores CSS y Texto de enlace, es de tipo String (texto).
     * @param text Hace referencia al texto que se escribirá en el elemento definido.
     */
    public void sendKeysText(String entity, String text) {
        getEntity(entity).click();
        getEntity(entity).clear();
        getEntity(entity).sendKeys(text);
    }

    public void scrollDimension() throws Exception {
        Dimension dimension = DriverMobileBase.getDriver().manage().window().getSize();
        int startX=(int) (dimension.width*0.3);
        int startY= (int) (dimension.height*0.3);
        int endX= (int) (dimension.width*0.2);
        int endY= (int) (dimension.height*0.2);
        TouchAction touchAction = new TouchAction(DriverMobileBase.getDriver());
        touchAction.press(PointOption.point(startX,startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endX,endY)).release().perform();
    }
}