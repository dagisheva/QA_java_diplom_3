package tests.setup;

import helpers.ApiSteps;
import helpers.TestData;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;

public class BaseLoginTest extends BaseTest {
    protected String name;
    protected String email;
    protected String password;
    String token;

    @Before
    public void generateUser() {
        name = TestData.generateLogin();
        email = TestData.generateEmail();
        password = TestData.generateSuccessPassword();
        token = ApiSteps.createUserGetToken(email, password, name);
    }

    @After
    public void deleteUser() {
        Response response = ApiSteps.deleteUser(token);
        System.out.println(response.getBody().asString());
    }
}
