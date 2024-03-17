package tests;

import helpers.ApiSteps;
import helpers.TestData;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Test;
import tests.setup.BaseUserTest;

public class RegistrationTests extends BaseUserTest {
    private String password = TestData.generateSuccessPassword();

    @Test
    @DisplayName("Registration test")
    public void registrationTest() {
        password = TestData.generateSuccessPassword();
        registrationPage.fillRegistrationData(name, email, password);
        registrationPage.waitForRegistrationButton();
        registrationPage.clickRegistration();
        loginPage.checkLoginPage();
    }

    @Test
    public void createUserWrongPass() {
        password = TestData.generateWrongPassword();
        registrationPage.fillRegistrationData(name, email, password);
        registrationPage.clickRegistration();
        registrationPage.CheckWrongPassError();
    }

    @After
    public void loginAndDelete() {
        String token = ApiSteps.loginGetToken(email, password);
        if(token!=null) {
            Response response = ApiSteps.deleteUser(token);
            System.out.println(response.getBody().asString());
        }
    }
}
