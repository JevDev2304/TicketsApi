package com.backend.myTicket.controller;

import com.backend.myTicket.response.EventTicketAvailability;
import com.backend.myTicket.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tickets")
@Tag(name = "Ticket REST API Endpoints", description = "Operations related to tickets")
public class TicketRestController {
    private TicketService ticketService;
    @Autowired
    public TicketRestController(TicketService theTicketService) {
        ticketService = theTicketService;
    }
    @Operation(summary ="Get Ticket availability for an Event", description = "Get Ticket availability for an Event")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/availability/{eventId}")
    public EventTicketAvailability getTicketAvailabilityForEvent(Long eventId) {
        return ticketService.searchTicketAvailability(Math.toIntExact(eventId));
    }
}
