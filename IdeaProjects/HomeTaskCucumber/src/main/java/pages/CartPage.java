package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @FindBy(xpath = "//span[@class='select2-selection__rendered' and contains(@title,'1')]")
    private WebElement checkNumberProduct;
    @FindBy(xpath = "//h2[@class='bag-title bag-title--total' and contains(text(),'Total')]")
    private WebElement expectedText;
    @FindBy(xpath = "//button[@class='bag-item-remove']")
    private WebElement removeProduct;
    @FindBy(xpath = "//h2[@class='empty-bag-title']")
    private WebElement bagIsEmpty;

    public WebElement getBagIsEmptyElement() {
        return bagIsEmpty;
    }

    public String getTextBagIsEmpty() {
        return bagIsEmpty.getText();
    }

    public void clickRemoveProduct() {
        removeProduct.click();
    }

    public WebElement getExpectedText() {
        return expectedText;
    }

    public boolean isCheckTextToCart() {
        return expectedText.isDisplayed();
    }

    public String getCheckNumberProduct() {
        return checkNumberProduct.getText();
    }

    public WebElement checkNumberProductElement() {
        return checkNumberProduct;
    }

    public CartPage(WebDriver driver) {
        super(driver);
    }
}
