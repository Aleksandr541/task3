package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {
    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;
    SearchResultsPage searchResultsPage;
    CartPage cartPage;
    RegistrationPage registrationPage;
    MarketPlacePage marketPlacePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    ManPage manPage;
    PageFactoryManager pageFactoryManager;


    @Before
    public void testSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }


    @Given("User opens {string} page")
    public void userOpensHomePagePage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        homePage.getSearchField();
    }

    @And("User enters {string} in search field")
    public void userMakesSearchByKeywordKeyword(final String keyword) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickSearchField();
        homePage.enterTextToSearchField(keyword);
    }

    @When("User clicks on 'Search' button")
    public void userClicksOnSearchButton() {
        homePage.enterSearchButton();
    }

    @Then("User checks {string} products on the page")
    public void userChecksNumberProductsOnThePage(final String expectedAmount) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getElementOnPage());
        Assert.assertEquals(expectedAmount, searchResultsPage.numbersProductsOnPage());
    }

    @And("User checks 'Lod More' button visibility")
    public void userChecksHowManyProductsAreNumberOfProductsOnThePage() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.checkElementOnPage();
    }


    @And("User clicks on 'Show more' button")
    public void userClicksOnShowMoreButton() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.clickLoadMore();
    }

    @Then("User checks how many products are {string} on the page")
    public void userChecksHowManyProductsAreOnThePage(final String expectedNumbers) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getElementOnPage());
        Assert.assertEquals(expectedNumbers, searchResultsPage.numbersProductsOnPage());
    }


    @When("User clicks for the selected product")
    public void userClicksForTheSelectedProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.clickListProductsOnFirstProduct();
    }

    @And("User choice size product")
    public void userChoiceSizeProduct() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getSizeSelectElement());
        productPage.clickSizeSelect();
        productPage.getChoiceSizeSelect();
    }

    @And("User clicks button 'Add to Bag'")
    public void userClicksAddToBagButton() {
        productPage.clickAddToBag();
    }

    @And("User clicks button 'Bag'")
    public void userClicksButtonBag() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getButtonBag());
        productPage.clickButtonBag();
    }

    @And("User clicks 'View Bag' button")
    public void userClicksButtonViewBag() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getButtonViewBag());
        productPage.clickButtonViewBag();
    }

    @Then("User checks the {string} of items in the cart")
    public void userChecksTheNumberOfItemsInTheCart(final String expectedNumber) {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, cartPage.checkNumberProductElement());
        Assert.assertEquals(expectedNumber, cartPage.getCheckNumberProduct());
    }


    @And("User clicks Register button")
    public void userClicksOnTheRegisterButton() {
        homePage = pageFactoryManager.getHomePage();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getButtonRegister());
        homePage.clickButtonRegister();
    }

    @And("User click on the Join button")
    public void userClickOnTheJoinButton() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getButtonJoinElement());
        homePage.clickButtonJoin();
    }

    @And("User enters Invalid {string} into Email field of registration")
    public void userEntersInvalidEmailIntoEmailFieldOfRegistrationFormAndPressEnter(final String email) {
        registrationPage = pageFactoryManager.getRegistrationPage();
        registrationPage.getEmailField(email);
    }

    @And("User enters Invalid {string} into First name field of registration")
    public void userEntersInvalidFirstNameIntoFirstNameFieldOfRegistrationFormAndPressEnter(final String firstName) {
        registrationPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, registrationPage.isCheckFirstNameField());
        registrationPage.getFirstNameField(firstName);
    }

    @And("User enters Invalid {string} into Last name field of registration")
    public void userEntersInvalidLastNameIntoLastNameFieldOfRegistrationFormAndPressEnter(final String lastName) {
        registrationPage.getLastNameField(lastName);
    }

    @When("User enters Invalid {string} into Password field of registration")
    public void userEntersInvalidPasswordIntoPasswordFieldOfRegistrationFormAndPressEnter(final String password) {
        registrationPage.getPasswordField(password);
    }

    @Then("User checks an {string}")
    public void userChecksAnError(final String expectedText) {
        Assert.assertEquals(expectedText, registrationPage.getException());
    }

    @And("User clicks Sign In link")
    public void userClicksSignInLink() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSignInLink());
        homePage.clickSignInLink();
    }

    @And("User enters {string} into email field")
    public void userEntersEmailIntoEmailField(final String email) {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.enterEmailField(email);
    }

    @And("User enters {string} into password field")
    public void userEntersPasswordIntoPasswordField(final String password) {
        loginPage.enterPasswordField(password);
    }

    @And("User clicks Sign In submitting button")
    public void userClicksSignInSubmittingButton() {
        loginPage.clickSignInButton();
    }

    @Then("User checks that MyAccountPage has{string}")
    public void userChecksThatMyAccountPageHasText(final String expectedText) {
        myAccountPage = pageFactoryManager.getMyAccountPage();
        myAccountPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        myAccountPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, myAccountPage.getExpectedTextElement());
        Assert.assertEquals(expectedText, myAccountPage.getExpectedText());
    }

    @And("User clicks on Marketplace button")
    public void userClicksOnMarketplaceButton() {
        homePage.clickButtonMarketplace();
    }

    @And("User checks  {string} on the marketplace page")
    public void userChecksTextOnTheMarketplacePage(final String expectedText) {
        marketPlacePage = pageFactoryManager.getMarketPlacePage();
        Assert.assertTrue(marketPlacePage.getBooleanTextHolderPage());
    }


    @Then("User checks the {string} on the marketplace page")
    public void userChecksTheTextOnTheMarketplacePage(final String expectedText) {
        Assert.assertEquals(expectedText, driver.getCurrentUrl());
    }

    @And("User clicks on Man button")
    public void userClicksOnManButton() {
        homePage.clickManButton();
    }

    @And("User checks that Men's Sale Carousel is visible")
    public void userChecksThatMenSSaleCarouselIsVisible() {
        manPage = pageFactoryManager.getManPage();
        Assert.assertTrue(manPage.isManCarouselElement());
    }

    @And("User clicks on Carousel scroll forward button")
    public void userClicksOnCarouselScrollForwardButton() {
        manPage.clickNextButtonCarousel();
    }

    @And("User checks that Carousel where scrolled forward")
    public void userChecksThatCarouselWhereScrolledForward() {
        manPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, manPage.getNextElement());
        Assert.assertTrue(manPage.isCheckNextElement());
    }

    @When("User clicks on Carousel scroll back button")
    public void userClicksOnCarouselScrollBackButton() {
        manPage.clickPreviousButtonCarousel();
    }

    @And("User checks that Carousel where scrolled back")
    public void userChecksThatCarouselWhereScrolledBack() {
        manPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, manPage.getPreviousElement());
        Assert.assertTrue(manPage.isCheckPreviousElement());
    }

    @Then("User checks {string} elements in Carousel")
    public void userChecksAmountElementsInCarousel(final String expectedAmount) {
        System.out.println(manPage.getListOfElementsInCarouselString());
        Assert.assertEquals(expectedAmount, manPage.getListOfElementsInCarouselString());
    }

    @And("User checks that Bag visibility")
    public void userChecksThatBagVisibility() {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, cartPage.getExpectedText());
        Assert.assertTrue(cartPage.isCheckTextToCart());
    }

    @And("User removes product from the cart")
    public void userRemovesProductFromTheCart() {
        cartPage.clickRemoveProduct();
    }

    @Then("User checks that the cart is {string}")
    public void userChecksThatTheCartIsEmpty(final String expectedText) {
        cartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, cartPage.getBagIsEmptyElement());
        Assert.assertEquals(expectedText, cartPage.getTextBagIsEmpty());
    }

    @When("User checks field filter's Brand visibility")
    public void userChecksFieldFilterSBrandVisibility() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getFilterBrandElement());
        Assert.assertTrue(searchResultsPage.isCheckFilterBrand());
    }

    @And("User clicks Brand filter field")
    public void userClicksBrandFilterField() {
        searchResultsPage.clickFilterBrand();
    }

    @When("User checks button Asos visibility")
    public void userChecksButtonAsosVisibility() {
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getButtonBrandElement());
        Assert.assertTrue(searchResultsPage.isCheckButtonBrand());
    }

    @And("User clicks Asos button")
    public void userClicksAsosButton() {
        searchResultsPage.clickButtonBrand();
    }

    @Then("The user checks all products {string} Asos")
    public void theUserChecksAllProductsBrandAsos(final String expectedText) {
        searchResultsPage.clickFilterBrand();
        Assert.assertTrue(searchResultsPage.containsString(expectedText));
    }

    @Then("User checks that the registration page contains the address {string} or the wrong password")
    public void userChecksThatTheRegistrationPageContainsTheAddressTextOrTheWrongPassword(final String expectedText) {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, loginPage.isCheckErrorIncorrectEmail());
        Assert.assertEquals(expectedText, loginPage.getTextErrorIncorrectEmail());
    }

    @And("User moves cursor on clothing")
    public void userMovesCursorOnClothing() {

        marketPlacePage = pageFactoryManager.getMarketPlacePage();
        marketPlacePage.moveCursorOnClothing();
    }

    @And("User chooses category of knitwear")
    public void userChoosesCategoryOfKnitwear() {
        marketPlacePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, marketPlacePage.getKnitwearForWoman());
        marketPlacePage.clickKnitwearForWoman();
    }

    @And("User clicks on menu of sort on marketplace")
    public void userClicksOnMenuOfSortOnMarketplace() {
        marketPlacePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, marketPlacePage.getMenuOfSort());
        marketPlacePage.clickMenuOfSort();
    }

    @And("User chooses sort by FromHighToLow on marketplace")
    public void userChoosesSortByTypeOfSortOnMarketplace() {
        marketPlacePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, marketPlacePage.getButtonOfSortFromHighToLow());
        marketPlacePage.clickButtonOfSortFromHighToLow();
    }

    @And("User checks that sort updated on marketplace")
    public void userChecksThatSortUpdatedOnMarketplace() {
        marketPlacePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, marketPlacePage.getMenuOfSort());
    }

    @Then("User checks that products are sorted by {string} on marketplace")
    public void userChecksThatProductsAreSortedByTypeOfSortOnMarketplace(final String typeOfSort) {
        marketPlacePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(marketPlacePage.sortByPrice(marketPlacePage.getListOfPriceOfProduct(), typeOfSort));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
