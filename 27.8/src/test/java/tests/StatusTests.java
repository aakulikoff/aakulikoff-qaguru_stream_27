package tests;

import org.junit.jupiter.api.*;

import static utils.FileUtils.readStringFromFile;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusTests extends TestBase {

    @Test
    void getListUsers(){

        String actualResponse =
        given()
                .log().uri()
                .get("users?page=2")
                .then()
                .log().body()
                .statusCode(200).extract().asString();

        String expectedResponse = readStringFromFile("src/test/resources/data/listUsers/expectedResponse.json");
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void getSingleUserNotFound(){
        given()
                .log().uri()
                .get("users/23")
                .then()
                .log().body()
                .statusCode(404);
    }

    @Test
    void createUser(){
        String requestData = readStringFromFile("src/test/resources/data/createUser/requestData.json");

                given()
                        .log().uri()
                        .contentType(JSON)
                        .body(requestData)
                        .when()
                        .post("users")
                        .then()
                        .log().body()
                        .statusCode(201)
                        .body("name", is("morpheus"))
                        .body("job",  is("leader"));
    }

    @Test
    void successfulLogin() {
        String requestData = readStringFromFile("src/test/resources/data/loginUser/requestData.json");
        String actualResponse =
                given()
                        .contentType(JSON)
                        .body(requestData)
                        .when()
                        .post("login")
                        .then()
                        .statusCode(200).extract().asString();

        String expectedResponse = readStringFromFile("src/test/resources/data/loginUser/expectedResponse.json");
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void successfulLogin2() {
        String data = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";
        given()
                .contentType(JSON)
                .body(data)
                .when()
                .post("login")
                .then()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    void registerUnsucessful() {
        String requestData = readStringFromFile("src/test/resources/data/registerUser/requestData.json");
        String actualResponse =
                given()
                        .contentType(JSON)
                        .body(requestData)
                        .log().body()
                        .when()
                        .post("register")
                        .then()
                        .log().body()
                        .statusCode(400).extract().asString();

        String expectedResponse = readStringFromFile("src/test/resources/data/registerUser/expectedResponse.json");
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void deleteUser() {
        given()
                .contentType(JSON)
                .when()
                .delete("users/2")
                .then()
                .statusCode(204);
    }

}
