package com.ignaciogg.eventstoredemo.domain.events;

import com.ignaciogg.eventstoredemo.domain.DomainEvent;

import java.util.UUID;

public class AccountCreated extends DomainEvent {

    private UUID accountId;

    public AccountCreated(UUID accountId) {
        super("account-created");
        this.accountId = accountId;
    }

    public UUID getAccountId() {
        return accountId;
    }
}
