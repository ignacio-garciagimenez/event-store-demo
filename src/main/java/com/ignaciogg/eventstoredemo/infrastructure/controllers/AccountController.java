package com.ignaciogg.eventstoredemo.infrastructure.controllers;

import com.ignaciogg.eventstoredemo.application.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public ResponseEntity<UUID> createAccount() {
        return new ResponseEntity<>(accountService.createAccount(), HttpStatus.CREATED);
    }
}
