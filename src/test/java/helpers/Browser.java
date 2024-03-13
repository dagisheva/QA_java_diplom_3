package helpers;

import org.openqa.selenium.WebDriver;

public class Browser {
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

    }

    public WebDriver returnYandex() {}
}
