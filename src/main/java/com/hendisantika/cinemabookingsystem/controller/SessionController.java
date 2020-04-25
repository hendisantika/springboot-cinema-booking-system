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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

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

    @PostMapping(value = "/admin/add/session")
    public String addSession(@Valid FilmSession filmSession, @RequestParam("price") int price,
                             BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("allFilms", filmService.getAllFilms());
            model.addAttribute("price", price);
            return "/admin/add/session";
        }
        filmSession = filmSessionService.addSession(filmSession);
        return "redirect:/admin/session/";
    }

    @GetMapping(value = "/admin/edit/session")
    public String editSession(@RequestParam Long sessionId, Model model) {
        FilmSession filmSession = filmSessionService.getSessionById(sessionId);
        model.addAttribute("filmSession", filmSession);
        model.addAttribute("allHalls", filmSession.getHall().getCinema().getHalls());
        model.addAttribute("allFilms", filmService.getAllFilms());
        return "/admin/edit/session";
    }

    @GetMapping(value = "/admin/delete/session")
    public String deleteSession(@RequestParam Long filmSessionId, Model model) {
        filmSessionService.deleteSessionById(filmSessionId);
        return "redirect:/admin/session";
    }
}
