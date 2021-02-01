package com.segurosbolivar.automation.tests.offers.searchoptions;

import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.tests.offers.StepsOffers;
import com.segurosbolivar.automation.tests.offers.asserts.OfferAsserts;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class searchOptionsRunner extends Hooks {
    ThreadLocal<StepsOffers> steps = ThreadLocal.withInitial(StepsOffers::new);

    @Test(dataProvider = "searchDataMethod")
    public void searchByCityOrSectorOrNeighborhood(String searchText) {
        steps.get().clickEntry();
        List<WebElement> listResultOffers = steps.get()
                .writeSearch(searchText)
                .clickSearchOffersButton()
                .getResultOffers();

        if (listResultOffers.size() > 0) {
            OfferAsserts.checkMessageOnSale(listResultOffers, steps.get());
        } else {
            OfferAsserts.checkMessageNotResultOffers(steps.get());
        }

    }

    @DataProvider(parallel = true)
    public Object[][] searchDataMethod() {
        return new Object[][]{{"cali"}, {"bogota"}};
    }
}
