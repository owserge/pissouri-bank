package com.pissouri.dto;

/**
 * Definitive list of API status codes
 */
public final class ResponseStatusCode {

    /**
     * Success, all is good
     */
    public static final int OK = 2000;

    /**
     * Client error, e.g. params invalid
     */
    public static final int CLIENT_ERROR = 4000;

    /**
     * Server error, something went wrong
     */
    public static final int SERVER_ERROR = 5000;
}
