package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@name='Username']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@name='Password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@value='Sign in']")
    private WebElement signInButton;
    @FindBy(xpath = "//span[@class='qa-email-validation field-validation-error']/span")
    private WebElement errorIncorrectEmail;

    public WebElement isCheckErrorIncorrectEmail() {
        return errorIncorrectEmail;
    }

    public String getTextErrorIncorrectEmail() {
        return errorIncorrectEmail.getText();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void enterPasswordField(final String password) {
        passwordField.sendKeys(password);
    }

    public void enterEmailField(final String email) {
        emailField.sendKeys(email);
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
