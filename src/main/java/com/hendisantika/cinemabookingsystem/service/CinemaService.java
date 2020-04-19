package com.hendisantika.cinemabookingsystem.service;

import com.hendisantika.cinemabookingsystem.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : cinema-booking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/04/20
 * Time: 06.34
 */
@Service
public class CinemaService {

    private final CinemaRepository cinemaRepository;
    @Value("${page.size}")
    private Integer pageSize;

    @Autowired
    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }
}
