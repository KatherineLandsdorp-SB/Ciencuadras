package com.segurosbolivar.automation.commons;

import com.segurosbolivar.automation.commons.services.DataService;
import com.segurosbolivar.automation.commons.services.utils.ServiceConstants;
import com.segurosbolivar.automation.commons.utils.JsonParser;
import lombok.extern.log4j.Log4j2;
import org.json.simple.JSONObject;

@Log4j2
public class Elements {
    private static JSONObject response;

    public static void initElements() {
        if (response == null) {
            log.info("Call Elements ....");
            response = DataService.getElements(ServiceConstants.PLATFORM_ID, ServiceConstants.ENVIRONMENT_ID);
        }
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
