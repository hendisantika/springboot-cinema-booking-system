package com.hendisantika.cinemabookingsystem.service;

import com.hendisantika.cinemabookingsystem.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : cinema-booking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/04/20
 * Time: 05.53
 */
@Service
public class FilmService {
    private static final int PAGE_SIZE = 10;

    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
}
