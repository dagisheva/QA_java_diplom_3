package helpers;

public class Config {
    private static final String chromeDriverPath = "tools/drivers/chromedriver/chromedriver.exe";
    private static final String yandexDriverPath = "tools/drivers/yandexdriver/yandexdriver.exe";
    private static final String yandexBrowserPath = "tools/YandexBrowser/Application/browser.exe";
    private static final String baseUri = "https://stellarburgers.nomoreparties.site";
    private static final String loginUrl = "/login";
    private static final String loginUserPath = "/api/auth/login";
    private static final String userPath = "/api/auth/user";
    private static final String createUserPath = "/api/auth/register";

    public static String returnBaseUri() {
        return baseUri;
    }

    public static String returnLoginUrl() {
        return baseUri + loginUrl;
    }

    public static String returnRegisterPath() {
        return createUserPath;
    }

    public static String returnLoginPath() {
        return loginUserPath;
    }

    public static String returnUserPath() {
        return userPath;
    }

    public static String returnChromeDriverPath() {
        return chromeDriverPath;
    }

    public static String returnYandexDriverPath() {
        return yandexDriverPath;
    }

    public static String returnYandexBrowserPath() {
        return yandexBrowserPath;
    }

}
