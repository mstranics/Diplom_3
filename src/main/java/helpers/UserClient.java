package helpers;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient extends RestClient {
private static final String  REGISTER_USER_PATH ="/api/auth/register";
    private static final String  LOGIN_USER_PATH ="/api/auth/login";
    private static final String USER_PATH = "/api/auth/user";

    @Step("Create user via API")
    public ValidatableResponse create(User user ) {
        return given().filter(new AllureRestAssured())
                .spec(getBaseSpec())
                .body(user)
                .when()
                .post(REGISTER_USER_PATH)
                .then();
    }

    @Step("Login via API")
    public ValidatableResponse login(UserCreds userCreds) {

        return given().log().all().filter(new AllureRestAssured())
                .spec(getBaseSpec())
                .body(userCreds)
                .when()
                .post(LOGIN_USER_PATH)
                .then().log().body();
    }
    @Step("Delete user via API")
    public ValidatableResponse delete(String accessToken) {
        return given().filter(new AllureRestAssured())
                .spec(getBaseSpec())
                .headers("Authorization", accessToken)
                .when()
                .delete(USER_PATH)
                .then();

    }
}
