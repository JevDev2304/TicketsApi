package com.backend.myTicket.service;

import com.backend.myTicket.entity.Ticket;
import com.backend.myTicket.request.PayTicketRequest;
import com.backend.myTicket.response.EventTicketAvailability;

import java.util.List;

public interface TicketService {
    Ticket payTicket(PayTicketRequest payTicketRequest);
    List<Ticket> findTicketsByUserEmail(String email);
    EventTicketAvailability searchTicketAvailability(Integer eventId);
    Ticket findTicketById(String ticketId);

}
