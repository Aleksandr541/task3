package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//select[@data-id='sizeSelect']")
    private WebElement clickSizeSelect;
    @FindBy(xpath = "//select[@data-id='sizeSelect']/option[contains(text(),'EU')]")
    private WebElement choiceSize;
    @FindBy(xpath = "//span[@data-bind='text: buttonText']")
    private WebElement addToBag;
    @FindBy(xpath = "//span[@class='_1z5n7CN']")
    private WebElement buttonBag;
    @FindBy(xpath = "//span[contains(text(),'View Bag')]")
    private WebElement buttonViewBag;

    public WebElement getButtonViewBag() {
        return buttonViewBag;
    }

    public WebElement getButtonBag() {
        return buttonBag;
    }

    public void clickButtonViewBag() {
        buttonViewBag.click();
    }

    public void clickButtonBag() {
        buttonBag.click();
    }

    public WebElement getSizeSelectElement() {
        return clickSizeSelect;
    }

    public void clickSizeSelect() {
        clickSizeSelect.click();
    }

    public void getChoiceSizeSelect() {
        choiceSize.click();
    }

    public void clickAddToBag() {
        addToBag.click();
    }

    public ProductPage(WebDriver driver) {
        super(driver);
    }
}
