package com.segurosbolivar.automation.tests.publishRealState;

import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.utils.PropertyManager;
import org.testng.annotations.Test;

public class RunnerPublishRealState extends Hooks {
    ThreadLocal<StepsPublishRealState> steps = ThreadLocal.withInitial(StepsPublishRealState::new);


    @Test(priority = 1, groups = {"sanity"})
    public void publishRealStateSuccessful() throws InterruptedException {
        steps.get()
                .clickButtonSaleHome()
                .clickRealState()
                .fillInName()
                .fillInMail()
                .fillInPhones()
                .fillInCity()
                .selectSale()
                .clickCaptcha()
                .clickConfirmation()
                .validationTextButtonUnderstand()
                .clickButtonUnderstood();
    }

    @Test(priority = 2, groups = {"sanity"})
    public void publishRealStateNoMandatoryData() {
        steps.get()
                .clickButtonSaleHome()
                .clickRealState()
                .clickConfirmation()
                .validationDataMandatory();
    }

    @Test(priority = 3, groups = {"sanity"})
    public void publihsRealStateNoMandatoryNameData() throws InterruptedException {
        steps.get()
                .clickButtonSaleHome()
                .clickRealState()
                .fillInMail()
                .fillInPhones()
                .fillInCity()
                .selectSale()
                .clickCaptcha()
                .clickConfirmation()
                .validationDataMandatory();
    }

    @Test(priority = 4, groups = {"sanity"})
    public void publihsRealStateNoMandatoryEmailData() throws InterruptedException {
        steps.get()
                .clickButtonSaleHome()
                .clickRealState()
                .fillInName()
                .fillInPhones()
                .fillInCity()
                .selectSale()
                .clickCaptcha()
                .clickConfirmation()
                .validationDataMandatory();
    }

    @Test(priority = 5, groups = {"sanity"})
    public void publihsRealStateNoMandatoryPhoneData() throws InterruptedException {
        steps.get()
                .clickButtonSaleHome()
                .clickRealState()
                .fillInName()
                .fillInMail()
                .fillInCity()
                .selectSale()
                .clickCaptcha()
                .clickConfirmation()
                .validationDataMandatory();

    }

    @Test(priority = 6, groups = {"sanity"})
    public void publihsRealStateNoMandatoryCityData() {
        steps.get()
                .clickButtonSaleHome()
                .clickRealState()
                .fillInName()
                .fillInMail()
                .fillInPhones()
                .selectSale()
                .clickCaptcha()
                .clickConfirmation()
                .validationDataMandatory();

    }

    @Test(priority = 7, groups = {"sanity"})
    public void validationButtonTransaction() {
        steps.get()
                .clickButtonSaleHome()
                .clickRealState()
                .validationRadioButtonSale()
                .validationRadioButtonRent()
                .validationRadioButtonRentSale();
    }


}
