package com.example.sbertest.service.impl;

import com.example.sbertest.model.T1;
import com.example.sbertest.repo.abstr.T1Dao;
import com.example.sbertest.service.abstr.SberServiceAbstract;
import com.example.sbertest.service.abstr.T1Service;
import org.springframework.stereotype.Service;

@Service
public class T1ServiceImpl extends SberServiceAbstract<T1, Long> implements T1Service {
    public T1ServiceImpl(T1Dao t1Dao) {
        super(t1Dao);
    }
}
