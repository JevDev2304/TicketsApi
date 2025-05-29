package com.backend.myTicket.repository;

import com.backend.myTicket.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Integer> {
    @Query(value = "SELECT * FROM events WHERE date >= CURRENT_TIMESTAMP ORDER BY date ASC", nativeQuery = true)
    List<Event> findAvailableEventsNative();
    @Query(value = "SELECT * FROM events WHERE date >= CURRENT_TIMESTAMP AND category = ?1 AND date >= CURRENT_DATE ORDER BY date ASC", nativeQuery = true)
    List<Event> findAvailableEventsByCategory(String category);
    @Query(value = "SELECT * FROM events WHERE date >= CURRENT_TIMESTAMP AND name LIKE CONCAT('%', ?1, '%')", nativeQuery = true)
    List<Event> findAvailableEventsByName(String name);

}
