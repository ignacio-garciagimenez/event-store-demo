package com.ignaciogg.eventstoredemo.domain;

import java.util.UUID;

public abstract class DomainEvent {

    private final UUID eventId;
    private final String eventType;

    protected DomainEvent(String eventType) {
        this.eventId = UUID.randomUUID();
        this.eventType = eventType;
    }

    public UUID getEventId() {
        return this.eventId;
    }
    public String getEventType() {
        return this.eventType;
    }
}
