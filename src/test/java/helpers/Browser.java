package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
    private String chromeDriverPath = Config.CHROMEDRIVER_PATH;
    private String yandexDriverPath = Config.YANDEXDRIVER_PATH;
    private String yandexBrowserPath = Config.YANDEXBROWSER_PATH;
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
        System.setProperty("webdriver.chrome.driver", yandexDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.setBinary(yandexBrowserPath);
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }
}
