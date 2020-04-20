package com.hendisantika.cinemabookingsystem.service;

import com.hendisantika.cinemabookingsystem.exception.ResourceNotFoundException;
import com.hendisantika.cinemabookingsystem.model.Genre;
import com.hendisantika.cinemabookingsystem.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : cinema-booking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/04/20
 * Time: 05.59
 */
@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAllGenre() {
        return genreRepository.findAll();
    }

    public Genre getGenreByID(Long id) {
        return genreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Genre [genreId=" + id +
                "] can't be found"));
    }
}
