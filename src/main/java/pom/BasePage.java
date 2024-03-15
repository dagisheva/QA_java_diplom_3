package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By element) {
        return driver.findElement(element);
    }

    public void clickOnElement(By element) {
        findElement(element).click();
    }

    public org.openqa.selenium.WebElement waitForElementToBeVisible(By element) {
        WebElement expectedElement = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            expectedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException e) {
            System.out.println("Element with locator " + element + " not found within the specified timeout.");
        }
        return expectedElement;
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
}
