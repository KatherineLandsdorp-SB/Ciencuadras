package com.segurosbolivar.automation.tests.search;
import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Methods;

public class MethodsSearch extends BaseTest {
    protected Methods methods = new Methods();

    public void clickLogo(){
        methods.waitForPageLoad();
        methods.waitingForElement("logo", 15);
        methods.clickElementJs("logo");

    }

    public String clickSearchCode(){
        methods.waitForPageLoad();
        methods.awaitToFindElement("searchCode", 3);
        methods.sendKeysText("searchCode", "7214-1200006");
        methods.clickElementJs("searchButton");
        methods.pause(15);
        return  methods.searchText("7214-1200006", 15);
    }



    //rent

    public void clickOnRent() {
        methods.clickElement("rent");
    }

    public String searchPropertyForCity() throws InterruptedException {
        methods.sendKeysText("inputSeach", services.getField("cityAllied"));
        methods.keyDown("inputSeach");
        methods.waitingForElement("textSearch", 120);
        methods.scrollTo("scroll");
        methods.scrollTo("scroll");
        methods.scrollTo("scroll");
        return methods.getEntity("textSearch").getText();
    }

    public String searchPropertyForNeighborhood() throws InterruptedException {
        methods.sendKeysText("inputSeach", services.getField("neighborhood"));
        methods.waitingForElement("textSearch", 120);
        methods.keyDown("inputSeach");
        methods.scrollTo("scroll");
        methods.scrollTo("scroll");
        return methods.getEntity("textSearch").getText();
    }

    public String searchPropertyForSector() throws InterruptedException {
        methods.sendKeysText("inputSeach", services.getField("sector"));
        methods.waitingForElement("textSearch", 120);
        methods.keyDown("inputSeach");
        methods.scrollTo("scroll");
        return methods.getEntity("textSearch").getText();
    }

    public String filterTypeDealRent() throws InterruptedException {
        methods.clickElement("buttonDeal");
        methods.angularMaterialDrop("dropDownDeal", services.getField("li_Rent"));
        methods.pause(8);
        methods.clickElement("iconClose");
        methods.scrollTo("scroll");
        methods.scrollTo("scroll");
        return methods.getEntity("textSearch").getText();
    }

    public String filterTypeDealBuyNew() {
        methods.clickElement("buttonDeal");
        methods.angularMaterialDrop("dropDownDeal", services.getField("li_BuyNew"));
        methods.pause(8);
        methods.clickElement("iconClose");
        methods.scrollTo("scroll");
        methods.scrollTo("scroll");
        return methods.getEntity("textSearch").getText();

    }

    public String filterTypeDealBuyUsed() {
        methods.clickElement("buttonDeal");
        methods.angularMaterialDrop("dropDownDeal", services.getField("li_BuyUsed"));
        methods.pause(8);
        methods.clickElement("iconClose");
        methods.scrollTo("scroll");
        methods.scrollTo("scroll");
        return methods.getEntity("textSearch").getText();

    }
    public String  filterPropertyTypeRent(){
        methods.clickElement("buttonTypeProperty");
        methods.clickElement("checkApartment");
        methods.pause(8);
        methods.clickElement("iconClose");
        methods.scrollTo("scroll");
        methods.scrollTo("scroll");
        return methods.getEntity("textSearch").getText();

    }
    public String  filterPropertyTypeStudioAparment(){
        methods.clickElement("buttonTypeProperty");
        methods.clickElement("checkStudioApartment");
        methods.pause(8);
        methods.clickElement("iconClose");
        methods.scrollTo("scroll");
        methods.scrollTo("scroll");
        return methods.getEntity("textSearch").getText();
    }
    public String  filterPropertyTypeHome(){
        methods.clickElement("buttonTypeProperty");
        methods.clickElement("checkHome");
        methods.pause(8);
        methods.clickElement("iconClose");
        methods.scrollTo("scroll");
        methods.scrollTo("scroll");
        return methods.getEntity("textSearch").getText();
    }
    public String  filterPropertyTypeLocal(){
        methods.clickElement("buttonTypeProperty");
        methods.clickElement("checkLocal");
        methods.pause(8);
        methods.clickElement("iconClose");
        methods.scrollTo("scroll");
        methods.scrollTo("scroll");
        return methods.getEntity("textSearch").getText();
    }
    public String  filterPropertyTypeOffice(){
        methods.clickElement("buttonTypeProperty");
        methods.clickElement("checkLocal");
        methods.pause(8);
        methods.clickElement("iconClose");
        methods.scrollTo("scroll");
        methods.scrollTo("scroll");
        return methods.getEntity("textSearch").getText();
    }


}