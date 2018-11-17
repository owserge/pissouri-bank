package com.pissouri.data;

import java.time.ZonedDateTime;
import java.util.Currency;
import java.util.UUID;

import static com.pissouri.common.Currencies.*;
import static com.pissouri.dto.TransferStatusCode.ACCEPTED;
import static com.pissouri.dto.TransferStatusCode.PENDING;
import static com.pissouri.dto.TransferStatusCode.REJECTED;
import static java.time.ZoneOffset.UTC;
import static org.apache.commons.lang3.RandomUtils.nextBoolean;
import static org.apache.commons.lang3.RandomUtils.nextInt;
import static org.apache.commons.lang3.RandomUtils.nextLong;

/**
 * Static utility methods for {@link Transfer}
 */
public final class Transfers {

    /**
     * @return A {@link Transfer} populated with sane and reasonable random information
     */
    static Transfer random() {

        return random(nextInt(10, 100_000));
    }

    /**
     * A {@link Transfer} with a record id provided and populated with random information
     * @param id The id for this random {@link Transfer} record
     * @return A {@link Transfer} populated with sane and reasonable random information
     */
    static Transfer random(long id) {

        ZonedDateTime createdAt = ZonedDateTime.now(UTC).minusHours(id);

        Transfer transfer = new Transfer()
                .setId(id)
                .setAmount(randomAmount())
                .setCurrency(randomCurrency())
                .setStatus(randomStatus())
                .setBalanceAfter(randomBalance())
                .setReference(randomReference())
                .setCreatedAt(createdAt);

        BankRoute randomBankRoute = BankRoutes.random();

        if (transfer.getAmount() < 0) transfer.setBeneficiary(randomBankRoute);
        else transfer.setOriginator(randomBankRoute);

        return transfer;
    }

    private static long randomAmount() {

        long random = nextLong(100L, 10_000L);
        boolean positive = nextBoolean();

        return positive ? random : random * -1;
    }

    private static String randomCurrency() {

        Currency currency = EUR;

        int random = nextInt();
        if (random % 3 == 0) currency = GBP;
        if (random % 5 == 0) currency = USD;
        if (random % 7 == 0) currency = AUD;

        return currency.getCurrencyCode();
    }

    private static String randomStatus() {

        String status = ACCEPTED;

        int random = nextInt();
        if (random % 3 == 0) status = PENDING;
        if (random % 5 == 0) status = REJECTED;

        return status;
    }

    private static long randomBalance() {

        return nextLong(100L, 10_000L);
    }

    private static String randomReference() {

        return UUID.randomUUID().toString();
    }
}
