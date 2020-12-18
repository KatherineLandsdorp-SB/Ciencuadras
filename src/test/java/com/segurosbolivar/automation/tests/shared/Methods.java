package com.segurosbolivar.automation.tests.shared;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.helpers.DriverFacade;

public class Methods extends BaseTest {
    protected DriverFacade webDriverFacade;


    public void clickOnEntry(){
        webDriverFacade.waitForVisibilityOfElement(entryUser);
        entryUser.click();
    }

    public void loginPerson(){
        webDriverFacade.waitForVisibilityOfElement(loginPerson);
        loginPerson.click();
    }

    public void clickOnPublish() {
        buttonPublishProperty.click();
    }

    public void clickOnKnowHowPublish(){
        buttonKnowPublish.click();
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
        webDriverFacade.waitForVisibilityOfElement(buttonRealState);
        if (buttonRealState.isEnabled()) {
            buttonRealState.click();
        }
    }



}
