package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyAccountPage extends BasePage {
    @FindBy(xpath = "//div[@class='_3hSCfS2']/span[@class='tiqiyps']")
    private WebElement expectedText;

    public WebElement getExpectedTextElement() {
        return expectedText;
    }

    public String getExpectedText() {
        return expectedText.getText();
    }

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
}
