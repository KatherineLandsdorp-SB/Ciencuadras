package com.segurosbolivar.automation.commons.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;

public class JsonParser {
    public static JSONObject toJSONObject(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(obj, JSONObject.class);
    }
}
