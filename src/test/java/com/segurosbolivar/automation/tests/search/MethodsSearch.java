package com.segurosbolivar.automation.tests.search;
import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Methods;

public class MethodsSearch extends BaseTest {
    protected Methods methods = new Methods();

    public void clickSearchSelect(){
        methods.waitForPageLoad();
        methods.awaitToFindElement("searchSelect", 3);
        methods.clickElement("searchSelect");
    }

    public void clickSearchType(){
        methods.waitForPageLoad();
        methods.awaitToFindElement("searchType", 3);
        methods.clickElement("searchType");
    }

    public void city(){
        methods.waitForPageLoad();
        methods.awaitToFindElement("city", 3);
        methods.clickElement("city");
    }

    public void search(){
        methods.waitForPageLoad();
        methods.awaitToFindElement("search", 3);
        methods.clickElement("search");
    }

}
