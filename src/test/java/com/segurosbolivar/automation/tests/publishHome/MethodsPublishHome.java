package com.segurosbolivar.automation.tests.publishHome;

import com.segurosbolivar.automation.elements.Elements;
import com.segurosbolivar.automation.tests.shared.RecicleableMethodsCiencuadras;

public class MethodsPublishHome extends Elements {
    RecicleableMethodsCiencuadras methodsRecyclable = new RecicleableMethodsCiencuadras();

    public boolean validateButtonKnowHowPublish() {
        boolean present;
        present = methodsRecyclable.validationElementEnable(buttonKnowPublish);
        return present;
    }

    public boolean validateButtonPublishProperty() {
        boolean present;
        present = methodsRecyclable.validationElementEnable(buttonPublishProperty);
        return present;
    }

    public boolean validateLabelAccompainment(){
        driverFacade.waitForVisibilityOfElement(labelAccompaiment);
        boolean present;
        present=labelAccompaiment.isDisplayed();
        return present;
    }


}
