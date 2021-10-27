package com.example.sbertest.initializer;

import com.example.sbertest.service.initDB.InitDB;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DatabaseInitializer implements CommandLineRunner {

    private final InitDB initDB;

    @Override
    public void run(String... args) throws Exception {
        initDB.initDB();
    }
}
