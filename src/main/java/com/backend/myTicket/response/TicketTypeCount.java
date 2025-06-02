package com.backend.myTicket.response;

public class TicketTypeCount {
    private Integer tipoTicket;
    private Long total;

    public TicketTypeCount(Integer tipoTicket, Long total) {
        this.tipoTicket = tipoTicket;
        this.total = total;
    }

    public Integer getTipoTicket() {
        return tipoTicket;
    }

    public void setTipoTicket(Integer tipoTicket) {
        this.tipoTicket = tipoTicket;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}