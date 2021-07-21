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


    @Step("The user closes the popup save search")
    public StepsFiltersOffers clickExitPopUp() {
        this.filters.clickExitPopUp();
        this.body.randomClickOnBody();
        return this;
    }




}
