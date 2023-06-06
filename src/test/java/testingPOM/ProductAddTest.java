package testingPOM;

import base.TestUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.ProductPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ProductAddTest extends TestUtil {

    @Test
    public void addItemToTheCart() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login("standard_user","secret_sauce");

        SoftAssert softAssert = new SoftAssert();

        productPage.addItemToCart("bike-light");
        Assert.assertEquals(productPage.getItemsInCart(),1);

        productPage.addItemToTheCart("onesie");
        Assert.assertEquals(productPage.getItemsInCart(),2);

        productPage.addItemToTheCart("fleece-jacket");
        Assert.assertEquals(productPage.getItemsInCart(),3);

        productPage.removeItemFromTheCart("bike-light");
        Assert.assertEquals(productPage.getItemsInCart(),2);

        productPage.removeItemFromTheCart("onesie");
        Assert.assertEquals(productPage.getItemsInCart(),1);

        softAssert.assertAll();
    }



}
