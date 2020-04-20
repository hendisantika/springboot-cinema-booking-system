package com.hendisantika.cinemabookingsystem.service;

import com.hendisantika.cinemabookingsystem.repository.TicketRepository;
import com.hendisantika.cinemabookingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : cinema-booking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/04/20
 * Time: 06.12
 */
@Service
public class UserService {
    private final UserRepository userRepository;

    private final TicketRepository ticketRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, TicketRepository ticketRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
}
