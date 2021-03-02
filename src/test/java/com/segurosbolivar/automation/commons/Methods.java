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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

public class Methods extends BaseTest {
    WebDriverWait wait;
    private JSONObject field;
    private int iteration;

    /* ============================================================= */
    /* ====================== JSON     HANDLE ====================== */
    /* ============================================================= */

    public void assertAttributes(Object asserts, WebElement element){
        if(asserts != null){
            JSONObject jsonObject = (JSONObject) field.get("asserts");

            Iterator<String> keys = jsonObject.keySet().iterator();;
            while(keys.hasNext()) {
                String key = keys.next();
                assertEquals(element.getAttribute(key), jsonObject.get(key));
            }
        }
    }

    //Buscar un elemento dada la entidad
    public WebElement getEntity(String entity) {
        WebElement element = null;
        field = (JSONObject) driverFacade.JsonFile().get(entity);
        try {
            if (field != null) {
                String typeObject = (String) field.get("GetFieldBy");
                Object asserts = field.get("asserts");

                switch (typeObject) {
                    case "Xpath":
                        element = driverFacade.getWebDriver().findElement(By.xpath((String) field.get("ValueToFind")));
                        break;
                    case "Id":
                        element = driverFacade.getWebDriver().findElement(By.id((String) field.get("ValueToFind")));
                        break;
                    default:
                        element = null;
                }
                assertAttributes(asserts, element);
                return element;

            } else {
                System.out.println("Item not found " + entity);
            }
        } catch (Exception e) {
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
    public WebElement waitElementExplicitTime(String entity) {
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driverFacade.getWebDriver(), 10);
        field = (JSONObject) driverFacade.JsonFile().get(entity);
        try {
            if (field != null) {
                String typeObject = (String) field.get("GetFieldBy");
                System.out.println("elemento" + field.get("ValueToFind"));
                switch (typeObject) {
                    case "Xpath":
                        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((String) field.get("ValueToFind"))));
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

    public String searchText(String text, int iterations){
        WebElement element = null;

        try {
                boolean ElementPresent = false;
                iteration = 0;

                while (iteration < (iterations * 2) && !ElementPresent) {
                    try {
                        ElementPresent = driverFacade.getWebDriver().findElement(By.xpath(("//*[contains(text(),'" + text + "')]"))).isEnabled();
                        element = driverFacade.getWebDriver().findElement(By.xpath(("//*[contains(text(),'" + text + "')]")));
                    } catch (Exception e) {
                        iteration++;
                        System.out.print("#Tried: " + iteration);
                        System.out.println(ElementPresent + " Not Search  " + text);
                    }
                }

                if (ElementPresent) {
                    Thread.sleep(1000);
                    System.out.print("Successful Enable: ** :) **  "+ element.getText());
                    return element.getText();
                } else {
                    System.out.print("Enable Failed: ** :( **  ");
                    System.out.print("No Se encontro el Elemento: ** :( ** : " + "//*[contains(text(),'" + text + "'");
                    System.out.print("No Se encontro el Elemento: ** :) **  ");
                    assertFalse(ElementPresent);
                }
                System.out.println(" ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        return element.getText();

    }

    //Esperar elemento por iteraciones
    public void waitingForElement(String entity, int iterations) {

        WebElement element = null;
        field = (JSONObject) driverFacade.JsonFile().get(entity);
        if (field != null) {
            String typeObject = (String) field.get("GetFieldBy");

            try {
                boolean ElementPresent = false;
                iteration = 0;

                while (iteration < (iterations * 2) && !ElementPresent) {
                    try {

                        switch (typeObject) {
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
                    System.out.print("No Se encontro el Elemento: ** :) **  ");
                    assertFalse(ElementPresent);
                }
                System.out.println(" ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Item not found");
        }
    }


    //Esperar un elemento n segundos
    public void awaitToFindElement(String entity, int seconds) {
        field = (JSONObject) driverFacade.JsonFile().get(entity);

        await().atMost(seconds, TimeUnit.SECONDS)
                .pollInterval(Duration.ONE_SECOND)
                .until(() -> {
                    try {
                        driverFacade.getWebDriver().findElement(By.id((String) field.get("ValueToFind")));
                        return true;
                    } catch (NoSuchElementException e) {
                        return false;
                    }
                });
    }


    //Validar si un elemento esta disponible
    public boolean validationElementEnable(String entity) {
        WebElement elemen = getEntity(entity);
        boolean element = false;
        try {
            element = elemen.isEnabled();
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

    // Validar si un elemento esta seleccionado
    public boolean validationElementSelected(String entity) {
        WebElement element = getEntity(entity);
        boolean elemen = false;
        try {
            elemen = element.isSelected();
        } catch (Exception e) {
            System.out.println("El elemento no se encuentra seleccionado" + e.getMessage());
        }
        if (elemen) {
            System.out.println("El elemento" + entity + "seleccionado");
        } else {
            System.out.println(element + "Validar el elemento, no se encontro");
        }
        return elemen;
    }

    public boolean validationElementDisplayed(String entity) {
        WebElement element = getEntity(entity);
        boolean elemen = false;
        try {
            elemen = element.isDisplayed();
        } catch (Exception e) {
            System.out.println("El elemento no se encuentra seleccionado" + e.getMessage());
        }
        if (elemen) {
            System.out.println("El elemento" + entity + "seleccionado");
        } else {
            System.out.println(element + "Validar el elemento, no se encontro");
        }
        return elemen;
    }

    //Esperar que la pagina termine de cargar
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

    public void switchToAnotherWindow(int windowNumber) {
        List<String> windowlist = null;
        Set<String> windows = driverFacade.getWebDriver().getWindowHandles();
        windowlist = new ArrayList<String>(windows);
        String currentWindow = driverFacade.getWebDriver().getWindowHandle();
        if (!currentWindow.equalsIgnoreCase(windowlist.get(windowNumber - 1))) {
            driverFacade.getWebDriver().switchTo().window(windowlist.get(windowNumber - 1));
        }
    }

    //changeWindow
    public void changeWindow() {
        String originalWindow = driverFacade.getWebDriver().getWindowHandle();
        for (String windowHandle : driverFacade.getWebDriver().getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driverFacade.getWebDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    // metodos de scroll
    public void scrollTo(String entity) {
        WebElement element = getEntity(entity);
        ((JavascriptExecutor) driverFacade.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollToPixel(String entity) {
        WebElement element = getEntity(entity);
        ((JavascriptExecutor) driverFacade.getWebDriver()).executeScript("window.scrollBy(0,500)", element);

    }


    public void doScrollDown(int x, String entity) {
        for (int i = 0; i <= x; i++) {
            pause(2);
            scrollToPixel(entity);
        }
    }

    public void scrollToEndPage() {

        JavascriptExecutor js = (JavascriptExecutor) driverFacade.getWebDriver();
        js.executeScript("window.scrollTo (0, document.body.scrollHeight)");
    }

// fin metodos scroll

    public void selectList(String entity, String text) {
        WebElement element = getEntity(entity);
        Select selecList = new Select(element);
        selecList.selectByVisibleText(services.getField(text));

    }

    public String elementText(String text, String type) {
        return "//" + type + "[text()='" + text + "']";
    }

    public WebElement xpathElement(String xpath) {
        return driverFacade.getWebDriver().findElement(By.xpath(xpath));
    }

    public void clickElement(String entity) {
        getEntity(entity).click();
    }

    public void clickElementJs(String entity) {
        WebElement element = getEntity(entity);
        JavascriptExecutor executor = (JavascriptExecutor) driverFacade.getWebDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    //waitTime
    public void pause(Integer seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Enviar texto
    public void sendKeysText(String entity, String text) {
        getEntity(entity).click();
        getEntity(entity).clear();
        getEntity(entity).sendKeys(text);
    }

    //click checkbox
    public void checkbox(String entity) {
        getEntity(entity).isSelected();
    }

    //Enviar enter
    public void sendKeysEnter(String entity) {
        getEntity(entity).sendKeys(Keys.ENTER);
    }
    /* ============================================================= */
    /* =================== FIN COMMONS GLOBALES ==================== */
    /* ============================================================= */



    /* ============================================================= */
    /* ==================== ELEMENTOS ANGULAR ====================== */
    /* ============================================================= */

    // Select material angular
    public void angularMaterialSelect(WebElement webElement, String search) {
        driverFacade.waitForVisibilityOfElement(webElement);
        webElement.click();
        webElement.sendKeys(search);
        Select dropdown = new Select(driverFacade.getWebDriver().findElement(By.xpath("//span[contains(text(),'" + search + "')]")));
        dropdown.selectByVisibleText(search);
        //WebElement element = webDriver.findElement(By.xpath("//span[contains(text(),'"+search+"')]"));
        //driverFacade.waitForVisibilityOfElement(element);
    }

    // Autocomplete material angular
    public void angularMaterialAutocomplete(String entity, String search) {
        waitingForElement(entity, 5);
        getEntity(entity).click();
        getEntity(entity).sendKeys(search);
        getEntity(entity).sendKeys(Keys.ARROW_DOWN);
        getEntity(entity).sendKeys(Keys.ENTER);
    }

    /* ============================================================= */
    /* =================== FIN ELEMENTOS ANGULAR =================== */
    /* ============================================================= */

    //Metodo para completar formularios de busqueda
    public void keyDown(String entity) {
        waitingForElement(entity, 5);
        getEntity(entity).sendKeys(Keys.ARROW_DOWN);
        getEntity(entity).sendKeys(Keys.ENTER);
        waitingForElement(entity, 5);
        pause(3);
    }


    public void select(String entity, String search) {
        Select dropdown = new Select(getEntity(entity));
        dropdown.selectByVisibleText(search);
    }



    // Metodo para seleccionar elemento a partir del xpath
    public void angularMaterialDrop(String entity, String search) {
        WebElement element = getEntity(entity);
        driverFacade.waitForVisibilityOfElement(element);
        driverFacade.getWebDriver().findElement(By.xpath("//*[@id=\"bnt-filter-1\"]/a[" + search + "]")).click();
        System.out.println("se realiza xpath" + "//*[@id=\"bnt-filter-1\"]/a[" + search + "]");

    }

    public boolean elementListSelected(String value) {
        Boolean checkSelenium = driverFacade.getWebDriver().findElement(By.xpath("//*[@id=\"bnt-filter-1\"]/a[" + value + "]")).isSelected();
        System.out.println("variable" + checkSelenium);
        return checkSelenium;
    }

    // Mètodo para limpiar texto
    public String clearText(String entity, String oldText, String newText) {
        String replace = getEntity(entity).getText().replaceAll(oldText, newText);
        return replace;
    }

    // Metodo para obtener texto de elemento web
    public String getTextElement(String entity) {
        WebElement element = getEntity(entity);
        String text = getEntity(entity).getText();
        return text;
    }

    //Metodo para realizar carga de imagen guardada en ruta del proyecto
    public void uploadFileImage(int Intentos, int Veces, String entity) {
        //String path = System.getProperty("user.dir");
        while (Intentos <= Veces) {
            //System.out.println(path + "esta ingresando a cargar la imagen");
            // inputImage.sendKeys(path + "/src/test/java/com/segurosbolivar/automation/commons/uploadFile/imagen.png");
            getEntity(entity).sendKeys(getFile());
            pause(10);
            System.out.println("Valor de Intentos : " + Intentos + getFile());
            Intentos++;
        }
    }

    //Metodo para obtener ruta absoluta local
    String getFile() {
        return new File("./src/test/java/com/segurosbolivar/automation/commons/uploadFile/imagen.png").getAbsolutePath();
    }

    public String generatosDinamicValue() {
        int longitud = 6;
        String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String text = "";
        Random rnd = new Random();
        while (text.length() < 4) {
            for (int x = 0; x < longitud; x++) {
                int indiceAleatorio = numeroAleatorioEnRango(0, alphabet.length() - 1);
                char caracterAleatorio = alphabet.charAt(indiceAleatorio);
                text += caracterAleatorio;
            }
            return text;

        }
        return text;

    }


    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }

    public String dinamicDataTest(String value){
        String data= services.getField(value);
        String dinamic=generatosDinamicValue()+data;
        return dinamic;

    }

}

