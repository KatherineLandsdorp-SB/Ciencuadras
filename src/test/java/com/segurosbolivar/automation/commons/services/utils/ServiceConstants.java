package com.segurosbolivar.automation.commons.services.utils;

import com.segurosbolivar.automation.commons.utils.PropertyManager;

public class ServiceConstants {
    public static final String AUT_BASE_URL = PropertyManager.getConfigValueByKey("services.aut_base_url");
    public static final String USER_NAME = PropertyManager.getConfigValueByKey("services.user_name");
    public static final String PASS = PropertyManager.getConfigValueByKey("services.password");
    public static final String DATA_SCOPE = PropertyManager.getConfigValueByKey("services.scope.data_scope");
    public static final String METRICS_SCOPE = PropertyManager.getConfigValueByKey("services.scope.metrics_scope");
    public static final String BASE_URL = PropertyManager.getConfigValueByKey("services.base_url");
    public static final String BASE_PATH = PropertyManager.getConfigValueByKey("services.base_path");
    public static final Integer PLATFORM_ID = Integer.parseInt(PropertyManager.getConfigValueByKey("automation.platformId"));
    public static final Integer ENVIRONMENT_ID = Integer.parseInt(PropertyManager.getConfigValueByKey("automation.environmentId"));
    public static final Integer PROVIDER_ID = Integer.parseInt(PropertyManager.getConfigValueByKey("automation.execution.providerId"));
    public static final Integer TYPE_AUTOMATION_ID = Integer.parseInt(PropertyManager.getConfigValueByKey("automation.execution.type_automationId"));
    public static final Integer TYPE_EXECUTION_ID = Integer.parseInt(PropertyManager.getConfigValueByKey("automation.execution.type_executionId"));
    public static final Integer STATE_EXECUTION_ID = Integer.parseInt(PropertyManager.getConfigValueByKey("automation.execution.state_executionId"));
    public static final String AUTOMATION_EXECUTOR = PropertyManager.getConfigValueByKey("automation.execution.executor");

}
