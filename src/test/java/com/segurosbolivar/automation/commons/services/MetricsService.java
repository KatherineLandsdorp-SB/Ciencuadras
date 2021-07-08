package com.segurosbolivar.automation.commons.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.segurosbolivar.automation.commons.models.CaseExecution;
import com.segurosbolivar.automation.commons.models.Execution;
import com.segurosbolivar.automation.commons.services.utils.ServiceConstants;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MetricsService {

    private static String token;

    public static void setToken(Token token) {
        MetricsService.token = token.getToken();
    }

    public static Integer setExecution(Execution execution) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = new HashMap<>();
        data.put("idSuite", execution.idSuite);
        data.put("idEnvironment", execution.idEnvironment);
        data.put("idStateExecution", execution.idStateExecution);
        data.put("idProvider", execution.idProvider);
        data.put("idTypeAutomation", execution.idTypeAutomation);
        data.put("idTypeExecution", execution.idTypeExecution);
        data.put("jiraProject", execution.jiraProject);
        data.put("jiraIssue", execution.jiraIssue);
        data.put("requestDate", execution.requestDate);
        data.put("executor", execution.executor);
        String request = mapper.writeValueAsString(data);
        JSONObject response = given()
                .auth().oauth2(token)
                .baseUri(ServiceConstants.BASE_URL)
                .basePath(ServiceConstants.BASE_PATH)
                .contentType("application/json")
                .body(request)
                .when()
                .post("/executions")
                .peek() // Use peek() to print the output response
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(JSONObject.class);
        return Integer.parseInt(response.get("id").toString());
    }

    public static void setCaseExecution(CaseExecution caseExecution) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = new HashMap<>();
        data.put("idExecution", caseExecution.idExecution);
        data.put("idCase", caseExecution.idCase);
        data.put("idStateExecution", caseExecution.idStateExecution);
        data.put("startDate", caseExecution.startDate);
        data.put("endDate", caseExecution.startDate);
        data.put("dataInputExecution", caseExecution.dataInputExecution);
        data.put("dataOutputExecution", caseExecution.dataOutputExecution);
        String request = mapper.writeValueAsString(data);
        given()
                .auth().oauth2(token)
                .baseUri(ServiceConstants.BASE_URL)
                .basePath(ServiceConstants.BASE_PATH)
                .contentType("application/json")
                .body(request)
                .when()
                .post("/executioncases")
                .peek() // Use peek() to print the output response
                .then()
                .statusCode(200)
                .extract()
                .body();
    }
}
