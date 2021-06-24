package com.segurosbolivar.automation.commonslocal.layout;

import com.segurosbolivar.automation.commons.Methods;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Filters {
    private Methods methods = new Methods();

    public void filterCityOrHoods(String filterValue) {
        methods.waitForPageLoad();
        methods.waitingForElement("filterByCityOrHoods", 5);
        methods.sendKeysTextJs("filterByCityOrHoods", filterValue);
        methods.waitingForElement("searchByCityOrHoods", 10);
        methods.clickElementJs("searchByCityOrHoods");
        methods.waitForPageLoad();
    }

    public boolean searchTypesOfRealStatesResult(String[] typesRealState) {
        Map<String, Integer> table = new HashMap<String, Integer>(typesRealState.length);
        for (String key : typesRealState) {
            table.put(key, 0);
        }
        LinkedList<WebElement> elementos = new LinkedList<>(this.methods.getEntities("tittlesCardResultSearch"));

        while (elementos.size() > 0) {
            WebElement tmpElement = elementos.pop();
            String textElement = tmpElement.getText().toLowerCase();
            String key = textElement.split(" ")[0].trim();
            if (table.containsKey(key)) {
                int value = table.get(key) + 1;
                table.replace(key, value);
            } else {
                return false;
            }
        }

        if (table.values().contains(0)) {
            return false;
        } else {
            return true;
        }

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
        methods.clickElement("checkBoxOffice");
        methods.waitForPageLoad();
    }


    public void clickButtonGoogleMap() {
        this.methods.waitElementExplicitTime("buttonMap", 10);
        this.methods.clickElementAction("buttonMap");
    }


    public String clickOnMarkerResultMap() {
        this.methods.waitForPageLoad();
        String text = "";
        if (this.methods.visibleElement("mapCanva", 60)) {
            this.methods.waitingForElement("markerMapResult", 20);
            this.methods.clickElementJs("markerMapResult");
            this.methods.waitingForElement("tittleInfoMarker", 5);
            text = this.methods.getEntity("tittleInfoMarker").getText();
        }
        return text;
    }

    public void openFilterTypeRealState() {
        methods.waitForPageLoad();
        methods.waitingForElement("filterCheckBoxRealState", 3);
        methods.clickElementJs("filterCheckBoxRealState");
    }

    private void openFilterOrderBy() {
        methods.waitingForElement("filterCheckBoxOrderBy", 3);
        methods.clickElementJs("filterCheckBoxOrderBy");
    }

    public void setOrderBySquareLowerToHigher() {
        openFilterOrderBy();
        methods.waitingForElement("elementSquareLowerToHigher", 3);
        methods.clickElementJs("elementSquareLowerToHigher");
    }

    public boolean isOrderBySquareLowerToHigher() {
        this.methods.waitForPageLoad();
        LinkedList<WebElement> elementos = new LinkedList<>(this.methods.getEntities("squareCardResultSearch"));
        double auxValue = 0;
        while (elementos.isEmpty() == false) {
            WebElement tmpElement = elementos.removeFirst();
            String textElement = tmpElement.getText().toLowerCase();
            double key = Double.valueOf(textElement.trim().split(" ")[0].trim());
            if (key >= auxValue || auxValue == 0) {
                auxValue = key;
            } else {
                elementos = null;
                return false;
            }
        }
        return true;
    }

    public void setOrderBySquareHigherToLower() {
        openFilterOrderBy();
        methods.waitingForElement("elementSquareHigherToLower", 3);
        methods.clickElementJs("elementSquareHigherToLower");
    }

    public boolean isOrderBySquareHigherToLower() {
        this.methods.waitForPageLoad();
        LinkedList<WebElement> elementos = new LinkedList<>(this.methods.getEntities("squareCardResultSearch"));
        double auxValue = 0;
        while (elementos.isEmpty() == false) {
            WebElement tmpElement = elementos.removeFirst();
            String textElement = tmpElement.getText().toLowerCase();
            double key = Double.valueOf(textElement.trim().split(" ")[0].trim());
            if (key <= auxValue  || auxValue == 0) {
                auxValue = key;
            } else {
                elementos = null;
                return false;
            }
        }

        return true;
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

    public void  saveSearchFilter(String nameSearch){
        clickOnSaveSearchFilter();
        boolean hidden = methods.visibleElement("fieldTextSaveSearchFilter",30);
        if(hidden!=false){
           this.methods.sendKeysTextJs("fieldTextSaveSearchFilter", nameSearch);
           this.methods.clickElementJs("buttonPopupSaveSearchFilter");
        }


    }


}
