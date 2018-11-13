package com.pissouri.controller;

import com.pissouri.ApiTest;
import com.pissouri.service.AccountService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.mockito.Mockito.when;

@ApiTest
@RunWith(SpringRunner.class)
public class ErrorAdviceApiTest {

    @MockBean
    private AccountService accountService;

    @LocalServerPort
    private int serverPort;

    @Before
    public void setup() {

        RestAssured.port = serverPort;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void shouldReturnInternalServerErrorWithResponseDto_whenUnhandledExceptionThrown() {

        when(accountService.getAccount()).thenThrow(new RuntimeException("Ah shit"));

        given()
                .when()
                .get("/account")
                .then()
                .assertThat()
                .statusCode(500)
                .contentType(ContentType.JSON)
                .body("status_code", equalTo(5000))
                .body("status_text", equalTo("Kaboom"))
                .body("data", nullValue());
    }
}
