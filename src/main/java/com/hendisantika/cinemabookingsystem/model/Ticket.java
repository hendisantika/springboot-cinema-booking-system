package com.hendisantika.cinemabookingsystem.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by IntelliJ IDEA.
 * Project : cinema-booking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/04/20
 * Time: 06.12
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Ticket extends BaseEntity {

    @Embedded
    private Seat seat;

    private Integer price;

    @ManyToOne
    @JoinColumn(name = "film_session_id")
    private FilmSession filmSession;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
