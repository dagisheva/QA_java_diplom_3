package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordPage extends BasePage {
    private final By loginButton = By.xpath(".//a[text()='Войти']");

    public RestorePasswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click login button RestorePassword page")
    public void clickLoginRestorePass() {
        clickOnElement(loginButton);
    }
}
