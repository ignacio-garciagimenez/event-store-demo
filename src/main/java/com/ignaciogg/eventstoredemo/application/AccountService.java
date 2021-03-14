package com.ignaciogg.eventstoredemo.application;

import com.eventstore.dbclient.AppendToStreamOptions;
import com.eventstore.dbclient.EventData;
import com.eventstore.dbclient.EventStoreDBClient;
import com.eventstore.dbclient.ExpectedRevision;
import com.ignaciogg.eventstoredemo.domain.Account;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class AccountService {

    private final EventStoreDBClient dbClient;

    public AccountService(EventStoreDBClient dbClient) {
        this.dbClient = dbClient;
    }

    public UUID createAccount() {
        Account newAccount = new Account();

        newAccount.getDomainEvents().forEach(domainEvent -> {
            EventData event = EventData.builderAsJson(domainEvent.getEventId(), domainEvent.getEventType(), domainEvent).build();
            AppendToStreamOptions options = AppendToStreamOptions.get()
                    .expectedRevision(ExpectedRevision.ANY);
            try {
                dbClient.appendToStream("accounts", options, event).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        return newAccount.getAccountId();
    }
}
