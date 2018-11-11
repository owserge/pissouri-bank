package com.pissouri.controller;

import com.pissouri.dto.AccountDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

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

        AccountDto accountDto = given()
                .when()
                .get("/account")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("statusCode", equalTo(2000))
                .body("statusText", equalTo("ok"))
                .extract().body().jsonPath().getObject("data", AccountDto.class);

        assertThat(accountDto).isNotNull();
        assertThat(accountDto.getId()).isGreaterThan(0);
        assertThat(accountDto.getNumber()).isNotNull();
        assertThat(accountDto.getNumber()).isNotEmpty();
        assertThat(accountDto.getCurrency()).isNotNull();
        assertThat(accountDto.getCurrency().length()).isEqualTo(3);
        assertThat(accountDto.getBalance()).isGreaterThanOrEqualTo(0);
        assertThat(accountDto.getReference()).isNotNull();
        assertThat(accountDto.getReference()).isNotEmpty();
        assertThat(accountDto.getCreatedAt()).isNotNull();
        assertThat(accountDto.getUpdatedAt()).isNotNull();
    }
}
