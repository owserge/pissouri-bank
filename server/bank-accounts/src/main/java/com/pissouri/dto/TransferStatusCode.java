package com.pissouri.dto;

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
}