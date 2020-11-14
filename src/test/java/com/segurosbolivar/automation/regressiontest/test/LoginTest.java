package com.segurosbolivar.automation.regressiontest.test;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.annotations.Test;

public class LoginTest extends Hooks {

    ThreadLocal<LoginStepDef> steps= ThreadLocal.withInitial(LoginStepDef::new);

    @Test
    public void successfulLogin(){
        steps.get().clickLogin().fillAll().checkLogin("Zeroe Zeroe");
    }

    @Test
    public void successfulLogin2(){
        steps.get().clickLogin().fillAll().checkLogin("Holman");
    }
}
