package com.segurosbolivar.automation.tests.publishProperty;

import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.utils.PropertyManager;
import org.testng.annotations.Test;

public class RunnerPublishProperty extends Hooks {

    ThreadLocal<StepsPublishProperty> steps = ThreadLocal.withInitial(StepsPublishProperty::new);

    /*@Test
    public void registerUserEnd() {
        //steps.get().clickPublish();
        steps.get().clickPublishYourself();
        steps.get().clickOnBasicPlan();
        steps.get().clickOnAddToCar();
        steps.get().fillAllFieldPublication();


    }*/
    @Test
    public void validateCityWithCoverage(){
        steps.get().clickPublish();
        steps.get().clickPublishYourself();
        steps.get().clickOnAddToCar();
        steps.get().registerCityCoverage(PropertyManager.getConfigValueByKey("city"));
       // steps.get().clickButtonContinueCityCoverage();
       // steps.get().validateCityCoverage(PropertyManager.getConfigValueByKey("city"));
        //steps.get().clickButtonContinueCityCoverage();
    }

}
