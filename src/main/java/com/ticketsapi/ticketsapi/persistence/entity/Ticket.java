package com.ticketsapi.ticketsapi.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "boletas")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_boleta")
    private Integer ticketId;
    @Column(name= "nombre")
    private String name;
    @Column(name = "id_categoria")
    private Integer categoryId;
    @Column(name = "id_evento")
    private Integer event_id;
    @Column(name = "codigo_barras")
    private String barCode;
    @Column(name = "precio_venta")
    private Integer salePrice;
    @Column(name = "cantidad_stock")
    private Integer stock;
    @Column(name = "estado")
    private Boolean state;

    @OneToMany(mappedBy = "ticket")
    private List<PurchaseTickets> purchaseTicketsT;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Integer event_id) {
        this.event_id = event_id;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
