package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ManPage extends BasePage {
    @FindBy(xpath = "//ul[@class='carousel__list js-carouselList']")
    private WebElement manCarousel;
    @FindBy(xpath = "//button[@class='next js-next']")
    private WebElement nextButtonCarousel;
    @FindBy(xpath = "//button[@class='previous js-previous']")
    private WebElement previousButtonCarousel;
    @FindBy(xpath = "//span[@class='carousel__labelText' and contains(text(),'T-SHIRTS & VESTS')]")
    private WebElement nextElement;
    @FindBy(xpath = "//span[@class='carousel__labelText' and contains(text(),'COATS & JACKETS')]")
    private WebElement previousElement;
    @FindBy(xpath = "//ul[@class='carousel__list js-carouselList']/li")
    private List<WebElement> listOfElementsInCarousel;


    public WebElement getNextElement() {
        return nextElement;
    }

    public WebElement getPreviousElement() {
        return previousElement;
    }

    public String getListOfElementsInCarouselString() {
        return Integer.toString(getListOfElementsInCarousel().size());
    }

    public List<WebElement> getListOfElementsInCarousel() {
        return listOfElementsInCarousel;
    }

    public boolean isCheckPreviousElement() {
        return previousElement.isDisplayed();
    }

    public boolean isCheckNextElement() {
        return nextElement.isDisplayed();
    }

    public void clickPreviousButtonCarousel() {
        previousButtonCarousel.click();
    }

    public void clickNextButtonCarousel() {
        nextButtonCarousel.click();
    }

    public boolean isManCarouselElement() {
        return manCarousel.isDisplayed();
    }

    public ManPage(WebDriver driver) {
        super(driver);
    }
}
