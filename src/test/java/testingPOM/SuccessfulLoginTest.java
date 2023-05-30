package testingPOM;

import base.TestUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;


import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class SuccessfulLoginTest extends TestUtil {

    //DATA PROVIDER
    @DataProvider(name = "correctUsers")
    public Object[][] correctUsers() {
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources1/correctUsers.csv"));
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObj = new Object[csvData.size()][2];

            for (int i = 0; i < csvData.size(); i++) {
                csvDataObj[i] = csvData.get(i);
            }
            return csvDataObj;
        } catch (IOException e) {
            System.out.println("File not found!");
            return null;
        } catch (CsvException e) {
            return null;
        }
    }

    //TESTS
    @Test(dataProvider = "correctUsers")
    public void successfulLogin(String userName, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login(userName, password);
        productPage.logout();
    }
}
