package helpers;

import com.github.javafaker.Faker;

public class TestData {
    private static Faker faker = new Faker();
    private static String activeTabIdentifier = "tab_tab_type_current__2BEPc";

    public static String generateLogin() {
        return faker.name().username();
    }

    public static String generateSuccessPassword() {
        String password = faker.name().firstName();
        while (password.length() < 6) {
            password = faker.name().firstName();
        }
        return password;
    }

    public static String generateEmail() {
        return faker.internet().emailAddress();
    }

    public static String generateWrongPassword() {
        String password = faker.name().firstName();
        while (password.length() > 5) {
            password = faker.name().firstName();
        }
        return password;
    }

    public static String returnActiveTabIdentifier() {
        return activeTabIdentifier;
    }
}
