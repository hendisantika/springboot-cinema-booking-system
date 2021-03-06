package com.hendisantika.cinemabookingsystem.repository;

import com.hendisantika.cinemabookingsystem.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : cinema-booking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/04/20
 * Time: 06.18
 */
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
