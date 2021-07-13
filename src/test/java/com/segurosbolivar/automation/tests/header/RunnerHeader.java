package com.segurosbolivar.automation.tests.header;
import com.segurosbolivar.automation.commons.Elements;
import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.commons.helpers.driver.DriverConstants;
import com.segurosbolivar.automation.commons.helpers.driver.web.DriverWebBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.TestType;

public class RunnerHeader extends Hooks {

    StepsHeader steps;

    @Test(
            id = 116,
            testType = TestType.WEB,
            description = "La url debe redireccionar a la pagina correspondiente"
    )
    public void NavBarHeader(){
        try{
            DriverWebBase.getDriver().get(DriverConstants.WEB_URL_ENVIRONMENT);
            this.steps = new StepsHeader(Elements.getWebElements());
            this.steps.clickOnEntryOffers()
                      .clickOnBuyNewRealState()
                      .clickOnBuyUsedRealState()
                      .clickOnRentRealState()
                      .clickOnFromExterior()
                      .closePopUpFromExterior()
                      .clickOnTools()
                      .clickOnBuilders()
                      .clickOnRealState()
                      .clickOnBlog();
            DriverWebBase.quitDriver();
        }catch (Exception e){
            Assert.fail(e.getMessage());
        }
    }


}
