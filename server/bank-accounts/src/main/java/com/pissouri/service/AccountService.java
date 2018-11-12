package com.pissouri.service;

import com.pissouri.dto.AccountDto;
import com.pissouri.dto.AddressDto;
import com.pissouri.dto.BankRouteDto;
import com.pissouri.dto.RegistrationDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import static java.time.ZoneOffset.UTC;

@Service
public class AccountService {

    public AccountDto getAccount() {

        ZonedDateTime firstOfJuly = ZonedDateTime.of(LocalDateTime.of(2018, 7, 1, 0, 0), UTC);

        RegistrationDto registrationDto = new RegistrationDto()
                .setFirstName("John")
                .setLastName("Cash")
                .setDateOfBirth("1985-10-25")
                .setNationality("British")
                .setAddress(new AddressDto()
                        .setStreet("1 God Save the Queen Str")
                        .setCity("London")
                        .setPostalCode("EC2700")
                        .setCountry("UK"));

        BankRouteDto bankRouteDto = new BankRouteDto()
                .setIban("PB63910000004543")
                .setBic("PBBE10080")
                .setSwiftCode("PB10080")
                .setAccountNumber("90001050")
                .setSortCode("100090")
                .setAddress(new AddressDto()
                        .setStreet("1 King Ave")
                        .setCity("Paphos")
                        .setPostalCode("5200")
                        .setCountry("CY"));

        return new AccountDto()
                .setId(42L)
                .setNumber("PB100042")
                .setCurrency("EUR")
                .setBalance(32750L)
                .setReference("4d2e6b5b-e1db-4227-b117-c3644b4f31a6")
                .setRegistration(registrationDto)
                .setBankRoute(bankRouteDto)
                .setCreatedAt(firstOfJuly)
                .setUpdatedAt(firstOfJuly);
    }
}
