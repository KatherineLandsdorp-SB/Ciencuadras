package com.segurosbolivar.automation.commonslocal.layout;

import com.segurosbolivar.automation.commons.methods.web.WebGlobalMethods;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Filters {
    private WebGlobalMethods methods;

    public  Filters(WebGlobalMethods methods){
        this.methods = methods;
    }

    public void filterCityOrHoods(String filterValue) {
        methods.waitForPageLoad();
        methods.waitingForElement("filterByCityOrHoods", 5);
        methods.sendKeysTextJs("filterByCityOrHoods", filterValue);
        methods.waitingForElement("searchByCityOrHoods", 10);
        methods.clickElementJs("searchByCityOrHoods");
        methods.waitForPageLoad();
    }


    public void filterSelectTypeApartment() {
        methods.waitingForElement("checkBoxApartment", 5);
        methods.clickElement("checkBoxApartment");
        methods.waitForPageLoad();
    }

    public void filterSelectTypeHouse() {
        methods.waitingForElement("checkBoxHouse", 5);
        methods.clickElement("checkBoxHouse");
        methods.waitForPageLoad();
    }

    public void filterSelectTypeOffice() {
        methods.waitElementExplicitTime("checkBoxOffice", 5);
        methods.clickElementJs("checkBoxOffice");
        methods.waitForPageLoad();
    }


    public void clickButtonGoogleMap() {
        this.methods.waitElementExplicitTime("buttonMap", 10);
        this.methods.clickElementAction("buttonMap");
    }


    public void openFilterTypeRealState() {
        methods.waitForPageLoad();
        methods.waitingForElement("filterCheckBoxRealState", 5);
        methods.clickElementJs("filterCheckBoxRealState");
    }


    public void clickExitPopUp(){
        boolean hidden = methods.visibleElement("exitPopupSaveSearch",20);
        if(hidden!=false){
            methods.waitingForElement("exitPopupSaveSearch",5);
            methods.clickElementJs("exitPopupSaveSearch");
        }
    }


    public  void  setOneBedroomFilter(){
            this.methods.waitingForElement("filterOneBedroom",3);
            this.methods.clickElementJs("filterOneBedroom");
            this.methods.waitForPageLoad();
    }

    public void setThreeBathroomsFilter(){
        this.methods.waitingForElement("filterThreeBathrooms",3);
        this.methods.clickElementJs("filterThreeBathrooms");
        this.methods.waitForPageLoad();
    }

    public void setOneParkingFilter(){
        this.methods.waitingForElement("filterOneParking",3);
        this.methods.clickElementJs("filterOneParking");
        this.methods.waitForPageLoad();
    }

    public void setMaxValuePriceOffers(String value){
        this.methods.waitingForElement("filterMaxPriceValueOffer",3);
        this.methods.sendKeysTextJsAndPressEnter("filterMaxPriceValueOffer",value);
        this.methods.waitForPageLoad();
    }

    private void clickOnSaveSearchFilter(){
        this.methods.waitingForElement("buttonSaveSearchFilter",3);
        this.methods.clickElementJs("buttonSaveSearchFilter");
    }




}
