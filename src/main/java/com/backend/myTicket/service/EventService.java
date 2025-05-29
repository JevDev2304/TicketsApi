package com.backend.myTicket.service;

import com.backend.myTicket.entity.Event;
import com.backend.myTicket.entity.User;

import java.util.List;

public interface EventService {
    List<Event> findAvailableEvents();
    List<Event> findAvailableEventsByCategory(String category);
    List<Event> findAvailableEventsByName(String name);
}
