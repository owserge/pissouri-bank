package com.pissouri.data;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class StaticAccountRepositoryUTest {

    private AccountRepository accountRepository;

    @Before
    public void setup() {

        accountRepository = new StaticAccountRepository();
    }

    @Test
    public void getAccount_shouldReturnOptionalOfAccount() {

        Optional<Account> accountOptional = accountRepository.getAccount();

        assertThat(accountOptional).isNotNull();
        assertThat(accountOptional).isNotEmpty();
        assertThat(accountOptional.isPresent()).isTrue();

        Account account = accountOptional.orElseThrow(AssertionError::new);

        assertThat(account).isNotNull();
        assertThat(account.getId()).isGreaterThan(0);
        assertThat(account.getNumber()).isNotNull();
        assertThat(account.getNumber()).isNotEmpty();
        assertThat(account.getCurrency()).isNotNull();
        assertThat(account.getCurrency().length()).isEqualTo(3);
        assertThat(account.getBalance()).isGreaterThanOrEqualTo(0);
        assertThat(account.getReference()).isNotNull();
        assertThat(account.getReference()).isNotEmpty();
        assertThat(account.getBankRoute()).satisfies(this::assertThatBankRouteIsValid);
        assertThat(account.getRegistration()).satisfies(this::assertThatRegistrationIsValid);
        assertThat(account.getCreatedAt()).isNotNull();
        assertThat(account.getUpdatedAt()).isNotNull();
    }

    private void assertThatBankRouteIsValid(BankRoute bankRoute) {

        assertThat(bankRoute).isNotNull();
        assertThat(bankRoute.getBic()).isNotNull();
        assertThat(bankRoute.getBic()).isNotEmpty();
        assertThat(bankRoute.getIban()).isNotNull();
        assertThat(bankRoute.getIban()).isNotEmpty();
        assertThat(bankRoute.getSwiftCode()).isNotNull();
        assertThat(bankRoute.getSwiftCode()).isNotEmpty();
        assertThat(bankRoute.getAccountNumber()).isNotNull();
        assertThat(bankRoute.getAccountNumber()).isNotEmpty();
        assertThat(bankRoute.getSortCode()).isNotNull();
        assertThat(bankRoute.getSortCode()).isNotEmpty();
        assertThat(bankRoute.getStreet()).isNotNull();
        assertThat(bankRoute.getStreet()).isNotEmpty();
        assertThat(bankRoute.getPostalCode()).isNotNull();
        assertThat(bankRoute.getPostalCode()).isNotEmpty();
        assertThat(bankRoute.getCity()).isNotNull();
        assertThat(bankRoute.getCity()).isNotEmpty();
        assertThat(bankRoute.getCountry()).isNotNull();
        assertThat(bankRoute.getCountry()).hasSize(2);
    }

    private void assertThatRegistrationIsValid(AccountRegistration registration) {

        assertThat(registration).isNotNull();

        assertThat(registration.getFirstName()).isNotNull();
        assertThat(registration.getFirstName()).isNotEmpty();
        assertThat(registration.getLastName()).isNotNull();
        assertThat(registration.getLastName()).isNotEmpty();
        assertThat(registration.getDateOfBirth()).isNotNull();
        assertThat(registration.getDateOfBirth()).isBeforeOrEqualTo(LocalDate.now().minusYears(18));
        assertThat(registration.getNationality()).isNotNull();
        assertThat(registration.getNationality()).isNotEmpty();
        assertThat(registration.getStreet()).isNotNull();
        assertThat(registration.getStreet()).isNotEmpty();
        assertThat(registration.getPostalCode()).isNotNull();
        assertThat(registration.getPostalCode()).isNotEmpty();
        assertThat(registration.getCity()).isNotNull();
        assertThat(registration.getCity()).isNotEmpty();
        assertThat(registration.getCountry()).isNotNull();
        assertThat(registration.getCountry()).hasSize(2);
    }
}
