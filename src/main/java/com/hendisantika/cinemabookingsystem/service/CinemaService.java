package com.hendisantika.cinemabookingsystem.service;

import com.hendisantika.cinemabookingsystem.model.Cinema;
import com.hendisantika.cinemabookingsystem.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
 * Date: 20/04/20
 * Time: 06.34
 */
@Service
public class CinemaService {

    private final CinemaRepository cinemaRepository;
    @Value("${page.size}")
    private Integer pageSize;

    @Autowired
    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public Page<Cinema> getAllCinemaPage(Integer pageNumber) {
        PageRequest request = PageRequest.of(pageNumber - 1, pageSize, Sort.Direction.ASC, "title");
        return cinemaRepository.findAll(request);
    }

    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }

}
