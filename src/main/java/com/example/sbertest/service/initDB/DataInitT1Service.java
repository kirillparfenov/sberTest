package com.example.sbertest.service.initDB;

import com.example.sbertest.model.T1;
import com.example.sbertest.model.Value;
import com.example.sbertest.service.abstr.T1Service;
import com.example.sbertest.utils.RandomGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 * DataInitT1Service - сервис, отвечающий за инициализацию таблицы T1 рандомными значениями
 */

@Service
@AllArgsConstructor
public class DataInitT1Service {
    private final T1Service t1Service;

    @Transactional
    public void initT1table() {
        for (int i = 0; i < 10; i++) {

            Value value = new Value();
            value.setThreadA(RandomGenerator.generateRandomBoolean());
            value.setThreadB(RandomGenerator.generateRandomBoolean());
            value.setQueue(new ArrayList<>());

            T1 entity = new T1();
            entity.setValue(value);

            t1Service.create(entity);
        }
    }
}
