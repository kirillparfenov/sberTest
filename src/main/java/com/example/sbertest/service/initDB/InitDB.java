package com.example.sbertest.service.initDB;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Заполнение БД тестовыми значениями
 */
@Service
@AllArgsConstructor
public class InitDB {

    private final DataInitT1Service t1Service;

    @Transactional
    public void initDB() {
        t1Service.initT1table();
    }
}
