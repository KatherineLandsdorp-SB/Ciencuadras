package com.segurosbolivar.automation.tests.blog;
import com.segurosbolivar.automation.commonslocal.BaseComponent;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;

public class StepsBlog extends BaseComponent {

    public StepsBlog(JSONObject json){
        super(json);
    }

    @Step("The user clicks on the login Link in the Header")
    public StepsBlog clickHeaderBlog(){
            header.clickOnBlog();
        return this;
    }

    @Step("Valdiate success")
    public StepsBlog scrollToPage(String page) throws InterruptedException {
        methods.waitForPageLoad();
        methods.waitingForElement(page, 5);
        methods.clickElementJs(page);
        methods.waitForPageLoad();
        methods.scrollToEndPage();
        methods.scrollToInitPage();
        return this;
    }
}