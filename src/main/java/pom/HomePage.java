package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    protected WebDriver driver;
    private final String parentPath = "/parent::div";
    private final String saucesTabPath = ".//span[text()='Соусы']";
    private final String fillingsTabPath = ".//span[text()='Начинки']";
    private final String bunsTabPath = ".//span[text()='Булки']";
    private final String saucesTabParentPath = saucesTabPath + parentPath;
    private final String fillingsTabParentPath = fillingsTabPath + parentPath;
    private final String bunsTabParentPath = bunsTabPath + parentPath;
    private final By personalAccountButton = By.xpath(".//a[@href='/account']");
    private final By loginAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By orderButton = By.xpath(".//button[text()='Оформить заказ']");
    private final By constructorButton = By.xpath(".//a[@href='/']/p[text()='Конструктор']");
    private final By logo = By.xpath(".//div/a[@href='/']");
    private final By constructBurger = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']");
    private final By bunsTab = By.xpath(bunsTabPath);
    private final By sauceTab = By.xpath(saucesTabPath);
    private final By fillingsTab = By.xpath(fillingsTabPath);
    private final By bunsTabParent = By.xpath(bunsTabParentPath);
    private final By saucesTabParent = By.xpath(saucesTabParentPath);
    private final By fillingsTabParent = By.xpath(fillingsTabParentPath);

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By element) {
        return driver.findElement(element);
    }

    public void clickOnElement(By element) {
        findElement(element).click();
    }

    public WebElement waitForElementToBeVisible(By element) {
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

    @Step("Get attribute class of Buns")
    public String getClassBunsTab() {
        return getFieldAttribute(bunsTabParent, "class");
    }

    @Step("Get attribute class of Sauces")
    public String getClassSauceTab() {
        return getFieldAttribute(saucesTabParent, "class");
    }

    @Step("Get attribute class of Fillings")
    public String getClassFillingsTab() {
        return getFieldAttribute(fillingsTabParent, "class");
    }

    @Step("Go to Fillings tab")
    public void goToFillingsTab() {
        clickOnElement(fillingsTab);
    }

    @Step("Go to Sauces tab")
    public void goToSaucesTab() {
        clickOnElement(sauceTab);
    }

    @Step("Go to Buns tab")
    public void goToBunsTab() {
        clickOnElement(bunsTab);
    }

    @Step("Go to personal account page")
    public void clickPersonalAccountButton() {
        clickOnElement(personalAccountButton);
    }

    @Step("Click loginAccountButton")
    public void clickLoginButton() {
        clickOnElement(loginAccountButton);
    }

    @Step("Wait for Order button")
    public WebElement waitForOrderButton() {
        return waitForElementToBeVisible(orderButton);
    }

    @Step("Wait for PersonalAccoutn button")
    public void waitForPersonalAccountButton() {
        waitForElementToBeVisible(personalAccountButton);
    }

    @Step("Click Constructor button")
    public void clickConstructorButton() {
        clickOnElement(constructorButton);
    }

    @Step("Click Logo button")
    public void clickLogoButton() {
        clickOnElement(logo);
    }

    @Step("Wait for constructBurgerElement")
    public WebElement waitForConstructBurgerElement() {
        return waitForElementToBeVisible(constructBurger);
    }
}
