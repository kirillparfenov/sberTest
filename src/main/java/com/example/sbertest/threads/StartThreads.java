package com.example.sbertest.threads;

import com.example.sbertest.service.abstr.T1Service;
import com.example.sbertest.service.abstr.T2Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@AllArgsConstructor
public class StartThreads {

    private final T1Service t1Service;
    private final T2Service t2Service;

    public void startThreads() throws InterruptedException {
        Task task = new Task(t1Service, t2Service);

        ExecutorService threadA = Executors.newFixedThreadPool(1, r -> {
            Thread thread = Executors.defaultThreadFactory().newThread(r);
            thread.setName(ThreadNames.threadA.name());
            return thread;
        });

        ExecutorService threadB = Executors.newFixedThreadPool(1, r -> {
            Thread thread = Executors.defaultThreadFactory().newThread(r);
            thread.setName(ThreadNames.threadB.name());
            return thread;
        });


        while (t1Service.countRows() > 0) {
            threadA.execute(task);
            threadB.execute(task);
        }
    }
}
