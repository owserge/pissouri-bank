package com.pissouri.service;

import com.pissouri.dto.AccountDto;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.UUID;

import static java.time.ZoneOffset.UTC;

@Service
public class AccountService {

    public AccountDto getAccount() {

        return new AccountDto()
                .setId(42L)
                .setNumber("PB100042")
                .setCurrency("EUR")
                .setBalance(32750L)
                .setReference(UUID.randomUUID().toString())
                .setCreatedAt(ZonedDateTime.now(UTC))
                .setUpdatedAt(ZonedDateTime.now(UTC));
    }
}
