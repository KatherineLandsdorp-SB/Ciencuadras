package com.segurosbolivar.automation.commons.methods.mobile.factory;

import com.segurosbolivar.automation.commons.methods.mobile.AndroidMethods;
import com.segurosbolivar.automation.commons.methods.mobile.IosMethods;
import com.segurosbolivar.automation.commons.methods.mobile.MobileGlobalMethods;
import com.segurosbolivar.automation.commons.utils.PropertyManager;
import org.json.simple.JSONObject;

public class MethodsFactory {
    private static MobileGlobalMethods mobileMethods;

    public static MobileGlobalMethods getMethods(JSONObject elements) {
        String option = PropertyManager.getConfigValueByKey("mobileDriver").toLowerCase();
        switch (option) {
            case "android":
                return mobileMethods = new AndroidMethods(elements);
            case "ios":
                return mobileMethods = new IosMethods(elements);
        }
        return mobileMethods;
    }
}