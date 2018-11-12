package com.pissouri.dto;

/**
 * Definitive list of API status codes
 */
final class ResponseStatusCode {

    /**
     * Success, all is good
     */
    static final int OK = 2000;

    /**
     * Client error, e.g. params invalid
     */
    static final int CLIENT_ERROR = 4000;

    /**
     * Server error, something went wrong
     */
    static final int SERVER_ERROR = 5000;
}
