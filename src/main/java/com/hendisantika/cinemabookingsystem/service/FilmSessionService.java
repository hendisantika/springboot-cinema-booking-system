package com.hendisantika.cinemabookingsystem.service;

import com.hendisantika.cinemabookingsystem.exception.ResourceNotFoundException;
import com.hendisantika.cinemabookingsystem.model.FilmSession;
import com.hendisantika.cinemabookingsystem.repository.FilmSessionRepository;
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
 * Time: 05.56
 */
@Service
public class FilmSessionService {
    private final FilmSessionRepository filmSessionRepository;

    @Autowired
    public FilmSessionService(FilmSessionRepository filmSessionRepository) {
        this.filmSessionRepository = filmSessionRepository;
    }

    public FilmSession addSession(FilmSession filmSession) {
        return filmSessionRepository.saveAndFlush(filmSession);
    }

    public void deleteSessionById(Long id) {
        if (getSessionById(id) != null) {
            filmSessionRepository.deleteById(id);
        }
    }

    public List<FilmSession> getAllSession() {
        return filmSessionRepository.findAll();
    }

    public FilmSession getSessionById(Long id) {
        return filmSessionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Film Session " +
                "[filmSessionId=" + id + "] can't be found"));
    }
}
