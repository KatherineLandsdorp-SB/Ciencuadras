package com.segurosbolivar.automation.tests.search;

import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.commons.utils.PropertyManager;
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
            driver.get(PropertyManager.getConfigValueByKey("url"));
            steps.get()
                    .searchCode();
            driver.quit();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
}