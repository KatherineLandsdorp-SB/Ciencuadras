package com.segurosbolivar.automation.tests.sample;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.TestType;

public class RunnerSample extends Hooks {
    @Test(
            id = 1000,
            testType = TestType.WEB,
            description = "Es un test de prueba de monitoring"
    )
    public void test(){
        try {
            Assert.fail();
        }catch (Exception e){
            Assert.fail(e.getMessage());
        }
    }
}
