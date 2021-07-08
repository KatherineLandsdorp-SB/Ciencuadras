package com.segurosbolivar.automation.commons.methods.mobile;

import com.segurosbolivar.automation.commons.helpers.driver.mobile.DriverMobileBase;
import com.segurosbolivar.automation.commons.utils.JsonParser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import lombok.extern.log4j.Log4j2;
import org.json.simple.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;


@Log4j2
public abstract class MobileGlobalMethods {
    private final AppiumDriver<?> driver;
    private final JSONObject elements;

    public MobileGlobalMethods(JSONObject elements) {
        this.elements = elements;
        this.driver = DriverMobileBase.getCurrentDriver();
    }

    protected MobileElement getEntity(String entity) throws Exception {
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
                        log.error(typeObject + " Not Found");
                }
                return element;

            } else {
                log.error("MobileMethods entity " + entity + " not found");
                throw new Exception("MobileMethods entity " + entity + " not found");
            }
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new Exception(ex);
        }
    }

    /**
     * <b>waitElementExplicitTime</b>
     * <p>Método con instrucciones que realiza una espera inteligente condicionado a la aparición de un elemento en el DOM.</p>
     * <p>El entity puede estar dado con propiedades tales como ID, Nombre, Clase, XPath, Selectores CSS, Texto de enlace, etc.</p>
     * <p><b>Implementación</b></p>
     * <p><b>methods.waitElementExplicitTime("entity");</b></p>
     *
     * @param entity Propiedad para buscar un elemento dentro del DOM de una página.
     * @return element - Encontrado en la búsqueda del DOM.
     */
    public MobileElement waitElementExplicitTime(String entity) throws Exception {
        MobileElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, 20);
        JSONObject field = JsonParser.toJSONObject(elements.get(entity));
        try {
            if (field != null) {
                String typeObject = (String) field.get("GetFieldBy");
                switch (typeObject) {
                    case "Xpath":
                        element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((String) field.get("ValueToFind"))));
                        break;
                    default:
                        log.error(typeObject + " Not Found");
                }
                return element;

            } else {
                log.error("entity " + entity + " Not Found");
                throw new Exception("entity " + entity + " Not Found");
            }
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new Exception(ex);
        }
    }

    public void clickBackButton() throws Exception {
        try {
            driver.navigate().back();
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new Exception(ex);
        }
    }

    //waitTime
    public void pause(Integer seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tabTouch() {
        try {
            TouchAction touchAction = new TouchAction(driver);
            touchAction.tap(PointOption.point(506, 1543)).perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tabTouchEntendido() {
        try {
            TouchAction touchAction = new TouchAction(driver);
            touchAction.tap(PointOption.point(536, 1407)).perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click(String entity) throws Exception {
        MobileElement element = getEntity(entity);
        element.click();
    }
    public void refreshPage() throws Exception {
        //driver.getKeyboard().pressKey(new KeyEvent(AndroidKey.8));
    }

    public int getDay(){
        Calendar fecha = Calendar.getInstance();
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        dia=dia+1;
        return dia;
    }

    public void scrollDimension3() throws Exception {
        try {
            Dimension dimension = driver.manage().window().getSize();
            int startX = (int) (dimension.width * 0.7);
            int startY = (int) (dimension.height * 0.7);
            int endX = (int) (dimension.width * 0.1);
            int endY = (int) (dimension.height * 0.1);
            TouchAction touchAction = new TouchAction(driver);
            touchAction.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(endX, endY)).release().perform();
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new Exception(ex);
        }
    }

    public String getText(String entity) throws Exception {
        MobileElement element = getEntity(entity);
        return element.getText();
    }

    public String getTextVal(String entity) throws Exception {
        MobileElement element = getEntity(entity);
        return element.getAttribute("Value");
    }

    /**
     * <b>sendKeysText</b>
     * <p>Método con instrucciones para escribir texto sobre un campo de texto en una página web.</p>
     * <p>Hace referencia a simular un usuario real escribiendo texto en una página web.</p>
     * <p><b>Implementación</b></p>
     * <p><b>methods.sendKeysText("entity","Texto básico");</b></p>
     *
     * @param entity Propiedad dada como ID, Nombre, Clase, XPath, Selectores CSS y Texto de enlace, es de tipo String (texto).
     * @param text   Hace referencia al texto que se escribirá en el elemento definido.
     */
    public void sendKeysText(String entity, String text) throws Exception {
        getEntity(entity).click();
        getEntity(entity).clear();
        getEntity(entity).sendKeys(text);
    }

    public void sendKeysTextNoElement(String entity, String text) throws Exception {
        getEntity(entity).click();
        getEntity(entity).clear();
        getEntity(entity).sendKeys(text);
    }

    public void sendKeysTextWithOutClick(String entity, String text) throws Exception {
        getEntity(entity).clear();
        getEntity(entity).sendKeys(text);
    }

    public void scrollDimension() throws Exception {

        try {
            Dimension dimension = driver.manage().window().getSize();
            int startX = (int) (dimension.width * 0.3);
            int startY = (int) (dimension.height * 0.6);
            int endX = (int) (dimension.width * 0.2);
            int endY = (int) (dimension.height * 0.2);
            TouchAction touchAction = new TouchAction(driver);
            touchAction.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(endX, endY)).release().perform();

        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new Exception(ex);
        }

    }

    public boolean isVisible(String entity) throws Exception {
        return getEntity(entity).isDisplayed();
    }

    public boolean isEnabled(String entity) throws Exception {
        return getEntity(entity).isEnabled();
    }

    public void ScrollToElementText(String text) throws Exception {

        ((AndroidDriver<MobileElement>) DriverMobileBase.getDriver())
                .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                        + ".scrollable(true).instance(0)).scrollIntoView("
                        + "new UiSelector().text(\""+text+"\").instance(0))");
    }

    public void ScrollToElementTextClick(String text) throws Exception {

        ((AndroidDriver<MobileElement>) DriverMobileBase.getDriver())
                .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                        + ".scrollable(true).instance(0)).scrollIntoView("
                        + "new UiSelector().text(\""+text+"\").instance(0))").click();
    }
}