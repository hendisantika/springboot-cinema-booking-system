package com.hendisantika.cinemabookingsystem.repository;

import com.hendisantika.cinemabookingsystem.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
public interface FilmRepository extends JpaRepository<Film, Long> {

    Page<Film> findByTitleContaining(String title, Pageable pageable);
}
