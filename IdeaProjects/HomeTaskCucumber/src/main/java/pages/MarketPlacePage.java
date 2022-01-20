package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MarketPlacePage extends BasePage {
    @FindBy(xpath = "//span[@class='AsosMpSiteChrome__TopBar_logoContainer_2sMWE']//a[@title='ASOS marketplace']")
    private WebElement textHolderPage;
    @FindBy(xpath = "//span[text()='Clothing']")
    private WebElement buttonOfClosing;
    @FindBy(xpath = "//a[text()='Knitwear']")
    private WebElement knitwearForWoman;
    @FindBy(xpath = "//select[@name='SortOptions']")
    private WebElement menuOfSort;
    @FindBy(xpath = "//p[@class='price']//span[@class='integer']")
    public List<WebElement> listOfPriceOfProduct;
    @FindBy(xpath = "//option[contains(text(),'Price High to Low')]")
    private WebElement buttonOfSortFromHighToLow;

    public WebElement getButtonOfSortFromHighToLow(){
        return buttonOfSortFromHighToLow;
    }
    public void clickButtonOfSortFromHighToLow() {
        buttonOfSortFromHighToLow.click();
    }

    public WebElement getMenuOfSort() {
        return menuOfSort;
    }

    public void clickMenuOfSort() {
        menuOfSort.click();
    }

    public WebElement getKnitwearForWoman() {
        return knitwearForWoman;
    }

    public void clickKnitwearForWoman() {
        knitwearForWoman.click();
    }

    public void moveCursorOnClothing() {
        new Actions(driver).moveToElement(buttonOfClosing).build().perform();
    }

    public boolean getBooleanTextHolderPage() {
        return textHolderPage.isDisplayed();
    }

    public MarketPlacePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getListOfPriceOfProduct() {
        return listOfPriceOfProduct;
    }

    public boolean sortByPrice(List<WebElement> webElements, String typeOfSort) {

        boolean result = true;
        for (int i = 0; i < webElements.size() - 1; i++) {
            if (typeOfSort.equals("FromHighToLow")) {
                if (Integer.parseInt(webElements.get(i).getText()) < Integer.parseInt(webElements.get(i + 1).getText())) {
                    result = false;
                }
            } else {
                if (Integer.parseInt(webElements.get(i).getText()) > Integer.parseInt(webElements.get(i + 1).getText())) {
                    result = false;
                }
            }
        }
        return result;
    }
}
