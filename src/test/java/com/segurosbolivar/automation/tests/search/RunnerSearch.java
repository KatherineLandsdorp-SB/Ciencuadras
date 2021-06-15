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
    public void loginTransversal(){
        try {
            steps.get()
                    .searchCode();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
}