package com.segurosbolivar.automation.commons.jira.zapi.DOM.ExecStatus.CycleExecution;

import java.util.List;

/**
 * Created by Chaitanya on 18-Jul-15.
 * Update by Sandra M. Arias R. 6-Nov-20.
 */
public class ExecutionCycleDOM {

    List<ExecutionCycleIndividualDOM> executions;

    public long getIdByVersion(long versionId) {
        long idToBeReturned = -1;
        for (ExecutionCycleIndividualDOM iterator : executions) {
            if (iterator.getVersionId() == versionId) {
                idToBeReturned = iterator.getId();
            }
        }
        return idToBeReturned;
    }
}
