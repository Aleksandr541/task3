package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
    @FindBy(xpath = "//input[@alt='Email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@class='qa-password-textbox input-validation-error']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@class='qa-firstname-textbox input-validation-error']")
    public WebElement firstNameField;
    @FindBy(xpath = "//input[@class='qa-lastname-textbox input-validation-error']")
    private WebElement lastNameField;
    @FindBy(xpath = "//span[@id='Email-error']")
    private WebElement exception;

    public String getException() {
        return exception.getText();
    }

    public void getLastNameField(String lastName) {
        lastNameField.click();
    }

    public WebElement isCheckFirstNameField() {

        return firstNameField;
    }

    public void getFirstNameField(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void getPasswordField(String password) {
        passwordField.sendKeys(password);
    }


    public void getEmailField(String email) {
        emailField.sendKeys(email, Keys.ENTER);
    }

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
}
