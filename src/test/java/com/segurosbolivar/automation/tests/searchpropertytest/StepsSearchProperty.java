package com.segurosbolivar.automation.tests.searchpropertytest;

import io.qameta.allure.Step;

public class StepsSearchProperty {

    private MethodsSearchProperty methodsSearchProperty;

    public StepsSearchProperty() {
        this.methodsSearchProperty = new MethodsSearchProperty();
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
