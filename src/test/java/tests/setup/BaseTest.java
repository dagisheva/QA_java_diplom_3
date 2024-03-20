package tests.setup;

import helpers.Browser;
import helpers.Config;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pom.HomePage;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUri = Config.BASE_URI;
    protected HomePage homePage;
    /*System.getProperty("property"*/
    @Before
    public void startUp() {
        driver = new Browser().getWebDriver("chrome");
        driver.get(baseUri);
        RestAssured.baseURI = baseUri;
        homePage = new HomePage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
