package com.hendisantika.cinemabookingsystem.controller;

import com.hendisantika.cinemabookingsystem.service.CinemaService;
import com.hendisantika.cinemabookingsystem.service.HallService;
import com.hendisantika.cinemabookingsystem.service.RowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by IntelliJ IDEA.
 * Project : cinema-booking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/04/20
 * Time: 04.14
 */
@Controller
public class RowController {

    private final RowService rowService;
    private final CinemaService cinemaService;
    private final HallService hallService;


    @Autowired
    public RowController(RowService rowService, CinemaService cinemaService, HallService hallService) {
        this.rowService = rowService;
        this.cinemaService = cinemaService;
        this.hallService = hallService;
    }
}
