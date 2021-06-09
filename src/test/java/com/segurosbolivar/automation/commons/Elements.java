package com.segurosbolivar.automation.commons;

import com.segurosbolivar.automation.commons.services.DataService;
import com.segurosbolivar.automation.commons.services.utils.ServiceConstants;
import com.segurosbolivar.automation.commons.utils.JsonParser;
import org.json.simple.JSONObject;

public class Elements {
    private static JSONObject response;

    private static void initElements() {
        if (response == null)
            response = DataService.getElements(ServiceConstants.PLATFORM_ID, ServiceConstants.ENVIRONMENT_ID);
    }
    public static JSONObject getWebElements() {
        initElements();
        return JsonParser.toJSONObject(response.get("webElements"));
    }

    public static JSONObject getMobileElements() {
        initElements();
        return JsonParser.toJSONObject(response.get("mobileElements"));
    }
}
