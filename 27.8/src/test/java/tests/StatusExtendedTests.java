package tests;

import models.lombok.*;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusExtendedTests extends TestBase {

    @Test
    void successfulLogin2() {

        LoginBodyLombokModels authData = new LoginBodyLombokModels();
        authData.setEmail("eve.holt@reqres.in");
        authData.setPassword("cityslicka");

        LoginResponseLombokModels response = given()
                .contentType(JSON)
                .body(authData)
        .when()
                .post("login")
        .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(LoginResponseLombokModels.class);

        assertEquals("QpwL5tke4Pnpja7X4", response.getToken());
    }

}
