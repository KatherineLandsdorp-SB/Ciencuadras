package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.commons.Data;
import com.segurosbolivar.automation.commons.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
public class RunnerLogin extends Hooks {
    ThreadLocal<StepsLogin> steps = ThreadLocal.withInitial(StepsLogin::new);

    @Test(
            priority = 1,
            testName = "36",
            description = "Validación login transversal"
    )
    public void loginTransversal(){
        try {
            Data data = new Data(36);
            steps.get()
                    .clickEntry()
                    .clickEnterButton()
                    .fillAll(data.getDataField("mail"), data.getDataField("password"))
                    .clickOnLogin()
                    .validateSuccess();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test(
            priority = 1,
            testName = "36",
            description = "Validación login transversal"
    )
    public void loginCheck(){
        try {
            Data data = new Data(36);
            steps.get()
                    .clickEntry()
                    .clickEnterButton()
                    .fillAll(data.getDataField("mail"), data.getDataField("password"))
                    .checkRemember()
                    .clickOnLogin()
                    .validateSuccess();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }


    @Test(
            priority = 1,
            testName = "36",
            description = "Validación login transversal"
    )
    public void loginFail(){
        try {
            Data data = new Data(36);
            steps.get()
                    .clickEntry()
                    .clickEnterButton()
                    .fillAll(data.getDataField("mail"), data.getDataField("password"))
                    .clickOnLogin()
                    .validateFailed();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

}