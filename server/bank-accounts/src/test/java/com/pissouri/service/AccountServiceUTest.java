package com.pissouri.service;

import com.pissouri.TypeConversions;
import com.pissouri.converter.AccountDtoConverter;
import com.pissouri.data.Account;
import com.pissouri.data.AccountRegistration;
import com.pissouri.data.AccountRepository;
import com.pissouri.data.BankRoute;
import com.pissouri.dto.AccountDto;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.convert.ConversionService;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Optional;

import static java.time.ZoneOffset.UTC;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountServiceUTest {

    private AccountRepository accountRepository;
    private AccountService accountService;

    @Before
    public void setup() {

        accountRepository = mock(AccountRepository.class);
        ConversionService conversionService = TypeConversions.serviceOf(new AccountDtoConverter());
        accountService = new AccountService(accountRepository, conversionService);
    }

    @Test
    public void getAccount_shouldReturnAccountDto() {

        givenAccount();

        AccountDto accountDto = accountService.getAccount(42L);

        assertThat(accountDto).isNotNull();
        assertThat(accountDto.getId()).isEqualTo(42L);
        assertThat(accountDto.getNumber()).isEqualTo("PB100042");
        assertThat(accountDto.getCurrency()).isEqualTo("EUR");
        assertThat(accountDto.getBalance()).isEqualTo(32750L);
        assertThat(accountDto.getReference()).isEqualTo("4d2e6b5b-e1db-4227-b117-c3644b4f31a6");

        assertThat(accountDto.getRegistration()).isNotNull();
        assertThat(accountDto.getRegistration().getFirstName()).isEqualTo("John");
        assertThat(accountDto.getRegistration().getLastName()).isEqualTo("Cash");
        assertThat(accountDto.getRegistration().getDateOfBirth()).isEqualTo("1985-10-25");
        assertThat(accountDto.getRegistration().getNationality()).isEqualTo("GB");
        assertThat(accountDto.getRegistration().getAddress()).isNotNull();
        assertThat(accountDto.getRegistration().getAddress().getStreet()).isEqualTo("1 God Save the Queen Str");
        assertThat(accountDto.getRegistration().getAddress().getCity()).isEqualTo("London");
        assertThat(accountDto.getRegistration().getAddress().getPostalCode()).isEqualTo("EC2700");
        assertThat(accountDto.getRegistration().getAddress().getCountry()).isEqualTo("UK");

        assertThat(accountDto.getBankRoute()).isNotNull();
        assertThat(accountDto.getBankRoute().getFullName()).isEqualTo("Cash, John");
        assertThat(accountDto.getBankRoute().getIban()).isEqualTo("PB63910000004543");
        assertThat(accountDto.getBankRoute().getBic()).isEqualTo("PBBE10080");
        assertThat(accountDto.getBankRoute().getSwiftCode()).isEqualTo("PB10080");
        assertThat(accountDto.getBankRoute().getAccountNumber()).isEqualTo("90001050");
        assertThat(accountDto.getBankRoute().getSortCode()).isEqualTo("100090");
        assertThat(accountDto.getBankRoute().getAddress()).isNotNull();
        assertThat(accountDto.getBankRoute().getAddress().getStreet()).isEqualTo("1 King Ave");
        assertThat(accountDto.getBankRoute().getAddress().getCity()).isEqualTo("Paphos");
        assertThat(accountDto.getBankRoute().getAddress().getPostalCode()).isEqualTo("5200");
        assertThat(accountDto.getBankRoute().getAddress().getCountry()).isEqualTo("CY");

        assertThat(accountDto.getCreatedAt()).isEqualTo(LocalDate.ofYearDay(2018, 1).atStartOfDay(UTC));
        assertThat(accountDto.getUpdatedAt()).isEqualTo(LocalDate.ofYearDay(2018, 1).atStartOfDay(UTC));
    }

    private void givenAccount() {

        AccountRegistration registration = new AccountRegistration()
                .setId(42L)
                .setFirstName("John")
                .setLastName("Cash")
                .setDateOfBirth(LocalDate.of(1985, 10, 25))
                .setNationality("GB")
                .setStreet("1 God Save the Queen Str")
                .setCity("London")
                .setPostalCode("EC2700")
                .setCountry("UK")
                .setCreatedAt(ZonedDateTime.now(UTC))
                .setUpdatedAt(ZonedDateTime.now(UTC));

        BankRoute bankRoute = new BankRoute()
                .setId(42L)
                .setIban("PB63910000004543")
                .setBic("PBBE10080")
                .setSwiftCode("PB10080")
                .setAccountNumber("90001050")
                .setSortCode("100090")
                .setStreet("1 King Ave")
                .setCity("Paphos")
                .setPostalCode("5200")
                .setCountry("CY")
                .setCreatedAt(ZonedDateTime.now(UTC))
                .setUpdatedAt(ZonedDateTime.now(UTC));

        when(accountRepository.findByIdAndIsActiveTrue(anyLong())).thenReturn(Optional.of(new Account()
                .setId(42L)
                .setNumber("PB100042")
                .setCurrency("EUR")
                .setBalance(32750L)
                .setReference("4d2e6b5b-e1db-4227-b117-c3644b4f31a6")
                .setBankRoute(bankRoute)
                .setRegistration(registration)
                .setActive(true)
                .setCreatedAt(LocalDate.ofYearDay(2018, 1).atStartOfDay(UTC))
                .setUpdatedAt(LocalDate.ofYearDay(2018, 1).atStartOfDay(UTC))));
    }
}
