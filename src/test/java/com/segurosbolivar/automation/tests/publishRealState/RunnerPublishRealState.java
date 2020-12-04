package com.segurosbolivar.automation.tests.publishRealState;

import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.utils.PropertyManager;
import org.testng.annotations.Test;

public class RunnerPublishRealState extends Hooks {
    ThreadLocal<StepsPublishRealState> steps = ThreadLocal.withInitial(StepsPublishRealState::new);


    @Test(priority = 1)
    public void publihsRealStateexitosoSuccssful() {
        steps.get().clickPublish();
        steps.get().clickRealState();
        steps.get().fillInName(PropertyManager.getConfigValueByKey("nameRealState"));
        steps.get().fillInMail(PropertyManager.getConfigValueByKey("emailRealState"));
        steps.get().fillInPhones(PropertyManager.getConfigValueByKey("phoneRealState"));
        steps.get().fillInCitu(PropertyManager.getConfigValueByKey("cityRealState"));
        steps.get().selectCity();
        steps.get().selectSale();
        steps.get().clickConfirmation();
        steps.get().validationButton(PropertyManager.getConfigValueByKey("messajeFinal"));
        steps.get().clickButtonUnderstood();

    }

    @Test(priority = 2)
    public void publihsRealStateNoMandatoryNameData(){
        steps.get().clickPublish();
        steps.get().clickRealState();
        steps.get().clickConfirmation();
        steps.get().validationDataMandatory(PropertyManager.getConfigValueByKey("messajeMandatoey"));


    }
}
