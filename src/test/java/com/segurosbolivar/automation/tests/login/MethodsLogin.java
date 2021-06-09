package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.commons.Data;
import com.segurosbolivar.automation.commons.methods.mobile.MobileMethods;
import com.segurosbolivar.automation.commons.methods.mobile.factory.MethodsFactory;
import org.json.simple.JSONObject;

import static org.testng.Assert.assertEquals;

public class MethodsLogin {
    MobileMethods mobileMethods;

    public MethodsLogin(JSONObject elements) {
        this.mobileMethods = MethodsFactory.getMethods(elements);
    }

    public void clickLoginTab(String entity) throws Exception {
        mobileMethods.waitElementExplicitTime(entity);
        mobileMethods.click(entity);
        //mobileMethods.waitElementExplicitTime("commons_loginTab");
        //mobileMethods.click("commons_loginTab");
    }

    public void assertTest(String entity,String text) throws Exception {
        mobileMethods.waitElementExplicitTime(entity);
        String assertText = mobileMethods.getText(entity);
        assertEquals(mobileMethods.getText(entity), text);
    }
    public void fillAll(String elemtMail,String dataEmail,String elemtKey,String dataKey,
                                             String elemtButton) throws Exception {
        mobileMethods.waitElementExplicitTime(elemtMail);
        mobileMethods.sendKeysText(elemtMail,dataEmail);
        mobileMethods.waitElementExplicitTime(elemtKey);
        mobileMethods.sendKeysText(elemtKey,dataKey);
        mobileMethods.click(elemtButton);
        mobileMethods.click(elemtButton);
    }

    public String assertVerifyCase(String elemtLabel) throws Exception {
        mobileMethods.waitElementExplicitTime(elemtLabel);
        String assertText = mobileMethods.getText(elemtLabel);

        return assertText;
    }
    /*public String fillAllRequiredNotRegister(String fieldMail,String fieldPass, String dataMail, String DataPass,
                                             String buttonLogin, String validate) throws Exception {
        mobileMethods.waitElementExplicitTime(fieldMail);
        mobileMethods.sendKeysText(fieldMail,dataMail);
        mobileMethods.waitElementExplicitTime("commons_passField");
        mobileMethods.sendKeysText("commons_passField",Data.getDataField("password"));
        mobileMethods.click("commons_buttonLogin");
        mobileMethods.click("commons_buttonLogin");
        mobileMethods.waitElementExplicitTime("commons_labelLoginFail");
        String assertText = mobileMethods.getText("commons_labelLoginFail");

        return assertText;
    }*/

    public void mulButtonClick() throws Exception {
        mobileMethods.click("mul");
    }

    public void fourNumberClick() throws Exception {
        mobileMethods.click("four");
    }
}
