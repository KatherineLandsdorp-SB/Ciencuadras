package com.segurosbolivar.automation.tests.search;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RunnerSearch extends Hooks {
    ThreadLocal<StepsSearch> steps = ThreadLocal.withInitial(StepsSearch::new);

    @Test(
            priority = 1,
            testName = "36",
            description = "Validación login transversal"
    )
    public void searchCode(){
        try {
            steps.get()
                    .searchCode("183150-1440107");
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test(
            priority = 1,
            testName = "36",
            description = "Validación login transversal"
    )
    public void searchCodeFail(){
        try {
            steps.get()
                    .searchCode("183150-1411100");
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
}