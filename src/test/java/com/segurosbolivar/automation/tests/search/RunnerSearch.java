package com.segurosbolivar.automation.tests.search;

import com.segurosbolivar.automation.commons.Data;
import com.segurosbolivar.automation.commons.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RunnerSearch extends Hooks {
    ThreadLocal<StepsSearch> steps = ThreadLocal.withInitial(StepsSearch::new);

    @Test(
            priority = 3,
            testName = "70",
            description = "Busqueda por codigo de proyecto"
    )
    public void searchCode(){
        try {
            Data data = new Data(70);
            steps.get()
                    .searchCode(data.getDataField("code"))
                    .validateSuccess();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test(
            priority = 3,
            testName = "71",
            description = "Busqueda por codigo de proyecto fallida"
    )
    public void searchCodeFail(){
        try {
            Data data = new Data(71);
            steps.get()
                    .searchCode(data.getDataField("code"))
                    .validateFail();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
}