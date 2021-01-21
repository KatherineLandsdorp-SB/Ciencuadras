package com.segurosbolivar.automation.tests.searchpropertytest;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RunnerSearchProperty extends Hooks {
    ThreadLocal<StepsSearchProperty> steps = ThreadLocal.withInitial(StepsSearchProperty::new);
    @Test
    public void searchPropertyByInvalidCode() {
       String outMessage =  steps.get()
                .clickLinkSearchByCode()
                .fillTextBoxSearchByInvalidCode()
                .clickSearchButton()
                .checkInvalidCodeMessage();

        Assert.assertEquals("El código que ingresaste no existe",outMessage);
    }
}
