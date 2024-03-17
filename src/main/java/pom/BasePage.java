package pom;

import helpers.CustomException;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private final By constructorButton = By.xpath(".//a[@href='/']/p[text()='Конструктор']");
    private final By logo = By.xpath(".//div/a[@href='/']");
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By element) {
        return driver.findElement(element);
    }

    public void clickOnElement(By element) {
        findElement(element).click();
    }

    public void CheckIfTransitionOccured(By element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException e) {
            throw new CustomException("The transition to the page did not occur or expected element didn't found");
        }
    }


    public void inputData(By element, String data) {
        WebElement elementToFill = findElement(element);
        elementToFill.clear();
        elementToFill.sendKeys(data);
    }

    public String getFieldAttribute(By element, String attribute) {
        WebElement webElement = driver.findElement(element);
        return webElement.getAttribute(attribute);
    }

    @Step("Click Constructor button")
    public void clickConstructorButton() {
        clickOnElement(constructorButton);
    }

    @Step("Click Logo button")
    public void clickLogoButton() {
        clickOnElement(logo);
    }
}
