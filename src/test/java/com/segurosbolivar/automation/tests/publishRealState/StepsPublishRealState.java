package com.segurosbolivar.automation.tests.publishRealState;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.tests.shared.SharedMethods;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class StepsPublishRealState extends BaseTest {
    private MethodsPublishRealState methodsPublishRealState = new MethodsPublishRealState();
    private SharedMethods shareMethods = new SharedMethods();

    @Step("The user clicks on the sale button in the home")
    public StepsPublishRealState clickButtonSaleHome() {
        assertTrue(shareMethods.clickOnButtonSaleHome());
        return this;

    }


    @Step("The user click on the button publish with Real State")
    public StepsPublishRealState clickRealState() {
        assertTrue(methodsPublishRealState.publishRealState());
        return this;
    }

    @Step("Register the fields in form publish with real state")
    public StepsPublishRealState fillForm() {
        methodsPublishRealState.registerForm();
        assertEquals(methodsPublishRealState.validateElement(), services.getField("sanityUnderstand"));
        return this;
    }

    @Step("Fill form publish with real state whit out data name")
    public StepsPublishRealState fillNoMandatoryDataName() {
        methodsPublishRealState.fillNoMandatoryDataName();
        assertEquals(methodsPublishRealState.validateDataMandatory(), services.getField("sanityConfirm"));
        return this;
    }

    @Step("Fill form publish with real state whit out data email")
    public StepsPublishRealState fillNoMandatoryDataEmail() {
        methodsPublishRealState.fillNoMandatoryDataEmail();
        assertEquals(methodsPublishRealState.validateDataMandatory(), services.getField("sanityConfirm"));
        return this;
    }

    @Step("Fill form publish with real state whit out data Phone")
    public StepsPublishRealState fillNoMandatoryDataPhone() {
        methodsPublishRealState.fillNoMandatoryDataPhone();
        assertEquals(methodsPublishRealState.validateDataMandatory(), services.getField("sanityConfirm"));
        return this;
    }

    @Step("Fill form publish with real state whit out data city")
    public StepsPublishRealState fillNoMandatoryDataCity() {
        methodsPublishRealState.fillNoMandatoryDataCity();
        assertEquals(methodsPublishRealState.validateDataMandatory(), services.getField("sanityConfirm"));
        return this;
    }


    @Step("click on button confirm in form publish with real state")
    public StepsPublishRealState clickConfirmationNoMandatoryData() {
        methodsPublishRealState.clickButtonConfirm();
        assertEquals(methodsPublishRealState.validateDataMandatory(), services.getField("sanityConfirm"));
        return this;
    }


    @Step("click on button Understood")
    public StepsPublishRealState clickButtonUnderstood() {
        assertTrue(methodsPublishRealState.clickButtonUnderstood());
        return this;
    }


    @Step("validate existence radio button sale")
    public StepsPublishRealState validationRadioButtonSale() {
        assertTrue(methodsPublishRealState.validateRadioButtonSale());
        return this;
    }

    @Step("validate existence radio button rent")
    public StepsPublishRealState validationRadioButtonRent() {
        assertTrue(methodsPublishRealState.validateRadioButtonRent());
        return this;
    }

    @Step("validate existence radio button rent and sale")
    public StepsPublishRealState validationRadioButtonRentSale() {
        assertTrue(methodsPublishRealState.validateRadioButtonRentSale());
        return this;
    }


}
