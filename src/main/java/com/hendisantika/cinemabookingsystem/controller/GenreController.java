package com.hendisantika.cinemabookingsystem.controller;

import com.hendisantika.cinemabookingsystem.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
}
