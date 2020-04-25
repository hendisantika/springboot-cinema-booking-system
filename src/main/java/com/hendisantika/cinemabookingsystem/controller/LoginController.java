package com.hendisantika.cinemabookingsystem.controller;

import com.hendisantika.cinemabookingsystem.service.FilmService;
import com.hendisantika.cinemabookingsystem.service.SecurityService;
import com.hendisantika.cinemabookingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
}
