package com.segurosbolivar.automation.commons.services;

import com.segurosbolivar.automation.commons.enums.ScopeType;
import com.segurosbolivar.automation.commons.services.utils.Credentials;
import com.segurosbolivar.automation.commons.services.utils.ServiceConstants;
import io.restassured.http.ContentType;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class Token {

    private final ScopeType scope;

    private String token;

    public Token(ScopeType scope) {
        this.scope = scope;
    }

    public Token buildToken() {
        String base64Credentials = Credentials.encodeCredentials();
        HashMap resp = given()
                .when()
                .header("Authorization", "Basic " + base64Credentials)
                .contentType(ContentType.URLENC)
                .queryParam("grant_type", "client_credentials")
                .queryParam("scope", scope.getValue())
                .baseUri(ServiceConstants.AUT_BASE_URL)
                .basePath("/oauth2")
                .post("/token")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(HashMap.class);
        token = resp.get("access_token").toString();
        return this;
    }

    public String getToken() {
        if (null == token)
            this.buildToken();
        return token;
    }


}
