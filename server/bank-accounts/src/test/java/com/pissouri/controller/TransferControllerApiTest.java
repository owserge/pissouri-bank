package com.pissouri.controller;

import com.pissouri.ApiTest;
import com.pissouri.RestApiTest;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static com.pissouri.dto.TransferStatusCode.ACCEPTED;
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
                .body("data.id", equalTo(1))
                .body("data.amount", equalTo(-2750))
                .body("data.currency", equalTo("EUR"))
                .body("data.status", equalTo(ACCEPTED))
                .body("data.balance_after", equalTo(18500))
                .body("data.reference", equalTo("eec6671b-c0d4-4833-9779-f4cbdb117eb7"))
                .body("data.created_at", equalTo("2018-07-01T00:00:00+03:00"))
                .body("data.originator", nullValue())
                .body("data.beneficiary", notNullValue())
                .body("data.beneficiary.full_name", equalTo("TERRA NOVA Ltd"))
                .body("data.beneficiary.bic", equalTo("CYBE17580"))
                .body("data.beneficiary.iban", equalTo("CY75910000004587"))
                .body("data.beneficiary.swift_code", nullValue())
                .body("data.beneficiary.account_number", nullValue())
                .body("data.beneficiary.sort_code", nullValue())
                .body("data.beneficiary.address", notNullValue())
                .body("data.beneficiary.address.street", equalTo("5 MAKARIOU Ave"))
                .body("data.beneficiary.address.city", equalTo("Nicosia"))
                .body("data.beneficiary.address.state", nullValue())
                .body("data.beneficiary.address.postal_code", equalTo("2200"))
                .body("data.beneficiary.address.country", equalTo("CY"));
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
                .body("data[0].amount", equalTo(-2750))
                .body("data[0].currency", equalTo("EUR"))
                .body("data[0].status", equalTo(ACCEPTED))
                .body("data[0].balance_after", equalTo(18500))
                .body("data[0].reference", equalTo("eec6671b-c0d4-4833-9779-f4cbdb117eb7"))
                .body("data[0].created_at", equalTo("2018-07-01T00:00:00+03:00"))
                .body("data[0].originator", nullValue())
                .body("data[0].beneficiary", notNullValue())
                .body("data[0].beneficiary.full_name", equalTo("TERRA NOVA Ltd"))
                .body("data[0].beneficiary.bic", equalTo("CYBE17580"))
                .body("data[0].beneficiary.iban", equalTo("CY75910000004587"))
                .body("data[0].beneficiary.swift_code", nullValue())
                .body("data[0].beneficiary.account_number", nullValue())
                .body("data[0].beneficiary.sort_code", nullValue())
                .body("data[0].beneficiary.address", notNullValue())
                .body("data[0].beneficiary.address.street", equalTo("5 MAKARIOU Ave"))
                .body("data[0].beneficiary.address.city", equalTo("Nicosia"))
                .body("data[0].beneficiary.address.state", nullValue())
                .body("data[0].beneficiary.address.postal_code", equalTo("2200"))
                .body("data[0].beneficiary.address.country", equalTo("CY"));
    }
}
