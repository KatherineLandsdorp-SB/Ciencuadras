package com.segurosbolivar.automation.tests.search;
import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Methods;

public class MethodsSearch extends BaseTest {
    protected Methods methods = new Methods();

    public void clickLogo(){
        methods.waitForPageLoad();
        methods.waitingForElement("logo", 15);
        methods.clickElementJs("logo");

    }

    public String clickSearchCode(){
        methods.waitForPageLoad();
        methods.awaitToFindElement("searchCode", 3);
        methods.sendKeysText("searchCode", "7214-1200006");
        methods.clickElementJs("searchButton");
        methods.pause(15);
        return  methods.searchText("7214-1200006", 15);
    }
}