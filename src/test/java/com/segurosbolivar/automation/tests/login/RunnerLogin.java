package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.commons.Data;
import com.segurosbolivar.automation.commons.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
public class RunnerLogin extends Hooks {
    ThreadLocal<StepsLogin> steps = ThreadLocal.withInitial(StepsLogin::new);

    @Test(
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
            testName = "74",
            description = "Validación login con opcion recuerdame"
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
            testName = "75",
            description = "Validación login con correo no registrado"
    )
    public void loginFail(){
        try {
            Data data = new Data(36);
            steps.get()
                    .clickEntry()
                    .clickEnterButton()
                    .fillAll(data.getDataField("mail")+"x", data.getDataField("password"))
                    .clickOnLogin()
                    .validateFailed();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

}