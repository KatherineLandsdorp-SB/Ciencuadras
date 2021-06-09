package com.segurosbolivar.automation.commons.utils;

import com.segurosbolivar.automation.commons.enums.ScopeType;
import com.segurosbolivar.automation.commons.helpers.driver.mobile.DriverMobileBase;
import com.segurosbolivar.automation.commons.helpers.driver.web.DriverWebBase;
import com.segurosbolivar.automation.commons.services.DataService;
import com.segurosbolivar.automation.commons.services.MetricsService;
import com.segurosbolivar.automation.commons.services.Token;
import io.restassured.RestAssured;
import org.json.simple.JSONObject;

public class InitAutomation {

    public static void initRestAssured() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    public static void initDriverFactories() {
        DriverMobileBase.instantiateDriverObject();
        DriverWebBase.instantiateDriverObject();
    }

    public static void initServices() {
        DataService.setToken(new Token(ScopeType.SERVICES_DATA).buildToken());
        MetricsService.setToken(new Token(ScopeType.SERVICES_METRICS).buildToken());
    }
}
