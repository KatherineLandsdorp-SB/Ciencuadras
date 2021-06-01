package com.segurosbolivar.automation.tests.register;
import io.qameta.allure.Step;
import org.testng.Assert;

public class StepsRegister {

    private MethodsRegister methods = new MethodsRegister();

    @Step("The user clicks on the login Link in the Header")
    public StepsRegister clickEntry(){
        this.methods.header.clickOnEntry();
        return this;
    }

    @Step("The user clicks on the register Link in the Popup")
    public StepsRegister clickRegister(){
        this.methods.registerPerson();
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
        this.methods.fillAllTheRequiredFields(
                firstName,
                secondName,
                lastName,
                secondLastName,
                mail,
                password,
                confirmPassword);
        return this;
    }

    @Step("The user clicks on the login Link in the Header")
    public StepsRegister ClickEntryLoginAllied(){
        this.methods.header.clickOnEntryLoginAllied();
        return this;
    }

    @Step("The user clicks on the label create account allied")
    public  StepsRegister ClickLabelCreateAccountAllied(){
        this.methods.ClickLabelCreateAccountAllied();
        return this;
    }

    @Step("The user fill all fields to register new account allied")
    public  StepsRegister FillAllFieldsCreateAccountAllied(String name, String email, String nit, String cellPhone, String city, String pass, String passConfirmation){
    boolean result = false;
    result = this.methods.FillAllCreateAccountAllied(name, email, nit, cellPhone, city, pass, passConfirmation);
    Assert.assertTrue(result);
    return this;
    }



}
