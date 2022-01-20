package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;
    @FindBy(xpath = "//p[@class='vp-JnyG']")
    private WebElement expectedText;
    @FindBy(xpath = "//button[@type='submit' and @data-testid='search-button-inline']")
    private WebElement searchButton;
    @FindBy(xpath = "//span[@type='accountUnfilled']")
    private WebElement buttonRegister;
    @FindBy(xpath = "//a[contains(text(),'Join')]")
    private WebElement buttonJoin;
    @FindBy(xpath = "//nav[@class='_3EAPxMS']//span[text()='Marketplace']")
    private WebElement marketplaceButton;
    @FindBy(xpath = "//div[contains(@style,'1221?&$n_320w$\");')]/following-sibling::div")
    private WebElement chooseVintageMenu;
    @FindBy(xpath = "//a[@data-testid='marketplace']")
    private WebElement buttonOfMarketplace;
    @FindBy(xpath = "//a[@data-testid='signin-link']")
    private WebElement signInLink;
    @FindBy(xpath = "//a[@data-testid='myaccount-link']")
    private WebElement myAccountLink;
    @FindBy(xpath = "//a[@data-testid='men-floor']")
    private WebElement manButton;

    public void clickManButton() {
        manButton.click();
    }

    public WebElement getButtonJoinElement() {
        return buttonJoin;
    }

    public void clickButtonMarketplace() {
        buttonOfMarketplace.click();
    }

    public WebElement getSignInLink() {
        return signInLink;
    }

    public void clickSignInLink() {
        signInLink.click();
    }

    public void clickButtonJoin() {
        buttonJoin.click();
    }

    public WebElement getButtonRegister() {
        return buttonRegister;
    }

    public void clickButtonRegister() {
        buttonRegister.click();
    }

    public void enterSearchButton() {
        searchButton.click();
    }

    public void clickSearchField() {
        searchField.click();
    }

    public void getSearchField() {
        searchField.isDisplayed();
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.sendKeys(searchText);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
