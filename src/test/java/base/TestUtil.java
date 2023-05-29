package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v110.webauthn.model.CredentialAdded;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestUtil {

    public WebDriver driver;
    public String appURL;
    public String browser;
    public int implicitWait;

    @BeforeMethod
    public void setupDriverAndOpenTestURL() {
        readConfig("src/test/resources1/config.properties");
        setupWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.get(appURL);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    ////////////////////////////////////////
    ////// Read config file for info ///////
    ////////////////////////////////////////
    private void readConfig(String confFile) {
        try {
            FileInputStream fileInputStream = new FileInputStream(confFile);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            appURL = properties.getProperty("testURL");
            browser = properties.getProperty("browser");
            implicitWait = Integer.parseInt(properties.getProperty("implicitWait"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    ////////////////////////////////////////
    //Setup for firefox and chrome drivers//
    ////////////////////////////////////////
    private WebDriver setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private WebDriver setupFfoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private void setupWebDriver() {
        switch (browser) {
            case "chrome":
                driver = setupChromeDriver();
                break;
            case "firefox":
                driver = setupFfoxDriver();
                break;
        }
    }
    ////////////////////////////////////////////
    //Driver to be closed upon test completion//
    ////////////////////////////////////////////


}

