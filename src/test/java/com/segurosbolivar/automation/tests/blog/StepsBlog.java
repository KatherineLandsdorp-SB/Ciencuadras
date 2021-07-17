package com.segurosbolivar.automation.tests.blog;
import com.segurosbolivar.automation.commonslocal.BaseComponent;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;

public class StepsBlog extends BaseComponent {

    public StepsBlog(JSONObject json){
        super(json);
    }

    @Step("The user clicks on the login Link in the Header")
    public StepsBlog searchCode(String code){
            methods.waitForPageLoad();
            methods.waitingForElement("inputCode", 5);
            methods.sendKeysText("inputCode", code);
            methods.clickElementJs("buttonCode");

        return this;
    }

    @Step("Valdiate success")
    public StepsBlog validateSuccess(){
        methods.waitForPageLoad();
        methods.waitingForElement("pageCodeSearch", 5);
        methods.validationElementDisplayed("pageCodeSearch");
        return this;
    }


    @Step("Valdiate fail")
    public StepsBlog validateFail(){
        methods.waitElementExplicitTime("pageCodeFailSearch", 20);
        methods.validationElementDisplayed("pageCodeFailSearch");
        return this;
    }

}