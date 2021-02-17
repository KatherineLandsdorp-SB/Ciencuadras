package com.segurosbolivar.automation.tests.search;

import com.segurosbolivar.automation.commons.BaseTest;
import io.qameta.allure.Step;

import static org.testng.Assert.assertTrue;

public class StepsSearch extends BaseTest {

    private MethodsSearch MethodsSearch = new MethodsSearch();

    @Step("The user click on the logo")
    public StepsSearch clickLogo(){
        MethodsSearch.clickLogo();
        return this;
    }

    @Step("Search code")
    public StepsSearch searchCode(){
        assertTrue(true, MethodsSearch.clickSearchCode());
        return this;
    }
}