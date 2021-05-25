package com.segurosbolivar.automation.tests.register;

import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.tests.login.StepsLogin;
import org.testng.annotations.Test;

public class RunnerRegister extends Hooks {

    ThreadLocal<StepsRegister> steps = ThreadLocal.withInitial(StepsRegister::new);


    @Test(
            testName = "2",
            description = "El usuario crea correctamente una cuenta de Ciencudadras con el perfil de aliado",
            suiteName = "SUITE1"
    )
    public void RegisterAllied(){
    this.steps.get()
            .ClickEntryLoginAllied()
            .ClickLabelCreateAccountAllied()
            .FillAllFieldsCreateAccountAllied("BOB","fiftye20200922@yopmail.com","8600025032","3084665689","bogota","1111.SB2021","1111.SB2021");
    }


}
