package com.segurosbolivar.automation.tests.filtersOffers;

import io.qameta.allure.Step;
import org.testng.Assert;

public class StepsFiltersOffers {

    private MethodsFiltersOffers methods = new MethodsFiltersOffers();

    @Step("The user clicks on the header label Offers ")
    public StepsFiltersOffers clickOnEntryOffers(){
        this.methods.header.clickOnEntryOffers();
        return this;
    }

    @Step("The user clicks on the header Buy used Real State")
    public StepsFiltersOffers clickOnBuyUsedRealState(){
        this.methods.header.selectBuyUsedRealState();
        return this;
    }

    @Step("The user clicks on the header Buy new Real State")
    public StepsFiltersOffers clickOnBuyNewRealState(){
        this.methods.header.selectBuyNewRealState();
        return this;
    }

    @Step("The user clicks on the label projects on plans")
    public StepsFiltersOffers clickProjectsOnPlans(){
        this.methods.clickLabelProjectsOnPlans();
        return this;
    }

    @Step("The user get tittle  of the result banner")
    public StepsFiltersOffers getTittleResultBanner(String  expectedTittle){
        String text = this.methods.getTittleTextResult();
        Assert.assertEquals(text, expectedTittle);
        return  this;
    }



    @Step("The user set value on the filter cities and Hoods")
    public StepsFiltersOffers setFilterCityOrHoods(String valueFilter){
        this.methods.filterCityOrHoods(valueFilter);
        this.methods.body.randomClickOnBody();
        return this;
    }

    @Step("The user click filter combo box type of real state")
    public StepsFiltersOffers clickFilterTypeRealState(){
        this.methods.openFilterTypeRealState();
        return this;
    }

    @Step("The user select filter, type of real state (Apartment)")
    public StepsFiltersOffers setFilterTypeRealStateApartment(){
        this.methods.filterSelectTypeApartment();
        this.methods.body.randomClickOnBody();
        return this;
    }

    @Step("The user select filter, type of real state (House)")
    public StepsFiltersOffers setFilterTypeRealStateHouse(){
        this.methods.filterSelectTypeHouse();
        this.methods.body.randomClickOnBody();
        return this;
    }

    @Step("The user select filter, type of real state (Office)")
    public StepsFiltersOffers setFilterTypeRealStateOffice(){
        this.methods.filterSelectTypeOffice();
        this.methods.body.randomClickOnBody();
        return this;
    }

    @Step("The user closes the popup save search")
    public StepsFiltersOffers clickExitPopUp() {
        methods.clickExitPopUp();
        return this;
    }

    @Step("The user open select Map mode view")
    public StepsFiltersOffers clickOpenMap(){
        this.methods.clickButtonGoogleMap();
        this.methods.body.randomClickOnBody();
        return  this;
    }

    @Step("The user open a marker to extract info")
    public StepsFiltersOffers clickOnMarkerResultMap(String expectedTypeRealState){
        String[] result = this.methods.clickOnMarkerResultMap().split("-");
        String text = result[0].toLowerCase().trim();
        Assert.assertEquals(text, expectedTypeRealState);
        return this;
    }

    @Step("The user search types of real state in result card list")
    public StepsFiltersOffers searchResultRealStateExist(String[] typeRealState){
        boolean result =  this.methods.searchTypesOfRealStatesResult(typeRealState);
        Assert.assertTrue(result);
        return  this;
    }


}
