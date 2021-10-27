package com.example.sbertest.threads;

import com.example.sbertest.model.T1;
import com.example.sbertest.model.T2;
import com.example.sbertest.model.Value;
import com.example.sbertest.service.abstr.T1Service;
import com.example.sbertest.service.abstr.T2Service;
import com.example.sbertest.utils.RandomGenerator;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
Задача, которую будут выполнять потоки
 */

@Slf4j
public class Task implements Runnable {

    private final T1Service t1Service;
    private final T2Service t2Service;

    public Task(T1Service t1Service, T2Service t2Service) {
        this.t1Service = t1Service;
        this.t2Service = t2Service;
    }

    @Override
    public void run() {
        synchronized (this) {
            Long randomId = RandomGenerator.generateRandomLong();
            String threadName = Thread.currentThread().getName();

            log.info("Running run() method in {}, Random ID: {}, CurrentThreadName: {}",
                    getClass(),
                    randomId,
                    threadName);

            if (t1Service.existById(randomId)) {

                T1 t1Entity = t1Service.getById(randomId).get();
                Value t1Value = t1Entity.getValue();

                log.info("T1 threadA: {}, T1 threadB: {}, T1 queue: {}, CurrentThreadName: {} ",
                        t1Value.isThreadA(),
                        t1Value.isThreadB(),
                        t1Value.getQueue(),
                        threadName);

                if (t1Value.isThreadA() && t1Value.isThreadB()) {

                    Value t2Value = Value.builder()
                            .threadA(t1Value.isThreadA())
                            .threadB(t1Value.isThreadB())
                            .queue(t1Value.getQueue())
                            .build();

                    T2 t2Entity = T2.builder().value(t2Value).build();

                    t2Service.create(t2Entity);
                    log.info("T2 inserted. T2 ID: {}, T2 threadA: {}, T2 threadB: {}, T2 queue: {}, CurrentThreadName: {} ",
                            t2Entity.getId(),
                            t2Value.isThreadA(),
                            t2Value.isThreadB(),
                            t2Value.getQueue(),
                            threadName);

                    t1Service.deleteById(t1Entity.getId());
                    log.info("T1 deleted. T1 ID: {}, T1 threadA: {}, T1 threadB: {}, T1 queue: {}, CurrentThreadName: {} ",
                            t1Entity.getId(),
                            t1Value.isThreadA(),
                            t1Value.isThreadB(),
                            t1Value.getQueue(),
                            threadName);

                } else {
                    List<String> t1Queue = t1Value.getQueue();
                    t1Queue.add(threadName);
                    t1Value.setQueue(t1Queue);

                    if (threadName.equals(ThreadNames.threadA.name())) {
                        t1Value.setThreadA(true);
                    } else if (threadName.equals(ThreadNames.threadB.name())) {
                        t1Value.setThreadB(true);
                    }

                    t1Service.update(t1Entity);

                    log.info("T1 was updated. T1 ID: {}, T1 threadA: {}, T1 threadB: {}, T1 queue: {}, CurrentThreadName: {} ",
                            t1Entity.getId(),
                            t1Value.isThreadA(),
                            t1Value.isThreadB(),
                            t1Value.getQueue(),
                            threadName);
                }
            }
        }
    }
}
