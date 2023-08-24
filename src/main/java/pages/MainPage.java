package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "signin2")
    WebElement signUpHeaderButton;

    @FindBy(id = "sign-username")
    WebElement signUpUsernameInput;

    @FindBy(id = "sign-password")
    WebElement signUpPasswordInput;

    @FindBy(css = "button[onclick='register()']")
    WebElement signUpModalButton;

    public void goTo() {
        driver.get("https://www.demoblaze.com/index.html");
    }

}
