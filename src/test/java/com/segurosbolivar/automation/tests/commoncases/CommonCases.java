package com.segurosbolivar.automation.tests.commoncases;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.helpers.driver.web.DriverWebBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public abstract class CommonCases extends BaseTest {
    @Test(id = 20, testName = "successfulLogin")
    public static void successfulLogin() {
        WebDriver driver = DriverWebBase.getDriver();
        driver.get("https://jira.segurosbolivar.com/login.jsp?os_destination=%2Fdefault.jsp");
        WebElement userTextField = driver.findElement(By.id("login-form-username"));
        WebElement passTextField = driver.findElement(By.id("login-form-password"));
        WebElement logInButton = driver.findElement(By.id("login-form-submit"));
        userTextField.sendKeys("80213585");
        passTextField.sendKeys("80213585");
        logInButton.click();
        WebElement dashBoardText = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"dashboard-content\"]/div[1]/div/div[1]/h1")));

        Assert.assertEquals("System Dashboard", dashBoardText.getText());
    }
}
