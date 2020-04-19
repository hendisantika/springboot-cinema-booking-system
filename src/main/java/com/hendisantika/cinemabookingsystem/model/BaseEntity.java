package com.hendisantika.cinemabookingsystem.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by IntelliJ IDEA.
 * Project : cinema-booking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/04/20
 * Time: 06.06
 */
@Data
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
}
