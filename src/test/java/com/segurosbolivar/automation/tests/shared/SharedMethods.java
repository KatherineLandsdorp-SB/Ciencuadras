package com.segurosbolivar.automation.tests.shared;

import com.segurosbolivar.automation.commons.BaseTest;
import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.commons.helpers.DriverFacade;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SharedMethods extends BaseTest {
    protected DriverFacade webDriverFacade;
    private Methods methods = new Methods();

    public String validateUsernameLoged() {

        String entity = StringUtils.capitalize(services.getField("firstName")) + " "
                + StringUtils.capitalize(services.getField("secondName")) + " "
                + StringUtils.capitalize(services.getField("lastName")) + " "
                + StringUtils.capitalize(services.getField("secondLastName"));

        return driverFacade.getWebDriver().findElement(By.xpath("//*[contains(text(), " + entity + ")]")).getText();
    }


    public void clickOnEntry() {
        methods.waitingForElement("entryUser", 10);
        methods.clickElement("entryUser");
    }

    public void loginPerson() {
        methods.waitingForElement("loginPerson", 10);
        methods.clickElement("loginPerson");
    }

    public void clickOnPublish() {
        methods.clickElement("buttonPublishProperty");
    }

    public void clickOnKnowHowPublish() {
        methods.clickElement("buttonKnowPublish");
    }

    public void clickOnPublishYourself() {
        //methods.waitingForElement("buttonPublishYourself", 10);
        methods.pause(10);
        methods.clickElement("buttonPublishYourself");
    }

    public void clickOnBasicPlan() {
        methods.waitingForElement("buttonBasicPlan", 10);
        methods.clickElement("buttonBasicPlan");
    }

    public void clickOnAddToCar() {
        methods.waitingForElement("buttonAddToCar", 10);
        methods.clickElement("buttonAddToCar");
    }

    public void publishRealState() {
        methods.waitingForElement("buttonRealState", 10);
        methods.clickElement("buttonRealState");
    }


    public void clickOnAddToCarOutstanding() {
        methods.waitingForElement("buttonAddToCar", 10);
        methods.clickElement("buttonAddToCar");
    }

    public void clickOnAddToCarBasicPlan() {
        methods.waitingForElement("buttonBasicAddToCar", 10);
        methods.clickElement("buttonBasicAddToCar");


    }

    public void clickOnButtonSaleHome() {
        methods.clickElement("buttonSale");
    }

    public void clickOnButtonAddPhoto() {
        buttonAddPhoto.click();
    }

    public void registerValueAdministration() {
        List<WebElement> dynamicElement = driverFacade.getWebDriver().findElements(By.id("administrationValue"));
        if (dynamicElement.size() != 0) {
            System.out.println("Existe elemento");
            methods.sendKeysText("inputAdministrationValue", services.getField("sanityAdminValue"));
        } else {//0, elemento no esta presente.
            System.out.println("Elemento no existe");
        }
    }


}
