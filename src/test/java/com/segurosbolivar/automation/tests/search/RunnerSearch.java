package com.segurosbolivar.automation.tests.search;

import com.segurosbolivar.automation.commons.Data;
import com.segurosbolivar.automation.commons.Elements;
import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.commons.dataprovider.DataProviderSource;
import com.segurosbolivar.automation.commons.helpers.driver.DriverConstants;
import com.segurosbolivar.automation.commons.helpers.driver.web.DriverWebBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.TestType;

public class RunnerSearch extends Hooks {

    StepsSearch steps;
    
    @Test(
            priority = 3,
            id = 104,
            testType = TestType.WEB,
            dataProviderClass = DataProviderSource.class,
            dataProvider = "test-data",
            description = "Módulo Artículos de Interés Blog"
    )
    public void moduleBlog(Data data){
        try {
            DriverWebBase.getDriver().get(DriverConstants.WEB_URL_ENVIRONMENT);
            this.steps = new StepsSearch(Elements.getWebElements());
            steps.searchCode(data.getDataField("code"))
                    .validateFail();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }


}