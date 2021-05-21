package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
public class RunnerLogin extends Hooks {
    ThreadLocal<StepsLogin> steps = ThreadLocal.withInitial(StepsLogin::new);
    @Test(
            priority = 1,
            suiteName = "SUITE1",
            testName = "18",
            description = "Validación tipo de pagina personas"
    )
    public void login() {
        try {
            steps.get()
                    .clickExitPopUp()
                    .clickEntry()
                    .clickEnterButton()
                    .fillAll(data.getField("mail"), data.getField("password"));
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
}