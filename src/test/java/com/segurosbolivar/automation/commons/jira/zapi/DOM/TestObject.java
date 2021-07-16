package com.segurosbolivar.automation.commons.jira.zapi.DOM;



import com.segurosbolivar.automation.commons.jira.zapi.ConnectionManager;
import com.segurosbolivar.automation.commons.jira.zapi.DOM.ExecStatus.CycleExecution.ExecutionCycleDOM;
import com.segurosbolivar.automation.commons.jira.zapi.DOM.ExecStatus.StepExecutionList;
import com.segurosbolivar.automation.commons.jira.zapi.DOM.ExecStatus.TestExecutionList;
import com.segurosbolivar.automation.commons.jira.zapi.DOM.JiraIssue.IssueDOM;
import com.segurosbolivar.automation.commons.jira.zapi.DOM.TestCycles.TestCycleList;
import com.segurosbolivar.automation.commons.jira.zapi.DOM.TestSteps.StepExecutionStatusListDOM;
import com.segurosbolivar.automation.commons.jira.zapi.Utils.PropertiesParser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Logger;

/**
 * Created by Chaitanya on 13-Jun-15.
 * Update by Sandra M. Arias R. 6-Nov-20.
 */
public class TestObject {
    private StepExecutionList stepExecutionList;
    private TestExecutionList testExecutionList;
    private TestCycleList testCycleList;
    public TestStepsDOM[] testSteps;
    private IssueDOM issue;
    private static TestObject testObject = null;
    private ExecutionCycleDOM executionCycleDOM;
    String key;
    String nameCycle;
    String testIssueType;
    long versionId;
    long projectId;
    public long executionId = -1;
    boolean testExecutedInSession = false;
    public int stepNumberUnderExecution = 0;

    static Logger logger = Logger.getLogger(TestObject.class.getName());

    public static TestObject createTestObject(IssueDOM issue, long versionId, String nameCycle,TestCycleList testCycleList) throws IOException, URISyntaxException {
        if (testObject == null) {
            testObject = new TestObject(issue,versionId,nameCycle,testCycleList);
        }else {
            testObject.issue = issue;
            testObject.versionId = versionId;
            testObject.nameCycle = nameCycle;
            testObject.testCycleList = testCycleList;
        }
        return testObject;
    }

    public static TestObject getInstance() {
        return testObject;
    }


    // TODO :  Make Singleton with Global Access
    protected TestObject(IssueDOM issue,long versionId, String nameCycle,TestCycleList testCycleList) throws IOException, URISyntaxException {
        this.nameCycle = nameCycle;
        this.issue = issue;
        this.versionId = versionId;
        this.key = issue.getKey();
        this.testCycleList = testCycleList;

        if (ConnectionManager.existIssue(key)) {
            System.out.println("Entro en la creacion del objeto "+ issue.getKey());
            testIssueType = PropertiesParser.getJiraTestIssueType(); // Consulta el tipo de issue en la propiedades
            if (issue.getIssueType().equalsIgnoreCase(testIssueType)) {
                projectId = issue.getProjectId();
            } else {
                logger.severe("ISSUE KEY NO VALIDA");
            }

            //retorna los tipos de status de ejecucion que posee cada step (WIMP,FAIL,PASS)
            this.stepExecutionList = ConnectionManager.getStepExecutionStatusSupported();

            //retorna los tipos de status de ejcucion que posse el ciclo completo (WIMP,Superado,Bloqueada)
            this.testExecutionList = ConnectionManager.getTestExecutionStatusSupported();

            testSteps = ConnectionManager.getStepsIssue(issue.getIdAsLong());

            executionId = getExecutionForTest();

            if (executionId == -1) {
                logger.info("TEST no ejecutado bajo el ciclo de prueba actual.");
                executeTestUnderCycle();
                executionId = getExecutionForTest();
                initTestStep();
            }
            System.out.println("SE VALIDAN DATOS NECESARIOS DEL TEST OBJECT " +issue.getKey());
            getTestStepsWithExecutionIds();
//            markStepStatusTo(testSteps[0].getExecutionId(), TestStatus.iStatus_WIP);
        }else {
            System.out.println("ESO NO EXISTE MIJO");
        }
    }

    /**
     * Obtiene el id de la ultimo ciclo de pruebas asociado
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    public long getExecutionForTest() throws IOException, URISyntaxException {
        ConnectionManager.refreshSession();
        executionCycleDOM = ConnectionManager.getTestExecutionForIssue(issue.getIdAsLong());
        executionId = executionCycleDOM.getIdByVersion(versionId);
        logger.info("EXECUTION ID : " + executionId);
        return executionId;
    }

    // executes a Test under a given test cycle
    public void executeTestUnderCycle() throws IOException, URISyntaxException {
            ConnectionManager.addTestToTestCycle(issue.getKey(),
                    versionId,
                    issue.getProjectId(),
                    Integer.toString(testCycleList.getTestCycleIdFromName(nameCycle)));
        testExecutedInSession = true;

    }

    public void markTestStatusTo(int statusToSet) throws IOException, URISyntaxException {
        ConnectionManager.changeTestStatus(executionId, statusToSet);
        logger.info("El estado del caso de prueba cambió a : " + statusToSet);
    }


    public void markStepStatusTo(long id, int statusToSet) throws IOException, URISyntaxException {
        ConnectionManager.changeStepStatus(id, issue.getIdAsString(), executionId, String.valueOf(statusToSet));
    }

    public void getTestStepsWithExecutionIds() throws IOException, URISyntaxException {
        testSteps = ConnectionManager.getStepsIssue(issue.getIdAsLong());
        StepExecutionStatusListDOM stepExecutionStatusList = ConnectionManager.getStepExecutionForIssue(executionId);
        for (TestStepsDOM iterator : testSteps) {
            int id = iterator.getId();
            iterator.setExecutionId((stepExecutionStatusList.getExecutionIdForEachTestStep(id)));
        }
    }

    public void markCurrentStepAs(int status) throws IOException, URISyntaxException {
        markStepStatusTo(testSteps[stepNumberUnderExecution].getExecutionId(), status);
        logger.info("PASO MARCADO COMO : " + status);
        stepNumberUnderExecution++;
    }

    public void initTestStep() throws IOException, URISyntaxException {
        for (TestStepsDOM iterator : testSteps) {
            ConnectionManager.initiateTestStepsAfterExecution(iterator.getId(), executionId);
        }
    }

    @Override
    public String toString() {
        return "NOMBRE DEL ISSUE : " + issue.getKey()
                + "\nISSUE ID : " + issue.getIdAsLong()
                + "\nPROJECT ID : " + issue.getProjectId()
                + "\nNOMBRE DEL PROYECTO : " + issue.getProjectName()
                + "\nVERSION ID : " + versionId;

    }
}
