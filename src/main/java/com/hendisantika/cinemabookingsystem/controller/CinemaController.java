package com.hendisantika.cinemabookingsystem.controller;

import com.hendisantika.cinemabookingsystem.model.Cinema;
import com.hendisantika.cinemabookingsystem.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping(value = "/cinema")
    public String allCinemaUser(@RequestParam(defaultValue = "1", required = false) Integer page, Model model) {
        Page<Cinema> pages = cinemaService.getAllCinemaPage(page);
        model.addAttribute("allCinema", pages);
        return "/cinema";
    }

    @GetMapping(value = "/admin/add/cinema")
    public String addCinema(Model model) {
        model.addAttribute("cinema", new Cinema());
        return "/admin/add/cinema";
    }
}
