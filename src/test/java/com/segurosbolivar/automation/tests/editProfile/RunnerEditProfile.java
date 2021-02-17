package com.segurosbolivar.automation.tests.editProfile;

import com.segurosbolivar.automation.commons.Hooks;
import org.testng.annotations.Test;

public class RunnerEditProfile extends Hooks {

    ThreadLocal<StepsEditProfile> steps= ThreadLocal.withInitial(StepsEditProfile::new);

    @Test(priority=5, groups = { "smoke" })
    public void editProfile(){
        steps.get()
                .aUserIsLoggedIn()
                .editProfile();
    }

//    @Test
//    public void successfullLoginFacebook(){
//        steps.get()
//                .clickEntry()
//                .clickLoginPerson()
//                .fillAll();
//    }

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