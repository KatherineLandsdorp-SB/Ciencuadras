package com.segurosbolivar.automation.tests.searchpropertytest;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Methods;
import io.qameta.allure.Step;

public class StepsSearchProperty extends BaseTest {

    private MethodsSearchProperty methodsSearchProperty;

    public StepsSearchProperty() {
        this.methodsSearchProperty = new MethodsSearchProperty(new Methods());
    }

    @Step("Click link search code")
    public StepsSearchProperty clickLinkSearchByCode() {
        this.methodsSearchProperty.clickLinkSearchByCode();
        return this;
    }

    @Step("Fill search textbox whit invalid property code")
    public StepsSearchProperty fillTextBoxSearchByInvalidCode() {
        this.methodsSearchProperty.fillTextBoxSearchByInvalidCode();
        return this;
    }

    @Step("Fill search textbox whit valid property code")
    public StepsSearchProperty fillTextBoxSearchByValidCode() {
        this.methodsSearchProperty.fillTextBoxSearchByValidCode();
        return this;
    }

    @Step("Click  Search Button")
    public StepsSearchProperty clickSearchButton() {
        this.methodsSearchProperty.clickSearchButton();
        return this;
    }

    @Step("Check invalid code message")
    public String checkInvalidCodeMessage() {
        String message = this.methodsSearchProperty.checkInvalidCodeMessage();
        return message;
    }
}
