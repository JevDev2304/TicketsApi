package com.backend.myTicket.service;

import com.backend.myTicket.entity.Ticket;
import com.backend.myTicket.entity.User;
import com.backend.myTicket.repository.TicketRepository;
import com.backend.myTicket.request.PayTicketRequest;
import com.backend.myTicket.response.EventTicketAvailability;
import com.backend.myTicket.response.TicketTypeCount;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository;
    private UserService userService;
    @Autowired
    public TicketServiceImpl(TicketRepository theTicketRepository, UserService theUserService) {
        ticketRepository = theTicketRepository;
        userService = theUserService;
    }
    @Transactional
    @Override
    public Ticket payTicket(PayTicketRequest payTicketRequest) {
        Ticket ticket = ticketRepository.findFirstAvailableTicket(payTicketRequest.getEventId(), payTicketRequest.getTicketTypeId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "The requested ticket is not available"
                ));
        User user = userService.findById(payTicketRequest.getEmail());
        if (user == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User not found with email: " + payTicketRequest.getEmail()
            );
        }
        ticket.setUser(user);
        ticket.setPurchaseDate(new Date());
        return  ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> findTicketsByUserEmail(String email) {
        return ticketRepository.findTicketsByUserEmail(email);
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
