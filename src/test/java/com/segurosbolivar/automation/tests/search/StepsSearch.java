package com.segurosbolivar.automation.tests.search;

import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.commonslocal.BaseComponent;
import io.qameta.allure.Step;

public class StepsSearch extends BaseComponent {
    private Methods methods = new Methods();

    @Step("The user clicks on the login Link in the Header")
    public StepsSearch searchCode(){
            methods.waitForPageLoad();
        return this;
    }

}