package tests.setup;

import helpers.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.HomePage;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUri = Config.returnBaseUri();
    protected HomePage homePage;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUri);
        RestAssured.baseURI = baseUri;
        homePage = new HomePage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
