package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return new HomePage(driver);
    }
    public ProductPage getProductPage(){
        return new ProductPage(driver);
    }
    public SearchResultsPage getSearchResultsPage(){
        return new SearchResultsPage(driver);
    }
    public CartPage getCartPage(){
        return new CartPage(driver);
    }
    public RegistrationPage getRegistrationPage(){
        return new RegistrationPage(driver);
    }
    public MarketPlacePage getMarketPlacePage(){
        return new MarketPlacePage(driver);
    }
    public LoginPage getLoginPage(){
        return new LoginPage(driver);
    }
    public MyAccountPage getMyAccountPage(){
        return new MyAccountPage(driver);
    }
    public ManPage getManPage(){
        return new ManPage(driver);
    }
}
