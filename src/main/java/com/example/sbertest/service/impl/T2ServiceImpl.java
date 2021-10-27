package com.example.sbertest.service.impl;

import com.example.sbertest.model.T2;
import com.example.sbertest.repo.abstr.T2Dao;
import com.example.sbertest.service.abstr.SberServiceAbstract;
import com.example.sbertest.service.abstr.T2Service;
import org.springframework.stereotype.Service;

@Service
public class T2ServiceImpl extends SberServiceAbstract<T2, Long> implements T2Service {
    public T2ServiceImpl(T2Dao t2Dao) {
        super(t2Dao);
    }
}
