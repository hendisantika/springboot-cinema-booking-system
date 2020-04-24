package com.hendisantika.cinemabookingsystem.controller;

import com.hendisantika.cinemabookingsystem.model.Actor;
import com.hendisantika.cinemabookingsystem.service.ActorService;
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
 * Time: 09.37
 */
@Controller
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping(value = "/admin/actor")
    public String allActor(Model model) {
        model.addAttribute("actors", actorService.getAllActors());
        return "/admin/actor";
    }

    @GetMapping(value = "/actor")
    public String allActorUser(@RequestParam(required = false, defaultValue = "1") Integer page, Model model) {
        Page<Actor> pages = actorService.getAllActorsPage(page);
        model.addAttribute("allActor", pages);
        return "/actor";
    }

    @GetMapping(value = "/admin/delete/actor")
    public String deleteActor(@RequestParam Long actorId) {
        actorService.deleteActorByID(actorId);
        return "redirect:/admin/actor";
    }

    @GetMapping(value = "/admin/edit/actor", params = {"actorId"})
    public String editActor(@RequestParam Long actorId, Model model) {
        model.addAttribute("actor", actorService.getActorByID(actorId));
        return "/admin/edit/actor";
    }

    @GetMapping(value = "/admin/add/actor")
    public String addActor(Model model) {
        model.addAttribute("actor", new Actor());
        return "/admin/add/actor";
    }
}
