package com.segurosbolivar.automation.tests.suite1Login;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RunnerSuite1Login extends Hooks {

    ThreadLocal<StepsSuite1Login> steps = ThreadLocal.withInitial(StepsSuite1Login::new);

    @Test(
            suiteName = "SUITE1",
            testName = "LOGIN_TRANSVERSAL FULL LOGIN",
            description = "CASO3",
            priority = 2
    )
    public void suite1Caso3successfullLogin() {
        try {
            steps.get()
                    .clickEntry()
                    .clickLoginPerson()
                    .fillAll();

        } catch (Exception ex) {

            Assert.fail(ex.getMessage());

        }
    }

    @Test(
            suiteName = "SUITE1",
            testName = "LOGIN_TRANSVERSAL FAIL LOGIN",
            description = "CASO4",
            priority = 2
    )
    public void suite1Caso4failLogin() {

        try {
            steps.get()
                    .clickEntry()
                    .clickLoginPerson()
                    .fillFail();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }

    }

    @Test(
            suiteName = "SUITE1",
            testName = "LOGIN_TRANSVERSAL REMEMBER LOGIN",
            description = "CASO5",
            priority = 2
    )
    public void suite1Caso5loginRemember() {

        try {

            steps.get()
                    .clickEntry()
                    .clickLoginPerson()
                    .clickRemember()
                    .fillAll();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        }

    }
}