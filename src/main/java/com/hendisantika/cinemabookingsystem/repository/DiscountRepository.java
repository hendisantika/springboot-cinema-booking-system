package com.hendisantika.cinemabookingsystem.repository;

import com.hendisantika.cinemabookingsystem.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : cinema-booking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/04/20
 * Time: 06.15
 */
public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
