package com.segurosbolivar.automation.tests.publishHome;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.annotations.Test;

public class RunnerPublishHome extends Hooks {
    ThreadLocal<StepsMethodsPublishHome> steps = ThreadLocal.withInitial(StepsMethodsPublishHome::new);

    @Test(priority = 1)
    public void validateOptionPublishProperty() {

        steps.get().validateButtonPublishProperty();
    }

    @Test(priority = 2)
    public void validateOptionKnowHowToPublish() {
        steps.get().validateButtonKnowPublish();
    }

}
