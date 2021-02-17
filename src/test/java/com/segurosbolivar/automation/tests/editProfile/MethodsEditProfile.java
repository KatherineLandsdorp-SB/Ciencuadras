package com.segurosbolivar.automation.tests.editProfile;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.utils.PropertyManager;

public class MethodsEditProfile extends BaseTest {
    private Methods methods = new Methods();


    public void clickNavbarDropdown(){
        methods.waitForPageLoad();
        methods.waitingForElement("navbarDropdown", 5);
        methods.clickElementJs("navbarDropdown");
    }

    public void clickEditProfile(){
        methods.waitForPageLoad();
        methods.waitingForElement("myData", 5);
        methods.clickElementJs("myData");
    }

    public String fillAllData(){
        methods.waitForPageLoad();
        methods.waitingForElement("editDepartment", 90);
        methods.clickElementJs("editDepartment");
        methods.sendKeysText("editPhone", "7107799");
        methods.sendKeysText("numberPhone", "3124444333");
        methods.checkbox("ckeckboxCall");
        methods.checkbox("ckeckboxPhone");
        methods.clickElementJs("saveProfile");
        methods.waitingForElement("confirmationSaveProfile", 90);
        return methods.getEntity("confirmationSaveProfile").getText();
    }
}