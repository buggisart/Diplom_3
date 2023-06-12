package User;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient extends RestClient {

private static final String DELETE_USER = "auth/user";

private static final String LOGIN_USER = "auth/login";

private static final String CREATE_USER = "auth/register";


public ValidatableResponse create(User user) {
        return given()
                .spec(getBaseSpec())
                .body(user)
                .when()
                .post(CREATE_USER)
                .then();
    }
    public ValidatableResponse login(UserCredentials userCredentials) {
        return given()
                .spec(getBaseSpec())
                .body(userCredentials)
                .when()
                .post(LOGIN_USER)
                .then();
    }
    public ValidatableResponse deleteUser(String authToken) {
        return given()
                .spec(getBaseSpec())
                .header("Authorization", authToken)
                .when()
                .delete(DELETE_USER)
                .then()
                .log().all();
    }
}

