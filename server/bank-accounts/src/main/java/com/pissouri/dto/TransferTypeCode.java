package com.pissouri.dto;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

/**
 * Bank transfer types currently supported by the system
 */
public final class TransferTypeCode {

    /**
     * Incoming transfers, i.e. transfer is funds received
     */
    public static final String INCOMING = "IN";

    /**
     * Outgoing transfers, i.e. transfer is funds sent out
     */
    public static final String OUTGOING = "OUT";

    /**
     * Set of all transfer type code definitions
     */
    private static final Set<String> ALL = new HashSet<>(asList(INCOMING, OUTGOING));

    /**
     * @return True if the value is contained in the list of defined transfer type codes, false if otherwise
     */
    public static boolean valid(String status) {

        return status != null && ALL.contains(status);
    }
}
