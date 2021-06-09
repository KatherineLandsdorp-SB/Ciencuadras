package com.segurosbolivar.automation.commons.services.utils;

import java.util.Base64;

public class Credentials {
    public static String encodeCredentials() {
        return Base64.getEncoder().encodeToString((ServiceConstants.USER_NAME +
                ":" + ServiceConstants.PASS).getBytes());
    }
}
