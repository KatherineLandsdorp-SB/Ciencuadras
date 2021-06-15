package com.segurosbolivar.automation.tests.offers;

import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.commons.utils.PropertyManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RunnerOffers extends Hooks {

    ThreadLocal<StepsOffers> steps = ThreadLocal.withInitial(StepsOffers::new);


    @Test(
            testName = "47",
            description = "Realizar búsqueda por mapa con los diferentes filtros"
    )
    public void SearchApartmentsToBuyMap(){
        try {
            this.steps.get()
                    .clickOnEntryOffers()
                    .clickOnBuyUsedRealState()
                    .clickFilterTypeRealState()
                    .setFilterTypeRealStateApartment()
                    .clickExitPopUp()
                    .setFilterCityOrHoods(data.getField("city"))
                    .clickOpenMap()
                    .clickOnMarkerResultMap(data.getAssert());
         } catch (Exception ex) {
            driver.quit();
        Assert.fail(ex.getMessage());

        }
    }



/*
    @Test(
            testName = "48",
            description = "Realizar búsqueda con varios tipos de inmueble"
    )
    public void SerchWithManyOptionsRealState(){

        try {
            String[] inputRealStates = {data.getField("realState_1"), data.getField("realState_2"), data.getField("realState_3")};

            this.steps.get()
                    .clickOnEntryOffers()
                    .clickOnBuyUsedRealState()
                    .clickFilterTypeRealState()
                    .setFilterTypeRealStateApartment()
                    .clickExitPopUp()
                    .clickFilterTypeRealState()
                    .setFilterTypeRealStateHouse()
                    .clickExitPopUp()
                    .clickFilterTypeRealState()
                    .setFilterTypeRealStateOffice()
                    .searchResultRealStateExist(inputRealStates);

        } catch (Exception ex) {
        Assert.fail(ex.getMessage());

        }
    }




    @Test(
            testName = "49",
            description = "Realizar de búsqueda sin criterios de coincidencia"
    )
    public void SearchWithoutCriteria(){
        try{
            this.steps.get()
                    .clickOnEntryOffers()
                    .clickOnBuyNewRealState()
                    .clickFilterTypeRealState()
                    .setFilterTypeRealStateApartment()
                    .clickExitPopUp()
                    .setFilterCityOrHoods(data.getField("city"))
                    .clickProjectsOnPlans()
                    .getTittleResultBanner(data.getAssert());
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
*/

}
