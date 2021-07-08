package com.segurosbolivar.automation.commons.helpers.driver;

import com.segurosbolivar.automation.commons.utils.PropertyManager;

public class DriverConstants {

    //LOCAL DRIVER ?
    public  static  final String DRIVER_LOCAL = PropertyManager.getConfigValueByKey("driverLocal");


    //CAPABILITIES MOBILE
    public  static final String MOBILE_UDID = PropertyManager.getConfigValueByKey("mobile.capabilities.udid");
    public  static final String MOBILE_DEVICE_NAME = PropertyManager.getConfigValueByKey("mobile.capabilities.device_name");
    public  static final String MOBILE_APP_PACKAGE = PropertyManager.getConfigValueByKey("mobile.capabilities.app_package");
    public  static final String MOBILE_APP_ACTIVITY = PropertyManager.getConfigValueByKey("mobile.capabilities.app_activity");
    public  static final String MOBILE_VERSION = PropertyManager.getConfigValueByKey("mobile.capabilities.version");
    public  static final String MOBILE_HOST_URL = PropertyManager.getConfigValueByKey("mobile.capabilities.host_url");


    //CAPABILITIES WEB
    public static final String WEB_BROWSER_NAME = PropertyManager.getConfigValueByKey("web.capabilities.browserName");
    public static final String WEB_BROWSER_VERSION = PropertyManager.getConfigValueByKey("web.capabilities.browserVersion");
    public static final String WEB_OS_PLATFORM = PropertyManager.getConfigValueByKey("web.capabilities.platformOS");
    public static final String WEB_NETWORK_ENABLE = PropertyManager.getConfigValueByKey("web.capabilities.network");
    public static final String WEB_VISUAL_ENABLE = PropertyManager.getConfigValueByKey("web.capabilities.visual");
    public static final String WEB_VIDEO_ENABLE = PropertyManager.getConfigValueByKey("web.capabilities.video");
    public static final String WEB_CONSOLE_ENABLE = PropertyManager.getConfigValueByKey("web.capabilities.console");

    //AUTH LAMBDA
    public static final String LAMBDA_USER_NAME = PropertyManager.getConfigValueByKey("lambda.userName");
    public static final String LAMBDA_PASS = PropertyManager.getConfigValueByKey("lambda.password");
    public static final String LAMBDA_GRID_URL = PropertyManager.getConfigValueByKey("lambda.gridUrl");


    //EXECUTION
    public static final String WEB_URL_ENVIRONMENT = PropertyManager.getConfigValueByKey("automation.environmentUrl");
    public static final String WEB_PLATFORM_NAME = PropertyManager.getConfigValueByKey("automation.platform_name");
    public static final String WEB_TYPE_EXECUTE = PropertyManager.getConfigValueByKey("automation.execution.type_automation_name");

}
