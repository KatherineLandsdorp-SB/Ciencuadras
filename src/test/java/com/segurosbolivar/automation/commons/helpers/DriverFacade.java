package com.segurosbolivar.automation.commons.helpers;

import com.segurosbolivar.automation.commons.Services;
import com.segurosbolivar.automation.commons.utils.PropertyManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;


public class DriverFacade {

    RemoteWebDriver driver;
    WebDriverWait wait;
    JSONObject jsonObject;

    int timeoutInSeconds = 60;

    private DesiredCapabilities capabilitiesSetUp(String description, String name) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platform", "MacOS Catalina");
//        capabilities.setCapability("browserName", "Safari");
//        capabilities.setCapability("version","13.0");
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "70.0");
        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("build", name);
        capabilities.setCapability("name", description);
        capabilities.setCapability("network", true); // To enable network logs
        capabilities.setCapability("visual", true); // To enable step by step screenshot
        capabilities.setCapability("video", true); // To enable video recording
        capabilities.setCapability("console", true); // To capture console logs
        return capabilities;
    }

    public DriverFacade(String description, String name) {
        JsonFile();

        if (!Boolean.valueOf(PropertyManager.getConfigValueByKey("driverLocal"))) {
            try {
                driver = new RemoteWebDriver(new URL("https://" + PropertyManager.getConfigValueByKey("lambdausername")
                        + ":" + PropertyManager.getConfigValueByKey("lambdapassword") +
                        PropertyManager.getConfigValueByKey("gridURL")), capabilitiesSetUp(description, name));
            } catch (MalformedURLException e) {
                System.out.println("Invalid grid URL");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else{
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        wait = new WebDriverWait(driver, timeoutInSeconds);
    }

    public WebDriver getWebDriver(){
        return driver;
    }



    public void waitForVisibilityOfElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /*
    public JSONObject JsonFile(){
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(Services.outputElements());
            jsonObject = (JSONObject) obj;
            return jsonObject;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
*/

    public JSONObject JsonFile(){
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
