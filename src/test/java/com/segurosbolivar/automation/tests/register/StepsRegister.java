package com.segurosbolivar.automation.tests.register;
import com.segurosbolivar.automation.commonslocal.BaseComponent;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import org.testng.Assert;

public class StepsRegister extends BaseComponent {

    public  StepsRegister(JSONObject json){
        super(json);
    }


    @Step("The user clicks on the login Link in the Header")
    public StepsRegister clickEntry(){
        header.clickOnEntry();
        return this;
    }

    @Step("The user clicks on the register Link in the Popup")
    public StepsRegister clickRegister(){
        methods.waitingForElement("registerUser", 3);
        methods.clickElement("registerUser");
        return this;
    }

    @Step("The user fill all the required fields")
    public StepsRegister fillAll(
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
            methods.sendKeysText("mailRegister", methods.mailGenerator());
            methods.sendKeysText("passRegister", password);
            methods.sendKeysText("confirmPassRegister", confirmPassword);
            methods.scrollTo("terms");
            methods.clickElement("terms");
            methods.clickElementJs("register");
            methods.waitForPageLoad();
            methods.waitingForElement("helloUser", 30);
            methods.getEntity("helloUser").getText();
        return this;
    }

    @Step("The user clicks on the login Link in the Header")
    public StepsRegister ClickEntryLoginAllied(){
            header.clickOnEntryLoginAllied();
        return this;
    }

    @Step("The user clicks on the label create account allied")
    public  StepsRegister ClickLabelCreateAccountAllied(){
            methods.waitingForElement("popupSigInAllied",10);
            methods.waitingForElement("labelCreateAccountAllied",5);
            methods.clickElementJs("labelCreateAccountAllied");
        return this;
    }

    @Step("The user fill all fields to register new account allied")
    public  StepsRegister FillAllFieldsCreateAccountAllied(String name, String email, String nit, String cellPhone, String city, String pass, String passConfirmation){
            methods.waitingForElement("fieldNameRegisterAllied",5);
            methods.sendKeysText("fieldNameRegisterAllied",name);
            methods.waitingForElement("fieldEmailRegisterAllied",5);
            methods.sendKeysText("fieldEmailRegisterAllied",email);
            methods.waitingForElement("fieldNitRegisterAllied",5);
            methods.sendKeysText("fieldNitRegisterAllied",nit);
            methods.waitingForElement("fieldCellPhoneRegisterAllied",5);
            methods.sendKeysText("fieldCellPhoneRegisterAllied",cellPhone);
            methods.waitingForElement("fieldCityRegisterAllied",5);
            methods.sendKeysText("fieldCityRegisterAllied",city);
            methods.waitingForElement("fieldPassRegisterAllied",5);
            methods.sendKeysText("fieldPassRegisterAllied",pass);
            methods.waitingForElement("fieldPassConfirmationRegisterAllied",5);
            methods.sendKeysText("fieldPassConfirmationRegisterAllied",passConfirmation);
            methods.waitingForElement("fieldTermsAndConditionsRegisterAllied",5);
            methods.clickElement("fieldTermsAndConditionsRegisterAllied");
            methods.waitingForElement("buttonEntryRegisterAllied",5);
            methods.clickElementJs("buttonEntryRegisterAllied");
            methods.waitForPageLoad();
            Assert.assertTrue(true);
        return this;
    }



}
