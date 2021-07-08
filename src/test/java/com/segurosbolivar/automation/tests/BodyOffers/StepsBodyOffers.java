package com.segurosbolivar.automation.tests.BodyOffers;
import com.segurosbolivar.automation.commonslocal.BaseComponent;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import org.testng.asserts.SoftAssert;

public class StepsBodyOffers extends BaseComponent {


    public  StepsBodyOffers(JSONObject json){
        super(json);
    }

    @Step("The user clicks on the header label Offers")
    public StepsBodyOffers clickOnEntryOffers() {
        this.header.clickOnEntryOffers();
        return this;
    }

    @Step("The user clicks on the header rent offers")
    public StepsBodyOffers clickOnEntryRentOffers() {
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


    @Step("The user check card offer have (photo,measures and buttons) in the list")
    public StepsBodyOffers verifyCardOfferList() {
        this.methods.waitForPageLoad();

        SoftAssert softAssert = new SoftAssert();

        boolean isPhotoCardPresent = this.methods.visibleElement("photoCardOffer", 3);
        softAssert.assertTrue(isPhotoCardPresent);

        boolean isValueCardOfferPreset = this.methods.visibleElement("valueCardOffer", 3) && this.methods.getEntity("valueCardOffer").getText().trim().length() > 0;;
        softAssert.assertTrue(isValueCardOfferPreset);

        boolean isLocationTextPresent = this.methods.visibleElement("locationCardOffer", 3)
                && this.methods.getEntity("locationCardOffer").getText().trim().length() > 0;
        softAssert.assertTrue(isLocationTextPresent);

        boolean isTypeOfferTextPresent = this.methods.visibleElement("typeCardOffer", 3)
                && this.methods.getEntity("typeCardOffer").getText().trim().length() > 0;

        softAssert.assertTrue(isTypeOfferTextPresent);

        boolean numRoomsPresent = this.methods.visibleElement("numRoomsOfferCard", 3)
                && this.methods.getEntity("numRoomsOfferCard").getText().trim().length() > 0;

        softAssert.assertTrue(numRoomsPresent);

        boolean numBathRoomsPresent = this.methods.visibleElement("numBathRoomsOfferCard", 3)
                && this.methods.getEntity("numBathRoomsOfferCard").getText().trim().length() > 0;

        softAssert.assertTrue(numBathRoomsPresent);

        boolean sizeSquareSpacePresent = this.methods.visibleElement("sizeSquareOfferCard", 3)
                && this.methods.getEntity("sizeSquareOfferCard").getText().trim().length() > 0;

        softAssert.assertTrue(sizeSquareSpacePresent);

        boolean isPresetButtonContactCardOffer = this.methods.visibleElement("buttonContactCard", 3);
        softAssert.assertTrue(isPresetButtonContactCardOffer);

        if (isPresetButtonContactCardOffer) {
            this.methods.clickElementJs("buttonContactCard");
            boolean isPresentContactWhatsapp = this.methods.visibleElement("buttonContactWhatsappCard", 3);
            softAssert.assertTrue(isPresentContactWhatsapp);
        }

        boolean isPresentButtonCompareOffers = this.methods.visibleElement("checkCompareOffers", 3);

        softAssert.assertTrue(isPresentButtonCompareOffers);


        softAssert.assertAll();

        return this;
    }


}
