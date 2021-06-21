package com.segurosbolivar.automation.commonslocal.layout;

import com.segurosbolivar.automation.commons.Methods;

public class Body {
    private Methods methods = new Methods();
    public void randomClickOnBody(){
        methods.clickElement("body");
    }
}
