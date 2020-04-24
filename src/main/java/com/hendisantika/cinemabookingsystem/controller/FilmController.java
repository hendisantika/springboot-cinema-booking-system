package com.hendisantika.cinemabookingsystem.controller;

import com.hendisantika.cinemabookingsystem.model.Film;
import com.hendisantika.cinemabookingsystem.service.ActorService;
import com.hendisantika.cinemabookingsystem.service.FilmService;
import com.hendisantika.cinemabookingsystem.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping(value = "/film")
    public String allFilmUser(@RequestParam(defaultValue = "1", required = false) Integer page, Model model) {
        Page<Film> pages = filmService.getAllFilmsPage(page);
        model.addAttribute("allFilm", pages);
        model.addAttribute("films", filmService.getAllFilms());
        return "/film";
    }

    @GetMapping(value = "/film", params = {"filmTittle"})
    public String searchFilm(@RequestParam String filmTittle,
                             @RequestParam(defaultValue = "1", required = false) Integer page, Model model) {
        Page<Film> searchResult = filmService.searchByTittle(filmTittle, page);
        model.addAttribute("allFilm", searchResult);
        return "/film";
    }

    @GetMapping(value = "/admin/add/film")
    public String addFilm(Model model) {
        model.addAttribute("film", new Film());
        return "/admin/add/film";
    }

    @PostMapping(value = "/admin/add/film")
    public String addFilm(@Valid Film film, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "error";
        }
        filmService.addFilm(film);

        return "redirect:/admin/film";
    }

    @GetMapping(value = "/admin/delete/film", params = {"filmId"})
    public String deleteFilm(@RequestParam Long filmId, Model model) {
        filmService.deleteFilmByID(filmId);
        return "redirect:/admin/film";
    }

    @GetMapping(value = "/admin/edit/film", params = {"filmId"})
    public String editFilm(@RequestParam Long filmId, Model model) {
        model.addAttribute("film", filmService.getFilmByID(filmId));
        return "/admin/edit/film";
    }

    @GetMapping(value = "/admin/add/genre_to_film", params = {"filmId"})
    public String addGenres(@RequestParam Long filmId, Model model) {
        model.addAttribute("allGenres", genreService.getAllGenre());
        model.addAttribute("film", filmService.getFilmByID(filmId));
        return "/admin/add/genre_to_film";
    }

    @PostMapping(value = "/admin/add/genre_to_film")
    public String addGenres(@Valid Film film, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "error";
        }
        filmService.addFilm(film);
        return "redirect:/admin/film";
    }

    @GetMapping(value = "/details/film")
    public String getFilm(@RequestParam Long filmId, Model model) {
        model.addAttribute("film", filmService.getFilmByID(filmId));
        return "/details/film";
    }

    @GetMapping(value = "/admin/add/actor_to_film", params = {"filmId"})
    public String addActors(@RequestParam Long filmId, Model model) {
        model.addAttribute("allActors", actorService.getAllActors());
        model.addAttribute("film", filmService.getFilmByID(filmId));
        return "/admin/add/actor_to_film";
    }

    @PostMapping(value = "/admin/add/actor_to_film")
    public String addActors(@Valid Film film, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "error";
        }
        filmService.addFilm(film);
        return "redirect:/admin/film";
    }

    private void validateImage(MultipartFile image) {
        if (!image.getContentType().equals("image/jpeg")) {
            throw new RuntimeException("Only JPG images are accepted");
        }
    }
}
