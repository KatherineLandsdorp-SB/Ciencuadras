package com.segurosbolivar.automation.tests.BodyOffers;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RunnerBodyOffers extends Hooks {

    ThreadLocal<StepsBodyOffers> steps = ThreadLocal.withInitial(StepsBodyOffers::new);

    @Test(
        testName = "23",
        description = "Realizar validación de las opciones de búsqueda"
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
}
