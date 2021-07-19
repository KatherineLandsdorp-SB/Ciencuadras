package com.segurosbolivar.automation.tests.search;
import com.segurosbolivar.automation.commonslocal.BaseComponent;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;

public class StepsSearch extends BaseComponent {

    public StepsSearch(JSONObject json){
        super(json);
    }


    @Step("The user clicks on the login Link in the Header")
    public StepsSearch searchCode(String code){
            methods.waitForPageLoad();
            methods.waitingForElement("inputCode", 5);
            methods.sendKeysText("inputCode", code);
            methods.clickElementJs("buttonCode");

        return this;
    }

    @Step("Valdiate success")
    public StepsSearch validateSuccess(){
        methods.waitForPageLoad();
        methods.waitingForElement("pageCodeSearch", 5);
        methods.validationElementDisplayed("pageCodeSearch");
        return this;
    }


    @Step("Valdiate fail")
    public StepsSearch validateFail(){
        methods.waitElementExplicitTime("pageCodeFailSearch", 20);
        methods.validationElementDisplayed("pageCodeFailSearch");
        return this;
    }

}