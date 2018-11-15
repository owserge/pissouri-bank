package com.pissouri.data;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Optional;

import static java.time.ZoneOffset.UTC;

@Repository
public class StaticAccountRepository implements AccountRepository {

    private static final ZonedDateTime FIRST_OF_JULY = ZonedDateTime.of(2018, 7, 1, 0, 0, 0, 0, UTC);

    @Override
    public Optional<Account> getAccount() {

        AccountRegistration registration = new AccountRegistration()
                .setId(42L)
                .setAccountId(42L)
                .setFirstName("John")
                .setLastName("Cash")
                .setDateOfBirth(LocalDate.of(1985, 10, 25))
                .setNationality("British")
                .setStreet("1 God Save the Queen Str")
                .setCity("London")
                .setPostalCode("EC2700")
                .setCountry("UK")
                .setCreatedAt(FIRST_OF_JULY)
                .setUpdatedAt(FIRST_OF_JULY);

        BankRoute bankRoute = new BankRoute()
                .setId(42L)
                .setAccountId(42L)
                .setIban("PB63910000004543")
                .setBic("PBBE10080")
                .setSwiftCode("PB10080")
                .setAccountNumber("90001050")
                .setSortCode("100090")
                .setStreet("1 King Ave")
                .setCity("Paphos")
                .setPostalCode("5200")
                .setCountry("CY")
                .setCreatedAt(FIRST_OF_JULY)
                .setUpdatedAt(FIRST_OF_JULY);

        return Optional.of(new Account()
                .setId(42L)
                .setNumber("PB100042")
                .setCurrency("EUR")
                .setBalance(32750L)
                .setReference("4d2e6b5b-e1db-4227-b117-c3644b4f31a6")
                .setBankRoute(bankRoute)
                .setRegistration(registration)
                .setCreatedAt(FIRST_OF_JULY)
                .setUpdatedAt(FIRST_OF_JULY));
    }
}
