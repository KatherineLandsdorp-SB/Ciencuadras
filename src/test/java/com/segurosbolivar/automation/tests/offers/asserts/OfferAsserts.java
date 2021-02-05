package com.segurosbolivar.automation.tests.offers.asserts;

import com.segurosbolivar.automation.tests.offers.StepsOffers;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class OfferAsserts {
    public static void checkMessageOnSale(List<WebElement> listResultOffers, StepsOffers steps) {
        listResultOffers.forEach(element -> {
            String messageOnSale = steps.getMessagePropertyOnSale(element);
            Assert.assertEquals(messageOnSale.toLowerCase(), "inmueble en oferta");
        });
    }

    public static void checkMessageNotResultOffers(StepsOffers steps){
        String messageNotResultOffers = steps.getMessageNotResultOffers();
        Assert.assertEquals(messageNotResultOffers.toLowerCase(), "inmuebles no encontrados");
    }
}
