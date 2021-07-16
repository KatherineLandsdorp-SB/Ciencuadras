package com.segurosbolivar.automation.commons.jira.zapi.DOM.TestSteps;

/**
 * Created by Chaitanya on 21-Jul-15.
 * Update by Sandra M. Arias R. 6-Nov-20.
 */
public class StepExecutionStatusListDOM {

    StepExecutionStatusDOM[] stepExecutionStatusDOMs;

    public StepExecutionStatusListDOM(StepExecutionStatusDOM[] stepExecutionStatusDOMs) {
        this.stepExecutionStatusDOMs = stepExecutionStatusDOMs;
        System.out.println(stepExecutionStatusDOMs);
    }

    public StepExecutionStatusDOM[] getStepExecutionStatusDOMs() {
        return stepExecutionStatusDOMs;
    }

    public long getExecutionIdForEachTestStep(long id) {
        StepExecutionStatusDOM toBeReturned = null;

        System.out.println(stepExecutionStatusDOMs);


        for (StepExecutionStatusDOM iterator : stepExecutionStatusDOMs) {

            System.out.println(iterator.getStepId());

            if (iterator.getStepId() == id) {
                toBeReturned = iterator;
            }
        }
        return toBeReturned.getId();
    }
}
