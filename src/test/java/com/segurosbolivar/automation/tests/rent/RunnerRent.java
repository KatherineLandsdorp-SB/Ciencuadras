package com.segurosbolivar.automation.tests.rent;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.annotations.Test;

public class RunnerRent extends Hooks {
    ThreadLocal<StepsRent> steps = ThreadLocal.withInitial(StepsRent::new);

    @Test(priority = 1, groups = {"smoke"})
    public void searchForCity() throws InterruptedException {
        steps.get()
                .clickOnRent()
                .searchPropertyForRent();

    }

    @Test(priority = 1, groups = {"smoke"})
    public void searchForBarrio() throws InterruptedException {
        steps.get()
                .clickOnRent()
                .searchPropertyForNeighborhood();

    }

    @Test(priority = 1, groups = {"smoke"})
    public void searchForSector() throws InterruptedException {
        steps.get()
                .clickOnRent()
                .searchPropertyForSector();

    }

    @Test(priority = 1, groups = {"smoke"})
    public void searchfilterRent() throws InterruptedException {
        steps.get()
                .clickOnRent()
                .filterDealRent();
    }

    @Test(priority = 1, groups = {"smoke"})
    public void searchfilterBuyNew() throws InterruptedException {
        steps.get()
                .clickOnRent()
                .filterDealBuyRent();
    }

    @Test(priority = 1, groups = {"smoke"})
    public void searchfilterBuyUsed() throws InterruptedException {
        steps.get()
                .clickOnRent()
                .filterDealBuyUsed();
    }


}
