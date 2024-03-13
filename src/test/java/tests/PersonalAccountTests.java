package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pom.LoginPage;
import pom.PersonalAccountPage;
import tests.setup.BaseLoginTest;


public class PersonalAccountTests extends BaseLoginTest {
    protected LoginPage loginPage;
    private PersonalAccountPage personalAccountPage;
    private WebElement element;

    @Before
    public void loginUser() {
        homePage.clickPersonalAccountButton();
        loginPage = new LoginPage(driver);
        loginPage.fillLoginDataAndLogin(email, password);
        homePage.clickPersAccWhenObscured();
        personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.waitForExitButton();
    }

    @Test
    @DisplayName("Personal Account test")
    public void goToPersonalAccountTest() {
        String nameInPersAcc = personalAccountPage.getNameFieldValue();
        String emailInPersAcc = personalAccountPage.getLoginFieldValue();
        System.out.println(emailInPersAcc);
        Assert.assertEquals("Names should match", name, nameInPersAcc);
        Assert.assertEquals("Emails should match", email, emailInPersAcc);
    }

    @Test
    @DisplayName("Go to constructor via Constructor test")
    public void goToConstructotTest() {
        personalAccountPage.clickConstructorButton();
        element = homePage.waitForConstructBurgerElement();
        Assert.assertNotNull("ConstructBurger element should be present", element);
    }

    @Test
    @DisplayName("Go to constructor via Logo test")
    public void goToConstructorViaStellarTest() {
        personalAccountPage.clickLogoButton();
        WebElement element = homePage.waitForConstructBurgerElement();
        Assert.assertNotNull("ConstructBurger element should be present", element);
    }

    @Test
    @DisplayName("Exit test")
    public void exitTest() {
        personalAccountPage.clickExitButton();
        WebElement element = loginPage.waitForLoginButton();
        Assert.assertNotNull("Login button should be present", element);
    }
}
