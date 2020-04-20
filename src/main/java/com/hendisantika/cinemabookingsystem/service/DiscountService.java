package com.hendisantika.cinemabookingsystem.service;

import com.hendisantika.cinemabookingsystem.exception.ResourceNotFoundException;
import com.hendisantika.cinemabookingsystem.model.Discount;
import com.hendisantika.cinemabookingsystem.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : cinema-booking-system
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/04/20
 * Time: 05.51
 */
@Service
public class DiscountService {
    private final DiscountRepository discountRepository;

    @Autowired
    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public List<Discount> getAllDiscount() {
        return discountRepository.findAll();
    }

    public Discount getDiscountByID(Long id) {
        return discountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor " +
                "[cinemaId=" + id + "] can't be found"));
    }

    public void deleteDiscountByID(Long id) {
        if (getDiscountByID(id) != null) {
            discountRepository.deleteById(id);
        }
    }

    public void addDiscount(Discount discount) {
        discountRepository.saveAndFlush(discount);
    }
}
