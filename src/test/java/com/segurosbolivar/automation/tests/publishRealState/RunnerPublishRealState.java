package com.segurosbolivar.automation.tests.publishRealState;

import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.utils.PropertyManager;
import org.testng.annotations.Test;

public class RunnerPublishRealState extends Hooks {
    ThreadLocal<StepsPublishRealState> steps = ThreadLocal.withInitial(StepsPublishRealState::new);


   @Test
    public void publishRealStateSuccessful() {
        steps.get()
                .clickButtonSaleHome()
                .clickRealState()
                .fillForm()
                .clickButtonUnderstood();
    }

    @Test
    public void publishRealStateNoMandatoryData() {
        steps.get()
                .clickButtonSaleHome()
                .clickRealState()
                .clickConfirmationNoMandatoryData();

    }

    @Test
    public void publishRealStateNoMandatoryDataName() {
        steps.get()
                .clickButtonSaleHome()
                .clickRealState()
                .fillNoMandatoryDataName();

    }

    @Test(priority = 4)
    public void publishRealStateNoMandatoryDataEmail() {
        steps.get()
                .clickButtonSaleHome()
                .clickRealState()
                .fillNoMandatoryDataEmail();

    }

    @Test(priority = 5)
    public void publishRealStateNoMandatoryDataPhone() {
        steps.get()
                .clickButtonSaleHome()
                .clickRealState()
                .fillNoMandatoryDataPhone();


    }

    @Test(priority = 6)
    public void publishRealStateNoMandatoryCityData() {
        steps.get()
                .clickButtonSaleHome()
                .clickRealState()
                .fillNoMandatoryDataCity();


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
