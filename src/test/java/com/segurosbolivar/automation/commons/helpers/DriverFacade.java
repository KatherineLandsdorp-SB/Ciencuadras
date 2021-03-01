package com.segurosbolivar.automation.commons.helpers;

import com.segurosbolivar.automation.utils.PropertyManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.remote.LocalFileDetector;

import static org.awaitility.Awaitility.await;


public class DriverFacade {



    RemoteWebDriver driver;
    WebDriverWait wait;
    JSONObject jsonObject;
    int timeoutInSeconds = 60;
    Date date = new Date();

    String executionName = "Ui_Automation_CienCuadras_Sonic"+"_2021_02_26_"+date.getHours()+"_"+date.getMinutes();

    protected DesiredCapabilities capabilitiesSetUp(String methodName) {

        String javaHome = System.getenv("JAVA_HOME");
        String browserName = System.getenv("BROWSER_NAME");
        String browserVersion = System.getenv("BROWSER_VERSION");
        String platformBrowser = System.getenv("BROWSER_PLATFORM");


        DesiredCapabilities capabilities = new DesiredCapabilities();

        if(browserName != null){
            capabilities.setCapability("browserName", browserName);
            capabilities.setCapability("version", browserVersion);
            capabilities.setCapability("platform", platformBrowser); // If this cap isn't specified, it will just get the any available one
        }else{
            capabilities.setCapability("browserName", PropertyManager.getConfigValueByKey("BROWSER_NAME"));
            capabilities.setCapability("version",  PropertyManager.getConfigValueByKey("BROWSER_VERSION"));
            capabilities.setCapability("platform",  PropertyManager.getConfigValueByKey("BROWSER_PLATFORM")); // If this cap isn't specified, it will just get the any available one
        }

        capabilities.setCapability("build", "Ui_Automation_CienCuadras_Sonic");
        capabilities.setCapability("name", methodName);

        capabilities.setCapability("build",executionName);
       capabilities.setCapability("name", methodName);

        capabilities.setCapability("network", true); // To enable network logs
        capabilities.setCapability("visual", true); // To enable step by step screenshot
        capabilities.setCapability("video", true); // To enable video recording
        capabilities.setCapability("console", true); // To capture console logs

        return capabilities;
    }

    public DriverFacade() {
        JsonFile();
        if (!Boolean.valueOf(PropertyManager.getConfigValueByKey("driverLocal"))) {
            try {
                driver = new RemoteWebDriver(new URL("https://" + PropertyManager.getConfigValueByKey("lambdausername")
                        + ":" + PropertyManager.getConfigValueByKey("lambdapassword") +
                        PropertyManager.getConfigValueByKey("gridURL")), capabilitiesSetUp("PruebaLocal"));
                driver.setFileDetector(new LocalFileDetector());

            } catch (MalformedURLException e) {
                System.out.println("Invalid grid URL");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            if (Boolean.valueOf(PropertyManager.getConfigValueByKey("desktop"))) {
                driver = new ChromeDriver();
                driver.manage().window().maximize();

            }else{
                HashMap<String, Object> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", PropertyManager.getConfigValueByKey("BROWSER_DEVICE"));
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                driver = new ChromeDriver(chromeOptions);
            }
        }
        wait = new WebDriverWait(driver, timeoutInSeconds);
    }

    public WebDriver getWebDriver() {
        return driver;
    }



    public JSONObject getJsonObject() {
        return jsonObject;
    }



    public void waitForVisibilityOfElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public JSONObject JsonFile() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(PropertyManager.getConfigValueByKey("elements")));
            jsonObject = (JSONObject) obj;
            return jsonObject;
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
