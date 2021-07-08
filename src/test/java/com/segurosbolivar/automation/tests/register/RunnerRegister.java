package com.segurosbolivar.automation.tests.register;

import com.segurosbolivar.automation.commons.Data;
import com.segurosbolivar.automation.commons.Elements;
import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.commons.dataprovider.DataProviderSource;
import com.segurosbolivar.automation.commons.helpers.driver.DriverConstants;
import com.segurosbolivar.automation.commons.helpers.driver.web.DriverWebBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.TestType;

public class RunnerRegister extends Hooks {

    StepsRegister steps;

    @Test(
            id = 35,
            priority = 2,
            testType = TestType.WEB,
            dataProviderClass = DataProviderSource.class,
            dataProvider = "test-data",
            description = "Registro transversal"
    )
    public void successfullRegister(Data data) throws Exception {
        try {
            DriverWebBase.getDriver().get(DriverConstants.WEB_URL_ENVIRONMENT);
            this.steps = new StepsRegister(Elements.getWebElements());
            steps.clickEntry()
                    .clickRegister()
                    .fillAll(
                            data.getDataField("firstName"),
                            data.getDataField("secondName"),
                            data.getDataField("lastName"),
                            data.getDataField("secondLastName"),
                            data.getDataField("mail"),
                            data.getDataField("password"),
                            data.getDataField("confirmPassword")
                    );
            DriverWebBase.quitDriver();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }


    @Test(
            id = 34,
            testType = TestType.WEB,
            priority = 2,
            dataProviderClass = DataProviderSource.class,
            dataProvider = "test-data",
            description = "El usuario crea correctamente una cuenta de Ciencudadras con el perfil de aliado"
    )
    public void RegisterAllied(Data data) throws Exception {
        try {
            DriverWebBase.getDriver().get(DriverConstants.WEB_URL_ENVIRONMENT);
            this.steps = new StepsRegister(Elements.getWebElements());
            this.steps.ClickEntryLoginAllied()
                    .ClickLabelCreateAccountAllied()
                    .FillAllFieldsCreateAccountAllied(
                            data.getDataField("firstName"),
                            data.getDataField("mail"),
                            data.getDataField("nit"),
                            data.getDataField("cellPhone"),
                            data.getDataField("city"),
                            data.getDataField("pass"),
                            data.getDataField("passConfirmate"));
            DriverWebBase.quitDriver();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }



}
