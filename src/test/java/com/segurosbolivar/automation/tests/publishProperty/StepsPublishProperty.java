package com.segurosbolivar.automation.tests.publishProperty;

import com.segurosbolivar.automation.commons.Services;
import com.segurosbolivar.automation.tests.shared.Methods;
import com.segurosbolivar.automation.tests.shared.RecicleableMethodsCiencuadras;
import com.segurosbolivar.automation.elements.Elements;
import io.qameta.allure.Step;

import javax.xml.ws.Service;

import static org.testng.Assert.assertEquals;

public class StepsPublishProperty {

    private MethodsPublishProperty MethodsPublishProperty;
    private RecicleableMethodsCiencuadras RecicleableMethodsCiencuadras;
    private Services Services;
    private Methods Methods;

    @Step("The user clicks on the publish button in the home")
    public StepsPublishProperty clickPublish() {
        RecicleableMethodsCiencuadras = new RecicleableMethodsCiencuadras();
        RecicleableMethodsCiencuadras.clickOnPublish();

        return this;

    }
    @Step("The user clicks on the publish button in the home")
    public StepsPublishProperty clickButtonSaleHome() {
        Methods = new Methods();
        Methods.clickOnButtonSaleHome();

        return this;

    }

    @Step("")
    public StepsPublishProperty clickPublishYourself() {
        RecicleableMethodsCiencuadras = new RecicleableMethodsCiencuadras();
        RecicleableMethodsCiencuadras.clickOnPublishYourself();
        return this;
    }

    @Step("")
    public StepsPublishProperty validateStepAccompaniment() {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.validateLabelAccompaniment();
        return this;
    }

    @Step("")
    public StepsPublishProperty validateStepChoosePlan() {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.validateLabelChoosePlan();
        return this;
    }

    @Step("")
    public StepsPublishProperty validateStepPublish() {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.validateLabelPublish();
        return this;
    }

    @Step("")
    public StepsPublishProperty validateStepPay() {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.validateLabelPay();
        return this;
    }

    @Step("")
    public StepsPublishProperty validateCheckDoneStepOneTracking() {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.validateCheckStepOneTracking();
        return this;
    }

    @Step("")
    public StepsPublishProperty validateCheckDoneStepTwoTracking() {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.validateCheckStepTwoTracking();
        return this;
    }

    @Step("")
    public StepsPublishProperty validateCheckDoneStepThreeTracking() {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.validateCheckStepThreeTracking();
        return this;
    }

    @Step("")
    public StepsPublishProperty validateCheckDoneStepFourTracking() {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.validateCheckStepFourTracking();
        return this;
    }
    @Step("")
    public StepsPublishProperty clickOnButtonBackStepTracking() {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.clickOnButtonBackTracking();
        return this;
    }
    @Step("")
    public StepsPublishProperty clickOnButtonBack(){
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.clickButtonBack();
        return this;
    }



    @Step("")
    public StepsPublishProperty clickOnBasicPlan() {
        RecicleableMethodsCiencuadras = new SharedMethods();
        RecicleableMethodsCiencuadras.clickOnBasicPlan();
        return this;
    }

    @Step("")
    public StepsPublishProperty clickOnAddToCar() {
        RecicleableMethodsCiencuadras = new RecicleableMethodsCiencuadras();
        RecicleableMethodsCiencuadras.clickOnAddToCarBasicPlan();
        return this;
    }

    @Step("")
    public StepsPublishProperty clickOnAddToCarOutstanding() {
        RecicleableMethodsCiencuadras = new RecicleableMethodsCiencuadras();
        RecicleableMethodsCiencuadras.clickOnAddToCarOutstanding();
        return this;
    }

    //Step form publications
    @Step()
    public StepsPublishProperty registerValueRent(String value) {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.registerRentValue(value);
        return this;
    }

    @Step()
    public StepsPublishProperty clickButtonPublishSale() {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.clickButtonSale();
        return this;
    }

    @Step()
    public StepsPublishProperty registerPriceSale(String value) {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.registerSalePrice(value);
        return this;
    }

    @Step()
    public StepsPublishProperty clickAdministrationValue() {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.clickSliderAdministrationValue();
        return this;
    }

    @Step()
    public StepsPublishProperty registerValueAdministration(String value) {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.registerValueAdministration(value);
        return this;
    }

