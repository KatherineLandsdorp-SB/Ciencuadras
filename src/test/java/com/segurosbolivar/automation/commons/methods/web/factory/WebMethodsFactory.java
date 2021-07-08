package com.segurosbolivar.automation.commons.methods.web.factory;
import com.segurosbolivar.automation.commons.Elements;
import com.segurosbolivar.automation.commons.methods.web.WebGlobalMethods;
import org.json.simple.JSONObject;

public class WebMethodsFactory {
    public static WebGlobalMethods getMethods(JSONObject json){
        return  new WebGlobalMethods(json);
    }
}
