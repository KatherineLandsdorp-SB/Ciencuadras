package com.segurosbolivar.automation.tests.BodyOffers;
import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.commonslocal.BaseComponent;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

public class StepsBodyOffers extends BaseComponent {

    private Methods methods = new Methods();

    @Step("The user clicks on the header label Offers")
    public StepsBodyOffers clickOnEntryOffers(){
        this.header.clickOnEntryOffers();
        return this;
    }

    @Step("The user clicks on the first card offer")
    public StepsBodyOffers clickOnFirstCardOffer(){
        this.methods.waitForPageLoad();
        this.methods.clickElement("cardResultSearch");
        this.methods.waitForPageLoad();
        return this;
    }

    @Step("The user visualize and check details about offer")
    public StepsBodyOffers visualizeCheckOfferDetails(){
        SoftAssert softAssert = new SoftAssert();

        boolean isFlatPhotoPresent = this.methods.visibleElement("imageFlatOfferDetail",3);
        softAssert.assertTrue(isFlatPhotoPresent);

        boolean is360PhotoPresent  = this.methods.visibleElement("imageRotateOfferDetail",3);
        softAssert.assertTrue(is360PhotoPresent);

        boolean isValueOfferPreset =
                this.methods.visibleElement("valueOfferDetail",3)
                && this.methods.getEntity("valueOfferDetail").getText().length() >0;

        softAssert.assertTrue(isValueOfferPreset);

        boolean isCodeOfferPresent = this.methods.visibleElement("codeOfferDetail",3)
                && this.methods.getEntity("codeOfferDetail").getText().length() >0;
        softAssert.assertTrue(isCodeOfferPresent);


        //Click to open panel description offer

        boolean isMeasuresOfferPresent = this.methods.visibleElement("panelMeasures",3);
        softAssert.assertTrue(isMeasuresOfferPresent);

        boolean isMonthlyExpensesPresent = this.methods.visibleElement("panelMonthlyExpenses",3);
        softAssert.assertTrue(isMonthlyExpensesPresent);



    return this;
    }


}
