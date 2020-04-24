package com.hendisantika.cinemabookingsystem.controller;

import com.hendisantika.cinemabookingsystem.service.CinemaService;
import com.hendisantika.cinemabookingsystem.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : cinema-booking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 25/04/20
 * Time: 05.34
 */
@Controller
public class HallController {

    private final CinemaService cinemaService;

    private final HallService hallService;

    @Autowired
    public HallController(CinemaService cinemaService, HallService hallService) {
        this.cinemaService = cinemaService;
        this.hallService = hallService;
    }

    @GetMapping(value = "/admin/hall")
    public String allHall(Model model) {
        model.addAttribute("halls", hallService.getAllHall());
        return "/admin/hall";
    }
}
