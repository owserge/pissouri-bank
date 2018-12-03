package com.pissouri.controller;

import com.pissouri.ApiTest;
import com.pissouri.RestApiTest;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@ApiTest
@RunWith(SpringRunner.class)
public class AccountControllerApiTest extends RestApiTest {

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
                .body("data.id", equalTo(1))
                .body("data.number", equalTo("PB100042"))
                .body("data.currency", equalTo("EUR"))
                .body("data.balance", equalTo(32750))
                .body("data.reference", equalTo("4d2e6b5b-e1db-4227-b117-c3644b4f31a6"))
                .body("data.registration.first_name", equalTo("John"))
                .body("data.registration.last_name", equalTo("Cash"))
                .body("data.registration.dob", equalTo("1985-10-25"))
                .body("data.registration.nationality", equalTo("GB"))
                .body("data.registration.address.street", equalTo("1 God Save the Queen Ave"))
                .body("data.registration.address.city", equalTo("London"))
                .body("data.registration.address.postal_code", equalTo("EC2700"))
                .body("data.registration.address.country", equalTo("UK"))
                .body("data.bank_route.full_name", equalTo("Cash, John"))
                .body("data.bank_route.iban", equalTo("PB63910000004543"))
                .body("data.bank_route.bic", equalTo("PBBE10080"))
                .body("data.bank_route.swift_code", equalTo("PB10080"))
                .body("data.bank_route.account_number", equalTo("90001050"))
                .body("data.bank_route.sort_code", equalTo("100090"))
                .body("data.bank_route.address.street", equalTo("1 King Ave"))
                .body("data.bank_route.address.city", equalTo("Paphos"))
                .body("data.bank_route.address.postal_code", equalTo("5200"))
                .body("data.bank_route.address.country", equalTo("CY"))
                .body("data.created_at", equalTo("2018-07-01T00:00:00+03:00"))
                .body("data.updated_at", equalTo("2018-07-01T00:00:00+03:00"));
    }
}
