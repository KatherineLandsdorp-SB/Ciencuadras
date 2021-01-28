package com.segurosbolivar.automation.tests.searchpropertytest;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MethodsSearchProperty extends BaseTest {

    private Methods methods;

    public MethodsSearchProperty(Methods methods) {
        this.methods = methods;
    }

    public void clickLinkSearchByCode() {
        methods.waitForPageLoad();
        
        methods.clickElement("searchButtonByCode");
    }

    public void fillTextBoxSearchByInvalidCode() {
        methods.awaitToFindElement("city", 10);
        methods.sendKeysText("city", "test-code-23456");
    }

    public void fillTextBoxSearchByValidCode() {
        methods.awaitToFindElement("city", 10);
        methods.sendKeysText("city", "151119-921485");
    }

    public void clickSearchButton() {
        methods.clickElement("searchButtonIcon");
    }

    public String checkInvalidCodeMessage() {
        //Espera hasta que el elemento este visible. TimeOut de 30 segundos
        WebDriverWait wait = new WebDriverWait(this.driverFacade.getWebDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']/div[1]/div[1]")));
        WebElement invalidMessage = methods.getEntity("errorMessageContainer");
        return invalidMessage.getText();
    }
}
