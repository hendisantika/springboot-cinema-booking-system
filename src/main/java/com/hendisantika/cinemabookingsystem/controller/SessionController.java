package com.hendisantika.cinemabookingsystem.controller;

import com.hendisantika.cinemabookingsystem.model.FilmSession;
import com.hendisantika.cinemabookingsystem.service.CinemaService;
import com.hendisantika.cinemabookingsystem.service.FilmService;
import com.hendisantika.cinemabookingsystem.service.FilmSessionService;
import com.hendisantika.cinemabookingsystem.service.HallService;
import com.hendisantika.cinemabookingsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * Date: 26/04/20
 * Time: 04.16
 */
@Controller
public class SessionController {

    private final FilmSessionService filmSessionService;
    private final FilmService filmService;
    private final CinemaService cinemaService;
    private final HallService hallService;
    private final TicketService ticketService;


    @Autowired
    public SessionController(FilmSessionService filmSessionService, FilmService filmService,
                             CinemaService cinemaService, HallService hallService,
                             TicketService ticketService) {
        this.filmSessionService = filmSessionService;
        this.filmService = filmService;
        this.cinemaService = cinemaService;
        this.hallService = hallService;
        this.ticketService = ticketService;
    }

    @GetMapping(value = "/admin/add/session", params = {"cinemaId"})
    public String addSession(@RequestParam Long cinemaId, Model model) {
        FilmSession filmSession = new FilmSession();
        model.addAttribute("filmSessionId", filmSession.getId());
        model.addAttribute("filmSession", filmSession);
        model.addAttribute("cinemaId", cinemaId);
        model.addAttribute("allHalls", cinemaService.getCinemaByID(cinemaId).getHalls());
        model.addAttribute("allFilms", filmService.getAllFilms());
        return "/admin/add/session";
    }

}
