package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.AbstractComponents;

public class ProductPage extends AbstractComponents {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn-success")
    WebElement addToCartButton;
    By byAddToCartButton = By.cssSelector(".btn-success");

    public void clickAddToCartButton() {
        waitVisibilityOfElementLocated(byAddToCartButton);
        addToCartButton.click();
    }

    public String getAlertText() {
        return waitAndSwitchToAlert().getText();
    }

}
