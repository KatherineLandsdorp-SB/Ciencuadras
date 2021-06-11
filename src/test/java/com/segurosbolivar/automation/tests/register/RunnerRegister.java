package com.segurosbolivar.automation.tests.register;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.annotations.Test;

public class RunnerRegister extends Hooks {

    ThreadLocal<StepsRegister> steps = ThreadLocal.withInitial(StepsRegister::new);

    @Test(
            priority = 1,
            testName = "35",
            description = "Registro transversal"
    )
    public void successfullRegister() {
        steps.get()
                .clickEntry()
                .clickRegister()
                .fillAll(
                        data.getField("firstName" ),
                        data.getField("secondName"),
                        data.getField("lastName"),
                        data.getField("secondLastName"),
                        data.getField("mail"),
                        data.getField("password"),
                        data.getField("confirmPassword")
                );
    }

    @Test(
            priority = 1,
            testName = "34",
            description = "El usuario crea correctamente una cuenta de Ciencudadras con el perfil de aliado"
    )
    public void RegisterAllied() {
        this.steps.get()
                .ClickEntryLoginAllied()
                .ClickLabelCreateAccountAllied()
                .FillAllFieldsCreateAccountAllied("BOB", "fiftye20200922@yopmail.com", "8600025032", "3084665689", "bogota", "1111.SB2021", "1111.SB2021");
    }
}
