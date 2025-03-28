package com.hendisantika.cinemabookingsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Project : cinema-booking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/04/20
 * Time: 06.09
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class FilmSession extends BaseEntity {

    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @OneToMany(mappedBy = "filmSession")
    private Set<Ticket> tickets;
}
