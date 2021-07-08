package com.segurosbolivar.automation.commons.enums;

import com.segurosbolivar.automation.commons.services.utils.ServiceConstants;

public enum ScopeType {

    SERVICES_DATA(ServiceConstants.DATA_SCOPE),
    SERVICES_METRICS(ServiceConstants.METRICS_SCOPE);
    private final String value;

    ScopeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
