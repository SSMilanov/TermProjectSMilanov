package pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class LoginPage extends BasePage {
    ///////////////////////////////////////////
    /////////Initializing the page ////////////
    ///////////////////////////////////////////
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /////////////////////
    //Find Web elements//
    /////////////////////
    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    @FindBy(className = "title")
    private WebElement prPageTitle;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement userMenuBtn;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    //////////////
    ///Actions ///
    //////////////
    public ProductPage login (String userName, String password) throws InterruptedException {
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys(userName);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        loginBtn.click();
        return new ProductPage(driver);
    }

}
