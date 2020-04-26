package com.hendisantika.cinemabookingsystem.controller;

import com.hendisantika.cinemabookingsystem.service.DiscountService;
import com.hendisantika.cinemabookingsystem.service.UserService;
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
 * Date: 27/04/20
 * Time: 04.12
 */
@Controller
public class UserController {

    private final UserService userService;
    private final DiscountService discountService;

    @Autowired
    public UserController(UserService userService, DiscountService discountService) {
        this.userService = userService;
        this.discountService = discountService;
    }

    @GetMapping(value = "/admin/user")
    public String allUser(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/admin/user";
    }
}
