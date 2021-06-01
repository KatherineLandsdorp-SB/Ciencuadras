package com.segurosbolivar.automation.tests.offers;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.annotations.Test;

public class RunnerOffers extends Hooks {

    ThreadLocal<StepsOffers> steps = ThreadLocal.withInitial(StepsOffers::new);


    @Test(
            testName = "11",
            description = "Formulario búsqueda por Mapa"
    )
    public void SearchApartmentsToBuyMap(){
        this.steps.get()
                .clickOnEntryOffers()
                .clickOnBuyNewRealState()
                .clickFilterTypeRealState()
                .setFilterTypeRealStateApartment()
                .clickExitPopUp()
                .setFilterCityOrHoods("Bogotá")
                .clickOpenMap()
                .clickOnMarkerResultMap();
    }



}
