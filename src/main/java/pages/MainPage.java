package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.AbstractComponents;

public class MainPage extends AbstractComponents {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "signin2")
    WebElement signUpHeaderButton;
    By bySignUpHeaderButton = By.id("signin2");

    @FindBy(id = "sign-username")
    WebElement signUpUsernameInput;

    @FindBy(id = "sign-password")
    WebElement signUpPasswordInput;

    @FindBy(css = "button[onclick='register()']")
    WebElement signUpModalButton;
    By bySignUpModalButton = By.cssSelector("button[onclick='register()']");

    public void goTo() {
        driver.get("https://www.demoblaze.com/index.html");
    }

    public void clickSignUpHeaderButton() {
        waitVisibilityOfElementLocated(bySignUpHeaderButton);
        signUpHeaderButton.click();
    }

    public void writeSignUpUsernameInput(String usernameText) {
        waitVisibilityOfElementLocated(bySignUpModalButton);
        signUpUsernameInput.sendKeys(usernameText);
    }

    public void writeSignUpPasswordInput(String passwordText) {
        signUpPasswordInput.sendKeys(passwordText);
    }

    public void clickSignUpModalButton() {
        signUpModalButton.click();
    }

    public String getAlertText() {
        return waitAndSwitchToAlert().getText();
    }

}
