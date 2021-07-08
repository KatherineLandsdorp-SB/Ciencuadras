package com.segurosbolivar.automation.tests.filtersOffers;

import com.segurosbolivar.automation.commons.Data;
import com.segurosbolivar.automation.commons.Elements;
import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.commons.dataprovider.DataProviderSource;
import com.segurosbolivar.automation.commons.helpers.driver.DriverConstants;
import com.segurosbolivar.automation.commons.helpers.driver.web.DriverWebBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.TestType;

public class RunnerFiltersOffers extends Hooks {

    StepsFiltersOffers steps;

    @Test(
            priority = 4,
            id = 47,
            testType = TestType.WEB,
            dataProviderClass = DataProviderSource.class,
            dataProvider = "test-data",
            description = "Realizar búsqueda por mapa con los diferentes filtros"
    )
    public void SearchApartmentsToBuyMap(Data data){
        try {
            DriverWebBase.getDriver().get(DriverConstants.WEB_URL_ENVIRONMENT);
            this.steps = new StepsFiltersOffers(Elements.getWebElements());
            this.steps
                    .clickOnEntryOffers()
                    .clickOnBuyUsedRealState()
                    .setFilterCityOrHoods(data.getDataField("city"))
                    .clickFilterTypeRealState()
                    .setFilterTypeRealStateApartment()
                    .clickExitPopUp()
                   .clickOpenMap()
                    .clickOnMarkerResultMap(data.getAssertField("validate"));
            DriverWebBase.quitDriver();
         } catch (Exception ex) {
        Assert.fail(ex.getMessage());

        }
    }

    @Test(
            priority = 4,
            id = 48,
            testType = TestType.WEB,
            dataProviderClass = DataProviderSource.class,
            dataProvider = "test-data",
            description = "Realizar búsqueda con varios tipos de inmueble"
    )
    public void SearchWithManyOptionsRealState(Data data){
        try {
            String[] inputRealStates = {data.getDataField("realState_1"), data.getDataField("realState_2"),data.getDataField("realState_3")};
            DriverWebBase.getDriver().get(DriverConstants.WEB_URL_ENVIRONMENT);
            this.steps = new StepsFiltersOffers(Elements.getWebElements());
            this.steps.clickOnEntryOffers()
                    .clickOnBuyUsedRealState()
                    .clickFilterTypeRealState()
                    .setFilterTypeRealStateOffice()
                    .clickExitPopUp()
                    .clickFilterTypeRealState()
                    .setFilterTypeRealStateApartment()
                    .clickExitPopUp()
                    .clickFilterTypeRealState()
                    .setFilterTypeRealStateHouse()
                    .setThreeBathRoomsFilter()
                    .searchResultRealStateExist(inputRealStates);
            DriverWebBase.quitDriver();
        } catch (Exception ex) {
        Assert.fail(ex.getMessage());
        }
    }



    @Test(
            priority = 4,
            id = 49,
            testType = TestType.WEB,
            dataProviderClass = DataProviderSource.class,
            dataProvider = "test-data",
            description = "Realizar de búsqueda sin criterios de coincidencia"
    )
    public void SearchWithoutCriteria(Data data){
        try{
            DriverWebBase.getDriver().get(DriverConstants.WEB_URL_ENVIRONMENT);
            this.steps = new StepsFiltersOffers(Elements.getWebElements());
            this.steps.clickOnEntryOffers()
                    .clickOnBuyNewRealState()
                    .clickFilterTypeRealState()
                    .setFilterTypeRealStateApartment()
                    .clickExitPopUp()
                    .setFilterCityOrHoods(data.getDataField("city"))
                    .clickProjectsOnPlans()
                    .getTittleResultBanner(data.getAssertField("validate"));
            DriverWebBase.quitDriver();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }



    @Test(
            priority = 4,
            id = 64,
            testType = TestType.WEB,
            dataProviderClass = DataProviderSource.class,
            dataProvider = "test-data",
            description = "Ordenar Resultados: Area: Menor a Mayor."
    )
    public void OrderSquareLowerToHigher(Data data){
        try {
            DriverWebBase.getDriver().get(DriverConstants.WEB_URL_ENVIRONMENT);
            this.steps = new StepsFiltersOffers(Elements.getWebElements());
            this.steps.clickOnEntryOffers()
                    .clickOnBuyUsedRealState()
                    .setFilterCityOrHoods(data.getDataField("city"))
                    .clickFilterTypeRealState()
                    .setFilterTypeRealStateApartment()
                    .clickExitPopUp()
                    .clickOrderBySquareLowerToHigher()
                    .verifyOrderBySquareLowerToHigher();
            DriverWebBase.quitDriver();
        }catch (Exception e){
            Assert.fail(e.getMessage());
        }
    }


    @Test(
            priority = 4,
            id = 65,
            testType = TestType.WEB,
            dataProviderClass = DataProviderSource.class,
            dataProvider = "test-data",
            description = "Ordenar Resultados: Area: Mayor a Menor."
    )
    public void OrderSquareHigherToLower(Data data){
        try {
            DriverWebBase.getDriver().get(DriverConstants.WEB_URL_ENVIRONMENT);
            this.steps = new StepsFiltersOffers(Elements.getWebElements());
            this.steps.clickOnEntryOffers()
                    .clickOnBuyUsedRealState()
                    .setFilterCityOrHoods(data.getDataField("city"))
                    .clickFilterTypeRealState()
                    .setFilterTypeRealStateApartment()
                    .clickExitPopUp()
                    .clickOrderBySquareHigherToLower()
                    .verifyOrderBySquareHigherToLower();
            DriverWebBase.quitDriver();
        }catch (Exception e){
            Assert.fail(e.getMessage());
        }
    }



    @Test(
            priority = 4,
            id = 79,
            testType = TestType.WEB,
            dataProviderClass = DataProviderSource.class,
            dataProvider = "test-data",
            description = "Filtrar por: Tipo de inmueble, Habitaciones, Baños, Parqueadero, Precio, Más. Guardar búsqueda sin loguearse."
    )
    public void SearchWithFiltersAndVerifyLogin(Data data){
        try {
            DriverWebBase.getDriver().get(DriverConstants.WEB_URL_ENVIRONMENT);
            this.steps = new StepsFiltersOffers(Elements.getWebElements());
            this.steps.clickOnEntryOffers()
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
            DriverWebBase.quitDriver();
        }catch (Exception e){
            Assert.fail(e.getMessage());
        }
    }

}
