package com.segurosbolivar.automation.commons.services;


import com.segurosbolivar.automation.commons.services.utils.ServiceConstants;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class DataService {
    private static String token;

    public static void setToken(Token token) {
        DataService.token = token.getToken();
    }

    public static JSONObject getDataService(Integer platformId, Integer caseId) {
        return given()
                .auth().oauth2(token)
                .baseUri(ServiceConstants.BASE_URL)
                .basePath(ServiceConstants.BASE_PATH)
                .get("/data/{platformId}/case/{caseId}", platformId, caseId)
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(JSONObject.class);
    }

    public static JSONObject getElements(Integer platformId, Integer environmentId) {
        return given()
                .auth().oauth2(token)
                .baseUri(ServiceConstants.BASE_URL)
                .basePath(ServiceConstants.BASE_PATH)
                .get("/elements/{platformId}/environment/{caseId}", platformId, environmentId)
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(JSONObject.class);
    }
}
