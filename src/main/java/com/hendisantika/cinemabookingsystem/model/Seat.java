package com.hendisantika.cinemabookingsystem.model;

import com.sun.rowset.internal.Row;
import lombok.Value;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
class Seat {

    @ManyToOne
    @JoinColumn(name = "row_id")
    private Row row;

    private Integer seat;
}
