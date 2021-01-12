package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.annotations.Test;

public class RunnerLoginFacebook extends Hooks {

    ThreadLocal<StepsLogin> steps = ThreadLocal.withInitial(StepsLogin::new);

    @Test(priority=1, groups = { "smoke" })
    public void successfullLoginFacebook(){
        steps.get()
                .clickEntry()
                .clickLoginPerson()
                .fillAllFacebook();
    }

    // se agrega inmplementaciòn trayendo datos desde servicio de firebase
   /* ConnectionBD objBd = new ConnectionBD();
    @Test
    public void successfulLogin(){
        System.out.println("Prueba de extraccion de BD " + objBd.getDataService("cienCuadras","username"));
        steps.get().clickEntry().fillAll("AUTOMATION PRUEBAS AUTOMATION PRUEBAS");
    }
*/


//    @Test
//    public void successfulLoginSucess(){
//        steps.get().clickEntry();
//    }
}