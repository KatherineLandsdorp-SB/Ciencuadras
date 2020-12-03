package com.segurosbolivar.automation.tests.shared;

import com.segurosbolivar.automation.commons.helpers.DriverFacade;
import com.segurosbolivar.automation.elements.Elements;
import org.openqa.selenium.By;

import java.io.IOException;

public class RecicleableMethodsCiencuadras extends Elements {
    protected DriverFacade webDriverFacade;

    public void clickOnPublish()  {
        //webDriverFacade.waitForVisibilityOfElement(buttonHowToPublish);

        buttonHowToPublish.click();
    }

    public void clickOnPublishYourself() {
        webDriverFacade.waitForVisibilityOfElement(buttonPublishYourself);
        buttonPublishYourself.click();
    }

    public void clickOnBasicPlan() {
        webDriverFacade.waitForVisibilityOfElement(buttonBasicPlan);
        buttonBasicPlan.click();
    }

    public void clickOnAddToCar() {
        webDriverFacade.waitForVisibilityOfElement(buttonAddToCar);
        buttonAddToCar.click();
    }

    public void publishRealState() {
       //webDriverFacade.awaitToFindElement(By.xpath("//button[text()='CON INMOBILIARIA']"));
        //webDriverFacade.waitForVisibilityOfElement(buttonRealState);
        buttonRealState.click();
    }


}
