package testingPOM;

import base.TestUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ProductTest extends TestUtil {


    @DataProvider(name = "ItemsList")
    public Object[][] getItemFromList() {
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources1/itemsList.csv"));
            List<String[]> csvData = csvReader.readAll();
            Object[][] itemFromCSV = new Object[csvData.size()][1];

            for (int i = 0; i < csvData.size(); i++) {
                itemFromCSV[i] = csvData.get(i);
            }
            return itemFromCSV;
        } catch (IOException e) {
            System.out.println("File not found!");
            return null;
        } catch (CsvException e) {
            return null;
        }
    }

    @Test(dataProvider = "getItemFromList")
    public void addItemToTheCart(String itemsFromCSV) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login("standard_user","secret_sauce");

        //productPage.addItemToCart();

    }



}
