package com.segurosbolivar.automation.commons;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.research.ws.wadl.Response;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

public class Services {
    JSONObject jsonObj = new JSONObject();
    JSONArray jsonArray = new JSONArray();

    public void getDataService(String portal) {

        try {
            Client client = Client.create();
            WebResource webResource = client.resource("https://us-central1-ucroniadata.cloudfunctions.net/app/portal/" + portal);
            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
            String output = response.getEntity(String.class);

            jsonObj = new JSONObject(output);
            jsonArray = jsonObj.getJSONArray("result");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getField(String field){
        String res = "";
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject explrObject = jsonArray.getJSONObject(i);
                res = explrObject.getString(field);
                return res;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
