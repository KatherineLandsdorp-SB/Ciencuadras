package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.commons.Hooks;


import org.testng.annotations.Test;

public class RunnerLogin extends Hooks {

    ThreadLocal<StepsLogin> steps = ThreadLocal.withInitial(StepsLogin::new);

    @Test(priority=2, groups = { "smoke" })
    public void successfullLogin(){
        steps.get()
                .clickEntry()
                .clickLoginPerson()
                .fillAll();
    }

    @Test(priority=2, groups = { "smoke" })
    public void failLogin(){
        steps.get()
                .clickEntry()
                .clickLoginPerson()
                .fillFail();
    }


    @Test(priority=2, groups = { "smoke" })
    public void successfullLoginRemember(){
        steps.get()
                .clickEntry()
                .clickLoginPerson()
                .clickRemember()
                .fillAll();
    }
}