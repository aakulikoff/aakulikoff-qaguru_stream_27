package tests;

import io.qameta.allure.restassured.AllureRestAssured;
import models.lombok.*;
import models.pojo.*;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusExtendedTests extends TestBase {

    @Test
    void successfulLoginPojoTest() {

        LoginBodyModels authData = new LoginBodyModels();
        authData.setEmail("eve.holt@reqres.in");
        authData.setPassword("cityslicka");

        LoginResponseModels response = given()
                .contentType(JSON)
                .body(authData)
                .log().uri()
                .log().body()
                .log().headers()
        .when()
                .post("login")
        .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(LoginResponseModels.class);

        assertEquals("QpwL5tke4Pnpja7X4", response.getToken());
    }

    @Test
    void successfulLoginLombokTest() {

        LoginBodyLombokModels authData = new LoginBodyLombokModels();
        authData.setEmail("eve.holt@reqres.in");
        authData.setPassword("cityslicka");

        LoginResponseLombokModels response = given()
                .log().uri()
                .log().body()
                .log().headers()
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

    @Test
    void successfulLoginAllureTest() {

        LoginBodyLombokModels authData = new LoginBodyLombokModels();
        authData.setEmail("eve.holt@reqres.in");
        authData.setPassword("cityslicka");

        LoginResponseLombokModels response = given()
                .filter(new AllureRestAssured())
                .log().uri()
                .log().body()
                .log().headers()
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

    @Test
    void successfulLoginCustomAllureTest() {

        LoginBodyLombokModels authData = new LoginBodyLombokModels();
        authData.setEmail("eve.holt@reqres.in");
        authData.setPassword("cityslicka");

        LoginResponseLombokModels response = given()
                .filter(new AllureRestAssured())
                .log().uri()
                .log().body()
                .log().headers()
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

    @Test
    void successfulLoginAllureStepsTest() {

        LoginBodyLombokModels authData = new LoginBodyLombokModels();
        authData.setEmail("eve.holt@reqres.in");
        authData.setPassword("cityslicka");

        LoginResponseLombokModels response = step( "Сделать запрос", ()->
                     given()
                            .filter(new AllureRestAssured())
                            .log().uri()
                            .log().body()
                            .log().headers()
                            .contentType(JSON)
                            .body(authData)
                    .when()
                            .post("login")
                    .then()
                            .log().status()
                            .log().body()
                            .statusCode(200)
                            .extract().as(LoginResponseLombokModels.class));

        step( "Проверить ответ", ()->
            assertEquals("QpwL5tke4Pnpja7X4", response.getToken()));
    }

}
