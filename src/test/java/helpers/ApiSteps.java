package helpers;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import pojo.User;

import static io.restassured.RestAssured.given;

public class ApiSteps {
    private static User user;
    private static String registerPath = Config.CREATE_USER_PATH;
    private static String loginPath = Config.LOGIN_USER_PATH;
    private static String userPath = Config.USER_PATH;

    @Step("Create user via API")
    public static Response createUserAPI(String email, String password, String name) {
        user = new User(email, password, name);
        return given().header("Content-type", "application/json").and().body(user).when().post(registerPath);
    }

    @Step("Get access token")
    public static String getAccessToken(Response response) {
        return response.then().extract().path("accessToken");
    }

    @Step("Create user and get token")
    public static String createUserGetToken(String email, String password, String name) {
        Response response = createUserAPI(email, password, name);
        return getAccessToken(response);
    }

    @Step("Login and get token")
    public static String loginGetToken(String email, String password) {
        User loginUser = new User(email, password);
        Response response = given().header("Content-type", "application/json").and().body(loginUser).when()
                .post(loginPath);
        System.out.println(response.getBody().asString());
        return getAccessToken(response);
    }

    @Step("Delete User step")
    public static Response deleteUser(String accessToken) {
        return given().header("Content-type", "application/json").and()
                .header("Authorization", accessToken).when().delete(userPath);
    }
}
