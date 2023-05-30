package testingPOM;

import base.TestUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.ProductPage;

import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.time.Duration;
import java.util.List;

public class FailingLoginTest extends TestUtil {


    @DataProvider(name = "incorrectUsers")
    public Object [][] getIncorrectUsers(){

        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources1/incorrectUsers.csv"));
            List<String []> csvData = csvReader.readAll();
            Object [] [] csvDataObj = new Object[csvData.size()][2];

            for (int i = 0; i < csvData.size() ; i++) {
                csvDataObj[i] = csvData.get(i);
            }
            return  csvDataObj;
        } catch (IOException e) {
            System.out.println("File not found!");
            return  null;
        } catch (CsvException e){
            return null;
        }
    }


    @Test (dataProvider = "incorrectUsers")
    public void failingLogin(String userName, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login(userName, password);

        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(),"Epic sadface: Username and password do not match any user in this service");
    }
}
