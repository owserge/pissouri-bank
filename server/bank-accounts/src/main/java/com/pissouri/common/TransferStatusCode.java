package com.pissouri.common;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

public final class TransferStatusCode {

    /**
     * The transfer is pending review from a bank operator
     */
    public static final String PENDING = "PENDING";

    /**
     * The transfer has been reviewed, approved, and has been accepted
     */
    public static final String ACCEPTED = "ACCEPTED";

    /**
     * There was an issue with the transfer, it has been rejected and the funds have been returned
     */
    public static final String REJECTED = "REJECTED";

    /**
     * Set of all transfer status code definitions
     */
    private static final Set<String> ALL = new HashSet<>(asList(PENDING, ACCEPTED, REJECTED));

    /**
     * @return True if the value is contained in the list of defined transfer status codes, false if otherwise
     */
    public static boolean valid(String status) {

        return status != null && ALL.contains(status);
    }
}