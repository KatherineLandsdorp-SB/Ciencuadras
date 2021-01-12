package com.segurosbolivar.automation.tests.publishHome;

import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.commons.BaseTest;

public class MethodsPublishHome extends BaseTest {
    Methods services = new Methods();

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
