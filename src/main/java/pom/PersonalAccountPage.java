package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage extends BasePage {
    private static final By profileLink = By.xpath(".//a[@href='/account/profile']");
    private static final By nameField = By.xpath(".//label[text()='Имя']/following-sibling::input");
    private static final By emailField = By.xpath(".//label[text()='Логин']/following-sibling::input");
    private static final By exitButton = By.xpath(".//button[text()='Выход']");
    private static final By saveButton = By.xpath(".//button[text()='Сохранить']");
    private static final By testButton = By.xpath("");

    public PersonalAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get login field value")
    public String getLoginFieldValue() {
        return getFieldAttribute(emailField, "value");
    }

    @Step("Get name field value")
    public String getNameFieldValue() {
        return getFieldAttribute(nameField, "value");
    }

    @Step("Wait for fields")
    public void waitForNameField() {
        checkIfTransitionOccured(nameField);
    }

    @Step("Get classSet")
    public void waitProfileLink() {
        checkIfTransitionOccured(profileLink);
    }

    @Step("Click exit button")
    public void clickExitButton() {
        clickOnElement(exitButton);
    }

    public void waitForExitButton() {
        checkIfTransitionOccured(exitButton);
    }

    public void waitForSaveButton() {
        checkIfTransitionOccured(saveButton);
    }

    public void waitForTestButton() {
        checkIfTransitionOccured(testButton);
    }
}
