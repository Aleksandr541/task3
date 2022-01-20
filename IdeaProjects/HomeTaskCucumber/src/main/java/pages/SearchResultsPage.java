package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {
    @FindBy(xpath = "//span[@class='_16nzq18']")
    private List<WebElement> listOfPriceProducts;
    @FindBy(xpath = "//p[text()='Your search results for:']")
    private WebElement massageAboutSearchResult;
    @FindBy(xpath = "//a[@class='_39_qNys']")
    private WebElement loadMore;
    @FindBy(xpath = "//span[@class='_16nzq18']")
    private WebElement product;
    @FindBy(xpath = "//div[@class='_2pwX7b9' and text()='Brand']")
    private WebElement filterBrand;
    @FindBy(xpath = "//div[text()='ASOS 4505']")
    private WebElement buttonAsosDesign;
    @FindBy(xpath = "//div[@class='_3J74XsK']//h2")
    private List<WebElement> listOfNameProducts;

    public boolean containsString(String expectedText) {
        for (WebElement a : listOfNameProducts) {
            String b = a.getText().toUpperCase();
            if (!b.contains(expectedText)) return false;
        }
        return true;
    }

    public WebElement getButtonBrandElement() {
        return buttonAsosDesign;
    }

    public void clickButtonBrand() {
        buttonAsosDesign.click();
    }

    public boolean isCheckButtonBrand() {
        return buttonAsosDesign.isDisplayed();
    }

    public WebElement getFilterBrandElement() {
        return filterBrand;
    }

    public void clickFilterBrand() {
        filterBrand.click();
    }

    public boolean isCheckFilterBrand() {
        return filterBrand.isDisplayed();
    }


    public WebElement getLoadMoreButton() {
        return loadMore;
    }

    public void clickLoadMore() {
        loadMore.click();
    }

    public boolean checkElementOnPage() {
        return loadMore.isDisplayed();
    }

    public WebElement getElementOnPage() {
        return loadMore;
    }

    public List<WebElement> getListProducts() {
        return listOfPriceProducts;
    }

    public void clickListProductsOnFirstProduct() {
        listOfPriceProducts.get(0).click();
    }

    public String numbersProductsOnPage() {
        return Integer.toString(getListProducts().size());
    }

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }
}
