package testingPOM;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.ProductPage;

public class ProblemUserTest extends TestUtil {
    @Test
    public void problemUserTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login("problem_user","secret_sauce");

        SoftAssert softAssert = new SoftAssert();

        WebElement image0Link = driver.findElement(By.xpath("//a[@id='item_0_img_link']/img"));
        String src0 = image0Link.getAttribute("src");
        String src0Exp = "https://www.saucedemo.com/static/media/bike-light-1200x1500.37c843b0.jpg";
        softAssert.assertEquals(src0,src0Exp);

        WebElement image1Link = driver.findElement(By.xpath("//a[@id='item_1_img_link']/img"));
        String src1 = image1Link.getAttribute("src");
        String src1Exp = "https://www.saucedemo.com/static/media/bolt-shirt-1200x1500.c2599ac5.jpg";
        softAssert.assertEquals(src1,src1Exp);

        WebElement image2Link = driver.findElement(By.xpath("//a[@id='item_2_img_link']/img"));
        String src2 = image2Link.getAttribute("src");
        String src2Exp = "https://www.saucedemo.com/static/media/red-onesie-1200x1500.2ec615b2.jpg";
        softAssert.assertEquals(src2,src2Exp);

        WebElement image3Link = driver.findElement(By.xpath("//a[@id='item_3_img_link']/img"));
        String src3 = image3Link.getAttribute("src");
        String src3Exp = "https://www.saucedemo.com/static/media/red-tatt-1200x1500.30dadef4.jpg";
        softAssert.assertEquals(src3,src3Exp);

        WebElement image4Link = driver.findElement(By.xpath("//a[@id='item_4_img_link']/img"));
        String src4 = image4Link.getAttribute("src");
        String src4Exp = "https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg";
        softAssert.assertEquals(src4,src4Exp);

        WebElement image5Link = driver.findElement(By.xpath("//a[@id='item_5_img_link']/img"));
        String src5 = image5Link.getAttribute("src");
        String src5Exp = "https://www.saucedemo.com/static/media/sauce-pullover-1200x1500.51d7ffaf.jpg";
        softAssert.assertEquals(src5,src5Exp);

        softAssert.assertAll();
       productPage.logout();
        }



    }
