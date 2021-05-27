package com.segurosbolivar.automation.commonslocal.layout;

import com.segurosbolivar.automation.commons.Methods;

public class Header {

    private Methods methods = new Methods();

    public void clickOnEntryLoginAllied(){
        methods.waitForPageLoad();
        methods.waitingForElement("sigInMenu",10);
        methods.clickElementJs("sigInMenu");
        methods.waitingForElement("alliedSigInMenu",10);
        methods.clickElementJs("alliedSigInMenu");
        methods.waitingForElement("popupSigInAllied",10);
    }

    public void clickOnEntry(){
        methods.waitForPageLoad();
        methods.waitingForElement("headPerson", 5);
        methods.clickElement("headPerson");
    }
}
