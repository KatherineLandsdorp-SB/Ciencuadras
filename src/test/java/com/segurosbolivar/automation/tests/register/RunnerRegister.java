package com.segurosbolivar.automation.tests.register;

import com.segurosbolivar.automation.commons.Data;
import com.segurosbolivar.automation.commons.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RunnerRegister extends Hooks {

    ThreadLocal<StepsRegister> steps = ThreadLocal.withInitial(StepsRegister::new);

    @Test(
            testName = "35",
            description = "Registro transversal"
    )
    public void successfullRegister() throws Exception {
        try {
            Data data = new Data(35);
            steps.get()
                    .clickEntry()
                    .clickRegister()
                    .fillAll(
                            data.getDataField("firstName"),
                            data.getDataField("secondName"),
                            data.getDataField("lastName"),
                            data.getDataField("secondLastName"),
                            data.getDataField("mail"),
                            data.getDataField("password"),
                            data.getDataField("confirmPassword")
                    );
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test(
            testName = "34",
            description = "El usuario crea correctamente una cuenta de Ciencudadras con el perfil de aliado"
    )
    public void RegisterAllied() throws Exception {
        try {
            Data data = new Data(35);
            this.steps.get()
                    .ClickEntryLoginAllied()
                    .ClickLabelCreateAccountAllied()
                    .FillAllFieldsCreateAccountAllied(
                            data.getDataField("firstName"),
                            data.getDataField("mail"),
                            data.getDataField("nit"),
                            data.getDataField("cellPhone"),
                            data.getDataField("city"),
                            data.getDataField("pass"),
                            data.getDataField("passConfirmate"));
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

}
