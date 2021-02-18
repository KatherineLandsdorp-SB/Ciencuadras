package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.commons.Hooks;


import org.testng.annotations.Test;

public class RunnerLogin extends Hooks {

    ThreadLocal<StepsLogin> steps = ThreadLocal.withInitial(StepsLogin::new);

    @Test(priority=2, groups = { "smoke" }, description = "CASO3_LOGIN_TRANSVERSAL")
    public void successfullLogin(){
        steps.get()
                .clickEntry()
                .clickLoginPerson()
                .fillAll();
    }

    @Test(priority=2, groups = { "smoke" }, description = "CASO4_LOGIN_TRANSVERSAL")
    public void failLogin(){
        steps.get()
                .clickEntry()
                .clickLoginPerson()
                .fillFail();
    }

    @Test(priority=2, groups = { "smoke" }, description = "CASO5_LOGIN_TRANSVERSAL", sute, case)
    public void loginRemember(){
        steps.get()
                .clickEntry()
                .clickLoginPerson()
                .clickRemember()
                .fillAll();
    }
}