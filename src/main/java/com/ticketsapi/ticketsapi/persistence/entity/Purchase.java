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

    @Column(name = "medio_pago")
    private char paymentMethodChar; // Para un solo carácter (CHAR)

    @Column(name = "ultimos_cuatro_tarjeta")
    private String lastFourDigits;

    @Column(name = "valor_pagado")
    private Integer paymentValue; // Para el valor de pago como NUMERIC

    @Column(name = "nombre_factura")
    private String nameInBill;

    @Column(name = "metodo_pago")
    private Character methodChar;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Customer customer;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseTickets> purchaseTicketsP;

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

    public char getPaymentMethodChar() {
        return paymentMethodChar;
    }

    public void setPaymentMethodChar(char paymentMethodChar) {
        this.paymentMethodChar = paymentMethodChar;
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

    public Character getMethodChar() {
        return methodChar;
    }

    public void setMethodChar(Character methodChar) {
        this.methodChar = methodChar;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}