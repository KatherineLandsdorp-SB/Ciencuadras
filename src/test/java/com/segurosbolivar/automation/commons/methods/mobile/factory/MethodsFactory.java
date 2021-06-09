package com.segurosbolivar.automation.commons.methods.mobile.factory;

import com.segurosbolivar.automation.commons.methods.mobile.AndroidMethods;
import com.segurosbolivar.automation.commons.methods.mobile.IosMethods;
import com.segurosbolivar.automation.commons.methods.mobile.MobileMethods;
import com.segurosbolivar.automation.commons.utils.PropertyManager;
import org.json.simple.JSONObject;

public class MethodsFactory {
    private static MobileMethods mobileMethods;

    public static MobileMethods getMethods(JSONObject elements) {
        if (null == mobileMethods) {
            String option = PropertyManager.getConfigValueByKey("mobileDriver").toLowerCase();
            switch (option) {
                case "android":
                    return mobileMethods = new AndroidMethods(elements);
                case "ios":
                    return mobileMethods = new IosMethods(elements);
            }
        }
        return mobileMethods;
    }
}