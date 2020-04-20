package com.hendisantika.cinemabookingsystem.service;

import com.hendisantika.cinemabookingsystem.exception.ResourceNotFoundException;
import com.hendisantika.cinemabookingsystem.model.Film;
import com.hendisantika.cinemabookingsystem.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Page<Film> getAllFilmsPage(Integer pageNumber) {
        PageRequest request = PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "title");
        return filmRepository.findAll(request);
    }

    public Film getFilmByID(Long id) {
        return filmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor " +
                "[cinemaId=" + id + "] can't be found"));
    }

    public Page<Film> searchByTittle(String filmTittle, Integer pageNumber) {
        PageRequest request = PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "title");
        return filmRepository.findByTitleContaining(filmTittle, request);
    }
}
