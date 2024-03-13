package helpers;

public class Config {
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

}
