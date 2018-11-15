package com.pissouri.common;

import java.util.Collections;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

/**
 * Common static utility methods for {@link Currency}
 */
public final class Currencies {

    public static final Currency EUR = Currency.getInstance("EUR"); // Euro
    public static final Currency GBP = Currency.getInstance("GBP"); // British Pound
    public static final Currency AUD = Currency.getInstance("AUD"); // Australian Dollar
    public static final Currency USD = Currency.getInstance("USD"); // United States Dollar

    private static final Set<Currency> AVAILABLE = new HashSet<>(asList(EUR, GBP, AUD, USD));

    /**
     * @return Set of application-supported {@link Currency} definitions
     */
    public static Set<Currency> available() {

        return Collections.unmodifiableSet(AVAILABLE);
    }
}
