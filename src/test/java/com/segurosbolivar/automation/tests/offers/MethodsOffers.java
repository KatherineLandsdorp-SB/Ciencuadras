package com.segurosbolivar.automation.tests.offers;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.commonslocal.BaseComponent;
import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.WebElement;

import java.util.*;

public class MethodsOffers extends BaseComponent {

    private Methods methods = new Methods();

    public void clickExitPopUp(){
        boolean hidden = methods.visibleElement("exitPopupSaveSearch",15);
        if(hidden!=false){
            methods.waitingForElement("exitPopupSaveSearch",10);
            methods.clickElementJs("exitPopupSaveSearch");
        }
    }



    public void filterCityOrHoods(String filterValue){
        methods.waitForPageLoad();
        methods.waitingForElement("filterByCityOrHoods",5);
        methods.sendKeysTextJs("filterByCityOrHoods", filterValue);
        methods.waitingForElement("searchByCityOrHoods",10);
        methods.clickElementJs("searchByCityOrHoods");
        methods.waitForPageLoad();
    }

    public void openFilterTypeRealState(){
        methods.waitForPageLoad();
        methods.waitingForElement("filterCheckBoxRealState",5);
        methods.clickElementJs("filterCheckBoxRealState");

    }

    public void filterSelectTypeApartment(){
        methods.waitingForElement("checkBoxApartment",5);
        methods.clickElement("checkBoxApartment");
        methods.waitForPageLoad();
    }

    public void filterSelectTypeHouse(){
     methods.waitingForElement("checkBoxHouse",5);
     methods.clickElement("checkBoxHouse");
     methods.waitForPageLoad();
    }

    public void filterSelectTypeOffice(){
     methods.waitElementExplicitTime("checkBoxOffice",5);
     methods.clickElement("checkBoxOffice");
     methods.waitForPageLoad();
    }


    public void clickButtonGoogleMap(){
    this.methods.waitElementExplicitTime("buttonMap",10);
    this.methods.clickElementAction("buttonMap");
    }

    public void clickLabelProjectsOnPlans(){
    this.methods.waitForPageLoad();
    this.methods.waitElementExplicitTime("labelProjectOnPlans",5);
    this.methods.clickElementJs("labelProjectOnPlans");
    this.methods.waitForPageLoad();
    }

    public String getTittleTextResult(){
        String text = "";
        this.methods.waitingForElement("tittleBannerResult",10);
        text = this.methods.getEntity("tittleBannerResult").getText();
        return text;
    }

    public String clickOnMarkerResultMap(){
        this.methods.waitForPageLoad();
        String text = "";
        if(this.methods.visibleElement("mapCanva",60)){
            this.methods.waitingForElement("markerMapResult",20);
            this.methods.clickElementJs("markerMapResult");
            this.methods.waitingForElement("tittleInfoMarker",5);
            text = this.methods.getEntity("tittleInfoMarker").getText();
        }
        return text;
    }


    public boolean searchTypesOfRealStatesResult(String[] typesRealState){
        Map<String, Integer> table = new HashMap<String,Integer>(typesRealState.length);
        for (String key: typesRealState) {
            table.put(key,0);
        }
        LinkedList<WebElement> elementos = new LinkedList<>(this.methods.getEntities("tittlesCardResultSearch"));

        while (elementos.size()>0){
            WebElement tmpElement = elementos.pop();
            String textElement = tmpElement.getText().toLowerCase();
            String key = textElement.split(" ")[0].trim();
            if(table.containsKey(key)){
                int value = table.get(key) + 1;
                table.replace(key, value);
            }else{
                return false;
            }
        }

        if(table.values().contains(0)){
            return false;
        }else {
            return true;
        }

    }









}
