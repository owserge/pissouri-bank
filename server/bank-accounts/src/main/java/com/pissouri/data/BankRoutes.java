package com.pissouri.data;

import java.time.ZonedDateTime;

import static java.time.ZoneOffset.UTC;
import static org.apache.commons.lang3.RandomUtils.nextInt;

/**
 * Static utility methods for {@link BankRoute}
 */
public final class BankRoutes {

    /**
     * @return A {@link BankRoute} populated with sane and reasonable random information
     */
    static BankRoute random() {

        long randomId = nextInt(10, 1000);
        ZonedDateTime createdAt = ZonedDateTime.now(UTC).minusHours(randomId);

        return new BankRoute()
                .setId(randomId)
                .setBic(randomBic())
                .setFullName("McDonalds Paphos")
                .setIban(randomIban())
                .setSwiftCode(randomSwiftCode())
                .setAccountNumber(randomAccountNumber())
                .setSortCode(randomSortCode())
                .setStreet("1 King Ave")
                .setCity("Paphos")
                .setPostalCode("5200")
                .setCountry("CY")
                .setCreatedAt(createdAt)
                .setUpdatedAt(createdAt);
    }

    private static String randomBic() {

        return String.format("PBBE%d", nextInt(1000, 9999));
    }

    private static String randomIban() {

        return String.format("PB%d0000%d", nextInt(100000, 999999), nextInt(1000, 9999));
    }

    private static String randomSwiftCode() {

        return String.format("PB%d", nextInt(10000, 99999));
    }

    private static String randomAccountNumber() {

        return String.format("9000%d", nextInt(1000, 9999));
    }

    private static String randomSortCode() {

        return String.format("100%d", nextInt(100, 999));
    }
}
