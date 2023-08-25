package standalone;

import components.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ProductPage;

import static org.testng.Assert.assertEquals;

public class AddToCartHappyPathTests extends TestBase {

    @Test(dataProvider = "getData")
    public void addingProductsToCartTest(String productName, String expectedAlertMessage) {

        ProductPage productPage = mainPage.clickToSeeProductDetails(productName);
        productPage.clickAddToCartButton();

        String actualAlertMessage = mainPage.getAlertText();
        assertEquals(actualAlertMessage, expectedAlertMessage,"Alert messages don't match");

        mainPage.clickAlertOKButton();

    }

    @DataProvider
    public Object[][] getData() {

        return new Object[][] {
                {"Sony vaio i5", "Product added"},
                {"Sony vaio i7", "Product added"}
        };

    }

}
