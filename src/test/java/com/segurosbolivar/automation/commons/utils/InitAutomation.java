package com.segurosbolivar.automation.commons.utils;

import com.segurosbolivar.automation.commons.enums.ScopeType;
import com.segurosbolivar.automation.commons.helpers.driver.DriverConstants;
import com.segurosbolivar.automation.commons.helpers.driver.web.DriverWebBase;
import com.segurosbolivar.automation.commons.services.DataService;
import com.segurosbolivar.automation.commons.services.MetricsService;
import com.segurosbolivar.automation.commons.services.Token;
import io.restassured.RestAssured;
import lombok.extern.log4j.Log4j2;

import java.text.SimpleDateFormat;
import java.util.Date;

@Log4j2
public class InitAutomation {

    public static void initRestAssured() {
        log.info("Start config RestAssured ....");
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    public static void initDriverFactories() {
        log.info("Start config Factories ....");
        String nameExecution ="UI_"+ DriverConstants.WEB_PLATFORM_NAME+"_" + DriverConstants.WEB_TYPE_EXECUTE + "_" + new SimpleDateFormat("yyyy_MM_dd_hh:mm:ss").format(new Date());
        DriverWebBase.nameExecutionLambda = nameExecution;
        DriverWebBase.instantiateDriverObject();
    }


    public static void initServices() {
        log.info("Start config Services ....");
        DataService.setToken(new Token(ScopeType.SERVICES_DATA).buildToken());
        MetricsService.setToken(new Token(ScopeType.SERVICES_METRICS).buildToken());
    }


}
