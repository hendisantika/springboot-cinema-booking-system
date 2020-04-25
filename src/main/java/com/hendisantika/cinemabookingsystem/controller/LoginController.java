package com.hendisantika.cinemabookingsystem.controller;

import com.hendisantika.cinemabookingsystem.service.FilmService;
import com.hendisantika.cinemabookingsystem.service.SecurityService;
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
 * Date: 26/04/20
 * Time: 04.08
 */
@Controller
public class LoginController {

    private final UserService userService;
    private final SecurityService securityService;
    private final FilmService filmService;

    @Autowired
    public LoginController(UserService userService,
                           SecurityService securityService,
                           FilmService filmService) {
        this.userService = userService;
        this.securityService = securityService;
        this.filmService = filmService;
    }

    @GetMapping(value = "/admin/")
    public String index(Model model) {
        return "/admin/index";
    }

}
