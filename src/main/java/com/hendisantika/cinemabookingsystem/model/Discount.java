package com.hendisantika.cinemabookingsystem.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
