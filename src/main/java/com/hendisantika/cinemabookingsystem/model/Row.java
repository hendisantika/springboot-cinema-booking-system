package com.hendisantika.cinemabookingsystem.model;

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
