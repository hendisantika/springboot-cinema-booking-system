package com.hendisantika.cinemabookingsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
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
public class User extends BaseEntity {

    private String username;

    private String firstName;

    private String lastName;

    private String phone;

    private String password;

    @Transient
    private String passwordConfirm;

    private String email;

    @OneToMany(mappedBy = "user")
    private Set<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;
}
