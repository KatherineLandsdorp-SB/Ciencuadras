package com.segurosbolivar.automation.tests.register;

import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.commonslocal.BaseComponent;

public class MethodsRegister extends BaseComponent {

    private Methods methods = new Methods();


    public void ClickLabelCreateAccountAllied(){
        this.methods.waitingForElement("popupSigInAllied",10);
        this.methods.waitingForElement("labelCreateAccountAllied",5);
        this.methods.clickElementJs("labelCreateAccountAllied");
    }

    public void registerPerson(){
        this.methods.waitingForElement("registerUser", 3);
        this.methods.clickElement("registerUser");
    }

    public String fillAllTheRequiredFields(
            String firstName,
            String secondName,
            String lastName,
            String secondLastName,
            String mail,
            String password,
            String confirmPassword
            ){
        methods.waitForPageLoad();
        methods.waitingForElement("nameRegister", 60);
        methods.sendKeysText("nameRegister", firstName);
        methods.sendKeysText("secondNameRegister", secondName);
        methods.sendKeysText("lastNameRegister", lastName);
        methods.sendKeysText("secondLastnameRegister", secondLastName);
        methods.sendKeysText("mailRegister", mail);
        methods.sendKeysText("passRegister", password);
        methods.sendKeysText("confirmPassRegister", confirmPassword);
        methods.scrollTo("terms");
        methods.clickElement("terms");
        methods.clickElement("register");
        methods.waitForPageLoad();
        methods.waitingForElement("navbarDropdown", 300);
        return methods.getEntity("navbarDropdown").getText();
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
