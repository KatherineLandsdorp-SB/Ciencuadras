package com.segurosbolivar.automation.commonslocal.layout;
import com.segurosbolivar.automation.commons.methods.web.WebGlobalMethods;

public class Header {

    private WebGlobalMethods methods;

    public Header(WebGlobalMethods methods) {
        this.methods = methods;
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


    public void selectBuyUsedRealState(){
        methods.waitingForElement("labelBuyUsedRealState", 5);
        methods.clickElement("labelBuyUsedRealState");
        methods.waitForPageLoad();
    }

    public void selectBuyNewRealState(){
        methods.waitingForElement("labelBuyNewRealState", 5);
        methods.clickElement("labelBuyNewRealState");
        methods.waitForPageLoad();
    }


    public void selectRentRealState(){
        methods.waitingForElement("labelRentRealState", 5);
        methods.clickElement("labelRentRealState");
        methods.waitForPageLoad();
    }

    public void selectTools(){
        methods.waitingForElement("labelToolsHeader",5);
        methods.clickElementJs("labelToolsHeader");
        methods.waitForPageLoad();
    }

    public void selectFromExterior(){
        methods.waitingForElement("labelFromExteriorHeader",5);
        methods.clickElement("labelFromExteriorHeader");
        methods.waitForPageLoad();
    }

    public void selectBlog(){
        methods.waitingForElement("labelBlogHeader",5);
        methods.clickElement("labelBlogHeader");
        methods.waitForPageLoad();
    }

    public void selectRealState(){
        methods.waitingForElement("labelAlliedHeader",5);
        methods.clickElement("labelAlliedHeader");
        methods.waitingForElement("labelRealStateHeader",5);
        methods.clickElement("labelRealStateHeader");
        methods.waitForPageLoad();
    }

    public void selectBuilders(){
        methods.waitingForElement("labelAlliedHeader",5);
        methods.clickElement("labelAlliedHeader");
        methods.waitingForElement("labelBuildersHeader",5);
        methods.clickElement("labelBuildersHeader");
        methods.waitForPageLoad();
    }



}
