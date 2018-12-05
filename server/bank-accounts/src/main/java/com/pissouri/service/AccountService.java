package com.pissouri.service;

import com.pissouri.data.AccountRepository;
import com.pissouri.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final ConversionService conversionService;

    @Autowired
    public AccountService(AccountRepository accountRepository, ConversionService conversionService) {

        this.accountRepository = accountRepository;
        this.conversionService = conversionService;
    }

    public AccountDto getAccount(long id) {

        return accountRepository
                .findByIdAndIsActiveTrue(id)
                .map(account -> conversionService.convert(account, AccountDto.class))
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));
    }
}
