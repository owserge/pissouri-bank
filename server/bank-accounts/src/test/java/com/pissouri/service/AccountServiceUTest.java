package com.pissouri.service;

import com.pissouri.data.StaticAccountRepository;
import com.pissouri.dto.AccountDto;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountServiceUTest {

    private AccountService accountService;

    @Before
    public void setup() {

        accountService = new AccountService(new StaticAccountRepository());
    }

    @Test
    public void getAccount_shouldReturnAccountDto() {

        AccountDto accountDto = accountService.getAccount();

        assertThat(accountDto).isNotNull();
        assertThat(accountDto.getId()).isGreaterThan(0);
        assertThat(accountDto.getNumber()).isNotNull();
        assertThat(accountDto.getNumber()).isNotEmpty();
        assertThat(accountDto.getCurrency()).isNotNull();
        assertThat(accountDto.getCurrency().length()).isEqualTo(3);
        assertThat(accountDto.getBalance()).isGreaterThanOrEqualTo(0);
        assertThat(accountDto.getReference()).isNotNull();
        assertThat(accountDto.getReference()).isNotEmpty();
        assertThat(accountDto.getCreatedAt()).isNotNull();
        assertThat(accountDto.getUpdatedAt()).isNotNull();
    }
}
