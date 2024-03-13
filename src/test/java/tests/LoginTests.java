package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pom.LoginPage;
import pom.RegistrationPage;
import pom.RestorePasswordPage;
import tests.setup.BaseLoginTest;

public class LoginTests extends BaseLoginTest {
    private LoginPage loginPage;
    private WebElement element;


    @Test
    @DisplayName("Login from HomePage test")
    public void loginFromHomePageTest() {
        homePage.clickLoginButton();
        loginPage = new LoginPage(driver);
        loginPage.fillLoginDataAndLogin(email, password);
        element = homePage.waitForOrderButton();
        Assert.assertNotNull("Order button should be present", element);
    }

    @Test
    @DisplayName("Login via Personal Account button test")
    public void loginWithPersonalAccountButtonTest() {
        homePage.clickPersonalAccountButton();
        loginPage = new LoginPage(driver);
        loginPage.fillLoginDataAndLogin(email, password);
        element = homePage.waitForOrderButton();
        Assert.assertNotNull("Order button should be present", element);
    }

    @Test
    @DisplayName("Login via button on RegistrationPage test")
    public void loginRegistrationPageTest() {
        homePage.clickPersonalAccountButton();
        loginPage = new LoginPage(driver);
        loginPage.clickRegistration();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickLoginButtonRegistrationPage();
        loginPage.fillLoginDataAndLogin(email, password);
        element = homePage.waitForOrderButton();
        Assert.assertNotNull("Order button should be present", element);
    }

    @Test
    @DisplayName("Login via button on RestorePasswordPage test")
    public void loginRestorePasswordPageButton() {
        homePage.clickPersonalAccountButton();
        loginPage = new LoginPage(driver);
        loginPage.clickRestorePasswordButton();
        RestorePasswordPage restorePage = new RestorePasswordPage(driver);
        restorePage.clickLoginRestorePass();
        loginPage.fillLoginDataAndLogin(email, password);
        element = homePage.waitForOrderButton();
        Assert.assertNotNull("Order button should be present", element);
    }
}
