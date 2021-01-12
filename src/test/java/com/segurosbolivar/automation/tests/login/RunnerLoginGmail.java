package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.commons.Hooks;


import org.testng.annotations.Test;

public class RunnerLogin extends Hooks {

    ThreadLocal<StepsLogin> steps = ThreadLocal.withInitial(StepsLogin::new);

    @Test(priority=1, groups = { "smoke" })
    public void successfullLogin(){
        steps.get()
                .clickEntry()
                .clickLoginPerson()
                .fillAll();
    }

    @Test(priority=1, groups = { "smoke" })
    public void successfullLoginRemember(){
        steps.get()
                .clickEntry()
                .clickLoginPerson()
                .clickRemember()
                .fillAll();
    }

    @Test(priority=2, groups = { "smoke" })
    public void successfullGmail(){
        steps.get()
                .clickEntry()
                .clickLoginPerson()
                .fillAllGmail();
    }

    @Test(priority=3, groups = { "smoke" })
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