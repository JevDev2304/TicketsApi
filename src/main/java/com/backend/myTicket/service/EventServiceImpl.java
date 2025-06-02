package com.backend.myTicket.service;

import com.backend.myTicket.entity.Event;
import com.backend.myTicket.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class EventServiceImpl implements  EventService{
    private EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository theEventRepository){
        eventRepository = theEventRepository;
    }
    @Override
    public List<Event> findAvailableEvents() {
        return eventRepository.findAvailableEventsNative();
    }

    @Override
    public List<Event> findAvailableEventsByCategory(String category) {
        return eventRepository.findAvailableEventsByCategory(category);
    }

    @Override
    public List<Event> findAvailableEventsByName(String name) {
        return eventRepository.findAvailableEventsByName(name);
    }

    @Override
    public Event findEventById(Integer eventId) {
        return eventRepository.findById(eventId).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Event not found with id: " + eventId
        ));
    }
}
