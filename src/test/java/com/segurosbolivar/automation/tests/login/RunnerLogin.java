package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.commons.Hooks;


import org.testng.annotations.Test;

public class RunnerLogin extends Hooks {

    ThreadLocal<StepsLogin> steps = ThreadLocal.withInitial(StepsLogin::new);

    @Test(priority=2, groups = { "smoke" }, description = "This is really a simple crazy test")
    public void successfullLogin(){
        steps.get()
                .clickEntry()
                .clickLoginPerson()
                .fillAll();
    }

    @Test(priority=2, groups = { "smoke" }, description = "This is really a simple crazy")
    public void failLogin(){
        steps.get()
                .clickEntry()
                .clickLoginPerson()
                .fillFail();
    }

    @Test(priority=2, groups = { "smoke" }, description = "This is really a simple")
    public void successfullLoginRemember(){
        steps.get()
                .clickEntry()
                .clickLoginPerson()
                .clickRemember()
                .fillAll();
    }
}