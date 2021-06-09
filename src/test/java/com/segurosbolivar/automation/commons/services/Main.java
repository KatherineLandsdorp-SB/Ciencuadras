package com.segurosbolivar.automation.commons.services;


import com.segurosbolivar.automation.commons.enums.ScopeType;
import io.restassured.RestAssured;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        System.out.println(ScopeType.SERVICES_DATA.getValue());
        Token token = new Token(ScopeType.SERVICES_DATA).buildToken();

        // DataService dataService = new DataService(new Token(ScopeType.SERVICES_DATA));
//        JSONObject resp = dataService.getDataService(1, 1);
//        ObjectMapper objectMapper = new ObjectMapper();
//        Object ar = resp.get("data");
//        JSONArray data = objectMapper.convertValue(ar, JSONArray.class);
        //System.out.println(data.get(0));

        // JSONObject resp = dataService.getElements(1, 1);
        // System.out.println(resp);

    }
}
