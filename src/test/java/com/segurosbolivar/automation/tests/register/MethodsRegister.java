package com.segurosbolivar.automation.tests.register;

import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.commonsLocal.MethodsHeader;

public class MethodsRegister extends MethodsHeader {

    private Methods methods = new Methods();


    public void ClickLabelCreateAccountAllied(){
    this.methods.waitingForElement("popupSigInAllied",10);
    this.methods.waitingForElement("labelCreateAccountAllied",5);
    this.methods.clickElementJs("labelCreateAccountAllied");
    }


    public boolean FillAllCreateAccountAllied(String name, String email, String nit, String cellPhone, String city, String pass, String passConfirmation){
    this.methods.waitingForElement("fieldNameRegisterAllied",5);
    this.methods.sendKeysText("fieldNameRegisterAllied",name);
    this.methods.waitingForElement("fieldEmailRegisterAllied",5);
    this.methods.sendKeysText("fieldEmailRegisterAllied",email);
    this.methods.waitingForElement("fieldNitRegisterAllied",5);
    this.methods.sendKeysText("fieldNitRegisterAllied",nit);
    this.methods.waitingForElement("fieldCellPhoneRegisterAllied",5);
    this.methods.sendKeysText("fieldCellPhoneRegisterAllied",cellPhone);
    this.methods.waitingForElement("fieldCityRegisterAllied",5);
    this.methods.sendKeysText("fieldCityRegisterAllied",city);
    this.methods.waitingForElement("fieldPassRegisterAllied",5);
    this.methods.sendKeysText("fieldPassRegisterAllied",pass);
    this.methods.waitingForElement("fieldPassConfirmationRegisterAllied",5);
    this.methods.sendKeysText("fieldPassConfirmationRegisterAllied",passConfirmation);
    this.methods.waitingForElement("fieldTermsAndConditionsRegisterAllied",5);
    this.methods.clickElement("fieldTermsAndConditionsRegisterAllied");
    this.methods.waitingForElement("buttonEntryRegisterAllied",5);
    this.methods.clickElementJs("buttonEntryRegisterAllied");
    this.methods.waitForPageLoad();

    return true;

    }



}
