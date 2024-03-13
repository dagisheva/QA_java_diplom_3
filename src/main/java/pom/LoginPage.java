package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends HomePage {
    private final By registrationPage = By.className("Auth_link__1fOlj");
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    private final By emailField = By.xpath(".//fieldset[1]/div/div/input");
    private final By passwordField = By.xpath(".//fieldset[2]/div/div/input");
    private final By restorePasswordButton = By.xpath(".//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        HomePage.driver = driver;
    }


    @Step("Go to Registration page")
    public void clickRegistration() {
        clickOnElement(registrationPage);
    }

    @Step("Wait for Login button to be visible")
    public WebElement waitForLoginButton() {
        return waitForElementToBeVisible(loginButton);
    }

    @Step("Fill email field")
    public void fillEmailField(String email) {
        inputData(emailField, email);
    }

    @Step("Fill password field")
    public void fillPasswordField(String password) {
        inputData(passwordField, password);
    }

    @Step("Fill login data")
    public void fillLoginDataAndLogin(String email, String password) {
        fillEmailField(email);
        fillPasswordField(password);
        loginPageClickLoginButton();
    }

    @Step("Click login button")
    public void loginPageClickLoginButton() {
        clickOnElement(loginButton);
    }

    @Step("Click restorePasswordButton")
    public void clickRestorePasswordButton() {
        clickOnElement(restorePasswordButton);
    }
}
