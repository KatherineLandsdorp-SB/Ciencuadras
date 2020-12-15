package com.segurosbolivar.automation.tests.register;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.annotations.Test;

public class RunnerRegister extends Hooks {

    ThreadLocal<StepsRegister> steps= ThreadLocal.withInitial(StepsRegister::new);

    @Test
    public void successfullRegister(){
        steps.get().clickEntry()
                .fillAll("AUTOMATION PRUEBAS AUTOMATION PRUEBAS");
    }
}