package com.hendisantika.cinemabookingsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class Cinema extends BaseEntity {

    private String title;
    private String address;
    private String phone;
    private String email;

    @OneToMany(mappedBy = "cinema")
    private Set<Hall> halls;

}
