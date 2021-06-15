package com.segurosbolivar.automation.commons;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.segurosbolivar.automation.commons.utils.JsonParser;
import com.segurosbolivar.automation.commons.utils.PropertyManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Data {
    private  JSONObject data;
    private  Services services;

    public Data(Integer testId) throws Exception{
        this.services = new Services();
       initData(testId);
    }

    private  void initData(Integer testId) throws Exception {
        data = services.getDataService(PropertyManager.getConfigValueByKey("idPortal"), testId);
        if (null == data)
            throw new Exception("Data not found");
    }

    private  JSONObject getData(Integer index) {
        ObjectMapper objectMapper = new ObjectMapper();
        Object arr = data.get("data");
        JSONArray arrData = objectMapper.convertValue(arr, JSONArray.class);
        return JsonParser.toJSONObject(arrData.get(index));
    }

    private  JSONObject getAsserts() {
        return JsonParser.toJSONObject(data.get("asserts"));
    }

    public  String getDataField(String entity) {
        JSONObject data = getData(0);
        return data.get(entity).toString();
    }

    public String getDataField(Integer index, String entity) {
        JSONObject data = getData(index);
        return data.get(entity).toString();
    }

    public  String getAssertField(String entity) {
        JSONObject asserts = getAsserts();
        return asserts.get(entity).toString();
    }
}