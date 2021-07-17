package com.segurosbolivar.automation.commons.jira.zapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.segurosbolivar.automation.commons.jira.JiraConstants;
import com.segurosbolivar.automation.commons.jira.zapi.DOM.ExecStatus.CycleDOM;
import com.segurosbolivar.automation.commons.jira.zapi.DOM.ExecStatus.CycleExecution.ExecutionCycleDOM;
import com.segurosbolivar.automation.commons.jira.zapi.DOM.ExecStatus.CycleExecution.ExecutionForActiveExecutionDOM;
import com.segurosbolivar.automation.commons.jira.zapi.DOM.ExecStatus.ExecutionStatusDOM;
import com.segurosbolivar.automation.commons.jira.zapi.DOM.ExecStatus.StepExecutionList;
import com.segurosbolivar.automation.commons.jira.zapi.DOM.ExecStatus.TestExecutionList;
import com.segurosbolivar.automation.commons.jira.zapi.DOM.JiraIssue.IssueDOM;
import com.segurosbolivar.automation.commons.jira.zapi.DOM.Projects.ProjectOptionsDOM;
import com.segurosbolivar.automation.commons.jira.zapi.DOM.RequestDOM.StepResultUpdateDOM;
import com.segurosbolivar.automation.commons.jira.zapi.DOM.RequestDOM.TestExecution;
import com.segurosbolivar.automation.commons.jira.zapi.DOM.TestCycles.TestCycleDeserializer;
import com.segurosbolivar.automation.commons.jira.zapi.DOM.TestCycles.TestCycleList;
import com.segurosbolivar.automation.commons.jira.zapi.DOM.TestSteps.StepExecutionStatusDOM;
import com.segurosbolivar.automation.commons.jira.zapi.DOM.TestSteps.StepExecutionStatusListDOM;
import com.segurosbolivar.automation.commons.jira.zapi.DOM.TestStepsDOM;
import com.segurosbolivar.automation.commons.jira.zapi.DOM.Versions.VersionsList;
import com.segurosbolivar.automation.commons.jira.zapi.Utils.ConnectionUtils;
import com.segurosbolivar.automation.commons.jira.zapi.Utils.PropertiesParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;
import static org.apache.commons.lang3.StringUtils.isNumeric;


/**
 * Created by Chaitanya on 23-May-15.
 * Update by Sandra M. Arias R. 6-Nov-20.
 * Update by German D. Rojas 25-may-21
 */
public class ConnectionManager {

    static final String projectListUrl = "/rest/zapi/latest/util/project-list";
    static final String testCycleUrl = "/rest/zapi/latest/cycle";
    static final String testStepUrl = "/rest/zapi/latest/teststep";
    static final String versionsUrl = "/rest/zapi/latest/util/versionBoard-list";
    static final String linkIssue = "/rest/api/2/issueLink";
    static final String stepExecStatusUrl = "/rest/zapi/latest/util/teststepExecutionStatus";
    static final String testExecStatusUrl = "/rest/zapi/latest/util/testExecutionStatus";
    static final String fetchIssueUrl = "/rest/api/2/issue/";

    static final String addTestToCycleUrl = "/rest/zapi/latest/execution/addTestsToCycle";
    static final String changeTestExecutionUrl = "/rest/zapi/latest/execution/";
    static final String changeTestStepExecutionUrl = "/rest/zapi/latest/stepResult/";
    static final String getTestExecutionsUrl = "/rest/zapi/latest/execution/";
    static final String getTestStepExecutionIdUrl = "/rest/zapi/latest/stepResult";
    static final String initiateTestAfterExecUrl = "/secure/ExecuteTest!default.jspa";

    private static ConnectionManager connectionManager = new ConnectionManager();
    private static Gson gson = new Gson();
    private static URIBuilder uriBuilder = new URIBuilder();
    private static CycleDOM newIdCycleString;
    private GsonBuilder builder;
    public static CloseableHttpClient client;
    static Logger logger = Logger.getLogger(ConnectionManager.class.getName());


