package com.segurosbolivar.automation.tests.search;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RunnerSearch extends Hooks {
    ThreadLocal<StepsSearch> steps= ThreadLocal.withInitial(StepsSearch::new);

    @Test(priority=3, groups = { "smoke" })
    public void successSearchCode(){
        steps.get()
                .clickLogo()
                .searchCode();
    }



    //Rent
    @Test(priority = 3, groups = {"sanity"})
    public void searchForCity() throws InterruptedException {
        steps.get()
                .clickOnRent()
                .searchPropertyForRent();

    }

    @Test(priority = 3, groups = {"smoke"})
    public void searchForBarrio() throws InterruptedException {
        steps.get()
                .clickOnRent()
                .searchPropertyForNeighborhood();

    }

    @Test(priority = 3, groups = {"smoke"})
    public void searchForSector() throws InterruptedException {
        steps.get()
                .clickOnRent()
                .searchPropertyForSector();

    }

    @Test(priority = 3, groups = {"smoke"})
    public void searchfilterRent() throws InterruptedException {
        steps.get()
                .clickOnRent()
                .filterDealRent();
    }

    @Test(priority = 3, groups = {"smoke"})
    public void searchfilterBuyNew() throws InterruptedException {
        steps.get()
                .clickOnRent()
                .filterDealBuyRent();
    }

    @Test(priority = 3, groups = {"smoke"})
    public void searchfilterBuyUsed() throws InterruptedException {
        steps.get()
                .clickOnRent()
                .filterDealBuyUsed();
    }


    @Test(priority = 3, groups = {"smoke"})
    public void searchTypePropertyRent() throws InterruptedException {
        steps.get()
                .clickOnRent()
                .filterPropertyTypeRent();
    }
    @Test(priority = 4, groups = {"smoke"})
    public void searchTypePropertyStudioAparment() throws InterruptedException {
        steps.get()
                .clickOnRent()
                .filterPropertyTypeStudioAparment();
    }
    @Test(priority = 4, groups = {"smoke"})
    public void searchTypePropertyHome() throws InterruptedException {
        steps.get()
                .clickOnRent()
                .filterPropertyTypeHome();
    }

    @Test(priority = 4, groups = {"smoke"})
    public void searchTypePropertyLocal() throws InterruptedException {
        steps.get()
                .clickOnRent()
                .filterPropertyTypeLocal();
    }


}