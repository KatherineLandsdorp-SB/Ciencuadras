package com.segurosbolivar.automation.tests.BodyOffers;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RunnerBodyOffers extends Hooks {

    ThreadLocal<StepsBodyOffers> steps = ThreadLocal.withInitial(StepsBodyOffers::new);

    @Test(
            priority = 5,
            testName = "55",
            description = "OFERTAS / DETALLE DEL INMUEBLE"
    )
    public void verifyDetailOffer(){
    try{
        this.steps.get()
                .clickOnEntryOffers()
                .clickOnFirstCardOffer()
                .clicksOnWindowDetailOffer()
                .visualizeCheckOfferDetails();

    }catch (Exception e){
        Assert.fail(e.getMessage());
    }
    }


    @Test(
            priority = 5,
            testName = "59",
            description = "ARRIENDO/ DETALLE DEL INMUEBLE"
    )
    public void verifyDetailRentOffer(){
        try{
            this.steps.get()
                    .clickOnEntryOffers()
                    .clickOnEntryRentOffers()
                    .clickOnFirstCardOffer()
                    .clicksOnWindowDetailOffer()
                    .visualizeCheckOfferDetails();

        }catch (Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test(
            priority = 5,
            testName = "58",
            description = "ARRIENDO/ RESULTADO DE INMUEBLES"
    )
    public void verifyDetailCardOfferList(){
        try {
            this.steps.get()
                    .clickOnEntryOffers()
                    .verifyCardOfferList();
        }catch (Exception e){
            Assert.fail(e.getMessage());
        }
    }
}
