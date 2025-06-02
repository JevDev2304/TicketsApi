package com.backend.myTicket.service;

import com.backend.myTicket.entity.Ticket;
import com.backend.myTicket.repository.TicketRepository;
import com.backend.myTicket.response.EventTicketAvailability;
import com.backend.myTicket.response.TicketTypeCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository;
    @Autowired
    public TicketServiceImpl(TicketRepository theTicketRepository) {
        ticketRepository = theTicketRepository;
    }

    @Override
    public Ticket payTicket(Integer eventId, String email, Integer ticketId) {
        return null;
    }

    @Override
    public List<Ticket> findTicketsByUserEmail(String email) {
        return List.of();
    }

    @Override
    public EventTicketAvailability searchTicketAvailability(Integer eventId) {
        List<TicketTypeCount> dbResponse = ticketRepository.searchTicketAvailability(eventId);
        if (dbResponse.isEmpty()) {
            return new EventTicketAvailability( 0, 0, 0);
        }
        else{
            return new EventTicketAvailability(
                    Math.toIntExact(dbResponse.get(0).getTotal()),
                    Math.toIntExact(dbResponse.get(1).getTotal()),
                    Math.toIntExact(dbResponse.get(2).getTotal())
            );
        }

    }
}
