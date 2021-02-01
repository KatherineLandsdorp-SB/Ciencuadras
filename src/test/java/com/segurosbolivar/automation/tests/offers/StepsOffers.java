package com.segurosbolivar.automation.tests.offers;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StepsOffers {
    MethodsOffers methodsOffers = new MethodsOffers();

    @Step("The user clicks on the offers Link in the Header")
    public StepsOffers clickEntry() {
        methodsOffers.clickOnEntry();
        return this;
    }

    @Step("Write search on the offers search textBox")
    public StepsOffers writeSearch(String text) {
        methodsOffers.writeSearch(text);
        return this;
    }

    @Step("Click Search offers Button")
    public StepsOffers clickSearchOffersButton() {
        methodsOffers.clickSearchOffersButton();
        return this;
    }

    @Step("Get the result of the offers search")
    public List<WebElement> getResultOffers() {
        return methodsOffers.getResultOffers();
    }

    @Step("Check if each element of getResultOffers has a property on sale message")
    public String getMessagePropertyOnSale(WebElement webElement) {
        return methodsOffers.getMessagePropertyOnSale(webElement);
    }

    @Step("When search not found. Get not found search message")
    public String getMessageNotResultOffers() {
        return methodsOffers.getMessageNotResultOffers();
    }

}
