package com.example.sbertest.repo.impl;

import com.example.sbertest.model.T2;
import com.example.sbertest.repo.abstr.SberRepoAbstract;
import com.example.sbertest.repo.abstr.T2Dao;
import org.springframework.stereotype.Repository;

@Repository
public class T2DaoImpl extends SberRepoAbstract<T2, Long> implements T2Dao {
}
