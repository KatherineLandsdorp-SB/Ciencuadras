package com.segurosbolivar.automation.tests.BodyOffers;

import com.segurosbolivar.automation.commons.Elements;
import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.commons.helpers.driver.DriverConstants;
import com.segurosbolivar.automation.commons.helpers.driver.web.DriverWebBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.TestType;

public class RunnerBodyOffers extends Hooks {

    StepsBodyOffers steps;


    @Test(
            priority = 5,
            id = 55,
            testType = TestType.WEB,
            description = "OFERTAS / DETALLE DEL INMUEBLE"
    )
    public void verifyDetailOffer() {
        try {
            DriverWebBase.getDriver().get(DriverConstants.WEB_URL_ENVIRONMENT);
            steps = new StepsBodyOffers(Elements.getWebElements());
            this.steps.clickOnEntryOffers()
                    .clickOnFirstCardOffer()
                    .clicksOnWindowDetailOffer()
                    .visualizeCheckOfferDetails();
            DriverWebBase.quitDriver();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }


    @Test(
            priority = 5,
            id = 59,
            testType = TestType.WEB,
            description = "ARRIENDO/ DETALLE DEL INMUEBLE"
    )
    public void verifyDetailRentOffer(){
        try{
            DriverWebBase.getDriver().get(DriverConstants.WEB_URL_ENVIRONMENT);
            steps = new StepsBodyOffers(Elements.getWebElements());
            this.steps.clickOnEntryOffers()
                    .clickOnEntryRentOffers()
                    .clickOnFirstCardOffer()
                    .clicksOnWindowDetailOffer()
                    .visualizeCheckOfferDetails();
            DriverWebBase.quitDriver();
        }catch (Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test(
            priority = 5,
            id = 58,
            testType = TestType.WEB,
            description = "ARRIENDO/ RESULTADO DE INMUEBLES"
    )
    public void verifyDetailCardOfferList(){
        try {
            DriverWebBase.getDriver().get(DriverConstants.WEB_URL_ENVIRONMENT);
            steps = new StepsBodyOffers(Elements.getWebElements());
            this.steps.clickOnEntryOffers()
                        .verifyCardOfferList();
            DriverWebBase.quitDriver();
        }catch (Exception e){
            Assert.fail(e.getMessage());
        }
    }


}
