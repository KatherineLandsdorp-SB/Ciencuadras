package com.segurosbolivar.automation.tests.publishRealState;

import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.utils.PropertyManager;
import org.testng.annotations.Test;

import java.util.PriorityQueue;

public class RunnerPublishRealState extends Hooks {
    ThreadLocal<StepsPublishRealState> steps = ThreadLocal.withInitial(StepsPublishRealState::new);


   /* @Test(priority = 1)
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


    }*/
    @Test(priority = 3)
    public  void validationButtonTransaction(){
        steps.get().clickPublish();
        steps.get().clickRealState();
        steps.get().validationRadioButtonSale();
        steps.get().validationRadioButtonRent();
       steps.get().validationRadioButtonRentSale();
    }
}
