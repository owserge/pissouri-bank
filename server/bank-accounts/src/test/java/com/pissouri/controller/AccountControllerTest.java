package com.pissouri.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class AccountControllerTest {

    @LocalServerPort
    private int serverPort;

    @Before
    public void setup() {

        RestAssured.port = serverPort;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void getAccount_shouldReturnAccountDto() {

        given()
                .when()
                .get("/account")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("status_code", equalTo(2000))
                .body("status_text", equalTo("ok"))
                .body("data", notNullValue())
                .body("data.id", equalTo(42))
                .body("data.number", equalTo("PB100042"))
                .body("data.currency", equalTo("EUR"))
                .body("data.balance", equalTo(32750))
                .body("data.reference", equalTo("4d2e6b5b-e1db-4227-b117-c3644b4f31a6"))
                .body("data.created_at", equalTo("2018-07-01T00:00:00Z"))
                .body("data.updated_at", equalTo("2018-07-01T00:00:00Z"));
    }
}
