package com.pissouri;

import io.restassured.RestAssured;
import org.junit.Before;
import org.springframework.boot.web.server.LocalServerPort;

/**
 * API testing base class, with some common configuration for HTTP-based API testing
 * Subclasses would be test fixtures initialising a web environment, i.e. {@link ApiTest} fixtures
 */
abstract public class RestApiTest {

    @LocalServerPort
    protected int serverPort;

    @Before
    public void setup() {

        RestAssured.port = serverPort;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    /**
     * Read the contents of a resource file that should exist on the class path
     * @param fileName The name of the file
     * @return The contents of the file, null if file is empty
     */
    protected String readFromClasspath(String fileName) {

        return Resources.getResourceAsString(fileName, getClass());
    }
}
