package com.segurosbolivar.automation.tests.search;

import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.commonslocal.BaseComponent;
import io.qameta.allure.Step;

public class StepsSearch extends BaseComponent {
    private Methods methods = new Methods();

    @Step("The user clicks on the login Link in the Header")
    public StepsSearch searchCode(String code){
            methods.waitForPageLoad();
            methods.waitingForElement("inputCode", 10);
            methods.sendKeysText("inputCode", code);
            methods.clickElementJs("buttonCode");
            methods.validationElementDisplayed("page");
        return this;
    }


    @Step("The user clicks on the login Link in the Header")
    public StepsSearch searchProject(){
        methods.waitForPageLoad();
        methods.waitingForElement("leaseProject", 10);
        methods.waitForPageLoad();
        return this;
    }

}