package com.segurosbolivar.automation.commons;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.simple.JSONObject;

@ToString
public class Data {
    @Getter
    private final JSONObject data;
    @Getter
    private final JSONObject asserts;
    @Getter
    @Setter
    private JSONObject dataOutputExecution;
    @Getter
    @Setter
    private JSONObject dataOutputPerformance;


    public Data(JSONObject data, JSONObject asserts) {
        this.data = data;
        this.asserts = asserts;
    }

    public String getDataField(String entity) {
        return data.get(entity).toString();
    }

    public String getAssertField(String entity) {
        return asserts.get(entity).toString();
    }
}
