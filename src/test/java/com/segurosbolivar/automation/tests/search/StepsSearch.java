package com.segurosbolivar.automation.tests.search;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.tests.rent.StepsRent;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class StepsSearch extends BaseTest {

    private MethodsSearch MethodsSearch = new MethodsSearch();

    @Step("The user click on the logo")
    public StepsSearch clickLogo(){
        MethodsSearch.clickLogo();
        return this;
    }

    @Step("Search code")
    public StepsSearch searchCode(){
        assertTrue(true, MethodsSearch.clickSearchCode());
        return this;
    }





    //

    @Step("The user to do click on rent")
    public StepsSearch clickOnRent() {
        MethodsSearch.clickOnRent();
        return this;
    }

    @Step("The user search property for city")
    public StepsSearch searchPropertyForRent() throws InterruptedException {
        assertEquals(MethodsSearch.searchPropertyForCity(), "Arriendo en Bogotá de apartamentos, casas y más inmuebles");
        return this;
    }

    @Step("The user search property for neighborhood")
    public StepsSearch searchPropertyForNeighborhood() throws InterruptedException {
        assertEquals(MethodsSearch.searchPropertyForNeighborhood(), services.getField("textSearchNeihborhood"));
        return this;
    }

    @Step("The user search property for Sector")
    public StepsSearch searchPropertyForSector() throws InterruptedException {
        assertEquals(MethodsSearch.searchPropertyForSector(), services.getField("textSearchSector"));
        return this;
    }

    @Step("The user search property for rent")
    public StepsSearch filterDealRent() throws InterruptedException {
        assertEquals(MethodsSearch.filterTypeDealRent(), services.getField("textSearchRent"));
        return this;
    }

    @Step("The user search property for buy new")
    public StepsSearch filterDealBuyRent() throws InterruptedException {
        assertEquals(MethodsSearch.filterTypeDealBuyNew(), services.getField("textBuyNew"));
        return this;
    }

    @Step("The user search property for buy new")
    public StepsSearch filterDealBuyUsed() throws InterruptedException {
        assertEquals(MethodsSearch.filterTypeDealBuyUsed(), services.getField("textBuyUsed"));
        return this;
    }
    @Step("The user search property type rent")
    public StepsSearch filterPropertyTypeRent() throws InterruptedException {
        assertEquals(MethodsSearch.filterPropertyTypeRent(), services.getField("textCheckRent"));
        return this;
    }
    @Step("The user search property type studio aparment")
    public StepsSearch filterPropertyTypeStudioAparment() throws InterruptedException {
        assertEquals(MethodsSearch.filterPropertyTypeStudioAparment(), services.getField("checkStudioAparment"));
        return this;
    }
    @Step("The user search property type home")
    public StepsSearch filterPropertyTypeHome() throws InterruptedException {
        assertEquals(MethodsSearch.filterPropertyTypeHome(), services.getField("texCheckHome"));
        return this;
    }
    @Step("The user search property type home")
    public StepsSearch filterPropertyTypeLocal() throws InterruptedException {
        assertEquals(MethodsSearch.filterPropertyTypeLocal(), services.getField("textCheckLocal"));
        return this;
    }
}