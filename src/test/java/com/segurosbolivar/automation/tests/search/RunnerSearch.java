package com.segurosbolivar.automation.tests.search;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.annotations.Test;

public class RunnerSearch extends Hooks {

    ThreadLocal<StepsSearch> steps= ThreadLocal.withInitial(StepsSearch::new);

    @Test(priority=1, groups = { "smoke" })
    public void successfullRegister(){
        steps.get()
                .clickEntry()
                .clickAllied()
                .fillAll();
                //.validateEmail()
    }
}