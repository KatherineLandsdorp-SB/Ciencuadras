package com.segurosbolivar.automation.tests.PublishHome;

import com.segurosbolivar.automation.commons.Services;
import com.segurosbolivar.automation.commons.BaseTest;

public class MethodsPublishHome extends BaseTest {
    Services services = new Services();

    public boolean validateButtonKnowHowPublish() {
        boolean present;
        present = services.validationElementEnable(buttonKnowPublish);
        return present;
    }

    public boolean validateButtonPublishProperty() {
        boolean present;
        present = services.validationElementEnable(buttonPublishProperty);
        return present;
    }

    public boolean validateLabelAccompainment(){
        driverFacade.waitForVisibilityOfElement(labelAccompaiment);
        boolean present;
        present=labelAccompaiment.isDisplayed();
        return present;
    }
}
