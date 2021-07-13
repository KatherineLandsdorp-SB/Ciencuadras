package com.segurosbolivar.automation.commonslocal;

import com.segurosbolivar.automation.commons.methods.web.WebGlobalMethods;
import com.segurosbolivar.automation.commonslocal.layout.Body;
import com.segurosbolivar.automation.commonslocal.layout.Filters;
import com.segurosbolivar.automation.commonslocal.layout.Header;
import org.json.simple.JSONObject;

public class BaseComponent  {

   protected Header header;
   protected Body body;
   protected  Filters filters;
   protected WebGlobalMethods methods;

    public  BaseComponent(JSONObject json){
        this.methods = new WebGlobalMethods(json);
        this.header = new Header(this.methods);
        this.body = new Body(this.methods);
        this.filters = new Filters(this.methods);
    }
}
