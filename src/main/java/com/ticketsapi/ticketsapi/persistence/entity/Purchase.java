package com.ticketsapi.ticketsapi.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compras")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer purchaseId;

    @Column(name = "id_cliente")
    private String customerId;

    @Column(name = "fecha")
    private LocalDateTime date; // Para una fecha sin timezone

    @Column(name = "metodo_pago")
    private String paymentMethod; // Para un solo carácter (CHAR)

    @Column(name = "ultimos_cuatro_tarjeta")
    private String lastFourDigits;

    @Column(name = "valor_pagado")
    private Integer paymentValue; // Para el valor de pago como NUMERIC

    @Column(name = "nombre_factura")
    private String nameInBill;

    public List<PurchaseTickets> getPurchaseTicketsP() {
        return purchaseTicketsP;
    }

    public void setPurchaseTicketsP(List<PurchaseTickets> purchaseTicketsP) {
        this.purchaseTicketsP = purchaseTicketsP;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Customer customer;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseTickets> purchaseTicketsP;

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }


    public String getLastFourDigits() {
        return lastFourDigits;
    }

    public void setLastFourDigits(String lastFourDigits) {
        this.lastFourDigits = lastFourDigits;
    }

    public Integer getPaymentValue() {
        return paymentValue;
    }

    public void setPaymentValue(Integer paymentValue) {
        this.paymentValue = paymentValue;
    }

    public String getNameInBill() {
        return nameInBill;
    }

    public void setNameInBill(String nameInBill) {
        this.nameInBill = nameInBill;
    }


    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}