    ConnectionManager() {
        client = HttpClients.custom().setConnectionTimeToLive(60,TimeUnit.SECONDS).setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy() {

            @Override
            public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
                long keepAlive = super.getKeepAliveDuration(response, context);
                if (keepAlive == -1) {
                    keepAlive = 60 * 1000;
                }
                return keepAlive;
            }
        }).setMaxConnTotal(100).build();
    }

    public static ConnectionManager getInstance() {
        return connectionManager;
    }

    public static void refreshSession() throws IOException {

        client = HttpClients.custom().setConnectionTimeToLive(60,TimeUnit.SECONDS).setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy() {

            @Override
            public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
                long keepAlive = super.getKeepAliveDuration(response, context);
                if (keepAlive == -1) {
                    keepAlive = 60 * 1000;
                }
                return keepAlive;
            }
        }).setMaxConnTotal(100).build();
    }

    public static void closeConnection() throws IOException {
        uriBuilder = null;
        uriBuilder = new URIBuilder();
        client.close();

    }

    public static Gson getGson() {
        return gson;
    }

    public static HttpEntity makeRequest(HttpGet get) throws IOException {
        HttpResponse httpResponse = null;
        try {
           httpResponse = client.execute(get);

        }catch (SSLException ss){
            refreshSession();
            httpResponse = client.execute(get);
        }finally {

            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return httpResponse.getEntity();
            } else {
                logger.severe("RESPONSE CODE : " + httpResponse.getStatusLine().getStatusCode()
                        + "\nREASON : " + httpResponse.getStatusLine().getReasonPhrase());
                return null;
            }
        }

    }

    public static HttpEntity makeRequest(HttpPost post) throws IOException {
        HttpResponse httpResponse = client.execute(post);
        if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            return httpResponse.getEntity();
        } else {
            logger.severe("RESPONSE CODE : " + httpResponse.getStatusLine().getStatusCode()
                    + "\nREASON : " + httpResponse.getStatusLine().getReasonPhrase());
            return null;
        }
    }

    public static HttpEntity makeRequest(HttpPut put) throws IOException {
        HttpResponse httpResponse = null;
        try {
            httpResponse = client.execute(put);

        }catch (SSLException ss){
            refreshSession();
            httpResponse = client.execute(put);
        }finally {

            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return httpResponse.getEntity();
            } else {
                logger.severe("RESPONSE CODE : " + httpResponse.getStatusLine().getStatusCode()
                        + "\nREASON : " + httpResponse.getStatusLine().getReasonPhrase());
                return null;
            }
        }
    }

    public static HttpGet setGenericParams(HttpGet httpGet) {
        httpGet.setHeader("Authorization", ConnectionUtils.getEncodedAuthKey());
        httpGet.setHeader("Content-Type", "application/json");
        return httpGet;
    }

    public static HttpPost setGenericParams(HttpPost httpPost) {
        httpPost.setHeader("Authorization", ConnectionUtils.getEncodedAuthKey());
        httpPost.setHeader("Content-Type", "application/json; charset=utf-8");
        return httpPost;
    }

    public static HttpPut setGenericParams(HttpPut httpPut) {
        httpPut.setHeader("Authorization", ConnectionUtils.getEncodedAuthKey());
        httpPut.setHeader("Content-Type", "application/json");
        return httpPut;
    }

    // gets list of projects on Jira
    public static ProjectOptionsDOM getProjectsList() throws IOException, URISyntaxException {
        URI uri = uriBuilder.clearParameters()
                .setScheme("https")
                .setHost(PropertiesParser.getJiraHost())
                .setPort(PropertiesParser.getJiraPort())
                .setPath(projectListUrl)
                .build();
        HttpGet httpGet = new HttpGet(uri);
        setGenericParams(httpGet);
        logger.info(httpGet.getURI().toString());
        HttpEntity httpEntity = makeRequest(httpGet);
        JsonElement element = new JsonParser().parse(EntityUtils.toString(httpEntity));
        logger.info(element.toString());
        ProjectOptionsDOM retrievedOptions = null;
        if (element.isJsonObject()) {
            logger.info(String.valueOf(element.isJsonObject()));
            retrievedOptions = gson.fromJson(element.getAsJsonObject(), ProjectOptionsDOM.class);
        }
        EntityUtils.consume(httpEntity);
        return retrievedOptions;

        /*List<ProjectDOM> list = retreivedOptions.getOptions();
        logger.info(String.valueOf(list.size()));
        return list;*/
    }

    /**
     * Metodo que retorna todos los ciclos existentes en el proyecto y la version que se defina
     * @param projectId
     * @param versionId
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public static TestCycleList getTestCycles(long projectId, long versionId) throws URISyntaxException, IOException {
        URI uri = uriBuilder.setScheme("https")
                .clearParameters()
                .setHost(PropertiesParser.getJiraHost())
                .setPort(PropertiesParser.getJiraPort())
                .setPath(testCycleUrl)
                .setParameter("projectId", String.valueOf(projectId))
                .setParameter("versionId", String.valueOf(versionId))
                .setParameter("offset", "0")
                .setParameter("expand", "executionSummaries")
                .build();
        HttpGet httpGet = new HttpGet(uri); // TODO surround with try catch block
        setGenericParams(httpGet);
        logger.info(httpGet.getURI().toString());
        HttpEntity httpEntity = makeRequest(httpGet);
        String json = EntityUtils.toString(httpEntity);
        logger.info(json);
        String modifiedJson = json.replaceAll("[,][\"][r][e][c][o][r][d][s][C][o][u][n][t][\"][:][\\d]", "");

        int indiceAntepenultimoCaracterJson = modifiedJson.length() -2;
        String antePenultimoCaracter = String.valueOf(modifiedJson.charAt(indiceAntepenultimoCaracterJson));

        while (isNumeric(antePenultimoCaracter)== true){

            modifiedJson = new StringBuilder(modifiedJson).replace(indiceAntepenultimoCaracterJson, indiceAntepenultimoCaracterJson+1, "").toString();
            indiceAntepenultimoCaracterJson = modifiedJson.length() -2;
            antePenultimoCaracter = String.valueOf(modifiedJson.charAt(indiceAntepenultimoCaracterJson));
        }

        logger.info(modifiedJson);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(TestCycleList.class, new TestCycleDeserializer());
        Gson gson = gsonBuilder.setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES).create();
        TestCycleList testCycleList = gson.fromJson(modifiedJson, TestCycleList.class);
        EntityUtils.consume(httpEntity);
        return testCycleList;
    }

    /**
     * Metodo que retorna los Steps de una Issue tipo (PRUEBA)
     * @param idIssue
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public static TestStepsDOM[] getStepsIssue(long idIssue) throws URISyntaxException, IOException {
        URI uri = uriBuilder.setScheme("https")
                .clearParameters()
                .setHost(PropertiesParser.getJiraHost())
                .setPort(PropertiesParser.getJiraPort())
                .setPath(testStepUrl+"/"+idIssue).build();
        HttpGet httpGet = new HttpGet(uri); // TODO surround with try catch block
        setGenericParams(httpGet);
        HttpEntity httpEntity = makeRequest(httpGet);
        String json = EntityUtils.toString(httpEntity);
        json = json.replace("{\"stepBeanCollection\":", "");
        json = json.substring(0, json.length() - 1);
        TestStepsDOM[] array = gson.fromJson(json, TestStepsDOM[].class);
        EntityUtils.consume(httpEntity);
        /*
        for (TestStepsDOM x : array) {
            logger.info("ID : " + x.getId());
            logger.info("ORDER : " + x.getOrderId());
            logger.info("STEP : " + x.getStep());
            logger.info("RESULT : " + x.getResult());
        }
        */
        return array;
    }

    // get Versions List
    public static VersionsList getProjectVersions(long projectId) throws URISyntaxException, IOException {
        URI uri = uriBuilder.setScheme("https")
                .clearParameters()
                .setHost(PropertiesParser.getJiraHost())
                .setPort(PropertiesParser.getJiraPort())
                .setPath(versionsUrl)
                .setParameter("projectId", String.valueOf(projectId))
                .build();
        HttpGet httpGet = new HttpGet(uri); // TODO surround with try catch block
        setGenericParams(httpGet);
        //logger.info(httpGet.getURI().toString());
        HttpEntity httpEntity = makeRequest(httpGet);
        String json = EntityUtils.toString(httpEntity);
        //logger.info(json);
        VersionsList list = gson.fromJson(json, VersionsList.class);
        EntityUtils.consume(httpEntity);
        return list;
    }

    // gets list of Status codes supported for the Steps in a Test
    public static StepExecutionList getStepExecutionStatusSupported() throws URISyntaxException, IOException {
        URI uri = uriBuilder.setScheme("https")
                .clearParameters()
                .setHost(PropertiesParser.getJiraHost())
                .setPort(PropertiesParser.getJiraPort())
                .setPath(stepExecStatusUrl)
                .build();
        HttpGet httpGet = new HttpGet(uri);
        setGenericParams(httpGet);
        logger.info(httpGet.getURI().toString());
        HttpEntity httpEntity = makeRequest(httpGet);
        String json = EntityUtils.toString(httpEntity);
        logger.info(json);
        ExecutionStatusDOM[] stepStatusList = gson.fromJson(json, ExecutionStatusDOM[].class);
        StepExecutionList stepExecutionList = new StepExecutionList();
        stepExecutionList.setList(stepStatusList);
        EntityUtils.consume(httpEntity);
        return stepExecutionList;
    }

    // gets list of Status codes supported for the Test as a whole
    public static TestExecutionList getTestExecutionStatusSupported() throws URISyntaxException, IOException {

        URI uri = uriBuilder.setScheme("https")
                .clearParameters()
                .setHost(PropertiesParser.getJiraHost())
                .setPort(PropertiesParser.getJiraPort())
                .setPath(testExecStatusUrl)
                .build();
        HttpGet httpGet = new HttpGet(uri);
        setGenericParams(httpGet);
        logger.info(httpGet.getURI().toString());
        HttpEntity httpEntity = makeRequest(httpGet);
        String json = EntityUtils.toString(httpEntity);
        logger.info(json);
        ExecutionStatusDOM[] testStatusList = gson.fromJson(json, ExecutionStatusDOM[].class);
        TestExecutionList testExecutionList = new TestExecutionList();
        testExecutionList.setList(testStatusList);
        EntityUtils.consume(httpEntity);

        return testExecutionList;
    }

    /**
     * Metodo que devuelve la información basica de una issue.
     * @param key
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public static IssueDOM getIssue(String key) throws URISyntaxException, IOException {
        URI uri = uriBuilder.setScheme("https")
                .clearParameters()
                .setHost(PropertiesParser.getJiraHost())
                .setPort(PropertiesParser.getJiraPort())
                .setPath(fetchIssueUrl + key)
                .build();
        HttpGet httpGet = new HttpGet(uri);
        setGenericParams(httpGet);
        HttpEntity httpEntity = makeRequest(httpGet);
        String json = EntityUtils.toString(httpEntity);
        //logger.info("ISSUE JSON : " + json);
        if (json.contains("errorMessages")) {
            logger.severe("No existe esta issue");
            return null;
        }
        IssueDOM issue = gson.fromJson(json, IssueDOM.class);
        EntityUtils.consume(httpEntity);
        return issue;
    }

    /**
     * Verifica si una issue existe en el proyecto
     * @param key
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public static boolean existIssue(String key) throws URISyntaxException, IOException {
        boolean isValid = true;                         // default initialization to true
        URI uri = uriBuilder.setScheme("https")
                .clearParameters()
                .setHost(PropertiesParser.getJiraHost())
                .setPort(PropertiesParser.getJiraPort())
                .setPath(fetchIssueUrl + key)
                .build();
        HttpGet httpGet = new HttpGet(uri);
        setGenericParams(httpGet);
        HttpEntity httpEntity = makeRequest(httpGet);
        String json = EntityUtils.toString(httpEntity);
        logger.info("ISSUE VALID JSON : " + json);
        if (json.contains("errorMessages")) {
            logger.severe("No existe esta issue");
            isValid = false;
        }
        EntityUtils.consume(httpEntity);
        return isValid;
    }

    // change test Status to PASS,FAIL,WIP, etc.
    public static void changeTestStatus(long testExecutionId, int statusCode) throws URISyntaxException, IOException {
        URI uri = uriBuilder.setScheme("https")
                .clearParameters()
                .setHost(PropertiesParser.getJiraHost())
                .setPort(PropertiesParser.getJiraPort())
                .setPath(changeTestExecutionUrl + testExecutionId + "/execute")
                .build();

        HttpPut httpPut = new HttpPut(uri);
        setGenericParams(httpPut);

        String json = "{\"status\":" + Integer.toString(statusCode) + "}";
        logger.info(json);

        httpPut.setEntity(new StringEntity(json));

        logger.info(httpPut.toString());

        HttpEntity httpEntity = makeRequest(httpPut);

        InputStream is = httpEntity.getContent();
        is.close();
        EntityUtils.consume(httpEntity);
    }

    // associate bug to Test
    public static void changeTestStatusBecauseAssociateBug(long testExecutionId, String newIssue) throws URISyntaxException, IOException {
        URI uri = uriBuilder.setScheme("https")
                .clearParameters()
                .setHost(PropertiesParser.getJiraHost())
                .setPort(PropertiesParser.getJiraPort())
                .setPath(changeTestExecutionUrl + testExecutionId + "/execute")
                .build();

        HttpPut httpPut = new HttpPut(uri);

        setGenericParams(httpPut);

        String json = "{\"defectList\": [\"" + newIssue + "\"],\"updateDefectList\": \"true\"}";
        logger.info(json);

        httpPut.setEntity(new StringEntity(json));
        logger.info(httpPut.toString());

        HttpEntity httpEntity = makeRequest(httpPut);

        InputStream is = httpEntity.getContent();
        is.close();
        EntityUtils.consume(httpEntity);
    }


    /**
     * Metodo que permite Crear un Ejecucion de una issue (Prueba), sobre un ciclo
     * @param issue Nombre Key de la issue (Prueba)
     * @param versionId long versionId de la version
     * @param projectId long id del proyecto
     * @param cycleId long id del ciclo, al cual se le asociara la ejecucion de la issue.
     * @throws URISyntaxException
     * @throws IOException
     */
    public static void addTestToTestCycle(String issue, long versionId, long projectId, String cycleId)
            throws URISyntaxException, IOException {
        URI uri = uriBuilder.setScheme("https")
                .clearParameters()
                .setHost(PropertiesParser.getJiraHost())
                .setPort(PropertiesParser.getJiraPort())
                .setPath(addTestToCycleUrl)
                .build();
        HttpPost httpPost = new HttpPost(uri);

        setGenericParams(httpPost);
        TestExecution testExecution = new TestExecution(new String[]{issue}, versionId, cycleId, Long.toString(projectId), "1");
        String json = testExecution.toString();
        logger.info(json);
        httpPost.setEntity(new StringEntity(json));
        HttpEntity httpEntity = makeRequest(httpPost);
        logger.info(httpEntity.toString());
        EntityUtils.consume(httpEntity);
    }

    /**
     * Metodo que retorna los test que realizo  una ISSUE (Prueba) en los ciclos de prueba.
     * @param idIssue long
     * @return ExecutionCycleDOM
     * @throws URISyntaxException
     * @throws IOException
     */
    public static ExecutionCycleDOM getTestExecutionForIssue(long idIssue) throws URISyntaxException, IOException {
        URI uri = uriBuilder.setScheme("https")
                .clearParameters()
                .setHost(PropertiesParser.getJiraHost())
                .setPort(PropertiesParser.getJiraPort())
                .setPath(getTestExecutionsUrl)
                .setParameter("issueId", Long.toString(idIssue))
                .build();
        HttpGet httpGet = new HttpGet(uri);
        setGenericParams(httpGet);
        HttpEntity httpEntity = makeRequest(httpGet);
        String json = EntityUtils.toString(httpEntity);
        logger.info(uri.toString());
        logger.info(json);
        ExecutionCycleDOM executionCycleDOM = gson.fromJson(json, ExecutionCycleDOM.class);
        EntityUtils.consume(httpEntity);
        return executionCycleDOM;
    }


    // change step status via a detailed execute method
    public static void changeStepStatus(long id, String issueId, long stepExecutionId, String status) throws URISyntaxException, IOException {
        URI uri = uriBuilder.setScheme("https")
                .clearParameters()
                .setHost(PropertiesParser.getJiraHost())
                .setPort(PropertiesParser.getJiraPort())
                .setPath(changeTestStepExecutionUrl + id)
                .build();
        HttpPut httpPut = new HttpPut(uri);
        setGenericParams(httpPut);
        logger.info(httpPut.toString());
        StepResultUpdateDOM requestBody = new StepResultUpdateDOM(id, issueId, stepExecutionId, status);
        logger.info(requestBody.toString());
        httpPut.setEntity(new StringEntity(requestBody.toString()));
        HttpEntity entity = makeRequest(httpPut);
        EntityUtils.consume(entity);
    }

    // gets unique identifier step to execution id
    public static StepExecutionStatusListDOM getStepExecutionForIssue(long executionId) throws URISyntaxException, IOException {

        // Activando la API para crear ID del paso de la prueba
        getIdExecutionForActiveExecution(String.valueOf(executionId));

        // Una vez que active la API anterior, se creará stepresult / stepid.
        URI uri = uriBuilder.setScheme("https")
                .clearParameters()
                .setHost(PropertiesParser.getJiraHost())
                .setPort(PropertiesParser.getJiraPort())
                .setPath(getTestStepExecutionIdUrl)
                .setParameter("executionId", String.valueOf(executionId))
                .build();
        HttpGet httpGet = new HttpGet(uri);
        setGenericParams(httpGet);
        logger.info(httpGet.toString());
        HttpEntity httpEntity = makeRequest(httpGet);
        String response = EntityUtils.toString(httpEntity);
        logger.info(response);
        StepExecutionStatusDOM[] list = gson.fromJson(response, StepExecutionStatusDOM[].class);
        StepExecutionStatusListDOM stepList = new StepExecutionStatusListDOM(list);
        EntityUtils.consume(httpEntity);
        return stepList;
    }

    //  Obtenga el ID de ejecución y active la siguiente API para crear ID de paso

    /**
     *
     * @param executionId
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public static ExecutionForActiveExecutionDOM getIdExecutionForActiveExecution(String executionId) throws URISyntaxException, IOException {
        URI uri = uriBuilder.setScheme("https")
                .clearParameters()
                .setHost(PropertiesParser.getJiraHost())
                .setPort(PropertiesParser.getJiraPort())
                .setPath(getTestExecutionsUrl + executionId)
                //.setParameter("executionId", String.valueOf(executionId))
                .setParameter("expand", "checksteps")
                //.setPath("?expand=checksteps")
                .build();
        logger.info("getIdExecutionForActiveExecution |0|0|0|0|0|0|0|0 "+uri.toString());
        HttpGet httpGet = new HttpGet(uri);
        setGenericParams(httpGet);
        HttpEntity httpEntity = makeRequest(httpGet);
        String json = EntityUtils.toString(httpEntity);
        logger.info(json);
        ExecutionForActiveExecutionDOM executionForActiveExecutionDOM = gson.fromJson(json, ExecutionForActiveExecutionDOM.class);
        EntityUtils.consume(httpEntity);
        return executionForActiveExecutionDOM;
    }

    public static void initiateTestStepsAfterExecution(long stepId, long executionId) throws URISyntaxException, IOException {
        URI uri = uriBuilder.clearParameters()
                .setScheme("https")
                .setHost(PropertiesParser.getJiraHost())
                .setPort(PropertiesParser.getJiraPort())
                .setPath(changeTestStepExecutionUrl)
                .build();
        String body = "{\"stepId\" : " + stepId + ",\"executionId\" : " + executionId + " } ";
        HttpPost httpPost = new HttpPost(uri);
        setGenericParams(httpPost);
        httpPost.setEntity(new StringEntity(body));
        logger.info(httpPost.toString());
        HttpEntity httpEntity = makeRequest(httpPost);
        EntityUtils.consume(httpEntity);
    }

    /**
     * Firma un paso de prueba sobre una Issue (Prueba)
     * @param IssueId
     * @param step
     * @param data
     * @param result
     * @throws URISyntaxException
     * @throws IOException
     */
    public static void addTestStepToTestCase(String IssueId, String step, String data, String result) throws URISyntaxException, IOException {
        URI uri = uriBuilder.clearParameters()
                .setScheme("https")
                .setHost(PropertiesParser.getJiraHost())
                .setPort(PropertiesParser.getJiraPort())
                .setPath(testStepUrl + "/"+ IssueId)
                .build();
        String body = "{\"step\" : \"" + step + "\",\"data\" : \"" + data + "\",\"result\" : \"" + result + "\" } ";
        HttpPost httpPost = new HttpPost(uri);
        setGenericParams(httpPost);
        httpPost.setEntity(new StringEntity(body));
        //logger.info(httpPost.toString());
        HttpEntity httpEntity = makeRequest(httpPost);
        EntityUtils.consume(httpEntity);
    }

    public static CycleDOM createCycle (String nameCycle, String descriptionCycle, String startDateCycle, String endDateCycle, long projectId, long versionId) throws URISyntaxException, IOException {

        URI uri = uriBuilder.clearParameters()
                .setScheme("https")
                .setHost(PropertiesParser.getJiraHost())
                .setPort(PropertiesParser.getJiraPort())
                .setPath(testCycleUrl)
                .build();

        String body = "{  \"clonedCycleId\": \"\",  \"name\": \""+nameCycle+"\",  \"build\": \"\",  \"environment\": \"\",  \"description\": \""+descriptionCycle+"\",  \"startDate\": \""+startDateCycle+"\",  \"endDate\": \""+endDateCycle+"\",  \"projectId\": \""+projectId+"\",  \"versionId\": \""+versionId+"\"}";
        HttpPost httpPost = new HttpPost(uri);
        setGenericParams(httpPost);
        httpPost.setEntity(new StringEntity(body));
        logger.info(httpPost.toString());
        HttpEntity httpEntity = makeRequest(httpPost);

        String json = EntityUtils.toString(httpEntity);
        logger.info("NEW CYCLE ID JSON : " + json);
        if (json.contains("errorMessages")) {
            logger.severe("No existe esta issue");
            return null;
        }
        CycleDOM cycle = gson.fromJson(json, CycleDOM.class);

        EntityUtils.consume(httpEntity);

        newIdCycleString = cycle;

        return cycle;

    }


    /**
     * Metodo que permite enlazar issues
     * @param keyIssueSource
     * @param keyIssue
     * @param typeLink
     */
    public static void linkIssues(String keyIssueSource, String keyIssue,String typeLink) throws URISyntaxException, IOException{
        URI uri = uriBuilder.clearParameters()
                .setScheme("https")
                .setHost(PropertiesParser.getJiraHost())
                .setPort(PropertiesParser.getJiraPort())
                .setPath(linkIssue).build();

        HttpPost httpPost = new HttpPost(uri);
        setGenericParams(httpPost);
        String jsonBody =  "{\"type\": { \"id\":\"10303\" }," +
                           "\"inwardIssue\": { \"key\": \""+keyIssueSource+"\"}," +
                           "\"outwardIssue\": {\"key\": \""+keyIssue+"\"}}";
        System.out.println(jsonBody);
        httpPost.setEntity(new StringEntity(jsonBody));
        HttpEntity httpEntity = makeRequest(httpPost);
        EntityUtils.consume(httpEntity);
    }


    /**
     * Metodo que permite hacer una transccion de una issue sobre el flujo de trabajo
     * @param keyIssue
     * @param typeTransition
     * @throws URISyntaxException
     * @throws IOException
     */
    public static  void DoTransitionIssue(String keyIssue, String typeTransition)  throws URISyntaxException, IOException{
        URI uri = uriBuilder.clearParameters()
                .setScheme("https")
                .setHost(JiraConstants.JIRA_HOST)
                .setPort(Integer.parseInt(JiraConstants.JIRA_PORT))
                .setPath(fetchIssueUrl+keyIssue+"/transitions").build();

        HttpPost httpPost = new HttpPost(uri);
        setGenericParams(httpPost);
        String jsonBody =  "{\"transition\": { \"id\":\"81\",  \"name\":\"Error_encontrado\" }}";
        httpPost.setEntity(new StringEntity(jsonBody));
        HttpEntity httpEntity = makeRequest(httpPost);
        EntityUtils.consume(httpEntity);
    }






    public static void main(String[] args) throws IOException, URISyntaxException {
        /*long projectId = getProjectsList().getProjectIdForProjectName("TEST");
        long versionId = getProjectVersions(projectId).findUnreleasedProjectVersion("2015.09.03").getValue();
        String cycleId = Integer.toString(getTestCycles(projectId, versionId).getTestCycleIdFromName("Automated"));
        logger.info("PROJECT : " + projectId + "\tVERSION : " + versionId + "\tCYCLE : " + cycleId);
        String issues = "TEST-1";
        addTestToTestCycle(issues, versionId, projectId, cycleId);*/
//        getTestExecutionForIssue(10000);
//        changeStepStatus(9, String.valueOf(10000), 8, String.valueOf(TestStatus.sStatus_PASS));

        /*StepExecutionStatusListDOM list = getStepExecutionForIssue(8);
        logger.info(String.valueOf(list.getExecutionIdForEachTestStep(2).getId()));*/
//        TestCycleList l = getTestCycles(10000,10000);
//        logger.info(String.valueOf(l.getTestCycleIdFromName("Automated")));
//        closeConnection();

        /*TestStepsDOM [] steps = ConnectionManager.getTestSteps(10000);
        for(TestStepsDOM x : steps){
            logger.info(x.toString());
        }*/
        /*
        TestObject.createTestObject("TEST-1");
        TestObject.getInstance().getExecutionForTest();
//        TestObject.getInstance().executeTestUnderCycle();
        for (TestStepsDOM x : TestObject.getInstance().testSteps) {
            logger.info(x.toString());
        }
//        TestObject.getInstance().markCurrentStepAs(TestStatus.iStatus_WIP);


         */


    DoTransitionIssue("AUTMT-439","");


    }
}