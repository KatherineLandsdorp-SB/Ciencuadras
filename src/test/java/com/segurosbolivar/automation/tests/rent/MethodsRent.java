package com.segurosbolivar.automation.tests.rent;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.tests.shared.SharedMethods;


public class MethodsRent extends BaseTest {
    private Methods methods = new Methods();
    private SharedMethods shared = new SharedMethods();

    public void clickOnRent() {
        methods.clickElement("rent");
    }

    public String searchPropertyForCity() throws InterruptedException {
        methods.sendKeysText("inputSeach", services.getField("cityAllied"));
        methods.keyDown("inputSeach");
        methods.waitingForElement("textSearch", 120);
        System.out.println("se muestra" + methods.getEntity("textSearch").getText());
        methods.scrollToPixel("scroll");
        methods.scrollToPixel("scroll");
        methods.scrollToPixel("scroll");
        return methods.getEntity("textSearch").getText();
    }

    public String searchPropertyForNeighborhood() throws InterruptedException {
        methods.sendKeysText("inputSeach", services.getField("neighborhood"));
        methods.waitingForElement("textSearch", 120);
        methods.keyDown("inputSeach");
        methods.scrollToPixel("scroll");
        methods.scrollToPixel("scroll");
        return methods.getEntity("textSearch").getText();
    }

    public String searchPropertyForSector() throws InterruptedException {
        methods.sendKeysText("inputSeach", services.getField("sector"));
        methods.waitingForElement("textSearch", 120);
        methods.keyDown("inputSeach");
        methods.scrollToPixel("scroll");
        return methods.getEntity("textSearch").getText();
    }

    public String filterTypeDealRent() throws InterruptedException {
        methods.clickElement("buttonDeal");
        methods.angularMaterialDrop("dropDownDeal", services.getField("li_Rent"));
        methods.pause(8);
        methods.clickElement("iconClose");
        methods.scrollToPixel("scroll");
        methods.scrollToPixel("scroll");
        return methods.getEntity("textSearch").getText();
    }

    public String filterTypeDealBuyNew() {
        methods.clickElement("buttonDeal");
        methods.angularMaterialDrop("dropDownDeal", services.getField("li_BuyNew"));
        methods.pause(8);
        methods.clickElement("iconClose");
        methods.scrollToPixel("scroll");
        methods.scrollToPixel("scroll");
        return methods.getEntity("textSearch").getText();

    }

    public String filterTypeDealBuyUsed() {
        methods.clickElement("buttonDeal");
        methods.angularMaterialDrop("dropDownDeal", services.getField("li_BuyUsed"));
        methods.pause(8);
        methods.clickElement("iconClose");
        methods.scrollToPixel("scroll");
        methods.scrollToPixel("scroll");
        return methods.getEntity("textSearch").getText();

    }
    public String  filterPropertyTypeRent(){
        methods.clickElement("buttonTypeProperty");
        methods.clickElement("checkApartment");
        methods.pause(8);
        methods.clickElement("iconClose");
        methods.scrollToPixel("scroll");
        methods.scrollToPixel("scroll");
        return methods.getEntity("textSearch").getText();

    }
    public String  filterPropertyTypeStudioAparment(){
        methods.clickElement("buttonTypeProperty");
        methods.clickElement("checkStudioApartment");
        methods.pause(8);
        methods.clickElement("iconClose");
        methods.scrollToPixel("scroll");
        methods.scrollToPixel("scroll");
        return methods.getEntity("textSearch").getText();
    }
    public String  filterPropertyTypeHome(){
        methods.clickElement("buttonTypeProperty");
        methods.clickElement("checkHome");
        methods.pause(8);
        methods.clickElement("iconClose");
        methods.scrollToPixel("scroll");
        methods.scrollToPixel("scroll");
        return methods.getEntity("textSearch").getText();
    }
    public String  filterPropertyTypeLocal(){
        methods.clickElement("buttonTypeProperty");
        methods.clickElement("checkLocal");
        methods.pause(8);
        methods.clickElement("iconClose");
        methods.scrollToPixel("scroll");
        methods.scrollToPixel("scroll");
        return methods.getEntity("textSearch").getText();
    }
    public String  filterPropertyTypeOffice(){
        methods.clickElement("buttonTypeProperty");
        methods.clickElement("checkLocal");
        methods.pause(8);
        methods.clickElement("iconClose");
        methods.scrollToPixel("scroll");
        methods.scrollToPixel("scroll");
        return methods.getEntity("textSearch").getText();
    }


}
