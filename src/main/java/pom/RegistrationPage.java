package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {
    private final By nameField = By.xpath(".//fieldset[1]/div/div/input");
    private final By emailField = By.xpath(".//fieldset[2]/div/div/input");
    private final By passwordField = By.xpath(".//fieldset[3]/div/div/input");
    private final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By wrongPassError = By.xpath(".//p[text()='Некорректный пароль']");
    private final By loginButton = By.xpath(".//a[text()='Войти']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill name field")
    public void fillNameField(String name) {
        inputData(nameField, name);
    }

    @Step("Fill email field")
    public void fillEmailField(String email) {
        inputData(emailField, email);
    }

    @Step("Fill password field")
    public void fillPasswordField(String password) {
        inputData(passwordField, password);
    }

    @Step("Fill registration data")
    public void fillRegistrationData(String name, String email, String password) {
        fillNameField(name);
        fillEmailField(email);
        fillPasswordField(password);
    }

    @Step("Click Registration")
    public void clickRegistration() {
        clickOnElement(registrationButton);
    }

    @Step("Wait for incorrect password error")
    public void CheckWrongPassError() {
        CheckIfTransitionOccured(wrongPassError);
    }

    @Step("Click login button RegistrationPage")
    public void clickLoginButtonRegistrationPage() {
        clickOnElement(loginButton);
    }

    @Step("Wait for Registration button")
    public void waitForRegistrationButton() {
        CheckIfTransitionOccured(registrationButton);
    }
}
