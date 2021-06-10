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
        driver.get(PropertyManager.getConfigValueByKey("url"));
        try {
            this.steps.get()
                    .clickOnEntryOffers()
                    .clickOnBuyUsedRealState()
                    .clickFilterTypeRealState()
                    .setFilterTypeRealStateApartment()
                    .clickExitPopUp()
                    .setFilterCityOrHoods("Bogotá")
                    .clickOpenMap()
                    .clickOnMarkerResultMap("apartamento");
            driver.quit();
         } catch (Exception ex) {
        Assert.fail(ex.getMessage());
        driver.quit();
        }
    }




    @Test(
            testName = "48",
            description = "Realizar búsqueda con varios tipos de inmueble"
    )
    public void SerchWithManyOptionsRealState(){

        driver.get(PropertyManager.getConfigValueByKey("url"));
        try {
            String[] data = {"apartamento", "casa", "oficina"};
            this.steps.get()
                    .clickOnEntryOffers()
                    .clickOnBuyUsedRealState()
                    .clickFilterTypeRealState()
                    .setFilterTypeRealStateApartment()
                    .clickExitPopUp()
                    .clickFilterTypeRealState()
                    .setFilterTypeRealStateHouse()
                    .clickFilterTypeRealState()
                    .setFilterTypeRealStateOffice()
                    .searchResultRealStateExist(data);
            driver.quit();
        } catch (Exception ex) {
        Assert.fail(ex.getMessage());
        driver.quit();
        }
    }


    @Test(
            testName = "49",
            description = "Realizar de búsqueda sin criterios de coincidencia"
    )
    public void SearchWithoutCriteria(){
        driver.get(PropertyManager.getConfigValueByKey("url"));
        try{

            this.steps.get()
                    .clickOnEntryOffers()
                    .clickOnBuyNewRealState()
                    .clickFilterTypeRealState()
                    .setFilterTypeRealStateApartment()
                    .clickExitPopUp()
                    .setFilterCityOrHoods("Bucaramanga")
                    .clickProjectsOnPlans()
                    .getTittleResultBanner("Proyectos no encontrados");
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
            driver.quit();

        }
    }



}
