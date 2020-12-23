package com.segurosbolivar.automation.tests.publishRealState;

import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.utils.PropertyManager;
import org.testng.annotations.Test;

public class RunnerPublishRealState extends Hooks {
    ThreadLocal<StepsPublishRealState> steps = ThreadLocal.withInitial(StepsPublishRealState::new);

/*
    @Test(priority = 1)
    public void publihsRealStateexitosoSuccssful() throws InterruptedException {
        steps.get().clickPublish();
        steps.get().clickRealState();
        steps.get().fillInName(PropertyManager.getConfigValueByKey("nameRealState"));
        steps.get().fillInMail(PropertyManager.getConfigValueByKey("emailRealState"));
        steps.get().fillInPhones(PropertyManager.getConfigValueByKey("phoneRealState"));
        steps.get().fillInCitu(PropertyManager.getConfigValueByKey("cityRealState"));
        steps.get().selectSale();
        //steps.get().clickCaptcha();
        //steps.get().clickConfirmation();
        //steps.get().validationButton(PropertyManager.getConfigValueByKey("messajeFinal"));
        // steps.get().clickButtonUnderstood();

    }

    @Test(priority = 2)
    public void publihsRealStateNoMandatoryData() throws InterruptedException {
        steps.get().clickPublish();
        steps.get().clickRealState();
       /* steps.get().clickCaptcha();
        steps.get().clickConfirmation();
        steps.get().validationDataMandatory(PropertyManager.getConfigValueByKey("messajeMandatoey"));


    }

    @Test(priority = 3)
    public void publihsRealStateNoMandatoryNameData() throws InterruptedException {
        steps.get().clickPublish();
        steps.get().clickRealState();
        steps.get().fillInMail(PropertyManager.getConfigValueByKey("emailRealState"));
        steps.get().fillInPhones(PropertyManager.getConfigValueByKey("phoneRealState"));
        steps.get().fillInCitu(PropertyManager.getConfigValueByKey("cityRealState"));
        steps.get().selectSale();
        /*steps.get().clickCaptcha();
        steps.get().clickConfirmation();
        steps.get().validationDataMandatory(PropertyManager.getConfigValueByKey("messajeMandatoey"));

    }

    @Test(priority = 4)
    public void publihsRealStateNoMandatoryEmailData() throws InterruptedException {
        steps.get().clickPublish();
        steps.get().clickRealState();
        steps.get().fillInName(PropertyManager.getConfigValueByKey("nameRealState"));
        steps.get().fillInPhones(PropertyManager.getConfigValueByKey("phoneRealState"));
        steps.get().fillInCitu(PropertyManager.getConfigValueByKey("cityRealState"));
        steps.get().selectSale();
       steps.get().clickCaptcha();
        steps.get().clickConfirmation();
        steps.get().validationDataMandatory(PropertyManager.getConfigValueByKey("messajeMandatoey"));

    }

    @Test(priority = 5)
    public void publihsRealStateNoMandatoryPhoneData() throws InterruptedException {
        steps.get().clickPublish();
        steps.get().clickRealState();
        steps.get().fillInName(PropertyManager.getConfigValueByKey("nameRealState"));
        steps.get().fillInMail(PropertyManager.getConfigValueByKey("emailRealState"));
        steps.get().fillInCitu(PropertyManager.getConfigValueByKey("cityRealState"));
        steps.get().selectSale();
        //steps.get().clickCaptcha();
        // steps.get().clickConfirmation();
        // steps.get().validationDataMandatory(PropertyManager.getConfigValueByKey("messajeMandatoey"));

    }
*/
    @Test(priority = 6)
    public void publihsRealStateNoMandatoryCityData() throws InterruptedException {
        steps.get().clickPublish();
        steps.get().clickRealState();
        steps.get().fillInName(PropertyManager.getConfigValueByKey("nameRealState"));
        steps.get().fillInMail(PropertyManager.getConfigValueByKey("emailRealState"));
        steps.get().fillInPhones(PropertyManager.getConfigValueByKey("phoneRealState"));
        steps.get().selectSale();
        Thread.sleep(3000);
        steps.get().clickCaptcha();
        //steps.get().clickConfirmation();
        //  steps.get().validationDataMandatory(PropertyManager.getConfigValueByKey("messajeMandatoey"));

    }
/*
    @Test(priority = 7)
    public void validationButtonTransaction() throws InterruptedException {
        steps.get().clickPublish();
        steps.get().clickRealState();
        steps.get().validationRadioButtonSale();
        steps.get().validationRadioButtonRent();
        steps.get().validationRadioButtonRentSale();
    }
*/

}
