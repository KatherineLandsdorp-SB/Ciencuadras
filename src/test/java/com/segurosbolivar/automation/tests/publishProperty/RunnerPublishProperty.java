package com.segurosbolivar.automation.tests.publishProperty;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.annotations.Test;

public class RunnerPublishProperty extends Hooks {

    ThreadLocal<StepsPublishProperty> steps = ThreadLocal.withInitial(StepsPublishProperty::new);

    @Test
    public void registerUserEnd() {
        //steps.get().clickPublish();
        steps.get().clickPublishYourself();
        steps.get().clickOnBasicPlan();
        steps.get().clickOnAddToCar();
        steps.get().fillAllFieldPublication();


    }

}
