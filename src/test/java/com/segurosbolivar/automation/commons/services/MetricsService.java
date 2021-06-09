package com.segurosbolivar.automation.commons.services;

public class MetricsService {

    private static String token;

    public MetricsService(Token token) {
        this.token = token.getToken();
    }

    public static void setToken(Token token) {
        MetricsService.token = token.getToken();
    }
}
