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
 * Time: 06.11
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Discount extends BaseEntity {

    private String title;

    private String description;

    private int percent;

    @OneToMany(mappedBy = "discount")
    private Set<User> users;
}