    @Step()
    public StepsPublishProperty validateMandatoryFieldValueAdministration(String value) {
        MethodsPublishProperty = new MethodsPublishProperty();
        assertEquals(MethodsPublishProperty.validateMandatoryValueAdministration(), value);
        return this;
    }

    @Step()
    public StepsPublishProperty registerAntiquityProperty(String value) {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.registerAntiquityProperty(value);
        return this;
    }

    @Step()
    public StepsPublishProperty registerArea(String area) {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.registeArea(area);
        return this;
    }

    @Step()
    public StepsPublishProperty registerDescription(String value) {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.registerDescriptionProperty(value);
        return this;
    }

    @Step()
    public StepsPublishProperty registerStratumProperty() {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.registerStratum();
        return this;
    }

    @Step()
    public StepsPublishProperty registerCityProperty(String city) throws InterruptedException {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.registerCityProperty(city);
        return this;
    }


    @Step()
    public StepsPublishProperty registerPropertyDistric(String value) throws InterruptedException {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.registerDistric(value);
        return this;
    }

    @Step()
    public StepsPublishProperty registerCityAdress(String value) {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.registerAdress(value);
        return this;
    }

    @Step()
    public StepsPublishProperty confirmAdress() throws InterruptedException {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.confirmAdress();
        return this;
    }

    @Step()
    public StepsPublishProperty regisStepsUserEmail(String value) throws InterruptedException {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.registerEmailNewUser(value);
        return this;
    }

    @Step()
    public StepsPublishProperty registerTypeDocument() {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.registerTypeDocument();
        return this;
    }

    @Step()
    public StepsPublishProperty registerIdentificationUser(String value) {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.registerIdentificationNewUser(value);
        return this;
    }

    @Step()
    public StepsPublishProperty registerNameUser(String value) {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.registerNameNewUser(value);
        return this;
    }

    @Step()
    public StepsPublishProperty registerLastNameUser(String value) {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.registerLastNameNewUser(value);
        return this;
    }

    @Step()
    public StepsPublishProperty registerCellPhoneUser(String value) {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.registerCellPhoneNewUser(value);
        return this;
    }

    @Step()
    public StepsPublishProperty registerPasswordUser(String value) {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.registerPasswordNewUser(value);
        return this;
    }

    @Step()
    public StepsPublishProperty registerConfirmPasswordUser(String value) {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.registerConfirmPassword(value);
        return this;
    }

    @Step()
    public StepsPublishProperty clickOnButtonContinue () throws InterruptedException{
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.clickOnButtonContinue();
        return this;
    }

    public StepsPublishProperty registerCityCoverage(String city) throws InterruptedException {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.registerCityCoverage(city);
        return this;
    }

    @Step()
    public StepsPublishProperty validateCityCoverage(String text) {
        MethodsPublishProperty = new MethodsPublishProperty();
        assertEquals(MethodsPublishProperty.validateTextConfirmCoverage(), text);
        return this;
    }

    @Step()
    public StepsPublishProperty validateCityOutCoverage(String text) {
        MethodsPublishProperty = new MethodsPublishProperty();
        assertEquals(MethodsPublishProperty.validateTextOutCoverage(), text);

        return this;
    }

    @Step()
    public StepsPublishProperty clickButtonContinueCityCoverage() throws InterruptedException {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.clickButtonContinueCoverage();
        return this;
    }

    @Step()
    public StepsPublishProperty clickButtonConfirmCityCoverage() throws InterruptedException {
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.clickButtonConfirmCoverageCity();
        return this;
    }


    @Step()
    public StepsPublishProperty validateFormWithoutCity(String texto) {
        MethodsPublishProperty = new MethodsPublishProperty();
        assertEquals(MethodsPublishProperty.validateTexFormWithoutCity(), texto);
        return this;
    }
    @Step()
    public StepsPublishProperty uploapFile(int h,int s) throws InterruptedException  {
        Services = new Services();
       Services.uploadFileImage(h,s);
        //Services.uploadRemoteImage();
        return this;
    }
    @Step()
    public StepsPublishProperty clickButtonContinuePhoto(){
        MethodsPublishProperty = new MethodsPublishProperty();
        MethodsPublishProperty.clickOnButtonContinuePhoto();
        return this;
    }



}
