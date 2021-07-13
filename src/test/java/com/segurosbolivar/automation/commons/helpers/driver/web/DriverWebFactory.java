package com.segurosbolivar.automation.commons.helpers.driver.web;

import com.segurosbolivar.automation.commons.helpers.driver.DriverConstants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

@Log4j2
public class DriverWebFactory {
    private RemoteWebDriver webDriver;

    RemoteWebDriver getDriver() {
        String platform = DriverConstants.WEB_BROWSER_NAME;
        if (webDriver == null) {
            if (platform.equals("chrome")) {
                webDriver = new ChromeDriver();
                webDriver.manage().window().maximize();
            }
            if (platform.equals("firefox")) {
                webDriver = new FirefoxDriver();
            }
        }
        return webDriver;
    }

    RemoteWebDriver getDriver(String description, String nameExecution) {
         if(webDriver == null) {
             try {
                 webDriver = new RemoteWebDriver(new URL("https://" + DriverConstants.LAMBDA_USER_NAME + ":"
                         + DriverConstants.LAMBDA_PASS
                         + DriverConstants.LAMBDA_GRID_URL),
                         capabilitiesWebSetUp(description, nameExecution));
             } catch (MalformedURLException e) {
                 System.out.println("Invalid grid URL");
             } catch (Exception e) {
                 System.out.println(e.getMessage());
             }
         }
             return webDriver;

    }






    RemoteWebDriver getCurrentDriver() {
        return webDriver;
    }

    void quitDriver() {
        if (null != webDriver) {
            try {
                webDriver.close();
                webDriver.quit();
                webDriver = null;

            } catch (Exception ex) {
                log.warn(ex.getMessage());
            }
        }
    }


    private DesiredCapabilities capabilitiesWebSetUp(String description, String name) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", DriverConstants.WEB_BROWSER_NAME);
        capabilities.setCapability("version", DriverConstants.WEB_BROWSER_VERSION);
        capabilities.setCapability("platform", DriverConstants.WEB_OS_PLATFORM); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("build", name);
        capabilities.setCapability("name", description);
        capabilities.setCapability("network", Boolean.parseBoolean(DriverConstants.WEB_NETWORK_ENABLE)); // To enable network logs
        capabilities.setCapability("visual", Boolean.parseBoolean(DriverConstants.WEB_VISUAL_ENABLE)); // To enable step by step screenshot
        capabilities.setCapability("video", Boolean.parseBoolean(DriverConstants.WEB_VIDEO_ENABLE)); // To enable video recording
        capabilities.setCapability("console", Boolean.parseBoolean(DriverConstants.WEB_CONSOLE_ENABLE)); // To capture console logs
        return capabilities;
    }


}
