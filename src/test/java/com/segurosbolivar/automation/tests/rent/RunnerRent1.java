package com.segurosbolivar.automation.tests.rent;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.annotations.Test;

public class RunnerRent1 extends Hooks {
    ThreadLocal<StepsRent> steps = ThreadLocal.withInitial(StepsRent::new);

    @Test(priority = 1, groups = {"smoke"})
    public void searchTypePropertyRent() throws InterruptedException {
        steps.get()
                .clickOnRent()
                .filterPropertyTypeRent();
    }
    @Test(priority = 1, groups = {"smoke"})
    public void searchTypePropertyStudioAparment() throws InterruptedException {
        steps.get()
                .clickOnRent()
                .filterPropertyTypeStudioAparment();
    }
    @Test(priority = 1, groups = {"smoke"})
    public void searchTypePropertyHome() throws InterruptedException {
        steps.get()
                .clickOnRent()
                .filterPropertyTypeHome();
    }

    @Test(priority = 1, groups = {"smoke"})
    public void searchTypePropertyLocal() throws InterruptedException {
        steps.get()
                .clickOnRent()
                .filterPropertyTypeLocal();
    }

}
