package com.segurosbolivar.automation.sanitytest.test;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.annotations.Test;

public class LoginTest extends Hooks {

    ThreadLocal<LoginStepDef> steps= ThreadLocal.withInitial(LoginStepDef::new);

    @Test
    public void successfulLogin(){
        steps.get().checkLogin("Natalia Pineda Tarazona");
    }




}
