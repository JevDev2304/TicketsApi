package com.ticketsapi.ticketsapi.persistence.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.EmbeddableInstantiator;

@Entity
@Table(name= "compras_boletas")
public class PurchaseTickets {
    @EmbeddedId
    private PurchaseTicketsPK id;
    @Column(name = "cantidad")
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "id_boleta", insertable = false, updatable = false)
    private Ticket ticket;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public PurchaseTicketsPK getId() {
        return id;
    }

    public void setId(PurchaseTicketsPK id) {
        this.id = id;
    }
}
