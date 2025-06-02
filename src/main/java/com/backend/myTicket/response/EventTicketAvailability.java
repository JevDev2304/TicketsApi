package com.backend.myTicket.response;


public class EventTicketAvailability {
    private Integer basicTicketsAvailable;
    private Integer preferredTicketsAvailable;
    private Integer vipTicketsAvailable;

    public EventTicketAvailability(Integer basicTicketsAvailable, Integer preferredTicketsAvailable, Integer vipTicketsAvailable) {
        this.basicTicketsAvailable = basicTicketsAvailable;
        this.preferredTicketsAvailable = preferredTicketsAvailable;
        this.vipTicketsAvailable = vipTicketsAvailable;
    }

    public Integer getBasicTicketsAvailable() {
        return basicTicketsAvailable;
    }

    public void setBasicTicketsAvailable(Integer basicTicketsAvailable) {
        this.basicTicketsAvailable = basicTicketsAvailable;
    }

    public Integer getPreferredTicketsAvailable() {
        return preferredTicketsAvailable;
    }

    public void setPreferredTicketsAvailable(Integer preferredTicketsAvailable) {
        this.preferredTicketsAvailable = preferredTicketsAvailable;
    }

    public Integer getVipTicketsAvailable() {
        return vipTicketsAvailable;
    }

    public void setVipTicketsAvailable(Integer vipTicketsAvailable) {
        this.vipTicketsAvailable = vipTicketsAvailable;
    }
}
