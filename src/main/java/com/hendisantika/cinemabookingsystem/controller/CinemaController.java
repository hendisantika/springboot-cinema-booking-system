package com.hendisantika.cinemabookingsystem.controller;

import com.hendisantika.cinemabookingsystem.service.CinemaService;
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
 * Date: 24/04/20
 * Time: 09.52
 */
@Controller
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping(value = "/admin/cinema")
    public String allCinema(Model model) {
        model.addAttribute("cinemas", cinemaService.getAllCinemas());
        return "/admin/cinema";
    }

}
