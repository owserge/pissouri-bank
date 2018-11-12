package com.pissouri.controller;

import com.pissouri.dto.TransferStatusCode;
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
public class TransferControllerTest {
    @LocalServerPort
    private int serverPort;

    @Before
    public void setup() {

        RestAssured.port = serverPort;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void getAccountTransferById_shouldReturnTransferDto() {

        long transferId = 1L;

        given()
                .when()
                .get(String.format("/account/transfers/%s",transferId))
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("status_code", equalTo(2000))
                .body("status_text", equalTo("ok"))
                .body("data", notNullValue())
                .body("data.id", equalTo(1))
                .body("data.amount", equalTo(100))
                .body("data.currency", equalTo("EUR"))
                .body("data.status", equalTo(TransferStatusCode.ACCEPTED))
                .body("data.balance_after", equalTo(100))
                .body("data.reference", equalTo("e2b70dba-e6b3-11e8-9f32-f2801f1b9fd1"))
                .body("data.created_at", equalTo("2018-07-01T00:00:00Z"));
    }
}
