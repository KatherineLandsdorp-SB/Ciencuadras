package com.segurosbolivar.automation.tests.header;

import com.segurosbolivar.automation.commonslocal.BaseComponent;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;

public class StepsHeader  extends BaseComponent {

    public StepsHeader(JSONObject jsonElements){
        super(jsonElements);
    }


    @Step("The user clicks on the header label Offers ")
    public StepsHeader clickOnEntryOffers(){
        this.header.clickOnEntryOffers();
        return this;
    }

    @Step("The user clicks on the header Buy used Real State")
    public StepsHeader clickOnBuyUsedRealState(){
        this.header.selectBuyUsedRealState();
        return this;
    }

    @Step("The user clicks on the header Buy new Real State")
    public StepsHeader clickOnBuyNewRealState(){
        this.header.selectBuyNewRealState();
        return this;
    }

    @Step("The user clicks on the header Rent Real State")
    public StepsHeader clickOnRentRealState(){
        this.header.selectRentRealState();
        return this;
    }

    @Step("The user clicks on the header label tools ")
    public StepsHeader clickOnTools(){
        this.header.selectTools();
        return this;
    }

    @Step("The user clicks on the header label From Exterior ")
    public StepsHeader clickOnFromExterior(){
        this.header.selectFromExterior();
        return this;
    }

    @Step("The user clicks on the header label Blog ")
    public StepsHeader clickOnBlog(){
        this.header.selectBlog();
        return this;
    }

    @Step("The user clicks on the header  Allied label and select Real state label")
    public StepsHeader clickOnRealState(){
        this.header.selectRealState();
        return this;
    }

    @Step("The user clicks on the header  Allied label and select Builders label")
    public StepsHeader clickOnBuilders(){
        this.header.selectBuilders();
        return this;
    }

    @Step("The user clicks on the header label From Exterior but if appears an popup the user close it")
    public StepsHeader closePopUpFromExterior(){
        boolean hidden = methods.visibleElement("buttonClosePopupFromExterior",10);
        if(hidden!=false){
            methods.waitingForElement("buttonClosePopupFromExterior",5);
            methods.clickElementJs("buttonClosePopupFromExterior");
        }
        return this;
    }
}
