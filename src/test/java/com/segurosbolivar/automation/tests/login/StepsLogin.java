package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.commons.Data;
import org.json.simple.JSONObject;
import static org.testng.Assert.assertEquals;

public class StepsLogin {

    private final MethodsLogin methodsSimpleTest;

    public StepsLogin(JSONObject elements) {
        this.methodsSimpleTest = new MethodsLogin(elements);
    }

    /**
     * Método que instancia dar clic en la sesión de Iniciar sesión
     * @param entity
     * @return Se retorna así mismo para poder ser usado en toda la clase.
     * @throws Exception Si no aparece el elemento.
     */
    public StepsLogin loginTabClick(String entity) throws Exception {
        methodsSimpleTest.clickLoginTab(entity);
        return this;
    }

    public StepsLogin fillAll(String elemtMail,String dataEmail,String elemtKey, String dataKey,
                              String elemtButton) throws Exception {

        methodsSimpleTest.fillAll(elemtMail,dataEmail,elemtKey,dataKey,elemtButton);
        return this;
    }

    public StepsLogin assertVerifyCase(String elemtLabel,String dataAssert) throws Exception {
        assertEquals(methodsSimpleTest.assertVerifyCase(elemtLabel),dataAssert);
        return this;
    }
    /*public StepsLogin fillAll(String fieldMail,String fieldPass, String dataMail, String DataPass,
                              String buttonLogin, String validate) throws Exception {
        //
        assertEquals(methodsSimpleTest.fillAllRequiredNotRegister(),validate);
        return this;
    }*/
    /*public StepsLogin fillMail(String entity, String text) throws Exception {
        methodsSimpleTest.fillFieldsText(entity,text);
        return this;
    }
    public StepsLogin fillPassword(String entity, String text) throws Exception {
        methodsSimpleTest.fillFieldsText(entity,text);
        return this;
    }*/
    /*public StepsLogin clickLoginButton(String entity) throws Exception {
        methodsSimpleTest.click(entity);
        methodsSimpleTest.assertTest(entity,text);
        return this;
    }*/

    public StepsLogin assertLoginFail(String entity, String text) throws Exception {
        methodsSimpleTest.assertTest(entity,text);
        return this;
    }

    public StepsLogin mulButtonClick() throws Exception {
        methodsSimpleTest.mulButtonClick();
        return this;
    }

    public StepsLogin fourNumberClick(String number) throws Exception {
        methodsSimpleTest.fourNumberClick();
        return this;
    }
}
