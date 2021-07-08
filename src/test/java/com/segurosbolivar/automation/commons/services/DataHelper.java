package com.segurosbolivar.automation.commons.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.segurosbolivar.automation.commons.utils.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataHelper {

    private final Integer platformId;
    private final Integer caseId;
    private JSONObject data;

    public DataHelper(Integer platformId, Integer caseId) throws Exception {
        this.platformId = platformId;
        this.caseId = caseId;
        initData();
    }

    private void initData() throws Exception {
        data = DataService.getDataService(platformId, caseId);
        if (null == data)
            throw new Exception("Data not found");
    }

    public JSONArray getArrData() {
        ObjectMapper objectMapper = new ObjectMapper();
        Object arr = data.get("data");
        return objectMapper.convertValue(arr, JSONArray.class);
    }

    public JSONObject getAsserts() {
        return JsonParser.toJSONObject(data.get("asserts"));
    }

}
