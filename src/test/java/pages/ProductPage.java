package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProductPage extends BasePage {

        final  String PRODUCT_ID = "add-to-cart-sauce-labs-";
        ///////////////////////////////////////////
        /////////Initializing the page ////////////
        ///////////////////////////////////////////
        public ProductPage(WebDriver driver){
            super(driver);
            PageFactory.initElements(driver, this);
        }

        /////////////////////
        //Find Web elements//
        /////////////////////
        @FindBy(className = "title")
        private WebElement pageTitle;

        @FindBy(id = "react-burger-menu-btn")
        private WebElement userMenuBtn;

        @FindBy(id = "shopping_cart_container")
        private WebElement shoppingCart;

        @FindBy(className = "shopping_cart_badge")
        private WebElement shoppingCartBadge;

        @FindBy(id = "logout_sidebar_link")
        private WebElement logoutLink;

        ///////////////////////
        /// Actions/Methods  //
        ///////////////////////
        public void addItemToTheCart(String itemName){

            WebElement itemToBeAdded = driver.findElement(By.id(PRODUCT_ID + itemName));
            itemToBeAdded.click();
        }

        public int getItemsInCart(){
            return Integer.parseInt(shoppingCartBadge.getText());
        }

        public void logout(){

        userMenuBtn.click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait2.until(ExpectedConditions.visibilityOf(logoutLink));
        logoutLink.click();

    }
}