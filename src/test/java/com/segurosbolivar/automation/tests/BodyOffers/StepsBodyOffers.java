package com.segurosbolivar.automation.tests.BodyOffers;

import com.segurosbolivar.automation.commons.Methods;
import com.segurosbolivar.automation.commonslocal.BaseComponent;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

public class StepsBodyOffers extends BaseComponent {

    private Methods methods = new Methods();

    @Step("The user clicks on the header label Offers")
    public StepsBodyOffers clickOnEntryOffers() {
        this.header.clickOnEntryOffers();
        return this;
    }

    @Step("The user clicks on the header rent offers")
    public  StepsBodyOffers clickOnEntryRentOffers(){
        this.header.selectRentRealState();
        return this;
    }

    @Step("The user clicks on the first card offer")
    public StepsBodyOffers clickOnFirstCardOffer() {
        this.methods.waitForPageLoad();
        this.methods.clickElement("cardResultSearch");
        this.methods.waitForPageLoad();
        return this;
    }

    @Step("The user clicks and open the new window detail offer")
    public StepsBodyOffers clicksOnWindowDetailOffer() {
        this.methods.switchToAnotherWindow(2);
        return this;
    }

    @Step("The user visualize and check details about offer")
    public StepsBodyOffers visualizeCheckOfferDetails() throws Exception {
        this.methods.waitForPageLoad();
        SoftAssert softAssert = new SoftAssert();

        boolean isFlatPhotoPresent = this.methods.visibleElement("imageFlatOfferDetail", 3);
        softAssert.assertTrue(isFlatPhotoPresent);

        this.methods.waitingForElement("buttonCarruselRight", 5);
        this.methods.clickElementJs("buttonCarruselRight");

        boolean is360PhotoPresent = this.methods.visibleElement("imageRotateOfferDetail", 3);
        softAssert.assertTrue(is360PhotoPresent);

        boolean isValueOfferPreset =
                this.methods.visibleElement("valueOfferDetail", 3)
                        && this.methods.getEntity("valueOfferDetail").getText().length() > 0;

        softAssert.assertTrue(isValueOfferPreset);

        boolean isCodeOfferPresent = this.methods.visibleElement("codeOfferDetail", 3)
                && this.methods.getEntity("codeOfferDetail").getText().length() > 0;
        softAssert.assertTrue(isCodeOfferPresent);

        this.methods.clickElementJs("buttonDropDownPanelDescription");

        boolean isMeasuresOfferPresent = this.methods.visibleElement("panelMeasures", 3);
        softAssert.assertTrue(isMeasuresOfferPresent);

        boolean isMonthlyExpensesPresent = this.methods.visibleElement("panelMonthlyExpenses", 3);
        softAssert.assertTrue(isMonthlyExpensesPresent);

        boolean isCreditSimulatorPresent = this.methods.visibleElement("tittleCreditSimulator", 3);
        softAssert.assertTrue(isCreditSimulatorPresent);

        this.methods.scrollToEndPage();
        this.methods.waitingForElement("buttonMapPositionDetailOffer", 3);
        this.methods.clickElement("buttonMapPositionDetailOffer");
        this.methods.waitingForElement("mapDetailOffer", 5);

        boolean isMarkerMapOfferPresent = this.methods.visibleElement("mapMarkerDetailOffer", 3);
        softAssert.assertTrue(isMarkerMapOfferPresent);

        softAssert.assertAll();

        return this;
    }

    @Step("The user fill all form to contact owner of the offer")
    public StepsBodyOffers fillAllFormContactOwnerOffer(String name, String email, String cellPhone) {

        this.methods.sendKeysText("fieldNameContactOffer", name);
        this.methods.sendKeysText("fieldEmailContactOffer", email);
        this.methods.sendKeysText("fieldCellPhoneContactOffer", cellPhone);

        return this;
    }


}
