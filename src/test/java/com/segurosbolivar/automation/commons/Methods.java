package com.segurosbolivar.automation.commons;

import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;
import com.segurosbolivar.automation.commons.helpers.DriverFactory;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.awaitility.Duration;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

public class Methods extends BaseTest {
    private JSONObject field;
    private int iteration;

    /* ============================================================= */
    /* ====================== JSON     HANDLE ====================== */
    /* ============================================================= */

    //Buscar un elemento dada la entidad
    public WebElement getEntity(String entity) {
        WebElement element = null;
        field = (JSONObject) driverFacade.JsonFile().get(entity);
        try {
            if (field != null) {
                String typeObject = (String) field.get("GetFieldBy");
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
                return element;

            } else {
                System.out.println("Item not found " + entity);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return element;
    }


    public List<WebElement> getEntities(String entity) {
        List<WebElement> elements = null;
        field = (JSONObject) driverFacade.JsonFile().get(entity);
        try {
            if (field != null) {
                String typeObject = (String) field.get("GetFieldBy");
                switch (typeObject) {
                    case "Xpath":
                        elements= driverFacade.getWebDriver().findElements(By.xpath((String) field.get("ValueToFind")));
                        break;
                    case "Id":
                        elements = driverFacade.getWebDriver().findElements(By.id((String) field.get("ValueToFind")));
                        break;
                    default:
                        elements = null;
                }
                return elements;

            } else {
                System.out.println("Items not found " + entity);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return elements;
    }

    /* ============================================================= */
    /* ====================== JSON     HANDLE ====================== */
    /* ============================================================= */


    /* ============================================================= */
    /* ====================== COMMONS GLOBALES ====================== */
    /* ============================================================= */

    //Esperar un elemento con carga explicita
    public WebElement waitElementExplicitTime(String entity, int time) {
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driverFacade.getWebDriver(), time);
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
                        System.out.println(ElementPresent + " Not Present  " + entity);
                    }
                }

                if (ElementPresent) {
                    Thread.sleep(1000);
                    System.out.print("Successful Enable: ** :) **  ");
                    //assertEquals(true, ElementPresent);
                } else {
                    System.out.print("No Se encontro el Elemento: ** :( ** : " + entity);
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


    //[Esperar elemento si esta presento o no por iteraciones]
    public boolean visibleElement(String entity, int iterations) {
        WebElement element = null;
        field = (JSONObject) driverFacade.JsonFile().get(entity);
        boolean ElementPresent = false;
        if (field != null) {
            String typeObject = (String) field.get("GetFieldBy");
            ElementPresent = false;
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
                }
            }
        } else {
            //System.out.println("Item not found");
        }
        return ElementPresent;
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
        JavascriptExecutor js = (JavascriptExecutor)driverFacade.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView(false)", element);
    }

    public void scrollToPixel(String entity) {
        WebElement element = getEntity(entity);
        ((JavascriptExecutor) driverFacade.getWebDriver()).executeScript("window.scrollBy(0,500)", element);

    }

    public void scrollToEndPage() throws InterruptedException {
        //avascriptExecutor js = (JavascriptExecutor) driverFacade.getWebDriver();
        //js.executeScript("window.scrollTo (0, document.body.scrollHeight)");

        JavascriptExecutor jse = (JavascriptExecutor)driverFacade.getWebDriver();
        jse.executeScript("window.scrollBy(0,250)", "");
        for (int second = 0;; second++) {

            if (second >= 15) {
                break;
            }
            jse.executeScript("window.scrollBy(0,200)", "");
            Thread.sleep(250);
        }

    }

    public void scrollToInitPage() {
        JavascriptExecutor js = (JavascriptExecutor) driverFacade.getWebDriver();
        js.executeScript("window.scrollTo (0, 0)");
    }

// fin metodos scroll

    public void selectList(String entity, String text) {
        WebElement element = getEntity(entity);
        Select selecList = new Select(element);
       // selecList.selectByVisibleText(services.getField(text));

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

    public void clickElementAction(String entity) {
        WebElement element = getEntity(entity);
        Actions action = new Actions(driverFacade.getWebDriver());
        action.moveToElement(element).perform();
        action.moveToElement(element).click().perform();
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

    public void sendKeysTextJs(String entity, String text) {
        clickElementJs(entity);
        getEntity(entity).clear();
        getEntity(entity).sendKeys(text);
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
    public void angularMaterialSelect(String entity, String search) {

        driverFacade.waitForVisibilityOfElement(getEntity(entity));
        getEntity(entity).click();
        getEntity(entity).sendKeys(search);
        driverFacade.getWebDriver().findElement(By.xpath("//span[contains(text(),'" + search + "')]")).clear();
        pause(5);
        //WebElement element = webDriver.findElement(By.xpath("//span[contains(text(),'"+search+"')]"));
        //driverFacade.waitForVisibilityOfElement(element);
    }

    public void angularMaterialSelectOption( String entity, String search) {
        WebElement webElement = getEntity(entity);
        driverFacade.waitForVisibilityOfElement(webElement);
        clickElementJs(entity);
        driverFacade.getWebDriver().findElement(By.xpath("//mat-option/span[contains(.,'" + search + "')]")).click();
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
    public void keyDown(String entity) throws InterruptedException {
        waitingForElement(entity, 5);
        getEntity(entity).sendKeys(Keys.ARROW_DOWN);
        getEntity(entity).sendKeys(Keys.ENTER);
        waitingForElement(entity, 5);
        Thread.sleep(3000);

    }

    // Metodo para seleccionar elemento a partir del xpath
    public void angularMaterialDrop(String entity, String search) {
        WebElement element = getEntity(entity);
        driverFacade.waitForVisibilityOfElement(element);
        driverFacade.getWebDriver().findElement(By.xpath("//*[@id=\"bnt-filter-1\"]/a[" + search + "]")).click();

    }

    public boolean elementListSelected(String value) {
        Boolean checkSelenium = driverFacade.getWebDriver().findElement(By.xpath("//*[@id=\"bnt-filter-1\"]/a[" + value + "]")).isSelected();
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
            getEntity(entity).sendKeys(getFile());
            pause(10);
            Intentos++;
        }
    }

    //Metodo para obtener ruta absoluta local
    String getFile() {
        return new File("./src/test/java/com/segurosbolivar/automation/commons/uploadFile/imagen.png").getAbsolutePath();
    }



    /* ============================================================= */
    /* ==================== VALIDAR IMAGENES ======================= */
    /* ============================================================= */

    public void validateAllImages(){
        List<WebElement> allImages = driverFacade.getWebDriver().findElements(By.tagName("img"));
        List<String> theList = new ArrayList<>();

        for(WebElement imageFromList:allImages){
            if (!theList.contains(imageFromList.getAttribute("src"))){
                theList.add(imageFromList.getAttribute("src"));
                checkLinks(imageFromList);
                checkImageValidity(imageFromList);
                String ImageUrl=imageFromList.getAttribute("src");
            }
        }
    }

    Boolean checkLinks(WebElement Im) {
        int Response = 0;
        String Source = "";
        try {
            Source = Im.getAttribute("src");
            if (Source.equals("#"))
                return false;

            HttpURLConnection Connect = (HttpURLConnection) (new URL(Source)).openConnection();
            Response = Connect.getResponseCode();
        } catch (Exception e) {
            // TODO: handle exception
        }
        if (!((Response + "").startsWith("4") || (Response + "").startsWith("5"))) {
            return true;
        } else {
            return false;
        }
    }

    static Boolean checkImageValidity(WebElement Im) {
        String Source = Im.getAttribute("src");
        try {
            BufferedImage img = ImageIO.read(new URL(Source));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void compareImages(){
        //load images to be compared:
        BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources("./src/test/java/com/segurosbolivar/automation/data/fin.png");
        BufferedImage actualImage = ImageComparisonUtil.readImageFromResources("./src/test/java/com/segurosbolivar/automation/data/ini.png");
        // where to save the result (leave null if you want to see the result in the UI)
        File resultDestination = new File( "./src/test/java/com/segurosbolivar/automation/data/result.png" );
        //Create ImageComparison object and compare the images.

        //Create ImageComparison object with result destination and compare the images.
        ImageComparisonResult imageComparisonResult = new ImageComparison(expectedImage, actualImage, resultDestination).compareImages();

        //Check the result
        assertEquals(ImageComparisonState.MATCH, imageComparisonResult.getImageComparisonState());
    }

    public void screenshotComplete() throws IOException{
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driverFacade.getWebDriver());
        ImageIO.write(screenshot.getImage(),"PNG",new File("./src/test/java/com/segurosbolivar/automation/data/train_test2.png"));
    }

    public void screenshotElement(String entity, String description) throws IOException{
        WebElement ImageElement = getEntity(entity);
        Screenshot ImageScreenshot = new AShot().coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driverFacade.getWebDriver(), ImageElement);
        BufferedImage actualImage = ImageScreenshot.getImage();

        takeScreenshot(actualImage, description);
    }

    public  void testScreenShot(String entity) throws IOException, InterruptedException {

        // Selenium Script
        WebElement ImageElement = getEntity(entity);
        Screenshot ImageScreenshot = new AShot().coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(driverFacade.getWebDriver(), ImageElement);

        File f = new File("./src/test/java/com/segurosbolivar/automation/data/train_"+entity+".png");
        try {
        if (f.exists() && f.canRead()) {

                BufferedImage expectedImage = ImageIO.read(new File("./src/test/java/com/segurosbolivar/automation/data/train_"+entity+".png"));
                BufferedImage actualImage = ImageScreenshot.getImage();

                ImageDiffer imgdiffer = new ImageDiffer();
                ImageDiff imgdiff = imgdiffer.makeDiff(expectedImage, actualImage);
                BufferedImage diffImage = imgdiff.getDiffImage();
                if(imgdiff.hasDiff()){
                    //ImageIO.write(imgdiff.getMarkedImage(),"PNG", new File("./src/test/java/com/segurosbolivar/automation/data/validate_"+entity+".png"));
                    //addAllureScreenshotPNG("./src/test/java/com/segurosbolivar/automation/data/validate_"+entity+".png");
                    assertFalse("Images are Different", imgdiff.hasDiff());
                }
        } else {
            BufferedImage actualImage = ImageScreenshot.getImage();
            ImageIO.write(actualImage,"PNG",new File("./src/test/java/com/segurosbolivar/automation/data/train_"+entity+".png"));
        } // Error message.

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] takeScreenShotAsByte(WebDriver webDriver) throws IOException {
        return takeFullPageScreenShotAsByte(webDriver);
    }

    private static byte[] takeFullPageScreenShotAsByte(WebDriver webDriver) throws IOException {
        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(webDriver);

        BufferedImage originalImage = fpScreenshot.getImage();

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(originalImage, "png", baos);
            baos.flush();
            return baos.toByteArray();
        }
    }

    public static byte[] toByteArray(BufferedImage bi, String format)
            throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, format, baos);
        byte[] bytes = baos.toByteArray();
        return bytes;

    }


    @Attachment(value = "Page Screenshot", type = "image/png")
    public static byte[] saveScreenshotPNG() throws IOException {

        BufferedImage expectedImage = ImageIO.read(new File("./src/test/java/com/segurosbolivar/automation/data/train_test2.png"));

        // if decoding is not necessary just return image
        return toByteArray(expectedImage, "png");
    }

    @Attachment(value = "Test Evidence", type = "image/png")
    public byte[] takeScreenshot(BufferedImage image, String description) throws IOException {
        Allure.addAttachment(description, new ByteArrayInputStream(toByteArray(image, "png")));
        return toByteArray(image, "png");
    }


    /* ============================================================= */
    /* ========================== SEO ============================== */
    /* ============================================================= */

    public void validateGtm(String gtm) {

        JavascriptExecutor js = (JavascriptExecutor)driverFacade.getWebDriver();

        ArrayList<Map<String, List<String> >> myList = new ArrayList<>();

        //Execute GTM script to fetch values
        myList =  (ArrayList) js.executeScript("return window.dataLayer");

        // Parse through GTM arrayList
        for(int a=0; a < myList.size(); a++) {
            for (String key : myList.get(a).keySet()) {
                System.out.println(key + "      " + myList.get(a).get(key));
            }
        }

        String code = driverFacade.getWebDriver().getPageSource();
        Allure.addAttachment("GTM: ", gtm);
        Allure.addAttachment("html lang: ", "es");
        Allure.addAttachment("canonical: ", "http://pre.segurosbolivar.com/");
        Allure.addAttachment("head title: ", "Seguros de vida, vehículos, salud y hogar | Seguros Bolívar");
        Allure.addAttachment("description: ", "Compañía aseguradora colombiana que brinda una gran variedad de seguros para usted y su familia. Tranquilo, nosotros respondemos.");
        Allure.addAttachment("robots: ", "noindex, nofollow");

    }
}

