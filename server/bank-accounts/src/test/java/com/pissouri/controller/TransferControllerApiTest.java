package com.pissouri.controller;

import com.pissouri.ApiTest;
import com.pissouri.RestApiTest;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static com.pissouri.JsonMatcher.equalToJson;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;

@ApiTest
@RunWith(SpringRunner.class)
public class TransferControllerApiTest extends RestApiTest {

    @Test
    public void getAccountTransferById_shouldReturnTransferDto_whenTransferFound() {

        long transferId = 1L;

        String expectedResponseBody = readFromClasspath("getAccountTransferById_whenTransferFound.json");

        given()
                .when()
                .get(String.format("/account/transfers/%s", transferId))
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(equalToJson(expectedResponseBody));
    }

    @Test
    public void getAccountTransfers_shouldReturnListOfTransferDto_whenTransfersFound() {

        String expectedResponseBody = readFromClasspath("getAccountTransfers_whenTransfersFound.json");

        given()
                .when()
                .get("/account/transfers")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(equalToJson(expectedResponseBody));
    }

    @Test
    public void getAccountTransfers_shouldReturnPartOfListOfTransferDto_whenSizeParameterIsProvided() {

        String expectedResponseBody = readFromClasspath("getAccountTransfers_whenPageParameterIsProvided.json");

        given()
                .when()
                .get("/account/transfers?size=5")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(equalToJson(expectedResponseBody));
    }

    @Test
    public void getAccountTransfers_shouldReturnClientError_whenSizeParameterIsEqualToZero() {

        given()
                .when()
                .get("/account/transfers?size=0")
                .then()
                .assertThat()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .body("status_code", equalTo(4000))
                .body("status_text", equalTo("Page size must not be less than one!"))
                .body("data", nullValue());
    }

    @Test
    public void getAccountTransfers_shouldReturnDefaultListOfTransferDto_whenSizeParameterIsLessThanZero() {

        given()
                .when()
                .get("/account/transfers?size=-5")
                .then()
                .assertThat()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .body("status_code", equalTo(4000))
                .body("status_text", equalTo("Page size must not be less than one!"))
                .body("data", nullValue());
    }

    @Test
    public void getAccountTransfers_shouldReturnPartOfListOfTransferDto_whenPageAndSizeParametersProvided() {

        String expectedResponseBody = readFromClasspath("getAccountTransfers_whenPageAndSizeParametersProvided.json");

        given()
                .when()
                .get("/account/transfers?page=1&size=5")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(equalToJson(expectedResponseBody));
    }

    @Test
    public void getAccountTransfers_shouldReturnClientError_whenPageParameterIsLessThanZero() {

        given()
                .when()
                .get("/account/transfers?page=-5")
                .then()
                .assertThat()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .body("status_code", equalTo(4000))
                .body("status_text", equalTo("Page index must not be less than zero!"))
                .body("data", nullValue());
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
}
