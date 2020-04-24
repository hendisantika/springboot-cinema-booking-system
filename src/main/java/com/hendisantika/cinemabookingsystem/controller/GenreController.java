package com.hendisantika.cinemabookingsystem.controller;

import com.hendisantika.cinemabookingsystem.model.Genre;
import com.hendisantika.cinemabookingsystem.service.GenreService;
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
 * Date: 25/04/20
 * Time: 05.25
 */
@Controller
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping(value = "/admin/genre")
    public String allGenre(Model model) {
        model.addAttribute("genres", genreService.getAllGenre());
        return "/admin/genre";
    }

    @GetMapping(value = "/genre")
    public String allGenreUser(Model model) {
        model.addAttribute("genres", genreService.getAllGenre());
        return "/genre";
    }

    @GetMapping(value = "/admin/delete/genre")
    public String deleteGenre(@RequestParam Long genreId) {
        genreService.deleteGenreById(genreId);
        return "redirect:/admin/genre";
    }

    @GetMapping(value = "/admin/edit/genre", params = {"genreId"})
    public String editGenre(@RequestParam Long genreId, Model model) {
        model.addAttribute("genre", genreService.getGenreByID(genreId));
        return "/admin/edit/genre";
    }

    @GetMapping(value = "/admin/add/genre")
    public String addGenre(Model model) {
        model.addAttribute("genre", new Genre());
        return "/admin/add/genre";
    }
}
