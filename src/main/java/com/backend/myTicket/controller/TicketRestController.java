package com.backend.myTicket.controller;

import com.backend.myTicket.entity.Ticket;
import com.backend.myTicket.request.PayTicketRequest;
import com.backend.myTicket.response.EventTicketAvailability;
import com.backend.myTicket.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public EventTicketAvailability getTicketAvailabilityForEvent(@PathVariable() Long eventId) {
        return ticketService.searchTicketAvailability(Math.toIntExact(eventId));
    }
    @Operation(summary = "Pay for a Ticket", description = "Return a Ticket after payment")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/pay")
    public Ticket payForTicket(@RequestBody PayTicketRequest ticketRequest) {
        return ticketService.payTicket(ticketRequest);
    }

}
