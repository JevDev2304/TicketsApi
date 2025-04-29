package com.ticketsapi.ticketsapi.domain;


import java.time.LocalDateTime;

public class PurchaseD {

    private Integer purchaseIdD;

    private String customerIdD;

    private LocalDateTime dateD; // Para una fecha sin timezone

    private String paymentMethodD; // Para un solo carácter (CHAR)


    private String lastFourDigitsD;

    private Integer paymentValueD; // Para el valor de pago como NUMERIC


    private String nameInBillD;

    private CustomerD customerD;

    public CustomerD getCustomerD() {
        return customerD;
    }

    public void setCustomerD(CustomerD customerD) {
        this.customerD = customerD;
    }

    public Integer getPurchaseIdD() {
        return purchaseIdD;
    }

    public void setPurchaseIdD(Integer purchaseIdD) {
        this.purchaseIdD = purchaseIdD;
    }

    public String getCustomerIdD() {
        return customerIdD;
    }

    public void setCustomerIdD(String customerIdD) {
        this.customerIdD = customerIdD;
    }

    public LocalDateTime getDateD() {
        return dateD;
    }

    public void setDateD(LocalDateTime dateD) {
        this.dateD = dateD;
    }

    public String getPaymentMethodD() {
        return paymentMethodD;
    }

    public void setPaymentMethodD(String paymentMethodD) {
        this.paymentMethodD = paymentMethodD;
    }

    public String getLastFourDigitsD() {
        return lastFourDigitsD;
    }

    public void setLastFourDigitsD(String lastFourDigitsD) {
        this.lastFourDigitsD = lastFourDigitsD;
    }

    public Integer getPaymentValueD() {
        return paymentValueD;
    }

    public void setPaymentValueD(Integer paymentValueD) {
        this.paymentValueD = paymentValueD;
    }

    public String getNameInBillD() {
        return nameInBillD;
    }

    public void setNameInBillD(String nameInBillD) {
        this.nameInBillD = nameInBillD;
    }
}
