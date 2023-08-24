package components;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.MainPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;
    public MainPage mainPage;

    public WebDriver initializeDriver() throws IOException {

        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/GlobalData.properties");
        properties.load(fis);
        String browser = System.getProperty("browser") != null ? System.getProperty("browser") : properties.getProperty("browser");

        if (browser.contains("chrome")) {

            ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            if (browser.contains("headless"))
                chromeOptions.addArguments("headless");
            driver = new ChromeDriver(chromeOptions);

        } else if (browser.contains("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.contains("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.manage().window().maximize();
        return driver;

    }

    @BeforeMethod(alwaysRun = true)
    public MainPage startApp() throws IOException {

        driver = initializeDriver();
        mainPage = new MainPage(driver);
        mainPage.goTo();
        return mainPage;

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

}
