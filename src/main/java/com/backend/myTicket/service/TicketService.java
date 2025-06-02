package com.backend.myTicket.service;

import com.backend.myTicket.entity.Ticket;
import com.backend.myTicket.response.EventTicketAvailability;

import java.util.List;

public interface TicketService {
    Ticket payTicket(Integer eventId, String email, Integer ticketId);
    List<Ticket> findTicketsByUserEmail(String email);
    EventTicketAvailability searchTicketAvailability(Integer eventId);
}
