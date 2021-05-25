package com.segurosbolivar.automation.commonsLocal;

import com.segurosbolivar.automation.commons.Methods;

public class MethodsHeader  {

    private Methods methods = new Methods();

    public void clickOnEntryLoginAllied(){
        methods.waitForPageLoad();
        methods.waitingForElement("sigInMenu",10);
        methods.clickElementJs("sigInMenu");
        methods.waitingForElement("alliedSigInMenu",10);
        methods.clickElementJs("alliedSigInMenu");
        methods.waitingForElement("popupSigInAllied",10);
    }


}
