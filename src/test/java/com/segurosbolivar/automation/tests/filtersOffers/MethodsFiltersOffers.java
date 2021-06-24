package com.segurosbolivar.automation.tests.filtersOffers;
import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.commonslocal.BaseComponent;

public class MethodsFiltersOffers extends BaseComponent {

    private Methods methods = new Methods();




    public void clickLabelProjectsOnPlans(){
    this.methods.waitForPageLoad();
    this.methods.waitElementExplicitTime("labelProjectOnPlans",5);
    this.methods.clickElementJs("labelProjectOnPlans");
    this.methods.waitForPageLoad();
    }

    public String getTittleTextResult(){
        String text = "";
        this.methods.waitingForElement("tittleBannerResult",10);
        text = this.methods.getEntity("tittleBannerResult").getText();
        return text;
    }

}
