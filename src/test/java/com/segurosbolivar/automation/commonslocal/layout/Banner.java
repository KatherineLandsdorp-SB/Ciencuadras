package com.segurosbolivar.automation.commonslocal.layout;

import com.segurosbolivar.automation.commons.Methods;
import io.qameta.allure.Step;

public class Banner {
    private Methods methods = new Methods();
    @Step("The user clicks on new property")
    public Banner buyNewProperty(){
        methods.waitingForElement("", 5);
        methods.clickElement("");
        return this;
    }
}
