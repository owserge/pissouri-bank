package com.pissouri.controller;

import com.pissouri.ApiTest;
import com.pissouri.RestApiTest;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static com.pissouri.JsonMatcher.equalToJson;
import static io.restassured.RestAssured.given;

@ApiTest
@RunWith(SpringRunner.class)
public class AccountControllerApiTest extends RestApiTest {

    @Test
    public void getAccount_shouldReturnAccountDto_whenAccountFound() {

        String expectedBody = readFromClasspath("getAccount_whenAccountFound.json");

        given()
                .when()
                .get("/account")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(equalToJson(expectedBody));
    }
}