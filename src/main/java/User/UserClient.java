package User;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserAPI extends RestClient {

private static final String DELETE_USER = "auth/user";

private static final String CREATE_USER = "auth/register";


    public ValidatableResponse create(String email, String password, String name]) {
        return given()
                .spec(getBaseSpec())
                .body(email, password, name)
                .when()
                .post(CREATE_USER)
                .then();
    }
    public ValidatableResponse deleteUser(String authToken) {
        return given()
                .spec(getBaseSpec())
                .header("Authorization", authToken)
                .when()
                .delete(DELETE_USER)
                .then();
    }
}

