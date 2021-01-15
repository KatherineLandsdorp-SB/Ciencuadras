package com.segurosbolivar.automation.tests.rent;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.tests.shared.SharedMethods;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class StepsRent extends BaseTest {
    private MethodsRent methodsRent = new MethodsRent();
    private SharedMethods methods = new SharedMethods();


    @Step("The user to do click on rent")
    public StepsRent clickOnRent() {
        methodsRent.clickOnRent();
        return this;
    }

    @Step("The user search property for city")
    public StepsRent searchPropertyForRent() throws InterruptedException {
        assertEquals(methodsRent.searchPropertyForCity(), services.getField("textSearchCity"));
        System.out.println("texto en paso" + services.getField("textSearchCity"));
        return this;
    }

    @Step("The user search property for neighborhood")
    public StepsRent searchPropertyForNeighborhood() throws InterruptedException {
        assertEquals(methodsRent.searchPropertyForNeighborhood(), services.getField("textSearchNeihborhood"));
        return this;
    }

    @Step("The user search property for Sector")
    public StepsRent searchPropertyForSector() throws InterruptedException {
        assertEquals(methodsRent.searchPropertyForSector(), services.getField("textSearchSector"));
        return this;
    }

    @Step("The user search property for rent")
    public StepsRent filterDealRent() throws InterruptedException {
        assertEquals(methodsRent.filterTypeDealRent(), services.getField("textSearchRent"));
        return this;
    }

    @Step("The user search property for buy new")
    public StepsRent filterDealBuyRent() throws InterruptedException {
        assertEquals(methodsRent.filterTypeDealBuyNew(), services.getField("textBuyNew"));
        return this;
    }

    @Step("The user search property for buy new")
    public StepsRent filterDealBuyUsed() throws InterruptedException {
        assertEquals(methodsRent.filterTypeDealBuyUsed(), services.getField("textBuyUsed"));
        return this;
    }
    @Step("The user search property type rent")
    public StepsRent filterPropertyTypeRent() throws InterruptedException {
        assertEquals(methodsRent.filterPropertyTypeRent(), services.getField("textCheckRent"));
        return this;
    }
    @Step("The user search property type studio aparment")
    public StepsRent filterPropertyTypeStudioAparment() throws InterruptedException {
        assertEquals(methodsRent.filterPropertyTypeStudioAparment(), services.getField("checkStudioAparment"));
        return this;
    }
    @Step("The user search property type home")
    public StepsRent filterPropertyTypeHome() throws InterruptedException {
        assertEquals(methodsRent.filterPropertyTypeHome(), services.getField("texCheckHome"));
        return this;
    }
    @Step("The user search property type home")
    public StepsRent filterPropertyTypeLocal() throws InterruptedException {
        assertEquals(methodsRent.filterPropertyTypeLocal(), services.getField("textCheckLocal"));
        return this;
    }
}
