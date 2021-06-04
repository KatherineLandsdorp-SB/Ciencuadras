package com.segurosbolivar.automation.tests.offers;

import com.segurosbolivar.automation.tests.login.StepsLogin;
import io.qameta.allure.Step;
import org.testng.Assert;

public class StepsOffers {

    private  MethodsOffers methods = new MethodsOffers();

    @Step("The user clicks on the header label Offers ")
    public StepsOffers clickOnEntryOffers(){
        this.methods.header.clickOnEntryOffers();
        return this;
    }

    @Step("The user clicks on the header Buy used Real State")
    public  StepsOffers clickOnBuyUsedRealState(){
        this.methods.header.selectBuyUsedRealState();
        return this;
    }

    @Step("The user clicks on the header Buy new Real State")
    public  StepsOffers clickOnBuyNewRealState(){
        this.methods.header.selectBuyNewRealState();
        return this;
    }

    @Step("The user clicks on the label projects on plans")
    public StepsOffers clickProjectsOnPlans(){
        this.methods.clickLabelProjectsOnPlans();
        return this;
    }

    @Step("The user get tittle  of the result banner")
    public  StepsOffers getTittleResultBanner( String  expectedTittle){
        String text = this.methods.getTittleTextResult();
        Assert.assertEquals(text, expectedTittle);
        return  this;
    }



    @Step("The user set value on the filter cities and Hoods")
    public  StepsOffers setFilterCityOrHoods(String valueFilter){
        this.methods.filterCityOrHoods(valueFilter);
        this.methods.body.randomClickOnBody();
        return this;
    }

    @Step("The user click filter combo box type of real state")
    public StepsOffers clickFilterTypeRealState(){
        this.methods.openFilterTypeRealState();
        return this;
    }

    @Step("The user select filter, type of real state (Apartment)")
    public  StepsOffers setFilterTypeRealStateApartment(){
        this.methods.filterSelectTypeApartment();
        this.methods.body.randomClickOnBody();
        return this;
    }

    @Step("The user closes the popup save search")
    public StepsOffers clickExitPopUp() {
        methods.clickExitPopUp();
        return this;
    }

    @Step("The user open select Map mode view")
    public StepsOffers clickOpenMap(){
        this.methods.clickButtonGoogleMap();
        this.methods.body.randomClickOnBody();
        return  this;
    }

    @Step("The user open a marker to extract info")
    public StepsOffers clickOnMarkerResultMap(String expectedTypeRealState){
        String[] result = this.methods.clickOnMarkerResultMap().split("-");
        String text = result[0].toLowerCase().trim();
        Assert.assertEquals(text, expectedTypeRealState);
        return this;
    }




}
