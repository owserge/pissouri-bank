package com.pissouri.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping(value = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAccount() {

        return "This is my account";
    }
}
