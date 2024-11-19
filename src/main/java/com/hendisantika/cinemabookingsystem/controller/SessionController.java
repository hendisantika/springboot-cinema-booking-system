package com.hendisantika.cinemabookingsystem.controller;

import com.hendisantika.cinemabookingsystem.model.FilmSession;
import com.hendisantika.cinemabookingsystem.service.CinemaService;
import com.hendisantika.cinemabookingsystem.service.FilmService;
import com.hendisantika.cinemabookingsystem.service.FilmSessionService;
import com.hendisantika.cinemabookingsystem.service.HallService;
import com.hendisantika.cinemabookingsystem.service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequiredArgsConstructor
public class SessionController {

    private final FilmSessionService filmSessionService;
    private final FilmService filmService;
    private final CinemaService cinemaService;
    private final HallService hallService;
    private final TicketService ticketService;

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

    @GetMapping(value = "/admin/session", params = {"cinemaId"})
    public String allSessionByCinema(@RequestParam Long cinemaId, Model model) {
        model.addAttribute("cinemaId", cinemaId);
        return "/admin/session";
    }

    @GetMapping(value = "/admin/session")
    public String allSession(Model model) {
        model.addAttribute("sessions", filmSessionService.getAllSession());
        return "/admin/session";
    }

    @GetMapping(value = "/session", params = {"cinemaId"})
    public String allSessionByCinemaUser(@RequestParam Long cinemaId, Model model) {
        return "/session";
    }

    @GetMapping(value = "/session", params = {"hallId"})
    public String allSessionByHallUser(@RequestParam Long hallId, Model model) {
        return "/session";
    }

    @GetMapping(value = "/session", params = {"filmId"})
    public String allSessionByFilmUser(@RequestParam Long filmId, Model model) {
        return "/session";
    }

    @GetMapping(value = "/session")
    public String allSessionUser(Model model) {
        model.addAttribute("sessions", filmSessionService.getAllSession());
        return "/session";
    }

    @GetMapping(value = "/details/session")
    public String getSession(@RequestParam Long sessionId, Model model) {
        model.addAttribute("filmSession", filmSessionService.getSessionById(sessionId));
        return "/details/session";
    }
}
