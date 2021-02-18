package com.segurosbolivar.automation.tests.suite1Login;

import com.segurosbolivar.automation.commons.Hooks;


import org.testng.annotations.Test;

public class RunnerSuite1Login extends Hooks {

    ThreadLocal<StepsSuite1Login> steps = ThreadLocal.withInitial(StepsSuite1Login::new);

    @Test(priority=2, description = "CASO3_LOGIN_TRANSVERSAL")
    public void suite1Caso3successfullLogin(){
        steps.get()
                .clickEntry()
                .clickLoginPerson()
                .fillAll();
    }

    @Test(priority=2, description = "CASO4_LOGIN_TRANSVERSAL")
    public void suite1Caso3failLogin(){
        steps.get()
                .clickEntry()
                .clickLoginPerson()
                .fillFail();
    }

    @Test(priority=2, description = "CASO5_LOGIN_TRANSVERSAL")
    public void suite1Caso3loginRemember(){
        steps.get()
                .clickEntry()
                .clickLoginPerson()
                .clickRemember()
                .fillAll();
    }
}