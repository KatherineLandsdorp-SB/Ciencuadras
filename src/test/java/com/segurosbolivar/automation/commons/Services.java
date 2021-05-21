package com.segurosbolivar.automation.commons;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.segurosbolivar.automation.commons.utils.PropertyManager;
import com.segurosbolivar.automation.commons.utils.TestingExecution;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import io.qameta.allure.Allure;
import okhttp3.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Services {
    private static String token;
    private static JSONObject jsonObj = new JSONObject();
    private static JSONArray jsonArray = new JSONArray();
    private static org.json.simple.JSONObject jsonElements;
    private static String outputElements = new String();
    public static void getToken(String extent) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("https://autoqa-prod.auth.us-east-1.amazoncognito.com/oauth2/token");
        String base64Credentials = Base64.getEncoder().encodeToString(("4h2socn50j29j5671b8sr3sr9j" +
                ":" + "14ps9e5gtfn6ep3a5i7qunp35e3fsot8bqj0b314mpk7cdddkq1i").getBytes());
        httpPost.addHeader("Authorization", "Basic " + base64Credentials);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
        String grant_type = "client_credentials";
        String scope = extent;
        StringEntity input = null;
        try {
            input = new StringEntity("grant_type=" + grant_type +
                    "&scope=" + scope);
            httpPost.setEntity(input);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            Map<String, Object> res = new ObjectMapper().readValue(response.getEntity().getContent(), HashMap.class);
            token = res.get("access_token").toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void getDataService(String platform, String caso) {
        try {
            String scope = "services/data";
            getToken(scope);
            Client client = Client.create();
            System.out.println("https://7scw0ywnt9.execute-api.us-east-1.amazonaws.com/prod/data/"+platform+"/case/"+caso);
            WebResource webResource = client.resource("https://7scw0ywnt9.execute-api.us-east-1.amazonaws.com/prod/data/"+platform+"/case/"+caso);
            ClientResponse response = webResource
                    .header("Authorization", "Bearer "+token)
                    .accept("application/json").get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
            String output = response.getEntity(String.class);
            jsonObj = new JSONObject(output);
            jsonArray = jsonObj.getJSONArray("data");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getAssert(String entity){
        return  "HOLA PRUEBAS";
    }

    public static void getElements(String platform, String environmentId ) {
        try {
            String scope = "services/data";
            getToken(scope);
            Client client = Client.create();
            System.out.println("https://7scw0ywnt9.execute-api.us-east-1.amazonaws.com/prod/elements/"+platform+"/environment/"+environmentId);
            WebResource webResource = client.resource("https://7scw0ywnt9.execute-api.us-east-1.amazonaws.com/prod/elements/"+platform+"/environment/"+environmentId);
            ClientResponse response = webResource
                    .header("Authorization", "Bearer "+token)
                    .accept("application/json").get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
            String output = response.getEntity(String.class);
            jsonObj = new JSONObject(output);
            outputElements = jsonObj.getJSONObject("elements").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String outputElements(){
       return outputElements;
    }

    public static String setExecution(String idSuite, String idEnvironment, String idStateExecution, String jiraProject, String JiraIssue, String executor) {
        try {
            Date myDate = new Date();
            String requestDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").format(myDate);
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            String data =
                    "{\n  \"idSuite\": "+"\""+idSuite+"\",\n" +
                    " \"idEnvironment\": "+"\""+idEnvironment+"\",\n" +
                    "\"idStateExecution\" : "+"\""+idStateExecution+"\",\n" +
                    "\"jiraProject\" : "+"\""+jiraProject+"\",\n" +
                    "\"jiraIssue\" : "+"\""+JiraIssue+"\",\n" +
                    "\"requestDate\": "+"\""+requestDate +"\",\n" +
                    "\"executor\": "+"\""+executor+"\"}";

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, data);
            Request request = new Request.Builder()
                    .url("https://7scw0ywnt9.execute-api.us-east-1.amazonaws.com/prod/executions")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", "Bearer " + token)
                    .build();
            Response response = client.newCall(request).execute();
            JSONObject myObject = new JSONObject(response.body().string());
            String IdExecution = myObject.getString("id");
            TestingExecution.idExecution = IdExecution;
            return IdExecution;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setCaseExecution(String idExecution, String idCase, String idStateExecution, String idTypeExecution,  String startDate, String endDate) {
        try {
            Date myDate = new Date();
            String requestDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").format(myDate);
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            String data =
                    "{\n  \"idExecution\": "+"\""+idExecution+"\",\n" +
                    "\"idCase\": "+"\""+idCase+"\",\n" +
                    "\"idStateExecution\" : "+"\""+idStateExecution+"\",\n" +
                    "\"idTypeExecution\" : "+"\""+idTypeExecution+"\",\n" +
                    "\"startDate\" : "+"\""+startDate+"\",\n" +
                    "\"endDate\": "+"\""+endDate +"\"}";

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, data);
            Allure.addAttachment("HTTP: ", data);

            Request request = new Request.Builder()
                    .url("https://7scw0ywnt9.execute-api.us-east-1.amazonaws.com/prod/executioncases")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", "Bearer " + token)
                    .build();
            Response response = client.newCall(request).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void jiraIssue(String idProject, String summary, String description) {

        try {
            Client client = Client.create();
            String data =
                    "{\n    \"fields\": {" +
                            "\n       \"project\":\n       {" +
                            "\n          \"id\": "+idProject+"" +
                            "},\n       " +
                            "\"summary\": "+ summary +"" +
                            "\"description\":"+ description +"" +
                            "\"issuetype\": {\n " +
                            "\"id\": \"10505\"\n " +
                            "}\n   }\n}";

            WebResource webResource = client.resource("https://jira.segurosbolivar.com/rest/api/2/issue/");
            ClientResponse response = webResource.accept("application/json").post(ClientResponse.class, data);
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


    public void uploadObjectsS3(String nameFile, String data){
        Regions clientRegion = Regions.US_EAST_1;
        String bucketName = "autoqa-prod-automation";
        String objectKey = nameFile; //NameFileS3
        try {
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withCredentials(new DefaultAWSCredentialsProviderChain().getInstance())
                    .withRegion(clientRegion)
                    .build();

            Date expiration = new Date();
            long expTimeMillis = expiration.getTime();
            expTimeMillis += 1000 * 10 * 10;
            expiration.setTime(expTimeMillis);

            GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, objectKey)
                    .withMethod(HttpMethod.PUT)
                    .withExpiration(expiration);

            URL url = s3Client.generatePresignedUrl(generatePresignedUrlRequest);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("PUT");
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            out.write(data);
            out.close();
            connection.getResponseCode();
            S3Object object = s3Client.getObject(bucketName, objectKey);
        }catch (AmazonServiceException e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void uploadFileS3(String nameFile){
        Regions clientRegion = Regions.US_EAST_1;
        String bucketName = "autoqa-prod-automation";
        String objectKey = nameFile; //NameFileS3
        try {
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withCredentials(new DefaultAWSCredentialsProviderChain().getInstance())
                    .withRegion(clientRegion)
                    .build();

            Date expiration = new Date();
            long expTimeMillis = expiration.getTime();
            expTimeMillis += 1000 * 10 * 10;
            expiration.setTime(expTimeMillis);

            String getFileLocal = new File("src/test/java/com/segurosbolivar/automation/commons/uploadFile/").getAbsolutePath();
            PutObjectRequest request = new PutObjectRequest(bucketName,  nameFile, new File(getFileLocal+"/"+nameFile));
            s3Client.putObject(request);
        }catch (AmazonServiceException e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        }
    }

    public void donwloadObjectsS3(String nameFile){
        Regions clientRegion = Regions.US_EAST_1;
        String bucketName = "autoqa-prod-automation";
        String objectKey = nameFile; //NameFileS3
        try {
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withCredentials(new DefaultAWSCredentialsProviderChain().getInstance())
                    .withRegion(clientRegion)
                    .build();

            Date expiration = new Date();
            long expTimeMillis = expiration.getTime();
            expTimeMillis += 1000 * 10 * 10;
            expiration.setTime(expTimeMillis);
            String getFileLocal = new File("src/test/java/com/segurosbolivar/automation/commons/uploadFile/").getAbsolutePath();
            S3Object fullObject;
            s3Client.getObject(
                    new GetObjectRequest(bucketName, nameFile),
                    new File(getFileLocal+"/"+nameFile)
            );
        }catch (AmazonServiceException e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        }
    }

    String getFileLocal() {
        return new File("src/test/java/com/segurosbolivar/automation/commons/uploadFile/").getAbsolutePath();
    }
}
