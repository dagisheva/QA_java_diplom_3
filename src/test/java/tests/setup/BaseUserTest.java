package tests.setup;

import helpers.TestData;
import org.junit.Before;
import pom.LoginPage;
import pom.RegistrationPage;

public class BaseUserTest extends BaseTest {
    protected LoginPage loginPage;
    protected String name;
    protected String email;
    protected RegistrationPage registrationPage;

    @Before
    public void openLoginPage() {
        name = TestData.generateLogin();
        email = TestData.generateEmail();
        homePage.clickPersonalAccountButton();
        loginPage = new LoginPage(driver);
        loginPage.clickRegistration();
        registrationPage = new RegistrationPage(driver);
    }
}
