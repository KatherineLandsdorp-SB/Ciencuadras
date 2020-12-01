package com.segurosbolivar.automation.tests.publishRealState;

import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.utils.PropertyManager;
import org.testng.annotations.Test;

public class RunnerPublishRealState extends Hooks {
    ThreadLocal<StepsPublishRealState> steps = ThreadLocal.withInitial(StepsPublishRealState::new);


    @Test
    public void publihsRealStateSuccefully() {
        //steps.get().clickPublish();
        steps.get().clickRealState();
        steps.get().fillFieldFormRealState(PropertyManager.getConfigValueByKey("messajeFinal"));

    }
}
