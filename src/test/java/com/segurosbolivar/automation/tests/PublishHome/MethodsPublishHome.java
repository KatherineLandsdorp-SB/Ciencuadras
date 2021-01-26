package com.segurosbolivar.automation.tests.PublishHome;

import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.tests.shared.SharedMethods;

public class MethodsPublishHome extends BaseTest {
    private Methods methods = new Methods();
    private SharedMethods shared = new SharedMethods();

    public boolean validateButtonKnowHowPublish() {
        boolean present=methods.validationElementEnable("buttonKnowPublish");
        return present;
    }

    public boolean validateButtonPublishProperty() {
        boolean present= methods.validationElementEnable("buttonPublishProperty");
        return present;
    }


}
