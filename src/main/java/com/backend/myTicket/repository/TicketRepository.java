package com.backend.myTicket.repository;

import com.backend.myTicket.entity.Event;
import com.backend.myTicket.entity.Ticket;
import com.backend.myTicket.response.TicketTypeCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, String> {
    @Query(value = """
             SELECT ticket_type_id AS tipoTicket, COUNT(*) AS total
                    FROM tickets
                    WHERE event_id = :eventId
                    AND email IS NULL
                    GROUP BY ticket_type_id
                    ORDER BY ticket_type_id
            """, nativeQuery = true)
    List<TicketTypeCount> searchTicketAvailability(@Param("eventId") Integer eventId);

    @Query(value = "SELECT * FROM tickets  WHERE event_id = :eventId AND ticket_type_id = :ticketTypeId AND email IS NULL LIMIT 1", nativeQuery = true)
    Optional<Ticket> findFirstAvailableTicket(@Param("eventId") Integer eventId, @Param("ticketTypeId") Integer ticketTypeId);

}
