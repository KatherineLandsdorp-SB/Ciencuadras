package com.segurosbolivar.automation.tests.register;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RunnerRegister extends Hooks {

    ThreadLocal<StepsRegister> steps= ThreadLocal.withInitial(StepsRegister::new);

    @Test(priority=1, groups = { "smoke" })
    public void successfullRegister(){

        try {
            steps.get()
                    .clickEntry()
                    .clickRegister()
                    .fillAll();

        } catch (Exception  ex) {
            Assert.fail(ex.getMessage());
            
        }


    }

    @Test(priority=1, groups = { "smoke" })
    public void successfullRegisterAllied(){

        try {
            steps.get()
                    .clickEntry()
                    .clickAllied()
                    .fillAllAllied();
            //.validateEmail()

        } catch (Exception  ex) {
            Assert.fail(ex.getMessage());
            
        }

    }
}