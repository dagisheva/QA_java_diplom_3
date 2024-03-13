package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
    private String chromeDriverPath = Config.returnChromeDriverPath();
    private String yandexDriverPath = Config.returnYandexDriverPath();
    private String yandexBrowserPath = Config.returnYandexBrowserPath();
    public WebDriver getWebDriver(String browserName) {
        WebDriver driver = null;
        switch(browserName) {
            case "chrome":
                driver = returnChrome();
                return driver;
            case "yandex":
                driver = returnYandex();
                return driver;
        }
        return driver;
    }

    public WebDriver returnChrome() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }

    public WebDriver returnYandex() {
        System.setProperty("webdriver.chrome.driver", yandexBrowserPath);
        ChromeOptions options = new ChromeOptions();
        options.setBinary(yandexBrowserPath);
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }
}
