package com.ignaciogg.eventstoredemo.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Entity {

    private final List<DomainEvent> domainEvents = new ArrayList<>();

    protected void addDomainEvent(DomainEvent event) {
        domainEvents.add(event);
    }

    protected void removeDomainEvent(DomainEvent event) {
        domainEvents.remove(event);
    }

    protected void clearDomainEvents() {
        domainEvents.clear();
    }

    public List<DomainEvent> getDomainEvents() {
        return Collections.unmodifiableList(domainEvents);
    }
}
