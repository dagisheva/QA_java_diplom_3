package tests;

import helpers.TestData;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import tests.setup.BaseUserTest;

public class RegistrationWrongPassTest extends BaseUserTest {
    private String password = TestData.generateWrongPassword();

    @Test
    public void createUserWrongPass() {
        registrationPage.fillRegistrationData(name, email, password);
        registrationPage.clickRegistration();
        WebElement element = registrationPage.waitForIncorrectPassError();
        Assert.assertNotNull("Incorrect password error should be present", element);
    }
}
