package com.segurosbolivar.automation.commonslocal.layout;
import com.segurosbolivar.automation.commons.methods.web.WebGlobalMethods;

public class Body {
    private WebGlobalMethods methods;
    public Body(WebGlobalMethods methods){
        this.methods = methods;
    }
    public void randomClickOnBody(){
        methods.clickElementAction("body");
    }
}
