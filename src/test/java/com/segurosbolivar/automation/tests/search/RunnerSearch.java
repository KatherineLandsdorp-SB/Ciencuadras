package com.segurosbolivar.automation.tests.search;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RunnerSearch extends Hooks {
    ThreadLocal<StepsSearch> steps = ThreadLocal.withInitial(StepsSearch::new);

    @Test(priority = 3, groups = {"smoke"})
    public void successSearchCode() {

        try {
            steps.get()
                    .clickLogo()
                    .searchCode();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }
    }


    //Rent
    @Test(priority = 3, groups = {"sanity"})
    public void searchForCity() throws InterruptedException {

        try {
            steps.get()
                    .clickOnRent()
                    .searchPropertyForRent();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }

    }

    @Test(priority = 3, groups = {"smoke"})
    public void searchForBarrio() throws InterruptedException {
        try {
            steps.get()
                    .clickOnRent()
                    .searchPropertyForNeighborhood();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }
    }

    @Test(priority = 3, groups = {"smoke"})
    public void searchForSector() throws InterruptedException {

        try {
            steps.get()
                    .clickOnRent()
                    .searchPropertyForSector();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }
    }

    @Test(priority = 3, groups = {"smoke"})
    public void searchfilterRent() throws InterruptedException {
        try {
            steps.get()
                    .clickOnRent()
                    .filterDealRent();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }

    }

    @Test(priority = 3, groups = {"smoke"})
    public void searchfilterBuyNew() throws InterruptedException {

        try {
            steps.get()
                    .clickOnRent()
                    .filterDealBuyRent();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }

    }

    @Test(priority = 3, groups = {"smoke"})
    public void searchfilterBuyUsed() throws InterruptedException {


        try {
            steps.get()
                    .clickOnRent()
                    .filterDealBuyUsed();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }

    }


    @Test(priority = 3, groups = {"smoke"})
    public void searchTypePropertyRent() throws InterruptedException {

        try {
            steps.get()
                    .clickOnRent()
                    .filterPropertyTypeRent();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }

    }

    @Test(priority = 4, groups = {"smoke"})
    public void searchTypePropertyStudioAparment() throws InterruptedException {
        try {
            steps.get()
                    .clickOnRent()
                    .filterPropertyTypeStudioAparment();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }
    }

    @Test(priority = 4, groups = {"smoke"})
    public void searchTypePropertyHome() throws InterruptedException {
        try {
            steps.get()
                    .clickOnRent()
                    .filterPropertyTypeHome();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }

    }

    @Test(priority = 4, groups = {"smoke"})
    public void searchTypePropertyLocal() throws InterruptedException {
        try {
            steps.get()
                    .clickOnRent()
                    .filterPropertyTypeLocal();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }

    }
}