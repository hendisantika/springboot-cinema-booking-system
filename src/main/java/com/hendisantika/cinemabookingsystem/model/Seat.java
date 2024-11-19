package com.hendisantika.cinemabookingsystem.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Value;

/**
 * Created by IntelliJ IDEA.
 * Project : cinema-booking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/04/20
 * Time: 06.12
 */
@Value
@Embeddable
public class Seat {

    @ManyToOne
    @JoinColumn(name = "row_id")
    private Row row;

    private Integer seat;
}
