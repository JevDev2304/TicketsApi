package com.backend.myTicket.controller;

import com.backend.myTicket.entity.Event;

import com.backend.myTicket.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@Tag(name="Event REST API Endpoints", description = "Operations related to events")
public class EventRestController {
    private EventService eventService;
    @Autowired
    public EventRestController(EventService theEventService){
        eventService = theEventService;

    }
    @Operation(summary = "Get Available Events", description = "Get Events")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<Event> getAvailableEvents() {
        return eventService.findAvailableEvents();
    }
    @Operation(summary = "Get Available Events By Category", description = "Get Events by Category")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/category/{category}")
    public List<Event> getAvailableEventsByCategory(@PathVariable @Size(min = 5, max = 50) String category) {
        return eventService.findAvailableEventsByCategory(category);
    }
    @Operation(summary = "Get Available Events By Name", description = "Get Events by Name")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/name/{name}")
    public List<Event> getAvailableEventsByName(@PathVariable @Size(min = 2, max = 50) String name) {
        return eventService.findAvailableEventsByName(name);
    }
    @Operation(summary = "Get Event By Id", description = "Get Event by Id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{eventId}")
    public Event getEventById(@PathVariable Integer eventId) {
        return eventService.findEventById(eventId);
    }

}
