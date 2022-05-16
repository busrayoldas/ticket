package com.airlineticketsystem.repository;

import com.airlineticketsystem.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Ticket findByTicketNo(String ticketNo);
}