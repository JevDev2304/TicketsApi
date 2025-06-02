package com.backend.myTicket.request;

import jakarta.validation.constraints.*;

public class PayTicketRequest {
    @NotBlank(message = "Email is mandatory")
    @Size(min = 5, max = 100, message = "Email must be between 5 and 100 characters")
    @Email(message = "Email must be valid")
    private String email;

    @NotNull(message = "Event ID is mandatory")
    private Integer eventId;

    @NotNull(message = "Ticket type ID is mandatory")
    @Min(value = 1, message = "Only can be used id 1, 2 or 3")
    @Max(value = 3, message = "Only can be used id 1, 2 or 3")
    private Integer ticketTypeId;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(Integer ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }
}
