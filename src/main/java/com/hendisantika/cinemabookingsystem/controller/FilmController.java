package com.hendisantika.cinemabookingsystem.controller;

import com.hendisantika.cinemabookingsystem.service.ActorService;
import com.hendisantika.cinemabookingsystem.service.FilmService;
import com.hendisantika.cinemabookingsystem.service.GenreService;
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
 * Time: 05.16
 */
@Controller
public class FilmController {
    private final FilmService filmService;

    private final ActorService actorService;

    private final GenreService genreService;

    @Autowired
    public FilmController(FilmService filmService, ActorService actorService, GenreService genreService) {
        this.filmService = filmService;
        this.actorService = actorService;
        this.genreService = genreService;
    }

    @GetMapping(value = "/admin/film")
    public String allFilms(Model model) {
        model.addAttribute("films", filmService.getAllFilms());
        return "/admin/film";
    }
}
