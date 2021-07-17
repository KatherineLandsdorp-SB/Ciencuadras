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
            id = 70,
            testType = TestType.WEB,
            dataProviderClass = DataProviderSource.class,
            dataProvider = "test-data",
            description = "Busqueda por codigo de proyecto"
    )
    public void searchCode(Data data){
        try {
            DriverWebBase.getDriver().get(DriverConstants.WEB_URL_ENVIRONMENT);
            this.steps = new StepsSearch(Elements.getWebElements());
            steps.searchCode(data.getDataField("code"))
                    .validateSuccess();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test(
            priority = 3,
            id = 71,
            testType = TestType.WEB,
            dataProviderClass = DataProviderSource.class,
            dataProvider = "test-data",
            description = "Busqueda por codigo de proyecto fallida"
    )
    public void searchCodeFail(Data data){
        try {
            DriverWebBase.getDriver().get(DriverConstants.WEB_URL_ENVIRONMENT);
            this.steps = new StepsSearch(Elements.getWebElements());
            steps.searchCode(data.getDataField("code"))
                    .validateFail();
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test(
            priority = 3,
            id = 102,
            testType = TestType.WEB,
            dataProviderClass = DataProviderSource.class,
            dataProvider = "test-data",
            description = " Realizar búsqueda por proyecto "
    )
    public void searchProject(Data data){
        try {
            DriverWebBase.getDriver().get(DriverConstants.WEB_URL_ENVIRONMENT);
            this.steps = new StepsSearch(Elements.getWebElements());
            steps.searchCode(data.getDataField("code"))
                    .validateFail();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test(
            priority = 3,
            id = 103,
            testType = TestType.WEB,
            dataProviderClass = DataProviderSource.class,
            dataProvider = "test-data",
            description = "Realizar búsqueda con diferentes filtros"
    )
    public void searchProjectFail(Data data){
        try {
            DriverWebBase.getDriver().get(DriverConstants.WEB_URL_ENVIRONMENT);
            this.steps = new StepsSearch(Elements.getWebElements());
            steps.searchCode(data.getDataField("code"))
                    .validateFail();

        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

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


    @Test(
            priority = 3,
            id = 105,
            testType = TestType.WEB,
            dataProviderClass = DataProviderSource.class,
            dataProvider = "test-data",
            description = "Realizar validación de las opciones de búsqueda"
    )
    public void optionsSerach(Data data){
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