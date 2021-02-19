package com.segurosbolivar.automation.tests.suite1Login;

import com.segurosbolivar.automation.commons.Hooks;
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
        steps.get()
                .clickEntry()
                .clickLoginPerson()
                .fillAll();
    }

    @Test(
            suiteName = "SUITE1",
            testName = "LOGIN_TRANSVERSAL FAIL LOGIN",
            description = "CASO4",
            priority = 2
    )
    public void suite1Caso4failLogin() {
        steps.get()
                .clickEntry()
                .clickLoginPerson()
                .fillFail();
    }

    @Test(
            suiteName = "SUITE1",
            testName = "LOGIN_TRANSVERSAL REMEMBER LOGIN",
            description = "CASO5",
            priority = 2
    )
    public void suite1Caso5loginRemember() {
        steps.get()
                .clickEntry()
                .clickLoginPerson()
                .clickRemember()
                .fillAll();
    }
}