package com.segurosbolivar.automation.tests.registertest;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.annotations.Test;

public class RunnerRegisterTest extends Hooks {
    ThreadLocal<StepsRegisterTest> steps = ThreadLocal.withInitial(StepsRegisterTest::new);

    @Test(priority = 1, groups = {"smoke"})
    public void successfullRegister() {
        steps.get()
                .clickEntry()
                .clickRegister()
                .fillAll();
    }

}
