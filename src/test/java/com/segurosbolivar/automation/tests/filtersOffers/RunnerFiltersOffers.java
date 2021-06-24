package com.segurosbolivar.automation.tests.filtersOffers;

import com.segurosbolivar.automation.commons.Data;
import com.segurosbolivar.automation.commons.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RunnerFiltersOffers extends Hooks {

    ThreadLocal<StepsFiltersOffers> steps = ThreadLocal.withInitial(StepsFiltersOffers::new);


    @Test(
            priority = 4,
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
            priority = 4,
            testName = "48",
            description = "Realizar búsqueda con varios tipos de inmueble"
    )
    public void SearchWithManyOptionsRealState(){

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
            priority = 4,
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

    @Test(
            priority = 4,
            testName = "64",
            description = "Ordenar Resultados: Área: Menor a Mayor."
    )
    public void OrderSquareLowerToHigher(){
            this.steps.get()
                    .clickOnEntryOffers()
                    .clickOnBuyUsedRealState()
                    .setFilterCityOrHoods("ibague")
                    .clickFilterTypeRealState()
                    .setFilterTypeRealStateApartment()
                    .clickExitPopUp()
                    .clickOrderBySquareLowerToHigher()
                    .verifyOrderBySquareLowerToHigher();

    }


    @Test(
            priority = 4,
            testName = "65",
            description = "Ordenar Resultados: Área: Mayor a Menor."
    )
    public void OrderSquareHigherToLower(){
        this.steps.get()
                .clickOnEntryOffers()
                .clickOnBuyUsedRealState()
                .setFilterCityOrHoods("ibague")
                .clickFilterTypeRealState()
                .setFilterTypeRealStateApartment()
                .clickExitPopUp()
                .clickOrderBySquareHigherToLower()
                .verifyOrderBySquareHigherToLower();

    }



    @Test(
            priority = 4,
            testName = "79",
            description = "Filtrar por: Tipo de inmueble, Habitaciones, Baños, Parqueadero, Precio, Más. Guardar búsqueda sin loguearse."
    )
    public void SearchWithFiltersAndVerifyLogin(){
        try {
            Data data = new Data(79);
            this.steps.get()
                    .clickOnEntryOffers()
                    .clickOnBuyUsedRealState()
                    .clickFilterTypeRealState()
                    .setFilterTypeRealStateHouse()
                    .clickExitPopUp()
                    .setOneBedRoomFilter()
                    .setThreeBathRoomsFilter()
                    .setOneParkingFilter()
                    .setMaxValuePriceOfferFilter(data.getDataField("price"))
                    .saveSearchFilter(data.getDataField("nameSave"))
                    .isSystemRequestLogIn();
        }catch (Exception e){
            Assert.fail(e.getMessage());
        }
    }


}
