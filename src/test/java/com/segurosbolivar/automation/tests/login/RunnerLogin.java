package com.segurosbolivar.automation.tests.login;

import com.segurosbolivar.automation.commons.Data;
import com.segurosbolivar.automation.commons.Elements;
import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.commons.dataprovider.DataProviderSource;
import com.segurosbolivar.automation.commons.helpers.driver.DriverConstants;
import com.segurosbolivar.automation.commons.helpers.driver.web.DriverWebBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.TestType;

public class RunnerLogin extends Hooks {


    StepsLogin steps;

    @Test(
            id = 36,
            testType = TestType.WEB,
            dataProviderClass = DataProviderSource.class,
            dataProvider = "test-data",
            description = "Validación login transversal 36"
    )
    public void loginTransversal(Data data){
        try {
            DriverWebBase.getDriver().get(DriverConstants.WEB_URL_ENVIRONMENT);
            this.steps = new StepsLogin(Elements.getWebElements());
            steps.clickEntry()
                    .clickEnterButton()
                    .fillAll(data.getDataField("mail"), data.getDataField("password"))
                    .clickOnLogin()
                    .validateSuccess();
            DriverWebBase.quitDriver();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

}