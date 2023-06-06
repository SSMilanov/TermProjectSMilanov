package testingPOM;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class SortProdTest extends TestUtil {

    @Test
    public void sortItems() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login("standard_user", "secret_sauce");

        productPage.sortProductsBy("az");
        productPage.sortProductsBy("za");
        productPage.sortProductsBy("lohi");
        productPage.sortProductsBy("hilo");
    }
}