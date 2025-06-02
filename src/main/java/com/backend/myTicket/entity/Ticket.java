package com.backend.myTicket.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @Column(name = "id", nullable = false, unique = true, columnDefinition = "char(36)")
    private String id;

    @ManyToOne()
    @JoinColumn(name = "email", referencedColumnName = "email", nullable = true)
    private User user;

    @ManyToOne()
    @JoinColumn(name = "event_id", referencedColumnName = "id", nullable = false)
    private Event event;

    @ManyToOne()
    @JoinColumn(name = "ticket_type_id", referencedColumnName = "id", nullable = false)
    private TicketType ticketTypeEntity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "purchase_date", nullable = true)
    private Date purchaseDate;

    public Ticket() {}
    public Ticket(String id, User user, Event event, TicketType ticketTypeEntity, Date purchaseDate) {
        this.id = id;
        this.user = user;
        this.event = event;
        this.ticketTypeEntity = ticketTypeEntity;
        this.purchaseDate = purchaseDate;
    }
    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public TicketType getTicketTypeEntity() {
        return ticketTypeEntity;
    }

    public void setTicketTypeEntity(TicketType ticketTypeEntity) {
        this.ticketTypeEntity = ticketTypeEntity;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
