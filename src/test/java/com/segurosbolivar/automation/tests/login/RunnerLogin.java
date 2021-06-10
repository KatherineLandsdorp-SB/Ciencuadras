package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.commons.utils.PropertyManager;
import org.testng.Assert;
import org.testng.annotations.Test;
public class RunnerLogin extends Hooks {
    ThreadLocal<StepsLogin> steps = ThreadLocal.withInitial(StepsLogin::new);

    @Test(
            priority = 1,
            testName = "36",
            description = "Validación login transversal"
    )
    public void loginTransversal(){
        try {
            driver.get(PropertyManager.getConfigValueByKey("url"));
            steps.get()
                    .clickEntry()
                    .clickEnterButton()
                    .fillAll(data.getField("mail"), data.getField("password"));
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }


}