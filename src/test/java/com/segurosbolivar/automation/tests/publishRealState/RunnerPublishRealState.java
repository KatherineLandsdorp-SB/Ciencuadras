package com.segurosbolivar.automation.tests.publishRealState;

import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.utils.PropertyManager;
import org.testng.annotations.Test;

public class RunnerPublishRealState extends Hooks {
    ThreadLocal<StepsPublishRealState> steps = ThreadLocal.withInitial(StepsPublishRealState::new);


    @Test(priority = 1)
    public void publihsRealStateSuccssful() throws InterruptedException {
        steps.get()
                .clickButtonSaleHome()
                .clickRealState()
                .fillInName()
                .fillInMail()
                .fillInPhones()
                .fillInCity()
                .selectSale()
                .clickConfirmation()
                .validationTextButtonUnderstand()
                .clickButtonUnderstood();
    }

    @Test(priority = 2)
    public void publihsRealStateNoMandatoryData() {
        steps.get()
                .clickButtonSaleHome()
                .clickRealState()
                .clickConfirmation()
                .validationDataMandatory();
    }

    @Test(priority = 3)
    public void publihsRealStateNoMandatoryNameData() throws InterruptedException {
        steps.get()
                .clickButtonSaleHome()
                .clickRealState()
                .fillInMail()
                .fillInPhones()
                .fillInCity()
                .selectSale()
                .clickConfirmation()
                .validationDataMandatory();
    }

    @Test(priority = 4)
    public void publihsRealStateNoMandatoryEmailData() throws InterruptedException {
        steps.get()
                .clickButtonSaleHome()
                .clickRealState()
                .fillInName()
                .fillInPhones()
                .fillInCity()
                .selectSale()
                .clickConfirmation()
                .validationDataMandatory();
    }

    @Test(priority = 5)
    public void publihsRealStateNoMandatoryPhoneData() throws InterruptedException {
        steps.get()
                .clickButtonSaleHome()
                .clickRealState()
                .fillInName()
                .fillInMail()
                .fillInCity()
                .selectSale()
                .clickConfirmation()
                .validationDataMandatory();

    }

    @Test(priority = 6)
    public void publihsRealStateNoMandatoryCityData() {
        steps.get()
                .clickButtonSaleHome()
                .clickRealState()
                .fillInName()
                .fillInMail()
                .fillInPhones()
                .selectSale()
                .clickConfirmation()
                .validationDataMandatory();

    }

    @Test(priority = 7)
    public void validationButtonTransaction() {
        steps.get()
                .clickButtonSaleHome()
                .clickRealState()
                .validationRadioButtonSale()
                .validationRadioButtonRent()
                .validationRadioButtonRentSale();
    }


}
