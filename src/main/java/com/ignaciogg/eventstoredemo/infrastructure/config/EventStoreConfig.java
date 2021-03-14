package com.ignaciogg.eventstoredemo.infrastructure.config;

import com.eventstore.dbclient.EventStoreDBClient;
import com.eventstore.dbclient.EventStoreDBClientSettings;
import com.eventstore.dbclient.EventStoreDBConnectionString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventStoreConfig {

    @Value("${event.store.connection.string}")
    private String connectionString;

    @Bean
    public EventStoreDBClient eventStoreClient() {
        EventStoreDBClientSettings setts = EventStoreDBConnectionString.parseOrThrow("esdb://localhost:2113?tls=false");
        return EventStoreDBClient.create(setts);
    }
}
