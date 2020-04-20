package com.hendisantika.cinemabookingsystem.service;

import com.hendisantika.cinemabookingsystem.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : cinema-booking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/04/20
 * Time: 06.08
 */
@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    @Value("${page.size}")
    private Integer pageSize;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
}
