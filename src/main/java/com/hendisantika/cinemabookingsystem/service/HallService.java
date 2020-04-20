package com.hendisantika.cinemabookingsystem.service;

import com.hendisantika.cinemabookingsystem.exception.ResourceNotFoundException;
import com.hendisantika.cinemabookingsystem.model.Hall;
import com.hendisantika.cinemabookingsystem.repository.HallRepository;
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
 * Time: 06.02
 */
@Service
public class HallService {
    private final HallRepository hallRepository;

    @Autowired
    public HallService(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    public List<Hall> getAllHall() {
        return hallRepository.findAll();
    }

    public Hall getHallByID(Long hallId) {
        return hallRepository.findById(hallId).orElseThrow(() -> new ResourceNotFoundException("Hall [hallId=" + hallId + "] can't be found"));
    }
}
