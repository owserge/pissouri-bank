package com.pissouri.controller;

import com.pissouri.dto.AccountDto;
import com.pissouri.dto.ResponseDto;
import com.pissouri.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("WeakerAccess")
@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {

        this.accountService = accountService;
    }

    @GetMapping(value = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<AccountDto> getAccount() {

        return ResponseDto.ok(accountService.getAccount());
    }
}
