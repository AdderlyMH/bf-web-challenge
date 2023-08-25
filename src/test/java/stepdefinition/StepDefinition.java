package stepdefinition;

import components.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MainPage;
import pages.ProductPage;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class StepDefinition extends TestBase {

    public MainPage mainPage;
    public ProductPage productPage;

    @Given("user goes to the main page")
    public void userGoesToTheMainPage() throws IOException {
        mainPage = startApp();
    }

    @Given("user clicks the header SIGN UP button")
    public void userClicksTheHeaderSIGNUPButton() {
        mainPage.clickSignUpHeaderButton();
    }

    @Given("user writes data: {string}, {string}")
    public void userWritesData(String username, String password) {
        mainPage.writeSignUpUsernameInput(username);
        mainPage.writeSignUpPasswordInput(password);
    }

    @When("user clicks the modal SIGN UP button")
    public void userClicksTheModalSIGNUPButton() {
        mainPage.clickSignUpModalButton();
    }

    @Then("appears a pop-up with the message {string}")
    public void appearsAPopUpWithTheMessage(String expectedAlertMessage) {
        String actualAlertMessage = mainPage.getAlertText();
        assertEquals(actualAlertMessage, expectedAlertMessage,"Alert messages don't match");
    }

    @And("clicks the OK alert button")
    public void clicksTheOKAlertButton() {
        mainPage.clickAlertOKButton();
    }

    @And("closes the modal SIGN UP form")
    public void closesTheModalSIGNUPForm() {
        mainPage.clickCloseModalButton();
    }

    @Given("user clicks the header LOGIN button")
    public void userClicksTheHeaderLOGINButton() {
        mainPage.clickLoginHeaderButton();
    }

    @And("user writes login data: {string}, {string}")
    public void userWritesLoginData(String username, String password) {
        mainPage.writeLoginUsernameInput(username);
        mainPage.writeLoginPasswordInput(password);
    }

    @When("user clicks the modal LOG IN button")
    public void userClicksTheModalLOGINButton() {
        mainPage.clickLoginModalButton();
    }

    @Then("appears a button with the message {string}")
    public void appearsAButtonWithTheMessage(String expectedUsernameWelcome) {
        String actualUsernameWelcome = mainPage.getWelcomeUsernameButtonText();
        assertEquals(actualUsernameWelcome, expectedUsernameWelcome,"Username welcome doesn't match");
    }

    @And("user clicks the header LOG OUT button")
    public void userClicksTheHeaderLOGOUTButton() {
        mainPage.clickLogoutHeaderButton();
    }

    @Given("user clicks on product {string}")
    public void userClicksOnProduct(String productName) {
        productPage = mainPage.clickToSeeProductDetails(productName);
    }

    @When("user clicks the ADD TO CART button")
    public void userClicksTheADDTOCARTButton() {
        productPage.clickAddToCartButton();
    }

}
