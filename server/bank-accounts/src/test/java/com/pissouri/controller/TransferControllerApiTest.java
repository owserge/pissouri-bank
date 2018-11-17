package com.pissouri.controller;

import com.pissouri.ApiTest;
import com.pissouri.RestApiTest;
import com.pissouri.data.BankRoute;
import com.pissouri.data.Transfer;
import com.pissouri.data.TransferRepository;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Optional;

import static com.pissouri.dto.TransferStatusCode.*;
import static io.restassured.RestAssured.given;
import static java.time.ZoneOffset.UTC;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ApiTest
@RunWith(SpringRunner.class)
public class TransferControllerApiTest extends RestApiTest {

    @MockBean
    private TransferRepository transferRepository;

    @Test
    public void getAccountTransferById_shouldReturnTransferDto_whenTransferFound() {

        long transferId = 1L;

        givenTransferExists(transferId);

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
                .body("data.created_at", equalTo("2018-07-01T00:00:00Z"))
                .body("data.originator", notNullValue())
                .body("data.originator.bic", equalTo("PBBE10080"))
                .body("data.originator.iban", equalTo("PB63910000004543"))
                .body("data.originator.swift_code", equalTo("PB10080"))
                .body("data.originator.account_number", equalTo("90001050"))
                .body("data.originator.sort_code", equalTo("10090"))
                .body("data.originator.address", notNullValue())
                .body("data.originator.address.street", equalTo("1 Pissouri Ave"))
                .body("data.originator.address.city", equalTo("Paphos"))
                .body("data.originator.address.postal_code", equalTo("5200"))
                .body("data.originator.address.country", equalTo("CY"));
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

        givenTransfersExist();

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
                .body("data[0].balance_after", equalTo(1000))
                .body("data[0].reference", equalTo("e2b70dba-e6b3-11e8-9f32-f2801f1b9fd1"))
                .body("data[0].created_at", equalTo("2018-07-01T00:00:00Z"))
                .body("data[0].beneficiary", nullValue())
                .body("data[0].originator", notNullValue())
                .body("data[0].originator.bic", equalTo("PBBE10080"))
                .body("data[0].originator.iban", equalTo("PB63910000004543"))
                .body("data[0].originator.swift_code", equalTo("PB10080"))
                .body("data[0].originator.account_number", equalTo("90001050"))
                .body("data[0].originator.sort_code", equalTo("10090"))
                .body("data[0].originator.address", notNullValue())
                .body("data[0].originator.address.street", equalTo("1 Pissouri Ave"))
                .body("data[0].originator.address.city", equalTo("Paphos"))
                .body("data[0].originator.address.postal_code", equalTo("5200"))
                .body("data[0].originator.address.country", equalTo("CY"))

                .body("data[1].id", equalTo(2))
                .body("data[1].amount", equalTo(-100))
                .body("data[1].currency", equalTo("GBP"))
                .body("data[1].status", equalTo(PENDING))
                .body("data[1].balance_after", equalTo(900))
                .body("data[1].reference", equalTo("1189aca5-e628-4be6-82b7-d12b37e437d0"))
                .body("data[1].created_at", equalTo("2018-07-02T00:00:00Z"))
                .body("data[1].originator", nullValue())
                .body("data[1].beneficiary", notNullValue())
                .body("data[1].beneficiary.bic", equalTo("NVBE10234"))
                .body("data[1].beneficiary.iban", equalTo("NV63910000005871"))
                .body("data[1].beneficiary.swift_code", equalTo("NV10918"))
                .body("data[1].beneficiary.account_number", equalTo("90001255"))
                .body("data[1].beneficiary.sort_code", equalTo("10013"))
                .body("data[1].beneficiary.address", notNullValue())
                .body("data[1].beneficiary.address.street", equalTo("1 God Save the Queen St"))
                .body("data[1].beneficiary.address.city", equalTo("London"))
                .body("data[1].beneficiary.address.postal_code", equalTo("E7500"))
                .body("data[1].beneficiary.address.country", equalTo("UK"));
    }

    private void givenTransferExists(long transferId) {

        when(transferRepository.getTransferById(eq(transferId)))
                .thenReturn(Optional.of(new Transfer()
                        .setId(transferId)
                        .setAmount(100)
                        .setCurrency("EUR")
                        .setStatus(ACCEPTED)
                        .setBalanceAfter(100)
                        .setReference("e2b70dba-e6b3-11e8-9f32-f2801f1b9fd1")
                        .setCreatedAt(ZonedDateTime.of(2018, 7, 1, 0, 0, 0, 0, UTC))
                        .setOriginator(new BankRoute()
                            .setId(transferId)
                            .setBic("PBBE10080")
                            .setIban("PB63910000004543")
                            .setSwiftCode("PB10080")
                            .setAccountNumber("90001050")
                            .setSortCode("10090")
                            .setStreet("1 Pissouri Ave")
                            .setCity("Paphos")
                            .setPostalCode("5200")
                            .setCountry("CY"))));
    }

    private void givenTransfersExist() {

        when(transferRepository.getTransfers()).thenReturn(Arrays.asList(
                new Transfer()
                        .setId(1L)
                        .setAmount(100)
                        .setCurrency("EUR")
                        .setStatus(ACCEPTED)
                        .setBalanceAfter(1000)
                        .setReference("e2b70dba-e6b3-11e8-9f32-f2801f1b9fd1")
                        .setCreatedAt(ZonedDateTime.of(2018, 7, 1, 0, 0, 0, 0, UTC))
                        .setOriginator(new BankRoute()
                                .setId(1L)
                                .setBic("PBBE10080")
                                .setIban("PB63910000004543")
                                .setSwiftCode("PB10080")
                                .setAccountNumber("90001050")
                                .setSortCode("10090")
                                .setStreet("1 Pissouri Ave")
                                .setCity("Paphos")
                                .setPostalCode("5200")
                                .setCountry("CY")),

                new Transfer()
                        .setId(2L)
                        .setAmount(-100)
                        .setCurrency("GBP")
                        .setStatus(PENDING)
                        .setBalanceAfter(900)
                        .setReference("1189aca5-e628-4be6-82b7-d12b37e437d0")
                        .setCreatedAt(ZonedDateTime.of(2018, 7, 2, 0, 0, 0, 0, UTC))
                        .setBeneficiary(new BankRoute()
                                .setId(2L)
                                .setBic("NVBE10234")
                                .setIban("NV63910000005871")
                                .setSwiftCode("NV10918")
                                .setAccountNumber("90001255")
                                .setSortCode("10013")
                                .setStreet("1 God Save the Queen St")
                                .setCity("London")
                                .setPostalCode("E7500")
                                .setCountry("UK"))
              ));
    }
}
