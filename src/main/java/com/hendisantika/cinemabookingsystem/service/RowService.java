package com.hendisantika.cinemabookingsystem.service;

import com.hendisantika.cinemabookingsystem.model.Row;
import com.hendisantika.cinemabookingsystem.repository.RowRepository;
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
 * Time: 06.06
 */
@Service
public class RowService {
    private final RowRepository rowRepository;

    @Autowired
    public RowService(RowRepository rowRepository) {
        this.rowRepository = rowRepository;
    }

    public Row addRow(Row row) {
        return rowRepository.saveAndFlush(row);
    }

    public List<Row> getAllRow() {
        return rowRepository.findAll();
    }
}
