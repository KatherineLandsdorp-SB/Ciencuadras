package com.segurosbolivar.automation.tests.BodyOffers;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RunnerBodyOffers extends Hooks {

    ThreadLocal<StepsBodyOffers> steps = ThreadLocal.withInitial(StepsBodyOffers::new);

    @Test(
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


}
