package com.segurosbolivar.automation.tests.register;

import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.regressiontest.test.steps.LoginStepDef;
import org.testng.annotations.Test;

public class RunnerLogin extends Hooks {

    ThreadLocal<LoginStepDef> steps= ThreadLocal.withInitial(LoginStepDef::new);

    @Test
    public void successfulLogin(){
        steps.get().clickLogin();
    }

//    @Test
//    public void successfulLogin2(){
//        steps.get().clickLogin().fillAll().checkLogin("Holman");
//    }
}