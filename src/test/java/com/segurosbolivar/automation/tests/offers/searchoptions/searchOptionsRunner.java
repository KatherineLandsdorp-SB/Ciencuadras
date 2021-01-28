package com.segurosbolivar.automation.tests.offers.searchoptions;

import com.segurosbolivar.automation.commons.Hooks;
import com.segurosbolivar.automation.tests.offers.StepsOffers;
import com.segurosbolivar.automation.tests.offers.asserts.OfferAsserts;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class searchOptionsRunner extends Hooks {
    ThreadLocal<StepsOffers> steps = ThreadLocal.withInitial(StepsOffers::new);

    @Test
    public void searchByCityOrSectorOrNeighborhood() {
        List<String> searches = Arrays.asList("cali", "", "bogota", "", "pereira", "cartagena", "", "wwtygfdrewdfghjjklkloiuytwwww");
        steps.get().clickEntry();
        searches.forEach(searchText -> {
            List<WebElement> listResultOffers = steps.get()
                    .writeSearch(searchText)
                    .clickSearchOffersButton()
                    .getResultOffers();

            if (listResultOffers.size() > 0) {
                OfferAsserts.checkMessageOnSale(listResultOffers, steps.get());
            } else {
                OfferAsserts.checkMessageNotResultOffers(steps.get());
            }
        });
    }
}
