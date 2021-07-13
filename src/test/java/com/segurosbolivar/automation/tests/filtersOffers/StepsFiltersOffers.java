package com.segurosbolivar.automation.tests.filtersOffers;

import com.segurosbolivar.automation.commonslocal.BaseComponent;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import org.testng.Assert;

public class StepsFiltersOffers extends BaseComponent {

    public StepsFiltersOffers(JSONObject json){
        super(json);
    }

    @Step("The user clicks on the header label Offers ")
    public StepsFiltersOffers clickOnEntryOffers(){
        this.header.clickOnEntryOffers();
        return this;
    }

    @Step("The user clicks on the header Buy used Real State")
    public StepsFiltersOffers clickOnBuyUsedRealState(){
        this.header.selectBuyUsedRealState();
        return this;
    }

    @Step("The user clicks on the header Buy new Real State")
    public StepsFiltersOffers clickOnBuyNewRealState(){
        this.header.selectBuyNewRealState();
        return this;
    }

    @Step("The user clicks on the label projects on plans")
    public StepsFiltersOffers clickProjectsOnPlans(){
        this.methods.waitForPageLoad();
        this.methods.waitElementExplicitTime("labelProjectOnPlans",5);
        this.methods.clickElementJs("labelProjectOnPlans");
        this.methods.waitForPageLoad();
        return this;
    }

    @Step("The user get tittle  of the result banner")
    public StepsFiltersOffers getTittleResultBanner(String  expectedTittle){
        String text = "";
        this.methods.waitingForElement("tittleBannerResult",10);
        text = this.methods.getEntity("tittleBannerResult").getText();
        Assert.assertEquals(text, expectedTittle);
        return  this;
    }

    @Step("The user set value on the filter cities and Hoods")
    public StepsFiltersOffers setFilterCityOrHoods(String valueFilter){
        this.filters.filterCityOrHoods(valueFilter);
        return this;
    }

    @Step("The user click filter combo box type of real state")
    public StepsFiltersOffers clickFilterTypeRealState(){
        this.filters.openFilterTypeRealState();
        return this;
    }

    @Step("The user select filter, type of real state (Apartment)")
    public StepsFiltersOffers setFilterTypeRealStateApartment(){
        this.filters.filterSelectTypeApartment();
        return this;
    }

    @Step("The user select filter, type of real state (House)")
    public StepsFiltersOffers setFilterTypeRealStateHouse(){
        this.filters.filterSelectTypeHouse();
        return this;
    }

    @Step("The user select filter, type of real state (Office)")
    public StepsFiltersOffers setFilterTypeRealStateOffice(){
        this.filters.filterSelectTypeOffice();

        return this;
    }

    @Step("The user closes the popup save search")
    public StepsFiltersOffers clickExitPopUp() {
        this.filters.clickExitPopUp();
        this.body.randomClickOnBody();
        return this;
    }

    @Step("The user open select Map mode view")
    public StepsFiltersOffers clickOpenMap(){
        this.filters.clickButtonGoogleMap();
        return  this;
    }

    @Step("The user open a marker to extract info")
    public StepsFiltersOffers clickOnMarkerResultMap(String expectedTypeRealState){
        String[] result = this.filters.clickOnMarkerResultMap().split("-");
        String text = result[0].toLowerCase().trim();
        Assert.assertEquals(text, expectedTypeRealState);
        return this;
    }

    @Step("The user search types of real state in result card list")
    public StepsFiltersOffers searchResultRealStateExist(String[] typeRealState){
        boolean result =  this.filters.searchTypesOfRealStatesResult(typeRealState);
        Assert.assertTrue(result);
        return  this;
    }

    @Step("The user order results by square lower to higher")
    public StepsFiltersOffers clickOrderBySquareLowerToHigher(){
    this.filters.setOrderBySquareLowerToHigher();
    return this;
    }

    @Step("The user verify order results offers is correct Lower To Higher")
    public StepsFiltersOffers verifyOrderBySquareLowerToHigher(){
        boolean isCorrectOrder  = this.filters.isOrderBySquareLowerToHigher();
        Assert.assertTrue(isCorrectOrder);
        return this;
    }

    @Step("The user order results by square  higher to lower")
    public StepsFiltersOffers clickOrderBySquareHigherToLower(){
        this.filters.setOrderBySquareHigherToLower();
        return this;
    }

    @Step("The user verify order results offers is correct higher to lower")
    public StepsFiltersOffers verifyOrderBySquareHigherToLower(){
        boolean isCorrectOrder  = this.filters.isOrderBySquareHigherToLower();
        Assert.assertTrue(isCorrectOrder);
        return this;
    }

    @Step("The user set One bedroom in the filters search")
    public  StepsFiltersOffers setOneBedRoomFilter(){
        this.filters.setOneBedroomFilter();
        return this;
    }

    @Step("The user set three bathrooms in the filter search")
    public StepsFiltersOffers setThreeBathRoomsFilter(){
        this.filters.setThreeBathroomsFilter();
        return  this;
    }

    @Step("The user set one parking in the filters search")
    public  StepsFiltersOffers setOneParkingFilter(){
        this.filters.setOneParkingFilter();
        return  this;
    }

    @Step("The user set a max value price int the filters search ")
    public StepsFiltersOffers setMaxValuePriceOfferFilter(String value){
        this.filters.setMaxValuePriceOffers(value);
        return  this;
    }

    @Step("The user save his search with a name")
    public StepsFiltersOffers saveSearchFilter(String nameSearch){
        this.filters.saveSearchFilter(nameSearch);
        return  this;
    }

    @Step("The system request log in to save search filter")
    public StepsFiltersOffers isSystemRequestLogIn(){
        boolean isLogInPresent = this.methods.visibleElement("panelLoginPopUp",50);
        Assert.assertTrue(isLogInPresent);
        return  this;
    }


}
