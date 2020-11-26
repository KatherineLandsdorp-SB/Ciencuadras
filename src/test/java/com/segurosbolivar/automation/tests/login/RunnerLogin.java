package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.commons.Hooks;


import org.testng.annotations.Test;

public class RunnerLogin extends Hooks {

    ThreadLocal<StepsLogin> steps= ThreadLocal.withInitial(StepsLogin::new);

    @Test
    public void successfulLogin(){
        steps.get().clickEntry().fillAll("AUTOMATION PRUEBAS AUTOMATION PRUEBAS");
    }

//    @Test
//    public void successfulLoginSucess(){
//        steps.get().clickEntry();
//    }
}