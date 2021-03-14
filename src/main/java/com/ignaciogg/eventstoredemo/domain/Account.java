package com.ignaciogg.eventstoredemo.domain;


import com.ignaciogg.eventstoredemo.domain.events.AccountCreated;

import java.util.UUID;

public class Account extends Entity{

    private final UUID id;
    private double amount;
    private String currency;

    public Account() {
        this.id = UUID.randomUUID();
        this.amount = 0;
        this.currency = "USD";
        this.addDomainEvent(new AccountCreated(this.id));
    }

    public UUID getAccountId() {
        return id;
    }


}
