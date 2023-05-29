package testingPOM;

import base.TestUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class FailingLoginTest extends TestUtil {

    @FindBy (xpath = "//h3[@data-test='error']" )
    private WebElement errorMessage;

    @FindBy (className = "error-button")
    private WebElement errorMessageText;

    @DataProvider(name = "IncorrectUsers")
    public Object [][] ReadIncorrectUsersFromCSV(){

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

    @Test(dataProvider = "IncorrectUsers")
    public void failingLogin(String username, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);


        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessageText,"Epic sadface: Username and password do not match any user in this service");
    }
}
