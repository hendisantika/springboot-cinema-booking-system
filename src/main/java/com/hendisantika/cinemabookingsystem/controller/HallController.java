package com.hendisantika.cinemabookingsystem.controller;

import com.hendisantika.cinemabookingsystem.model.Hall;
import com.hendisantika.cinemabookingsystem.service.CinemaService;
import com.hendisantika.cinemabookingsystem.service.HallService;
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
 * Date: 25/04/20
 * Time: 05.34
 */
@Controller
@RequiredArgsConstructor
public class HallController {

    private final CinemaService cinemaService;

    private final HallService hallService;

    @GetMapping(value = "/admin/hall")
    public String allHall(Model model) {
        model.addAttribute("halls", hallService.getAllHall());
        return "/admin/hall";
    }

    @GetMapping(value = "/hall")
    public String allHallUser(Model model) {
        model.addAttribute("halls", hallService.getAllHall());
        return "/hall";
    }

    @GetMapping(value = "/admin/add/hall")
    public String addHall(Model model) {
        model.addAttribute("hall", new Hall());
        model.addAttribute("cinemas", cinemaService.getAllCinemas());
        return "/admin/add/hall";
    }

    @PostMapping(value = "/admin/add/hall")
    public String addHall(@Valid Hall hall, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/admin/hall";
        }
        hallService.addHall(hall);
        return "redirect:/admin/hall";
    }

    @GetMapping(value = "/admin/edit/hall")
    public String editHall(@RequestParam Long hallId, Model model) {
        model.addAttribute("hall", hallService.getHallByID(hallId));
        model.addAttribute("cinemas", cinemaService.getAllCinemas());
        return "/admin/edit/hall";
    }

    @GetMapping(value = "/admin/delete/hall", params = {"hallId"})
    public String deleteHall(@RequestParam Long hallId) {
        hallService.deleteHallByID(hallId);
        return "redirect:/admin/hall";
    }
}
