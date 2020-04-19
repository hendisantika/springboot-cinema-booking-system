package com.hendisantika.cinemabookingsystem.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by IntelliJ IDEA.
 * Project : cinema-booking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/04/20
 * Time: 06.13
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Row extends BaseEntity {
    private int rowIndex;

    private int seats;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;
}
