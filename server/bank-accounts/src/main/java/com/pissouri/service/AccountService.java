package com.pissouri.service;

import com.pissouri.dto.AccountDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import static java.time.ZoneOffset.UTC;

@Service
public class AccountService {

    public AccountDto getAccount() {

        LocalDateTime firstOfJuly = LocalDateTime.of(2018, 7, 1, 0, 0);

        return new AccountDto()
                .setId(42L)
                .setNumber("PB100042")
                .setCurrency("EUR")
                .setBalance(32750L)
                .setReference("4d2e6b5b-e1db-4227-b117-c3644b4f31a6")
                .setCreatedAt(ZonedDateTime.of(firstOfJuly, UTC))
                .setUpdatedAt(ZonedDateTime.of(firstOfJuly, UTC));
    }
}
