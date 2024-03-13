package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordPage extends HomePage {
    private final By loginButton = By.xpath(".//a[text()='Войти']");

    public RestorePasswordPage(WebDriver driver) {
        HomePage.driver = driver;
    }

    @Step("Click login button RestorePassword page")
    public void clickLoginRestorePass() {
        clickOnElement(loginButton);
    }
}
