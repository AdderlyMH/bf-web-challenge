package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.AbstractComponents;

import java.util.List;

public class MainPage extends AbstractComponents {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    @FindBy(css = "#signInModal button.btn.btn-secondary")
    WebElement closeModalButton;

    @FindBy(id = "login2")
    WebElement loginHeaderButton;
    By byLoginHeaderButton = By.id("login2");

    @FindBy(id = "loginusername")
    WebElement loginUsernameInput;

    @FindBy(id = "loginpassword")
    WebElement loginPasswordInput;

    @FindBy(css = "button[onclick='logIn()']")
    WebElement loginModalButton;
    By byLoginModalButton = By.cssSelector("button[onclick='logIn()']");

    @FindBy(id = "nameofuser")
    WebElement welcomeUsernameButton;
    By byWelcomeUsernameButton = By.id("nameofuser");

    @FindBy(id = "logout2")
    WebElement logoutHeaderButton;
    By byLogoutHeaderButton = By.id("logout2");

    @FindBy(css = ".mb-4")
    List<WebElement> productList;

    public void goTo() {
        driver.get("https://www.demoblaze.com/index.html");
    }

    public void clickSignUpHeaderButton() {
        waitVisibilityOfElementLocated(bySignUpHeaderButton);
        signUpHeaderButton.click();
    }

    public void writeSignUpUsernameInput(String usernameText) {
        waitVisibilityOfElementLocated(bySignUpModalButton);
        signUpUsernameInput.clear();
        signUpUsernameInput.sendKeys(usernameText);
    }

    public void writeSignUpPasswordInput(String passwordText) {
        signUpPasswordInput.clear();
        signUpPasswordInput.sendKeys(passwordText);
    }

    public void clickSignUpModalButton() {
        signUpModalButton.click();
    }

    public void clickAlertOKButton() {
        waitAndSwitchToAlert().accept();
        switchToDefaultContent();
    }

    public void clickCloseModalButton() {
        closeModalButton.click();
    }

    public void clickLoginHeaderButton() {
        waitVisibilityOfElementLocated(byLoginHeaderButton);
        loginHeaderButton.click();
    }

    public void writeLoginUsernameInput(String usernameText) {
        waitVisibilityOfElementLocated(byLoginModalButton);
        loginUsernameInput.clear();
        loginUsernameInput.sendKeys(usernameText);
    }

    public void writeLoginPasswordInput(String passwordText) {
        loginPasswordInput.clear();
        loginPasswordInput.sendKeys(passwordText);
    }

    public void clickLoginModalButton() {
        loginModalButton.click();
    }

    public String getWelcomeUsernameButtonText() {
        waitVisibilityOfElementLocated(byWelcomeUsernameButton);
        return welcomeUsernameButton.getText();
    }

    public void clickLogoutHeaderButton() {
        waitVisibilityOfElementLocated(byLogoutHeaderButton);
        logoutHeaderButton.click();
    }

    public List<WebElement> getProductList() {
        waitVisibilityOfAllElements(productList);
        return productList;
    }

    public WebElement getProductByName(String productName) {
        return getProductList().stream().filter(product -> product.findElement(By.cssSelector(".card-title a")).
                getText().equals(productName)).findFirst().orElse(null);
    }

    public ProductPage clickToSeeProductDetails(String productName) {

        Actions actions = new Actions(driver);
        WebElement requiredProduct = getProductByName(productName);

        actions.scrollToElement(requiredProduct).click(requiredProduct).build().perform();
        return new ProductPage(driver);

    }

}
