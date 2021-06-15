package com.segurosbolivar.automation.tests.offers;

import com.segurosbolivar.automation.commons.Data;
import com.segurosbolivar.automation.commons.Hooks;
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
            Data data = new Data(47);
            this.steps.get()
                    .clickOnEntryOffers()
                    .clickOnBuyUsedRealState()
                   .clickFilterTypeRealState()
                    .setFilterTypeRealStateApartment()
                    .clickExitPopUp()
                   .setFilterCityOrHoods(data.getDataField("city"))
                   .clickOpenMap()
                   .clickOnMarkerResultMap(data.getAssertField("validate"));

         } catch (Exception ex) {
        Assert.fail(ex.getMessage());

        }
    }




    @Test(
            testName = "48",
            description = "Realizar búsqueda con varios tipos de inmueble"
    )
    public void SerchWithManyOptionsRealState(){

        try {
            Data data = new Data(48);
            String[] inputRealStates = {data.getDataField("realState_1"), data.getDataField("realState_2"),data.getDataField("realState_3")};

            this.steps.get()
                    .clickOnEntryOffers()
                    .clickOnBuyUsedRealState()
                    .clickFilterTypeRealState()
                    .setFilterTypeRealStateOffice()
                    .clickExitPopUp()
                    .clickFilterTypeRealState()
                    .setFilterTypeRealStateApartment()
                    .clickExitPopUp()
                    .clickFilterTypeRealState()
                    .setFilterTypeRealStateHouse()
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
            Data data = new Data(49);
            this.steps.get()
                    .clickOnEntryOffers()
                    .clickOnBuyNewRealState()
                    .clickFilterTypeRealState()
                    .setFilterTypeRealStateApartment()
                    .clickExitPopUp()
                    .setFilterCityOrHoods(data.getDataField("city"))
                    .clickProjectsOnPlans()
                    .getTittleResultBanner(data.getAssertField("validate"));
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }






}
