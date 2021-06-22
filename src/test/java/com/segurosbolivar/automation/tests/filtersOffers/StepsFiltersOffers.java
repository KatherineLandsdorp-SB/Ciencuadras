package com.segurosbolivar.automation.tests.filtersOffers;

import io.qameta.allure.Step;
import com.segurosbolivar.automation.commonslocal.BaseComponent;
import org.testng.Assert;

public class StepsFiltersOffers extends BaseComponent {

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
        this.filters.filterCityOrHoods(valueFilter);
        this.methods.body.randomClickOnBody();
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
        this.methods.body.randomClickOnBody();
        return this;
    }

    @Step("The user select filter, type of real state (House)")
    public StepsFiltersOffers setFilterTypeRealStateHouse(){
        this.filters.filterSelectTypeHouse();
        this.methods.body.randomClickOnBody();
        return this;
    }

    @Step("The user select filter, type of real state (Office)")
    public StepsFiltersOffers setFilterTypeRealStateOffice(){
        this.filters.filterSelectTypeOffice();
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
        this.filters.clickButtonGoogleMap();
        this.methods.body.randomClickOnBody();
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

}
