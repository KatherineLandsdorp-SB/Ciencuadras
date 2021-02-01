package com.segurosbolivar.automation.tests.offers;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MethodsOffers extends BaseTest {
    Methods methods = new Methods();

    public void clickOnEntry() {
        methods.waitForPageLoad();
        methods.awaitToFindElement("entryOffersUser", 5);
        methods.clickElement("entryOffersUser");
        methods.waitForPageLoad();
    }

    public void writeSearch(String text) {

        WebElement searchOffersInput = methods.getEntity("searchOffersInput");
        searchOffersInput.clear();
        searchOffersInput.sendKeys(text);
    }

    public void clickSearchOffersButton() {
        methods.clickElement("searchOffersButton");
        methods.pause(6);
    }

    public List<WebElement> getResultOffers() {
        methods.pause(6);
        return methods.getEntities("contentResultOffers");
    }

    public String getMessagePropertyOnSale(WebElement webElement) {
        WebElement message = webElement.findElement(By.xpath("//div[@class='cinta-oferta ng-star-inserted']"));
        return message.getText();
    }

    public String getMessageNotResultOffers() {
        return methods.getEntity("messageNotResultOffers").getText();
    }

}
