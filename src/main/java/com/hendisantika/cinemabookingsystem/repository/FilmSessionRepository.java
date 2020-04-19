package com.hendisantika.cinemabookingsystem.repository;

import com.hendisantika.cinemabookingsystem.model.FilmSession;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : cinema-booking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/04/20
 * Time: 06.16
 */
public interface FilmSessionRepository extends JpaRepository<FilmSession, Long> {
}
