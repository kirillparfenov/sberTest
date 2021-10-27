package com.example.sbertest.controller;

import com.example.sbertest.model.T1;
import com.example.sbertest.model.T2;
import com.example.sbertest.service.abstr.T1Service;
import com.example.sbertest.service.abstr.T2Service;
import com.example.sbertest.threads.StartThreads;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/*
Основной контроллер для работы с приложением
 */

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "api/sber/")
public class SberController {

    private final T1Service t1Service;
    private final T2Service t2Service;
    private final StartThreads startThreads;

    //Прочитать все записи из таблицы T1
    @GetMapping("/getAllFromTable1")
    public ResponseEntity<List<T1>> readAllFromT1() {
        log.info("Class: {}, readAllFromT1()", getClass());
        return ResponseEntity.ok(t1Service.getAll());
    }

    //Прочитать все записи из таблицы T2
    @GetMapping("/getAllFromTable2")
    public ResponseEntity<List<T2>> readAllFromT2() {
        log.info("Class: {}, readAllFromT2()", getClass());
        return ResponseEntity.ok(t2Service.getAll());
    }

    //Запуск 2х потоков
    @GetMapping("startThreads")
    public ResponseEntity<?> startThreads() throws  InterruptedException {
        log.info("Class: {}, startThreads()", getClass());
        startThreads.startThreads();
        return ResponseEntity.ok("Работа завершена");
    }
}
