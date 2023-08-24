package stepdefinition;

import components.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MainPage;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class StepDefinition extends TestBase {

    public MainPage mainPage;

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

}
