package tests;

import helpers.ApiSteps;
import helpers.TestData;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import tests.setup.BaseUserTest;

public class RegistrationTests extends BaseUserTest {
    private String password = TestData.generateSuccessPassword();

    @Test
    @DisplayName("Registration test")
    public void registrationTest() {
        registrationPage.fillRegistrationData(name, email, password);
        registrationPage.waitForRegistrationButton();
        registrationPage.clickRegistration();
        WebElement element = loginPage.waitForLoginButton();
        Assert.assertNotNull("Login button should be present", element);
    }

    @After
    public void loginAndDelete() {
        String token = ApiSteps.loginGetToken(email, password);
        Response response = ApiSteps.deleteUser(token);
        System.out.println(response.getBody().asString());
    }
}
