package com.pissouri.controller;

import com.pissouri.ApiTest;
import com.pissouri.RestApiTest;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static com.pissouri.dto.TransferStatusCode.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@ApiTest
@RunWith(SpringRunner.class)
public class TransferControllerApiTest extends RestApiTest {

    @Test
    public void getAccountTransferById_shouldReturnTransferDto_whenTransferFound() {

        long transferId = 1L;

        given()
                .when()
                .get(String.format("/account/transfers/%s", transferId))
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
                .body("data.status", equalTo(ACCEPTED))
                .body("data.balance_after", equalTo(100))
                .body("data.reference", equalTo("e2b70dba-e6b3-11e8-9f32-f2801f1b9fd1"))
                .body("data.created_at", equalTo("2018-07-01T00:00:00Z"));
    }

    @Test
    public void getAccountTransferById_shouldReturnNotFound_whenTransferNotFound() {


        given()
                .when()
                .get(String.format("/account/transfers/%s", Long.MAX_VALUE))
                .then()
                .assertThat()
                .statusCode(404)
                .contentType(ContentType.JSON)
                .body("status_code", equalTo(4000))
                .body("status_text", equalTo("Not found"))
                .body("data", nullValue());
    }

    @Test
    public void getAccountTransferById_shouldReturnClientError_whenTransferIdIsInvalid() {

        long transferId = -1L;

        given()
                .when()
                .get(String.format("/account/transfers/%s", transferId))
                .then()
                .assertThat()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .body("status_code", equalTo(4000))
                .body("status_text", equalTo("Invalid argument -1"))
                .body("data", nullValue());
    }

    @Test
    public void getAccountTransfers_shouldReturnListOfTransferDto() {

        given()
                .when()
                .get("/account/transfers")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("status_code", equalTo(2000))
                .body("status_text", equalTo("ok"))
                .body("data", notNullValue())

                .body("data[0].id", equalTo(1))
                .body("data[0].amount", equalTo(100))
                .body("data[0].currency", equalTo("EUR"))
                .body("data[0].status", equalTo(ACCEPTED))
                .body("data[0].balance_after", equalTo(100))
                .body("data[0].reference", equalTo("e2b70dba-e6b3-11e8-9f32-f2801f1b9fd1"))
                .body("data[0].created_at", equalTo("2018-07-01T00:00:00Z"))

                .body("data[1].id", equalTo(2))
                .body("data[1].amount", equalTo(-50))
                .body("data[1].currency", equalTo("EUR"))
                .body("data[1].status", equalTo(PENDING))
                .body("data[1].balance_after", equalTo(150))
                .body("data[1].reference", equalTo("e2b7104e-e6b3-11e8-9f32-f2801f1b9fd1"))
                .body("data[1].created_at", equalTo("2018-07-02T00:00:00Z"))

                .body("data[2].id", equalTo(3))
                .body("data[2].amount", equalTo(19))
                .body("data[2].currency", equalTo("EUR"))
                .body("data[2].status", equalTo(REJECTED))
                .body("data[2].balance_after", equalTo(169))
                .body("data[2].reference", equalTo("e2b711ac-e6b3-11e8-9f32-f2801f1b9fd1"))
                .body("data[2].created_at", equalTo("2018-07-03T00:00:00Z"));
    }
}
