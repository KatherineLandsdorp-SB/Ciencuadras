package com.segurosbolivar.automation.commonslocal.layout;

import com.segurosbolivar.automation.commons.Methods;

public class Header {

    private Methods methods = new Methods();

    public void clickOnEntryLoginAllied(){
        methods.waitForPageLoad();
        methods.waitingForElement("sigInMenu",10);
        methods.clickElementJs("sigInMenu");
        methods.waitingForElement("alliedSigInMenu",10);
        methods.clickElementJs("alliedSigInMenu");
        methods.waitingForElement("popupSigInAllied",10);
    }

    public void clickOnEntry(){
        methods.waitForPageLoad();
        methods.waitingForElement("headPerson", 5);
        methods.clickElement("headPerson");
    }

    public void clickOnEntryOffers(){
        methods.waitForPageLoad();
        methods.waitingForElement("entryOffersView", 5);
        methods.clickElement("entryOffersView");
    }


    public void selectBuyRealState(){
        methods.waitingForElement("labelBuyRealState", 5);
        methods.clickElement("labelBuyRealState");
        methods.waitForPageLoad();
    }


    public void selectRentRealState(){
        methods.waitingForElement("labelRentRealState", 5);
        methods.clickElement("labelRentRealState");
        methods.waitForPageLoad();
    }
}
