package com.hendisantika.cinemabookingsystem.service;

import com.hendisantika.cinemabookingsystem.model.Actor;
import com.hendisantika.cinemabookingsystem.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : cinema-booking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/04/20
 * Time: 06.20
 */
@Service
public class ActorService {
    private final ActorRepository actorRepository;
    @Value("${page.size}")
    private Integer pageSize;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public void addActor(Actor actor) {
        actorRepository.saveAndFlush(actor);
    }

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }
}
