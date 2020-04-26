package com.hendisantika.cinemabookingsystem.controller;

import com.hendisantika.cinemabookingsystem.model.Ticket;
import com.hendisantika.cinemabookingsystem.service.RowService;
import com.hendisantika.cinemabookingsystem.service.TicketService;
import com.hendisantika.cinemabookingsystem.service.UserService;
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
 * Date: 27/04/20
 * Time: 04.07
 */
@Controller
public class TicketController {

    private final TicketService ticketService;
    private final UserService userService;
    private final RowService rowService;

    @Autowired
    public TicketController(TicketService ticketService, UserService userService, RowService rowService) {
        this.ticketService = ticketService;
        this.userService = userService;
        this.rowService = rowService;
    }

    @GetMapping(value = "/admin/edit/ticket", params = {"ticketId"})
    public String editTicket(@RequestParam Long ticketId, Model model) {
        model.addAttribute("ticket", ticketService.findById(ticketId));
        return "/admin/edit/ticket";
    }

    @PostMapping(value = "/admin/edit/ticket")
    public String editTicket(@Valid Ticket ticket, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/admin/ticket";
        }
        ticketService.update(ticket);
        return "redirect:/admin/ticket";
    }
}
